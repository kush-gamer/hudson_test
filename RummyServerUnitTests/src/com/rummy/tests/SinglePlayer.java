package com.rummy.tests;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.actions.DefaultActionHandler;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.logic.common.game.GameNotStartedSTM;
import com.mango.games.rummy.logic.common.game.GamePlayingSTM;
import com.mango.games.rummy.logic.common.game.GameWaitingToStartSTM;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tests.concurrency.*;


public class SinglePlayer {

	
	GameProxy gameProxy;
	IClientAdapter adapter;
	
	int       playerId = 1;
	int       seatId = 1;
	Injector  injector;

	
	@Before
	public void setUp() throws Exception 
	{
//		injector = Guice.createInjector(new InjectionModule());
//		gameProxy = injector.getInstance(GameProxy.class);
//		gameProxy.createNewGame(1, 5, 121, 1);
//		gameProxy.getClientAdapter().setServerResponseManager(mock(ServerResponseManager.class));
		gameProxy = Helper.createGameProxy(1, 5, 121, 101);
		adapter   = gameProxy.getClientAdapter();
	}

	@After
	public void tearDown() throws Exception 
	{
		gameProxy = null;
	}
	
	@Test
	public void testNewGame() throws InterruptedException
	{
		IClientAdapter adapter = gameProxy.getClientAdapter();
		assertNotNull(adapter);
		
		assertNotNull(adapter.getModelFactory());
		assertNotNull(adapter.getTimerScheduler());
		assert(null == adapter.getServerResponseManager());
	}
	
	@Test
	public void testInvalidMessage() throws InterruptedException
	{
		ISFSObject sfsObject = Helper.createSFSObject();
		
		sfsObject.putBool("IsServerEvent", false);
		sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "InvalidMessage");
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		try {
			adapter.handleEvent(sfsObject);
		}
		catch(Exception e)
		{
			assertTrue(e != null);
		}
	}
	
	@Test
	public void testJoinMe() throws InterruptedException
	{
		int eventHandled = 0;
		try 
		{
			//eventHandled = joinPlayer(1);
			eventHandled = Helper.joinPlayer(gameProxy, 1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(e.getMessage(), e == null);
		}
		
		assertTrue( eventHandled == 1 );
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		Game game = (Game)adapter.getTarget();
		
		assertTrue(game.getUser().size() > 0 );
	}
	
	
	@Test
	public void testTakeSeat1Player() throws InterruptedException
	{
		try 
		{
			joinPlayer(1);
			assignSeat(1, 0);
		}
		catch(Exception e){
			assertTrue(e.getMessage(), e == null);
		}
		IClientAdapter adapter = gameProxy.getClientAdapter();
		Game game = (Game)adapter.getTarget();
		
	    System.out.println(" Seat Taken Successfully !" + game.getSeat().size());

		Seat seat = (Seat)game.getSeat().get(0);
	    assertNotNull("Player Not Null ", seat.getPlayer());
	    
	    Player player = (Player)seat.getPlayer();
	    System.out.println(" Seat Taken Successfully !" + player.getId());
	}
	
	@Test
	public void test2Joins() throws InterruptedException
	{
		try 
		{
			joinPlayer(1);
			assignSeat(1, 0);
		}
		catch(Exception e) {}
		
		try
		{
			joinPlayer(2);
		}
		catch(Exception e){
			
			assertTrue(e.getMessage(), e == null);
		}
		
		IClientAdapter adapter = gameProxy.getClientAdapter();
		Game game = (Game)adapter.getTarget();
		
		Seat seat = (Seat)game.getSeat().get(0);
		assertTrue(seat.getPlayer() != null);
		
		seat = (Seat)game.getSeat().get(1);
		assertTrue(seat.getPlayer() == null);
		
		assertTrue(game.getUser().size() == 2);
		
	}
	
	@Test
	public void testTakeSeat2Player() throws InterruptedException 
	{
		try 
		{
			joinPlayer(1);
			assignSeat(1, 0);
			joinPlayer(2);
		}
		catch(Exception e) {}

		IClientAdapter adapter = gameProxy.getClientAdapter();
		
		assertTrue(validateCurrentState(adapter, GameNotStartedSTM.class));
		
		try{
			
			assignSeat(2, 1);
		}
		catch(Exception e){
			
			assertTrue(e.getMessage(), e == null);
		}
		
		
		Game game = (Game)adapter.getTarget();
		
		Seat seat = (Seat)game.getSeat().get(0);
		assertTrue(seat.getPlayer() != null);
		
		seat = (Seat)game.getSeat().get(1);
		assertTrue(seat.getPlayer() != null);
		
		assertTrue(validateCurrentState(adapter, GameWaitingToStartSTM.class));
		/**
		 * NOTE: To check if the timeout is working set a breakpoint at the previous line and'
		 * wait for 10 seconds. check the stdout and then resume.
		 */
		
		assertEquals("Number of players should be 2", 2, Helper.getNumUsersInGame(adapter));
		
	}
	

	
	
	private boolean validateCurrentState(IClientAdapter adapter, Class b)
	{
		boolean bRet = true;
		
        DefaultActionHandler stm = (DefaultActionHandler) adapter.getStateChanger().getCurrent();
		
		bRet = stm.getClass().isAssignableFrom(b);
		return bRet;
	}
	
	
    private int joinPlayer(long playerID) throws Exception
    {
    	int eventHandled = 0;
    	//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();

    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gjoinme");
    	sfsObject.putLong("playerid", playerID);
    	
    	IClientAdapter adapter = gameProxy.getClientAdapter();
		
	    eventHandled = adapter.handleEvent(sfsObject);
	    
	    return eventHandled;
			
    }
    
    
    
    private void assignSeat(long playerID, int seatID)
    {
		ISFSObject sfsObject = Helper.createSFSObject();
		sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gseataken");
		sfsObject.putLong("playerid", playerID);
		sfsObject.putLong("seatid", seatID);
		
		int eventHandled = 0;
		IClientAdapter adapter = gameProxy.getClientAdapter();
		try 
		{
			eventHandled = adapter.handleEvent(sfsObject);
		}
		catch(Exception e)
		{
			assertTrue(e.getMessage(), e == null);
		}
		
		assertTrue( eventHandled == 1);
    }
    
   
}
