package com.mango.games.rummy.logic.common.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.IStateMachine;

/** Encapsulates the statemachines interface.
 * A wrapper class that holds the current state and is responsible for changing the current state
 * 
 * @author Sanjeev
 *
 */
public class GameStateHolder implements IStateChanger
{
	private IStateMachine currentState;
	private IClientAdapter clientAdapter;
	private static final Logger log = LoggerFactory.getLogger(GameStateHolder.class);
	
	public GameStateHolder(IClientAdapter cAdapter)
	{
		clientAdapter = cAdapter;
	}
	
    public void changeState(IStateMachine newState) 
	{
	   if (newState == null) throw new IllegalArgumentException("New state is null");
	   
	   if(currentState != null)
	   {
		   currentState.exitState();
	   }
	   
	   currentState = newState;
	   currentState.enterState();
	}
    
    public IStateMachine getCurrent() 
    {
        return currentState;
    }
    
    public IClientAdapter getClientAdapter()
    {
    	return clientAdapter;
    }
}
