package com.rummy.tests;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Seat;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Joker;
import com.rummy.tests.base.GamePlayTests;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;
import com.tests.concurrency.Concurrent;
import com.tests.concurrency.ConcurrentJunitrunner;

public class TestGamePlay2Players extends GamePlayTests{

	public static long PLAYER_1 = 1;
	public static long PLAYER_2 = 2;
	public static long PLAYER_3 = 3;
	public static long PLAYER_4 = 4;
	public static long PLAYER_5 = 5;
	public static long PLAYER_6 = 6;
	
	public static long GAME_1 = 1;
	public static long GAME_2 = 2;
	public static long GAME_3 = 3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}
	
	@Test
	public void testCardsDistributed() throws InterruptedException
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, 1);
			Helper.assignSeat(gameProxy, 1, 0);
			Helper.joinPlayer(gameProxy, 2);
			Helper.assignSeat(gameProxy, 2, 1);
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
		assertEquals("Number of players should be 2", 2, Helper.getNumPlayersInDeal(adapter));
		
		//Check open and close decks in Deal
		Deal deal = Helper.getDeal(adapter);
		
		ClosedDeck cDeck = (ClosedDeck) deal.getCloseddeck();
		
		assertEquals("ClosedDeck should have 24 cards", cDeck.getCard().size(), 24);
		
		OpenDeck openDeck = (OpenDeck) deal.getOpendeck();
		assertEquals("Opendeck should have 1 card", openDeck.getCard().size(), 1);
		
		assertNotNull("Joker must have 1 card", deal.getJoker());
		
		DealPlayer plyr0 = (DealPlayer)deal.getDealplayer().get(0);
		DealPlayer plyr1 = (DealPlayer)deal.getDealplayer().get(1);
		
		//Get player0's hand cards which are in one group.
		GroupCards grpCards = (GroupCards)plyr0.getHandcards().getGroups().get(0);
		assertEquals("Player 1 should have 13 hand cards",grpCards.getCard().size(), 13);
		
		//Get player1's hand cards which are in one group.
		GroupCards grpCards1 = (GroupCards)plyr1.getHandcards().getGroups().get(0);
		assertEquals("Player 1 should have 13 hand cards",grpCards1.getCard().size(), 13);
		
		//Check if the player have hand cards - 13
		Seat seat0 = Helper.getSeat(adapter, 0);
		Seat seat2 = Helper.getSeat(adapter, 2);
		
		assertNotNull(seat0.getPlayer());
		assertNotNull(seat2.getPlayer());
		
	}
	
	@Test
	public void TestAutoPickCard() throws InterruptedException
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
		
		//Sleep for 10 seconds and check the opendeck size to be 2, as 1 card should be discarded
		Thread.sleep(TimeoutConstants.TURN_TIME_OUT + 1000);
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		assertEquals("ClosedDeck should have 23 cards", Helper.getClosedDeckSize(adapter), 23);
		System.out.println("Open Deck Size is:" + Helper.getOpenDeckSize(adapter));
		assertEquals("Opendeck should have 2 cards", Helper.getOpenDeckSize(adapter), 2);
		
		
		//Sleep another 10 seconds and check the deck size
		Thread.sleep(TimeoutConstants.TURN_TIME_OUT + 1000);
		assertEquals("ClosedDeck should have 23 cards", Helper.getClosedDeckSize(adapter), 22);
		assertEquals("Opendeck should have 3 cards", Helper.getOpenDeckSize(adapter), 3);
		
		//Sleep another 10 seconds and check the deck size
		Thread.sleep(TimeoutConstants.TURN_TIME_OUT + 1000);
		assertEquals("ClosedDeck should have 23 cards", Helper.getClosedDeckSize(adapter), 21);
		assertEquals("Opendeck should have 4 cards", Helper.getOpenDeckSize(adapter), 4);
		
		/**
		 * Not sleep for long time and observe the deal going through ticking motions
		 */
		Thread.sleep(50000);
	}
	
	@Test
	public void TestManualPickCard() throws InterruptedException, Exception
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
		
		//Wait for half the timeout-time and orchestrate a pick/discard
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN/2);
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		int handled = Helper.pickACard(adapter, 1);
		assertEquals("PickCard should be handled ", 1, handled);
		
		assertEquals("ClosedDeck should have 23 cards", Helper.getClosedDeckSize(adapter), 23);
		
	    Card discCard = (Card)Helper.getHandCards(1, adapter).get(11);
		handled = Helper.discardACard(adapter, 1, discCard);
		assertEquals("Discard Card should be handled ", 1, handled);
		
		assertEquals("Opendeck should have 2 cards", Helper.getOpenDeckSize(adapter), 2);
		
		//Wait for half the timeout-time and orchestrate a pick/discard
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN/2);
		
		//Now repeat pick and discard for the second player
		handled = Helper.pickACard(adapter, 2);
		assertEquals("PickCard should be handled ", 1, handled);
		
		assertEquals("ClosedDeck should have 22 cards", Helper.getClosedDeckSize(adapter), 22);
		
	    discCard = (Card)Helper.getHandCards(2, adapter).get(6);
		handled = Helper.discardACard(adapter, 2, discCard);
		assertEquals("Discard Card should be handled ", 1, handled);
		
		assertEquals("Opendeck should have 2 cards", Helper.getOpenDeckSize(adapter), 3);
		
		
		Thread.sleep(10000);
		
	}
	
	@Test
	public void TestPickDiscardWrongTurns() throws InterruptedException, Exception
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
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
		
		//Wait for half the timeout-time and orchestrate a pick/discard
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN/2);
		
		/**
		 * Wrong-guy( PLAYER_2) picks a card
		 */
		IClientAdapter adapter = gameProxy.getClientAdapter();
		int handled = Helper.pickACard(adapter, PLAYER_2);
		assertEquals("PickCard should not be handled ", 1, handled);
		
		assertEquals("ClosedDeck should have 24 cards", Helper.getClosedDeckSize(adapter), 24);
		assertEquals("Number of cards in hand should remain 13", Helper.getHandCards(PLAYER_2, adapter).size(), 13);
		
		/**
		 * Right player picks the card
		 */
		handled = Helper.pickACard(adapter, PLAYER_1);
		assertEquals("PickCard should  be handled ", 1, handled);
		
		assertEquals("ClosedDeck should have 23 cards", Helper.getClosedDeckSize(adapter), 23);
		assertEquals("Number of cards in hand should be 14", Helper.getHandCards(PLAYER_1, adapter).size(), 14);
		
		/**
		 *Wrong guy discards a card
		 */
		   Card discCard = (Card)Helper.getHandCards(PLAYER_2, adapter).get(11);
		   handled = Helper.discardACard(adapter, PLAYER_2, discCard);
		   assertEquals("Discard Card should be handled ", 1, handled);
		 
		   assertEquals("Opendeck should have 1 card", Helper.getOpenDeckSize(adapter), 1);
		   assertEquals("Number of cards in hand should rmain 13", Helper.getHandCards(PLAYER_2, adapter).size(), 13);
		   
		/**
		 * Right player (PLAYER_1) discards the card
		 */
	    discCard = (Card)Helper.getHandCards(PLAYER_1, adapter).get(11);
		handled = Helper.discardACard(adapter, PLAYER_1, discCard);
		assertEquals("Discard Card should be handled ", 1, handled);
		
		assertEquals("Opendeck should have 2 cards", Helper.getOpenDeckSize(adapter), 2);
		assertEquals("Number of cards in hand should be 13", Helper.getHandCards(PLAYER_1, adapter).size(), 13);
		
		//Wait for half the timeout-time and orchestrate a pick/discard
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN/2);
		
		//Now repeat pick and discard for the second player
		handled = Helper.pickACard(adapter, 2);
		assertEquals("PickCard should be handled ", 1, handled);
		
		assertEquals("ClosedDeck should have 22 cards", Helper.getClosedDeckSize(adapter), 22);
		
	    discCard = (Card)Helper.getHandCards(2, adapter).get(6);
		handled = Helper.discardACard(adapter, 2, discCard);
		assertEquals("Discard Card should be handled ", 1, handled);
		
		assertEquals("Opendeck should have 3 cards", Helper.getOpenDeckSize(adapter), 3);
		
		
		Thread.sleep(10000);
	}

    @Test
    public void TestPickDiscard20Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(23);
    }
	
    @Test
    public void TestPickDiscard6Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(6);
    }
    
    @Test
    public void TestPickDiscard10Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(10);
    }
    
    @Test
    public void TestPickDiscard8Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(8);
    }
    
    @Test
    public void TestPickDiscard7Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(7);
    }
    
    @Test
    public void TestPickDiscard2Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(2);
    }
    
    
    @Test
    public void TestPickDiscard15Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(15);
    }
    
    @Test
    public void TestPickDiscard5Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(5);
    }
    
    @Test
    public void TestPickDiscard12Times() throws InterruptedException, Exception
    {
    	TestPickDiscard_2Players(12);
    }
    
	private void TestPickDiscard_2Players(int nTimes) throws InterruptedException, Exception
	{
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
		}
		catch(Exception e) {}
		
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		//Now orchestrate turns for player 1 and 2, some 50 times.
		for(int i=0; i<nTimes; i++ )
		{
			System.out.println("Pick and Discard iteration number - " + i);
			//Pick for player 1
			pickACard(adapter, PLAYER_1);
			
			discACard(adapter, PLAYER_1);
			
			pickACard(adapter, PLAYER_2);
			
			discACard(adapter, PLAYER_2);
		}

	}
	
	

}
