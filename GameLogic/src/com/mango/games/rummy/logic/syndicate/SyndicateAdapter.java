package com.mango.games.rummy.logic.syndicate;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;
import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.utils.ITimerScheduler;
import com.mangogames.rummy.model.SyndicateGame;

public class SyndicateAdapter extends AbstractGameAdapter 
{

	@Inject
	public SyndicateAdapter(SyndicateGame targt) {
		super((EObject)targt);
	}

	@Override
	public IModelCreationFactory getModelFactory()
	{
		return super.getModelCreationFactory();
	}

	@Override
	public ITimerScheduler getTimerScheduler() 
	{
		return super.getTableScheduler();
	}

}
