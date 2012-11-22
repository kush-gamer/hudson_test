package com.rummy.tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.actions.DefaultActionHandler;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.RummyContainer;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.logic.common.deal.DealEndedSTM;
import com.mango.games.rummy.logic.common.deal.DealPlayingSTM;
import com.mango.games.rummy.logic.common.deal.DealShuffleCardsSTM;
import com.mango.games.rummy.logic.common.game.GameEndedSTM;
import com.mango.games.rummy.logic.common.game.GameNotStartedSTM;
import com.mango.games.rummy.logic.common.game.GamePlayingSTM;
import com.mango.games.rummy.logic.common.game.GameWaitingToStartSTM;
import com.mango.games.rummy.logic.common.match.MatchEndingSTM;
import com.mango.games.rummy.logic.common.match.MatchNewDealSTM;
import com.mango.games.rummy.logic.common.match.MatchPlayingSTM;
import com.mango.games.rummy.logic.common.match.MatchScore4DealSTM;

import com.mango.games.rummy.logic.common.match.MatchTossSTM;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;
import com.tests.concurrency.Concurrent;
import com.tests.concurrency.ConcurrentJunitrunner;

@RunWith(ConcurrentJunitrunner.class)
@Concurrent(threads = 4)
public class MultiPlayerJoinsLeaves {

	private GameProxy createGameProxy(int id, int maxSeats, double prizePool,
			int gtype) {

		Injector injector;
		injector = Guice.createInjector(new InjectionModule());

		GameProxy gameProxy = null;

		gameProxy = injector.getInstance(GameProxy.class);
		gameProxy.createNewGame(id, maxSeats, prizePool, gtype);
		gameProxy.getClientAdapter().setServerResponseManager(
				mock(ServerResponseManager.class));

		return gameProxy;
	}

	@Test
	public void testTakeSeatAfterGameStart() throws InterruptedException {
		GameProxy gameProxy = createGameProxy(1, 5, 121, 1);
		gameProxy.getClientAdapter().setServerResponseManager(
				mock(ServerResponseManager.class));
		RummyContainer rummyContainer = new RummyContainer();
		RummyContainer.init();
		gameProxy.getClientAdapter().setEventHandlerMap(rummyContainer.eventHandlerMap);
		try {
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}
		IClientAdapter adapter = gameProxy.getClientAdapter();
		assertTrue(Helper.validateCurrentState(adapter, GameWaitingToStartSTM.class));

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		assertTrue(Helper.getCurrentState(adapter),
				Helper.validateCurrentState(adapter, GamePlayingSTM.class));

		try {
			Helper.joinPlayer(gameProxy, 3);
			int event = Helper.assignSeat(gameProxy, 3, 2);
			assert (event == 0);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}

		Game game = (Game) adapter.getTarget();

		Match match = game.getMatch();
		assert (match.getMatchplayer().size() == 2);
	}

	@Test
	public void testJoinsBeforeGameStart() throws InterruptedException {
		
		GameProxy      gameProxy = Helper.createGameProxy(2, 5, 121, 101);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try {
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 2);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}
		
		Game game = (Game) adapter.getTarget();

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN / 2);
		
		try {
			Helper.joinPlayer(gameProxy, 3);
			Helper.assignSeat(gameProxy, 3, 4);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}
		
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GameWaitingToStartSTM.class));
		
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 10);
		
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
		
		Match match = game.getMatch();
		Deal deal = match.getDeal();
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 10);
		
		IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
	    IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);
		
		assertEquals(match.getMatchplayer().size(), 3);
		assertEquals(deal.getDealplayer().size(), 3);
		
		assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));

	}

	@Test
	public void testLeaveGame() throws InterruptedException {
		/* Create Game */
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try {
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}		

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 10);
		
		assertTrue(Helper.getCurrentState(adapter),
				Helper.validateCurrentState(adapter, GamePlayingSTM.class));
		
		
		
		Game game = (Game) adapter.getTarget();
		Match match = game.getMatch();
		
		IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
		assertTrue(Helper.getCurrentState(matchAdapter),
				Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 10);
		
	
		Deal deal = match.getDeal();
		
		assertNotNull(deal);		
		IClientAdapter dealAdapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
		
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));

		try {
			int event = leaveSeat(gameProxy, 1, 0);
			assertEquals(1, event);
			System.out.println("Leaving");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage(), e == null);
		}			


		assertTrue(Helper.getCurrentState(dealAdapter),
				Helper.validateCurrentState(dealAdapter, DealEndedSTM.class));
		
		assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchEndingSTM.class));
	    Thread.sleep(TimeoutConstants.MATCH_ENDING + 100);
	    assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GameEndedSTM.class));

		match = game.getMatch();
		assertNull(match);

	}

//	private String getCurrentState(IClientAdapter adapter) {
//		DefaultActionHandler stm = (DefaultActionHandler) adapter
//				.getStateChanger().getCurrent();
//
//		return stm.getClass().toString();
//
//	}

//	private boolean validateCurrentState(IClientAdapter adapter, Class b) {
//		boolean bRet = true;
//
//		DefaultActionHandler stm = (DefaultActionHandler) adapter
//				.getStateChanger().getCurrent();
//
//		bRet = stm.getClass().isAssignableFrom(b);
//		return bRet;
//	}

//	private int joinPlayer(GameProxy gameProxy, long playerID) throws Exception {
//		int eventHandled = 0;
//		// Send a JoinMe message to the GameAdapter, and check its flow.
//		ISFSObject sfsObject = Helper.createSFSObject();
//		sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gjoinme");
//		sfsObject.putLong("playerid", playerID);
//
//		IClientAdapter adapter = gameProxy.getClientAdapter();
//
//		eventHandled = adapter.handleEvent(sfsObject);
//
//		return eventHandled;
//
//	}
//
//	private int assignSeat(GameProxy gameProxy, long playerID, int seatID) {
//		ISFSObject sfsObject = Helper.createSFSObject();
//		sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID,
//				"gseataken");
//		sfsObject.putLong("playerid", playerID);
//		sfsObject.putLong("seatid", seatID);
//
//		int eventHandled = 0;
//		IClientAdapter adapter = gameProxy.getClientAdapter();
//		try {
//			eventHandled = adapter.handleEvent(sfsObject);
//		} catch (Exception e) {
//			assertTrue(e.getMessage(), e == null);
//		}
//		return eventHandled;
//		// assertTrue(eventHandled == 1);
//	}

	private int leaveSeat(GameProxy gameProxy, long playerID, int seatID) {
		ISFSObject sfsObject = Helper.createSFSObject();
		sfsObject
				.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gtolobby");
		sfsObject.putLong("playerid", playerID);
		sfsObject.putLong("seatid", seatID);

		int eventHandled = 0;
		IClientAdapter adapter = gameProxy.getClientAdapter();
		try {
			eventHandled = adapter.handleEvent(sfsObject);
		} catch (Exception e) {
			assertTrue(e.getMessage(), e == null);
		}
		return eventHandled;
		// assertTrue(eventHandled == 1);

	}

}
