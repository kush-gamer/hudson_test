package com.mango.games.rummy.handlers;

import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.UserInfoManager;
import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)		
@MultiHandler
public class LobbyRequests extends BaseClientRequestHandler
{
	@Override
	public void handleClientRequest(User user, ISFSObject params)
	{	
		String requestID = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		
		System.out.println(" T E S T " + params.getDump());
		
		if(requestID.equals(ActionConstants.GetUserInfo))
		{
			this.send("PlayerInfo", UserInfoManager.UserLogin(params, user), user);
			
			//TODO: Also send currently online
		}	
	}
}
