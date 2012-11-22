/**
 * 
 */
package com.mango.games.rummy.logic.common.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.utils.PlayerType;

import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.Score;

/**
 * @author admin
 *
 */
public class MatchNewDealSTM extends AbstractSTM 
{
	public MatchNewDealSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}

	/**
	 * State Change - MatchPlayingSTM
	 *  - instantiate Deal
	 *  - Deal init STM - DealShuffleCardsSTM
	 *  - set match and deal players
	 *  - set deal count, last start turn 
	 */
	public void enterState() 
	{
		//initialize new deal
		initiateNewDeal();
		
		this.changeState(new MatchPlayingSTM(this.stateChanger));
	}
	
	private void initiateNewDeal()
	{	
		Match match = (Match)this.getClientAdapter().getTarget();
		Game  game = match.getGame();
		Deal deal = (Deal) this.getClientAdapter().getModelFactory().createObject(Deal.class);
		
		match.setDeal(deal);
		
		System.out.println("MatchNewDealSTM: " + deal.toString());
		
		//Set the turn based on toss winning
		/**
		 * TODO - This needs to be changed - Turn should be set to the next player after last turn.
		 * But for the first deal, it should be set to the toss winner or firs seated player.
		 */
		deal.setCurrentTurn(match.getLastStartTurn());
		
		//Iterate through the match players list and add them as Deal Players
		//If a player has lost the game, then the match player state should reflect so.
		for(EObject mpItem : match.getMatchplayer())
		{
	         MatchPlayer matchPlayr = (MatchPlayer)mpItem;
	         
	         if(matchPlayr.getTotalScore() <= game.getMaxScore())
	         {
	        	 DealPlayer dealPlayer = (DealPlayer) this.getClientAdapter().getModelFactory()
        				 .createObject(DealPlayer.class);	        	
			
				 dealPlayer.setName(matchPlayr.getName());
				 dealPlayer.setId(matchPlayr.getId());
				 dealPlayer.setSource(matchPlayr.getSource());
				 dealPlayer.setUidSrc(matchPlayr.getUidSrc());
				 dealPlayer.setLevel(matchPlayr.getLevel());
				 dealPlayer.setChips(matchPlayr.getChips());
			  	 dealPlayer.setXp(matchPlayr.getXp());
			  	 dealPlayer.setType(matchPlayr.getType());
					
					//Set the score object for the deal player and set it here
				 Score score = (Score) this.getClientAdapter().getModelFactory().createObject(Score.class);
				 dealPlayer.setScore(score);
				 
				 deal.getDealplayer().add(dealPlayer);
	         }
		}	
		
		/**
		 * Create an adapter for the deal, and kick of the process for starting a new deal.
		 */
		EcoreUtil.getRegisteredAdapter(deal, deal);
	}
}
