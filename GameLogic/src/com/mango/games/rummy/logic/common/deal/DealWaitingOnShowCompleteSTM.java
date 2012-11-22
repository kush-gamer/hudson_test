package com.mango.games.rummy.logic.common.deal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import com.mango.games.rummy.bot.BotPlayerAdapter;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;

import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.HandCards;


public class DealWaitingOnShowCompleteSTM extends AbstractSTM 
{
	public DealWaitingOnShowCompleteSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
		
		processBotShow();
	}
	
	public void enterState() 
	{
		long timeout = TimeoutConstants.SHOW_TIME_OUT;
		
        log.info("Entered waiting on show. Scheduling timeout in " + timeout + " millis.");
		
        getClientAdapter().getTimerScheduler().scheduleTimeout(timeout, TableScheduler.SHOW);
	}
	
	public void exitState()
	{
		//TODO: do all cleanup
	}
	
	public void timeout()
	{
		// send time out, 
		this.changeState(new DealEndedSTM(this.stateChanger));
	}
	
	public int declareCards(long playerID, HandCards cards, Card discardedCard)
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();

		// get score 
		
		// this returns score
		dealAdapter.scanSlots(playerID, cards, false);
		
		// send player done with show
		sendPlayerDoneWithShow();
		
		// update player's state
		dealAdapter.setPlayerDoneWithShow(playerID);
		
		// is everyone done with show
		if(dealAdapter.isEveryoneDoneWithShow())
		{
			Log.logger.debug("Everyone done with Show... Changing State");
			this.changeState(new DealEndedSTM(this.stateChanger));
		}
		
		return 1;
	}
	
	private void processBotShow()
	{
		DealAdapter dealAdapter = (DealAdapter) this.getClientAdapter();

		EList<EObject> dealPlayers = dealAdapter.getDeal().getDealplayer();
		
		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) (obj);
			
			BotPlayerAdapter botPlayerAdapter = dealAdapter.getBotPlayerAdapter(dealPlayer);
			if(botPlayerAdapter != null)
			{
				botPlayerAdapter.declareCards(false);
			}
		}
	}
	
	public int userDisconnected(long playerID)
	{
		//TODO:
		return 1;
	}
	
	public int toLobby(long playerID)
	{
		// TODO:
		return 1;
	}
	
	private void sendPlayerDoneWithShow()
	{
		
	}
}
