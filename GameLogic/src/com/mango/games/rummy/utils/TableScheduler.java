package com.mango.games.rummy.utils;

import java.util.concurrent.ScheduledFuture;

import org.eclipse.emf.common.notify.Adapter;

import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ITimerCallable;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.logic.common.timers.Trigger;
import com.mango.games.rummy.logic.common.timers.TriggerType;
import com.mangogames.rummy.model.Game;

/**
 * One instance per Game. This will keep a cache of scheduled actions and their keys so that the actions
 * can be cancelled or triggerred. 
 * @author Sanjeev
 *
 */
public class TableScheduler implements ITimerScheduler
{
	private   TimeoutCache timeoutCache;
    private   ITimerCallable callbackAdapter;
    
	public TableScheduler(ITimerCallable adaptr) 
	{
		
		timeoutCache = new TimeoutCache();
		this.callbackAdapter = adaptr;
	}
	
	/** 
	 * This is a non-cancellable scheduled action. 
	 * A GameAction type is created in this method. This GameAction is a generic action, that makes the Game 
	 * move to the next state. For example, if the Game is waitingtostartSTM, then it will move to the next state
	 * in response to this action.
	 * @param millis
	 */
	public void scheduleTimeout(long millis, int seq) 
	{
		TimedAction action = new TimedAction(callbackAdapter); 
        TriggerType type = TriggerType.TIMEOUT;
        Trigger timeout = new Trigger(type);
        timeout.setSeq(seq);
       
        action.setAttachment(timeout);
        
        //Schedule a normal timeout. This is not cancellable, so don't add it to cache.
        ScheduledFuture<?>  futureHandle = ActionScheduler.getScheduler().scheduleAction(action, millis, callbackAdapter );
	}
	
	 /**
     * Schedule a player timeout trigger command.
     *
     * @param seq
     */
    public void schedulePlayerTimeout(long millis, long pid, int seq) 
    {
        TimedAction action = new TimedAction(callbackAdapter); 
        TriggerType type = TriggerType.PLAYER_TIMEOUT;
        Trigger timeout = new Trigger(type, pid);
        timeout.setSeq(seq);
        action.setAttachment(timeout);
        
        //Call actionscheduler here.
        ScheduledFuture<?> futureHandle = ActionScheduler.getScheduler().scheduleAction(action, millis, callbackAdapter );
        
        //Cache the future handle for cancelling task if required.
        Game game = (Game)((Adapter)callbackAdapter).getTarget();
        timeoutCache.addTimeout(game.getId(), pid, futureHandle);
    }
    
    public void clearTimeout(long pid)
    {
    	Game game = (Game)((Adapter)callbackAdapter).getTarget();
    	
    	ScheduledFuture<?>  futureHandle = timeoutCache.removeTimeout(game.getId(), pid);
    	
    	//Cancel if the task is not already completed. If completed, then this will do nothing.
    	//Do not interrupt if the task has already been initiated.
    	if( futureHandle != null )
    	    futureHandle.cancel(false);
    }
 }
