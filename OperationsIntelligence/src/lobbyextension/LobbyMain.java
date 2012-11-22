package lobbyextension;

import lobbyextension.handlers.RespondToHeartBeat;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class LobbyMain extends SFSExtension {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		addRequestHandler("Heartbeat", RespondToHeartBeat.class);
		
	}
}
