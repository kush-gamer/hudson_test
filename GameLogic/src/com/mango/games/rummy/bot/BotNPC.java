package com.mango.games.rummy.bot;

//import com.smartfoxserver.v2.SmartFoxServer;
//import com.smartfoxserver.v2.api.SFSApi;
//import com.smartfoxserver.v2.entities.Room;
//import com.smartfoxserver.v2.entities.User;
//import com.smartfoxserver.v2.entities.Zone;
//import com.smartfoxserver.v2.entities.managers.IZoneManager;
//import com.smartfoxserver.v2.exceptions.SFSJoinRoomException;
//import com.smartfoxserver.v2.exceptions.SFSLoginException;

public class BotNPC 
{
//	SmartFoxServer _server = SmartFoxServer.getInstance();
//	IZoneManager _zoneManager = _server.getZoneManager();
//	Zone _currentZone = _zoneManager.getZoneByName("Rummy");
//	
//	private SFSApi sfsApi;
//	private User _user;
//	private Room _room;
	
	public BotNPC() {
		
	}

	public boolean activate(int roomID, String userName)
	{
//		try
//		{
//			_user = sfsApi.createNPC(userName, _currentZone, true);
//			
//			_room = _currentZone.getRoomById(roomID);
//			sfsApi.joinRoom(_user, _room);
//		}
//		catch(SFSLoginException e)
//		{
//			System.out.println(" Login Exception " + e.getMessage());
//			return false;
//		}
//		catch(SFSJoinRoomException e)
//		{
//			System.out.println(" Join Room Exception " + e.getMessage());
//			return false;
//		}
//		catch(Exception e)
//		{
//			System.out.println(" Bot creation failed " + e.getMessage());
//			return false;
//		}		
		
		return true;
	}
	
	public boolean deactivate()
	{
//		try
//		{
//			sfsApi.leaveRoom(_user, _room);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception :: calling leaveRoom in bot deactivate");
//			
//			return false;
//		}
//		try
//		{
//			sfsApi.logout(_user);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception :: calling logout in bot deactivate");
//			
//			return false;
//		}
		
		return true;
	}
}
