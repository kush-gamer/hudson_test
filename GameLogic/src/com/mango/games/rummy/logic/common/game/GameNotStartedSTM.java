package com.mango.games.rummy.logic.common.game;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.common.AbstractGameAdapter;
import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.model.ModelCreationFactory;
import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;


/**
 * @author Sanjeev
 *
 */
public class GameNotStartedSTM extends AbstractSTM 
{
	public GameNotStartedSTM(IStateChanger stateHolder)
	{
		super(stateHolder);
	}
	
	public void enterState() 
	{
		
	}
	
	public void exitState()
	{
		
	}

	/** 
	 *  State Change - None
	 *  - add this player to game players
	 *	- send opponent info
	 */
	public int joinMe(long playerID) throws Exception
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		
		Game game = gameAdapter.getGame();
		
		Player player = gameAdapter.joinPlayerToRoom(playerID);
		
		//1.1) TODO: update buddy variables
		
		if(player != null)
		{
			gameAdapter.getServerResponseManager().sendOpponentInfo(player.getId(), game.getSeat());
			
			if(!gameAdapter.isPlayerEligible(player))
			{
				gameAdapter.getServerResponseManager().sendNotEligibleForXP(player.getId());
			}
			
			return 1;
		}
		else
		{
			throw new Exception("Application Error: Player not found in Database");
		}
	}
	
	/**
	 * State Change - GameWaitingToStartSTM
	 *  - add this player to the game players.
	 *  - send opponent info
	 *  - if joining from buddy list, and from within the game, take seat with the given seat
	 *  - if joining from buddy list from lobby on a created room, give owner the first [0]th seat
	 *  - if joining from Quick Play give the vacant seat. (Currently 0 seat with Bot at 1)
	 *  - send if player not eligible for xp
	 *  
	 */
	//TODO: BOT implementation for Quick Play
	
	public int quickJoin(long playerID, boolean fromBuddyList, int seatID) throws Exception
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();

		Game game = gameAdapter.getGame();
		Player player = gameAdapter.joinPlayerToRoom(playerID);
		
		//1.1) TODO: update buddy variables

		if(player != null)
		{
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
				this.getClientAdapter().getServerResponseManager().sendNotEligibleForXP(player.getId());
			}
		
			return 1;
		}
		else
		{
			throw new Exception("Application Error: Player not found in Database");
		}
	}
	
	/**
	 * State Change - GameWaitingToStartSTM
	 *  - assign seat to this player.
	 *  - send FailedToAddPlayer if seat not allocated
	 */
	public int takeSeat(long playerID, long seatID) 
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		
		Player player = gameAdapter.getPlayerByID(playerID); 
		
		if(false == gameAdapter.allocateSeat(player, seatID))
		{
			this.getClientAdapter().getServerResponseManager().sendFailedToAddPlayer(player.getId());
			
			return 1;
		}
		else
		{
			Log.logger.debug("Player allocated seat " + playerID + " " + seatID);
		}
	
		/**
		 * If the seat is allotted to the user, and there are more than 1 user on the table now
		 * then change the state of the game to Waiting to Start
		 */
		
		Log.logger.debug("No of seats occupied " + gameAdapter.getNumOfSeatsOccupied());

		if(gameAdapter.getNumOfSeatsOccupied() == gameAdapter.getGame().getMaxPlayers())
		{
			changeState(new GamePlayingSTM(this.stateChanger));
		}		
		else if(gameAdapter.getNumOfSeatsOccupied() >= gameAdapter.getGame().getMinPlayersRequired())
		{
			changeState(new GameWaitingToStartSTM(this.stateChanger));
		}
		else // Game configuration should determine if BOTS are allowed.
		{
			getClientAdapter().getTimerScheduler().scheduleTimeout(TimeoutConstants.BOT_SEATING, TableScheduler.BOTSEAT);
		}

		return 1;
	}
	
	/**
	 * HANLDES only TableScheduler.BOTSEAT timer callbacks. Other callbacks should be ignored
	 * If no other player joins the room, then have a BOT seated to start the game.
	 * TODO - BOT-LOGIC : Add BOT creation and seating logic here.
	 */
	public int timeout(TimedAction action)
	{
		if(action.getSeq() == TableScheduler.BOTSEAT)
		{
			onUserIdleTimeout();
			
			this.changeState(new GamePlayingSTM(this.stateChanger));
			
			return 1;
		}
		
		//Ignore other timer callbacks and return 0
		return 0;
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
		// remove player from the list of game players,
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		gameAdapter.removePlayer(playerID);
		
		Seat playerSeat = gameAdapter.resetSeatForThePlayer(playerID);
		
		int seatID = -1;
		if(playerSeat != null)
		{
			seatID = playerSeat.getSeatId();
		}
		
		// inform others, if there is someone else in the room
		this.getClientAdapter().getServerResponseManager().sendPlayerDisconnected(playerID, seatID);
	}
	
	private void onUserIdleTimeout()
	{
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) this.getClientAdapter();
		int vacantSeat = gameAdapter.getVacantSeat().getSeatId();
		
		BotPlayer botDealPlayer = (BotPlayer) this.getClientAdapter().getModelFactory().
				createObject(BotPlayer.class);
		
		ModelCreationFactory mFactory = (ModelCreationFactory)this.getClientAdapter().getModelFactory();
        mFactory.getDocumentRoot().setBotPlayer(botDealPlayer);
		
		BotPlayerAdapter botadapter = (BotPlayerAdapter) EcoreUtil.getRegisteredAdapter(botDealPlayer, botDealPlayer);
		botadapter.setClientAdapter(this.getClientAdapter());
		
		// id should be roomid
		long botPlayerID = botadapter.spawnBot((int)gameAdapter.getGame().getId());
		
		if(botPlayerID != 0)
		{
			Log.logger.debug(" Sending BotPlayer Instance  " + botDealPlayer);
			gameAdapter.joinPlayerToRoom(botDealPlayer, botPlayerID);
			takeSeat(botPlayerID, vacantSeat);
		}
	}
}
