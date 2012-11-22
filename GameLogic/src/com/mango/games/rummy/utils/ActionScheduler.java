package com.mango.games.rummy.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ITimerCallable;


import com.mango.games.rummy.logic.common.timers.TimedAction;

public class ActionScheduler 
{

	private static ActionScheduler actionScheduler;
	private final ScheduledExecutorService scheduler;
	
	private ActionScheduler() 
	{
		scheduler = Executors.newScheduledThreadPool(5); //Make it configurable

	}
	
	public static ActionScheduler getScheduler() 
    {
		if (actionScheduler == null)
		{
			actionScheduler = new ActionScheduler();
		}
		
		return actionScheduler;
	}
	
	public ScheduledFuture<?>  scheduleAction(final TimedAction action, final long millis, ITimerCallable gameAdaptr)
	{
		final TimeoutCallable triggerAction = new TimeoutCallable(action, gameAdaptr);
		
		//System.out.println("ActionScheduler:scheduleAction - " + triggerAction.hashCode());
		
        final ScheduledFuture<?> triggerHandle  = 
                scheduler.schedule(triggerAction, millis, TimeUnit.MILLISECONDS);
        
        return triggerHandle;
	}
}
