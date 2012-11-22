package com.mango.games.rummy.logic.common.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mango.games.rummy.logic.common.core.ERank;
import com.mango.games.rummy.logic.common.core.ESuit;
import com.mango.games.rummy.logic.common.core.ShowSlot.ELuck;
import com.mango.games.rummy.logic.common.core.ShowSlot.ESeqType;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.utils.Log;
import com.mangogames.rummy.model.Card;

public class CardCore 
{
	public static int GetPoint(ERank rank)
	{
		switch(rank)
		{
		case JACK:
		case QUEEN:
		case KING:
		case ACE:
		case ACE_WITH_FACE:
			return 10;
		case DEUCE:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		case TEN:
			return 10;
		}
		
		return 0;
	}

	private static boolean IsJoker(Card card, Card openJoker)
	{
		return (IsOpenJoker(card, openJoker));
	}
	
	public static boolean IsOpenJoker(Card card, Card openJoker)
	{
		return ((card.getRank() == openJoker.getRank()));
	}
	
	private static int GetNumberOfJokers(List<Card> cards, List<Integer> indicies, Card openJoker)
	{
		int count = 0;
		
		for(int i=0; i<cards.size(); i++)
		{
			if(IsJoker(cards.get(i), openJoker))
			{
				indicies.add(i);
				count++;
			}
		}

		return count;
	}
		
	private static int GetNumberOfJokers(List<Card> cards, Card openJoker)
	{
		int count = 0;
		
		for(int i=0; i<cards.size(); i++)
		{
			if(IsJoker(cards.get(i), openJoker))
			{
				count++;
			}
		}
		
		return count;
	}
	
	public static boolean DoesItMakeASet(ShowSlot slot, Card openJoker)
	{
		List<Card> scanCards = slot.Sequence;

		int noOfSpades = 0, noOfHearts = 0, noOfDiamonds = 0, noOfClubs = 0;
		
		int jokerCount = 0;
		
		for(int i=0; i<scanCards.size(); i++)
		{
			Card thisCard = scanCards.get(i);

			if(IsJoker(thisCard, openJoker))
			{
				jokerCount++;
				continue;
			}
			
			if(i == 0)
			{
				if(thisCard.getSuit() == ESuit.CLUB.ordinal()) noOfClubs++;
				else if(thisCard.getSuit() == ESuit.DIAMOND.ordinal()) noOfDiamonds++;
				else if(thisCard.getSuit() == ESuit.HEART.ordinal()) noOfHearts++;
				else if(thisCard.getSuit() == ESuit.SPADE.ordinal()) noOfSpades++;
			}
				
			int rankOfTheSlot = thisCard.getRank(); 
			
			for(int j=i+1; j<scanCards.size(); j++)
			{
				Card scannedCard = scanCards.get(j);
	
				if(IsJoker(scannedCard, openJoker))
				{
					continue;
				}
		
				if(i == 0)
				{
					if(scannedCard.getSuit() == ESuit.CLUB.ordinal()) noOfClubs++;
					else if(scannedCard.getSuit() == ESuit.DIAMOND.ordinal()) noOfDiamonds++;
					else if(scannedCard.getSuit() == ESuit.HEART.ordinal()) noOfHearts++;
					else if(scannedCard.getSuit() == ESuit.SPADE.ordinal()) noOfSpades++;
				}
				
				if(scannedCard.getRank() != rankOfTheSlot) // scanned card is not a joker, neither was this card, hence invalid set
				{
					return false;
				}
			}
			
			// to make sure they all are of different suits 
			if(noOfClubs > 1 || noOfDiamonds > 1 || noOfHearts > 1 || noOfSpades > 1)
			{
				return false;
			}
		}
		
		if(jokerCount == scanCards.size()) // possibility of a pure set
		{
			int clubs = 0;
			int diamonds = 0;
			int hearts = 0;
			int spades = 0;
			
			for(Card card : scanCards)
			{
				if(card.getSuit() == ESuit.CLUB.ordinal()) clubs++;
				if(card.getSuit() == ESuit.HEART.ordinal()) hearts++;
				if(card.getSuit() == ESuit.SPADE.ordinal()) spades++;
				if(card.getSuit() == ESuit.DIAMOND.ordinal()) diamonds++;
			}
			
			if(clubs > 1 || diamonds > 1 || hearts > 1 || spades > 1)
			{
				slot.Type = ESeqType.SET;
				slot.NoOfJokersUsed = jokerCount;
			}
			else
			{
				slot.Type = ESeqType.PURE_SET;
				slot.NoOfJokersUsed = 0;
			}			
		}
		else if(jokerCount > 0 && jokerCount < scanCards.size())
		{
			slot.Type = ESeqType.SET;
			slot.NoOfJokersUsed = jokerCount;
		}
		else if(jokerCount == 0)
		{
			slot.Type = ESeqType.PURE_SET;
			slot.NoOfJokersUsed = 0;
		}

		return true;
	}
	
	public static int GetTotalScore(boolean ofAllCardsInHand, Card openJoker, List<ShowSlot> slots)
	{
		int total = 0;
		
		for(ShowSlot slot : slots)
		{
			if(ofAllCardsInHand)
			{
				total += GetScore(slot.Sequence);
			}
			else
			{
				// was invalid
				 if(slot.Type == ShowSlot.ESeqType.INVALID) 
				 {
					 total += GetScore(slot.Sequence);
				 }
			}
		}
		
		return total;
	}
	
	private static int GetScore(List<Card> scanCards)
	{
		int score = 0;
		
		for(Card card : scanCards)
		{
			ERank rank = GetRankForInt(card.getRank());
			score += GetPoint(rank);
		}
		
		return score;
	}	
	
	private static boolean IsSameSuitSequence(List<Card> cards, Card openJoker, boolean isPure)
	{
		for(int i=0; i<cards.size(); i++)
		{
			Card thisCard = cards.get(i);
			
			if(IsJoker(thisCard, openJoker) && isPure == false)
			{
				continue;
			}
			else if(IsJoker(thisCard, openJoker) && isPure == true && AreAllCardsOfSameSuit(cards) == false)
			{
				return false;
			}
			
			ESuit suitOfTheSlot = GetSuitForInt(thisCard.getSuit()); 
			
			for(int j=i+1; j<cards.size(); j++)
			{
				Card scannedCard = cards.get(j); 
				
				if(IsJoker(scannedCard, openJoker))
				{
					continue;
				}
				if(scannedCard.getSuit() != suitOfTheSlot.ordinal()) // scanned card's suit is not same as the suit of the slot
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean AreAllCardsOfSameSuit(List<Card> cards) //TODO: OPTIMIZE
	{
		for(int i=0; i<cards.size(); i++)
		{
			Card thisCard = cards.get(i);

			ESuit suitOfTheSlot = GetSuitForInt(thisCard.getSuit()); 

			for(int j=i+1; j<cards.size(); j++)
			{
				Card scannedCard = cards.get(j); 
			
				if(scannedCard.getSuit() != suitOfTheSlot.ordinal()) // scanned card's suit is not same as the suit of the slot
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static List<Card> SeparateJokers(List<Card> cards, Card openJoker)
	{
		List<Card> jokers = new ArrayList<Card>();
		
		for(int i=cards.size()-1; i>=0; i--)
		{
			Card card = cards.get(i);
			
			if(IsOpenJoker(card, openJoker))
			{
				jokers.add(card);
				
				cards.remove(i);
			}
		}
		
		return jokers;
	}
	
	public static boolean DoesItMakeAPureRun(ShowSlot slot, Card openJoker, IModelCreationFactory modelCreationFactory)
	{
		List<Card> incomingCards = slot.Sequence;
		
		// are all having same suit
		if(IsSameSuitSequence(incomingCards, openJoker, true) == false)
		{
			System.out.println("Not of same suit");
			return false;
		}

		List<Card> scanCards = new ArrayList<Card>();
		for(int i = 0; i<incomingCards.size(); i++)
		{
			Card newCard = (Card) modelCreationFactory.createObject(Card.class);
			newCard.setRank(incomingCards.get(i).getRank());
			newCard.setSuit(incomingCards.get(i).getSuit());

			scanCards.add(newCard);
		}
				
		// count the number of jokers
		int numberOfJokers = GetNumberOfJokers(scanCards, openJoker);
		
		if(numberOfJokers > 1)
		{
			System.out.println("NOT PURE RETURN" + numberOfJokers);
			return false; // not allowed / possible if pure
		}
		
		// sort the cards now
		Collections.sort(scanCards, new CardRankComparator());
		
		for(Card card : scanCards)
		{
			System.out.println(card.getRank() + " " + card.getSuit());
		}
		
		// separate Ace
		boolean isAceWaitingToFitIn = false;
		if((scanCards.get(0).getRank() == ERank.ACE.ordinal()))
		{
			isAceWaitingToFitIn = true;
		}
		
		int i = isAceWaitingToFitIn ? 2 : 1;
		
		boolean returnFalse = false;
		
		for( ; i<scanCards.size(); i++)
		{
			Card scannedCard = scanCards.get(i);
			Card previousCard = scanCards.get(i-1);
			
			System.out.println("SCANNING .. S - P " + scannedCard.getRank() + " " + previousCard.getRank());
	
			int diff = scannedCard.getRank() - previousCard.getRank();
			
			if(diff != 1)
			{
				returnFalse = true;
				break;
			}
		}
	
		if(returnFalse)
		{
			System.out.println(" NOT A RUN ");
			
			scanCards.clear();
			return false;
		}
	
		// all done, fit in ace
		if(isAceWaitingToFitIn)
		{
			returnFalse = (!IsAcePosAdjusted(scanCards, modelCreationFactory));
			System.out.println("Is Ace Fitted IN " + returnFalse);
			
			if(returnFalse)
			{
				scanCards.clear();
				return false;
			}
		}
		
		slot.AdjSequence.addAll(scanCards);
		
		scanCards.clear();
		
		return true;
	}
	
	//TODO: Optimize
	public static boolean DoesItMakeARun3(ShowSlot slot, Card openJoker, IModelCreationFactory modelCreationFactory)
	{
		List<Card> incomingCards = slot.Sequence;
		
		// are all having same suit
		if(IsSameSuitSequence(incomingCards, openJoker, false) == false)
		{
			return false;
		}

		List<Card> scanCards = new ArrayList<Card>();
		for(int i = 0; i<incomingCards.size(); i++)
		{
			Card newCard = (Card) modelCreationFactory.createObject(Card.class);
			newCard.setRank(incomingCards.get(i).getRank());
			newCard.setSuit(incomingCards.get(i).getSuit());
			scanCards.add(newCard);
		}
				
		// separate the jokers
		List<Card> jokers = SeparateJokers(scanCards, openJoker);
		
		// count the number of jokers
		int numberOfJokers = jokers.size();
		
		// save joker indexes
		List<Integer> jokerIndices = new ArrayList<Integer>();
	
		// sort the cards now
		Collections.sort(scanCards, new CardRankComparator());
		
		// fit in the jokers at the end
		scanCards.addAll(jokers);
		
		for(Card card : scanCards)
		{
			System.out.println(card.getRank() + " " + card.getSuit());
		}
		
		// separate Ace
		boolean isAceWaitingToFitIn = false;
		if((scanCards.get(0).getRank() == ERank.ACE.ordinal()) && !IsOpenJoker(scanCards.get(0), openJoker))
		{
			isAceWaitingToFitIn = true;
		}
		
		
		int i = isAceWaitingToFitIn ? 2 : 1; // start from the next index if Ace is waiting to be fit in
		
		boolean returnFalse = false;
		
		for( ; i<scanCards.size(); i++)
		{
			//refresh joker indices after consuming
			jokerIndices.clear();
			numberOfJokers = GetNumberOfJokers(scanCards, jokerIndices, openJoker);
			
			Card scannedCard = scanCards.get(i);
			Card previousCard = scanCards.get(i-1);
			
			// if both of them are jokers, => nearing the end of list and implies the previous card was not used in sequence
			// Special case: ATT (T is joker)
			if(IsOpenJoker(scannedCard, openJoker) && IsOpenJoker(previousCard, openJoker)) // already handled for pure
			{
				// check i-2 >= 0
				if((i-2) >= 0)
				{
					Card previousToPrevious = scanCards.get(i-2);
					
					if(previousToPrevious.getRank() == ERank.ACE.ordinal())
					{
						isAceWaitingToFitIn = false;
					}
					
					previousCard.setRank(previousToPrevious.getRank() + 1);
					scannedCard.setRank(previousCard.getRank() + 1);
					
					if(i == (scanCards.size() - 1))
					{
						slot.NoOfJokersUsed += 2;
					}
					else
					{
						slot.NoOfJokersUsed++;
					}
				}
				
				continue;
			}
			if(IsOpenJoker(scannedCard, openJoker) && (scanCards.get(1).getRank() == ERank.THREE.ordinal()) && isAceWaitingToFitIn) // Special Boundary condition
			{
				// change joker to duece
				// moving scannedCard to first
				Card deuce = (Card) modelCreationFactory.createObject(Card.class);
				deuce.setRank(ERank.DEUCE.ordinal());
				deuce.setSuit(scannedCard.getSuit());
				
				scanCards.add(1, deuce); //REM: ace is at 0 
				
				// remove scannedCard
				scanCards.remove(scannedCard);
				jokerIndices.remove(numberOfJokers - 1);
				slot.NoOfJokersUsed++;
				
				i--;
				
				isAceWaitingToFitIn = false; // handled ACE now
				
				continue;
			}
			
			int diff = scannedCard.getRank() - previousCard.getRank();
			
			if(diff != 1) //TODO: DO NOT TAKE ABS Val EVER, ranks are sorted and hence the diff has to be positive 1
			{
				System.out.println("Diff is not 1 " + diff);

				if(IsJoker(scannedCard, openJoker))	// previousCard cannot be joker
				{
					// check if the joker is turning Ace and ace is waiting to fit in
					ERank nextRank = GetRankForInt(previousCard.getRank() + 1);
					System.out.println("Scanned Card Turns to " + nextRank);
					
					if(nextRank == ERank.ACE_WITH_FACE && isAceWaitingToFitIn)
					{
						// fit this in the beginning of the list
						// get the first card in the sequence
						Card firstCard = scanCards.get(1); // REM: ace is at 0
						ERank preFirstCardRank = GetRankForInt(firstCard.getRank() - 1);
						
						// and hope this is not Ace either
						if(preFirstCardRank == ERank.ACE)
						{
							System.out.println(" CRAZY ACE ");
							
							returnFalse = true;
							break;
						}
						
						// check if the scanned card rank is same as pre card rank // SPECIAL CASE
						if(scannedCard.getRank() == preFirstCardRank.ordinal() && scannedCard.getSuit() == previousCard.getSuit())
						{
							slot.NoOfJokersUsed--; // to counter the increment after the processing
						}
						
						scannedCard.setRank(preFirstCardRank.ordinal()); 
						
						System.out.println("Pre First Card Rank " + preFirstCardRank);
						
						// moving scannedCard to first
						Card preFirstCard = (Card) modelCreationFactory.createObject(Card.class);
						preFirstCard.setRank(scannedCard.getRank());
						preFirstCard.setSuit(scannedCard.getSuit());
						
						scanCards.add(1, preFirstCard); //REM: ace is at 0 
						// remove scannedCard
						scanCards.remove(scannedCard);
						i--;
					}
					else if((previousCard.getRank() + 1) > ERank.ACE_WITH_FACE.ordinal() // next card replacement is going beyond 13 and no ace to fit in 
							&& !isAceWaitingToFitIn)
					{
						// fit in this at the beginning of the list
						Card firstCard = scanCards.get(0);
						ERank preFirstCardRank = GetRankForInt(firstCard.getRank() - 1);

						// and hope this is less than Ace
						if(firstCard.getRank() - 1 < 0)
						{
							System.out.println(" CRAZY NOT POSSIBLE ");
							
							returnFalse = true;
							break;
						}
						
						// check if the scanned card rank is same as pre card rank // SPECIAL CASE
						if(scannedCard.getRank() == preFirstCardRank.ordinal() && scannedCard.getSuit() == previousCard.getSuit())
						{
							slot.NoOfJokersUsed--; // to counter the increment after the processing
						}
												
						scannedCard.setRank(preFirstCardRank.ordinal()); 
						
						// moving scannedCard to first
						Card preFirstCard = (Card) modelCreationFactory.createObject(Card.class);
						previousCard.setRank(scannedCard.getRank());
						previousCard.setRank(scannedCard.getSuit());
						
						scanCards.add(0, preFirstCard);
						// remove scannedCard
						scanCards.remove(scannedCard);
						i--;
					}					
					else
					{
						scannedCard.setRank(nextRank.ordinal());
						
						// if ace is joker (i.e scanned was joker and was already ace of the same suit) then counter the joker increment
						if(nextRank == ERank.ACE_WITH_FACE && !isAceWaitingToFitIn && openJoker.getRank() == ERank.ACE.ordinal()
								&& scannedCard.getSuit() == previousCard.getSuit())
						{
							slot.NoOfJokersUsed--; // to counter the increment after processing
						}
					}
					
					jokerIndices.remove(numberOfJokers - 1);

					slot.NoOfJokersUsed++;
					
					System.out.println("CHANGE SCANNING .. S - P " + scannedCard.getRank() + " " + previousCard.getSuit());
					continue;
				}
				// AND Finally none of them is a joker
				if(numberOfJokers > 0 && (!IsJoker(scannedCard, openJoker) && !IsJoker(previousCard, openJoker)))
				{
					// fit in joker in between the two					
					Card joker = scanCards.get(jokerIndices.get(numberOfJokers - 1));
					
					scanCards.remove(joker);
					
					// part of sequence
					if(joker.getRank() == previousCard.getRank() + 1 && joker.getSuit() == previousCard.getSuit())
					{
						System.out.println("Joker part of sequence");
					}						
					else
					{
						joker.setRank(previousCard.getRank() + 1);
						slot.NoOfJokersUsed++;
						
						System.out.println("Moving Joker");
						System.out.println("CHANGE SCANNING .. S - P" + scannedCard.getRank()+ " " + previousCard.getRank());
					}
					
					// get the new index of the scanned card
					int scannedCardNewIndex = scanCards.indexOf(scannedCard);
					scanCards.add(scannedCardNewIndex, joker);					
					i--;
					
					continue;
				}
				
				returnFalse = true;
				break;
			}
		}
	
		if(returnFalse)
		{
			System.out.println(" NOT A RUN ");
			scanCards.clear();
			return false;
		}	

		// all done, fit in ace
		if(isAceWaitingToFitIn)
		{
			returnFalse = (!IsAcePosAdjusted(scanCards, modelCreationFactory));
			System.out.println("Is Ace Fitted IN " + returnFalse);
			
			if(returnFalse)
			{
				scanCards.clear();
				return false;
			}
		}
		
		slot.AdjSequence.addAll(scanCards);
		
		scanCards.clear();
		
		for(Card card : slot.AdjSequence)
		{
			System.out.println(card.getRank() + " " + card.getSuit());
		}
		
		return true;
	}
	
	public static boolean IsAcePosAdjusted(List<Card> cards, IModelCreationFactory modelCreationFactory)
	{
		if(cards.get(1).getRank() == ERank.DEUCE.ordinal())
		{
			return true;
		}
		
		if(cards.get(cards.size() - 1).getRank() == ERank.KING.ordinal())
		{
			System.out.println("Ace fitted at back");
			
			cards.remove(0);
			
			Card newCard = (Card) modelCreationFactory.createObject(Card.class);
			
			newCard.setRank(ERank.ACE_WITH_FACE.ordinal());
			newCard.setSuit(cards.get(0).getSuit());

			cards.add(newCard);
			
			return true;
		}
		
		return false;
	}	
	
	public static int ScanSlots(List<ShowSlot> showSlots, Card openJoker, ShowSlotAttribute attrib, IModelCreationFactory modelCreationFactory)
	{
		int score = 0;
	
		for(ShowSlot slot : showSlots)
		{
			Log.logger.debug("Scanning slots, inside ScanSlots");
			int slotJokers = GetNumberOfJokers(slot.Sequence, openJoker);
			attrib.NumberOfJokers += slotJokers;

			// check for sequence count, if less than 3 then invalid
			List<Card> scanCards = slot.Sequence;
			
			if(scanCards.size() < 3)
			{
				slot.Type = ShowSlot.ESeqType.INVALID;
				continue;
			}
			
			// see if it makes a run
			//if(!attrib.FoundPureRun)
			{
				if(DoesItMakeAPureRun(slot, openJoker, modelCreationFactory))
				{
					slot.Type = ShowSlot.ESeqType.PURE_RUN;
					attrib.FoundPureRun = true;
					attrib.SequenceCount++;
					System.out.println("Pure Run" + slot.ID);
					// see if (mandatory) 2 sequences are made
					if(attrib.SequenceCount >= 2)
					{
						attrib.MandatoryCheckMet = true; 
					}

					continue;
				}
			}
			
			// if not pure run then it could be a sequence with joker
			if(DoesItMakeARun3(slot, openJoker, modelCreationFactory))
			{
				slot.Type = ShowSlot.ESeqType.RUN;
				System.out.println("Joker Run" + slot.ID);
				attrib.SequenceCount++;
				
				// see if (mandatory) 2 sequences are made
				if(attrib.SequenceCount >= 2 && attrib.FoundPureRun == true)
				{
					attrib.MandatoryCheckMet = true;
				}

				continue;
			}
			
			// see if it is forming a Set
			if(DoesItMakeASet(slot, openJoker))
			{
				if(scanCards.size() == 3)
				{
					if(scanCards.get(0).getRank() == ERank.QUEEN.ordinal())
					{
						if(slotJokers == 0)
						{
							slot.Highlight = 0;
						}
					}
					else if(scanCards.get(0).getRank() == ERank.KING.ordinal())
					{
						if(slotJokers == 0)
						{
							slot.Highlight = 1;
						}
					}
				}
				
				if(scanCards.size() == 4)
				{
					if(scanCards.get(0).getRank() == ERank.ACE.ordinal())
					{
						if(slotJokers == 0)
						{
							slot.Highlight = 2;
						}
					}
				}
				
				if(slot.Highlight == 0) slot.Luck = ELuck.THREE_QUEENS;
				if(slot.Highlight == 1) slot.Luck = ELuck.THREE_KINGS;
				if(slot.Highlight == 2) slot.Luck = ELuck.FOUR_ACES;
				
				attrib.SetCount++;				
				continue;
			}
			else // neither a set nor a sequence
			{
				slot.Type = ShowSlot.ESeqType.INVALID; // it was neither a set
				System.out.println("Invalid Run - in loop" + slot.ID);
			}	
		}
		
		score = GetTotalScore(false, openJoker, showSlots);
		
		return score;
	}
	
	public static int GetSlotScore(ShowSlot slot, boolean hasJokers, Card openJoker)
	{
		ShowSlot.ESeqType type = slot.Type;
		
		if(type == ShowSlot.ESeqType.SET)
		{
			return GetJokerSetScore(slot.Sequence, openJoker);
		}
		if(type == ShowSlot.ESeqType.RUN || type == ShowSlot.ESeqType.PURE_RUN)
		{
			return GetScore(slot.AdjSequence);
		}
		
		return 0;
	}
	
	public static int GetJokerSetScore(List<Card> scanCards, Card openJoker)
	{
		int score = 0;
		for(int i=0; i<scanCards.size(); i++)
		{
			Card thisCard = scanCards.get(i);
			
			if(IsJoker(thisCard, openJoker))
			{
				continue;
			}
			else
			{
				ERank rank = GetRankForInt(thisCard.getRank());
				score += GetPoint(rank) * scanCards.size();
				
				return score;
			}
		}
		
		// joker would have been forming the set if score is still 0
		if(score == 0)
		{
			ERank rank = GetRankForInt(scanCards.get(0).getRank());
			score += GetPoint(rank) * scanCards.size();
		}
		
		return score;
	}

	public static int GetSlotMultiplier(ShowSlot slot, Card openJoker)
	{
		int multiplier = 0;
		List<Card> cards = slot.Sequence;

		int jokersUsed = slot.NoOfJokersUsed;
		
		if(slot.Type == ESeqType.PURE_RUN || slot.Type == ESeqType.PURE_SET)
		{
			jokersUsed = 0;
		}		
		
		System.out.println("JOkers used " + jokersUsed);
		
		for(Card card : cards)
		{
			if(IsOpenJoker(card, openJoker) && jokersUsed > 0)
			{
				jokersUsed--;
				continue;
			}

			ERank rank = GetRankForInt(card.getRank());
			int val = GetCardMultiplier(rank);
			
			if(val == -1) continue;
			
			multiplier += val;
		}
		
		if(multiplier == 0) return 1;
		
		return multiplier;
	}
	
	public static int GetCardMultiplier(ERank rank)
	{
		switch(rank)
		{
		case ACE_WITH_FACE:
		case ACE: 
			return 10;
		case KING:
			return 7;
		case QUEEN:
			return 4;
		case JACK:
			return 2;
		default:
			break;			
		}
		
		return -1;
	}

	public static ERank GetRankForInt(int rank)
	{
		switch(rank)
		{
			case 0:
				return (ERank.ACE);
			case 1:
				return (ERank.DEUCE);
			case 2:
				return (ERank.THREE);
			case 3:
				return (ERank.FOUR);
			case 4:
				return (ERank.FIVE);
			case 5:
				return (ERank.SIX);
			case 6:
				return (ERank.SEVEN);
			case 7:
				return (ERank.EIGHT);
			case 8:
				return (ERank.NINE);
			case 9:
				return (ERank.TEN);
			case 10:
				return (ERank.JACK);
			case 11:
				return (ERank.QUEEN);
			case 12:
				return (ERank.KING);
			case 13:
				return (ERank.ACE_WITH_FACE); //should not go to client (MAKE SURE)
		}
		// default
		return (ERank.ACE);
	}
	
	public static ESuit GetSuitForInt(int suit)
	{
		switch(suit)
		{
			case 0:
				return (ESuit.HEART);
			case 1:
				return (ESuit.SPADE);
			case 2:
				return (ESuit.DIAMOND);
			case 3:
				return (ESuit.CLUB);
		}
		
		return (ESuit.HEART);
	}
	
	/*TODO: LATER
	public ArrayList<Card> GetCardsFromString(String cardString)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		String[] allCards = cardString.split(",");

		for(String card : allCards)
		{
			// get suit and rank
			Card newCard = GetCardFromString(card);
			cards.add(newCard);
		}
		
		return cards;
	}
	

	public ArrayList<ShowSlot> GetCardsInSlotsFromString(String cardString)
	{
		ArrayList<ShowSlot> slots = new ArrayList<ShowSlot>();
		
		String[] allCards = cardString.split(",");
		
		int i = 0;
		int slotID = 0;
	
		ArrayList<Card> cards = new ArrayList<Card>();
		for(String card : allCards)
		{
			// get suit and rank
			Card newCard = GetCardFromString(card);
			cards.add(newCard);
			
			if(i == 3 || i == 6 || i == 9 || i == 12)
			{
				ShowSlot slot = CreateNewSlot(slotID, cards);
				cards.clear();
				slotID++;
				
				slots.add(slot);
			}			
			i++;
		}
		
		return slots;
	}*/
	
	public static ShowSlot CreateNewSlot(int id, ArrayList<Card> cards)
	{
		ShowSlot slot = new ShowSlot();
		
		slot.ID = id;
		slot.Sequence.addAll(cards);
		
		return slot;
	}
	
	//TODO: LATER
	/*public Card GetCardFromString(String card)
	{
		String[] cardVals = card.split("_");

		int suitOrdinal = Integer.parseInt(cardVals[0]);
		int rankOrdinal = Integer.parseInt(cardVals[1]);
		
		ESuit cardSuit = GetSuitForInt(suitOrdinal);
		ERank cardRank = GetRankForInt(rankOrdinal);
		
		Card newCard = new Card(cardRank, cardSuit);
		
		return newCard;
	}*/
}
