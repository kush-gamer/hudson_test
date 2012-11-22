/**
 * 
 */
package com.mango.games.rummy.logic.actions;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.HandCards;
import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * @author admin
 *
 */
public class RummyActions implements IRummyActions 
{

	public RummyActions() 
	{
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.actions.IRummyActions#takeSeat(java.lang.String, long)
	 */
	@AEvent(msg="gjoinme")
	public int joinMe( @AParam(name="playerid") long playerID) throws Exception
	{
		return 0;
	}
	
	@AEvent(msg="gqjoin")
	public int quickJoin(@AParam(name="playerid") long playerID, @AParam(name="frombuddylist") boolean fromBuddyList, 
			@AParam(name="seatID") int seatID) throws Exception
	{
		return 0;
	}
	
	@AEvent(msg="gseataken")
	public int takeSeat( @AParam(name="playerid") long playerid,  @AParam(name="seatid") long seatid) 
	{
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.actions.IRummyActions#pickCardO(java.lang.String)
	 *
	 */

	@AEvent(msg="gcardpicked")
	public int cardPicked(@AParam(name="playerid")long playerID, @AParam(name="pickedfrom") int pickedFrom) 
	{
		return 0;
	}

	@AEvent(msg="gcardiscard")
	public int cardDiscarded(@AParam(name="playerid")long playerID, @AParam(name="discardedcard") Card discardedCard) 
	{
		return 0;
	}

	@AEvent(msg="ginitshow")
	public int showInitiated(@AParam(name="playerid") long playerID) 
	{
		return 0;
	}

	@AEvent(msg="gdeclare")
	public int declareCards(@AParam(name="playerid") long playerID,  @AParam(name="hand") HandCards cards, 
			@AParam(name="card") Card discardedCard) 
	{
		return 0;
	}
	

	@AEvent(msg="gdropme")
	public int dropMe(@AParam(name="playerid") long playerID) 
	{
		return 0;
	}
	
	@AEvent(msg="gtolobby")
	public int toLobby(@AParam(name="playerid") long playerID) 
	{
		return 0;
	}
	
	@AEvent(msg="userdisconnected")
	 public int userDisconnected(@AParam(name="playerid") long playerID)
	 {
		 return 0;
	 }


	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.actions.IRummyActions#showScoreCard(java.lang.String)
	 */
/*
	@AEvent(msg="gShowScoreCard")
	public int showScoreCard(@AParam(name="playerid") long playerid) 
	{
		return 0;
	}
	
	@AEvent(msg="lInvitedFriends")
	public int invitedFriends(@AParam(name="NoOfInvites") int noOfInvites, @AParam(name="GiftName") String giftName)
	{
		return 0;
	}
	
	@AEvent (msg="lGetLeaderBoard")
	public int getLeaderBoard(@AParam(name="Criteria") String criteria)
	{
		return 0;
	}
	
	@AEvent (msg="lPlayerUpdatedGift")
	public int playerUpdatedGift(@AParam(name="GiftID") int giftId, @AParam(name="CategoryName") String categoryName)
	{
		return 0;
	}
	
	@AEvent(msg="lGetContestLeaders")
	public int getContestLeaders(@AParam(name="ContestStartDate") String contestStartDate,@AParam(name="FacebookID") String facebookId)
	{
		return 0;
	}
	
	@AEvent(msg="lSaveInviteRequest")
	public int saveInviteRequest(@AParam(name="RequestID") String requestId, @AParam(name="SenderID") String senderId,@AParam(name="InvitedID") String invitedId)
	{
		return 0;
	}
	
	@AEvent(msg="lUpdateRequest")
	public int updateRequest(@AParam(name="RequestIDs") String requestId)
	{
		return 0;
	}

	@AEvent(msg="gDealCards")
	public int dealCards(@AParam(name="playerid", type="DealCardClass") Object dealCards, long plid) 
	{
		//Type cast object to you DealCardsClass
		// TODO Auto-generated method stub
		System.out.println(" Player picked Card " + plid + " From ");

		return 0;
	}
	
	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.actions.IRummyActions#act(com.smartfoxserver.v2.entities.data.ISFSObject)
	 */
	public int act(ISFSObject params) throws Exception
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EventDetails getEventHandlerMap(String messagename) {
		// TODO Auto-generated method stub. Leave it as it is
		return null;
	}
}
