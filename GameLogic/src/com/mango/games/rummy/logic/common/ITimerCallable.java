/**
 * 
 */
package com.mango.games.rummy.logic.common;

import com.mango.games.rummy.logic.common.timers.TimedAction;

/**
 * @author admin
 *
 */
public interface ITimerCallable 
{
	public int  handleTimeout(TimedAction action) throws Exception;
}
