package com.rummy.tests.base;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.Card;
import com.rummy.tests.Helper;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class GamePlayTests 
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
	
	
	protected void pickACard(IClientAdapter adapter, long playerID) throws Exception
	{
		/**
		 * Get the current state of ClosedDeck, OpenDeck. 
		 */
		int iClosedDeckSize = Helper.getClosedDeckSize(adapter);
		int handled = 0;
		String message = "";
		
		/**
		 * If the closed deck size reduces to zero, then shuffle will bring it back 
		 */
		if( iClosedDeckSize == 1 )
			iClosedDeckSize = 24;

		System.out.println("Closed Deck Size Before:" + Helper.getClosedDeckSize(adapter));

		//Wait before picking. Wait for a random time, just 2 secs less than the actual wait time.
		int waitTime = new Random().nextInt(TimeoutConstants.TURN_TIME_OUT/2 - 500);
		
		//Thread.sleep(waitTime);
		
		handled = Helper.pickACard(adapter, playerID);
		assertEquals("PickCard should be handled ", 1, handled);

		message = "Player should have 14 cards";
		

		System.out.println("Closed Deck Size After:" + Helper.getClosedDeckSize(adapter));
		
		System.out.println(message + " : " +  Helper.getHandCards(playerID, adapter).size());
		//assertEquals(message, Helper.getHandCards(playerID, adapter).size(), 14);


		message = "ClosedDeck should have " + (iClosedDeckSize-1) + " cards";
		
		System.out.println(message + " : " +  Helper.getClosedDeckSize(adapter));
		//assertEquals(message, iClosedDeckSize - 1, Helper.getClosedDeckSize(adapter) );
	}
	
	protected void discACard(IClientAdapter adapter, long playerID) throws InterruptedException, Exception
	{
		int iOpenDeckSize = Helper.getOpenDeckSize(adapter);
		int handled = 0;
		String message = "";
		Card discCard = (Card)Helper.getHandCards(playerID, adapter).get(new Random().nextInt(13));
		
		//Wait before picking. Wait for a random time, just 2 secs less than the actual wait time.
		int waitTime = new Random().nextInt(TimeoutConstants.TURN_TIME_OUT/2 - 500);
		
		//Thread.sleep(waitTime);
		handled = Helper.discardACard(adapter, playerID, discCard);
		assertEquals("DiscardCard should be handled ", 1, handled);
		
		message = "Opendeck should have " + (iOpenDeckSize+1) + " cards";
		assertEquals(message, iOpenDeckSize + 1, Helper.getOpenDeckSize(adapter));
		
		message = "Player should have 13 cards";
		assertEquals(message, 13, Helper.getHandCards(playerID, adapter).size());
	}
	
	protected void dropFromDeal(IClientAdapter adapter, long playerID) throws Exception
	{
		int eventHandled = 0;
    	//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gdropme");
    	sfsObject.putLong("playerid", playerID);
		
	    eventHandled = adapter.handleEvent(sfsObject);
	    
	    assertEquals("drop should be handled ", 1, eventHandled);
	}
}
