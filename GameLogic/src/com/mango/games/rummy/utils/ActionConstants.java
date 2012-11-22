package com.mango.games.rummy.utils;


public final class ActionConstants
{
	public static final int ActionProcessed = 1;
	public static final int ActionNotProcessed = 0;
	
	public static final int OpenDeck = 0;
	public static final int ClosedDeck = 1;
	
	public static final String JoinMe = "gjoinme";
	public static final String QuickJoin = "gqjoin";
	public static final String SeatTaken = "gseataken";
	public static final String CardPicked = "gcardpicked";
    public static final String CardDiscarded = "gcardiscard";
    public static final String ShowCards = "gdeclare";
    public static final String ShowCardsInit = "ginitshow";
    public static final String DropMe = "gdrop";
    public static final String QuitToLobby = "gtolobby";
    public static final String GetScoreCard = "gscorecard"; 
    public static final String PlayerUpdatedGift = "ggiftupdate";
    
    public static final String GetUserInfo = "luserinfo";
    public static final String GetGiftShop = "cgiftshop";
    public static final String BuyGift = "cgift";
    public static final String AddBuddy = "caddbuddy";
    public static final String GetGiftInventory = "cinventory";
    public static final String GetGiftInbox = "cgiftinbox";
    
    public static final String AddDefaultBuddies = "cdefbuddies";
    public static final String InviteToPlay = "cgameinvite";
    
    
    public static final String SaveInviteRequest = "cinvitereq";
    public static final String JoiningFromInvite = "cinvjoin";
    
    public static final String GetCurrentlyOnlinePlayers = "cconline";
    public static final String GetMyFriends = "cmyfriends";
    
    public static final String GetPlayerMangoGoldValue = "cgold";
    public static final String GetPurchaseGoldScreen = "ccpurchase";
    
    
	 /* TODO 
	 "InvitedFriends"
	 "GetAppUsers"
	
	// hud
	 "GetLeaderBoard"
	 "GetKingOfTheDay"
	 "PlayerUpdatedGift"
	 
	 "ConvertGoldToChips"
	
	 "GetMyGifts"
	 "GetMyGiftInventory"
	 "SendGift"
	 "GetUnlockedGifts"
	 "UpdateInventory"
	 "GetGiftsShop"
	 "GetPlayerGold"
	 "GetCreditScreen"
	 "GetPlayerStats"

	 "GetContestLeaders"
	
	// viral funnel handlers
	 "SaveInviteRequest"
	 "UpdateRequest"
	 "GetMyFriends"
	 "AddDefaultFriends"
	*/
}
