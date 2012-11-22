/**
 * 
 */
package com.rummy.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.MatchAdapter;
import com.mango.games.rummy.logic.common.deal.DealEndedSTM;
import com.mango.games.rummy.logic.common.deal.DealPlayingSTM;
import com.mango.games.rummy.logic.common.game.GameEndedSTM;
import com.mango.games.rummy.logic.common.game.GamePlayingSTM;
import com.mango.games.rummy.logic.common.match.MatchEndingSTM;
import com.mango.games.rummy.logic.common.match.MatchPlayingSTM;
import com.mango.games.rummy.logic.common.match.MatchScore4DealSTM;
import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.Score;
import com.rummy.tests.base.GamePlayTests;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

/**
 * @author Sanjeev
 *
 */

@RunWith(Parameterized.class)
public class TestDropsDeclarations extends GamePlayTests
{
	public static long PLAYER_1 = 1;
	public static long PLAYER_2 = 2;
	public static long PLAYER_3 = 3;
	public static long PLAYER_4 = 4;
	public static long PLAYER_5 = 5;
	public static long PLAYER_6 = 6;
	
	public static long GAME_1 = 1;
	public static long GAME_2 = 2;
	public static long GAME_3 = 3;
	
	public int[][] PLAYER_1_CARDS;
	public int[][] PLAYER_2_CARDS;
	public int[][] PLAYER_3_CARDS;
	
	public int PLAYER_1_SCORE;
	public int PLAYER_2_SCORE;
	public int PLAYER_3_SCORE;
	
	public long winID;
	
	public TestDropsDeclarations(int player1score, int player2score, int player3score, 
			int winid, int[][] player1groups, int[][] player2groups, int[][] player3groups) {
		this.PLAYER_1_SCORE = player1score;
		this.PLAYER_2_SCORE = player2score;
		this.PLAYER_3_SCORE = player3score;
		this.winID = winid;
		this.PLAYER_1_CARDS = player1groups;
		this.PLAYER_2_CARDS = player2groups;
		this.PLAYER_3_CARDS = player3groups;		
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] {
				{0,53,55,1,new int[][] {{0,1,2,3,4,5,6},{7,8,9,10,11,12}}, new int[][] {{0,1,2},{3,4,5,6},{8,8,10,11,7,6}}, new int[][] {{0,1,2},{3,4,5,6},{8,9,11,11,10,5}}}
		});
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
	}
	
	@Test
	public void testFirstDrop2Players() throws InterruptedException, Exception
	{
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 101);
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
		
		pickACard(adapter, PLAYER_1);
			
	    dropFromDeal(adapter, PLAYER_2);
	    
	    Thread.sleep(50000);
	    
	    Game game = (Game) adapter.getTarget();
	    Match match = game.getMatch();
	    Deal deal = match.getDeal();
	    
		DealPlayer dplayer1 = deal.getPlayerById(PLAYER_1);
		DealPlayer dplayer2 = deal.getPlayerById(PLAYER_2);
		
		assert(true == dplayer2.isDropped());
		assert(dplayer1.isSetWinner() == true);
		
		Score score = dplayer1.getScore();
		assert(score.getScore() == 121);
		assert(dplayer2.getScore().getScore() == 0);    

	}
	
	@Test
	public void testDropAndStates2Players() throws InterruptedException, Exception
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
		}
		catch(Exception e) 
		{
			
		}
		
		Game game = (Game) adapter.getTarget();
	    
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		Match match = game.getMatch();
	    Deal deal = match.getDeal();
	    
	    IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
	    IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);
		
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));

		
		playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_1);
		
		dropFromDeal(adapter, PLAYER_2);
	    
		checkDealEndMatchScoreState(matchAdapter, dealAdapter);

		checkDropped(deal, PLAYER_2);
		checkWinner(deal, PLAYER_1);
		
//		checkPlayerScore(deal, PLAYER_1, 40);
//		checkPlayerScore(deal, PLAYER_2, 0);
		
	    assert(null == deal);
	    
	    Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 20);
	    
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
	    	    
	    deal = match.getDeal();
	    
//	    checkPlayerScore(deal, PLAYER_1, 40);
//		checkPlayerScore(deal, PLAYER_2, 0);
				
	}
	
	@Test
	public void testGameCloseAfterMultipleRounds() throws InterruptedException, Exception 
	{
		/* Create Game */
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
		}
		catch(Exception e)
		{
			
		}
		
		Game game = (Game) adapter.getTarget();
	    
		
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		Match match = game.getMatch();
	    Deal deal = match.getDeal();
	    
	    IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
	    IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);
		
//		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));

		/* 
		 * Begin First Round 
		 */
	    System.out.println("Round 1");
		playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_1);
		
		dropFromDeal(adapter, PLAYER_2);
	    
		checkDealEndMatchScoreState(matchAdapter, dealAdapter);

		checkDropped(deal, PLAYER_2);
		checkWinner(deal, PLAYER_1);
		
		checkPlayerScore(match, PLAYER_1, 0, 0);
		checkPlayerScore(match, PLAYER_2, 40, 0);
		
		Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 20);
	    
		Deal deal1 = match.getDeal();
		IClientAdapter dealAdapter1 = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal1, deal1);
		
		assertNotSame(deal1, deal);
		assertNotSame(dealAdapter, dealAdapter1);
	    
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
	    
	    Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);	    
	    	    
	    assertTrue(Helper.getCurrentState(dealAdapter1), Helper.validateCurrentState(dealAdapter1, DealPlayingSTM.class));
	    

		/*
		 * Second Round
		 */
	    System.out.println("Round 2");
	    match = game.getMatch();
	    
	    playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_1);
		
		dropFromDeal(adapter, PLAYER_2);
	    
		checkDealEndMatchScoreState(matchAdapter, dealAdapter);

		checkDropped(deal1, PLAYER_2);
		checkWinner(deal1, PLAYER_1);
		
		checkPlayerScore(match, PLAYER_1, 0, 1);
		checkPlayerScore(match, PLAYER_2, 40, 1);
		
		Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 20);
	    
		Deal deal2 = match.getDeal();
		IClientAdapter dealAdapter2 = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal2, deal2);
		
		assertNotSame(deal1, deal2);
		assertNotSame(dealAdapter1, dealAdapter2);

	    
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
	    
	    Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);	    
	    	    
	    assertTrue(Helper.getCurrentState(dealAdapter2), Helper.validateCurrentState(dealAdapter2, DealPlayingSTM.class));

		/*
		 * Third Round, Winner Declare
		 */
	    System.out.println("Round 3");
	    playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_1);
		
		dropFromDeal(adapter, PLAYER_2);
	    
//		checkDealEndMatchScoreState(matchAdapter, dealAdapter);
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealEndedSTM.class));
//		DealPlayer dealPlayer = deal2.gePlayerById(PLAYER_2);
//		assertEquals(dealPlayer.getState(), DealPlayer.LOST_GAME);
//
//		checkDropped(deal2, PLAYER_2);
//		checkWinner(deal2, PLAYER_1);
		
		checkPlayerScore(match, PLAYER_1, 0, 2);
		checkPlayerScore(match, PLAYER_2, 40, 2);
		
//		Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 20);
//	    
//		Deal deal3 = match.getDeal();
//		IClientAdapter dealAdapter3 = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal3, deal3);
//		
//		assertNotSame(deal2, deal3);
//		assertNotSame(dealAdapter3, dealAdapter3);

	    
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchEndingSTM.class));
	    System.out.println("Match is ending: Inside Test");
	    Thread.sleep(TimeoutConstants.MATCH_ENDING + 100);
	    assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GameEndedSTM.class));
	    
//	    Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);	    
//	    	    
//	    assertTrue(Helper.getCurrentState(dealAdapter2), Helper.validateCurrentState(dealAdapter2, DealPlayingSTM.class));

	}
	
	@Test
	public void testThreePlayerDrop() throws InterruptedException, Exception {
		/* Create Game */
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
			Helper.joinPlayer(gameProxy, PLAYER_3);
			Helper.assignSeat(gameProxy, PLAYER_3, 4);
			
		}
		catch(Exception e) {}
		
		Game game = (Game) adapter.getTarget();	    
		
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		
		Match match = game.getMatch();
	    
	    IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
	    
	    assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
	    
	    Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 40);
	    
	    Deal deal = match.getDeal();
	    IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);
	    
	   // assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));
	    
		System.out.println("Current State 1" + Helper.getCurrentState(dealAdapter));

	    /* Play One Round */
	    playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_3);

		dropFromDeal(adapter, PLAYER_3);

		
		if(deal == null)
		{
			System.out.println("Deal object is NULL");
		}
		
		System.out.println("Current State " + Helper.getCurrentState(dealAdapter));
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));
		
		playOneRound(adapter, PLAYER_1);
		dropFromDeal(adapter, PLAYER_2);
		
		System.out.println("Current State " + Helper.getCurrentState(dealAdapter));
		
		checkWinner(deal, PLAYER_1);
	}
	
	@Test
	public void testScore() throws InterruptedException, Exception 
	{
		/* Create Game */
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
		}
		catch(Exception e) {}
		
		Game game = (Game) adapter.getTarget();
	    
		
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		/* Begin First Round */
	    completeADeal(PLAYER_1, game);
		checkPlayerScore(game.getMatch(), PLAYER_1, 0, 0);
		checkPlayerScore(game.getMatch(), PLAYER_2, 80, 0);
	    
	    Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 30);
		
	    Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
	    
		System.out.println("**********************NEW DEAL******************");
		
		System.out.println(" PLAYER_1 cards size" + Helper.getHandCards(PLAYER_1, adapter).size());
		System.out.println(" PLAYER_2 cards size" + Helper.getHandCards(PLAYER_2, adapter).size());
	    completeADeal(PLAYER_2, game);
		checkPlayerScore(game.getMatch(), PLAYER_1, 80, 1);
		checkPlayerScore(game.getMatch(), PLAYER_2, 0, 1);
		
	    Thread.sleep(TimeoutConstants.SHOWING_SCORECARD + 30);
		
	    Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		System.out.println("**********************FINAL DEAL********************");
		
		System.out.println(" PLAYER_1 cards size" + Helper.getHandCards(PLAYER_1, adapter).size());
		System.out.println(" PLAYER_2 cards size" + Helper.getHandCards(PLAYER_2, adapter).size());
	    completeADeal(PLAYER_2, game);
		checkPlayerScore(game.getMatch(), PLAYER_1, 80, 1);
		checkPlayerScore(game.getMatch(), PLAYER_2, 0, 1);
		checkPlayerTotalScore(game.getMatch(), PLAYER_1, 160);
	}
	
	@Test
	public void testThreePlayerScore() throws InterruptedException, Exception {
		/* Create Game */
		
		GameProxy      gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter   = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
			Helper.joinPlayer(gameProxy, PLAYER_2);
			Helper.assignSeat(gameProxy, PLAYER_2, 2);
			int event = Helper.joinPlayer(gameProxy, PLAYER_3);
			assertEquals(event, 1);
			event = Helper.assignSeat(gameProxy, PLAYER_3, 4);
			assertEquals(event, 1);
		}
		catch(Exception e) {}
		
		Game game = (Game) adapter.getTarget();
		
		
		//Sleep for Game to start
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 20);
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 20);
		
		Match match = game.getMatch();
		Deal deal = match.getDeal();
		
		DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
		
		/* Begin, Play One Round */
		playOneRound(adapter, PLAYER_1);
		playOneRound(adapter, PLAYER_2);
		playOneRound(adapter, PLAYER_3);
		
		if(this.winID == PLAYER_1) {
			pickACard(adapter, PLAYER_1);
			Card dicardCard = getCardToDiscard(PLAYER_1, deal);
			changePlayerCards(PLAYER_1, this.PLAYER_1_CARDS, game);
			changePlayerCards(PLAYER_2, this.PLAYER_2_CARDS, game);
			changePlayerCards(PLAYER_3, this.PLAYER_3_CARDS, game);
			Thread.sleep(8000);
			showInit(dealAdapter, PLAYER_1);
			Thread.sleep(3000); // wait for 3 seconds		
			declareCards(dealAdapter, PLAYER_1, dicardCard);
			Thread.sleep(8000); 			
			declareCards(dealAdapter, PLAYER_2, null);
			declareCards(dealAdapter, PLAYER_3, null);
			
		} else if (this.winID == PLAYER_2) {
			playOneRound(adapter, PLAYER_1);
			pickACard(adapter, PLAYER_2);
			Card dicardCard = getCardToDiscard(PLAYER_2, deal);
			changePlayerCards(PLAYER_1, this.PLAYER_1_CARDS, game);
			changePlayerCards(PLAYER_2, this.PLAYER_2_CARDS, game);
			changePlayerCards(PLAYER_3, this.PLAYER_3_CARDS, game);
			Thread.sleep(8000);
			showInit(dealAdapter, PLAYER_2);
			Thread.sleep(3000); // wait for 3 seconds		
			declareCards(dealAdapter, PLAYER_2, dicardCard);
			Thread.sleep(8000); 			
			declareCards(dealAdapter, PLAYER_1, null);
			declareCards(dealAdapter, PLAYER_3, null);
						
		} else if (this.winID == PLAYER_3) {
			playOneRound(adapter, PLAYER_1);
			playOneRound(adapter, PLAYER_2);
			pickACard(adapter, PLAYER_3);
			Card dicardCard = getCardToDiscard(PLAYER_3, deal);
			changePlayerCards(PLAYER_1, this.PLAYER_1_CARDS, game);
			changePlayerCards(PLAYER_2, this.PLAYER_2_CARDS, game);
			changePlayerCards(PLAYER_3, this.PLAYER_3_CARDS, game);
			Thread.sleep(8000);
			showInit(dealAdapter, PLAYER_3);
			Thread.sleep(3000); // wait for 3 seconds		
			declareCards(dealAdapter, PLAYER_3, dicardCard);
			Thread.sleep(8000); 			
			declareCards(dealAdapter, PLAYER_1, null);
			declareCards(dealAdapter, PLAYER_2, null);
						
		}
		
		checkWinner(deal, winID);
		checkPlayerScore(match, PLAYER_1, PLAYER_1_SCORE, 0);
		checkPlayerScore(match, PLAYER_2, PLAYER_2_SCORE, 0);
		checkPlayerScore(match, PLAYER_3, PLAYER_3_SCORE, 0);

	}
	
	private void changePlayerCards(long playerID, int[][] cards, Game game) throws Exception {
		Match match = game.getMatch();
		Deal deal = match.getDeal();
		DealPlayer dplayer = deal.getPlayerById(playerID);
		DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
		
		HandCards handCards = dplayer.getHandcards();
		CardContainer group = handCards.getGroupByIndex(0);
		
		EList<EObject> hcards = group.getCard();
		HandCards newHandCards = (HandCards) dealAdapter.getModelFactory().createObject(HandCards.class);
		
		EList<EObject> groups = newHandCards.getGroups();
		
		for(int i = 0; i < cards.length; i++) {
			System.out.println("Changing cards for: " + playerID);
			CardContainer group1 = (CardContainer) dealAdapter.getModelFactory().createObject(GroupCards.class);
			EList<EObject> group1Cards = group1.getCard();
			for(int k = 0; k < cards[i].length; k++) {
				Card c = (Card) dealAdapter.getModelFactory().createObject(Card.class);
				c.setRank(cards[i][k]);
				System.out.println(cards[i][k]);
				c.setSuit(1);
				group1Cards.add(c);
			}
			
			groups.add(group1);
		}
		EList<EObject> groupstmp = newHandCards.getGroups();
		System.out.println("NUmber of groups: " + groupstmp.size());
		assertEquals(groupstmp.size(), cards.length);
		dplayer.setHandcards(newHandCards);
		
	}
	
	
	private void completeADeal(long winnerID, Game game) throws Exception
	{
		Match match = game.getMatch();
		Deal deal = match.getDeal();
		
		MatchAdapter matchAdapter = (MatchAdapter) EcoreUtil.getRegisteredAdapter(match, match);
	    DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
	    AbstractGameAdapter gameAdapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter(game, game);

		playOneRound(gameAdapter, PLAYER_1);
		playOneRound(gameAdapter, PLAYER_2);
		
		
		if(winnerID == PLAYER_1)
		{
			playerInitShow(PLAYER_1, game);
			
			Thread.sleep(8000); // wait for 8 seconds
			
			declareCards(dealAdapter, PLAYER_2, null);

			checkDealEndMatchScoreState(matchAdapter, dealAdapter);

			checkWinner(deal, PLAYER_1);
		}
		else
		{
			playOneRound(gameAdapter, PLAYER_1);
			
			playerInitShow(PLAYER_2, game);
			
			Thread.sleep(8000); // wait for 8 seconds
			
			declareCards(dealAdapter, PLAYER_1, null);

			//checkDealEndMatchScoreState(matchAdapter, dealAdapter);

			checkWinner(deal, PLAYER_2);
		}
	}
		
	private void playerInitShow(long playerID, Game game) throws Exception
	{
		Deal deal = game.getMatch().getDeal();
		
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter(game, game);
		DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
		
		pickACard(gameAdapter, playerID);
		Card dicardCard = getCardToDiscard(playerID, deal);
			
		changeGroups(deal, playerID, dealAdapter);
    
		showInit(dealAdapter, playerID);
		Thread.sleep(3000); // wait for 3 seconds
	
		declareCards(dealAdapter, playerID, dicardCard);
	}
	
	private Card getCardToDiscard(long playerID, Deal deal)
	{
		DealPlayer dplayer = deal.getPlayerById(playerID);
		
		return (Card) dplayer.getHandcards().getGroupByIndex(0).getCard().get(0);
	}
	
	private void changeGroups(Deal deal, long playerID, IClientAdapter adapter)
	{
		DealPlayer dplayer = deal.getPlayerById(playerID);
		
		HandCards handCards = dplayer.getHandcards();
		CardContainer group = handCards.getGroupByIndex(0);
		
		EList<EObject> cards = group.getCard();		
		
		HandCards newHandCards = (HandCards) adapter.getModelFactory().createObject(HandCards.class);
		 
		EList<EObject> groups = newHandCards.getGroups();
		CardContainer group1 = (CardContainer) adapter.getModelFactory().createObject(GroupCards.class);
		EList<EObject> group1Cards = group1.getCard();
		 
		copyCards(cards, group1Cards, 0, 6);
		changeCards(group1Cards);
		groups.add(group1);
		 
		CardContainer group2 = (CardContainer) adapter.getModelFactory().createObject(GroupCards.class);
		EList<EObject> group2Cards = group2.getCard();
		
		copyCards(cards, group2Cards, 0, 5);
		changeCards(group2Cards);
		groups.add(group2);
		
		dplayer.setHandcards(newHandCards);
	}
	
	private void copyCards(EList<EObject> fromList, EList<EObject> toList, int fromIndex, int toIndex)
	{
		for(int i=fromIndex; i<toIndex; i++)
		{
			toList.add(i, fromList.get(i));
		}
	}	
	
	private void changeCards(EList<EObject> cards)
	{
		int i=0, j=1;
		for(EObject obj : cards)
		{
			Card c = (Card) obj;
			
			c.setRank(i);
			c.setSuit(j);
			
			i++;
		}	
	}
	
	private void showInit(IClientAdapter adapter, long playerID) throws Exception
	{
		int eventHandled = 0;
    	//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.ShowCardsInit);
    	sfsObject.putLong("playerid", playerID);
		
	    eventHandled = adapter.handleEvent(sfsObject);
	    
	    assertEquals("show init should be handled ", 1, eventHandled);
	}
	
	private void declareCards(DealAdapter adapter, long playerID, Card discardCard) throws Exception
	{
		int eventHandled = 0;
    	
		//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.ShowCards);
    	sfsObject.putLong("playerid", playerID);
    	
    	DealPlayer dealPlayer = adapter.getDealPlayerByID(playerID);
    	sfsObject.putSFSArray("Slots", getPlayerSlots(dealPlayer));
    	System.out.println(sfsObject.getDump());
    	
    	if(discardCard != null)
    	{
    		ISFSObject sfsCard = new SFSObject();
    		sfsCard.putInt("Suit", discardCard.getSuit());
    		sfsCard.putInt("Rank", discardCard.getRank());
    	
    		sfsObject.putSFSObject("Card", sfsCard);
    	}
    	else
    	{
    		sfsObject.putNull("Card");
    	}
		
	    eventHandled = adapter.handleEvent(sfsObject);
	    
	    assertEquals("show init should be handled ", 1, eventHandled);
	}
	
	private ISFSArray getPlayerSlots(DealPlayer player)
	{
		ISFSArray playerSlots = new SFSArray();
		
		EList<EObject> playerHand = player.getHandcards().getGroups();
		
		int id = 1;
		for(EObject obj : playerHand)
		{
			ISFSObject slot = new SFSObject();
			slot.putInt("SlotID", id);
			
			ISFSArray sequence = new SFSArray();
			
			CardContainer group = (CardContainer) obj;
			
			EList<EObject> cards = group.getCard();
			
			System.out.println(" Group " + id);
			
			for(EObject cardObj : cards)
			{
				Card card = (Card) cardObj;
				
				ISFSObject sfsCard = new SFSObject();
				sfsCard.putInt("Suit", card.getSuit());
				sfsCard.putInt("Rank", card.getRank());
				
				System.out.println(card);
				sequence.addSFSObject(sfsCard);
			}
			
			slot.putSFSArray("Sequence", sequence);
			playerSlots.addSFSObject(slot);

			id++;
		}
		
		return playerSlots;
	}
	
	public void playOneRound(IClientAdapter adapter, long player) throws Exception {
		pickACard(adapter, player);
		discACard(adapter, player);		
	}
	
	public void checkWinner(Deal deal, long player) {
		DealPlayer dplayer = deal.getPlayerById(player);
		System.out.println("Deal player" + dplayer);
		assertTrue(dplayer.isSetWinner());
	}
	
	public void checkDropped(Deal deal, long player) {
		DealPlayer dplayer = deal.getPlayerById(player);
		System.out.println("Deal player" + dplayer);
		assertTrue(dplayer.isDropped());
	}
	
	public void checkPlayerScore(Match match, long player, int score, int index) {
		MatchPlayer mplayer = match.getMatchPlayerById(player);
		System.out.println("Match player" + mplayer);
		System.out.println("Match" + match);
		assertEquals(mplayer.getScore().get(index).getScore(), score); 
	}
	
	public void checkPlayerTotalScore(Match match, long player, long score)
	{
		int tScore = 0;
		MatchPlayer mplayer = match.getMatchPlayerById(player);
		
		for(Score iScore : mplayer.getScore())
		{
			System.out.println("---" + iScore.getScore());
			tScore += iScore.getScore();
		}
		
		System.out.println("Total Score " + tScore);
		
		assertEquals(tScore, score); 
	}
	
	public void checkDealEndMatchScoreState(IClientAdapter matchAdapter, IClientAdapter dealAdapter) {
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealEndedSTM.class));
	    assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchScore4DealSTM.class));
	    
	}
	
	

}
