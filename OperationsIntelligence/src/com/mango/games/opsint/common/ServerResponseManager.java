package com.mango.games.opsint.common;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.smartfoxserver.v2.exceptions.SFSException;

import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.LoginRequest;
import sfs2x.client.requests.RoomSettings;

public class ServerResponseManager {

	public final SmartFox Sfs;
	private int i = 0;
	final IEventListener eventHandler;
	Timer sendHeartBeat;
	long delay = 60 * 1000;
	boolean loggedin = false;

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public ServerResponseManager() {
		Sfs = new SmartFox();
		Sfs.loadConfig(getCfgPath(), true);
		eventHandler = new SmartFoxEventHandler();
		Sfs.addEventListener(SFSEvent.ROOM_CAPACITY_CHANGE, eventHandler);
		Sfs.addEventListener(SFSEvent.CONNECTION, eventHandler);
		Sfs.addEventListener(SFSEvent.CONNECTION_LOST, eventHandler);
		Sfs.addEventListener(SFSEvent.LOGIN, eventHandler);
		Sfs.addEventListener(SFSEvent.EXTENSION_RESPONSE, eventHandler);
		Sfs.addEventListener(SFSEvent.ROOM_JOIN, eventHandler);

		sendHeartBeat = new Timer();
		sendHeartBeat.schedule(new SendHeartBeat(), 0, delay);

	}

	public RoomSettings createRoom() {
		i++;

		RoomSettings settings = new RoomSettings("My Chat Room");
		settings.setMaxUsers(40);
		settings.setName("Room" + i);
		// settings.setGroupId("chats");
		settings.setGame(true);
		Sfs.send(new CreateRoomRequest(settings));
		return settings;
	}

	private String getCfgPath() {
		System.out.println(System.getProperty("user.dir")
				+ "/config/sfs-config.xml");
		return System.getProperty("user.dir") + "/config/sfs-config.xml";
	}

	class SmartFoxEventHandler implements IEventListener {

		int num = 0;
		long sendResponseTime;
		long receivedResponseTime;
		long avgResponseTime;
		String loginID = "Lobby";

		@Override
		public void dispatch(BaseEvent event) throws SFSException {
			if (event.getType().equals(SFSEvent.ROOM_CAPACITY_CHANGE)) {
				SFSRoom roomChanged = (SFSRoom) event.getArguments()
						.get("room");
			}

			if (event.getType().equals(SFSEvent.CONNECTION)) {
				System.out.println("Connected! : " + num);

				Calendar now = Calendar.getInstance();
				sendResponseTime = now.getTimeInMillis();

				Sfs.send(new LoginRequest(loginID));
			}

			else if (event.getType().equals(SFSEvent.CONNECTION_LOST)) {
				System.out.println("Disconnected! : " + loginID);
				loggedin = false;
			}

			else if (event.getType().equals(SFSEvent.LOGIN)) {
				receivedResponseTime = Calendar.getInstance().getTimeInMillis();
				System.out.println("Log in Response Time (Millisecond) " + num
						+ " : " + (receivedResponseTime - sendResponseTime));
				if (avgResponseTime == 0) {
					avgResponseTime = receivedResponseTime - sendResponseTime;
				}
				loggedin = true;
			}
		}
	}

	private class SendHeartBeat extends TimerTask {

		public SendHeartBeat() {
		}

		@Override
		public void run() {
			if (loggedin) {
				Sfs.send(new ExtensionRequest("Heartbeat", null));
				System.out.println("Sent Heartbeat");
			}
		}
	}
}
