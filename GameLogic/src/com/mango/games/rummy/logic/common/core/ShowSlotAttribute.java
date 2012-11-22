package com.mango.games.rummy.logic.common.core;

public class ShowSlotAttribute 
{
	public boolean FoundPureRun;
	public int SequenceCount;
	public int SetCount; 
	public int NumberOfJokers;
	public boolean MandatoryCheckMet;
	public int Highlight;
	
	public ShowSlotAttribute()
	{
		FoundPureRun = false;
		SequenceCount = 0;
		SetCount = 0;
		NumberOfJokers = 0;
		MandatoryCheckMet = false;
		
		Highlight = -1;
	}
}
