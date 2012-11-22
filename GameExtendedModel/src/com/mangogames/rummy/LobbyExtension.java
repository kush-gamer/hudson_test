package com.mangogames.rummy;

import java.util.ArrayList;
import java.util.List;

import com.mango.games.rummy.handlers.CommonRequests;
import com.mango.games.rummy.handlers.LobbyRequests;
import com.mango.games.rummy.logic.common.RummyContainer;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.api.CreateRoomSettings.RoomExtensionSettings;
import com.smartfoxserver.v2.api.ISFSGameApi;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.SFSRoomRemoveMode;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.Zone;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.entities.invitation.Invitation;
import com.smartfoxserver.v2.entities.variables.RoomVariable;
import com.smartfoxserver.v2.entities.variables.SFSRoomVariable;
import com.smartfoxserver.v2.exceptions.SFSCreateRoomException;
import com.smartfoxserver.v2.extensions.SFSExtension;
import com.smartfoxserver.v2.game.CreateSFSGameSettings;

public class LobbyExtension extends SFSExtension
{
	public int MaxInvitationTime = 2;
	public RummyContainer rummyContainer;
	
	//TODO: get maxinvitationtime from config

	@Override
	public void init()
	{
		trace("------ Lobby Extension Begin: " + System.currentTimeMillis() + "-----------");
		RegisterEventHandlers();
		rummyContainer = new RummyContainer();
		RummyContainer.init();
		trace("------ Lobby Extension Begin: " + System.currentTimeMillis() + "-----------");
	}
		
	@Override
	 public void destroy()
	{
		trace("(((((((((((((Removing Lobby))))))))))))");
		
		UnRegisterEventHandlers();
		
		clearAllHandlers();
		clearFilters();

		super.destroy();
	}
	
	private void RegisterEventHandlers()
	{
		addRequestHandler("lTest", LobbyRequests.class);
		addRequestHandler("c*", CommonRequests.class);
		
		
		
		/*addRequestHandler("GetUserInfo", GetUserInfoHandler.class);
		addRequestHandler("GetAppUsers", GetAllAppUsersHandler.class);
		addRequestHandler("GetUsersInRoom", GetUsersInRoomHandler.class);
		addRequestHandler("PreJoinRequest", PreJoinRequestHandler.class);
		addRequestHandler("GetUserFromFBID", GetUserFromFBIDHandler.class);
		addRequestHandler("AddAsBuddy", AddAsBuddyHandler.class);
		
		addRequestHandler("InvitedFriends", InvitedFriendsHandler.class);
		
		addRequestHandler("PlayNow", PlayNowHandler.class);
		addRequestHandler("InviteToPlay", InviteToPlayHandler.class);

		addRequestHandler("GetMyGifts", GetGiftExchangeHandler.class);
		addRequestHandler("GetMyGiftInventory", GetUserInventoryHandler.class);
		addRequestHandler("SendGift", SendGiftExchangeHandler.class);
		addRequestHandler("GetUnlockedGifts", GetUnlockedGiftsHandler.class);
		addRequestHandler("UpdateInventory", UpdateInventoryHandler.class);
		addRequestHandler("GetGiftsShop", FGetGiftShopHandler.class);
		addRequestHandler("GetPlayerGold", GetPlayerGoldHandler.class);
		addRequestHandler("AddDefaultFriends", AddDefaultFriendsHandler.class);
		addRequestHandler("GetCreditScreen", GetCreditsScreenHandler.class);
	
		addRequestHandler("UpdateBotList", UpdateBotListHandler.class);
		
		// hud
		addRequestHandler("GetLeaderBoard", GetLeaderboardHandler.class);
		addRequestHandler("GetKingOfTheDay", GetKingOfTheDayHandler.class);
		addRequestHandler("PlayerUpdatedGift", PlayerUpdatedGiftHandler.class);
		addRequestHandler("GetScoreCard", GetScoreCardHandler.class);
		addRequestHandler("ConvertGoldToChips", ConvertGoldToChipsHandler.class);
			
		// 3 Card Challenge
		addRequestHandler("ChallengePlayerForQuickRummy", QRChallengePlayerHandler.class);
		addRequestHandler("QuickRummyConfirmChallenge", QRConfirmChallengeHandler.class);
		addRequestHandler("GetMyChallenges", QRGetMyChallengesHandler.class);
		addRequestHandler("AcceptQRChallenge", QRAcceptChallengeHandler.class);
		addRequestHandler("QRDiscardCard", QRDiscardCardHandler.class);
		addRequestHandler("QRPickedCard", QRPickedCardHandler.class);
		addRequestHandler("QRShowCards", QRShowHandler.class);
		addRequestHandler("QRGetWinner", QRGetWinnerHandler.class);
		addRequestHandler("QuitQRChallenge", QRQuitChallengeHandler.class);
		addRequestHandler("QRGetChallenge", QRGetChallengeHandler.class);
		addRequestHandler("QRViewedResult", QRViewedResultHandler.class);
		addRequestHandler("QRDeclineChallenge", QRDeclineChallengeHandler.class);
		
		// temp, not needed now
		addRequestHandler("GetContestLeaders", GetContestLeadersHandler.class);
		
		// viral funnel handlers
		addRequestHandler("SaveInviteRequest", SaveInviteRequestHandler.class);
		addRequestHandler("UpdateRequest", SaveAsFriendHandler.class);
		addRequestHandler("GetMyFriends", GetMyFriendsHandler.class);
		addRequestHandler("GetPlayerStats", GetPlayerStatsHandler.class);
		addRequestHandler("HasPlayerLikedFanPage", HasPlayerLikedFanPageHandler.class);
		
		// server event
		addEventHandler(SFSEventType.USER_DISCONNECT, OnUserDisconnectedHandler.class);
		addEventHandler(SFSEventType.SERVER_READY, OnServerReadyHandler.class);*/
	}
	
	private void UnRegisterEventHandlers()
	{
		removeRequestHandler("l*");
		removeRequestHandler("c*");
		
		/*removeRequestHandler("GetAppUsers");
		removeRequestHandler("GetUsersInRoom");
		removeRequestHandler("PreJoinRequest");
		removeRequestHandler("GetUserFromFBID");
		removeRequestHandler("AddAsBuddy");
		
		removeRequestHandler("PlayNow");
		removeRequestHandler("CreateRoom");
		removeRequestHandler("InviteToPlay");

		removeRequestHandler("InvitedFriends");
		
		removeRequestHandler("GetUserInfo");
		removeRequestHandler("GetMyGifts");
		removeRequestHandler("GetMyGiftInventory");
		removeRequestHandler("SendGift");
		removeRequestHandler("GetUserInfo");
		removeRequestHandler("GetUnlockedGifts");
		removeRequestHandler("UpdateInventory");
		removeRequestHandler("GetGiftsShop");
		removeRequestHandler("GetPlayerGold");
		removeRequestHandler("AddDefaultFriends");
		removeRequestHandler("GetCreditScreen");
		
		// 3 Card Challenge
		removeRequestHandler("ChallengePlayerForQuickRummy");
		removeRequestHandler("QuickRummyConfirmChallenge");
		removeRequestHandler("GetMyChallenges");
		removeRequestHandler("AcceptQRChallenge");
		removeRequestHandler("QRGetWinner");
		removeRequestHandler("QuitQRChallenge");
		removeRequestHandler("QRGetChallenge");
		removeRequestHandler("QRViewedResult");
		removeRequestHandler("QRDeclineChallenge");
		
		// temp, not needed now
		removeRequestHandler("GetContestLeaders");
		
		// viral funnel handlers
		removeRequestHandler("SaveInviteRequest");
		removeRequestHandler("UpdateRequest");
		removeRequestHandler("GetMyFriends");
		removeRequestHandler("GetPlayerStats");
		
		// server event handlers
		removeEventHandler(SFSEventType.USER_DISCONNECT);
		
		removeRequestHandler("KillBot"); */
		
		trace("^^^^^^^^^^^^^^^^^^^^^^^^^^^^Lobby Cleaned^^^^^^^^^^^^^^^^^^^^");
	}
	
	private void readAppConfig()
	{
		// TODO: DB: App Config
		/*ISFSArray settings = _dbTaskManager.GetAppConfig();
		
		for(int i=0; i<settings.size(); i++)
		{
			ISFSObject setting = settings.getSFSObject(i);
			String settingName = setting.getUtfString("ConfigName");
			
			if(settingName.equals("InvitationTimeOut"))
			{
				MaxInvitationTime = Integer.parseInt(setting.getUtfString("ConfigValue"));
			}			
		}*/
	}
	
	public void createPrivateRoom(User whoInvited, User whoAccepted)
	{
		ISFSGameApi gameAPI = SmartFoxServer.getInstance().getAPIManager().getGameApi();
		Zone zone = this.getParentZone();

		List<User> recipientsList = new ArrayList<User>();
		recipientsList.add(whoInvited);
		recipientsList.add(whoAccepted);
		
		List<RoomVariable> roomVariableList = new ArrayList<RoomVariable>();

		int chips = 25;
		String groupID = "100";
		
		roomVariableList.add(new SFSRoomVariable("Bet", chips, false, true, false));
		roomVariableList.add(new SFSRoomVariable("Owner", whoInvited.getName(), false, true, false));
		
		RoomExtensionSettings extensionSettings = new RoomExtensionSettings("RummyExtension", "rummy.server.RummyNetExtension");
		
		CreateSFSGameSettings roomSettings = new CreateSFSGameSettings();
		
		String randomVal = "" + System.nanoTime(); 
		String usrName = randomVal.substring(randomVal.length() - 8, randomVal.length());
		roomSettings.setName("IN" + usrName);
		roomSettings.setGroupId(groupID);
		
		roomSettings.setDynamic(true);
		roomSettings.setGame(true);
		roomSettings.setHidden(true);
		roomSettings.setGamePublic(true);
		roomSettings.setMinPlayersToStartGame(2);
		roomSettings.setMaxUsers(2);
		roomSettings.setMaxVariablesAllowed(10);
		roomSettings.setMaxSpectators(2);
				
		roomSettings.setRoomVariables(roomVariableList);
		roomSettings.setExtension(extensionSettings);
		
		roomSettings.setAutoRemoveMode(SFSRoomRemoveMode.WHEN_EMPTY);
		
		Room room = null;
		try
		{
			trace("Room Created by !" + whoInvited.getName());
			room = gameAPI.createGame(zone, roomSettings, null);
			
			ISFSObject response = new SFSObject();
			response.putUtfString("RoomID", room.getName());
						
			this.send("RoomCreated", response, recipientsList);
		}
		catch (SFSCreateRoomException e)
		{
			this.send("RoomCreationFailed", null, recipientsList);
			e.printStackTrace();
		}	
	}
	
	public void sendInvitationResponse(Invitation invitation, String inviteType, String responseType, boolean isAutoResponse, User receiver)
	{
		String inviteeFBID = invitation.getInvitee().getName();
		
		// TODO: DB - Memcache get name from user info for inviteeFBID
		String inviteeName = "";
		
		ISFSObject response = new SFSObject();
		response.putUtfString("InviteType", inviteType);
		response.putUtfString("ResponseType", responseType);
		response.putUtfString("Invitee", invitation.getInvitee().getName());
		response.putUtfString("InviteeName", inviteeName);
		response.putUtfString("Inviter", invitation.getInviter().getName());

		response.putInt("InvitationID", invitation.getId());
				
		if(responseType.equals("Refused"))
		{
			response.putBool("IsAutoRefused", isAutoResponse);
		}
		
		this.send("InvitationResponse", response, receiver);
	}

		
	@Override
	public Object handleInternalMessage(String cmdName, Object params) {
		if (cmdName == "eventhandler") {
			return rummyContainer;
		}
		return super.handleInternalMessage(cmdName, params);
	}
}
