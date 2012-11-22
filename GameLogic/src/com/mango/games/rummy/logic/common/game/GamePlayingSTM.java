package com.mango.games.rummy.logic.common.game;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.utils.Log;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;
import com.mangogames.rummy.model.Settlement;

/**
 * @author Sanjeev
 *
 */
public class GamePlayingSTM extends AbstractSTM 
{
	/**
	 * @param stateHolder
	 */
	public GamePlayingSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	/**
	 * State Change - None
	 *  - instantiate Match
	 *  - Match init STM - MatchTossSTM
	 */
	public void enterState()
	{
		initMatch();
	}
	
	
	public void exitState()
	{
		// TODO: DB Not Done save Game
		//Game
	}
	
	/**
	 * Create match.
	 * TODO Create the match players and deduct the money for the table.
	 */
	private void initMatch()
	{
		Match match = (Match) this.getClientAdapter().getModelFactory().createObject(Match.class);
		Game  game  = getGame();
		
		EList<EObject> matchPlayers = match.getMatchplayer();
		
		game.setMatch(match);
		
		for(EObject obj : game.getSeat())
		{
			Seat seat = (Seat) obj;
			if(seat != null)
			{
				Player player = (Player) seat.getPlayer();	
				
				if(player != null)
				{
					IModelCreationFactory factory = getClientAdapter().getModelFactory();
					// deduct fee and add to pot
					deductFeeAddToPot(player.getId());
					
					MatchPlayer matchPlayer = (MatchPlayer) factory.createObject(MatchPlayer.class);
			        Settlement settlemnt = (Settlement) factory.createObject(Settlement.class); //TODO: ask Sanjeev
			        
					matchPlayer.setName(player.getName());
					matchPlayer.setId(player.getId());
					matchPlayer.setSource(player.getSource());
					matchPlayer.setUidSrc(player.getUidSrc());
					matchPlayer.setLevel(player.getLevel());
					matchPlayer.setChips(player.getChips());
					matchPlayer.setXp(player.getXp());
					
					Log.logger.debug("Player TYPE " + player.getType() + " PLAYER ID " + player.getId());
					matchPlayer.setType(player.getType());
					
					//Create an empty settlement object
					matchPlayer.setSettlement(settlemnt);
					
					//Add the player to match
					matchPlayers.add(matchPlayer);
				}
			}
		}
		
		//Initialize the match adapter - This will start the toss process of the match.
		EcoreUtil.getRegisteredAdapter(match, match);
	}
	
	private void deductFeeAddToPot(long playerID)
	{
		Game game = getGame();
		AbstractGameAdapter adapter = (AbstractGameAdapter) EcoreUtil.getRegisteredAdapter(game, game);

		//TODO: DB Not Done access
		Player player = adapter.getPlayerByID(playerID);
		
		// update player chips
		int fee = player.getChips() - game.getEntryFee().intValueExact();
		player.setChips(fee);
		
		// add to pot
		int dPot = (int) (game.getPotValue() + (game.getEntryFee().intValueExact() - game.getRake()));
		game.setPotValue(dPot);
	}
	
	private Game getGame()
	{
		return (Game) this.getClientAdapter().getTarget();
	}
}
