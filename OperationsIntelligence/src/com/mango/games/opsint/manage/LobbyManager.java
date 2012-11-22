package com.mango.games.opsint.manage;

import java.util.ArrayList;
import java.util.List;

import sfs2x.client.entities.SFSRoom;
import sfs2x.client.requests.RoomSettings;

import com.mango.games.db.*;
import com.mango.games.opsint.common.EventListener;
import com.mango.games.opsint.common.ServerResponseManager;
import com.mango.games.opsint.definitions.GameData;

public class LobbyManager {
	
	private ArrayList<GameData> gameData;
	//private EventListener eventListener;
	private ServerResponseManager serverResponseManager;
	
	public LobbyManager() {
		List<GameDefinition> gamedefinitions = GameDefinition.getAllDefinitions();
		//eventListener = new EventListener();
		gameData = new ArrayList<GameData>();
		serverResponseManager = new ServerResponseManager();
		for (GameDefinition gd: gamedefinitions) {
			System.out.println(gd.toString());
		}
		createGameData(gamedefinitions);
		init();
	}
	
	public void createGameData(List<GameDefinition> gamedefinitions) {
		for (GameDefinition gd: gamedefinitions) {
			this.gameData.add(new GameData(gd));
		}
	}
	
	public void init() {
		while(!serverResponseManager.isLoggedin()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (GameData gd: gameData) {
			for(int i = 0; i < gd.getMinimumNumberOfRooms(); i++) {
				RoomSettings settings = serverResponseManager.createRoom();
				//eventListener.sendRoom(settings);
			}
		}
		
	}
	
	public static void main(String args[]) {
		LobbyManager lobbymanager = new LobbyManager();
	}

}
