/**
 * Show score card. Assign round win achievements to winner.
 * Change state to MatchNewDealSTM or MatchEndingSTM
 * 
 * If the match is over, then the scorecard should be presented by MatchEndingSTM.
 * However, it will be the same scorecard, so the code gets replicated (which is bad).
 * So we derive MatchEndingSTM from MatchScore4DealSTM to reuse the code. However, the
 * event handlers and timeout handlers should NOT BE CALLED.
 */

package com.mango.games.rummy.logic.common.match;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.achievements.Achievement;
import com.mango.games.rummy.achievements.AchievementManager;
import com.mango.games.rummy.achievements.Effort;
import com.mango.games.rummy.achievements.Effort.Type;
import com.mango.games.rummy.bot.BotPlayerAdapter;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.DealAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.MatchAdapter;
import com.mango.games.rummy.logic.common.timers.TimedAction;


import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.PlayerType;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.Score;


public class MatchScore4DealSTM extends AbstractSTM 
{
	boolean gameIsEnding = false;
	
	/**
	 * @param stateHolder
	 */
	public MatchScore4DealSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}
	
	public void enterState() 
	{
		Log.logger.debug("Entering Match Score 4 Deal");
		/**
		 * Check if the end of this deal also ends the match. If so, then change state to MatchEndingSTM,
		 * if not, continue with scorecard and start a new deal
		 */
		Match match = (Match)getClientAdapter().getTarget();
		Game game = match.getGame();
		Deal deal = match.getDeal();
		MatchAdapter matchAdapter = (MatchAdapter) this.getClientAdapter();
		int numSeated = game.getNumSeatedPlayers();
		int cntRemaining = 0;
		
		gameIsEnding = true;
		
		Log.logger.debug("Player score " + game.getMaxScore());
		Log.logger.debug("Game Ending?" + gameIsEnding);
		
		if(numSeated > 1)
		{
			for(EObject obj: match.getMatchplayer())
			{
			    MatchPlayer player = (MatchPlayer)obj;
			    DealPlayer dealPlayer = deal.getPlayerById(player.getId());
			    
			    if(dealPlayer.getScore() == null)
			    {
			    	Log.logger.debug("Deal Player SCORE is NULL");
			    }
			    
			    Score score1 = (Score) matchAdapter.getModelFactory().createObject(Score.class);
			    score1.setScore(dealPlayer.getScore().getScore());
			    score1.setDealnum(dealPlayer.getScore().getDealnum());
			    player.getScore().add(score1);

			    Log.logger.debug("Deal Player Score:" + dealPlayer.getScore());

			    int score = player.getTotalScore();
			    System.out.println("Player " + player.getId() + " score " + score);
			    
			    if(score <= game.getMaxScore() && score > -1) // checking against the default value
			    {
			    	cntRemaining++;
			    }
			}
			
			if(cntRemaining > 1)
			{
				Log.logger.debug("gameIsEnding:False cnt " + cntRemaining);
				gameIsEnding = false;
			}
		}
		
		if(gameIsEnding)
		{
			Log.logger.debug("Changing state to MatchEnding");
			changeState(new MatchEndingSTM(this.stateChanger));
			return ;
		}
		
		/**
		 * If game is not ending, then continue displaying scorecard and schedule a timeout for starting a new deal.
		 */
	    //Show the score card
		showScorecard(false);
		
		//Set a timer for next deal to start
		this.getClientAdapter().getTimerScheduler().scheduleTimeout(TimeoutConstants.SHOWING_SCORECARD, TableScheduler.SCORECARD);
	}
	
	/**
	 * 1. Close and clear current deal - For garbage collection
	 */
	public void exitState()
	{
		/**
		 * If the game is not ending, then clean the current deal to start a new deal.
		 * If the game is ending, then don't clean the deal, because the MatchEndingSTM needs
		 * the deal data to complete the scorecard process.
		 */
		if(gameIsEnding == false)
		{
			System.out.println("Exiting from MatchScorecard4Deal");
			//Clear the current deal so that a new deal can be created and associated with match.
			Match match = (Match)getClientAdapter().getTarget();
			Deal deal = match.getDeal();
			
			//Clear the current deal object
		    deal.eAdapters().remove(0); //Remove the deal adapter.
		    match.setDeal(null); //release the deal object for garbage collection
		}
	}
	
	/**
	 *  a new deal is to be started or the match winner is identifed and
	 * the game is closed - The match goes to NewDealSTM or MatchEndingSTM
	 */
	public int timeout(TimedAction action)
	{
		if(action.getSeq() == TableScheduler.SCORECARD) 
		{
			Log.logger.debug("Inside table scheduler timeout for MatchScore4Deal: 1");
			changeState(new MatchNewDealSTM(this.stateChanger));
			return 1;
		} 
		else 
		{
			Log.logger.debug("Inside table scheduler timeout for MatchScore4Deal: 2");
			return 0;
		}
	}

	/**
	 * 1. add current deal score to the match score.
	   2. get winner, who initiates and scores 0. Or the one with a 0.
	   4. send player cards, score for current round and total score
	 * 5. send achievements	
	 */
	protected void showScorecard(boolean isGameOver)
	{
		Match match = (Match)getClientAdapter().getTarget();
		Game game = match.getGame();
		Deal deal = match.getDeal();
		
		DealPlayer winnerOfTheRound = null;
		
		EList<EObject> dealPlayers = deal.getDealplayer();
			
		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			Score score = dealPlayer.getScore();
			Log.logger.debug("Score:" + score);
			int plyrScore = dealPlayer.getScore().getScore();
			
			MatchPlayer mPlayer = match.getMatchPlayerById(dealPlayer.getId());
			
			if(mPlayer != null)
			{
				//Add the score to mplayer scores
				
				//If the total score of the match player is more than maximum score
				//then mark this player as lost the game
				if(mPlayer.getTotalScore() > game.getMaxScore())
				{
					dealPlayer.updateState(DealPlayer.LOST_GAME); //Sanjeev not sure the need for this
					
					// if it is a bot then deactivate bot adapter
					processBotLostGame(dealPlayer);
				}
			}
			
			//Find the winner of this deal
			if(deal.getShowInitiator() == dealPlayer.getId() && plyrScore == 0)
			{
				winnerOfTheRound = dealPlayer;
			}
			//If the show was not initiated
			else if(plyrScore == 0 && winnerOfTheRound == null)
			{
				winnerOfTheRound = dealPlayer;
			}
		}
		
		// set winner
		winnerOfTheRound.setWinner(true);
		
		// send achievements
		assignRoundWinAchievements(winnerOfTheRound.getId());
		
		// send scorecard
		this.getClientAdapter().getServerResponseManager().sendScorecard(winnerOfTheRound.getId(), isGameOver);
	}
	
	private void processBotLostGame(DealPlayer dealPlayer)
	{
		Match match = (Match)getClientAdapter().getTarget();
		Deal deal = match.getDeal();

		if(dealPlayer.getType() == PlayerType.BOT)
		{
			DealAdapter dealAdapter = (DealAdapter) EcoreUtil.getRegisteredAdapter(dealPlayer, dealPlayer);
			
			if(dealAdapter != null)
			{
				BotPlayerAdapter botPlayerAdapter = dealAdapter.getBotPlayerAdapter(dealAdapter.getCurrentPlayer());
				
				if(botPlayerAdapter != null)
				{
					try
					{
						Log.logger.debug("Bot Deactivated!");
						botPlayerAdapter.deactivate();
					} 
					catch (Exception e) 
					{
						Log.logger.debug("Failed to Deactivated Bot!");

						e.printStackTrace();
					}
				}
			}
		}
	}

	private void assignRoundWinAchievements(long winnerOfTheRound)
	{
		Match match = (Match)getClientAdapter().getTarget();
		Deal deal = match.getDeal();
		
		DealPlayer winner = deal.getPlayerById(winnerOfTheRound);
		
		if(winner != null)
		{
			int foundKingsOrQueens = -1;
			
			for(int i=0; i<winner.getHighLights().size(); i++)
			{
				int highlight = winner.getHighLights().get(i);
				
				if((foundKingsOrQueens == 3 && highlight == 4) || 
						(foundKingsOrQueens == 4 && highlight == 3)) highlight = 7;
				
				if((highlight == 3 || highlight == 4)) foundKingsOrQueens = highlight;  

				Effort effort = new Effort(Type.ROUND_WIN, 1, highlight);
				
				Achievement achievement = AchievementManager.getIfAchievement(effort);
				
				if(achievement != null && false == AchievementManager.hasAlreadyAchieved(winner.getId(), achievement))
				{
					this.getClientAdapter().getServerResponseManager().sendAchievement(achievement.AchievementID, winner.getId());
				}
			}		
		}
	}
}
