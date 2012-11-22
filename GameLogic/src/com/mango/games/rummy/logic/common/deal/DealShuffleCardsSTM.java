package com.mango.games.rummy.logic.common.deal;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

public class DealShuffleCardsSTM extends AbstractSTM 
{
	public DealShuffleCardsSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	/**State Change - Schedule timeout to DealPlayingSTM
	 * - shuffle and deal the cards
	 * - send ready and table bet.
	 */
	public void enterState() 
	{
		// Deal - Deal cards, and distributecards to the players
        getDealAdapter().shuffleAndDeal();
        
        ServerResponseManager serverResponseManager = getClientAdapter().getServerResponseManager();
        
        serverResponseManager.sendReady();        
        serverResponseManager.sendTableBet(getDealAdapter().getDeal().getMatch().getGame().getPotValue());
 
		long timeout = TimeoutConstants.START_SHUFFLE_ANIMATION; 
		
        log.info("Entered SHUFFLE_ANIMATION. Scheduling timeout in " + timeout + " millis.");

        getClientAdapter().getTimerScheduler().scheduleTimeout(timeout, TableScheduler.SHUFFLE);
   	}
	
	/**State Change - DealPlayingSTM
	 * send getsetgo to client 
	 */
	public int timeout(TimedAction action)
	{
		getClientAdapter().getServerResponseManager().sendGetSetGo();
		
 		this.changeState(new DealPlayingSTM(this.stateChanger));
 		
 		return ActionConstants.ActionProcessed;
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
	
	private DealAdapter getDealAdapter()
	{
		return (DealAdapter)getClientAdapter();
	}
	
	public void exitState()
	{
	}
}
