package com.mango.games.rummy.logic.common;
/**
 * Copyright Mango Games
 */

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.mango.games.rummy.logic.actions.EventHandlerMap;
import com.mango.games.rummy.logic.common.match.MatchStateHolder;
import com.mango.games.rummy.logic.common.match.MatchTossSTM;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.model.IModelCreationFactory;

import com.mango.games.rummy.utils.ITimerScheduler;

import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;

import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * MatchAdapter listens to the change in MatchStates and sends updates to the clients (via SFX)
 * @author Sanjeev
 *
 */
public class MatchAdapter extends AbstractAdapter 
{
	private IStateChanger _stateHolder;
	
	@Inject
    public MatchAdapter(Match targ) 
    {
		super((EObject)targ);
	
		//System.out.println("MatchAdapter:MatchAdapter");
		
		_stateHolder = new MatchStateHolder(this);
		_stateHolder.changeState(new MatchTossSTM(_stateHolder));
	}
    
	protected Match getMatch()
	{
		return (Match)getTarget();
	}
	
	//Demonstrates how you can get a GameAdapter from this class
	protected AbstractGameAdapter getGameAdapter()
	{
		Game game = getMatch().getGame();
		AbstractGameAdapter adapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter(game, game);
		
		return adapter;
	}

	@Override
	public int handleEvent(ISFSObject params) throws Exception
	{
    	return super.handleEvent(params);
	}
	
	@Override
	public IClientAdapter getChildAdapter()
    {
		IClientAdapter dealAdapter = null;
    	//Get the corresponding model object. All Games are derived from Game model
    	Match match = (Match)this.getTarget();
    	
        Deal  deal = match.getDeal();
    	
    	//From the match, get its adapter
    	if(deal != null)
    	{
    	    dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);
    	}
    	
    	return dealAdapter;
    }
    
    public IStateChanger getStateHolder()
    {
    	return this._stateHolder;
    }

	@Override
	public int handleTimeout(TimedAction action) throws Exception
	{
		return super.handleTimeout(action);
	}
	
	public ITimerScheduler getTableScheduler()
	{
		return this.getGameAdapter().getTableScheduler();
	}

	@Override
	public ServerResponseManager getServerResponseManager() 
	{
		return getGameAdapter().getServerResponseManager();
	}

	@Override
	public IModelCreationFactory getModelFactory() 
	{
		return getGameAdapter().getModelCreationFactory();
	}

	@Override
	public ITimerScheduler getTimerScheduler()
	{
		return getGameAdapter().getTimerScheduler();
	}
	
	public IStateChanger getStateChanger()
	{
		return _stateHolder;
	}

	
	public void removePlayerFromMatch(long playerID)
	{
		Game game = (Game) (getMatch().getGame());
		
		IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(game, game);
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter)adapter;

		EList<EObject> matchPlayers = getMatch().getMatchplayer();
		
		// remove player from match, reset seat for this player
		Iterator<EObject> iterator = matchPlayers.iterator();
		
		while(iterator.hasNext())
		{
			MatchPlayer matchPlayer = (MatchPlayer) (iterator.next());
			if(matchPlayer.getId() == playerID)
			{
				gameAdapter.resetSeatForThePlayer(playerID);
				
				iterator.remove(); // Remember player remains in the game players' list, will only be removed if he clicks on go to lobby
			}
		}
	}
	
	public void cleanupDeal()
	{
		Deal deal = getMatch().getDeal();
		
		DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(deal, deal);

		dealAdapter.cleanup();
		
		deal = null;
	}
	
	public void cleanupMatch()
	{
		getMatch().getMatchplayer().clear();
	}
	
	public MatchPlayer getMatchPlayerByID(long playerID)
	{
		EList<EObject> matchPlayers = getMatch().getMatchplayer();
		
		for(EObject obj : matchPlayers)
		{
			MatchPlayer matchPlayer = (MatchPlayer) obj;
			
			if(matchPlayer.getId() == playerID)
			{
				return matchPlayer;
			}
		}
		
		return null;
	}
	
	@Override
	public EventHandlerMap getEventHandlerMap() {
		return getGameAdapter().getEventHandlerMap();
	}


	@Override
	public void setEventHandlerMap(EventHandlerMap eventHandlerMap) {
		getGameAdapter().setEventHandlerMap(eventHandlerMap);
	}
}
