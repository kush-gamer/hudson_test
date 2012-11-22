package com.mango.games.rummy.achievements;

public class Effort
{
	public enum Type
	{
		LEVEL_REACHED,
		INVITE,
		ROUND_WIN,
		GAME_WIN,
		PURCHASE,
		PARTICIPATE,
		SEND_GIFT,
		GENERAL
	}
	
	public Type EffortType;
	public int GoldenNumber;
	public Object AdditionalInfo[];
	
	public Effort(Type type, int goldenNumber, Object... param)
	{
		EffortType = type;
		GoldenNumber = goldenNumber;
		
		AdditionalInfo = new Object[param.length];
		
		for(int i=0; i<param.length; i++)
		{
			AdditionalInfo[i] = param[i];
		}
	}
}
