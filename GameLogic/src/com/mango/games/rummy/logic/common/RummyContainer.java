package com.mango.games.rummy.logic.common;

import com.mango.games.rummy.utils.Log;

public class RummyContainer implements IRummyContainer
{
	public static void init() 
	{
		Log.ConfigureLogger();
		Log.logger.debug("Logger has been configured");
	}
}
