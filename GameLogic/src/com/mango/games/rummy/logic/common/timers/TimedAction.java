package com.mango.games.rummy.logic.common.timers;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.ITimerCallable;

/**
 * Action generated from a Scheduled timout job
 * @author Sanjeev
 *
 */
public class TimedAction 
{
	private ITimerCallable clientAdapter;
	private Trigger attachment;
		
	public TimedAction(ITimerCallable adaptr) 
	{
		clientAdapter = adaptr;
	}
	
	public void setAttachment(Trigger att)
	{
		attachment = att;
	}
	
	/** If the action is a Player Timer Action, then
	 * the plyaer_id is returned. If not null is returned.
	 * @return
	 * player_id or null
	 */
	public long getPlayerTurnId()
	{
		if( attachment.getType() == TriggerType.PLAYER_TIMEOUT )
		{
			return attachment.getPid();
		}
		
		return 0;
	}
	
	//For debugging
	public int getSeq()
	{
		return attachment.getSeq();
	}

}
