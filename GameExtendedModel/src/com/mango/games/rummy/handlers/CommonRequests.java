package com.mango.games.rummy.handlers;

import com.mango.games.db.UserAccount;
import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.FriendsManager;
import com.mango.games.rummy.utils.GiftManager;
import com.mango.games.rummy.utils.InvitationHandler;
import com.mango.games.rummy.utils.UserHelper;
import com.mangogames.rummy.LobbyExtension;
import com.mangogames.rummy.RummyNetExtension;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.entities.invitation.Invitation;
import com.smartfoxserver.v2.entities.invitation.SFSInvitation;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)		
@MultiHandler
public class CommonRequests extends BaseClientRequestHandler
{
	@Override
	public void handleClientRequest(User user, ISFSObject params)
	{		
		String requestID = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		
		if(requestID.equals(ActionConstants.GetGiftShop))
		{
			ISFSObject response = GiftManager.getGiftShop();
			this.send("GiftShop", response, user);
		}
		else if(requestID.equals(ActionConstants.BuyGift))
		{
			GiftManager.buyGift(user, params, this.getParentExtension());
		}
		else if(requestID.equals(ActionConstants.GetGiftInbox))
		{
			GiftManager.getGiftInbox(Long.parseLong(user.getName()));
		}
		else if(requestID.equals(ActionConstants.GetGiftInventory))
		{
			GiftManager.getGiftInventory(Long.parseLong(user.getName()));
		}
		else if(requestID.equals(ActionConstants.AddBuddy))
		{
			addBuddy(user, params);
		}
		else if(requestID.equals(ActionConstants.GetCurrentlyOnlinePlayers))
		{
			ISFSObject response = new SFSObject();
			response.putInt("TempBuddyCount", FriendsManager.getOnlinePlayers(user)); //TODO: both are same
			response.putInt("CurrentlyOnline", FriendsManager.getOnlinePlayers(user));
			
	    	this.send("RummyPlayers", response, user);
		}
		else if(requestID.equals(ActionConstants.GetMyFriends))
		{
			ISFSObject response = new SFSObject();
			ISFSArray friends = FriendsManager.getMyFriends(user);
			
			response.putSFSArray("Friends", friends);

			this.send("MyFriends", response, user);
		}
		else if(requestID.equals(ActionConstants.AddDefaultBuddies))
		{
			FriendsManager.addDefaultBuddies(params.getSFSArray("Friends"), user);
		}
		else if(requestID.equals(ActionConstants.InviteToPlay))
		{
			inviteToPlay(user, params);
		}
		else if(requestID.equals(ActionConstants.SaveInviteRequest))
		{
			String inviteRequestID = params.getUtfString("RequestID");
			String senderID = params.getUtfString("SenderID");
			String invitedID = params.getUtfString("InvitedID");

			FriendsManager.saveInviteRequest(senderID, inviteRequestID, invitedID, this.getParentExtension());
		}
		else if(requestID.equals(ActionConstants.JoiningFromInvite))
		{
			FriendsManager.handlePlayerJoiningFromInvite(user.getName(), params, this.getParentExtension());
		}
	}
	
	private void addBuddy(User inviter, ISFSObject data)
	{
		String inviteeID = data.getUtfString("FacebookID");
		
		String inviteeNickName = "";
		String inviterNickName = "";
		
		// TODO: DB Done -Memcache, get firstname of from FBID for invitee and from  user for inviter
		
		long inviteeUserID = com.mango.games.db.UserDB.getUserbyFBID(inviteeID).getId(); //TODO: DB Done -Memcache
		
		User invitee = UserHelper.GetUserInZone(inviteeUserID, this.getParentExtension().getParentZone());
		
		ISFSObject inviteParams = new SFSObject();
		inviteParams.putUtfString("Sender", inviter.getName());
		inviteParams.putUtfString("InviteType", "AddAsBuddy");
		
		inviteParams.putUtfString("InviteeFBID", inviteeID);
		inviteParams.putUtfString("InviteeNickName", inviteeNickName);
		inviteParams.putUtfString("InviterNickName", inviterNickName);
		
		// get the lobby extension
		LobbyExtension lobbyExt = (LobbyExtension) SmartFoxServer.getInstance().getExtensionManager().
				getZoneExtension(inviter.getZone());
				
		int invitationExpiryTime = lobbyExt.MaxInvitationTime;
		Invitation invitation = new SFSInvitation(inviter, invitee, invitationExpiryTime, inviteParams);
		
		InvitationHandler cb = new InvitationHandler();
		cb.onAccepted(invitation, new SFSObject());
		cb.onRefused(invitation, new SFSObject());
		cb.onExpired(invitation);
		cb.InviteType = "AddAsBuddy";
				
		if(this.getParentExtension() instanceof LobbyExtension)
		{
			cb.LobbyExt = (LobbyExtension) this.getParentExtension();
		}
		else if(this.getParentExtension() instanceof RummyNetExtension)
		{
			RummyNetExtension ext = (RummyNetExtension) this.getParentExtension(); 
			cb.Ext = ext;
		}
		
		SmartFoxServer.getInstance().getAPIManager().getGameApi().sendInvitation(invitation, cb);
		trace("Sending invitation now");
		cb.IsSent = true;
				
		this.send("InviteSuccess", inviteParams, inviter);
	}
	
	private void inviteToPlay(User inviter, ISFSObject data)
	{
		String inviteeID = data.getUtfString("FacebookID");
		
		com.mango.games.db.UserDB inviterUserobj = com.mango.games.db.UserDB.getUserbyID(Long.parseLong(inviter.getName()));
		com.mango.games.db.UserDB inviteeUserobj = com.mango.games.db.UserDB.getUserbyFBID(inviteeID);
		
		UserAccount inviterUserAcc = UserAccount.getUserAccountbyUserID(inviterUserobj.getId());
		
		String inviteeNickName = inviteeUserobj.getFirst_name();
		String inviterNickName = inviterUserobj.getFirst_name();
		
		// TODO: DB Done -Memcache, get and set names (firstnames)
		
		
		long inviteeUserID = inviteeUserobj.getId(); //TODO: DB Done -Memcache
		
		User invitee = UserHelper.GetUserInZone(inviteeUserID, 
				this.getParentExtension().getParentZone());
		
		ISFSObject inviteParams = new SFSObject();
		
		inviteParams.putUtfString("Sender", inviter.getName());
		inviteParams.putUtfString("InviteeFBID", inviteeID);
		inviteParams.putUtfString("InviteeNickName", inviteeNickName);
		inviteParams.putUtfString("InviterNickName", inviterNickName);
		
		String inviteType = "";
		
		Room room = inviter.getLastJoinedRoom();
		
		if(room == null)
		{
			//TODO: DB Done -memcache check if user has insufficient chips
			
			int chips = inviterUserAcc.getChips();// TODO:
			if((chips - 25) < 0) //TODO: HARDCODED FOR 25, check for variations
			{
				this.send("InsufficientChips", data, inviter);
				return;
			}
			
			inviteType = "JoinNewGame";
			inviteParams.putUtfString("InviteType", inviteType);
		}
		else
		{
			// with the seatno
			int seatNo = data.getInt("SeatNo");
			
			inviteParams.putUtfString("RoomName", inviter.getLastJoinedRoom().getName());
			inviteParams.putInt("SeatNo", seatNo);
			inviteType = "JoinExistingGame";
			
			int betAmount = room.getVariable("Bet").getIntValue();
			inviteParams.putInt("BetAmount", betAmount);
			
			inviteParams.putUtfString("InviteType", inviteType);
		}
				
		Invitation invitation = new SFSInvitation(inviter, invitee, 12, inviteParams);
		
		InvitationHandler cb = new InvitationHandler();
		cb.onAccepted(invitation, new SFSObject());
		cb.onRefused(invitation, new SFSObject());
		cb.onExpired(invitation);
		cb.InviteType = inviteType;
		
		if(this.getParentExtension() instanceof LobbyExtension)
		{
			cb.LobbyExt = (LobbyExtension) this.getParentExtension();
		}
		else if(this.getParentExtension() instanceof RummyNetExtension)
		{
			RummyNetExtension ext = (RummyNetExtension) this.getParentExtension(); 
			cb.Ext = ext;

			// pause bot spawn in this room
			//TODO: ext.PauseBotSpawn(10);
		}
		
		SmartFoxServer.getInstance().getAPIManager().getGameApi().sendInvitation(invitation, cb);
		
		cb.IsSent = true;
		
		inviteParams.putInt("InvitationID", invitation.getId());
		this.send("InviteSuccess", inviteParams, inviter);
	}
}
