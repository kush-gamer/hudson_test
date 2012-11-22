package com.rummy.tests;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

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
public class TwoPlayersGameStarts 
{
	
	@Test
	public void testTakeSeat2Player() throws InterruptedException 
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
		}
		catch(Exception e) {}

		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		assertTrue(Helper.validateCurrentState(adapter, GameNotStartedSTM.class));
		
		try{
			
			Helper.assignSeat(gameProxy, 2, 1);
		}
		catch(Exception e){
			
			assertTrue(e.getMessage(), e == null);
		}
		
		
		Game game = (Game)adapter.getTarget();
		
		Seat seat = (Seat)game.getSeat().get(0);
		assertTrue(seat.getPlayer() != null);
		
		seat = (Seat)game.getSeat().get(1);
		assertTrue(seat.getPlayer() != null);
		
		assertTrue(Helper.validateCurrentState(adapter, GameWaitingToStartSTM.class));
		
		/**
		 * NOTE: To check if the timeout is working set a breakpoint at the previous line and'
		 * wait for 10 seconds. check the stdout and then resume.
		 */
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
	    
		assertEquals("Number of players should be 2", 2, Helper.getNumPlayersInDeal(adapter));
		assertEquals("Number of players should be 2", 2, Helper.getNumUsersInGame(adapter));
	}

	@Test
	public void testMatchCreated() throws InterruptedException 
	{
		int       playerId = 1;
		int       seatId = 1;
		
		GameProxy gameProxy = Helper.createGameProxy(2, 5, 121, 1);
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		Game game = (Game)adapter.getTarget();

		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
		}
		catch(Exception e) 
		{
			assertTrue(e.getMessage(), e == null);
		}
		
		
		assertNull(game.getMatch());
	    //Wait for game to enter game playing STM
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
		
		Match match = game.getMatch();
		assertNotNull("Match is null", match);
		
		IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
		assertNotNull("MatchAdapter is Null", matchAdapter);
		
		Deal deal = match.getDeal();
		assertNotNull("Deal is not created", deal);
		IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);
		assertNotNull("DealAdapter is Null", dealAdapter);
		
		assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealShuffleCardsSTM.class));
		
		
		//Now wait for timeout seconds
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 50);
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));
		
		assertEquals("Number of players should be 2", 2, Helper.getNumPlayersInDeal(adapter));
		assertEquals("Number of players should be 2", 2, Helper.getNumUsersInGame(adapter));
		
	}
    
   
}
