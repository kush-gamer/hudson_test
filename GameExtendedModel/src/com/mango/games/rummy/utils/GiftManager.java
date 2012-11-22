package com.mango.games.rummy.utils;

//import com.mango.games.db.PlayerDB;
import java.util.List;

import com.mango.games.db.Category;
import com.mango.games.db.Gift;
import com.mango.games.db.GiftExchange;
import com.mango.games.db.GiftInventory;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import com.mango.games.rummy.achievements.Achievement;
import com.mango.games.rummy.achievements.AchievementManager;
import com.mango.games.rummy.achievements.Effort;

public class GiftManager
{
	//private static PlayerDB _playerDB = new PlayerDB();

	public static ISFSObject getGiftShop()
	{
		ISFSObject giftShop = new SFSObject();
		
		ISFSArray items = new SFSArray();
		
		ISFSArray categories = getCategories();
		for(int i=0; i<categories.size(); i++)
		{
			ISFSObject row = categories.getSFSObject(i);
			
			ISFSArray gifts = getGiftsForCategory(row.getInt("CategoryID"));
			
			row.putSFSArray("Gifts", gifts);
			
			items.addSFSObject(row);
		}
		
		giftShop.putSFSArray("Items", items);
		
		return giftShop;
	}
	
	public static void buyGift(User sender, ISFSObject params, SFSExtension ext)
	{
		//String receiverID = params.getUtfString("FBIDReceiver");
		
		//boolean fromGame = params.getBool("FromGame");
		boolean forAll = params.getBool("ForAll");
		
		String giftID = params.getUtfString("GiftID");		
		//String giftName = params.getUtfString("GiftName");
		//String categoryName = params.getUtfString("CategoryName");	
		//String name = params.getUtfString("Name");
		int price = params.getInt("Price");		
		
		String fbid = params.getUtfString("FBIDReceiver");
		com.mango.games.db.UserDB userobj = com.mango.games.db.UserDB.getUserbyFBID(fbid);
		//userobj.getId();
		long receiverUserID = userobj.getId(); //TODO: DB DONE memcache, get user id for the given source id
		long senderUserID = Long.parseLong(sender.getName()); 
		
		// update sender's chips
		updateUserInfo(giftID, price, senderUserID, ext);
		
		// send gift		
		// bought for self? update inventory
		if(senderUserID == receiverUserID)
		{
			updateInventory(params, senderUserID, ext);
		}
		else
		{
			if(forAll == true) // and of course fromGame = true
			{
				sendToAll(params, senderUserID, ext);
			}
			else 
			{
				sendGift(params, senderUserID, receiverUserID, ext);
			}
		}
		
		// update achievements
		updateAchievements(senderUserID, params, ext);
	}
	
	public static void setCurrentGift(ISFSObject giftData, boolean fromGame, SFSExtension ext)
	{
		// TODO: DB Not Done Memcache, update current gift value
		/*
		 *  Create Table to store User's Current GiftID
		 */
		
		if(fromGame == true)
		{
			// inform others
			ext.send("UpdatePlayerGift", giftData, UserHelper.GetUsersList(ext.getParentRoom()));
		}
	}
	
	public static ISFSArray getGiftInventory(long playerID)
	{
		//TODO: DB - get gift inventory for the user
		return null;
	}
	
	public static ISFSArray getGiftInbox(long playerID)
	{
		// TODO: DB - Get all recent gifts received from gift exchange where IsAccepted = 0
		return null;
	}
	
	public static int getTotalGiftsSent(long playerID)
	{
		// TODO: DB Done get total gifts sent
		com.mango.games.db.UserDB obj = com.mango.games.db.UserDB.getUserbyID(playerID);
		String userfbid = obj.getExternalid();
		List<GiftExchange> giftexchange = GiftExchange.getGiftExchangeBySenderID(userfbid);
		return giftexchange.size();
		//return 0;
	}
	
	private static ISFSArray getCategories()
	{
		ISFSArray categories = new SFSArray();
		Category.getCategoryList();
		// TODO: DB Done, get all categories, fill in category array with category id and category name
		
		return categories;
	}
	
	private static ISFSArray getGiftsForCategory(int categoryID)
	{
		ISFSArray gifts =  new SFSArray();
		List<Gift> giftList = Gift.getGiftByCategoryID(categoryID);
		int giftSize = giftList.size();
		ISFSObject giftSFSobject = new SFSObject();
		for(int i =0;i<giftSize ; i++)
		{
			Gift giftobj = giftList.get(i);
			giftSFSobject.putUtfString("Description", giftobj.getDescription());
			giftSFSobject.putUtfString("GiftID", giftobj.getGiftID());
			giftSFSobject.putUtfString("Image", giftobj.getImage());
			giftSFSobject.putUtfString("Name", giftobj.getName());
			giftSFSobject.putInt("AutoGiftID", giftobj.getAutoGiftID());
			giftSFSobject.putInt("CategoryID", giftobj.getCategoryID());
			giftSFSobject.putInt("Chips", giftobj.getChips());
			giftSFSobject.putInt("Count", giftobj.getCount());
			
			gifts.addSFSObject(giftSFSobject);
		}
		// TODO: DB Done get all gifts corresponding to the parameter categoryID
		
		return gifts;
	}
	
	private static void updateInventory(ISFSObject giftData, long userID, SFSExtension ext)
	{
		//TODO: DB Done, update giftexchange, set isAccepted to true
		// update giftinventory, update gift count if gift exists else insert gift.
		GiftExchange giftexcobj = GiftExchange.getGiftExchangebyID(giftData.getInt("GiftExchangeID"));
		
		//giftexcobj.setReceiver(giftData.getUtfString("FBIDReceiver"));
		
		//com.mango.games.db.User userobj = com.mango.games.db.User.getUserbyID(userID);
		//String fbid = userobj.getExternalid();
		
		//giftexcobj.setSender(fbid);
		giftexcobj.setIsAccepted(1);
		String giftID = giftexcobj.getGiftID();
		String receiver = giftexcobj.getReceiver();
		
		GiftInventory giftInventoryobj = GiftInventory.getGiftInventoryByFacebookId_GiftID(receiver, giftID);
		/*
		 * If there are NO gifts in the User Inventory Add this gift to the Inventory
		 */
		if(giftInventoryobj == null)
		{
			new GiftInventory(receiver, giftID, 1);
		}
		else
		{
			giftInventoryobj.setCount(giftInventoryobj.getCount()+1);
			giftInventoryobj.update();
		}
		
	}
	
	private static void sendGift(ISFSObject giftData, long senderID, long receiverID, SFSExtension ext)
	{
		String giftID = giftData.getUtfString("GiftID");
				
		addToGiftExchange(giftID, senderID, receiverID);
		
		User usr = UserHelper.GetUserInZone(senderID, ext.getParentZone());
		
		// is sent from game
		boolean sentFromGame = giftData.getBool("FromGame");
		
		if(usr != null && sentFromGame) // is sent from game
		{
			ext.send("TableGift", giftData, usr);
		}
	}
	
	private static void sendToAll(ISFSObject giftData, long senderID, SFSExtension ext)
	{
		String giftID = giftData.getUtfString("GiftID");
		
		String senderName = com.mango.games.db.UserDB.getUserbyID(senderID).getFirst_name(); //TODO: DB Done Memcache: get sender name from senderID
		
		giftData.putUtfString("SenderName", senderName);
		
		List<User> users = UserHelper.GetRecipientsExceptUser(ext.getParentRoom(), senderID);
		
		ext.send("TableGift", giftData, users);
	
		for(User user : users)
		{
			//String receiverID = params.getUtfString("FBIDReceiver");
			long userName = Long.getLong(user.getName());
			addToGiftExchange(giftID, senderID, userName);
		}
	}

	private static void addToGiftExchange(String giftID, long senderID, long receiverID)
	{
		// TODO: DB Done insert into gift exchange
		/*
		 * date of exchange is to be updated
		 */
		String sender = com.mango.games.db.UserDB.getUserbyID(senderID).getExternalid();
		String receiver = com.mango.games.db.UserDB.getUserbyID(receiverID).getExternalid();
		new GiftExchange(giftID, sender, receiver);
		//new GiftExchange(giftID, sender, receiver, 0, dateofexcahnge);
	}
	
	private static void updateUserInfo(String giftID, int price, long senderID, SFSExtension ext)
	{
		checkSufficientFunds(senderID, price, ext);
		com.mango.games.db.UserAccount user = com.mango.games.db.UserAccount.getUserAccountbyUserID(senderID);
		int chips = user.getChips() - price;
		user.setChips(chips);
		user.update();
       	// TODO: DB Done update user chips, subtract the price
	}
	
	private static boolean checkSufficientFunds(long senderID, int price, SFSExtension ext)
	{
		com.mango.games.db.UserAccount user = com.mango.games.db.UserAccount.getUserAccountbyUserID(senderID);
		
		int chipsAfterUpdate = 0; // TODO: DB Done /Memcache, check if sufficient for the purchase
		chipsAfterUpdate = user.getChips() - price;
       	if(chipsAfterUpdate <= 0)
    	{
       		ext.send("BuyChips", null, UserHelper.GetUserInZone(senderID, ext.getParentZone()));
       		return false;
    	}
       	else
       	{
       		return true;
       	}
	}
	
	private static void updateAchievements(long senderID, ISFSObject giftData, SFSExtension ext)
	{
		if(giftData.getBool("ForAll"))
		{
			checkAndSendToAllAchievement(senderID, giftData, ext);
		}
		
		String receiverID = giftData.getUtfString("FBIDReceiver"); // TODO: SourceID from client
		long receiverUserID = com.mango.games.db.UserDB.getUserbyFBID(receiverID).getId(); //TODO: DB Done get userID from receiverID
		
		if(receiverUserID != senderID)
		{
			sendAchievementOnGiftCount(senderID, giftData, ext);
		}
		else
		{
			checkAndSendIfPurchaseAchievement(senderID, giftData, ext);
		}
	}
	
	private static void checkAndSendToAllAchievement(long senderID, ISFSObject giftData, SFSExtension ext)
	{
		String giftName = giftData.getUtfString("GiftName");
		String categoryName = giftData.getUtfString("CategoryName");	

		Effort effort = new Effort(Effort.Type.PURCHASE, ext.getParentRoom().getMaxUsers(), categoryName, giftName);
		Achievement achievement = AchievementManager.getIfAchievement(effort);
		
		if(achievement != null && false == AchievementManager.hasAlreadyAchieved(senderID, achievement))
		{
			sendAchievement(senderID, achievement.AchievementID, ext);
		}
	}
	
	private static void checkAndSendIfPurchaseAchievement(long senderID, ISFSObject giftData, SFSExtension ext)
	{
		String giftName = giftData.getUtfString("GiftName");
		String categoryName = giftData.getUtfString("CategoryName");	

		Effort effort = new Effort(Effort.Type.PURCHASE, 1, categoryName, giftName);
		Achievement achievement = AchievementManager.getIfAchievement(effort);
		if(achievement != null && false == AchievementManager.hasAlreadyAchieved(senderID, achievement))
		{
			sendAchievement(senderID, achievement.AchievementID, ext);
		}
	}
	
	private static void sendAchievementOnGiftCount(long senderID, ISFSObject giftData, SFSExtension ext)
	{
		int totalGiftCount = getTotalGiftsSent(senderID);
		
		if(totalGiftCount > 0)
		{
			Effort effort = new Effort(Effort.Type.SEND_GIFT, totalGiftCount);
			Achievement achievement = AchievementManager.getIfAchievement(effort);
			if(achievement != null)
			{
				sendAchievement(senderID, achievement.AchievementID, ext);
			}
		}
	}
	
	// TODO: Achievement-Buy 3 Drinks in 1 session~
	
	private static void sendAchievement(long playerID, int achievementID, SFSExtension ext)
	{
		ISFSObject achievement = new SFSObject();
		achievement.putInt("AchievementID", achievementID);
		
		ext.send("NewAchievement", achievement, UserHelper.GetUserInZone(playerID, ext.getParentZone()));
		
		// TODO: DB Not Done save in DB-memchache
		/*
		 * Insert into achievements playerID (FBID) and achievemnst id
		 * 
		 */
	}
}
