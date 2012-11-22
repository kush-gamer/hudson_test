package com.mango.games.rummy.logic.common.match;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;

public class MatchPlayingSTM extends AbstractSTM 
{
	public MatchPlayingSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	/**
	 * State Change - None
	 *  Does nothing yet!
	 */
	public void enterState() 
	{
		//System.out.println("MatchPlayingSTM:enterState");
	}
	
	public void exitState()
	{
		// TODO: DB Not Done Save Match
	}
}
