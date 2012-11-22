package com.rummy.tests;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.deal.DealPlayingSTM;
import com.mango.games.rummy.logic.common.game.GamePlayingSTM;
import com.mango.games.rummy.logic.common.match.MatchPlayingSTM;
import com.mango.games.rummy.model.ModelCreationFactory;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.rummy.tests.base.GamePlayTests;

public class TestBots extends GamePlayTests 
{
	public static long PLAYER_1 = 1;
	public static long GAME_1 = 1;
	
	@Before
	public void setUp() throws Exception 
	{
		
	}
	
	@Test
	public void TestBotAdapter() throws InterruptedException, Exception 
	{
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		BotPlayer botDealPlayer = (BotPlayer) adapter.getModelFactory().
		createObject(BotPlayer.class);
		
		ModelCreationFactory mFactory = (ModelCreationFactory)adapter.getModelFactory();
		mFactory.getDocumentRoot().setBotPlayer(botDealPlayer);
		
		BotPlayerAdapter botadapter = (BotPlayerAdapter) EcoreUtil.getRegisteredAdapter(botDealPlayer, botDealPlayer);

		//Get once more

		BotPlayerAdapter botadapter2 = (BotPlayerAdapter) EcoreUtil.getRegisteredAdapter(botDealPlayer, botDealPlayer);


		assert(botadapter.equals(botadapter2));
		
	}
	
	@Test
	public void TestBotSpawn() throws InterruptedException, Exception 
	{
		/* Create Game */
		GameProxy gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		try 
		{
			Helper.joinPlayer(gameProxy, PLAYER_1);
			Helper.assignSeat(gameProxy, PLAYER_1, 0);
		} 
		catch (Exception e) 
		{
			
		}
		
		Game game = (Game) adapter.getTarget();
		Thread.sleep(TimeoutConstants.GAME_START_COUNTDOWN + 50);		
		Thread.sleep(TimeoutConstants.START_SHUFFLE_ANIMATION + 50);
		Thread.sleep(TimeoutConstants.BOT_SEATING + 50);
		
		assertTrue(Helper.getCurrentState(adapter), Helper.validateCurrentState(adapter, GamePlayingSTM.class));		
		
		Match match = game.getMatch();
		assertNotNull(match);
		
		Deal deal = match.getDeal();
		assertNotNull(deal);
		
		IClientAdapter matchAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(match, match);
		IClientAdapter dealAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(deal, deal);		
		
		assertTrue(Helper.getCurrentState(matchAdapter), Helper.validateCurrentState(matchAdapter, MatchPlayingSTM.class));
		assertTrue(Helper.getCurrentState(dealAdapter), Helper.validateCurrentState(dealAdapter, DealPlayingSTM.class));
		
		System.out.println("Deal Player Size " + deal.getDealplayer().size());
		assertEquals(deal.getDealplayer().size(), 2);
		
		System.out.println("Match Player Size " + match.getMatchplayer().size());
		assertEquals(match.getMatchplayer().size(), 2);
		
		System.out.println("Current Turn " + deal.getCurrentTurn());
		
		for(int i=0; i<120; i++)
		{
			if(deal.getCurrentTurn() == 0)
			{
				System.out.println("*********Test Player Playing TURN*********");
				playOneRound(adapter, PLAYER_1);
			}
		
			Thread.sleep(5000);
		}
		
		//System.out.println("Bot discarded card " + Helper.getOpenDeck(adapter).getCard().get(1));
		
		//Thread.sleep(TimeoutConstants.TURN_TIME_OUT);
		//playOneRound(adapter, PLAYER_1);
		
		//System.out.println("Player discarded card " + Helper.getOpenDeck(adapter).getCard().get(2));
	}
	
	
	public void playOneRound(IClientAdapter adapter, long player) throws Exception 
	{
		pickACard(adapter, player);
		discACard(adapter, player);
	}
}
