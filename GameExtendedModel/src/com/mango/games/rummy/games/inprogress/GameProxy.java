package com.mango.games.rummy.games.inprogress;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mango.games.rummy.bot.BotPlayerAdapter;
import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.MatchAdapter;
import com.mango.games.rummy.model.ModelCreationFactory;
import com.mango.games.rummy.utils.ScoreManager;
import com.mango.games.rummy.utils.di.InjectionModule;
import com.mangogames.rummy.model.BotPlayer;
import com.mangogames.rummy.model.DocumentRoot;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.PointsGame;
import com.mangogames.rummy.model.Seat;
import com.mangogames.rummy.model.SyndicateGame;

/**
 * GameProxy serves as a proxy for the real Gameobject, which holds the game-state and the model
 * hierarchy. The proxy is a representation of GameObject for SmartFoxServer. 
 * 
 * The reason to seperate the actual GameObject representation from SFX interfaces is to have
 * the ability to run Games on independent servers (outside SFX). SFX will just manage the communication
 * between clients and Game Servers.
 * 
 * Helps us scale better with Distributed servers and game logic. 
 * This also helps us scale well with commodity servers, as SFX licenses are expensive.
 * 
 * GameProxies are registered as extensions in SFS
 * 
 * @author Sanjeev
 *
 */
@SuppressWarnings("unused")
public class GameProxy
{
   /** A game is represented by a unique identifier in SFX and our Database. 
    * Currently the identifier is created inside SFX, but at some point the identifier should be 
    * generated in our DB, and game creation should be triggered from that event. */
	
   private Long _gameId;
   private Game _game;
   
   @Inject
   private ModelCreationFactory _modelCreationFactory;
   
   
   
   /**
    * In the first version, it is assumed that the GameProxy and the GameAdapter are co-located
    * on the same server. This code will change when the GameAdapter is moved to different server(s).
    * 
    * THIS WILL CHANGE IN FUTURE, WHEN GAME LOGIC IS EXECUTED ON INDEPENDENT SERVERS (not SFX)
    */
   public GameProxy()
   {   
	   //ModelCreationFactory is created by Guice Injection. Do not create it using New.
   }
   
   /**
    * Create a new Game, with the given parameters. This is slightly Kludgy, as the parameters are
    * hard-coded.
    * @TODO - create new game should be further parameterised.
    *  
    * @param id
    * @param maxSeats
    * @param prizePool
    * @param gameType
    */
   public void createNewGame(long id, int maxSeats, double prizePool, int gameType)
   {
   	   Long lId = new Long(id);
   	   
   	   DocumentRoot root = _modelCreationFactory.getDocumentRoot();
   	   
   	   _game = (SyndicateGame)_modelCreationFactory.createObject(SyndicateGame.class);
       _game.setMaxPlayers(maxSeats);
       _game.setId(id);
       _game.setEntryFee(new BigDecimal(prizePool));
       _game.setType(gameType);
       
       if( gameType == 101 || gameType == 201 || gameType == 301 )
       {
    	   _game.setMaxScore(gameType);
       }
       
       int betAmount = (int) prizePool;
       float rake = ScoreManager.GetInstance().GetRake(betAmount);
      
       
       _game.setRake(rake);
        
       initializeGameSeats(_game);
       
       root.setGame(_game);
       
       //Create and initialize the client adapter for the Game.
       //The client adapter will in turn set the StateMachine
       IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(_game, _game);
       adapter.setModelCreationFactory(_modelCreationFactory);
   }   
   
   public Long getGameId()
   {
	   return _gameId;
   }
   
   public IClientAdapter getClientAdapter()
   {
       IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(_game, _game);
       
       return adapter;
   }
   
	private void initializeGameSeats(Game game)
	{
		// get max players in the game
		int maxSeats = game.getMaxPlayers();
		
		EList<EObject> seats = game.getSeat();
		
		for(int i=0; i<maxSeats; i++)
		{
			Seat seat = (Seat) _modelCreationFactory.createObject(Seat.class);
			seat.setSeatId(i);
			
			seats.add(seat);
		}
	}
}
