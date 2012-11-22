/**
 * 
 */
package com.mango.games.rummy.logic.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mango.games.rummy.logic.actions.DefaultActionHandler;
import com.mango.games.rummy.logic.actions.EventDetails;
import com.mango.games.rummy.logic.common.timers.TimedAction;

/**
 * This serves as the base STM for all State Machines. It extends DefaultActionHandler that does not do anything
 * for an event. Individual STMs should override appropriate action handlers. 
 */
public class AbstractSTM extends DefaultActionHandler implements IStateMachine 
{

	protected IStateChanger stateChanger;
	public static final Logger log = LoggerFactory.getLogger(AbstractSTM.class);
	
	/**
	 * Constructor passes the stateHolder as states Change
	 * @param stateHolder
	 */
	public AbstractSTM(IStateChanger stateHolder)
	{
		//System.out.println(this.getClass().toString());
		stateChanger = stateHolder;
	}
	
	protected void changeState(AbstractSTM newState) 
	{	
        newState.stateChanger = stateChanger;
        stateChanger.changeState(newState);
    }
	
	/* (non-Javadoc)
	 * @see com.mango.games.rummy.gamelogic.state.IStateMachine#enterState()
	 */
	@Override
	public void enterState() 
	{
	}

	/* (non-Javadoc)
	 * @see com.mango.games.rummy.gamelogic.state.IStateMachine#exitState()
	 */
	@Override
	public void exitState() 
	{
	}

	/* (non-Javadoc)
	 * @see com.mango.games.rummy.gamelogic.state.IStateMachine#timeout()
	 */
	@Override
	public int timeout(TimedAction action) 
	{
		return 0;
	}

	/**
	 * Utility methods
	 */
	
	protected IClientAdapter getClientAdapter()
	{
		return stateChanger.getClientAdapter();
	}
	
	/** ACTION Handlers are implemented here */
	//Implement Game action handlers that are common to all Game Formats - CFP, Pool, BettingCFP etc.	
	
	@Override
	public EventDetails getEventHandlerMap(String messagename)
	{
		EventDetails details = null;
		if( stateChanger != null )
		{
			 details = stateChanger.getClientAdapter().getEventHandlerMap().getEventDetailsMap(messagename);
		}
		return details;
	}
} 
