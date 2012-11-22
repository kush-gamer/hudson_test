package com.mango.games.rummy.logic.common.core;

import java.util.ArrayList;
import java.util.List;

import com.mangogames.rummy.model.Card;

public class ShowSlot
{
	public enum ESeqType
	{
		PURE_RUN,
		RUN,
		PURE_SET,
		SET,
		INVALID,
		NOT_SCANNED, // default
	}
	
	public enum ELuck
	{
		THREE_QUEENS,
		THREE_KINGS,
		FOUR_ACES,
	}
	
	public int ID;
	public List<Card> Sequence = new ArrayList<Card>();
	public List<Card> AdjSequence = new ArrayList<Card>();

	public ESeqType Type = ESeqType.NOT_SCANNED;
	public ELuck Luck;
	public int Highlight = -1;
	
	public int Score;
	
	public int NoOfJokersUsed = 0;
}
