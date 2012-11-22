package com.mangogames.rummy;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.handlers.CommonRequests;
import com.mango.games.rummy.handlers.GamePlayRequests;
import com.mango.games.rummy.handlers.OnServerReadyHandler;
import com.mango.games.rummy.handlers.OnUserJoinRoom;
import com.mango.games.rummy.logic.common.RummyContainer;
import com.mango.games.rummy.logic.common.ServerResponseManager;
import com.mango.games.rummy.utils.di.InjectionModule;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.entities.invitation.Invitation;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class RummyNetExtension extends SFSExtension
{ 
	Room _currentRoom = null;
	
	@Inject
	GameProxy _gameProxy = null;
	
	@Override
	public void init() 
	{
		trace("------ Room Extension: " + System.currentTimeMillis() + "-----------");
		RegisterRequestHandlers();
	}
	
	@Override
	public void destroy()
	{
		UnRegisterRequestHandlers();
		
		clearAllHandlers();
		clearFilters();
		
		super.destroy();
	}
	
	private void RegisterRequestHandlers()
	{
		addRequestHandler("lTest", GamePlayRequests.class);
		addRequestHandler("g*", GamePlayRequests.class);
		addRequestHandler("c*", CommonRequests.class);
		addRequestHandler("gjoinme", GamePlayRequests.class);
		addEventHandler(SFSEventType.USER_JOIN_ROOM, OnUserJoinRoom.class);
		addEventHandler(SFSEventType.SERVER_READY, OnServerReadyHandler.class);
		
		// Subscribing the game request handlers
		/*addRequestHandler("JoinMe", JoinMeHandler.class);
		addRequestHandler("SeatTaken", TakeSeatHandler.class);
		addRequestHandler("CardPicked", PickedCardHandler.class);
		addRequestHandler("CardDiscarded", DiscardCardHandler.class);
		addRequestHandler("ShowCards", ShowHandler.class);
		addRequestHandler("ShowCardsInit", ShowInitHandler.class);
		addRequestHandler("DropMe", DropMeHandler.class);
		addRequestHandler("QuitToLobby", QuitToLobbyHandler.class);
	
		addRequestHandler("InvitedFriends", InvitedFriendsHandler.class);
		addRequestHandler("GetAppUsers", GetAllAppUsersHandler.class);
		addRequestHandler("GetUserFromFBID", GetUserFromFBIDHandler.class);
		
		// hud
		addRequestHandler("GetLeaderBoard", GetLeaderboardHandler.class);
		addRequestHandler("GetKingOfTheDay", GetKingOfTheDayHandler.class);
		addRequestHandler("PlayerUpdatedGift", PlayerUpdatedGiftHandler.class);
		addRequestHandler("GetScoreCard", GetScoreCardHandler.class);
		addRequestHandler("ConvertGoldToChips", ConvertGoldToChipsHandler.class);
		
		addRequestHandler("GetMyGifts", GetGiftExchangeHandler.class);
		addRequestHandler("GetMyGiftInventory", GetUserInventoryHandler.class);
		addRequestHandler("SendGift", SendGiftExchangeHandler.class);
		addRequestHandler("GetUnlockedGifts", GetUnlockedGiftsHandler.class);
		addRequestHandler("UpdateInventory", UpdateInventoryHandler.class);
		addRequestHandler("GetGiftsShop", FGetGiftShopHandler.class);
		addRequestHandler("GetPlayerGold", GetPlayerGoldHandler.class);
		addRequestHandler("GetCreditScreen", GetCreditsScreenHandler.class);
		addRequestHandler("GetPlayerStats", GetPlayerStatsHandler.class);
	
		addRequestHandler("GetContestLeaders", GetContestLeadersHandler.class);
		
		// viral funnel handlers
		addRequestHandler("SaveInviteRequest", SaveInviteRequestHandler.class);
		addRequestHandler("UpdateRequest", SaveAsFriendHandler.class);
		addRequestHandler("GetMyFriends", GetMyFriendsHandler.class);
		addRequestHandler("AddDefaultFriends", AddDefaultFriendsHandler.class);
		addRequestHandler("HasPlayerLikedFanPage", HasPlayerLikedFanPageHandler.class);
		addRequestHandler("AddAsBuddy", AddAsBuddyHandler.class);
		addRequestHandler("InviteToPlay", InviteToPlayHandler.class);
		
		
		// 3CC
		addRequestHandler("QRDiscardCard", QRDiscardCardHandler.class);
		addRequestHandler("QRPickedCard", QRPickedCardHandler.class);
		addRequestHandler("QRShowCards", QRShowHandler.class);
		addRequestHandler("ChallengePlayerForQuickRummy", QRChallengePlayerHandler.class);
		addRequestHandler("QuickRummyConfirmChallenge", QRConfirmChallengeHandler.class);
		addRequestHandler("GetMyChallenges", QRGetMyChallengesHandler.class);
		addRequestHandler("AcceptQRChallenge", QRAcceptChallengeHandler.class);
		addRequestHandler("QRGetWinner", QRGetWinnerHandler.class);
		addRequestHandler("QuitQRChallenge", QRQuitChallengeHandler.class);
		addRequestHandler("QRGetChallenge", QRGetChallengeHandler.class);
		addRequestHandler("QRViewedResult", QRViewedResultHandler.class);
		addRequestHandler("QRDeclineChallenge", QRDeclineChallengeHandler.class);
		
		// server event handlers
		addEventHandler(SFSEventType.USER_DISCONNECT, OnPlayerGoneHandler.class);
		//addEventHandler(SFSEventType.ROOM_VARIABLES_UPDATE, RoomVariableUpdatedHandler.class);
		
		// for qa
		addRequestHandler("GetQuitXP", GetQuitXPHandler.class);
		
		// outside injection
		addRequestHandler("KillBot", KillBotHandler.class);*/
	}
	
	private void UnRegisterRequestHandlers()
	{
		removeRequestHandler("g*");
		removeRequestHandler("c*");

		// Subscribing the game request handlers
		/*removeRequestHandler("JoinMe");
		removeRequestHandler("SeatTaken");
		removeRequestHandler("CardPicked");
		removeRequestHandler("CardDiscarded");
		removeRequestHandler("ShowCards");
		removeRequestHandler("ShowCardsInit");
		removeRequestHandler("DropMe");
		removeRequestHandler("QuitToLobby");
		removeRequestHandler("GetUserFromFBID");
	
		removeRequestHandler("InvitedFriends");
		removeRequestHandler("GetAppUsers");
		
		// hud
		removeRequestHandler("GetLeaderBoard");EventHandlerMap.getEventHandlerMap().getEventDetailsMap(messageName);
		removeRequestHandler("GetKingOfTheDay");
		removeRequestHandler("PlayerUpdatedGift");
		removeRequestHandler("GetScoreCard");
		removeRequestHandler("ConvertGoldToChips");
		
		removeRequestHandler("GetMyGifts");
		removeRequestHandler("GetMyGiftInventory");
		removeRequestHandler("SendGift");
		removeRequestHandler("GetUnlockedGifts");
		removeRequestHandler("UpdateInventory");
		removeRequestHandler("GetGiftsShop");
		removeRequestHandler("GetPlayerGold");
		removeRequestHandler("GetCreditScreen");
		removeRequestHandler("GetPlayerStats");
	
		removeRequestHandler("GetContestLeaders");
		
		// viral funnel handlers
		removeRequestHandler("SaveInviteRequest");
		removeRequestHandler("UpdateRequest");
		removeRequestHandler("GetMyFriends");
		removeRequestHandler("AddDefaultFriends");
		removeRequestHandler("HasPlayerLikedFanPage");
		removeRequestHandler("InviteToPlay");
		
		// 3CC
		removeRequestHandler("QRDiscardCard");
		removeRequestHandler("QRPickedCard");
		removeRequestHandler("QRShowCards");
		removeRequestHandler("ChallengePlayerForQuickRummy");
		removeRequestHandler("QuickRummyConfirmChallenge");
		removeRequestHandler("GetMyChallenges");
		removeRequestHandler("AcceptQRChallenge");
		removeRequestHandler("QRGetWinner");
		removeRequestHandler("QuitQRChallenge");
		removeRequestHandler("QRGetChallenge");
		removeRequestHandler("QRViewedResult");
		removeRequestHandler("QRDeclineChallenge");
		
		// for qa
		removeRequestHandler("GetQuitXP");		
		
		removeEventHandler(SFSEventType.USER_DISCONNECT);
		//removeEventHandler(SFSEventType.ROOM_VARIABLES_UPDATE);
		
		// outside injection
		removeRequestHandler("KillBot");*/
	}
	
	public void sendInvitationResponse(Invitation invitation, String inviteType, String responseType, 
			boolean isAutoResponse, User receiver)
	{
		String inviteeFBID = invitation.getInvitee().getName();
		
		// TODO: DB Done -Memecache get name from user info for invitee
		//UserData info = UserInfoManager.GetInstance().GetUserInfo(inviteeFBID);
		com.mango.games.db.UserDB inviteeobj = com.mango.games.db.UserDB.getUserbyFBID(inviteeFBID);
		String inviteeName = inviteeobj.getFirst_name();
		
		ISFSObject response = new SFSObject();
		response.putUtfString("InviteType", inviteType);
		response.putUtfString("ResponseType", responseType);
		response.putUtfString("Invitee", inviteeFBID);
		response.putUtfString("InviteeName", inviteeName);
		response.putUtfString("Inviter", invitation.getInviter().getName());
		
		response.putInt("InvitationID", invitation.getId());
		
		if(responseType.equals("Refused"))
		{
			response.putBool("IsAutoRefused", isAutoResponse);
		}		
				
		this.send("InvitationResponse", response, receiver);
	}
	
	public GameProxy getGameProxy()
	{
		return _gameProxy;
	}

	public void onServerReady() 
	{
		_currentRoom = this.getParentRoom();
		int gameType = Integer.parseInt(_currentRoom.getGroupId());
		long roomID = _currentRoom.getId();
		int maxSeats = _currentRoom.getMaxUsers();
		int prizePool = _currentRoom.getVariable("Bet").getIntValue();
		//int prizePool = 25;
		
		Injector injector  = Guice.createInjector(new InjectionModule());
		
		//Create a new room using the Injector
		_gameProxy = injector.getInstance(GameProxy.class);		
		_gameProxy.createNewGame(roomID, maxSeats, prizePool, gameType);
		
		_currentRoom = this.getParentRoom();
		_gameProxy.getClientAdapter().setServerResponseManager(new ServerResponseManager(_currentRoom));
		
		// Get parent zone and add EventHandler to the Client adapter
		
		//LobbyExtension ext = (LobbyExtension) this.getParentZone().getExtension();
		//LobbyExtension ext = (LobbyExtension)SmartFoxServer.getInstance().getZoneManager().getZoneByName("Rummy").getExtension();
		RummyContainer rummyContainer = (RummyContainer)this.getParentZone().getExtension().handleInternalMessage("eventhandler", null);
		_gameProxy.getClientAdapter().setEventHandlerMap(rummyContainer.eventHandlerMap);
	}
}
