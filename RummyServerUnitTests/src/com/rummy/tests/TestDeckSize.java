package com.rummy.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.Deal;


public class TestDeckSize {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test2Players() throws InterruptedException
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
		//Sleep for Game start countdown to elapse
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//Sleep for shuffle animation time to elapse
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		//Ensure deal is in playable state, with two players
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		//Check open and close decks in Deal
		Deal deal = Helper.getDeal(adapter);
		ClosedDeck cDeck = (ClosedDeck) deal.getCloseddeck();
		
		assertEquals("ClosedDeck should have 24 cards", cDeck.getCard().size(), 24);
	}
	
	@Test
	public void test3Players() throws InterruptedException
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 2);
			Helper.joinPlayer(gameProxy, 3);
			Helper.assignSeat(gameProxy, 3, 3);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}
		//Sleep for Game start countdown to elapse
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//Sleep for shuffle animation time to elapse
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		//Ensure deal is in playable state, with two players
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		//Check open and close decks in Deal
		Deal deal = Helper.getDeal(adapter);
		ClosedDeck cDeck = (ClosedDeck) deal.getCloseddeck();
		
		assertEquals("ClosedDeck should have 63 cards", 63, cDeck.getCard().size());
	}

	@Test
	public void test4Players() throws InterruptedException
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
			Helper.joinPlayer(gameProxy, 3);
			Helper.assignSeat(gameProxy, 3, 2);
			Helper.joinPlayer(gameProxy, 4);
			Helper.assignSeat(gameProxy, 4, 4);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}
		//Sleep for Game start countdown to elapse
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//Sleep for shuffle animation time to elapse
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		//Ensure deal is in playable state, with two players
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		//Check open and close decks in Deal
		Deal deal = Helper.getDeal(adapter);
		ClosedDeck cDeck = (ClosedDeck) deal.getCloseddeck();
		
		assertEquals("ClosedDeck should have 50 cards", 50, cDeck.getCard().size());
	}
	
	@Test
	public void test5Players() throws InterruptedException
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
			Helper.joinPlayer(gameProxy, 3);
			Helper.assignSeat(gameProxy, 3, 2);
			Helper.joinPlayer(gameProxy, 4);
			Helper.assignSeat(gameProxy, 4, 4);
			Helper.joinPlayer(gameProxy, 5);
			Helper.assignSeat(gameProxy, 5, 3);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}
		//Sleep for Game start countdown to elapse
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		//Sleep for shuffle animation time to elapse
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		//Ensure deal is in playable state, with two players
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		//Check open and close decks in Deal
		Deal deal = Helper.getDeal(adapter);
		ClosedDeck cDeck = (ClosedDeck) deal.getCloseddeck();
		
		assertEquals("ClosedDeck should have 89 cards", 89, cDeck.getCard().size());
	}
}
