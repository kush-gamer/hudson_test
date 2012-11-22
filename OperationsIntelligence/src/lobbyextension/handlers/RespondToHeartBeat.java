package lobbyextension.handlers;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class RespondToHeartBeat extends BaseClientRequestHandler 
{

	@Override
	public void handleClientRequest(User user, ISFSObject obj) 
	{
		// TODO Auto-generated method stub
		this.send("Alive", null, user);
		trace("---- Received Heartbeat ----");
	}

}
