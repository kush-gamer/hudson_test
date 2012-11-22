package com.mango.games.rummy.logic.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;

import com.mango.games.rummy.bot.BotPlayerAdapter;

import com.mango.games.rummy.logic.actions.EventHandlerMap;

import com.mango.games.rummy.logic.common.core.CardCore;
import com.mango.games.rummy.logic.common.core.ERank;
import com.mango.games.rummy.logic.common.core.ESuit;
import com.mango.games.rummy.logic.common.core.ShowSlot;
import com.mango.games.rummy.logic.common.core.ShowSlot.ELuck;
import com.mango.games.rummy.logic.common.core.ShowSlotAttribute;
import com.mango.games.rummy.logic.common.deal.DealShuffleCardsSTM;
import com.mango.games.rummy.logic.common.deal.DealStateHolder;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.model.ModelUtils;

import com.mango.games.rummy.utils.ITimerScheduler;
import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.PlayerType;
import com.mango.games.rummy.utils.WinHighlight;

import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.ClosedDeck;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.GroupCards;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Score;
import com.mangogames.rummy.model.Seat;

import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * Adapts to the changes in Deal, and notifies the same to the client (via SFX API)
 * @author Sanjeev
 *
 */
public class DealAdapter extends AbstractAdapter
{
    private IStateChanger _stateHolder;
    
    /**
     * Create empty containers - ClosedDeck, OpenDeck, DealPlayerList
     */
    @Inject
    public DealAdapter(EObject targ)
    {
    	super(targ);
    	
    	// Create Closed Deck
    	getDeal().setCloseddeck((EObject)getModelFactory().createObject(ClosedDeck.class));
    	
    	// Create Opendeck container
    	getDeal().setOpendeck((EObject)getModelFactory().createObject(OpenDeck.class));
    	
    	_stateHolder = new DealStateHolder(this);
    	_stateHolder.changeState(new DealShuffleCardsSTM(_stateHolder));
    }
    
    
	@Override
	public int handleEvent(ISFSObject params) throws Exception
	{
    	return super.handleEvent(params);
	}
	
	@Override
	public int handleTimeout(TimedAction action) throws Exception
	{
		return super.handleTimeout(action);
	}
	
	@Override
	/**
	 * Deal does not have any children that respond to events and timeouts.
	 * Hence there is no child adatper for the deal.
	 */
	public IClientAdapter getChildAdapter()
    {
		return null;
    }
    
    public IStateChanger getStateHolder()
    {
    	return this._stateHolder;
    }

    
    /**
     * 1. Shuffle cards in the closed deck
     * 2. Add players to deal from the match. These are players who completed toss.
     * 3. Distribute cards to the players seated in the deal.
     */
	public void shuffleAndDeal()
	{
		// Create a deck - size of the deck is based on the number of players.
		initClosedDeck();
		
		initPlayersHand();
		
		// Distribute cards to players
		distributeCardsToPlayers();

		// Select the joker card
		setJoker();
		
		// Select an opendeck card
		addFirstCardToOpenDeck();
		
		// set the first turn
		setTurn();
		
		// init bots if any
		setBotPlayerContext();
	}
	
	private void setTurn()
	{
		// get the deal number
		int dealNum = getDeal().getMatch().getDealCount();
		
		if(dealNum == 0)
		{
			getDeal().setCurrentTurn(0);
			getDeal().getMatch().setLastStartTurn(0);
		}
		else
		{
			int lastStartTurn = getDeal().getMatch().getLastStartTurn(); 
			int nextTurn = getNextOccupiedSeat(lastStartTurn).getSeatId();
			getDeal().setCurrentTurn(nextTurn);
			getDeal().getMatch().setLastStartTurn(nextTurn);
		}
	}
	
	/**
	 * Fill closed deck with cards and shuffle the cards.
	 */
	private void initClosedDeck()
	{
		int deckCount = 1;
		
		int totalPlayers = getDeal().getDealplayer().size();
		
		if(totalPlayers > 2 && totalPlayers < 5)
		{
			deckCount = 2;
		}
		else if( totalPlayers >= 5)
		{
			deckCount = 3;
		} 
		
		ClosedDeck closedDeck = (ClosedDeck) getDeal().getCloseddeck();
		
		for(int i=0; i<deckCount; i++)
		{
			for(ESuit suit : ESuit.values())
			{
				for(ERank rank : ERank.values())
				{
					if(rank == ERank.ACE_WITH_FACE) continue; // not to be dealt
					
					Card newCard = (Card) getModelFactory().createObject(Card.class);
					
					newCard.setRank(rank.ordinal());
					newCard.setSuit(suit.ordinal());
					
					closedDeck.getCard().add(newCard);
				}
			}
		}
		
		// shuffle
		// LanguageUtil.shuffle(closedDeck.getCard());
		closedDeck.shuffle();
		
		int kk = 100;
		kk = 200 + kk;
	}
	
	 private void initPlayersHand()
	 {
		 EList<EObject> dealPlayers = getDeal().getDealplayer();
		 for(EObject obj : dealPlayers)
		 {
			 DealPlayer dealPlayer = (DealPlayer) obj;
			 if(dealPlayer != null)
			 {
				 //1. Create handcards
				 HandCards playerHandCards = (HandCards) getModelFactory().createObject(HandCards.class);
				 
				 //2. set handcards to player
				 dealPlayer.setHandcards(playerHandCards);
				 //3. Create a single group and add it to handcards
				 
				 EList<EObject> groups = playerHandCards.getGroups();
				 CardContainer group = (CardContainer) getModelFactory().createObject(GroupCards.class);
				 groups.add(group);
			 }
		 }
	 }
	
	private void distributeCardsToPlayers()
	{
		// deal 13 cards to each player
		for(int i=0; i<13; i++)
		{
			// make sure that the deck doesn't run out of cards
			if(getClosedDeck().size() == 0)
			{
				Log.logger.debug("Error: Deck not enough");
			}
			
			dealCards();
		}
	}
	
	private void dealCards()
	{
		EList<EObject> dealPlayers = getDeal().getDealplayer();

		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			
			HandCards playerHandCards = dealPlayer.getHandcards();
			EList<EObject> groups = playerHandCards.getGroups();			
			
			CardContainer group = (CardContainer) groups.get(0);
			
			EList<EObject> cards = group.getCard();
			cards.add(getClosedDeckList().remove(0));
		}
	}
	
	
	private void setBotPlayerContext()
	{
		EList<EObject> dealPlayers = getDeal().getDealplayer();

		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			
			if(dealPlayer.getType() == PlayerType.BOT)
			{
				BotPlayerAdapter botAdapter = getBotPlayerAdapter(dealPlayer);
				
				if(botAdapter != null)
				{
					botAdapter.setBotPlayerID(dealPlayer.getId());
					Card joker = (Card)(getDeal().getJoker());
					botAdapter.handleReady(joker.getRank());
				}
			}
		}
	}
	
	private EList<EObject> getClosedDeckList()
	{
		return ((ClosedDeck)getDeal().getCloseddeck()).getCard();
	}
	
	private void setJoker()
	{
		// pull the card from the middle of the deck and set it as open joker
		EList<EObject> closedDeckCards = ((ClosedDeck)getDeal().getCloseddeck()).getCard();
		Card openJoker = (Card) closedDeckCards.get(closedDeckCards.size()/2 - 1);
		
		getDeal().setJoker(openJoker);
				
		closedDeckCards.remove(openJoker);
	}
	
	private void addFirstCardToOpenDeck()
	{
		EList<EObject> openDeckCards = ((OpenDeck)getDeal().getOpendeck()).getCard();
		EList<EObject> closedDeckCards = ((ClosedDeck)getDeal().getCloseddeck()).getCard();

		openDeckCards.add(closedDeckCards.remove(0));
	}
	
	public boolean isCheatCard(Card card, long playerID)
	{
		HandCards playerHand = getDealPlayerByID(playerID).getHandcards();
		
		EList<EObject> groups = playerHand.getGroups();
		
		for(EObject obj : groups)
		{
			CardContainer group = (CardContainer)(obj);
			
			EList<EObject> playerCards = group.getCard();
			
			for(EObject playerCard : playerCards)
			{
				Card playerCardObj = (Card)playerCard;
				Log.logger.debug("PC--" + playerCardObj);
				if(playerCardObj.getSuit() == card.getSuit() && 
						playerCardObj.getRank() == card.getRank())
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public EList<EObject> getPlayerCards(long playerID)
	{
		DealPlayer player = getDealPlayerByID(playerID);
		
		HandCards playerHand = player.getHandcards();
		GroupCards grp = (GroupCards) playerHand.getGroups().get(0);
		
		return grp.getCard();
	}
	
//	public EList<EObject> getPlayerCards(long playerID, int group)
//	{
//		DealPlayer player = getDealPlayerByID(playerID);
//		
//		HandCards playerHand = player.getHandcards();
//		GroupCards grp = (GroupCards) playerHand.getGroups().get(group);
//		
//		return grp.getCard();
//	}
	
	public DealPlayer getDealPlayerByID(long playerID)
	{
		EList<EObject> dealPlayers = getDeal().getDealplayer();
		
		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			
			if(dealPlayer.getId() == playerID)
			{
				return dealPlayer;
			}
		}
		
		Log.logger.debug("Deal Player Not FOUND " );
		return null;
	}
	
	public boolean isDealPlayer(long playerID)
	{
		Deal deal = getDeal();
		EList<EObject> players = deal.getDealplayer();
		
		for(EObject obj : players)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			if(dealPlayer.getId() == playerID && dealPlayer.isPlaying())
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isPlayersTurn(long playerID)
	{
		if(getDeal().getCurrentTurn() == getPlayerSeatID(playerID))
		{
			return true;
		}
		
		return false;
	}
	
	public void dropPlayer(long playerID)
	{
		DealPlayer player = getDealPlayerByID(playerID);
		player.updateState(DealPlayer.DROPPED);
	}
	
	public EList<EObject> getClosedDeck()
	{
		Deal deal = getDeal();
		
		CardContainer closedDeckContainer = (CardContainer) deal.getCloseddeck();
		EList<EObject> closedDeck = closedDeckContainer.getCard();
			
		return closedDeck;
	}
	
	public EList<EObject> getOpenDeck()
	{
		Deal deal = getDeal();
		
		CardContainer openDeckContainer = (CardContainer) deal.getOpendeck();
		EList<EObject> openDeck = openDeckContainer.getCard();
			
		return openDeck;
	}
	
	public void addToOpenDeck(Card discardedCard)
	{
		EList<EObject> openDeck = getOpenDeck();
		openDeck.add(discardedCard);
	}
	
	public Card removeCardFromPlayerHand(long playerID, Card card)
	{
		Log.logger.debug("Card to remove for player " + playerID + " is " + card);
		DealPlayer player = getDealPlayerByID(playerID);
		EList<EObject> listCards = ((HandCards)player.getHandcards()).getGroupByIndex(0).getCard();
	
		/**
		 * Find the card with the same value in the playerCards list and then remove it.
		 */
		return ModelUtils.removeCardFromList(listCards, card);
	
	}
	
	public Card getCardFromClosedDeck()
	{
		EList<EObject> closedDeck = getClosedDeck();
		
		if(closedDeck.size() > 0)
		{
			Card topCard = getTopCard(closedDeck);
			
			// check if deck is over
			if(closedDeck.size() == 0)
			{
				getServerResponseManager().sendDeckOver();
			}
			
			return topCard;
		}
		
		return null;
	}
	
	/**
	 * Add all the opendeck cards to closed deck, barring the last discard.
	 * The last discard should be retained in the open deck.
	 */
	public void shuffleOpenDeck()
	{
		EList<EObject> listOpenDeckCards   = getOpenDeck();
		EList<EObject> listClosedDeckCards = getClosedDeck();
		Card           lastDiscard         = (Card) listOpenDeckCards.remove(listOpenDeckCards.size() - 1);

		listClosedDeckCards.addAll(listOpenDeckCards);
		listOpenDeckCards.clear();
		
		// add back the last discarded card
		listOpenDeckCards.add(lastDiscard);
		
		//Shuffle closed deck now
		ClosedDeck cldeck = (ClosedDeck)getDeal().getCloseddeck();
		cldeck.shuffle();
	}
	
	public Card getCardFromOpenDeck()
	{
		Deal deal = getDeal();
		
		CardContainer openDeck = (CardContainer) deal.getCloseddeck();
		EList<EObject> openDeckCards = openDeck.getCard();
		
		if(openDeckCards.size() > 0)
		{
			// remove last card from deck now
			Card lastDiscardedCard = (Card) openDeckCards.remove(openDeckCards.size() - 1);
			
			return lastDiscardedCard;
		}
		else
		{
			return null;
		}
	}
	
	public Card getLastDiscardedCard()
	{
		Deal deal = getDeal();
		
		CardContainer openDeck = (CardContainer) deal.getCloseddeck();
		EList<EObject> openDeckCards = openDeck.getCard();
		
		if(openDeckCards.size() > 0)
		{
			Card lastDiscardedCard = (Card) openDeckCards.get(openDeckCards.size() - 1);
			
			return lastDiscardedCard;
		}
		else
		{
			return null;
		}
	}
	
	public Card getTopCard(EList<EObject> deck)
	{
		// remove top card from deck now
		Card topCardOnDeck = (Card) deck.remove(0);
		
		return topCardOnDeck;
	}
	
	public int getPlayerHandCardCount(long playerID)
	{
		DealPlayer player = getDealPlayerByID(playerID);
		
		HandCards playerHand = player.getHandcards();
		EList<EObject> groups = ((HandCards) playerHand).getGroups();
		
		int cardsCount = 0;
		for(EObject obj : groups)
		{
			GroupCards group = (GroupCards) (obj);
			
			cardsCount += group.getCard().size();
		}
		
		return cardsCount;
	}
	
	public void addCardToPlayerHand(Card card, long playerID)
	{
		DealPlayer dealPlayer = getDealPlayerByID(playerID);
		dealPlayer.addCard(card);
		
		if(dealPlayer.getType() == PlayerType.BOT)
		{
			this.getBotPlayerAdapter(dealPlayer).receivePickedCard(card);
		}
	}
	
	public int getPlayersLeftInDeal()
	{
		EList<EObject> playersInDeal = getDeal().getDealplayer();
		
		int count = 0;
		for(EObject obj : playersInDeal)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			if(dealPlayer.isPlaying() == true)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public DealPlayer getLastPlayerLeftInDeal()
	{
		EList<EObject> playersInDeal = getDeal().getDealplayer();
		
		int count = 0;
		for(EObject obj : playersInDeal)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			if(dealPlayer.isPlaying() == true)
			{
				count++;
			}
		}
		
		if(count == 1)
		{
			return (DealPlayer) playersInDeal.get(0);
		}
		
		return null;
	}
		
	public Player getPlayerAtSeat(int seatID)
	{
		Game game = getDeal().getMatch().getGame();

		// iterate through seat list 
		EList<EObject> seats = game.getSeat();
				
		for(EObject obj : seats)
		{
			Seat seat = (Seat) obj;
			
			if(seat.getSeatId() == seatID)
			{
				return (Player) seat.getPlayer();
			}
		}
		
		return null;
	}
	
	public int getPlayerSeatID(long playerID)
	{
		Game game = getDeal().getMatch().getGame();

		// iterate through seat list 
		EList<EObject> seats = game.getSeat();
				
		for(EObject seat : seats)
		{
			synchronized (seat) 
			{
				Seat seatObject = (Seat) seat;
				Player player = (Player) seatObject.getPlayer();
				if(player != null && (player.getId() == playerID))
				{
					return seatObject.getSeatId();
				}
			}
		}
		
		return -1;
	}
	
	public int getNextTurn()
	{
		int currentTurn = getDeal().getCurrentTurn();
		
		int nextTurn = getNextOccupiedSeat(currentTurn).getSeatId();
		
		getDeal().setCurrentTurn(nextTurn);
		
		return nextTurn;
	}
	
	public DealPlayer getCurrentPlayer()
	{
		int currentTurn = getDeal().getCurrentTurn();
		return getDealPlayerByID(getPlayerAtSeat(currentTurn).getId()); 
	}
		
	public Seat getNextOccupiedSeat(int currentSeatID)
    {
		Deal deal = getDeal();
		Game game = deal.getMatch().getGame();
		EList<EObject> listSeats = game.getSeat();
		int nextSeatID = currentSeatID + 1;
		
		//Check if this player is a deal player or not. If not, find the next occupied player, or till all the seats
		//are iterated.
		  /**
		  * Run a circular check starting with the next-seat and reaching it back in circular iteration.
		  */
	    for(int i=0; i<listSeats.size(); i++)
		{
	    	if(nextSeatID == listSeats.size())
	    	{
	    		nextSeatID = 0;
	    	}
	    	
	    	Seat seat = (Seat) listSeats.get(nextSeatID);
	    	
	    	if(seat.getPlayer() != null)
	    	{
	    		Player gamePlyr = (Player)seat.getPlayer();
	    		
	    		// Check if the player is a deal player too
	    		if(deal.getPlayerById(gamePlyr.getId()) != null)
	    		{
	    			return seat;
	    		}
	    	}
	    	
	    	nextSeatID++;
		}
	    
	    /** This should not happen, but the caller should catch and take corrective action */
	    
	    return null;
    }
	
	public void updatePlayerScore(long playerID, int score)
	{
		DealPlayer dealPlayer = getDealPlayerByID(playerID);
		
		Score dealScore = (Score) getModelFactory().createObject(Score.class);
		dealScore.setDealnum(getDeal().getDealNumber());
		dealScore.setScore(score);
		
		dealPlayer.setScore(dealScore);
	}
	
	private List<ShowSlot> getHandCardsInSlots(HandCards cards, long playerID)
	{
		EList<EObject> groups = cards.getGroups();
		List<ShowSlot> slots = new ArrayList<ShowSlot>();
		
		int id = 0;
		Log.logger.debug("Number of groups for player: " + playerID + " is " + groups.size());
		for(EObject group : groups)
		{
			id++; 
			
			// for each group, get slot
			CardContainer groupCardContainer = (CardContainer) group;
			EList<EObject> groupCards = groupCardContainer.getCard();
			
			ShowSlot slot = getShowSlot(id, groupCards, playerID);
			Log.logger.debug("Adding slot for player: " + playerID + " slot " + slot);
			if(slot != null)
			{
				Log.logger.debug("Actually Adding slot for player: " + playerID + " slot " + slot);
				slots.add(slot);
			}
			else
			{
				//TODO: send cheat card detected response
			}
		}
		
		return slots;
	}
	
	public int scanSlots(long playerID, HandCards cards, boolean showInit)
	{
		int score = 0;
		ShowSlotAttribute attrib = new ShowSlotAttribute();
		
		Card openJoker = (Card) getDeal().getJoker();
		List<ShowSlot> slots = getHandCardsInSlots(cards, playerID);
		
		score = CardCore.ScanSlots(slots, openJoker, attrib, getModelFactory());
		
		Log.logger.debug(" SCORE " + score + " for Player " + playerID);
		
		if(score > 80) score = 80;
	
		for(ShowSlot slot : slots)
		{
			if(slot.Type == ShowSlot.ESeqType.INVALID)
			{
				if(showInit)
				{
					score = 80;
				}
				
				updatePlayerScore(playerID, score);
				slots.clear();
			
				return score;
			}
		}
		
		if(!attrib.FoundPureRun || !attrib.MandatoryCheckMet)
		{
			// invalid sequence, calculate points, if greater than 80 return 80
			score = 80;
			updatePlayerScore(playerID, score);						
		}
		else
		{
			updatePlayerScore(playerID, score);
			
			// check for highlights in win
			checkForHighlights(playerID, slots, attrib.SequenceCount, attrib.SetCount, attrib.NumberOfJokers);
		}
		
		// empty the SlotsArray before returning
		slots.clear();
		
		return score;
	}

	public void setPlayerDoneWithShow(long playerID)
	{
		DealPlayer dealPlayer = getDealPlayerByID(playerID);
		
		dealPlayer.updateState(DealPlayer.DONE_WITH_SHOW);
	}
	
	public boolean isEveryoneDoneWithShow()
	{
		EList<EObject> dealPlayers = getDeal().getDealplayer();
		
		for(EObject obj : dealPlayers)
		{
			DealPlayer player = (DealPlayer) obj;
			
			if(false == player.isDoneWithShow())
			{
				return false;
			}
		}
		
		return true;
	}
	
	public ShowSlot getShowSlot(int id, EList<EObject> cards, long playerID)
	{
		ShowSlot slot = new ShowSlot();
		slot.ID = id;
		
		Log.logger.debug("Slot.ID" + id);
		
		// read slots
		for(EObject obj : cards)
		{
			Card card = (Card) obj;
			
			if(card == null)
			{
				Log.logger.debug("Card object is nULLL");
			}
			else
			{
				Log.logger.debug("+" + card);
			}
			
			if(isCheatCard(card, playerID))
			{
				Log.logger.debug("Cheat Card detected!!!");
				return null;
			}
			
			slot.Sequence.add(card);		
		}
		
		slot.Type = ShowSlot.ESeqType.NOT_SCANNED;
		
		return slot;
	}
	
	public void setDropPenaltyForPlayer(long playerID)
	{
		DealPlayer dealPlayer = getDealPlayerByID(playerID);
		
		Game game = getDeal().getMatch().getGame();
		int maxScore = game.getMaxScore();
		
		int score = 80;
		
		if(dealPlayer.hasPickedACard() == false)
		{
			switch(maxScore)
			{
			case 101:
				score = 20;
				break;
			case 201:
				score = 25;
				break;
			case 301:
				score = 30;
				break;
			}
		}
		else
		{
			switch(maxScore)
			{
			case 101:
				score = 40;
				break;
			case 201:
				score = 50;
				break;
			case 301:
				score = 60;
				break;
			}
		}
		
		Score dealPlayerScore = dealPlayer.getScore();
		dealPlayerScore.setScore(score);
		dealPlayer.setScore(dealPlayerScore);
	}
	
	public void addAllPlayerCardsToClosedDeck(long playerID)
	{
		EList<EObject> playerCards = getPlayerCards(playerID);
		
		EList<EObject> closedDeckCards = getClosedDeck();
		
		closedDeckCards.addAll(playerCards);
	}
	
	private void checkForHighlights(long playerID, List<ShowSlot> slots,
			int sequenceCount, int sets, int numberOfJokers)
	{
		DealPlayer player = getDealPlayerByID(playerID);
		
		if(sequenceCount == 4)
		{
			player.getHighLights().add(WinHighlight.FOUR_SEQUENCES);
		}
		if(numberOfJokers == 3)
		{
			player.getHighLights().add(WinHighlight.THREE_JOKERS);			
		}
		if(sets == 2)
		{
			player.getHighLights().add(WinHighlight.TWO_SETS);
		}
		
		for(ShowSlot slot : slots)
		{
			if(slot.Luck == ELuck.FOUR_ACES)
			{
				player.getHighLights().add(WinHighlight.FOUR_ACES);
			}
			
			if(slot.Luck == ELuck.THREE_KINGS)
			{
				player.getHighLights().add(WinHighlight.THREE_KINGS);

			}
			if(slot.Luck == ELuck.THREE_QUEENS)
			{
				player.getHighLights().add(WinHighlight.THREE_QUEENS);
			}
		}
	}
	
	public long getShowInitiator()
	{
		return getDeal().getShowInitiator();
	}
	
	public void cleanup()
	{
		getClosedDeck().clear();
		getOpenDeck().clear();
		getDeal().setJoker(null);
		
		getDeal().getDealplayer().clear();		
		
		getDeal().setShowInitiator(0);
	}
	
	public BotPlayerAdapter getBotPlayerAdapter(DealPlayer dealPlayer)
	{
		Player botPlayer = getBotPlayerInstance(dealPlayer);

		if(botPlayer != null)
		{
			BotPlayerAdapter botAdapter = (BotPlayerAdapter) EcoreUtil.getRegisteredAdapter(botPlayer, botPlayer);
			Log.logger.debug(" Bot Player Adapter " + botAdapter);
			
			return botAdapter;
		}
		
		Log.logger.debug("?????????????Bot ADAPTER IS NULL");

		return null;
	}
	
	private Player getBotPlayerInstance(DealPlayer dealPlayer)
	{
		Game game = getDeal().getMatch().getGame();
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter(game, game);
		
		if(gameAdapter != null)
		{
			Player player = gameAdapter.getPlayerByID(dealPlayer.getId());
			if(player instanceof BotPlayer)
			{
				return player;
			}
		}
		
		Log.logger.debug("?????????????Bot player INstance is NULL");
		
		return null;
	}
	
	@Override
	//Get it from GameAdapter which is a parent of parent of deal
	public IModelCreationFactory getModelFactory() 
	{
		Game game = getDeal().getMatch().getGame();
		IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(game, game);
		
		if(adapter != null)
		{
			return adapter.getModelFactory();
		}
	   
	   return null;
	}
	
	public ITimerScheduler getTableScheduler()
	{
		return getGameAdapter().getTableScheduler();
	}

	@Override
	public ServerResponseManager getServerResponseManager() 
	{
		return getGameAdapter().getServerResponseManager();
	}

	@Override
	public ITimerScheduler getTimerScheduler() 
	{
		return getGameAdapter().getTimerScheduler();
	}
	
	@Override
	public IStateChanger getStateChanger()
	{
		return _stateHolder;
	}

	public Deal getDeal()
	{
		return (Deal)getTarget();
	}
	
	//Demonstrates how you can get a GameAdapter from this class
	protected AbstractGameAdapter getGameAdapter()
	{
		Match match = getDeal().getMatch();
		Game game = match.getGame();
		
		AbstractGameAdapter adapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter( game, game);
		
		return adapter;
	}

	@Override
	public EventHandlerMap getEventHandlerMap()
	{
		return getGameAdapter().getEventHandlerMap();
	}


	@Override
	public void setEventHandlerMap(EventHandlerMap eventHandlerMap) 
	{
		getGameAdapter().setEventHandlerMap(eventHandlerMap);
	}
}
