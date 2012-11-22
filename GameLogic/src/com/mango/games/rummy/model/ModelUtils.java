/**
 * A utility file to manipulate model elements. 
 * Will hold static utility methods to manipulate model elements.
 */
package com.mango.games.rummy.model;

import org.eclipse.emf.common.util.EList;

import com.mango.games.rummy.utils.Log;
import com.mangogames.rummy.model.Card;

/**
 * @author sanjeev
 *
 */
public class ModelUtils 
{
	
	/**
	 * Finds the card in the list of cards using the suit/rank values and removes the instance of that card.
	 * Note that the input paramenter card instance may not be the instance in the list of cards.
	 * Hence the logic to find corresponding card with same suit/rank values before removing it.
	 * @param cards
	 * @param findCard
	 * @return
	 */
	public static Card removeCardFromList(EList cards, Card findCard)
	{
		Log.logger.debug("Inside remove card, card to remove is " + findCard);
		for(int i=0; i<cards.size(); i++ )
		{
			
			Card iCard = (Card) cards.get(i);
			Log.logger.debug("Inside remove card, card in hand is " + iCard);
			if( iCard.isEqual(findCard) == true )
			{
				Log.logger.debug("Found card " + findCard);
				cards.remove(iCard);
				return iCard;
			}
		}
		
		/**
		 * Return false if the card is not found in the list
		 */
		return null;
	}
	
	/**
	 * Find a given card in the list of cards.
	 * Compare the card contents instead of card object's instance value.
	 * @param cards
	 * @param findCard
	 * @return
	 */
	public static Card findCardInList(EList cards, Card findCard)
	{
		for(int i=0; i<cards.size(); i++ )
		{
			Card iCard = (Card) cards.get(i);
			
			if( iCard.isEqual(findCard) == true )
			{
				return iCard;
			}
		}
		
		return null;
	}
	
}
