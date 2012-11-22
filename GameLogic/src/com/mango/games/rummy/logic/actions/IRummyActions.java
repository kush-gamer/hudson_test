/**
 * 
 */
package com.mango.games.rummy.logic.actions;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.HandCards;
import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * A catalog of all actions that are called from client to server side. 
 * These actions are executed by appropriate state machines (Tournament, Game, Match or Deal)
 * An action may be executed by multiple state machines at the same time - That is, both Match and Deal may
 * want to act upon a client side request/event. We use chain of command pattern for event handling.
 * 
 * Using a global interface file for all actions, so that all event handlers can be examined from this file itself.
 * Eventually, this interface and corresponding action handlers can all be auto generated for other games (such as teen-patty, poker etc).
 *
 * This is the second IP of a turn-based game, First one being a domain model.
 *
 * @author Sanjeev
 *
 */
public interface IRummyActions 
{
	/* Note that a game/table/deal is already resolved (by SFX Server handler) before an event gets sent to the event handler
	 */
	
	// GameNotStarted, GameWaitingToStart
	public int joinMe(long playerID) throws Exception;
	
	public int quickJoin(long playerID, boolean fromBuddyList, int seatID) throws Exception;
	
	/**
	 * Player requesting to take a given seat. Allocates the seat and sends a confirmation to plyaer.
	 * If there is a conflict (concurrent attempts to take the seat), then 
	 * a error message should be sent to the player.
	 * @param playerid
	 * @param seatid
	 */
	 public int takeSeat(long playerID, long seatid);
	 
	 // DealPlaying
	 public int cardPicked(long playerID, int pickedFrom);
	 
	 public int cardDiscarded(long playerID, Card discardedCard);
	 
	 public int showInitiated(long playerID);
	 
	 public int declareCards(long playerID, HandCards cards, Card discardedCard);
	 
	 public int dropMe(long playerID);
	 
	 public int userDisconnected(long playerID);
	 
	 public int toLobby(long playerID);
    
    /**
     * Player making a request to show his/her score-card. This results in score details getting sent to the player
     * @param playerid
     */
    //public int showScoreCard(long playerid);
    
    /**
     * Player requesting to pick a card from open deck. 
     *
     */

    
      
    /**
     * Finally this is the call that lands up with the first STM handling actions. 
     * This method extracts the parameters and calls the appropriate method call defined above in the interface.
     * 
     * @param params
     * @return
     */
    
    //public int invitedFriends(int noOfInvites, String giftName);
    
    
    //public int getLeaderBoard(String criteria);
    
    //public int playerUpdatedGift(int giftId,String categoryName);
    //public int getContestLeaders(String contestStartDate,String facebookId);
    //public int saveInviteRequest(String requestId,String senderId,String invitedId);
    //public int updateRequest(String requestId);
    
    public int act(ISFSObject params) throws Exception;
    /**
     * Currently use ISFSObject as a container for events and parameters.
     * ISFSObject ties us closely to the SmartFoxServer interfaces. Ideally we want this
     * code to be not aware of SFS. But for faster turnaround, using it currently to be changed later.
     * TODO - Remove dependency from ISFSObject.
     * @param params
     */
    
    
    /**
     * The event details map keeps the event handler signature for a given message.
     * This map is loaded during the application initialization time, and is retained
     * as a singleton instance in the adapter. This method should be implemented
     * in a super class having visibility to eventdetails map.
     * @param messagename
     * @return
     */
    EventDetails getEventHandlerMap(String messagename);
    
 }
