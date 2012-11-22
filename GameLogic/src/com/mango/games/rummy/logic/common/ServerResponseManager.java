package com.mango.games.rummy.logic.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mango.games.rummy.utils.RecipientType;
import com.mango.games.rummy.utils.UserHelper;

import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.Deal;
import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.Game;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.Match;
import com.mangogames.rummy.model.MatchPlayer;
import com.mangogames.rummy.model.OpenDeck;
import com.mangogames.rummy.model.Player;
import com.mangogames.rummy.model.Seat;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class ServerResponseManager
{
	SmartFoxServer _sfsObject = SmartFoxServer.getInstance();
	SFSExtension _roomExt = null;
	
	Room _currentRoom = null;
	
	Game _game = null;
		
	public ServerResponseManager(Room room) 
	{
		if(room != null)
		{
			_currentRoom = room;
			_roomExt = (SFSExtension) _sfsObject.getExtensionManager().getRoomExtension(_currentRoom);
		}
	}
	
	public void setGame(Game game)
	{
		_game = game;
	}

	public void sendOpponentInfo(long playerID, EList<EObject> seats)
	{
		ISFSArray opponents = new SFSArray();

		for(EObject seat : seats) // iterate through seat list
		{
			Seat seatObject = (Seat) seat;
			
			Player playerObject = (Player) seatObject.getPlayer();
			
			String opponentID = playerObject.getUidSrc();
			
			//TODO: handle reconnect
			
			ISFSObject opponent = new SFSObject();
			
			opponent.putUtfString("FacebookID", opponentID); 
			opponent.putInt("Level", playerObject.getLevel());
			opponent.putInt("Experience", playerObject.getXp());
			opponent.putInt("Chips", playerObject.getChips());
			
			//TODO: DB get opponent current gift, category/giftname from memcache
			
			//opponent.putUtfString("GiftID", info.GetLastFromInventory());
			
			//String giftsData = info.GetLastFromFInventory();
			//String[] dataArray = giftsData.split("/");			
			//opponent.putUtfString("CategoryName", dataArray[0]);
			//opponent.putUtfString("GiftName", dataArray[1]);
			
			// games won, games lost for the opponent
			//opponent.putInt("GamesWon", info.GamesWon);
			//opponent.putInt("GamesLost", info.GamesLost);
			
			opponent.putInt("SeatNo", seatObject.getSeatId());
			
			opponents.addSFSObject(opponent);
		}
		
		ISFSObject response = new SFSObject();
		response.putSFSArray("Opponents", opponents);
		
		_roomExt.send("OpponentInfo", response, getRecipients(RecipientType.USER, playerID));
	}
	
	public void sendNotEligibleForXP(long recipientID)
	{
		_roomExt.send("NotEligibleForXp", null, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendFailedToAddPlayer(long recipientID)
	{
		_roomExt.send("FailedToAdd", null, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendReady()
	{
		Deal deal = _game.getMatch().getDeal();
		
		ISFSObject sfsData = new SFSObject();

		getTableData(deal, sfsData);
		
		// send "GameStarted" to spectators
		_roomExt.send("GameStarted", sfsData, getRecipients(RecipientType.SPECTATORS, 0));
		
		// send cards to individuals
		ISFSArray sfsPlayerCards = new SFSArray();
		EList<EObject> dealPlayers = deal.getDealplayer();
		
		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer) obj;
			HandCards playerHand = dealPlayer.getHandcards();
			
			EList<EObject> groups = playerHand.getGroups();
			CardContainer group = (CardContainer) groups.get(0);

			EList<EObject> cards = group.getCard();
			for(EObject cardObj : cards)
			{
				Card card = (Card) cardObj;
				
				SFSObject sfsCard = new SFSObject();
				sfsCard.putInt("Rank", card.getRank());
				sfsCard.putInt("Suit", card.getSuit());
				
				sfsPlayerCards.addSFSObject(sfsCard);
			}
			sfsData.putSFSArray("Cards", sfsPlayerCards);
			
			_roomExt.send("Ready", sfsData, getRecipients(RecipientType.USER, dealPlayer.getId()));
		}
	}
	
	public void sendGetSetGo()
	{
		_roomExt.send("GetSetGo", null, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	private void getTableData(Deal deal, ISFSObject sfsData)
	{
		int whoseTurn = deal.getCurrentTurn();
		
		sfsData.putInt("WhoseTurn", whoseTurn);

		Card openJoker = (Card) deal.getJoker();
		ISFSObject sfsOpenJoker = new SFSObject();
		sfsOpenJoker.putInt("Rank", openJoker.getRank());
		sfsOpenJoker.putInt("Suit", openJoker.getSuit());
		
		sfsData.putSFSObject("OpenJoker", sfsOpenJoker);
		
		OpenDeck openDeck = (OpenDeck) deal.getOpendeck();
		Card firstDiscard = (Card) openDeck.getCard().get(0);
		
		ISFSObject sfsFirstDiscard = new SFSObject();
		sfsFirstDiscard.putInt("Rank", firstDiscard.getRank());
		sfsFirstDiscard.putInt("Suit", firstDiscard.getSuit());
		
		sfsData.putSFSObject("FirstCard", sfsFirstDiscard);
		
		int roundNumber = deal.getDealNumber();
		
		sfsData.putInt("Round", roundNumber);
	}
	
	public void sendTableBet(int potValue)
	{
		ISFSObject tableBet = new SFSObject();
		tableBet.putInt("PotValue", potValue);

		_roomExt.send("TableBet", tableBet, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendPickError(long recipientID)
	{
		_roomExt.send("PickError", null, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendCheatCard(long recipientID)
	{
		_roomExt.send("CheatDetected", null, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendDiscardError(long recipientID)
	{
		_roomExt.send("DiscardError", null, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendNewCardReceived(long recipientID, int pickedFrom, Card cardPicked)
	{
		ISFSObject data = new SFSObject();
		
		data.putUtfString("WhoPicked", Long.toString(recipientID));
		data.putInt("PickedFrom", pickedFrom);
		
		ISFSObject pickedCardObj = new SFSObject();
		pickedCardObj.putInt("Rank", cardPicked.getRank());
		pickedCardObj.putInt("Suit", cardPicked.getSuit());
		
		data.putSFSObject("CardPicked", pickedCardObj);
		
		_roomExt.send("NewCardReceived", data, getRecipients(RecipientType.USER, recipientID));
	}
	
	public void sendDeckOver()
	{
		_roomExt.send("DeckOver", null, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendPlayerPickedCard(long recipientID, int pickedFrom, Card cardPicked, Card lastDiscard)
	{
		ISFSObject data = new SFSObject();
		
		data.putUtfString("WhoPicked", Long.toString(recipientID));
		data.putInt("PickedFrom", pickedFrom);
		
		ISFSObject lastDiscardObj = new SFSObject();
		
		if(lastDiscard != null)
		{
			lastDiscardObj.putInt("Rank", lastDiscard.getRank());
			lastDiscardObj.putInt("Suit", lastDiscard.getSuit());
		}
		else
		{
			lastDiscardObj.putInt("Rank", -1);
			lastDiscardObj.putInt("Suit", -1);
		}
		
		data.putSFSObject("LastCardOnDiscard", lastDiscardObj);
		
		ISFSObject cardPickedObj = new SFSObject();
		cardPickedObj.putInt("Rank", cardPicked.getRank());
		cardPickedObj.putInt("Suit", cardPicked.getSuit());
		
		data.putSFSObject("CardPicked", cardPickedObj);
		
		_roomExt.send("PlayerPickedCard", data, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendShuffleOpenDeck()
	{
		_roomExt.send("ShuffleDiscard", null, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendTurnOver(Card discardedCard, int nextTurn, boolean wasTurnMissed)
	{
		ISFSObject response = new SFSObject();
		
		ISFSObject discardedCardObj = new SFSObject();
		
		discardedCardObj.putInt("Rank", discardedCard.getRank());
		discardedCardObj.putInt("Suit", discardedCard.getSuit());
		
		response.putSFSObject("DiscardedCard", discardedCardObj);
		response.putInt("WhoseTurn", nextTurn);
		response.putBool("WasTurnMissed", wasTurnMissed);
		
		_roomExt.send("TurnOver", null, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendShowInitiated(long playerID)
	{
		ISFSObject response = new SFSObject();
		response.putInt("SeatNo", getPlayerSeat(playerID));

		_roomExt.send("ShowInitiated", null, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendShowInitiatedError(long playerID)
	{
		_roomExt.send("ShowInitiatedError", null, getRecipients(RecipientType.USER, playerID));
	}
	
	public void sendShowInitTimeOut(long playerID)
	{
		_roomExt.send("ReadyForEvaluation", null, getRecipients(RecipientType.USER, playerID));
	}
	
	public void sendShowFailed(long playerID)
	{
		ISFSObject response = new SFSObject();
		response.putInt("SeatNo", getPlayerSeat(playerID));
	
		_roomExt.send("ShowFailed", response, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendValidShow(long playerID, Card discardedCard)
	{
		ISFSObject response =  new SFSObject();		
		response.putInt("SeatNo", getPlayerSeat(playerID));
		
		ISFSObject sfsDiscardedCard = new SFSObject();
		sfsDiscardedCard.putInt("Rank", discardedCard.getRank());
		sfsDiscardedCard.putInt("Suit", discardedCard.getSuit());
		
		response.putSFSObject("ShowCard", sfsDiscardedCard);
		
		_roomExt.send("GameOverShowCards", response, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendScorecard(long winnerID, boolean isGameOver)
	{
		Deal deal = _game.getMatch().getDeal();		
		
		ISFSObject gameOverData = new SFSObject();		
		
		EList<EObject> dealPlayers = deal.getDealplayer();
		
		ISFSArray playerSlotsScores = new SFSArray();
		ISFSArray kickedOutPlayers = new SFSArray();
 		
		for(EObject obj : dealPlayers)
		{
			DealPlayer dealPlayer = (DealPlayer)obj;

			playerSlotsScores.addSFSObject(getPlayerScoreboardData(dealPlayer, isGameOver));
			
			if(dealPlayer.hasLostTheGame())
			{
				kickedOutPlayers.addInt(getPlayerSeat(dealPlayer.getId()));
			}
		}
		
		gameOverData.putSFSArray("ScoreBoardData", playerSlotsScores);
		
		if(isGameOver)
		{
			gameOverData.putInt("Winner", getPlayerSeat(winnerID));
		}
		
		if(kickedOutPlayers.size() > 0)
		{
			gameOverData.putSFSArray("KickedOutPlayers", kickedOutPlayers);
		}
		
		_roomExt.send("ShowScoreCard", gameOverData, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendDefaultWinner(long playerID)
	{
		ISFSObject response =  new SFSObject();		
		response.putInt("SeatNo", getPlayerSeat(playerID));

		_roomExt.send("DefaultWinner", response, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendPlayerDisconnected(long playerID, int seatID)
	{
		
	}
	
	public void sendPlayerHasQuitToLobby(long playerID)
	{
		
	}
	
	public void sendAchievement(int achievementID, long playerID)
	{
		ISFSObject achievement = new SFSObject();
		achievement.putInt("AchievementID", achievementID);
		
		_roomExt.send("NewAchievement", achievement, getRecipients(RecipientType.USER, playerID));
	}
	
	private MatchPlayer getMatchPlayer(long playerID)
	{
		Match match = _game.getMatch();
		IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(match, match);
		MatchAdapter matchAdapter = (MatchAdapter) adapter;
		
		MatchPlayer matchPlayer = matchAdapter.getMatchPlayerByID(playerID);
		return matchPlayer;		
	}
		
	private int getPlayerSeat(long playerID)
	{
		IClientAdapter adapter = (IClientAdapter) EcoreUtil.getRegisteredAdapter(_game, _game);
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) adapter;
		
		return gameAdapter.getSeatForPlayer(playerID).getSeatId();
	}
	
	private ISFSObject getPlayerScoreboardData(DealPlayer dealPlayer, boolean isGameOver)
	{
		ISFSObject result = new SFSObject();
		
		MatchPlayer matchPlayer = getMatchPlayer(dealPlayer.getId());
	
		result.putInt("CurrentScore", dealPlayer.getScore().getScore());
		result.putInt("TotalScore", matchPlayer.getTotalScore());
		
		IClientAdapter adpater2 = (IClientAdapter) EcoreUtil.getRegisteredAdapter(_game, _game);
		AbstractGameAdapter gameAdapter = (AbstractGameAdapter) adpater2;
		
		// TODO: sessionTime
		int sessionTime = 0;
		
		if(dealPlayer.isWinner() == true)
		{
			if(isGameOver)
			{
				result.putInt("ExperienceEarned", matchPlayer.getXp());
				result.putInt("ChipsEarned", _game.getPotValue());
			}
			
			result.putBool("IsWinner", true);
		}
		else
		{
			if(isGameOver)
			{
				result.putInt("ExperienceEarned", matchPlayer.getXp());
			}
			
			result.putBool("IsWinner", false);
		}
			
		result.putSFSArray("Slots", getPlayerSlots(dealPlayer));
		
		return result;
	}
	
	private ISFSArray getPlayerSlots(DealPlayer player)
	{
		ISFSArray playerSlots = new SFSArray();
		
		EList<EObject> playerHand = player.getHandcards().getGroups();
		
		int id = 1;
		for(EObject obj : playerHand)
		{
			ISFSObject slot = new SFSObject();
			slot.putInt("SlotID", id);
			
			ISFSArray sequence = new SFSArray();
			
			CardContainer group = (CardContainer) obj;
			
			EList<EObject> cards = group.getCard();
			
			for(EObject cardObj : cards)
			{
				Card card = (Card) cardObj;
				
				ISFSObject sfsCard = new SFSObject();
				sfsCard.putInt("Suit", card.getSuit());
				sfsCard.putInt("Rank", card.getRank());
				
				sequence.addSFSObject(sfsCard);
			}
			
			slot.putSFSArray("Sequence", sequence);
			playerSlots.addSFSObject(slot);
			
			id++;
		}
		
		
		return playerSlots;
	}
	
	public void sendGameOverShowCards(long playerID, int seatID, Card discardedCard)
	{
		ISFSObject response = new SFSObject();
		response.putInt("SeatNo", seatID);
		
		ISFSObject discardedCardObj = new SFSObject();
		discardedCardObj.putInt("Suit", discardedCard.getSuit());
		discardedCardObj.putInt("Rank", discardedCard.getRank());
		
		_roomExt.send("GameOverShowCards", discardedCardObj, getRecipients(RecipientType.ALL_IN_ROOM, 0));
	}
	
	public void sendLevelUpBrag(int newLevel, long playerID)
	{
		ISFSObject response = new SFSObject();
		
		response.putInt("LevelNumber", newLevel);
		
		ISFSArray levelUnlocks = new SFSArray();
		
		String unlock1 = "";
		String unlock2 = "";
		ISFSObject unlockObj1 = new SFSObject();
		ISFSObject unlockObj2 = new SFSObject();
		
		switch(newLevel)
		{
		case 3: 
			unlock1 = "Single Round 3 Players";
			unlock2 = "100 Bet Amount";

			unlockObj1.putUtfString("Unlock", unlock1);
			unlockObj2.putUtfString("Unlock", unlock2);
			
			levelUnlocks.addSFSObject(unlockObj1);
			levelUnlocks.addSFSObject(unlockObj2);
			
			break;
		case 5: 
			unlock1 = "101 2 Players";
			unlock2 = "500 Bet Amount";
			
			unlockObj1.putUtfString("Unlock", unlock1);
			unlockObj2.putUtfString("Unlock", unlock2);
			
			levelUnlocks.addSFSObject(unlockObj1);
			levelUnlocks.addSFSObject(unlockObj2);
			
			break;
		case 6: 
			unlock1 = "101 3 Players";
			unlock2 = "201 2 Players";
			
			unlockObj1.putUtfString("Unlock", unlock1);
			unlockObj2.putUtfString("Unlock", unlock2);
			
			levelUnlocks.addSFSObject(unlockObj1);
			levelUnlocks.addSFSObject(unlockObj2);
			
			break;
		}
		
		response.putSFSArray("Unlocks", levelUnlocks);
		//TODO: client has to fill in BragText
		
		_roomExt.send("LevelUp", response, getRecipients(RecipientType.USER, playerID));
	}
	
	private List<User> getRecipients(long recipientType, long recipientID)
	{
		List<User> recipients = new ArrayList<User>(); 
		
		if(recipientID != 0 && recipientType == RecipientType.USER)
		{
			User recipient = UserHelper.GetUserByName(_currentRoom, recipientID);
			recipients.add(recipient);
		}
		else if(recipientID != 0 && recipientType == RecipientType.ALL_EXCEPT_USER)
		{
			recipients = UserHelper.GetUsersExceptUser(_currentRoom, recipientID);
		}
		else if(recipientType == RecipientType.ALL_PLAYERS_EXCEPT_USER)
		{
			recipients = UserHelper.GetPlayersExceptPlayer(_currentRoom, recipientID);
		}
		else if(recipientType == RecipientType.ALL_IN_ROOM)
		{
			recipients = UserHelper.GetUsersList(_currentRoom);
		}
		else if(recipientType == RecipientType.ALL_PLAYERS)
		{
			recipients = UserHelper.GetPlayersList(_currentRoom);
		}
		else if(recipientType == RecipientType.SPECTATORS)
		{
			recipients = UserHelper.GetSpectatorList(_currentRoom);
		}
		
		return recipients;
	}
}
