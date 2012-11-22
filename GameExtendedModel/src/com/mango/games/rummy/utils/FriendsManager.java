package com.mango.games.rummy.utils;

import java.util.ArrayList;
import java.util.List;

import com.mango.games.db.InviteRequests;
import com.mango.games.db.UserAccount;
import com.mango.games.db.UserDB;
import com.mango.games.rummy.achievements.Achievement;
import com.mango.games.rummy.achievements.AchievementManager;
import com.mango.games.rummy.achievements.Effort;
import com.mango.games.rummy.achievements.Effort.Type;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.api.ISFSBuddyApi;
import com.smartfoxserver.v2.buddylist.Buddy;
import com.smartfoxserver.v2.buddylist.BuddyVariable;
import com.smartfoxserver.v2.buddylist.ReservedBuddyVariables;
import com.smartfoxserver.v2.buddylist.SFSBuddyVariable;
import com.smartfoxserver.v2.buddylist.BuddyListManager;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.Zone;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.entities.managers.IZoneManager;
import com.smartfoxserver.v2.exceptions.SFSBuddyListException;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class FriendsManager 
{
	static SmartFoxServer _server = SmartFoxServer.getInstance();
	static IZoneManager _zoneManager = _server.getZoneManager();
	static Zone _currentZone = _zoneManager.getZoneByName("Rummy");
	static ISFSBuddyApi _buddyApi = _server.getAPIManager().getBuddyApi();
	static BuddyListManager _buddyManager = _currentZone.getBuddyListManager();
	
	private static List<String> getUserBuddies(User usr)
	{
		//TODO: DB Done /Memcache get FBID (sourceID) for the user, existing buddy list is saved with FBID
		
		long userID = Long.parseLong(usr.getName());
		
		com.mango.games.db.UserDB userObj = com.mango.games.db.UserDB.getUserbyID(userID);
		
		String userName = userObj.getFirst_name(); //TODO: here
		
		List<Buddy> userBuddies = _buddyManager.getBuddyList(userName).getBuddies();
		
		List<String> buddiesFBID = new ArrayList<String>();
		for(Buddy buddy :  userBuddies)
		{
			buddiesFBID.add(buddy.getName());
		}
		
		return buddiesFBID;
	}
	
	public static void addDefaultBuddies(ISFSArray friends, User requester)
	{
		for(int i=0; i<friends.size(); i++)
		{
			ISFSObject friend  = friends.getSFSObject(i);
			
			String friendsFBID = friend.getUtfString("FacebookID");
			String name = friend.getUtfString("Name");
			
			addBuddy(requester, friendsFBID, name, false);
		}
	}
	
	private static ISFSObject getFriendsData(String friendFBID)
	{
		//TODO: DB Done : get friends' data
		/*
		 * Get User account and User DB based on FriendFBID
		 */
		UserDB user = UserDB.getUserbyFBID(friendFBID);
		UserAccount useracc = UserAccount.getUserAccountbyUserID(user.getId());
		ISFSObject friend = new SFSObject();					
		
		friend.putUtfString("FriendID", friendFBID);
		friend.putInt("Level", useracc.getLevel());
		friend.putUtfString("Name", user.getFirst_name());
		friend.putInt("Chips", useracc.getChips());
		
		return friend;
		
		/*		String friends = "SELECT player.`Level`, " +
		"playermaster.`Name`, " +
		" player.Chips " +
		" FROM " +
		"player, playermaster " +
		" WHERE player.FacebookID = playermaster.FacebookID AND " +
		" player.FacebookID = '" + friendFBID + "'" +
		" ORDER BY " +
		" player.`Level` DESC, player.Chips DESC";
		
		try
		{
			ISFSArray result = _dbManager.executeQuery(friends);
			if(result.size() > 0)
			{
				ISFSObject row = result.getSFSObject(0);
				
				ISFSObject friend = new SFSObject();					
				
				friend.putUtfString("FriendID", friendFBID);
				friend.putInt("Level", row.getInt("Level"));
				friend.putUtfString("Name", row.getUtfString("Name"));
				friend.putInt("Chips", row.getInt("Chips"));
				friend.putBool("IsOnline", IsOnline(friendFBID));
				
				return friend;
			}	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}*/
	}
	
	
	public static ISFSArray getMyFriends(User usr)
	{
		List<String> buddies = getUserBuddies(usr);
		
		ISFSArray response = new SFSArray();
		
		for(String buddyFBID : buddies)
		{
			ISFSObject friend = getFriendsData(buddyFBID);
			
			if(friend != null)
			{
				response.addSFSObject(friend);
			}
		}
		
		return response;
	}
	
	public static boolean isMyFriend(User usr, String facebookID)
	{
		if(_buddyManager.getBuddyList(usr.getName()).containsBuddy(facebookID))
		{
			System.out.print("Is Already My Friend");
			return true;
		}
		else
		{
			System.out.print("Is NOT My Friend");
			return false;
		}
	}
	
	public static void setNickNameForUser(User usr, String nickName)
	{
		if(usr == null) return;
		
		ISFSObject nameObj = new SFSObject();
		nameObj.putUtfString("NickName", nickName);
		
		setBuddyVariableForUser(usr, ReservedBuddyVariables.BV_NICKNAME, nameObj);
	}
	
	public static void saveInviteRequest(String senderID, String requestID, String invitedID, SFSExtension ext)
	{
		int inviteCount = 0;
		if((requestID.length() > 0) && (invitedID.length() > 0))
		{
			String[] toIDs = invitedID.split(",");
			
			for(int i=0; i<toIDs.length; i++)
			{
				if(isAlreadyInvited(toIDs[i], senderID) == false)
				{
					inviteCount++;
				}

				saveInvite(senderID, requestID, toIDs[i]);
			}			
			
			if(inviteCount > 0)
			{
				sendInviteBonus(senderID, inviteCount, ext);
			}
		}
	}
	
	public static void handlePlayerJoiningFromInvite(String playerID, ISFSObject data, SFSExtension ext)
	{
		String requestID = data.getUtfString("RequestIDs");
		String invitee = playerID;
		
		String[] requests = requestID.split(",");

		for(int i=0; i<requests.length; i++)
		{
			String inviter = saveAsFriend(requests[i], invitee, ext);
			
			long inviterUserID = com.mango.games.db.UserDB.getUserbyFBID(inviter).getId(); //TODO: DB Done get userid from string
			
			// send a notification (if he is online)
			if(inviter.length() > 0)
			{
				User inviterUser = UserHelper.GetUserInZone(inviterUserID, ext.getParentZone());
				
				if(inviterUser != null)
				{
					ISFSObject response = new SFSObject();
					
					ISFSArray friends = getMyFriends(inviterUser);
					
					if(friends.size() > 0)
					{	
						response.putSFSArray("Friends", friends);
					}
					else
					{
						response = null;
					}
					
					ext.send("MyFriends", response, inviterUser);
				}
			}
		}		
	}
	
	private static String saveAsFriend(String requestID, String invitee, SFSExtension ext)
	{
		// TODO Require InvitationID (Primary Key) 
		// TODO: DB Done- get sender id from inviterequests using requsetID
		InviteRequests inviteRequest = InviteRequests.getInviteRequestByRequestID(requestID);
		
		String inviterID = inviteRequest.getSenderFBID(); // TODO: DB Done
		
		com.mango.games.db.UserDB inviteeUserObj = com.mango.games.db.UserDB.getUserbyFBID(invitee);
		com.mango.games.db.UserDB inviterUserObj = com.mango.games.db.UserDB.getUserbyFBID(inviterID);
		
		
		long inviteeUserID = inviteeUserObj.getId(); // TODO: DB Done-Memcache get from invitee
		long inviterUserID = inviterUserObj.getId(); // TODO: DB Done-Memcache get from invitee
		
		UserAccount inviteeUserAccount = UserAccount.getUserAccountbyUserID(inviteeUserID);
		User inviteeUser = UserHelper.GetUserInZone(inviteeUserID, ext.getParentZone());
		
		if(false == isMyPermanentBuddy(inviteeUser, inviterID))
		{
			addBuddy(inviteeUser, inviterID, "", false);
							
			//TODO: DB Done update from invite request as accepted
			inviteRequest.setStatus("Accepted");
			inviteRequest.update();
			
			sendInviteReward(inviterUserID, 750, ext);
			
		/*	ISFSObject refReward = new SFSObject();
			refReward.putUtfString("FriendID", inviterID);
			refReward.putInt("RewardChips", 100); */
			
			// TODO: update invitee chips 
			int chipsToInvitee = 100; 
			inviteeUserAccount.setChips(inviteeUserAccount.getChips() + chipsToInvitee);
			inviteeUserAccount.update();
			return inviterID;
		}
		
		return "";
	}
	
	private static void sendInviteReward(long inviterID, int chips, SFSExtension ext)
	{
		// accepted invite reward to the sender
		boolean updateInviteChips = false;
		
		addInviteBonus(inviterID, 750, updateInviteChips);
		
		int count = getInvitesAcceptedCount(inviterID);
		
		Effort effort = new Effort(Type.INVITE, count);			
		Achievement achievement = AchievementManager.getIfAchievement(effort);
		
		User inviter = UserHelper.GetUserInZone(inviterID, ext.getParentZone());
		UserAccount inviterUserAccount = UserAccount.getUserAccountbyUserID(inviterID);
		// check if the inviter is online
		if(inviter != null)
		{
			// TODO: DB Done- update inveter Chips
			int inviterChips = inviterUserAccount.getChips() + chips; //TODO: - getIviterChips + chips
			inviterUserAccount.setChips(inviterChips);
			
			ISFSObject response = new SFSObject();
			response.putInt("Chips", inviterChips);
			
			ext.send("ChipsUpdated", response, inviter); //TODO: CLIENT
			
			if(achievement != null)
			{
				sendAchievement(achievement.AchievementID, inviter, ext);
			}
		}
		else // inviter not online
		{
			// already handled on user INFO
			
		}
	}
	
	private static void sendAchievement(int achievementID, User user, SFSExtension ext)
	{
		ISFSObject achievement = new SFSObject();
		achievement.putInt("AchievementID", achievementID);
		
		ext.send("NewAchievement", achievement, user);
	}
	
	private static void sendInviteBonus(String senderID, int inviteCount, SFSExtension ext)
	{
		com.mango.games.db.UserDB userobj = com.mango.games.db.UserDB.getUserbyFBID(senderID);
		long senderUserID = userobj.getId();
		
		UserAccount useracc = UserAccount.getUserAccountbyUserID(senderUserID);
		
		int chips = useracc.getChips(); //TODO: DB Done get chips
		
		chips += inviteCount * 50; //TODO: INVITE_BONUS, to come from some config file
		
		ISFSObject response = new SFSObject();
		response.putInt("Chips", chips);
		response.putInt("Bonus", 50 * inviteCount);
		response.putInt("InviteCount", inviteCount);			
	
		ext.send("InviteBonus", response, UserHelper.GetUserInZone(senderUserID, ext.getParentZone()));
	}
	
	private static boolean isAlreadyInvited(String inviteeID, String inviterID)
	{
		// TODO: DB Done check inviterequests
		List<InviteRequests> invitelist = InviteRequests.getInviteRequestBySenderID_InvitedID(inviterID, inviteeID);
		if(invitelist.size() > 0)
			return true;
		else
			return false;
	}
	
	private static void saveInvite(String senderID, String requestID, String inviteeID)
	{
		
	}
	
	// when the sender is offline OFFLINE
	public static void addInviteBonus(long senderID, int chips, boolean updateInviteChips)
	{
		int chipsAfterInvite = 0;
		
		if(updateInviteChips == false)
		{
			chipsAfterInvite = chips;
		}
			
		//TODO: DB Not Done update player set ChipsUpdatedAfterInvite
		
		/*String sql = "UPDATE player SET Chips = Chips + " + chips + ", " +
				" ChipsUpdatedAfterInvite = ChipsUpdatedAfterInvite + " + chipsAfterInvite + 
				" WHERE FacebookID = '" + senderID + "'";
		
		try
		{
			_dbManager.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			System.out.println(sql);
			e.printStackTrace();
		}*/
	}
	
	public static int getInvitesAcceptedCount(long userID)
	{
		//long count = 0;
		com.mango.games.db.UserDB userobj = com.mango.games.db.UserDB.getUserbyID(userID);
		
		List<InviteRequests> invitelist = InviteRequests.getInviteRequestBySenderFBID_Status(userobj.getExternalid(), "Accepted");
		return invitelist.size();
		
		// TODO: DB Done get inviterequests count
		/*String sql = "SELECT Count(*) as Count FROM inviterequests WHERE Status = 'Accepted' AND " +
				" SenderFBID = '" + facebookID + "'";
		
		try
		{
			ISFSArray res = _dbManager.executeQuery(sql);
			
			if(res.size() > 0)
			{
				count = res.getSFSObject(0).getLong("Count");
			}			
		}
		catch(SQLException e)
		{
			System.out.println(sql);
			e.printStackTrace();
		}*/
		
		//return (int) count;
	}
	
	public static int getOnlinePlayers(User requester)
	{
		List<User> allUsers = UserHelper.GetUsersInLobby(_currentZone);
		
		for(User user : allUsers)
		{
			if(user.isNpc()) continue;

			ISFSObject player = new SFSObject();
			
			if(requester.getName().equals(user.getName())) continue; // do not add self!
			
			// TODO: DB -Memcache, get User Details and fill in player sfsobject
			String sourceUID = "";
			String firstName = "";
			boolean isOnline = true;
			String roomID = "";
			
			player.putUtfString("FacebookID", sourceUID);
			player.putUtfString("Name", firstName);
			player.putBool("IsOnline", isOnline);
			
			player.putUtfString("RoomID", roomID);
			
			// add to buddy list manager via sfs buddy api
			addBuddy(requester, sourceUID, firstName, true);
		}
		
		return allUsers.size();
	}
		
	public static void addBuddy(User usr, String facebookID, String name, boolean isTemp)
	{
		// TODO: DB-memcache - get sourceUID for the user
		
		String requesterSourceUID = ""; 
		
		if(!_buddyManager.getBuddyList(requesterSourceUID).containsBuddy(facebookID)) // no duplicates!
		{	
			try 
			{
				_buddyApi.addBuddy(usr, facebookID, isTemp, true, false);
			} 
			catch (SFSBuddyListException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println(" Already a buddy " + facebookID);
		}
	}
	
	public static void addPermanentBuddy(User usr, String facebookID, String name)
	{
		// TODO: DB-memcache get UserID from facebookID/sourceUID
		long userID = 0; //TODO: 
		
		User friend = UserHelper.GetUserInZone(userID, _currentZone);
		
		String sourceUID = ""; //TODO: get source user ID (FacebookID)

		if(_buddyManager.getBuddyList(sourceUID).containsBuddy(facebookID))
		{	
			_buddyApi.removeBuddy(usr, facebookID, false, false);
			
			// get friends' user
			_buddyApi.removeBuddy(friend, facebookID, false, false);
		}
		
		try 
		{
			_buddyApi.addBuddy(usr, facebookID, false, true, false);
			_buddyApi.addBuddy(friend, usr.getName(), false, true, false);
		} 
		catch (SFSBuddyListException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isMyPermanentBuddy(User usr, String facebookID)
	{
		if(_buddyManager.getBuddyList(usr.getName()).containsBuddy(facebookID))
		{
			Buddy buddy = _buddyManager.getBuddyList(usr.getName()).getBuddy(facebookID);
			
			if(!buddy.isTemp())
			{
				System.out.println("Is My permanent buddy " + buddy.getName());
				
				return true;
			}
		}
		
		System.out.println("Is NOTTT My permanent buddy");
		
		return false;
	}
	
	// TODO: do we need this??
	public static ISFSArray getOnfflinePlayers(ISFSArray players)
	{
		ISFSArray offlinePlayers = new SFSArray();
		for(int i=0; i<players.size(); i++)
		{
			//ISFSObject player = players.getSFSObject(i);
			
			/*if(isOnline(player.getUtfString("FacebookID")) == false)
			{
				player.putBool("IsOnline", false);
				offlinePlayers.addSFSObject(player);
			}*/
		}
		
		return offlinePlayers;
	}
	
	public static int countAllOnlineUsers()
	{
		int count = UserHelper.GetUsersInLobby(_currentZone).size();
		
		return count;
	}
	
	public static void setBuddyVariableForUser(User usr, String variableName, ISFSObject variableVal)
	{
		List<BuddyVariable> buddyVars = new ArrayList<BuddyVariable>();
		SFSBuddyVariable buddyVar = null;

		if(variableName.equals(ReservedBuddyVariables.BV_NICKNAME))
        {
			String value = variableVal.getUtfString("NickName");
			buddyVar = new SFSBuddyVariable(variableName, value);
        }
		else
		{
			buddyVar = new SFSBuddyVariable(variableName, variableVal);
		}
		
        buddyVars.add(buddyVar);
                
        try 
        {
			_buddyApi.setBuddyVariables(usr, buddyVars, true, false);
		} 
        catch (SFSBuddyListException e) 
        {
			e.printStackTrace();
		}
	}
	
	public static void setBuddyVariableForAllUsersInRoom(Room room, String variableName, ISFSObject variableVal)
	{
		List<User> recipients = UserHelper.GetUsersList(room);
		
		for(User usr : recipients)
		{
			if(usr.isNpc()) continue;
			
			setBuddyVariableForUser(usr, variableName, variableVal);
		}
	}
}
