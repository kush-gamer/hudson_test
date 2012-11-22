package com.mango.games.rummy.logic.common.deal;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.HandCards;

public class DealShowInitSTM extends AbstractSTM 
{
	private long _showInitiatorID;
	
	public long getShowInitiator()
	{
		return _showInitiatorID;
	}
	
	public void setShowInitiator(long showInitiator)
	{
		_showInitiatorID = showInitiator;
	}
	
	public DealShowInitSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	public void enterState() 
	{
		long timeout = TimeoutConstants.SHOW_INIT_TIME_OUT;
		
        log.info("Entered show init. Scheduling timeout in " + timeout + " millis.");
		
        getClientAdapter().getTimerScheduler().scheduleTimeout(timeout, TableScheduler.SHOW_INIT);
	}
	
	public void exitState()
	{
		
	}
	
	public void timeout()
	{
		sendShowInitTimeout();

		this.changeState(new DealWaitingOnShowCompleteSTM(this.stateChanger));
	}
	
	public int declareCards(long playerID, HandCards cards, Card discardedCard)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		// get score
		int score = dealAdapter.scanSlots(playerID, cards, true);
		if(score > 0)
		{
			// middle drop
			// broadcast that the show failed... and return from here.
			sendShowFailed(playerID, discardedCard);
			
			return 1;
		}
		
		sendValidShow(playerID, discardedCard);
		
		return 1;
	}
	
	public int userDisconnected(long playerID)
	{
		//TODO:
		return 1;
	}
	
	public int toLobby(long playerID)
	{
		//TODO:
		
		return 1;
	}
	
	private void sendValidShow(long playerID, Card discardedCard)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		dealAdapter.setPlayerDoneWithShow(playerID);
		
		// send valid show, cleanup for this player, remove this player from deal
		dealAdapter.getServerResponseManager().sendValidShow(playerID, discardedCard);
		
		// change state to DealWaitingOnShowComplete
		this.changeState(new DealWaitingOnShowCompleteSTM(this.stateChanger));
	}
	
	private void sendShowFailed(long playerID, Card discardedCard)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		
		// send show failed, cleanup for this player, remove this player from deal
		dealAdapter.getServerResponseManager().sendShowFailed(playerID);
		
		dealAdapter.dropPlayer(playerID);
		
		// change state to deal end if dealplayers == 1
		if(dealAdapter.getPlayersLeftInDeal() == 1)
		{
			this.changeState(new DealEndedSTM(this.stateChanger));
		}
		else 
		{
			dealAdapter.getServerResponseManager().sendTurnOver(discardedCard, dealAdapter.getNextTurn(), false);
			
			// add this card to open deck 
			dealAdapter.addToOpenDeck(discardedCard);
			
			this.changeState(new DealPlayingSTM(this.stateChanger));
		}
	}
	
	//TODO: confirm
	private void sendShowInitTimeout()
	{
		// send show init timeout
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();
		dealAdapter.getServerResponseManager().sendShowInitTimeOut(dealAdapter.getShowInitiator());
		
		// read groups in player's hand, validate
	}
}
