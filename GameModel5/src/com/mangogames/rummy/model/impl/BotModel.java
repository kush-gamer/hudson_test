package com.mangogames.rummy.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mangogames.rummy.model.Card;


public class BotModel
{
	private int _seatNo = -1;
	
	private ArrayList<Card> _cardsInHand = new ArrayList<Card>();
	private ArrayList<ArrayList<Card>> _sets = new ArrayList<ArrayList<Card>>();
	
	private static final int MaxSets = 4;
	private static final int MaxCardsInSets = 4;
	private static final int MinCardInASet = 3;
	
	private static final int MaxCardsInHand = 13;
	
	private int _hasFirstSequence = -1;
	private int _hasSecondSequence = -1;
	
	private int _openJokerRank = -1;
	
	public void setOpenJokerRank(int rank)
	{
		_openJokerRank = rank;
	}
	
	public void setSeatNo(int seatNo)
	{
		_seatNo = seatNo;
	}
	
	public int getSeatNo()
	{
		return _seatNo;
	}
	
	public void addCardToHandCards(Card card)
	{
		_cardsInHand.add(card);
	}
	
	public boolean shouldPickFromClosedDeck(Card discardedCard)
	{
		if (isJokerCard(discardedCard) || !isTouchCardForAnySetCards(discardedCard))
		{
			return false;
		}
		
		return true;
	}
	
	public int arrangeCards(int inHandCardCount)
	{
		int index = 0;
		while (index < _cardsInHand.size())
		{
			Card card = _cardsInHand.get(index);
			if (isJokerCard(card))
			{
				index++;
				continue;
			}
			if (processPickedCard(card))
			{
				index = 0;
			}
			else
			{
				Card touchCard = getTouchCardForAnyRemainingCard(card);
				if (touchCard != null)
				{
					if (!processPickedCard(touchCard))
					{
						if (addCardsToSet(card, touchCard))
						{
							index = 0;
						}
						else
						{
							index++;
						}
					}
					else
					{
						index = 0;
					}
				} 
				else
				{
					index++;
				}
			}
		}
		
		return _cardsInHand.size();
	}
	
	public void printBotCards()
	{
		System.out.println(" Bot Cards ");
		for(int i=0; i<_sets.size(); i++)
		{
			System.out.println(_sets.get(i));
		}
		
		System.out.println("Cards in Hand ");
		for(int i=0; i<_cardsInHand.size(); i++)
		{
			System.out.println(_cardsInHand.get(i));
		}
	}

	// Create a new set and store the touch cards in it
	private boolean addCardsToSet(final Card card1, final Card card2)
	{
		if(_sets.size() < MaxSets)
		{
			_sets.add(new ArrayList<Card>(Arrays.asList(card1, card2)));
			_cardsInHand.remove(card1);
			_cardsInHand.remove(card2);
			checkFirstAndSecondSequences();
			return true;
		}
		return false;
	}

	public void useJokers()
	{
		// if first set is done
		if (_hasFirstSequence >= 0)
		{
			// if joker exists in hand
			List<Card> jokerCards = new ArrayList<Card>();
			for (Card card : _cardsInHand)
			{
				if (isJokerCard(card))
				{
					jokerCards.add(card);
				}
			}
			for (int index = 0; index < _sets.size() && !jokerCards.isEmpty(); index++)
			{
				// add joker card to any existing touch set except
				// FIRST sequence
				if (index != _hasFirstSequence && getNumberOfFreeSpaceInSet(_sets.get(index)) > 0)
				{
					// add
					_sets.get(index).add(jokerCards.get(0));
					_cardsInHand.remove(jokerCards.get(0));
					jokerCards.remove(0);
					break;
				}
			}
		}
	}

	// Check is there any space available to fit more cards in the given set
	public int getNumberOfFreeSpaceInSet(List<Card> set)
	{
		boolean hasSetOfFour = anySetHasMaxCard();
		int setCanStoreMaxNCard = MaxCardsInSets;
		if (hasSetOfFour)
		{
			setCanStoreMaxNCard = MinCardInASet;
		}
		return setCanStoreMaxNCard - set.size();
	}

	// Add a given card to given set
	public boolean addCardToSet(List<Card> set, Card card)
	{
		if (((isJokerCard(card)) || isSetHasSameSuit(set, card) && card.getSuit() == set.get(0).getSuit())
				|| (isSetHasSameRank(set) && card.getRank() == set.get(0).getRank()))
		{
			if (getNumberOfFreeSpaceInSet(set) > 0)
			{
				set.add(card);
				_cardsInHand.remove(card);
				checkFirstAndSecondSequences();
				return true;
			}
		}
		return false;
	}
	
	// Check all the cards in set having same Suit
	public boolean isSetHasSameSuit(List<Card> set, Card card)
	{
		int suit = card.getSuit();
		int mixedCard = 0;
		if ((card.getRank() + 1) == 2 || (card.getRank() + 1) == 13)
		{
			mixedCard++;
		}
		for (int index = 0; index < set.size(); index++)
		{
			Card setCard = set.get(index);
			if ((card.getRank() + 1) == 2 || (card.getRank() + 1) == 13)
			{
				mixedCard++;
			}
			if (setCard.getSuit() != suit)
			{
				return false;
			}
		}
		if(mixedCard > 1)
		{
			return false;
		}
		return true;
	}

	// Check all the cards in set having same Rank
	private boolean isSetHasSameRank(List<Card> set)
	{
		int rank = set.get(0).getRank();
		for (int index = 1; index < set.size(); index++)
		{
			if (set.get(index).getRank() != rank)
			{
				return false;
			}
		}
		
		return true;
	}

	// Check first & second sequence exists or not
	// Store first sequence set index in _hasFirstSequence
	// Store second sequence set index in _hasSecondSequence
	private void checkFirstAndSecondSequences()
	{
		if (_hasFirstSequence < 0 || _hasSecondSequence < 0)
		{
			for (List<Card> set : _sets)
			{
				if (set.size() >= MinCardInASet)
				{
					int setIndex = _sets.indexOf(set);
					if (_hasFirstSequence < 0)
					{
						_hasFirstSequence = setIndex;
					}
					else if (_hasFirstSequence != setIndex)
					{
						_hasSecondSequence = setIndex;
					}
				}
			}
		}
	}

	// To avoid loosing picked card which is replaced by joker
	public void removeAllJokersFromSets()
	{
		for (List<Card> set : _sets)
		{
			List<Card> jokerCards = new ArrayList<Card>();
			for (Card card : set)
			{
				if(isJokerCard(card))
				{
					jokerCards.add(card);
				}
			}
			for (Card card : jokerCards)
			{
				set.remove(card);
				_cardsInHand.add(card);
			}
		}
	}

	// returns true if any set of cards has 4 cards in it else returns false
	private boolean anySetHasMaxCard()
	{
		for (List<Card> set : _sets)
		{
			if (set.size() == MaxCardsInSets)
			{
				return true;
			}
		}
		return false;
	}

	// Arrange the sets after picking a card
	// isPicked - it true if a card is picked from open/closed deck
	private boolean processPickedCard(Card card)
	{
		System.out.println(" Processing Picked Card " + card.getRank() + " " + card.getSuit());
		for(List<Card> set : _sets)
		{
			boolean isTouchCard = false;
			for(Card setCard : set)
			{
				// to avoid duplicate cards in single set
				if(!isSetAlreadyHaveSameCard(set, card))
				{
					if(isTouchCards(setCard, card))
					{
						isTouchCard = true;
						break;
					}
				}
			}
			if (isTouchCard)
			{
				if (addCardToSet(set, card))
				{
					return true;
				}
			}
		}
		return false;
	}

	// Before adding a touch card to set, make sure same card is not in the set
	private boolean isSetAlreadyHaveSameCard(List<Card> cardList, Card givenCard)
	{
		for (Card card : cardList)
		{
			if (card.getRank() == givenCard.getRank() && card.getSuit() == givenCard.getSuit())
			{
				return true;
			}
		}
		return false;
	}

	// Check for a given card if there any touch card from a set of cards in
	// hand
	private Card getTouchCardForAnyRemainingCard(Card card)
	{
		if (_sets.size() < MaxSets)
		{
			int i = 0;
			while (i < _cardsInHand.size())
			{
				if (_cardsInHand.get(i) != card && isTouchCards(card, _cardsInHand.get(i)))
				{
					return _cardsInHand.get(i);
				}
				i++;
			}
		}
		return null;
	}

	// Checks if the given card can fit any of the sets
	public boolean isTouchCardForAnySetCards(Card card)
	{
		if (_sets.size() < MaxSets)
		{
			int i = 0;
			while (i < _cardsInHand.size())
			{
				if (_cardsInHand.get(i) != card && isTouchCards(card, _cardsInHand.get(i)))
				{
					return true;
				}
				i++;
			}
		}
		for (List<Card> set : _sets)
		{
			boolean isTouchCard = false;
			for (Card setCard : set)
			{
				// to avoid duplicate cards in single set
				if (!isSetAlreadyHaveSameCard(set, card))
				{
					if (isTouchCards(setCard, card))
					{
						isTouchCard = true;
						break;
					}
				}
			}
			if (isTouchCard)
			{
				if (((isJokerCard(card)) || isSetHasSameSuit(set, card) && card.getSuit() == set.get(0).getSuit())
						|| (isSetHasSameRank(set) && card.getRank() == set.get(0).getRank()))
				{
					if (getNumberOfFreeSpaceInSet(set) > 0)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	// Check given two cards are touch cards or not
	private boolean isTouchCards(Card card1, Card card2)
	{
		if (_hasFirstSequence >= 0 && _hasSecondSequence >= 0 && (card1.getSuit() != card2.getSuit())
				&& (card1.getRank() == card2.getRank()))
		{
			return true;
		}
		if ((card1.getSuit() == card2.getSuit())
				&& ((Math.abs(card1.getRank() - card2.getRank()) == 1) || (Math.abs(card1.getRank() - card2.getRank()) == 12)))
		{
			return true;
		}
		return false;
	}

	// Check whether the card is joker card or not
	private boolean isJokerCard(Card card)
	{
		return (card.getRank() == _openJokerRank) ? true : false;
	}

	// Throws a card which is least wanted from the throwable cards in hand
	public Card getLeastWantedCard()
	{
		List<Card> _nonJokerCardsInHand = new ArrayList<Card>();
		for (Card card : _cardsInHand)
		{
			if (!isJokerCard(card))
			{
				_nonJokerCardsInHand.add(card);
			}
		}
		if (_nonJokerCardsInHand.isEmpty())
			return _cardsInHand.get(0);
		int maxIndex = 0;
		int Max = -1;
		for (int index = 0; index < _nonJokerCardsInHand.size(); index++)
		{
			Card card = _nonJokerCardsInHand.get(index);
			int Min = 13;
			for (int compIndex = 0; compIndex < _nonJokerCardsInHand.size(); compIndex++)
			{
				Card compareWithCard = _nonJokerCardsInHand.get(compIndex);
				if (card != compareWithCard)
				{
					int diff = findMaxDiffValue(card, compareWithCard);
					if (diff < Min)
					{
						Min = diff;
					}
				}
			}
			if (Max == -1)
			{
				Max = Min;
			} else if (Min > Max)
			{
				Max = Min;
				maxIndex = index;
			}
		}
		return _nonJokerCardsInHand.get(maxIndex);
	}

	// Find the best card for sets between two
	private int findMaxDiffValue(Card card, Card compareWith)
	{
		if (card.getSuit() == compareWith.getSuit())
		{
			return Math.abs(card.getRank() - compareWith.getRank());
		} 
		else if (card.getSuit() != compareWith.getSuit() && card.getRank() != compareWith.getRank())
		{
			return 13;
		} 
		else if (card.getSuit() != compareWith.getSuit() && card.getRank() == compareWith.getRank())
		{
			return 0;
		}
		return 0;
	}

	public boolean addRemainingCardToSet(List<Card> set, Card card)
	{
		if (getNumberOfFreeSpaceInSet(set) > 0)
		{
			set.add(card);
			_cardsInHand.remove(card);
			return true;
		}
		return false;
	}
	
	public void fitPickedCard(Card pickedCard)
	{
		_cardsInHand.add(pickedCard);
		
		if (!isJokerCard(pickedCard))
		{
			removeAllJokersFromSets();
		
			Card touchCard = getTouchCardForAnyRemainingCard(pickedCard);
			if (touchCard != null)
			{
				if (!addCardsToSet(pickedCard, touchCard))
				{
					// may be a touch card, but no set available to keep the
					// cards
					processPickedCard(pickedCard);
				}
			} 
			else
			{
				// if new card is not close to any cardsInHand, check if fits in
				// existing set
				processPickedCard(pickedCard);
			}
		}
		
		useJokers();
		
		printBotCards();
	}
	
	public boolean isReadyToSubmit()
	{
		System.out.println(" BOT IS LEFT WITH " + _cardsInHand.size());
		if(_cardsInHand.size() == 1)
		{
			return true;
		} 
		
		return false;
	}
	
	public Card discardACard()
	{
		Card discardedCard = getLeastWantedCard();
		_cardsInHand.remove(discardedCard);
		
		return discardedCard;
	}
	
	public ArrayList<ArrayList<Card>> getArrangedCards()
	{
		// If all 4 sets not exists, then create empty sets
		for (int setIndex = _sets.size(); setIndex < MaxSets; setIndex++)
		{
			_sets.add(new ArrayList<Card>());
		}
		// Adding all remaining cards except 14th card to all sets
		int loopIndex = 0;
		while (loopIndex < MaxCardsInHand)
		{
			boolean added = false;
			for (int setIndex = 0; setIndex < _sets.size() && _cardsInHand.size() > 0; setIndex++)
			{
				if (_hasFirstSequence >= 0 && setIndex == _hasFirstSequence)
				{
					continue;
				} 
				else if (_hasSecondSequence >= 0 && setIndex == _hasSecondSequence)
				{
					continue;
				}
				List<Card> set = _sets.get(setIndex);
				if (addRemainingCardToSet(set, _cardsInHand.get(0)))
				{
					added = true;
				}
			}
			if(added)
			{
				loopIndex = 0;
			}
			else
			{
				loopIndex++;
			}
		}
		
		return _sets;
	}
	
	public Card getShowCard()
	{
		System.out.println(" Size of Cards in Hand " + _cardsInHand.size());
		return _cardsInHand.get(0);
	}
	
} //BotModelImpl
