package com.rummy.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.eclipse.emf.common.util.EList;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.actions.DefaultActionHandler;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.RummyContainer;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.logic.common.core.ERank;
import com.mango.games.rummy.utils.PickActionConstants;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;
import com.rummy.tests.di.TestInjectionModule;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class Helper {

	public static ISFSObject createSFSObject()
    {
    	ISFSObject sfsObject = new SFSObject();
    	sfsObject.putBool("IsServerEvent", false);
    	
    	return sfsObject;
    }
	
	 public static GameProxy createGameProxy(int id, int maxSeats, double prizePool, int gtype)
     {
	    	Injector  injector;
	    	injector = Guice.createInjector(new TestInjectionModule());
	    	
	    	GameProxy gameProxy = null;
	    	
	    	gameProxy = injector.getInstance(GameProxy.class);
			gameProxy.createNewGame(id, maxSeats, prizePool, gtype);
			gameProxy.getClientAdapter().setServerResponseManager(mock(ServerResponseManager.class));
			
			RummyContainer rummyContainer = new RummyContainer();
			RummyContainer.init();
			gameProxy.getClientAdapter().setEventHandlerMap(rummyContainer.eventHandlerMap);
			
			
			return gameProxy;
	    }

	
	public static boolean validateCurrentState(IClientAdapter adapter, Class b)
	{
		boolean bRet = true;
		
		DefaultActionHandler stm = (DefaultActionHandler) adapter.getStateChanger().getCurrent();
		
		System.out.println(" Current State " + stm.getClass());
		
		bRet = stm.getClass().isAssignableFrom(b);
		return bRet;
	}
		
		
	public static int joinPlayer(GameProxy gameProxy, long playerID) throws Exception
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
	
	public static int assignSeat(GameProxy gameProxy, long playerID, int seatID)
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
			
			return eventHandled;
	    }
	
	public static String getCurrentState(IClientAdapter adapter)
	{
		DefaultActionHandler stm = (DefaultActionHandler) adapter.getStateChanger().getCurrent();
		
		return stm.getClass().toString();
		
	}
	
	public static int getNumUsersInGame(IClientAdapter gameAdapter)
	{
		Game game = (Game)gameAdapter.getTarget();
		
		return ((Game)gameAdapter.getTarget()).getUser().size();
	}
	 
	public static int getNumPlayersInDeal(IClientAdapter gameAdapter)
	{
		IClientAdapter dealAdapter = gameAdapter.getChildAdapter().getChildAdapter();
		return ((Deal)dealAdapter.getTarget()).getDealplayer().size();
	}
	
	public static int getNumUsersSeatedInGame(IClientAdapter gameAdapter)
	{
		EList seats = ((Game)gameAdapter.getTarget()).getSeat();
		
		//Iterate through each seat and get number of non-empty seats.
		int   num = 0;
		
		for( int i=0; i<seats.size(); i++ )
		{
			Seat seat = (Seat)seats.get(i);
			if( seat.getPlayer() != null )
			{
				num++;
			}
		}
		return num;
	}
	
	public static EList getHandCards(long pid, IClientAdapter gameAdapter)
	{
		IClientAdapter dealAdapter = gameAdapter.getChildAdapter().getChildAdapter();
		EList dealPlayers = ((Deal)dealAdapter.getTarget()).getDealplayer();
		
		for( int i=0; i<dealPlayers.size(); i++ )
		{
			DealPlayer plyr = (DealPlayer)dealPlayers.get(i);
			if( plyr.getId() == pid )
			{
				GroupCards grp = plyr.getHandcards().getGroupByIndex(0);
				return grp.getCard();
			}
		}
		
		return null;
	}
	
	public static boolean isPlayerSeated(int pid, IClientAdapter gameAdapter)
	{
		EList seats = ((Game)gameAdapter.getTarget()).getSeat();
		
		for( int i=0; i<seats.size(); i++ )
		{
			Seat seat = (Seat)seats.get(i);
			if( seat.getPlayer() != null )
			{
				Player playr = (Player)seat.getPlayer();
				if (playr.getId() == pid )
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static Deal getDeal(IClientAdapter gameAdapter)
	{
		return (Deal)gameAdapter.getChildAdapter().getChildAdapter().getTarget();
	}
	
	public static ClosedDeck getClosedDeck(IClientAdapter gameAdapter)
	{
		return (ClosedDeck)Helper.getDeal(gameAdapter).getCloseddeck();
	}
	
	public static OpenDeck getOpenDeck(IClientAdapter gameAdapter)
	{
		return (OpenDeck)Helper.getDeal(gameAdapter).getOpendeck();
	}

	public static int getClosedDeckSize(IClientAdapter adapter)
	{
		return Helper.getClosedDeck(adapter).getCard().size();
	}
	
	public static int getOpenDeckSize(IClientAdapter adapter)
	{
		return Helper.getOpenDeck(adapter).getCard().size();
	}
	
	public static Seat getSeat(IClientAdapter gameAdapter, int seatid)
	{
		return (Seat) ((Game)gameAdapter.getTarget()).getSeat().get(seatid);
	}
	
	public static int pickACard(IClientAdapter gameAdapter, long playerID) throws Exception
	{
		int eventHandled = 0;
    	//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gcardpicked");
    	sfsObject.putLong("playerid", playerID);
    	sfsObject.putInt("pickedfrom", PickActionConstants.PICKED_FROM_CLOSED_DECK);
		
	    eventHandled = gameAdapter.handleEvent(sfsObject);
	    
	    return eventHandled;
	}
	
	public static int discardACard(IClientAdapter gameAdapter, long playerID, Card card) throws Exception
	{
		int eventHandled = 0;
    	//Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = Helper.createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, "gcardiscard");
    	sfsObject.putLong("playerid", playerID);
    	
    	ISFSObject sfsCard = new SFSObject();
    	sfsCard.putInt("Rank", card.getRank());
    	sfsCard.putInt("Suit", card.getSuit());
    	
    	sfsObject.putSFSObject("Card", sfsCard);
		
	    eventHandled = gameAdapter.handleEvent(sfsObject);
	    
	    return eventHandled;
	}
}
