
package com.mango.games.rummy.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;


/**
 * All scheduled actions are kept in a concurrent hashmap. This cache is kept in the GameAdapter, as part of the game-state.
 * Every scheduled timerjob is cached here, and is removed if the user completes the action, or when the timer triggers
 * the timedout action.
 * 
 * @author Sanjeev
 *
 */
public class TimeoutCache {

    protected ConcurrentHashMap<MultiKey,ScheduledFuture<?>> actions;
    
    public TimeoutCache()
    {
    	actions = new ConcurrentHashMap<MultiKey, ScheduledFuture<?>>();
    }

    /**
     * Adds a reference to a timeout for an action request.
     *
     * @param tableId
     * @param pid
     * @param actionId
     */
    public void addTimeout(long gameId, long pid, ScheduledFuture<?> futureHandle) 
    {
    	//System.out.println("TimeoutCache:addTimeout -" + gameId + " ," + pid);
        actions.put(new MultiKey(gameId, pid), futureHandle);
    }

    /**
     * Removes reference from the map and cancel the scheduled action from
     * the given scheduler.
     *
     * @param tableId
     * @param pid
     * @param tableScheduler, if null then skipped.
     */
    public ScheduledFuture<?> removeTimeout(long gameid, long pid)
    {
    	//System.out.println("TimeoutCache:removeTimeout -" + gameid + " ," + pid);
    	
    	ScheduledFuture<?> futureHandle = actions.remove(new MultiKey(gameid, pid));
       
        /* TODO - It may be a good idea to pass the scheduler to this method and have the 
         * cached timerjob removed from the cache.
         */
       /** if (remove != null && tableScheduler != null) {
            tableScheduler.cancelScheduledAction(remove);
        } **/
    	
    	
        return futureHandle;
    }


}
