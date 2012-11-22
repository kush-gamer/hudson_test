package com.mango.games.rummy.utils;

import com.mangogames.rummy.LobbyExtension;
import com.mangogames.rummy.RummyNetExtension;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.invitation.Invitation;
import com.smartfoxserver.v2.entities.invitation.InvitationCallback;

public class InvitationHandler implements InvitationCallback 
{
	public boolean IsSent = false;
	public RummyNetExtension Ext = null;
	public LobbyExtension LobbyExt = null; 	
	public String InviteType = "";
		
	@Override
	public void onAccepted(Invitation arg0, ISFSObject arg1)
	{
		if(IsSent)
		{
			System.out.println("Invitation accepted" + arg0 + " " + arg1);
			
			if(InviteType.equals("AddAsBuddy"))
			{
				FriendsManager.addPermanentBuddy(arg0.getInviter(), arg0.getInvitee().getName(), 
						arg1.getUtfString("Name").toString());
			}
			else if(InviteType.equals("JoinNewGame"))
			{
				System.out.println("Invite to join new game - accepted");
				
				if(LobbyExt != null)
				{
					LobbyExt.createPrivateRoom(arg0.getInviter(), arg0.getInvitee());
				}
			}
			else if(arg1.getUtfString("InviteType").equals("JoinExistingGame"))
			{
				System.out.println("Invite to join existing game");
			}
		}
	}

	@Override
	public void onExpired(Invitation arg0)
	{
		if(IsSent)
		{
			if(LobbyExt != null)
			{
				LobbyExt.sendInvitationResponse(arg0, InviteType, "Expired", false, arg0.getInviter());
			}
			else if(Ext != null)
			{
				Ext.sendInvitationResponse(arg0, InviteType, "Expired", false, arg0.getInviter());
				
				//TODO: Ext.ResumeBotSpawn();
			}
						
			if(InviteType.equals("AddAsBuddy"))
			{
				User invitee = arg0.getInvitee();
			
				System.out.println("Invitation expired " + arg0);
				LobbyExt = (LobbyExtension) SmartFoxServer.getInstance().getExtensionManager().getZoneExtension(invitee.getZone());
				LobbyExt.sendInvitationResponse(arg0, InviteType, "Expired", false, invitee);
			}
		}
	}

	@Override
	public void onRefused(Invitation arg0, ISFSObject arg1) 
	{
		if(IsSent)
		{
			System.out.println("Invitation refused" + arg0 + " " + arg1);

			boolean isAutoRefused = arg1.getBool("IsAutoRefused");
			
			if(LobbyExt != null)
			{
				LobbyExt.sendInvitationResponse(arg0, InviteType, "Refused", isAutoRefused, arg0.getInviter());
			}
			else if(Ext != null)
			{
				Ext.sendInvitationResponse(arg0, InviteType, "Refused", isAutoRefused, arg0.getInviter());
				// TODO: Ext.ResumeBotSpawn();
			}

			System.out.println("Invitation refused" + arg0 + " " + arg1);
		}
	}
}
