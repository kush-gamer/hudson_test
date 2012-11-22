/**
 * 
 */
package com.mango.games.rummy.utils;

import java.util.concurrent.Callable;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ITimerCallable;
import com.mango.games.rummy.logic.common.timers.TimedAction;

/**
 * Class to trigger callback action when a timeout occurs.
 * The callback is routed through gameAdapter to Match/Deal adapters and their respective state machines
 * The statemachine handles the event timeout(action).
 * 
 * @author Sanjeev
 *
 */
public class TimeoutCallable implements Callable<Integer> 
{
	TimedAction action;
	ITimerCallable  callbackAdapter;
	
	public TimeoutCallable(TimedAction act, ITimerCallable adaptr) 
	{
	   this.callbackAdapter = adaptr;
	   this.action = act;
	}

	public Integer call() throws Exception
	{
		int retVal = 0;
		
		try {
			 System.out.println("Calling " + action.getSeq());
    	     retVal = callbackAdapter.handleTimeout(action);
		}
		catch(Exception e)
		{
			//System.out.println("TimeOutCallable: Exception " + e.getMessage());
			e.printStackTrace();
		}
		
		return retVal;
	}
}
