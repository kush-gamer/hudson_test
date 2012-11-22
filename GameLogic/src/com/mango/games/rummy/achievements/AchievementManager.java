package com.mango.games.rummy.achievements;

import com.mango.games.db.Achievements;
import com.mango.games.db.UserDB;

public class AchievementManager 
{
	public static Achievement getIfAchievement(Effort effort)
	{
		Achievement achievement = null;
		
		Effort.Type type = effort.EffortType;
				
		switch(type)
		{
		case LEVEL_REACHED:
			achievement = getIfLevelAchievement(effort);
			break;		
		case GAME_WIN:
			achievement = getIfGameWinAchievement(effort);
			break;
		case ROUND_WIN:
			achievement = getIfRoundWinAchievemnt(effort);
			break;
		case INVITE:
			achievement = getIfInviteAchievemnt(effort);
			break;
		case PARTICIPATE:
			achievement = getIfParticipationAchievemnt(effort);
			break;
		case PURCHASE:
			achievement = getIfPurchaseAchievemnt(effort);
			break;
		case SEND_GIFT:
			achievement = getIfSendGiftAchievemnt(effort);
			break;
		case GENERAL:
			achievement = getIfGeneralAchievemnt(effort);
			break;
		}

		return achievement;
	}
	
	public static boolean hasAlreadyAchieved(long playerID, Achievement achievement)
	{
		//TODO: DB DONE mem-cache
		int id = achievement.AchievementID;
		UserDB user = UserDB.getUserbyID(playerID);
		String userFacebookID = user.getExternalid();
		return Achievements.IsPlayerAchievement(userFacebookID, id);
		
	}
	
	private static Achievement getIfLevelAchievement(Effort effort)
	{
		Achievement achievement = null;
		
		int level = effort.GoldenNumber;
		
		switch(level)
		{
		case 10:
			achievement = new Achievement(17, "Silver!", 0);
			break;
		case 20:
			achievement = new Achievement(18, "Gold Standard", 0);
			break;
		case 30:
			achievement = new Achievement(19, "MVP", 0);
			break;
		case 40:
			achievement = new Achievement(20, "Legendary", 0);
			break;
		case 50:
			achievement = new Achievement(21, "Unobtainium", 0);
			break;
		}

		return achievement;
	}
	
	private static Achievement getIfGameWinAchievement(Effort effort)
	{
		Achievement achievement = null;
		
		int noOfWins = effort.GoldenNumber;
				
		switch(noOfWins)
		{
		case 1:
			achievement = new Achievement(9, "Winner Winner Chicken Dinner!", 0);
			break;
			
			//TODO: Check for no of wins achievement
		}
		
		
		if(effort.AdditionalInfo.length > 0 && effort.AdditionalInfo[0] != null)
		{
			int consecutiveWins = ((Integer)(effort.AdditionalInfo[0])).intValue();
				
			if(consecutiveWins == 2)
			{
				achievement = new Achievement(10, "Double Win", 0);
			}
			
			if(consecutiveWins == 10)
			{
				achievement = new Achievement(11, "10acious", 0);
			}
		}
		
		return achievement;
	}
	
	private static Achievement getIfRoundWinAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		int winHighlight = -1;
		
		if(effort.AdditionalInfo.length > 0 && effort.AdditionalInfo[0] != null)
		{
			winHighlight = ((Integer)(effort.AdditionalInfo[0])).intValue();
			
			switch(winHighlight)
			{
			case 0: // THREE_JOKERS
				achievement = new Achievement(16, "Joker Face", 0);
				break;
			case 1: // TWO_SETS
				achievement = new Achievement(12, "Double Twins", 0);
				break;
			case 2: // FOUR_SEQUENCES
				achievement = new Achievement(15, "The A Train", 0);
				break;
			case 3: // THREE_KINGS
				break;
			case 4: // THREE_QUEENS
				break;
			case 5: // FOUR_ACES
				achievement = new Achievement(14, "Aces High", 0);
				break;
			case 7: // THREE_KINGS && THREE_QUEENS
				achievement = new Achievement(13, "Royal Family", 0);
				break;
			}	
		}
		
		return achievement;
	}
	
	private static Achievement getIfInviteAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		int noOfInvites = effort.GoldenNumber;
		String giftID = "";
		
		if(effort.AdditionalInfo.length > 0 && effort.AdditionalInfo[0] != null)
		{
			giftID = ((String)effort.AdditionalInfo[0]);
		}
		
		switch(noOfInvites)
		{
		case 1:
			if(giftID.length() > 0)
			{
				achievement = new Achievement(5, "Santas Helper", 0);
			}			
			break;
		
		case 5:
			achievement = new Achievement(1, "Almost Famous", 0);
			break;
		
		case 10:
			achievement = new Achievement(2, "Friendly Neighbour", 0);
			break;
		
		case 15:
			achievement = new Achievement(3, "Celebrity", 0);
			break;
		}
				
		return achievement;
	}
	
	private static Achievement getIfParticipationAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		int roomType = effort.GoldenNumber;
		
		switch(roomType)
		{
		case 101:
			achievement = new Achievement(22, "101 Tryout", 0);
			break;
		case 201:
			achievement = new Achievement(23, "201 Tryout", 0);
			break;
		case 301:
			achievement = new Achievement(24, "301 Tryout", 0);
			break;
		}
		
		return achievement;		
	}
	
	private static Achievement getIfPurchaseAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		int noOfGifts = effort.GoldenNumber;
		String category = "";
		String gift = "";
		
		if(effort.AdditionalInfo.length > 0 && effort.AdditionalInfo[0] != null && effort.AdditionalInfo[1] != null)
		{
			gift = ((String)effort.AdditionalInfo[1]);
			category = ((String)effort.AdditionalInfo[0]);
			
			if(category.compareTo("Drinks") == 0 && noOfGifts == 3)
			{
				achievement = new Achievement(26, "Plastered!", 0);
			}
			
			if(gift.compareTo("Champagne") == 0 && noOfGifts >= 1)
			{
				achievement = new Achievement(7, "Party Time!", 0);
			}
			
			if(gift.compareTo("Steak") == 0 && noOfGifts == 1)
			{
				achievement = new Achievement(25, "Hunger Games!", 0);
			}
		}

		return achievement;
	}
	
	private static Achievement getIfSendGiftAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		int noOfGifts = effort.GoldenNumber;
		
		switch(noOfGifts)
		{
		case 1:
			achievement = new Achievement(4, "Little Santa", 0);
			break;
		case 50:
			achievement = new Achievement(6, "Robin Hood", 0);
			break;
		case 100:
			achievement = new Achievement(8, "Santa Claus", 0);
			break;
		}		
		
		return achievement;
	}
	
	private static Achievement getIfGeneralAchievemnt(Effort effort)
	{
		Achievement achievement = null;
		
		return achievement;		
	}
}
