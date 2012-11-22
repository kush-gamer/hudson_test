package com.mango.games.rummy.logic.common;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

import com.mango.games.rummy.utils.di.IAdapterFactory;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.SyndicateGame;
import com.mangogames.rummy.model.util.ModelAdapterFactory;

public class LogicAdapterFactory extends ModelAdapterFactory 
{

	@Inject
	private IAdapterFactory injectionFactory;
	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) 
	{
		EObject obj = (EObject)target;
		/**
		 * Install adapters as they are developed. By default an adapter is not created for a model element.		
		 */
		if(obj instanceof SyndicateGame)
		{
			return injectionFactory.createSyndicateAdapter((SyndicateGame)target);
		}
		else if(obj instanceof Match)
		{
			return new MatchAdapter((Match)target);
		}
		else if(obj instanceof Deal)
		{
			return new DealAdapter((Deal)target);
		}
		else if(obj instanceof BotPlayer)
		{
			//return new BotPlayerAdapter((BotPlayer) target);
			//BotPlayerAdapter botAdapter = new BotPlayerAdapter((BotPlayer) target);
			return injectionFactory.createBotPlayerAdapter((BotPlayer)target);
//			Log.logger.debug("Bot Adapter: " + botAdapter);
//			return botAdapter;
		}
		
		return null;
	}
}
