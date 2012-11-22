package com.mango.games.rummy.utils;

import java.sql.ResultSet;

import com.mango.games.db.PlayerDB;
import com.mango.games.db.UserDB;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject; 
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;

public class UserInfoManager
{
	private static PlayerDB _playerDB = new PlayerDB();
	
	public static ISFSObject UserLogin(ISFSObject data, User sender)
	{
		String facebookID = data.getUtfString("FacebookID");
		String gender = data.getUtfString("Gender");
		String firstName = data.getUtfString("FirstName");
		String lastName = data.getUtfString("LastName");
		String email = data.getUtfString("Email");
		String dob = data.getUtfString("DOB");
		String location = data.getUtfString("Location");
		
		FriendsManager.setNickNameForUser(sender, firstName);
		
		// init badges
		//TODO: Achievements stuff
		
		boolean isNewPlayer = false;
		/*
		 * DB Calls
		 */
		UserDB userobj = UserDB.getUserbyFBID(facebookID);
		if(userobj == null)
		{
			/*
			 * It's a New User
			 * Add Record Into Database
			 */
			userobj = new UserDB(firstName, lastName, email, facebookID, gender, dob);
		}
		ResultSet rs = _playerDB.getPlayerByFbId(Integer.getInteger(facebookID));

		ISFSObject response = new SFSObject();
    	         
        // TODO: get his rank, verify
        
        int chips = 500; // default
        int mangoGold = 1;
        int level = 1;
        int gamesWon = 0;
        int gamesLost = 0;
        int consecutiveWins = 0;
        String  giftID = "";
        String giftImage = "Apple";
        String giftName = "Apple";
        String categoryName = "Food";
        int experience = 0;
        String lastLoggedInDate = "";
        int consecutiveLogins = 0;
        int winXP = 0;
        int loseXP = 0;
        int quitXP = 0;
        int rank = 0;
        
		int playerID = -1;
		
	      
		//TODO: Achievements
        //ISFSArray achievementList = null;
		if(rs == null)
		{
			playerID = _playerDB.createFacebookPlayer(facebookID, firstName, lastName, gender, email, dob, location);
			
			rs = _playerDB.getPlayerById(playerID);
			
			isNewPlayer = true;
			
			rank = playerID;
		}
		else
		{
			//TODO: see if the player is inactive
    		/*if(row.getUtfString("Status").compareTo("INACTIVE") == 0)
    
    			SetPlayerActive(facebookID);
    		}*/
			
			try
			{
				chips = rs.getInt("Chips");
	
				mangoGold = rs.getInt("MangoGold");
	        	level = rs.getInt("Level");
	        	gamesWon = rs.getInt("GamesWon");
	        	gamesLost = rs.getInt("GamesLost");
	    		consecutiveWins = rs.getInt("ConsecutiveWins");
	    		experience = rs.getInt("Experience");
	    		lastLoggedInDate = rs.getString("LastLoggedIn");
	    		consecutiveLogins = rs.getInt("ConsecutiveLogin");
	    		winXP = rs.getInt("WinXP");
	    		loseXP = rs.getInt("LoseXP");
	    		quitXP = rs.getInt("QuitXP");
	    		
	    		playerID = rs.getInt("PlayerID");
			}
			catch(Exception e)
			{
				
			}
    		
    		//TODO: 
    		/*if(rs.getInt("ChipsUpdatedAfterInvite") > 0)
    		{
    			int count = FriendsManager.InvitesAcceptedCount(facebookID);
    			// check for achievements
    			int achievementID = AchievementBadgeManager.UpdateInviteAchievement(facebookID, count);
    			
    			response.putInt("PlayerAchievement", achievementID);
    		}*/

    		//giftID = rs.getString("CurrentGiftID"); //GetGiftsInventory(facebookID);
	        
	        /* TODO: get gift inventory and current gift id
	        if(giftID.length() == 0) 
	        {
	        	giftID = GetGiftsInventory(facebookID);
	        	
	        	if(giftID.length() == 0)
	        	{
	        		giftID = "2_1";
	        	}
	        }*/
	        
	        //response.putUtfString("GiftID", giftID);
	        
	        //ISFSObject giftsData = AchievementBadgeManager.GetFGiftsInventory(facebookID, giftID);
	        //response.putSFSArray("GiftsInventory", AchievementBadgeManager.GetFAllGiftsInventory(facebookID));
	        /*if(giftsData != null)
	        {
	        	giftImage = giftsData.getUtfString("Image");
	        	giftName = giftsData.getUtfString("Name");
	        	categoryName = giftsData.getUtfString("CategoryName");		        	
	        	//trace(giftName + " " + categoryName);
	        	
	        	response.putUtfString("GiftName", giftName);
	        	response.putUtfString("Image", giftImage);
	        	response.putUtfString("CategoryName", categoryName);
	        }
	        else
	        {
	        	response.putUtfString("Image", giftImage);
		        response.putUtfString("GiftName", giftName);
		        response.putUtfString("CategoryName", categoryName);
	        }
	        
	        // get his achievements
	        achievementList = (AchievementBadgeManager.GetAchievements(facebookID));
	        response.putSFSArray("Achievements", achievementList);
	        
	        response.putInt("Rank", rank);		        
        	}*/
	        
	        //TODO: CALCULATE RANK
		}
		
		String userName = Integer.toString(playerID);
		sender.setName(userName);
		
        ISFSObject obj = new SFSObject();
        obj.putUtfString("FirstName", firstName);
        obj.putInt("Level", level);
        obj.putInt("Chips", chips);
       	obj.putInt("Experience", experience);
       	obj.putInt("MangoGold", mangoGold);
        	
        ISFSArray newRes = new SFSArray();
        newRes.addSFSObject(obj);
        
        //TODO: gifts
        /*giftID = "2_1";
        
        response.putUtfString("GiftID", "2_1");
        response.putUtfString("GiftName", giftName);
        response.putUtfString("CategoryName", categoryName);*/
        
        response.putSFSArray("PlayerData", newRes);
        
        response.putBool("IsNewPlayer", isNewPlayer);
        
        response.putInt("Rank", rank);
        
        ISFSObject dailyBonus = getDailyBonus(lastLoggedInDate, consecutiveLogins);
        if(dailyBonus != null)
        {
        	response.putSFSObject("DailyBonus", dailyBonus);
        }
        else
        {
        	response.putNull("DailyBonus");
        }
        
        response.putUtfString("Location", getLocation(sender));
        
        return response;
	}
	
	private static String getLocation(User sender)
	{
		String countryCode = "US";
		
        if(!sender.isNpc())
        {
        	countryCode = UserHelper.GetUserLocation(sender);
    		
			if(countryCode.compareTo("US") == 0)
			{
				//user.UserCurrency = Currency.USD;
			}
			else if(countryCode.compareTo("IN") == 0)
			{
				//user.UserCurrency = Currency.INR;				
			}
			else if(UserHelper.IsEurope(countryCode))
			{
				//user.UserCurrency = Currency.EUR;
			}
			else
			{
				//user.UserCurrency = Currency.USD;
			}
        }
        else
        {
        	//user.UserCurrency = Currency.USD;
        	//user.IsBot = true;
        }
        
        return countryCode;
	}
	
	private static ISFSObject getDailyBonus(String lastLoggedInDate, int consecutiveLogins)
	{
		if(lastLoggedInDate.length() > 0) // the db has some value
		{
			// compare with the current date
			long diff = DateTimeUtil.DaysBetween(lastLoggedInDate, DateTimeUtil.GetCurrentTimeStamp());
			
			if(diff >= 1 && diff < 2)
			{
				// add Daily bonus
				consecutiveLogins++;
	        		
        		if(consecutiveLogins == 6) consecutiveLogins = 1;
        		
        		ISFSObject dailyBonus = new SFSObject();        		
        		int dailyBonuses[] = {200, 400, 600, 800, 1000};
        		
        		dailyBonus.putBool("IsBonusSending", true);
	        	dailyBonus.putInt("ConsecutiveLogins", consecutiveLogins);

    			//TODO: update user chips with daily bonus

	    		switch(consecutiveLogins)
        		{
        		case 1:
        			dailyBonus.putInt("Chips", dailyBonuses[0]);
        			break;
        		case 2:
		        	dailyBonus.putInt("Chips", dailyBonuses[1]);
        			break;
        		case 3:
		        	dailyBonus.putInt("Chips", dailyBonuses[2]);
        			break;
        		case 4:
		        	dailyBonus.putInt("Chips", dailyBonuses[3]);
        			break;
        		case 5:
		        	dailyBonus.putInt("Chips", dailyBonuses[4]);
        			break;
        		}
        		
	        	return dailyBonus;
        	}
        	else if(diff < 1)
        	{
        		return null;
        	}
        	else if(diff >= 2)
        	{
        		consecutiveLogins = 1;
        		return null;
        	}
        }
		
		return null;
	}
	
	public static void savePlayerData(long userID)
	{
		
	}
}
