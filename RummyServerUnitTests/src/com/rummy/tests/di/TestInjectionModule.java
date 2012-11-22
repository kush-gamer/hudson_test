package com.rummy.tests.di;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.mango.games.rummy.bot.BotNPC;
import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.syndicate.SyndicateAdapter;
import com.mango.games.rummy.utils.di.IAdapterFactory;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.SyndicateGame;
import com.mangogames.rummy.model.impl.BotPlayerImpl;
import com.mangogames.rummy.model.impl.SyndicateGameImpl;
import static org.mockito.Mockito.mock;

/**
 * @author admin
 *
 */
public class TestInjectionModule extends InjectionModule 
{

	@Override
	protected void configure() 
	{
		bind(SyndicateGame.class).to(SyndicateGameImpl.class);
		bind(BotPlayer.class).to(BotPlayerImpl.class);
		//bind(BotNPC.class).to(mock(BotNPC.class).getClass());
		//bind(BotNPC.class).to(BotNPC.class);
		
		install(new FactoryModuleBuilder()
	     .implement(SyndicateAdapter.class, SyndicateAdapter.class)
	     .implement(BotPlayerAdapter.class, BotPlayerAdapter.class)	     
	     .build(IAdapterFactory.class));
	}
	
}