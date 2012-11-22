package com.mango.games.rummy.utils.di;

import com.google.inject.AbstractModule;
import com.mango.games.rummy.bot.BotPlayerAdapter;

import com.mango.games.rummy.logic.syndicate.SyndicateAdapter;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.SyndicateGame;
import com.mangogames.rummy.model.impl.BotPlayerImpl;
import com.mangogames.rummy.model.impl.SyndicateGameImpl;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class InjectionModule extends AbstractModule {

	@Override
	protected void configure() 
	{
		bind(SyndicateGame.class).to(SyndicateGameImpl.class);
		bind(BotPlayer.class).to(BotPlayerImpl.class);
		
		install(new FactoryModuleBuilder()
	     .implement(SyndicateAdapter.class, SyndicateAdapter.class)
	     .implement(BotPlayerAdapter.class, BotPlayerAdapter.class)
	     .build(IAdapterFactory.class));
	}

}
