package com.rummy.tests;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.actions.DefaultActionHandler;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.logic.common.deal.DealPlayingSTM;
import com.mango.games.rummy.logic.common.deal.DealShuffleCardsSTM;
import com.mango.games.rummy.logic.common.game.GameNotStartedSTM;
import com.mango.games.rummy.logic.common.game.GamePlayingSTM;
import com.mango.games.rummy.logic.common.game.GameWaitingToStartSTM;
import com.mango.games.rummy.logic.common.match.MatchPlayingSTM;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tests.concurrency.*;

@RunWith(ConcurrentJunitrunner.class)
@Concurrent(threads = 4)
public class FourPlayersGamePlay 
{

	@Test
	public void Test4PlayersBasic() throws InterruptedException 
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.joinPlayer(gameProxy, 3);
			Helper.joinPlayer(gameProxy, 4);
			Helper.assignSeat(gameProxy, 3, 1);
			Helper.assignSeat(gameProxy, 2, 2);
			Helper.assignSeat(gameProxy, 4, 3);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}

		IClientAdapter adapter = gameProxy.getClientAdapter();

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		Game game = (Game)adapter.getTarget();
		assertNotNull("Match is null", game.getMatch());
		
		/*IClientAdapter matchAdapter = adapter.getChildAdapter();
		assertNotNull("Match adapter is null", matchAdapter);
		assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
		*/
		assertNotNull("Deal is null", game.getMatch().getDeal());
		assertNotNull("Player size is null", game.getMatch().getDeal().getDealplayer());
		assertEquals("Number of players should be 4", 4, game.getMatch().getDeal().getDealplayer().size());
	}


	@Test
	public void TestSeatingConflict() throws InterruptedException 
	{
		GameProxy gameProxy = Helper.createGameProxy(2, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.joinPlayer(gameProxy, 3);
			Helper.joinPlayer(gameProxy, 4);
			Helper.assignSeat(gameProxy, 2, 0);
			Helper.assignSeat(gameProxy, 3, 1);
			Helper.assignSeat(gameProxy, 4, 1);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}

		IClientAdapter adapter = gameProxy.getClientAdapter();

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
	
		EList players = ((Game)adapter.getTarget()).getMatch().getDeal().getDealplayer();
		assertEquals("Number of players should be 2", 2, players.size());
		
		assertEquals("First player is id 1", ((DealPlayer)players.get(0)).getId(), 1);
		assertEquals("Second player is id 3", ((DealPlayer)players.get(1)).getId(), 3);
		
	}

	@Test
	public void TestSeatingConflictOneOccupied() throws InterruptedException 
	{
		GameProxy gameProxy = Helper.createGameProxy(3, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.joinPlayer(gameProxy, 2);
			Helper.joinPlayer(gameProxy, 3);
			Helper.joinPlayer(gameProxy, 4);
			Helper.assignSeat(gameProxy, 4, 1);
			Helper.assignSeat(gameProxy, 3, 1);
			Helper.assignSeat(gameProxy, 2, 1);
			Helper.assignSeat(gameProxy, 4, 1);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}

		IClientAdapter adapter = gameProxy.getClientAdapter();

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GameNotStartedSTM.class));
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GameNotStartedSTM.class));
		
		//assertEquals("Number of players should be 2", 2, ((Game)adapter.getTarget()).getMatch().getDeal().getDealplayer().size());
	}

	@Test
	public void TestManySpectators() throws InterruptedException 
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 2);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}

		IClientAdapter adapter = gameProxy.getClientAdapter();

		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		Game game = (Game)adapter.getTarget();
		
		try 
		{
			Helper.joinPlayer(gameProxy, 3);
			Helper.joinPlayer(gameProxy, 4);
			Helper.joinPlayer(gameProxy, 5);
			Helper.assignSeat(gameProxy, 3, 1);
			Helper.assignSeat(gameProxy, 2, 2);
			Helper.assignSeat(gameProxy, 4, 3);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}
		
		assertEquals("Number of players should be 2", 2, Helper.getNumPlayersInDeal(adapter));
		assertEquals("Number of players should be 4", Helper.getNumUsersInGame(adapter), 2);
		
	}

	
   
}
