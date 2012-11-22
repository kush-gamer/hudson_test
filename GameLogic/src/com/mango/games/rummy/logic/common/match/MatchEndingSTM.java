/**
 * The game has found a winner or all other players have left the table.
 * Identify the winner, distribute funds and close the game
 */

package com.mango.games.rummy.logic.common.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.db.UserAccount;

import com.mango.games.rummy.achievements.Achievement;
import com.mango.games.rummy.achievements.AchievementManager;
import com.mango.games.rummy.achievements.Effort;
import com.mango.games.rummy.achievements.Effort.Type;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.game.GameEndedSTM;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.ScoreManager;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;

/**
 * This class derives from MatchScore4DealSTM to reuse its scoring functionality.
 * The scoring for a match end shows the scoring for the last deal and the winner information.
 * If we retain both as separate scoring systems, then there will be two scoreboards presented.
 * Hence this STM will override the deal score functionality to have a common code base and cleaner UI.
 * 
 * NOTE: OVERRIDE ALL BASE METHODS AND DO NOT CALL SUPER EXCEPT IN CASE OF CONSTRUCTOR.
 * WHEREVER SUPER IS CALLED, WRITE EXPLICIT COMMENTS ON WHAT IS DESIRED.
 * @author Mango6
 *
 */
public class MatchEndingSTM extends MatchScore4DealSTM 
{
	public MatchEndingSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}
	
	public void enterState() 
	{
		Log.logger.debug("Entering Match Ending");
		doSettlements();

		super.showScorecard(true);
		
		doleParticipationAchievements();
		
		//Set a timer for next deal to start
		this.getClientAdapter().getTimerScheduler().scheduleTimeout(TimeoutConstants.MATCH_ENDING, TableScheduler.MATCH_ENDING);
	}
	
	/**
	 *  a new deal is to be started or the match winner is identifed and
	 * the game is closed - The match goes to NewDealSTM or MatchEndingSTM
	 */
	public int timeout(TimedAction action)
	{
		Log.logger.debug("Inside timeout of MatchEnding: 2");
		//Ensure that this is not a player timeout.
		if(action.getSeq() == TableScheduler.MATCH_ENDING) 
		{
			Log.logger.debug("Inside timeout of MatchEnding: 1");
			
			Match match = (Match)this.getClientAdapter().getTarget();
			Game  game = match.getGame();

			IClientAdapter gameAdapter = (IClientAdapter)EcoreUtil.getRegisteredAdapter(game,  game);
			gameAdapter.getStateChanger().changeState(new GameEndedSTM(gameAdapter.getStateChanger()));
			
			return 1;
		}
		
		Log.logger.debug("Inside timeout of MatchEnding: 0");
		return 0;
	}
	
	private void doSettlements()
	{
		Match match = (Match)this.getClientAdapter().getTarget();
		Game game = match.getGame();
		
		EcoreUtil.getRegisteredAdapter(game, game);

		for(EObject obj : match.getMatchplayer())
		{
			MatchPlayer playr = (MatchPlayer)(obj);
			UserAccount user = UserAccount.getUserAccountbyUserID(playr.getId());
			int experience = user.getExperience(); 
			int level = user.getLevel(); 
			int chips = user.getChips();
			
			if(playr.getTotalScore() <= game.getMaxScore()) //winner
			{	
				 float xp = ScoreManager.GetInstance().GetWinXP( 
						        game.getEntryFee().intValue(),
						        game.getMaxScore(), 
						        game.getMaxPlayers(),
						        playr.getTotalScore(), 
						        playr.getLevel(), 100);
				 
				 experience += Math.round(xp);
				
				 chips += game.getPotValue();
			}
			else
			{				
				float xp = ScoreManager.GetInstance().GetLoseXP( 
				        game.getEntryFee().intValue(),
				        game.getMaxScore(), 
				        game.getMaxPlayers(),
				        playr.getTotalScore(), 
				        playr.getLevel(), 100);
				
				experience += Math.round(xp);
			}
			
			if(ScoreManager.GetInstance().IsLevelUp(level, experience))
			{
				int oldLevelCap = ScoreManager.GetInstance().GatherXP(level);
				
				experience = experience - oldLevelCap;

				level++;
				
				Effort effort = new Effort(Type.LEVEL_REACHED, level);
				Achievement achievement = AchievementManager.getIfAchievement(effort);
				
				if(achievement != null && false == AchievementManager.hasAlreadyAchieved(playr.getId(), achievement))
				{
					this.getClientAdapter().getServerResponseManager().sendAchievement(achievement.AchievementID, playr.getId());
				}
				
				this.getClientAdapter().getServerResponseManager().sendLevelUpBrag(level, playr.getId());
			}
			
			user.setChips(chips);
			user.setExperience(experience);
			user.setLevel(level);
			user.update();
		}		
	}
	
	private void doleParticipationAchievements()
	{
		Match match = (Match)this.getClientAdapter().getTarget();
		Game game = match.getGame();
		
		for(EObject obj : match.getMatchplayer())
		{
			MatchPlayer player = (MatchPlayer)(obj);
			
			if(player.getTotalScore() > game.getMaxScore()) // Player lost the game
			{
				if(ScoreManager.GetInstance().IsEligibleForTable(player.getLevel(), game.getType(),
						game.getMaxPlayers(), game.getEntryFee().intValueExact()))
				{
					// certificate of participation
					Effort effort = new Effort(Type.PARTICIPATE, game.getType());
					
					Achievement achievement = AchievementManager.getIfAchievement(effort);
					
					if(achievement != null && false == AchievementManager.hasAlreadyAchieved(player.getId(), achievement))
					{
						this.getClientAdapter().getServerResponseManager().sendAchievement(achievement.AchievementID, player.getId());
					}
				}
			}
		}
	}
}
