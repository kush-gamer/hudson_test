package com.rummy.tests;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class ParallelSeatingTests 
{
	static GameProxy gameProxy;
	
	@BeforeClass public static void onlyOnce() 
	{
		if( gameProxy == null )
		{
			System.out.println("Creating gameproxy");
		    gameProxy = Helper.createGameProxy(1, 5, 121, 1);
		}
	    
		gameProxy.getClientAdapter();	
	}
	
	@Test
	public void seat10() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(1, 0);
	}

	@Test
	public void seat20() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(2, 0);
	}
	
	@Test
	public void seat31() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(3, 1);
	}
	
	@Test
	public void seat40() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(4, 0);
	}
	
	@Test
	public void seat51() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(5, 1);
	}
	
	@Test
	public void seat62() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(5, 2);
	}
	
	@Test
	public void seat14() throws InterruptedException 
	{	
		JoinAndSeatAPlayer(1, 4);
	}
	
	
	private void JoinAndSeatAPlayer(int id, int seat)
	{
		try 
		{
			Thread.sleep(500);
			Helper.joinPlayer(gameProxy, id);
			Helper.assignSeat(gameProxy, id, seat);
		}
		catch(Exception e) 
		{
			//There should be no assertion on players joining. assert e == null will catch the exception in this test.
			assertTrue(e.getMessage(), e == null);
		}
	}

	
}
