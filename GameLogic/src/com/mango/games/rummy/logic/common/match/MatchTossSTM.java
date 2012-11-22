/**
 * This is a  state to do toss and assign seating.
 * In the current version, this is just a placeholder.
 * 
 */
package com.mango.games.rummy.logic.common.match;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;

import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.Seat;

public class MatchTossSTM extends AbstractSTM 
{
	public MatchTossSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	/**
	 * State Change - MatchNewDealSTM
	 *  
	 */
	public void enterState() 
	{	
		//Get the first occupied seat from 0 to 5. Set that as the first turn seat.
		//At some point later, toss will determine who plays first.
		Seat seat = getMatch().getGame().getFirstOccupiedSeat();
		getMatch().setLastStartTurn(seat.getSeatId());
		this.changeState(new MatchNewDealSTM(this.stateChanger));
	}
	
	public void exitState()
	{
		
	}
	
	public int userDisconnected(long playerID)
	{
		//TODO:
		return 1;
	}
	
	// Client disables ToLobby button, but handle it still
	public int toLobby(long playerID)
	{
		//TODO:
		return 1;
	}
	
	private Match getMatch()
	{
		return (Match) (this.getClientAdapter().getTarget());
	}
}
