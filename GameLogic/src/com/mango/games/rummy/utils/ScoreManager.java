package com.mango.games.rummy.utils;

public class ScoreManager 
{
	private static ScoreManager _instance = null;
	
	private int _baseXP = 2; // need to make it constant
	
	private float[] _buyInTypeBaseValues = {2.0f, 4.0f, 8.0f, 40.0f, 80.0f, 120.0f};
	private float[] _gameTypeBaseValues = {0.50f, 1.50f, 4.50f, 9.50f};
	private int[] _scoreBaseValues = {6, 3, 1, 0};
	private int[] _increments = {18, 36, 75, 150};
	private float[] _dropPenalties = {0.15f, 0.25f, 0.60f};
 		
	private ScoreManager()
	{ 
	}
	
	public static ScoreManager GetInstance()
	{
		if(_instance == null)
		{
			_instance = new ScoreManager();
		}
		
		return _instance;
	}
	
	public float GetN(int buyInAmount, int typeOfGame, int score, int level)
	{
		float denominator = (GetBaseBuyInAmount(buyInAmount) * GetTypeOfGamePoint(typeOfGame)) + (_baseXP * level);
		return denominator;
	}
	
	public float GetWinXP(int buyInAmount, int typeOfGame, int tableMaxCapacity, int score, int level, int sessionTime)
	{
		float winXP = 0;

		// get eligiblity
		if(!IsEligibleForTable(level, typeOfGame, tableMaxCapacity, buyInAmount)) return winXP;
				
		float denominator = GetN(buyInAmount, typeOfGame, score, level) + GetScoreBaseReward(score); 
		winXP = (denominator) + GetBonus(sessionTime, level);
		
		return winXP;
	}

	public float GetLoseXP(int buyInAmount, int typeOfGame, int tableMaxCapacity, int score, int level, int sessionTime)
	{
		float loseXP = 0;
		
		// get eligiblity
		if(!IsEligibleForTable(level, typeOfGame, tableMaxCapacity, buyInAmount)) return loseXP;
		
		float denominator = GetN(buyInAmount, typeOfGame, score, level) / 2;
		loseXP = (denominator) + GetBonus(sessionTime, level);
		
		return loseXP;
	}
	
	public float GetQuitXP(int buyInAmount, int typeOfGame, int tableMaxCapacity, int score, int level, int sessionTime, int currentCardsCount)
	{
		if(typeOfGame == 100) return 0; // single round no xp
		
		float loseXP = GetLoseXP(buyInAmount, typeOfGame, tableMaxCapacity, score, level, sessionTime);
		
		float quitXP = loseXP - loseXP * GetDropPenalty(buyInAmount, typeOfGame, currentCardsCount);
		
		System.out.println("++++++++++++++++++++++++   QUIT XP   +++++++++ : " + quitXP);
		if(quitXP < 0)	return 0;
		
		return quitXP;
	}
	
	public float GetDropPenalty(int buyInAmount, int typeOfGame, int score)
	{
		int penaltyScore = Math.abs(typeOfGame - score);
		
		System.out.println("Score" + score);
		System.out.println("PenaltyScore" + penaltyScore);
		
		switch(typeOfGame)
		{
		case 201:
			if(penaltyScore >= 81 && penaltyScore <= 201)
			{
				return _dropPenalties[0];
			}
			else if(penaltyScore >= 31 && penaltyScore <= 80)
			{
				return _dropPenalties[1];
			}
			else if(penaltyScore >= 0 && penaltyScore <= 30)
			{
				return _dropPenalties[2];
			}
			break;
		case 301:
			if(penaltyScore >= 122 && penaltyScore <= 301)
			{
				return _dropPenalties[0];
			}
			else if(penaltyScore >= 47 && penaltyScore <= 121)
			{
				return _dropPenalties[1];
			}
			else if(penaltyScore >= 0 && penaltyScore <= 46)
			{
				return _dropPenalties[2];
			}
			break;
		}
		
		return penaltyScore;
	}
	
	public int GetBonus(int sessionTime, int level)
	{
		switch(sessionTime)
		{
		case 60:
			return (50 + level);			
		}
		
		return 0;
	}
		
	private float GetBaseBuyInAmount(int buyInAmount)
	{
		switch(buyInAmount)
		{
		case 25:
			return _buyInTypeBaseValues[0];
		case 50:
			return _buyInTypeBaseValues[1];
		case 100:
			return _buyInTypeBaseValues[2];
		case 500:
			return _buyInTypeBaseValues[3];
		case 1000:
			return _buyInTypeBaseValues[4];
		case 1500:
			return _buyInTypeBaseValues[5];
		}
		
		return 1.0f;
	}
		
	private float GetTypeOfGamePoint(int typeOfGame)
	{
		float typeOfGamePoint = 0.0f;
		
		switch(typeOfGame)
		{
		case 100:
			typeOfGamePoint = _gameTypeBaseValues[0];
			break;
		case 101:
			typeOfGamePoint = _gameTypeBaseValues[1];
			break;
		case 201:
			typeOfGamePoint = _gameTypeBaseValues[2];
			break;
		case 301:
			typeOfGamePoint = _gameTypeBaseValues[3];
			break;
		}
		
		return typeOfGamePoint;
	}
	
	private int GetScoreBaseReward(int score)
	{
		int scoreBaseReward = 0;
		
		if(score >= 0 && score <= 5) return _scoreBaseValues[0];
		if(score >= 6 && score <= 20) return _scoreBaseValues[1];
		if(score >= 21 && score <= 50) return _scoreBaseValues[2];
		if(score >= 51 && score <= 80) return _scoreBaseValues[3];	
	
		return scoreBaseReward;
	}
	
	public boolean IsLevelUp(int level, int experience)
	{
		if(experience >= GatherXP(level))
		{
			return true;
		}
		
		return false;
	}
	
	public int GatherXP(int level)
	{
		System.out.println(level);
		if(level <= 1)
		{
			return 18;
		}
		
		return  GetXPIncrementVal(level - 1) + GatherXP(level - 1);		
	}
	
	public int GetXPIncrementVal(int level)
	{
		if(level == 1)
		{
			return 18;
		}				
		if(level > 1 && level <=5)
		{
			return _increments[0] + GetXPIncrementVal(level - 1);
		}
		else if(level >= 6 && level <= 25)
		{
			return _increments[1] + GetXPIncrementVal(level - 1);
		}
		else if(level >= 26 && level <= 40)
		{
			return _increments[2] + GetXPIncrementVal(level - 1);
		}
		else if(level >= 41 && level <= 50)
		{
			return _increments[3] + GetXPIncrementVal(level - 1);
		}		
		return 0;
	}
	
	public float GetRake(int tableAmount)
	{
		switch(tableAmount)
		{
		case 25:
			return 0.12f;	
		case 50:
			return 0.10f;	
		case 100:
			return 0.08f;	
		case 500:
			return 0.00f;	
		}
		
		return 0.0f;
	}
	
	public boolean IsEligibleForTable(int currentLevel, int tableType, int tableMaxCapacity, int betAmount)
	{
		System.out.println(" Current Level : " + currentLevel + " Table Type " + tableType + " Table Max Capacity " + tableMaxCapacity + " Bet Amount " + betAmount);
		
		if(currentLevel >= 1 && currentLevel <= 2)
		{
			if(tableMaxCapacity > 3 || betAmount > 50 || tableType != 100)
			{
				System.out.println(" Sending Not eligible ");
				return false;
			}
		}
		if(currentLevel >= 3 && currentLevel <= 4)
		{
			if(tableMaxCapacity > 3 || betAmount > 100 || tableType != 100)
			{
				System.out.println(" Sending Not eligible ");
				return false;
			}
		}
		if(currentLevel >= 5 && currentLevel < 6)
		{
			if((tableMaxCapacity > 2 && tableType != 101) || betAmount > 500 || (tableType != 100 && tableType != 101))
			{
				System.out.println(" Sending Not eligible ");
				return false;
			}
		}
		
		return true;
	}
}
