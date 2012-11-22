package com.mango.games.rummy.logic.common.core;

import java.util.Comparator;

import com.mangogames.rummy.model.Card;

public class CardRankComparator implements Comparator<Card>
{
	public int compare(Card firstCard, Card secondCard)
	{
		return (firstCard.getRank() - secondCard.getRank());
	}
}
