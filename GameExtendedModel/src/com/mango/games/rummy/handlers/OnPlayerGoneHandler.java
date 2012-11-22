package com.mango.games.rummy.handlers;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.UserInfoManager;
import com.mangogames.rummy.RummyNetExtension;
import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class OnPlayerGoneHandler extends BaseServerEventHandler 
{
	@Override
	public void handleServerEvent(ISFSEvent event) throws SFSException
	{
		trace("++++++++++++++++  OnPlayerGoneHandler  ++++++++++++++");
		User user = (User) event.getParameter(SFSEventParam.USER);
		
		RummyNetExtension ext = (RummyNetExtension) this.getParentExtension();
		GameProxy proxy = ext.getGameProxy();
		
		IClientAdapter adapter = proxy.getClientAdapter();
		
		ISFSObject params = new SFSObject();
		params.putUtfString("playerid", user.getName());
		params.putBool("IsServerEvent", true);
		params.putUtfString("MessageName", "userdisconnected");
		
		// save user data
		try 
		{
			adapter.handleEvent(params);
			
			// TODO: check if not saved already, save here
			UserInfoManager.savePlayerData(Long.getLong(user.getName()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
