package com.mango.games.opsint.common;

import sfs2x.client.SmartFox;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.requests.RoomSettings;

public class EventListener {
	
	public final SmartFox Sfs;
	//final IEventListener eventHandler;
	
	public EventListener() {
		Sfs = new SmartFox();
		Sfs.loadConfig(getCfgPath(), true);
		//eventHandler = new SmartFoxEventHandler();
				
		//Sfs.addEventListener(SFSEvent.ROOM_CAPACITY_CHANGE, eventHandler);
	}
	
		
	private String getCfgPath() 
	{
		System.out.println(System.getProperty("user.dir") + "/config/sfs-config.xml");
		
		return System.getProperty("user.dir") + "/config/sfs-config.xml";
	}
}
