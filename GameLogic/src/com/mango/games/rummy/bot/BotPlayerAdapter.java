package com.mango.games.rummy.bot;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.mango.games.db.BotInfoDB;
import com.mango.games.db.PlayerDB;
import com.mango.games.db.UserDB;
import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ITimerCallable;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.DateTimeUtil;
import com.mango.games.rummy.utils.ITimerScheduler;
import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.PickActionConstants;
import com.mango.games.rummy.utils.TableScheduler;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.OpenDeck;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;


public class BotPlayerAdapter implements Adapter, ITimerCallable
{
	private BotNPC _botNPC = null;
	
	private BotPlayer _botPlayer = null;
	
    private IModelCreationFactory _modelFactory;
    
    private IClientAdapter _clientAdapter = null;
    
    private ITimerScheduler _timerScheduler = null; //Create a private scheduler for BOT turn management
    
    BotInfoDB _botInfo = null;
    
    private BotPlayer getBotPlayer()
    {
    	return (BotPlayer) getTarget();
    }
    
    @Inject
    public BotPlayerAdapter(BotPlayer target) 
	{
		super();
		
		try 
		{
			_botNPC = new BotNPC();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		_timerScheduler = new TableScheduler(this);
		
		System.out.println(" ++++  Constructing BOT PLAYER ADAPTER " + this);
	}
    
	public void setClientAdapter(IClientAdapter clientAdapter)
	{
		_clientAdapter = clientAdapter;
		
		_modelFactory = _clientAdapter.getModelFactory();
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	@Override
	public Notifier getTarget() 
	{
		return _botPlayer;
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object arg0) 
	{
		if( arg0 instanceof BotPlayer )
		   return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	/* TODO: Not USED. FOR Reference : Notification
	@Override
	public void notifyChanged(Notification arg0) 
	{
		/**
		 * Adding multiple conditions because we are only interested in intercepting the card added event.
		 * This event happens when the picked card is added to players handcards. We are generating a custom
		 * event on the BotPlayer to reposition the card as per set/seq after the card is added to handcards
		 
		if((arg0.getEventType() == Notification.ADD) && (arg0.getNewValue() instanceof Card) &&
			 arg0.getOldValue() == null)
		{
			receivePickedCard((Card)arg0.getNewValue());
		}
	}*/
	
	public long spawnBot(int roomID) // returns player id
	{
		// get next available bot
		_botInfo = BotInfoDB.getNextAvailable();
		
		if(_botNPC.activate(roomID, _botInfo.getExternalid()))
		{
			long botDBID = Login(_botInfo);
			_botInfo.Engage();
			
			return botDBID;
		}
		
		return 0;
	}
		
	public void handleReady(int openJokerRank)
	{
		Log.logger.debug("(((((((((((((((((((((READY))))))))))))))))))) " + getBotPlayer());
		
		DealPlayer dealPlayer = getDealPlayer(getBotPlayer().getId());
		
		HandCards botHand = dealPlayer.getHandcards();
	
		EList<EObject> groups = botHand.getGroups();
		CardContainer group = (CardContainer) groups.get(0);

		EList<EObject> cards = group.getCard();
				
		for(EObject obj : cards)
		{
			Card card = (Card) (obj);
			
			// pass a new instance
			Card newCard = (Card) _clientAdapter.getModelFactory().createObject(Card.class);
			newCard.setRank(card.getRank());
			newCard.setSuit(card.getSuit());
			
			getBotPlayer().getBotModel().addCardToHandCards(newCard);
			
			Log.logger.debug("Adding card to bot hand " + newCard);
		}
		
		getBotPlayer().getBotModel().setOpenJokerRank(openJokerRank);
	}
	
	private DealPlayer getDealPlayer(long playerID)
	{
	    Log.logger.debug("Getting deal player by ID " + playerID);
		
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) _clientAdapter;
		
		Deal deal = gameAdapter.getGame().getMatch().getDeal();
		
		return deal.getPlayerById(playerID);
	}
	
	public void playTurn()
	{
		Random randomGenerator = new Random();
		int pickInSeconds = (27 - randomGenerator.nextInt(7)) * 1000; //TODO:		
		
		Log.logger.debug("Bot to play turn in " + pickInSeconds);

		_timerScheduler.scheduleTimeout(2000, ITimerScheduler.BOTPICK); // TODO:
	}

	/**
	 * Handle the bot scheduled timeout here.
	 */
	@Override
	public int handleTimeout(TimedAction action) throws Exception 
	{
		// get discarded card from the open deck
		if(action.getSeq() == ITimerScheduler.BOTPICK)
		{
			Log.logger.debug("Bot time to pick Card  ");
			
			AbstractGameAdapter gameAdapter = (AbstractGameAdapter) _clientAdapter;
		
			Deal deal = gameAdapter.getGame().getMatch().getDeal();
		
			OpenDeck openDeck = (OpenDeck) deal.getOpendeck();
			Card lastDiscardedCard = (Card) openDeck.getCard().get(0);
			pickACard(lastDiscardedCard);
			
			Log.logger.debug("Picked   ");
		}
		else if(action.getSeq() == ITimerScheduler.BOTDISCARD)
		{
			if(true == getBotPlayer().getBotModel().isReadyToSubmit())
			{
				initShow();
			}
			else
			{
				Card discardedCard = getBotPlayer().getBotModel().discardACard();
				cardDiscarded(discardedCard);
				
				Log.logger.debug("&&&&& Bot discarded card &&&& " + discardedCard.getRank() + " " + discardedCard.getSuit());
			}
		}
		else if(action.getSeq() == ITimerScheduler.BOTSHOW)
		{
			declareCards(true);
		}

		return 1;
	}
	
	public void receivePickedCard(Card pickedCard)
	{
		Card card = (Card) (pickedCard);
		
		Log.logger.debug("Received Picked Card  " + pickedCard.getRank() + " " + pickedCard.getSuit());
		
		// pass a new instance
		Card newCard = (Card) _modelFactory.createObject(Card.class);
		newCard.setRank(card.getRank());
		newCard.setSuit(card.getSuit());
		
		getBotPlayer().getBotModel().fitPickedCard(card);
		
		Random randomGenerator = new Random();
		int discardInSeconds = (randomGenerator.nextInt(13) + 5) * 1000; //TODO:
		
		_timerScheduler.scheduleTimeout(1000, ITimerScheduler.BOTDISCARD);
	}
	
	public void setBotPlayerID(long playerID)
	{
		//_botPlayer.setId(playerID);
	}
	
	private void pickACard(Card discardedCard)
	{
		int pickFrom = PickActionConstants.PICKED_FROM_OPEN_DECK;
		
		if(true == getBotPlayer().getBotModel().shouldPickFromClosedDeck(discardedCard))
		{
			pickFrom = PickActionConstants.PICKED_FROM_CLOSED_DECK;
		}
		
		try 
		{
			cardPicked(pickFrom);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private ISFSObject createSFSObject()
    {
    	ISFSObject sfsObject = new SFSObject();
    	sfsObject.putBool("IsServerEvent", false);
    	
    	return sfsObject;
    }
	
	private int cardPicked(int pickedFrom) throws Exception
    {
    	int eventHandled = 0;
    	
    	// Send a JoinMe message to the GameAdapter, and check its flow.
    	ISFSObject sfsObject = createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.CardPicked);
    	sfsObject.putLong("playerid", getBotPlayer().getId());
    	sfsObject.putInt("pickedfrom", pickedFrom);
 	    
    	eventHandled = _clientAdapter.handleEvent(sfsObject);
	    
	    return eventHandled;
    }
	
	private int cardDiscarded(Card discardedCard)
	{
    	int eventHandled = 0;
    	
		ISFSObject sfsObject = createSFSObject();
    	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.CardDiscarded);
    	sfsObject.putLong("playerid", getBotPlayer().getId());
    	
    	ISFSObject sfsCard = new SFSObject();
    	sfsCard.putInt("Rank", discardedCard.getRank());
    	sfsCard.putInt("Suit", discardedCard.getSuit());
    	
    	sfsObject.putSFSObject("Card", sfsCard);
		
	    try 
	    {
			eventHandled = _clientAdapter.handleEvent(sfsObject);
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	    
	    return eventHandled;
	}
	
	private int initShow()
	{
		int eventHandled = 0;
	   	
	   	ISFSObject sfsObject = createSFSObject();
	   	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.ShowCardsInit);
	   	sfsObject.putLong("playerid", getBotPlayer().getId());
	   	
	    try 
	    {
			eventHandled = _clientAdapter.handleEvent(sfsObject);
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
	   	
		Random randomGenerator = new Random();
		int showInSeconds = (randomGenerator.nextInt(5) + 10) * 1000; //TODO:
		_timerScheduler.scheduleTimeout(2000, ITimerScheduler.BOTSHOW);

	   	return eventHandled;
	}
	
	public int declareCards(boolean hasDeclaredShow)
	{
		int eventHandled = 0;
		
		ISFSObject sfsObject = createSFSObject();
	   	sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.ShowCards);
	   	sfsObject.putLong("playerid", getBotPlayer().getId());
  	
		ISFSObject sfsShowCard = new SFSObject();
		Card showCard = getBotPlayer().getBotModel().getShowCard();

		ISFSArray slotsArray = getSlotsArray();

		sfsObject.putBool("DeclaredShow", hasDeclaredShow);
		
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) _clientAdapter;
		int seatNo = gameAdapter.getSeatForPlayer(getBotPlayer().getId()).getSeatId();
		
		sfsObject.putInt("SeatNo", seatNo);
		
		sfsShowCard.putInt("Suit", showCard.getSuit());
		sfsShowCard.putInt("Rank", showCard.getRank());
		
		sfsObject.putSFSObject("ShowCard", sfsShowCard);
		sfsObject.putSFSArray("Slots", slotsArray);
		
		Log.logger.debug("Slots" + slotsArray.getDump());
		
	    try 
	    {
			eventHandled = _clientAdapter.handleEvent(sfsObject);
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}

		return eventHandled;
	}
	
	public void deactivate() throws Exception
	{
		_botNPC.deactivate();
		
		quitToLobby();
		
		_botInfo.Release();
	}
	
	private void quitToLobby() throws Exception
	{
		ISFSObject sfsObject = createSFSObject();
		sfsObject.putUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID, ActionConstants.QuitToLobby);
		sfsObject.putLong("playerid", _botPlayer.getId());
		sfsObject.putLong("seatid", _botPlayer.getBotModel().getSeatNo());
		
		_clientAdapter.handleEvent(sfsObject);
	}
	
	private ISFSArray getSlotsArray()
	{
		// Create show slots array
		ArrayList<ArrayList<Card>> slots = getBotPlayer().getBotModel().getArrangedCards();
		
		System.out.println("Slots Array ");
		
		for(int i=0; i<slots.size(); i++)
		{
			System.out.println(" slot - " + slots.get(i));
		}
		
		int maxSets = 4;
		ISFSArray slotsArray = new SFSArray();
		
		for(int setIndex = 0; setIndex < maxSets; setIndex++) 
		{
			if (slots.get(setIndex).size() == 4)
			{
				ISFSObject cSlot = createSlot(setIndex, 1, slots);
				slotsArray.addSFSObject(cSlot);
				break;
			}
		}
		
		int slotId = 1;
		for (int setIndex = 0; setIndex < maxSets; setIndex++)
		{
			if (slots.get(setIndex).size() < 4)
			{
				slotId++;
				ISFSObject cSlot = createSlot(setIndex, slotId, slots);
				slotsArray.addSFSObject(cSlot);
			}
		}
		return slotsArray;
	}
	
	private ISFSObject createSlot(int setIndex, int slotId, ArrayList<ArrayList<Card>> slots)
	{
		ISFSObject cSlot = new SFSObject();
		cSlot.putInt("SlotID", slotId);
		
		ISFSArray sequence = new SFSArray();
		
		for (Card card : slots.get(setIndex))
		{
			ISFSObject cardObj = new SFSObject();
			cardObj.putInt("Suit", card.getSuit());
			cardObj.putInt("Rank", card.getRank());
			sequence.addSFSObject(cardObj);
		}
		
		cSlot.putSFSArray("Sequence", sequence);
		return cSlot;
	}
	
	/**
	 * If new bot, insert info, 
	 * else read bot info into memcache (level, chips, achievements, rank etc) 
	 * @param botInfo
	 */
	public long Login(BotInfoDB botInfo)
	{
		String externalID = botInfo.getExternalid();
		String gender = botInfo.getGender();
		String firstName = botInfo.getFirst_name();
		String lastName = botInfo.getLast_name();
		String email = botInfo.getEmailid();
		String dob = botInfo.getDob();
		
		PlayerDB playerDB = new PlayerDB();
		Log.logger.debug(externalID);
		Log.logger.debug(playerDB);
		Log.logger.debug(Integer.getInteger(externalID));
		Log.logger.debug(Integer.parseInt(externalID));
		//ResultSet rs = playerDB.getPlayerByFbId(Integer.getInteger(externalID));
		//ResultSet rs = playerDB.getPlayerByFbId(Integer.parseInt(externalID));
        /*
         * adding UserDB Calls
         */
		UserDB userobj = UserDB.getUserbyFBID(externalID);
		if(userobj == null)
		{
			/*
			 * If Bot Doesn't exist in User Table 
			 * Adding Bot Data in the Database
			 */
			userobj = new UserDB(firstName, lastName, email, externalID, gender, dob);
		}
	     
		return userobj.getId();
		
		// TODO: DB LastLoggedInDate, ConsecutiveLogins
        // int dailyBonus = getDailyBonus(userobj.getlastLoggedInDate, consecutiveLogins);
        
        //TODO: DB add bonus to player chips
  	}
	
	private static int getDailyBonus(String lastLoggedInDate, int consecutiveLogins)
	{
		if(lastLoggedInDate.length() > 0) // the db has some value
		{
			// compare with the current date
			long diff = DateTimeUtil.DaysBetween(lastLoggedInDate, DateTimeUtil.GetCurrentTimeStamp());
			
			if(diff >= 1 && diff < 2)
			{
				// add Daily bonus
				consecutiveLogins++;
	        		
        		if(consecutiveLogins == 6) consecutiveLogins = 1;
        		
        		int dailyBonuses[] = {200, 400, 600, 800, 1000};
        		
  	    		switch(consecutiveLogins)
        		{
        		case 1:
        			return dailyBonuses[0];
        		case 2:
		        	return dailyBonuses[1];
        		case 3:
		        	return dailyBonuses[2];
        		case 4:
		        	return dailyBonuses[3];
        		case 5:
		        	return dailyBonuses[4];
        		}
        	}
        	else if(diff < 1)
        	{
        		return 0;
        	}
        	else if(diff >= 2)
        	{
        		consecutiveLogins = 1;
        		return 0;
        	}
        }
		
		return 0;
	}


	@Override
	public void notifyChanged(Notification arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(Notifier arg0) 
	{
		// TODO Auto-generated method stub
		_botPlayer = (BotPlayer) arg0;
	}
}
