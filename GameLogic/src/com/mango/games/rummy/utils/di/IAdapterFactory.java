package com.mango.games.rummy.utils.di;

import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.syndicate.SyndicateAdapter;

import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.SyndicateGame;

public interface IAdapterFactory 
{
	SyndicateAdapter createSyndicateAdapter(SyndicateGame target);
	BotPlayerAdapter createBotPlayerAdapter(BotPlayer plyr);
}
