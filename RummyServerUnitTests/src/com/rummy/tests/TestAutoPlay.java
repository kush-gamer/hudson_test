package com.rummy.tests;


import org.junit.Before;
import org.junit.Test;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.rummy.tests.base.GamePlayTests;

public class TestAutoPlay extends GamePlayTests{

	@Before
	public void setUp() throws Exception 
	{
		
	}
	
	@Test
	public void TestAutoPlayTillGameOver() throws InterruptedException, Exception
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
	    
	    //Continue the game further
	    
	    Thread.sleep(300000);

	}
	

}
