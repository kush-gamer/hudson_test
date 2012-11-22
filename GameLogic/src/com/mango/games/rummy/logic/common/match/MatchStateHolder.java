package com.mango.games.rummy.logic.common.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.IStateMachine;
import com.mango.games.rummy.logic.common.deal.DealStateHolder;

public class MatchStateHolder implements IStateChanger 
{
	private IStateMachine currentState;
	private IClientAdapter matchAdapter;
	
	private static final Logger log = LoggerFactory.getLogger(DealStateHolder.class);
	
	public MatchStateHolder(IClientAdapter adptr)
	{
		matchAdapter = adptr;
	}
	
    public void changeState(IStateMachine newState) 
	{
	   if (newState == null) throw new IllegalArgumentException("New state is null");
	   
	   //log.debug("Changing state from " + currentState + " to " + newState);
	   
	   if(currentState != null) 
	   {
		   currentState.exitState();
	   }
	   
	   currentState = newState;
	   currentState.enterState();
	}
    
    IStateMachine get() 
    {
    	return currentState;
    }

	@Override
	public IStateMachine getCurrent() 
	{
		return currentState;
	}

	@Override
	public IClientAdapter getClientAdapter() 
	{
		return matchAdapter;
	}
}
