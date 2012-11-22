package com.mango.games.rummy.handlers;

import com.mangogames.rummy.RummyNetExtension;
import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class OnServerReadyHandler  extends BaseServerEventHandler 
{
	@Override
	public void handleServerEvent(ISFSEvent event) throws SFSException
	{
		RummyNetExtension ext = (RummyNetExtension) this.getParentExtension();
		ext.onServerReady();
	}
}