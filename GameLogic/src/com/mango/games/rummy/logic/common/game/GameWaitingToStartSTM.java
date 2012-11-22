package com.mango.games.rummy.logic.common.game;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;

import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;

/**
 * @author Sanjeev
 *
 */
public class GameWaitingToStartSTM extends AbstractSTM 
{
	// TODO: private static final Logger log = LoggerFactory.getLogger(AbstractSTM.class);

	/**
	 * @param stateHolder
	 */
	public GameWaitingToStartSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}

	/**
	 * Minimum required players for this room have already joined. Start the game start countdown, while waiting for room to get full.
	 */
	public void enterState() 
	{
		long timeout = TimeoutConstants.GAME_START_COUNTDOWN; 
		
        this.getClientAdapter().getTimerScheduler().scheduleTimeout(timeout, TableScheduler.GAME_STARTING);
	}
	
	/**
	 * Handles only GAME_START_COUNTDOWN timer. 
	 * Other timers should be ignored. For example, this may recieve BOT_SEAT timer message, which should be ignored.
	 */
	public int timeout(TimedAction action)
	{
		System.out.println("GameWaitingToStartSTM:timeout" + action.getSeq());
		if(action.getSeq() == TableScheduler.GAME_STARTING)
		{
			System.out.println("While changing to GAMEPLAYING");
			this.changeState(new GamePlayingSTM(this.stateChanger));
			
			return 1;
		}
		
		return 0;
	}
	
	public void exitState()
	{
	}
	
	
	/** 
	 *  State Change - None
	 *  - add this player to game players
	 *	- send opponent info
	 *	- send if not eligible for xp
	 */
	public int joinMe(long playerID)
	{
		//1) add this player to game players
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		
		Game game = gameAdapter.getGame();
		Player player = gameAdapter.joinPlayerToRoom(playerID);

		//2) TODO: update buddy variables
		
		gameAdapter.getServerResponseManager().sendOpponentInfo(playerID, game.getSeat());
		
		if(!gameAdapter.isPlayerEligible(player))
		{
			gameAdapter.getServerResponseManager().sendNotEligibleForXP(playerID);
		}

		return 1;
	}
	
	
	/**
	 * State Change - GamePlayingSTM
	 *  - add this player to the game players.
	 *  - send opponent info
	 *  - if joining from buddy list, and from within the game, take seat with the given seat
	 *  - if joining from buddy list from lobby on a created room, give owner the first [0]th seat
	 *  - if joining from Quick Play give the vacant seat. (Currently 0 seat with Bot at 1)
	 *  - send if player not eligible for xp
	 *  
	 */
	public int quickJoin(long playerID, boolean fromBuddyList, int seatID)
	{
		//0) stop bot spawn
		
		//1) add this player to game players
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		
		Game game = gameAdapter.getGame();
		Player player = gameAdapter.joinPlayerToRoom(playerID);
		
		//1.1) TODO:  update buddy variables

		//3) send opponent info
		gameAdapter.getServerResponseManager().sendOpponentInfo(player.getId(), game.getSeat());
		
		// if joining from buddy list get
		if(fromBuddyList)
		{
			// if invited from the game
			if(seatID != -1)
			{
				takeSeat(playerID, seatID);
			}
			// else created a new room with invite
			else
			{
				String ownerID = game.getOwner();

				if(ownerID.equals(playerID))
				{
					seatID = 0;
				}
				else
				{
					seatID = 1;
				}
				
				takeSeat(playerID, seatID);
			}
		}
		else
		{
			// give the vacant seat
			Seat vacantSeat = gameAdapter.getVacantSeat();
			
			takeSeat(playerID, vacantSeat.getSeatId());
		}
		
		if(!gameAdapter.isPlayerEligible(player))
		{
			gameAdapter.getServerResponseManager().sendNotEligibleForXP(playerID);
		}
		
		return 1;
	}
	
	/**
	 * State Change - GamePlayingSTM
	 *  - assign seat to this player.
	 *  - send FailedToAddPlayer if seat not allocated
	 */
	public int takeSeat(long playerID, long seatID) 
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		Player player = gameAdapter.getPlayerByID(playerID);
		
		//TODO: OLD FRAMEWORK throws user out if the room is full, sends kick out		
		if(false == gameAdapter.allocateSeat(player, seatID))
		{
			gameAdapter.getServerResponseManager().sendFailedToAddPlayer(playerID);
		}
		
		Game game = gameAdapter.getGame();
		
		if(game.getMaxPlayers() == gameAdapter.getNumOfSeatsOccupied())
		{
			this.changeState(new GamePlayingSTM(this.stateChanger));
		}
		
		return 1;
	}
	
	public int userDisconnected(long playerID)
	{
		handlePlayerGone(playerID);
		return 1;
	}
	
	public int toLobby(long playerID)
	{
		handlePlayerGone(playerID);
		return 1;
	}
	
	private void handlePlayerGone(long playerID)
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		
		// reset player seat
		Seat playerSeat = gameAdapter.resetSeatForThePlayer(playerID);
		int seatID = -1;
		if(playerSeat != null)
		{
			seatID = playerSeat.getSeatId();
		}
		
		// remove player from the list of game players,
		gameAdapter.removePlayer(playerID);
				
		// inform others, if there is someone else in the room
		this.getClientAdapter().getServerResponseManager().sendPlayerDisconnected(playerID, seatID);
		
		Game game = gameAdapter.getGame();
		if(gameAdapter.getNumOfSeatsOccupied() < game.getMinPlayersRequired())
		{
			this.changeState(new GameNotStartedSTM(this.stateChanger));
		}
	}
}
