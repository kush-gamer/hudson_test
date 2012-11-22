package com.mango.games.rummy.logic.common.deal;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.match.MatchScore4DealSTM;

import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Match;

public class DealEndedSTM extends AbstractSTM
{
	public DealEndedSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}
	
	// doesn't really do anything but changes the match state to MatchShowingScoreboardSTM
	public void enterState() 
	{
		Match match = (Match) (getDeal().getMatch());
		
		IClientAdapter matchAdapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(match, match);
		IStateChanger matchStateHolder = matchAdapter.getStateChanger(); 
		
		matchStateHolder.changeState(new MatchScore4DealSTM(matchStateHolder));
	}
	
	public void exitState()
	{
	}
	
	private Deal getDeal()
	{
		return (Deal)this.getClientAdapter().getTarget();
	}
}
