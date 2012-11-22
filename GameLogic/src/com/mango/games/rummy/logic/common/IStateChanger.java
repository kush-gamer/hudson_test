package com.mango.games.rummy.logic.common;


/**
 * Interface for allowing the states to change the state in the holder, without introducing a circular dependency.
 *
 */

public interface IStateChanger 
{
    /**
     * Changes the current state the new state.
     *
     * @param newState the new state
     */
    public void changeState(IStateMachine newState);
    public IStateMachine getCurrent();
    
    public IClientAdapter getClientAdapter();
}
