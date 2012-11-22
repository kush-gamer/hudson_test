package com.mango.games.rummy.achievements;

public class Achievement 
{
	public int AchievementID;
	public String AchievementName;
	public int UnlockedGiftID;
	
	public Achievement(int achievementID, String name, int unlockedGiftID)
	{
		AchievementID = achievementID;
		AchievementName = name;
		UnlockedGiftID = unlockedGiftID;
	}
}
