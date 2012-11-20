package com.mango.games.db.sql;

public class UserSQL 
{
   //For User Table
	public static final String sqlCreatePlayer = 
		   "INSERT INTO user (first_name, last_name, emailid, externalid, extsrcid, gender, dob) VALUES ('%s', '%s', '%s', '%s', %d, '%s', '%s')";
   
   public static final String sqlGetPlayerById = "SELECT * FROM user WHERE id = %d";
   
   public static final String sqlGetFacebookId = "SELECT * FROM user WHERE externalid = '%s'";
   
   //For mGameType Table
   
   public static final String sqlCreateGameType = "INSERT INTO mGametype (name) VALUES ('%s')";
     
   public static final String sqlGetGameType = "SELECT * FROM mGametype WHERE id = %d";
   
   //For mGameDefinition Table
   
   public static final String sqlCreateGameDef = "INSERT INTO mGamedefinition(typeid, formatid, min_players, max_players, entryfee) VALUES ('%d','%d','%d','%d','%f')";
   
   public static final String sqlGetGameDefById = "SELECT * FROM mGamedefinition WHERE id = %d";
   
   public static final String sqlGetDefinitions = "SELECT * FROM mGamedefinition";
   
   //For Prize Table
   

   public static final String sqlGeneratePrize = "INSERT INTO prize(description, sponsor, img, icon, sponsor_logo) VALUES ('%s', '%s','%s','%s','%s')";

   
   public static final String sqlGetPrizeById = "SELECT * FROM prize WHERE id = %d";
   
   //For Game Table
		   
   public static final String sqlCreateGame = "INSERT INTO game (definitionid, prizeid, start_time, end_time) VALUES ('%d','%d','%s','%s')";
   
   public static final String sqlUpdateGame = "UPDATE game SET definitionid = %d , prizeid = %d , start_time = '%s' , end_time = '%s' WHERE id = %d";
   
   public static final String sqlGetGameById = "SELECT * FROM game WHERE id = %d";
   
   //For Game PLayer
   
   public static final String sqlCreateGamePlayer = "INSERT INTO gameplayer (gameid, userid, winner) VALUES (%d,%d , %d)";
   
   public static final String sqlGetGamePlayerByID = "SELECT * FROM gameplayer WHERE id = %d";
   
   public static final String sqlGetGamePlayerByUserID = "SELECT * FROM gameplayer WHERE userid = %d";
   
   public static final String sqlGetGamePlayerByGameID = "SELECT * FROM gameplayer WHERE gameid = %d";
   
   public static final String sqlUpdateGamePlayer = "UPDATE gameplayer SET gameid = %d , userid = %d , join_time = '%s' , leave_time = '%s' , winner = %d WHERE id = %d";
   
   //For DealPlayer
   
   public static final String sqlCreateDealPlayer = "INSERT INTO dealplayer(gameid, matchid, dealid, userid, points) VALUES('%d','%d','%d','%d','%d')";
   
   public static final String sqlUpdateDealPlayer = "UPDATE dealplayer SET gameid = %d , matchid = %d , dealid = %d , userid = %d , points = %d WHERE id = %d";
   
   public static final String sqlGetDealPlayerByID = "SELECT * FROM dealplayer WHERE id = %d";
   public static final String sqlGetDealPlayerByUserID = "SELECT * FROM dealplayer WHERE userid = %d";
   public static final String sqlGetDealPlayerByDealID = "SELECT * FROM dealplayer WHERE dealid = %d";
   
   // For User Account
   
   public static final String sqlCreateUserAccountDefault = "INSERT INTO useraccount(user_id) VALUES ('%d')";
   
   public static final String sqlCreateUserAccount = "INSERT INTO useraccount(chips, gold, experience, level, lastlogin, invitebonus, user_id) VALUES ('%s','%s','%d','%d','%s','%d','%d')";
   
   public static final String sqlUpdateUserAccount = "UPDATE useraccount SET chips = %d , gold = %d , experience = %d , level = %d , lastlogin = '%s', invitebonus = %d WHERE user_id = %d";
   

   public static final String sqlGetUserAccountById = "SELECT * FROM useraccount WHERE id = %d";
   
   public static final String sqlGetUserAccountByUserID = "SELECT * FROM useraccount WHERE user_id = %d";
   
   // GIFTS
   
   public static final String sqlCreateGift = "INSERT INTO gift(CategoryID , GiftID , Name , Chips , Image , Description , Count) VALUES ('%d' , '%s' , '%s' , '%d' , '%s' , '%s' , '%d')";
   public static final String sqlGetGiftByID = "SELECT * FROM gift WHERE AutoGiftID = %d";
   public static final String sqlGetGiftByGiftID = "SELECT * FROM gift WHERE GiftID = '%s'";
   public static final String sqlUpdateGift = "UPDATE gift SET CategoryID = %d , GiftID = '%s' , Name = '%s' , Chips = %d , Image = '%s' , Description = '%s' ,  Count = %d WHERE AutoGiftID = %d";
   public static final String sqlGetGiftByCategoryID = "SELECT * FROM gift WHERE CategoryID = %d";
   
   
   // Gifts Exchange
   
   public static final String sqlCreateGiftExchange = "INSERT INTO giftexchange(GiftID , Sender , Receiver , IsAccepted , DateOfExchange) " +
   		"						VALUES('%s' , '%s' , '%s' , '%d' , '%s')";
   public static final String sqlGetGiftExchangeByID = "SELECT * FROM giftexchange WHERE GiftExchangeID = %d";
   public static final String sqlGetGiftExchangeByGiftID = "SELECT * FROM giftexchange WHERE GiftID = '%s'";
   public static final String sqlUpdateGiftExchange = "UPDATE giftexchange SET GiftID = '%s' , Sender = '%s' , Receiver = '%s' , IsAccepted = %d , DateOfExchange = '%s' WHERE GiftExchangeID = %d";
   public static final String sqlGetGiftExchangeBySenderID = "SELECT * FROM giftexchange WHERE Sender = '%s'";
   
   //Achievements
   public static final String sqlCreateAchievement = "INSERT INTO achievements(AchievementID , FacebookID , BadgeID , IsCurrent , DateOfUnlock) " +
   								"VALUES ('%d' , '%s' , '%d' , '%d' , '%s')";
   public static final String sqlUpdateAchievements = "UPDATE achievements SET AchievementsID = %d , FacebookID = %s , BadgeID = %d , IsCurrent = %d , DateOfUnlock = %s WHERE ID = %d";
   public static final String sqlGetAchievementsByID = "SELECT * FROM achievements WHERE ID = %d";
   
   public static final String sqlGetAchievementByFacebookID_AchievementID = "SELECT * FROM achievements WHERE FacebookID = '%s' AND AchievementID = %d";
   public static final String sqlDeleteAchievements = "DELETE FROM achievements WHERE ID = %d";
   
   //Category
   public static final String sqlCreateCategory = "INSERT INTO category (CategoryName) VALUES ('%s')";
   public static final String sqlGetCategoryByID = "SELECT * FROM category WHERE CategoryID = %d";
   public static final String sqlGetCategoryList = "SELECT * FROM category";
   
   //GiftInventory
   
   public static final String sqlCreateGiftInventory = "INSERT INTO giftinventory (FacebookID , GiftID , Count , DateOfUpdate) " +
   									" Values ('%s' , '%s' , '%d' ,'%s')";
   public static final String sqlGetGiftInventoryByID = "SELECT * FROM giftinventory WHERE InventoryID = %d";
   public static final String sqlGetGiftInventoryByFacebookID = "SELECT * FROM giftinventory WHERE FacebookID = %s";
   public static final String sqlGetGiftInventoryByFacebookID_GiftID = "SELECT * FROM giftinventory WHERE FacebookID = '%s' AND GiftID = '%s'";
   
   public static final String sqlUpdateGiftInventory = "UPDATE giftinventory SET FacebookID = %s , GiftID = %s , Count = %d , DateOfUpdate = %s " +
   						" WHERE InventoryID = %d";
   
// Game Transaction
   public static final String sqlCreateGameTransaction = "INSERT INTO gametransaction (user_id , gameid ,, matchid , dealid , txtypeid , amount , currencyid) " +
   							" VALUES('%d' , '%d' , '%d' , '%d' ,'%d','%d','%d')	";
   public static final String sqlUpdateGameTransaction = "UPDATE gametransaction SET user_id = %d , gameid = %d , matchid = %d , dealid = %d , txtypeid = %d , amount = %d , currencyid = %d WHERE id = %d";
   
   public static final String sqlGetGameTransactionByID = "SELECT * FROM gametransaction WHERE id = %d";
   public static final String sqlGetGameTransactionByUserID = "SELECT * FROM gametransaction WHERE user_id = %d";
   
   //BotInfo
   
   public static final String sqlCreateBotInfo = "INSERT INTO bot (first_name, last_name, emailid, externalid, extsrcid, gender, dob) VALUES ('%s', '%s', '%s', '%s', %d, '%s', '%s')";
   public static final String sqlGetNextAvailableBot = "SELECT * FROM bot ORDER BY instance ASC Limit 1";
   public static final String sqlEngageBot = "UPDATE bot SET instance = instance + 1 WHERE id = %d";
   public static final String sqlReleaseBot = "UPDATE bot SET instance = instance - 1 WHERE id = %d";
   public static final String sqlReleaseAllBot = "UPDATE bot SET instance = 0";
   
   
   
   //Invite Request
   
   public static final String sqlCreateInviteRequest = "INSERT INTO inviterequests (RequestID , SenderFBID , InvitedFBID)" +
   								" VALUES ('%s' , '%s' , '%s')";
   public static final String sqlUpdateInviteRequest = "UPDATE inviterequests SET RequestID = '%s' , SenderFBID = '%s' , InvitedFBID = '%s' , Status = '%s' WHERE InvitationID = %d";
   
   public static final String sqlGetInviteRequestsByID = "SELECT * FROM inviterequests WHERE InvitationID = %d";
   
   public static final String sqlGetInviteRequestByRequestID = "SELECT * FROM inviterequests WHERE RequestID = %s";
   public static final String sqlGetInviteRequestBySenderId_ReceiverID = "SELECT * FROM inviterequests WHERE SenderFBID = '%s' AND InvitedFBID = '%s'";
   
   public static final String sqlGetInvitedRequestBySenderID_Status = "SELECT * FROM inviterequests WHERE SenderFBID = '%s' AND Status = '%s'";
   
   
   //mCurrency
   
   public static final String sqlCreatemCurrency = "INSERT INTO mCurrency(type) VALUES ('%s')";
   public static final String sqlUpdatemCurrency = "UPDATE mCurrency SET type = '%s' WHERE id = %d";
   public static final String sqlGetmCurrencyByID = "SELECT * FROM mCurrency WHERE id = %d";
   public static final String sqlGetmCurrencyByType = "SELECT * FROM mCurrency WHERE type = '%s'";
   public static final String sqlDeletemCurrency = "DELETE FROM mCurrency WHERE id = %d";
   
   
   // Game Dealer
   public static final String sqlCreategameDealer = "INSERT INTO gamedealer(gameid , matchid , dealid , chips , gold) " +
   											"VALUES (%d , %d , %d , %d , %d)";
   
   public static final String sqlGetGameDealerByID = "SELECT * FROM gamedealer WHERE id = %d";
   public static final String sqlGetGameDealerByGameID = "SELECT * FROM  gamedealer WHERE gameid = %d";
   public static final String sqlGetGameDealerByGameID_MatchID = "SELECT * FROM gamedealer WHERE gameid = %d AND matchid = %d";
   public static final String sqlGetGameDealerByGameID_MatchID_DealID = "SELECT * FROM gamedealer WHERE gameid = %d AND matchid = %d AND dealid = %d";
   public static final String sqlUpdateGameDealer = "UPDATE gamedealer SET gameid = %d , matchid = %d , dealid = %d , chips = %d , gold = %d WHERE id = %d";
   public static final String sqlDeleteGameDealer = "DELETE FROM gamedealer WHERE id = %d";
   
   //mTransactionType
   
   public static final String sqlCreatemTransactionType = "INSERT INTO mTransactiontype(description , type) VALUES ('%s', '%s')";
   public static final String sqlGetmTransactionTypeByID = "SELECT * FROM mTransactiontype WHERE id = %d";
   public static final String sqlGetmTransactionTypeByType = "SELECT * FROM mTransactiontype WHERE type = '%s'";
   public static final String sqlUpdatemTransactionType = "UPDATE mTransactiontype SET description = '%s' , type = '%s' WHERE id = %d";
   public static final String sqlDeletemTransactionType = "DELETE FROM mTransactiontype WHERE id = %d";
   
   // mFormat
   
   public static final String sqlCreatemFormat = "INSERT INTO mFormat(name) VALUES('%s')";
   public static final String sqlUpdatemFormat = "UPDATE mFormat SET name = '%s' WHERE id = %d";
   public static final String sqlGetmFormatByID = "SELECT * FROM mFormat WHERE id = %d";
   public static final String sqlDeletemFormat = "DELETE FROM mFormat WHERE id = %d";

   
}
