package com.mango.games.rummy.logic.common;

import com.mango.games.rummy.logic.actions.IRummyActions;
import com.mango.games.rummy.logic.common.timers.TimedAction;


public interface IStateMachine extends IRummyActions
{
    public void enterState();
   
    public void exitState();

    public int timeout(TimedAction action);
}
