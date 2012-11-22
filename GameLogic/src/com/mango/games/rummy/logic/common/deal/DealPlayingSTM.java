package com.mango.games.rummy.logic.common.deal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.PickActionConstants;
import com.mango.games.rummy.utils.PlayerType;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Score;

public class DealPlayingSTM extends AbstractSTM 
{
	public DealPlayingSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}
	
	public void enterState()
	{
		startTicking();
	}
	
	private void startTicking()
	{
		long timeout = TimeoutConstants.TURN_TIME_OUT;
        int currentTurn = getDeal().getCurrentTurn();
		DealPlayer player = getWhoseTurn(currentTurn);
		
		//System.out.println("current turn -" + currentTurn);
		//System.out.println("DealAdapter.startTicking for " + player.getId() + ". Time:" +  System.currentTimeMillis());
		Log.logger.debug("^^^^^^^^^^^^^^^^^^^^^^^Starting to Tick ^^^^^^^^^^^^^^^^^^^^^^^^" + player.getId());
        
        processBotTurn();
		
        getClientAdapter().getTimerScheduler().schedulePlayerTimeout(timeout, player.getId(), TableScheduler.TURN);
	}
	
	
	@Override
	public int timeout(TimedAction action)
	{
		Log.logger.debug("^^^^^^^^^^^^^^^^^^^^^^^Turn Time Out^^^^^^^^^^^^^^^^^^^^^^^^" + action.getSeq());
		
		//System.out.println("DealPlayingSTM:Timeout - Playerid:" + action.getPlayerTurnId() + " Time:" + System.currentTimeMillis());
		/**
		 * The timed action is expected to be a Playertimeout action. 
		 * Any other action should be ignored.
		 */
		if(action.getPlayerTurnId() == 0)
		{
			Log.logger.debug("Returned Zero, not player Turn ID");
			return 0;
		}
		
		//Also make sure this is indeed the players turn
		int currentTurn = getDeal().getCurrentTurn();
		DealPlayer player = getWhoseTurn(currentTurn);
		Log.logger.debug("Player Turn ID is " + action.getPlayerTurnId());
		Log.logger.debug("Player ID is " + player.getId());
		
		if(player != null && (action.getPlayerTurnId() != player.getId()))
		{
			Log.logger.debug("Returned Zero, not player Turn");
			return 0;
		}
		
		// set missed turn count
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();		
		DealPlayer dealPlayer = dealAdapter.getDealPlayerByID(player.getId());
		dealPlayer.setMissedTurnCount(dealPlayer.getMissedTurnCount() + 1);

	     // check if the player missed the turn 3 consecutive times
		if(player.getMissedTurnCount() == 3)
		{
			// drop player
			dropPlayer(player.getId());
		}
			
		// pick a card from closed deck and discard
		playAuto(player.getId());
			
		return 1;
	}
	
	public void exitState()
	{
	}
	
	/**
	 * 
	 *  State Change - None
	 *  - get picked card from opendeck, closeddeck depending on pickedFrom
	 *  - reset missed turn count
	 *  - send pick error if couldn't get the card, player already has more than 13 cards
		- send turn over
	 */	
	public int cardPicked(long playerID, int pickedFrom)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();		
	
		if(dealAdapter.getPlayerHandCardCount(playerID) > 13 || false == dealAdapter.isPlayersTurn(playerID))
		{
			Log.logger.debug("PICK ERROR ");
			dealAdapter.getServerResponseManager().sendPickError(playerID);
			return 1;
		}
		
		DealPlayer dealPlayer = dealAdapter.getDealPlayerByID(playerID); 
		dealPlayer.setMissedTurnCount(0);
		
		Card cardPicked = getPickedCard(pickedFrom);
		
		if(cardPicked == null)
		{
			Log.logger.debug("PICK ERROR 2");

			dealAdapter.getServerResponseManager().sendPickError(playerID);
			return 1;
		}
		else
		{
			// add this card to players'cards
			dealAdapter.addCardToPlayerHand(cardPicked, playerID);
		}
		
		if(pickedFrom == PickActionConstants.PICKED_FROM_CLOSED_DECK)
		{
			Log.logger.debug("PICKED CARD FROMCLOSEDDECK " + playerID  + " " + cardPicked);

			dealAdapter.getServerResponseManager().sendNewCardReceived(playerID, pickedFrom, cardPicked);
		}
		else if(pickedFrom == PickActionConstants.PICKED_FROM_OPEN_DECK)
		{
			Log.logger.debug("PLAYER PICKED_FROM_OPEN_DECK " + cardPicked);

			dealAdapter.getServerResponseManager().sendPlayerPickedCard(playerID, pickedFrom, cardPicked, 
					dealAdapter.getLastDiscardedCard());
		}
		
		if(dealPlayer.hasPickedACard() == false)
		{
			dealPlayer.updateState(DealPlayer.PICKED);
		}

	    if(dealAdapter.getClosedDeck().size() == 0)
		{
			dealAdapter.getServerResponseManager().sendShuffleOpenDeck();
			dealAdapter.shuffleOpenDeck();
		}
		
		return 1;
	}
	/* 
	 *  State Change - None
	 * (non-Javadoc)
	 * 
	 *  * @see com.mango.games.rummy.logic.actions.RummyActions#cardDiscarded(java.lang.String)
	 */	
	/*
	 *  0. send shuffle open deck if the closed deck is over
	 *  1. add to the discarded card list
	 *  2. delete discarded card from player's card
		3. send turn over
	 */	
	public int cardDiscarded(long playerID, Card discardedCard)
	{
		//System.out.println("DealPlayingSTM:cardDiscarded - playerId -" + playerID);
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();		

		if(false == dealAdapter.isPlayersTurn(playerID))
		{
			Log.logger.debug("DISCARD ERROR " );
			
			this.getClientAdapter().getServerResponseManager().sendDiscardError(playerID);
			return 1;
		}
		
		processCardDiscarded(playerID, discardedCard, false);
		
		return 1;
	}
	
	/* 
	 *  State Change - DealShowInitSTM
	 * (non-Javadoc)
	 * 
	 *  * @see com.mango.games.rummy.logic.actions.RummyActions#showInitiated(java.lang.String)
	 */	
	public int showInitiated(long playerID)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();		

		int seatID = dealAdapter.getPlayerSeatID(playerID);
		
		if(seatID != -1)
		{
			dealAdapter.getServerResponseManager().sendShowInitiated(playerID);
		}
		else
		{
			dealAdapter.getServerResponseManager().sendShowInitiatedError(playerID);
		}
		
		// change state
		changeState(new DealShowInitSTM(this.stateChanger));
		
		return 1;
	}
	
	public int dropMe(long playerID)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		if(false == dealAdapter.isPlayersTurn(playerID))
		{
			Log.logger.debug("DROP ERROR " );
			
			// TODO: send server response			
			return 1;
		}

		dropPlayer(playerID);
		
		return 1;
	}

	/**
	 * Find the given card in the player hand cards and remove it.
	 * Note that the findCard instance will not be in the hand cards. The corresponding instance
	 * with the same rank/suite needs to be found and removed.
	 * This can be called from both the player discard event, and from the auto-discard event.
	 * Hence it is seprated out as a functional block
	 * @param playerID
	 * @param findCard
	 * @param wasTurnMissed
	 */
	private void processCardDiscarded(long playerID, Card findCard, boolean wasTurnMissed)
    {
		Card removedCard = null; //Instance of the card removed from player handcards
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		//System.out.println("DealPlayingSTM:processCardDiscarded playerid -" + playerID);
        /**
           * If there is an attempt to cheat, then just send a cheat message to the player
           * and return. The timer will take care of autodiscard.
           */
		if(dealAdapter.isCheatCard(findCard, playerID) && wasTurnMissed == false)
		{
			// send cheat
			this.getClientAdapter().getServerResponseManager().sendCheatCard(playerID);
			 Log.logger.debug("CHEAT CARD>>>>>>>");
			return;
		}
		
		/**
          * Cancel the player timeout scheduled for pick/discard cards.*/
		
		clearPlayerTimeout(playerID);
		removedCard = dealAdapter.removeCardFromPlayerHand(playerID, findCard);
		Log.logger.debug("Removed card for player " + playerID + " is " + removedCard);
		if(removedCard == null)
		{
			Log.logger.debug("Couldn't get card to be removed ");
		}
		
		assert(removedCard != null);
		
		//	Add the removedCard instance to the open deck. Note that the findCard instance is a transient card.
		if(removedCard != null)
		{
			dealAdapter.addToOpenDeck(removedCard);
		}
		
		int nextTurn = turnOver();
		
		Log.logger.debug("///////////////PLAYER DISCARDED Card. turn over ///////////////////////" + playerID + " " + findCard);
		
		dealAdapter.getServerResponseManager().sendTurnOver(findCard, nextTurn, wasTurnMissed);
		
		startTicking();
    }
	
	private void processBotTurn()
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		Log.logger.debug("Player whose turn  " + dealAdapter.getCurrentPlayer().getId());
		
		if(dealAdapter.getCurrentPlayer().getType() == PlayerType.BOT)
		{
			Log.logger.debug("BOT TYPE " + dealAdapter.getCurrentPlayer().getId());
			
			BotPlayerAdapter botPlayerAdapter = dealAdapter.getBotPlayerAdapter(dealAdapter.getCurrentPlayer()); 
		
			if(botPlayerAdapter != null)
			{
				botPlayerAdapter.playTurn();
			}
			else
			{
				Log.logger.debug(dealAdapter.getCurrentPlayer().getClass() + " not found");
			}
		}

//		else
//		{
//			Log.logger.debug("NOOOOT BOT TYPE " + dealAdapter.getCurrentPlayer().getId());
//		}
	}
	
	public int userDisconnected(long playerID)
	{
		clearPlayerTimeout(playerID);
		handleUserGone(playerID);
		
		return 1;
	}
	
	public int toLobby(long playerID)
	{
		clearPlayerTimeout(playerID);
		
		handleUserGone(playerID);

		return 1;
	}
	
	private void handleUserGone(long playerID)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();		
		
		// set the state for this player as disconnected
		DealPlayer dealPlayer = dealAdapter.getDealPlayerByID(playerID);		
		
		// TODO identify quit to lobby and disconnected
		dealPlayer.updateState(DealPlayer.LOST_GAME); // TODO: is disconnected, right now changing it to lost.
		
		// check how many are left, if only one left, declare default winner for that game
		if(dealAdapter.getPlayersLeftInDeal() == 1)
		{
			endDealDeclareDefaultWinner();
		}
		else
		{
			// else play auto
			playAuto(playerID);
		}
	}
	
	private DealPlayer getWhoseTurn(int turn)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		Player player = dealAdapter.getPlayerAtSeat(turn); 
		if(player != null)
		{
			DealPlayer dealPlayer = dealAdapter.getDealPlayerByID(player.getId());
			return dealPlayer;
		}
		
		return null;
	}
	
	private void playAuto(long playerID)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		// check if the player had picked a card, discard the last card from player hand
		EList<EObject> playerCards = dealAdapter.getPlayerCards(playerID); 
		Log.logger.debug("Inside Play Auto for player " + playerID);
		int cardsSize = playerCards.size();
		if(cardsSize == 14)
		{
			Log.logger.debug("If block, Number of cards for player " + playerID + " is " + cardsSize);
			Card lastPickedCard = (Card) playerCards.get(cardsSize - 1);
			
			processCardDiscarded(playerID, lastPickedCard, true); 
		}
		else
		{
			Log.logger.debug("Else block, Number of cards for player " + playerID + " is " + cardsSize);
			Card topCardFromClosedDeck = getPickedCard(PickActionConstants.PICKED_FROM_CLOSED_DECK);

			Log.logger.debug("Picked Card: " + topCardFromClosedDeck);
			
			clearPlayerTimeout(playerID);

			//	Add the removedCard instance to the open deck. Note that the findCard instance is a transient card.
			if(topCardFromClosedDeck != null)
			{
				dealAdapter.addToOpenDeck(topCardFromClosedDeck);
			}
			
			int nextTurn = turnOver();
			
			Log.logger.debug("Next Turn is " + dealAdapter.getPlayerAtSeat(nextTurn));
			dealAdapter.getServerResponseManager().sendTurnOver(topCardFromClosedDeck, nextTurn, true);
			
			startTicking();
		} 
	}
	
	private void dropPlayer(long playerID)
	{
		clearPlayerTimeout(playerID);
		
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		// set the state for this player as dropped
		DealPlayer dealPlayer = dealAdapter.getDealPlayerByID(playerID);		
		dealPlayer.updateState(DealPlayer.DROPPED);
		
		dealAdapter.setDropPenaltyForPlayer(playerID);
		
		// check how many are left, if only one left, declare default winner for that game
		if(dealAdapter.getPlayersLeftInDeal() == 1)
		{
			endDealDeclareDefaultWinner();
		}
		else
		{
			// else play auto
			playAuto(playerID);
		}
	}
	
	private void endDealDeclareDefaultWinner()
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
	
		DealPlayer winner = dealAdapter.getLastPlayerLeftInDeal();
		
		if(winner != null)
		{
			Score score = winner.getScore();
			score.setScore(0);
			winner.setScore(score);
		}

		this.getClientAdapter().getServerResponseManager().sendDefaultWinner(winner.getId());
		
		this.changeState(new DealEndedSTM(this.getClientAdapter().getStateChanger()));;
	}
	
	private int turnOver()
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		int currentTurn = getDeal().getCurrentTurn();
		
		int nextTurn = dealAdapter.getNextOccupiedSeat(currentTurn).getSeatId();
		
		getDeal().setCurrentTurn(nextTurn);
		
		return nextTurn;
	}
	
	private Card getPickedCard(int pickedFrom)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		if(pickedFrom == PickActionConstants.PICKED_FROM_CLOSED_DECK)
		{
			return dealAdapter.getCardFromClosedDeck();
		}
		
		else if(pickedFrom == PickActionConstants.PICKED_FROM_OPEN_DECK)
		{
			return dealAdapter.getCardFromOpenDeck();
		}
		
		return null;
	}
	
	private void clearPlayerTimeout(long plrId)
	{
		getClientAdapter().getTimerScheduler().clearTimeout(plrId);
	}
	
	private Deal getDeal()
	{
		return (Deal) this.getClientAdapter().getTarget();
	}
}
