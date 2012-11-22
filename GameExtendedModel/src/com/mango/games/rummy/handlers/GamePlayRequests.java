package com.mango.games.rummy.handlers;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.utils.ActionConstants;
import com.mango.games.rummy.utils.FriendsManager;

import com.mangogames.rummy.RummyNetExtension;

import com.smartfoxserver.v2.annotations.Instantiation;
import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.annotations.Instantiation.InstantiationMode;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

@Instantiation(InstantiationMode.SINGLE_INSTANCE)
@MultiHandler
public class GamePlayRequests extends BaseClientRequestHandler
{
	@Override
	public void handleClientRequest(User user, ISFSObject params)
	{
		trace(" Extension " + this.getParentExtension().getName());
		
		trace(" Processing Request " + params.getDump());
		
		RummyNetExtension ext = (RummyNetExtension) this.getParentExtension();
		GameProxy proxy = ext.getGameProxy();
		
		IClientAdapter adapter = proxy.getClientAdapter();
		
		params.putUtfString("playerid", user.getName());
		params.putBool("IsServerEvent", false);
		
		try 
		{
			int eventHandled = adapter.handleEvent(params);
			String requestID = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
			
			if(eventHandled == 1)
			{
				if(requestID.equals(ActionConstants.JoinMe))
				{
					Room lastJoinedRoom = user.getLastJoinedRoom();
					
					ISFSObject joinedRoomDetails = new SFSObject();
					joinedRoomDetails.putUtfString("RoomJoinedName", lastJoinedRoom.getName());
					joinedRoomDetails.putInt("BetAmount", lastJoinedRoom.getVariable("Bet").getIntValue());
					joinedRoomDetails.putBool("IsSeated", false);
					
					FriendsManager.setBuddyVariableForUser(user, "RoomJoinedDetails", joinedRoomDetails);
				}
				
				if(requestID.equals(ActionConstants.SeatTaken))
				{
					Room lastJoinedRoom = user.getLastJoinedRoom();

					ISFSObject joinedRoomDetails = new SFSObject();
					joinedRoomDetails.putUtfString("RoomJoinedName", lastJoinedRoom.getName());
					joinedRoomDetails.putInt("BetAmount", lastJoinedRoom.getVariable("Bet").getIntValue());
					joinedRoomDetails.putBool("IsSeated", true);
				
					FriendsManager.setBuddyVariableForUser(user, "RoomJoinedDetails", joinedRoomDetails);
				}
				
				if(requestID.equals(ActionConstants.QuitToLobby))
				{
					ISFSObject roomDetails = new SFSObject();
					roomDetails.putNull("RoomJoinedName");
					FriendsManager.setBuddyVariableForUser(user, "RoomJoinedDetails", roomDetails);
					
					ISFSObject gameState = new SFSObject();
					gameState.putUtfString("State", "NA");
					FriendsManager.setBuddyVariableForUser(user, "GameState", gameState);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		/*if(requestID.equals(ActionConstants.JoinMe))
		{
			
		}		
		else if(requestID.equals(ActionConstants.SeatTaken))
		{
			
		}		
		else if(requestID.equals(ActionConstants.CardPicked))
		{
			
		}		
		else if(requestID.equals(ActionConstants.CardDiscarded))
		{
			
		}		
		else if(requestID.equals(ActionConstants.DropMe))
		{
			
		}		
		else if(requestID.equals(ActionConstants.ShowCardsInit))
		{
			
		}
		else if(requestID.equals(ActionConstants.ShowCards))
		{
			
		}*/
	}
}
