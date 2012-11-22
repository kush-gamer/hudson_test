package com.mango.games.rummy.logic.common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.db.UserDB;
import com.mango.games.db.UserAccount;

import com.mango.games.rummy.logic.actions.EventHandlerMap;
import com.mango.games.rummy.logic.common.game.GameNotStartedSTM;
import com.mango.games.rummy.logic.common.game.GameStateHolder;
import com.mango.games.rummy.logic.common.timers.TimedAction;

import com.mango.games.rummy.model.IModelCreationFactory;

import com.mango.games.rummy.utils.ITimerScheduler;
import com.mango.games.rummy.utils.Log;
import com.mango.games.rummy.utils.PlayerType;
import com.mango.games.rummy.utils.ScoreManager;
import com.mango.games.rummy.utils.TableScheduler;

import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;

import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * This adapter sits between the client interface (called from SFX/Socket-server), and the server
 * interface (called from the Game Model through notifications). 
 * 
 * Client request (from SFX) to GameAdapter
 * Each Game model object will have a game-adapter. The GameAdapter delegates management of Game State
 * to the StateMachine (IGameSTM). The State Machine makes changes to the Game Model
 * 
 * Listener to Game Model changes.
 * Adapter listens to game model changes. It then sends the updated state information to the Game Client(s), 
 * through SFX (Socket server) API.
 *
 * @author Sanjeev
 *
 */
public abstract class AbstractGameAdapter extends AbstractAdapter
{
    private IStateChanger _stateHolder;
	
    private ITimerScheduler _tableScheduler;

    private IModelCreationFactory _modelFactory;   
   
    private ServerResponseManager _serverResponseManager;
    
    private EventHandlerMap _eventHandlerMap;

	public AbstractGameAdapter(EObject targt)
	{
		super(targt);
		
		_stateHolder = new GameStateHolder(this);
		_stateHolder.changeState(new GameNotStartedSTM(_stateHolder));
		
		Game game = (Game)getTarget();
		
		_tableScheduler = new TableScheduler(this);
		
		initialize(game);
	}
	
	public void setEventHandlerMap(EventHandlerMap eventHandlerMap) 
	{
		_eventHandlerMap = eventHandlerMap;
	}
	
	public EventHandlerMap getEventHandlerMap() 
	{
		return _eventHandlerMap;
	}
	
	public void setServerResponseManager(ServerResponseManager serverResponseManager)
	{
		_serverResponseManager = serverResponseManager;
		_serverResponseManager.setGame((Game) this.getTarget()); 
	}
	
	public ServerResponseManager getServerResponseManager()
	{
		return _serverResponseManager;
	}
	
	@Override
	public void setModelCreationFactory(IModelCreationFactory fc)
	{
		this._modelFactory = fc;
	}
	
	public IModelCreationFactory getModelCreationFactory()
	{
		return _modelFactory;
	}
	
	public IStateChanger getStateChanger()
	{
		return _stateHolder;
	}
	
	public ITimerScheduler getTableScheduler()
	{
		return _tableScheduler;
	}
	
	/**
	 * Initialize game state...In the first implementation,
	 * the initial state will be base state (first state).
	 */
	private void initialize(Game game)
	{
		_stateHolder.changeState(new GameNotStartedSTM(_stateHolder));
	}

/** HELPER METHODS */
	
	
	/**
	 * Client side interface methods. A Client message is to be routed to the Adapter first.
	 * The adapter will delegate it to its State Machine. A chain of delegation is to be implemented as follows -
	 * a. Game Delegates it to the Match, if the match is in progress.
	 * b. Match Delegates it to the Deal, if the Deal is in progress.
	 * c. After Deal and Match have processed the message, GameAdapter will process the message. 
	 * d. Not implemented: We can have a reverse flow too, whereby Game processes it first and then gives it to the Match and then Match to Dea.
	 * As I type it, the choice between c and d is not made. 
	 */
	
    public int handleEvent(ISFSObject params) throws Exception
    {
       	return super.handleEvent(params);
    }
    
    /**
     * Method to handle timeout actions. These actions are called from inside the app
     * when an action is timedout. The timeout is to be handled by appropriate state machine
     * just as a client event is handled.
     */
    public int handleTimeout(TimedAction action) throws Exception
    {
    	//This method unravels the event object and call appropriate action in the state machine.
    	int isHandled = super.handleTimeout(action);
    	
    	//Remove the timeout from the cache.
    	if( action.getPlayerTurnId() != 0 )
    	{
    		_tableScheduler.clearTimeout(action.getPlayerTurnId());
    	}
    	
    	return isHandled;
    }
    
    
    public IClientAdapter getChildAdapter()
    {
    	return getMatchAdapter();
    }
    
    public IStateChanger getStateHolder()
    {
    	return this._stateHolder;
    }
    
    /**
     * Gets the match adapter, if the match is in progress. If not, returns null
     * @return
     */
    private IClientAdapter getMatchAdapter()
    {
    	IClientAdapter matchAdapter = null;
    	//Get the corresponding model object. All Games are derived from Game model
    	Game game = (Game)this.getTarget();
    	
    	//Get the match from the game
    	Match match = (Match)game.getMatch();
    	
    	//From the match, get its adapter
    	if(match != null)
    	{
    	    matchAdapter = (MatchAdapter) EcoreUtil.getRegisteredAdapter(match, match);
    	}
    	
    	return matchAdapter;
    }
    
	public int getNumOfSeatsOccupied()
	{
		int numSeatsOccupied = 0;
		
		// iterate through seat list 
		EList<EObject> seats = getGame().getSeat();
						
		for(EObject obj : seats)
		{
			Seat seat = (Seat) obj;
			if(seat.getPlayer() != null)
			{
				numSeatsOccupied++;
			}
		}
		
		return numSeatsOccupied;
	}
	
	/**
	 * Allocates a given seat to a player.
	 * @param player
	 * @param seatID
	 * @returns true if allocated. False if the seat is already filled up.
	 */
	public boolean allocateSeat(Player player, long seatID)
	{
		if(player == null)
		{
			return false;
		}
		
		Seat seat = getSeatByID(seatID);
		
		synchronized (seat) 
		{
			if(seat != null && seat.getPlayer() == null)
			{
				// assign this seat to the requester
				Log.logger.debug(player.getId() + " has been assigned " + seat.getSeatId());
				
				seat.setPlayer(player);
				return true;
			}
		}
		
		return false;
	}
	
	public Player getPlayerByID(long playerID)
	{
		Game game = getGame();
		EList<EObject> gamePlayers = game.getUser();
		
		for(EObject player : gamePlayers)
		{
			Player playerObject = (Player) player;
			
			if(playerObject.getId() == playerID)
			{
				return playerObject;
			}
		}
		
		return null;
	}

	public Seat getSeatByID(long seatID)
	{
		Game game = getGame();
		
		// iterate through seat list 
		EList<EObject> seats = game.getSeat();
				
		for(EObject seat : seats)
		{
			Seat seatObject = (Seat) seat;
			if(seatObject.getSeatId() == seatID)
			{
				return seatObject;
			}
		}
		
		return null;
	}
	
	public Seat getVacantSeat()
	{
		Game game = getGame();
		
		// iterate through seat list 
		EList<EObject> seats = game.getSeat();
				
		for(EObject seat : seats)
		{
			Seat seatObject = (Seat) seat;
			if(seatObject.getPlayer() == null)
			{
				return seatObject;
			}
		}
		
		return null;
	}
	
	public Seat resetSeatForThePlayer(long playerID) 
	{
		Seat playerSeat = getSeatForPlayer(playerID); 
		if(playerSeat != null)
		{
			playerSeat.setPlayer(null);
			
			return playerSeat;
		}
		
		return null;
	}
	
	public Seat getSeatForPlayer(long playerID)
	{
		Game game = getGame();
		
		EList<EObject> seats = game.getSeat();
		
		for(EObject obj : seats)
		{
			Seat seat = (Seat) obj;
			Player player = (Player) seat.getPlayer();
			if(player.getId() == playerID)
			{
				return seat;
			}
		}
		
		return null;
	}
	
	public Player joinPlayerToRoom(long playerID)
	{
		Game game = getGame();
	    EList<EObject> gamePlayers = game.getUser();
	    
	    UserDB userDB = UserDB.getUserbyID(playerID);
		UserAccount userAccountDB = UserAccount.getUserAccountbyUserID(playerID);
       
		if(userDB != null && userAccountDB != null)
		{
			Player player = (Player)this.getModelFactory().createObject(Player.class);
			player.setChips(userAccountDB.getChips());
			player.setLevel(userAccountDB.getLevel());
			player.setXp(userAccountDB.getExperience());
			player.setName(userDB.getFirst_name());
			player.setUidSrc(userDB.getExternalid());
			player.setSource(userDB.getExtsrcid());
			player.setId(playerID);
			player.setType(PlayerType.DEFAULT);
				
			gamePlayers.add(player);
				
			return player;
		}
		
		return null;
	}
	
	public void joinPlayerToRoom(BotPlayer botPlayer, long botUserID)
	{
		Log.logger.debug(" Bot player INSTANCE inside JoinPlayerToRoom " +  botPlayer);
		
		Game game = getGame();
	    EList<EObject> gamePlayers = game.getUser();
	    
	    UserDB userDB = UserDB.getUserbyID(botUserID);
		UserAccount userAccountDB = UserAccount.getUserAccountbyUserID(botUserID);
	
		if(botPlayer != null && userDB != null && userAccountDB != null)
		{
			botPlayer.setChips(userAccountDB.getChips());
			botPlayer.setLevel(userAccountDB.getLevel());
			botPlayer.setXp(userAccountDB.getExperience());
			botPlayer.setName(userDB.getFirst_name());
			botPlayer.setUidSrc(userDB.getExternalid());
			botPlayer.setSource(userDB.getExtsrcid());
			botPlayer.setId(botUserID);
			botPlayer.setType(PlayerType.BOT);
	
			gamePlayers.add(botPlayer);
		}
	}
	
	public boolean isPlayerEligible(Player player)
	{
		Game game = getGame();
		
		return ScoreManager.GetInstance().IsEligibleForTable(player.getLevel(), (int) game.getId(), 
				game.getMaxPlayers(), game.getEntryFee().intValueExact());
	}
	
	public int getWinXP(Player player, int score, int sessionTime)
	{
		Game game = getGame();
		int buyIn = (game.getEntryFee()).intValueExact();
		int maxScore = game.getMaxScore();
		int tableMaxCapacity = game.getMaxPlayers();
	
		int xp = Math.round(ScoreManager.GetInstance().GetWinXP(buyIn, maxScore, tableMaxCapacity, score, player.getLevel(), sessionTime));
		
		return xp;
	}
	
	public int getLoseXP(Player player, int score, int sessionTime)
	{
		Game game = getGame();
		int buyIn = (game.getEntryFee()).intValueExact();
		int maxScore = game.getMaxScore();
		int tableMaxCapacity = game.getMaxPlayers();
	
		int xp = Math.round(ScoreManager.GetInstance().GetLoseXP(buyIn, maxScore, tableMaxCapacity, score, player.getLevel(), sessionTime));
		
		return xp;
	}
	
	public void removePlayer(long playerID)
	{
		// remove from the player's list
		Player player = getPlayerByID(playerID);
		getGame().getUser().remove(player);
	}
	
	public void cleanupGame()
	{
		cleanupMatch();
		
		getGame().getSeat().clear();
		getGame().getUser().clear();
	}
	
	private void cleanupMatch()
	{
		Match match = getGame().getMatch();
		MatchAdapter matchAdapter = (MatchAdapter) EcoreUtil.getRegisteredAdapter(match, match);

		matchAdapter.cleanupMatch();
		
		match = null;
	}
    
    public long getGameId()
    {
    	return ((Game)getTarget()).getId();
    }
    
    public Game getGame()
    {
    	return ((Game) getTarget());
    }
 }
