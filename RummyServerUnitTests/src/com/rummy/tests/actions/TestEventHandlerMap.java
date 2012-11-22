package com.rummy.tests.actions;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mango.games.rummy.logic.actions.EventHandlerMap;
import com.mango.games.rummy.utils.ActionConstants;


public class TestEventHandlerMap 
{
	private EventHandlerMap evHandlerMap;
	
	@Before
	public void setUp() throws Exception 
	{
		evHandlerMap = EventHandlerMap.getEventHandlerMap();
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testNoMethod() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage("SomeDummyMessage");
		assertNull(methd);
	}
	
	@Test
	public void testJoinMe() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.JoinMe);
		assertNotNull(methd);
	}
	
	@Test
	public void testCardDiscarded() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.CardDiscarded);
		assertNotNull(methd);
	}
	
	@Test
	public void testCardPicked() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.CardPicked);
		assertNotNull(methd);
	}
	
	@Test
	public void testDropMe() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.DropMe);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetScoreCard() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetScoreCard);
		assertNotNull(methd);
	}
	
	@Test
	public void testQuitToLobby() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.QuitToLobby);
		assertNotNull(methd);
	}
	
	@Test
	public void testSeatTaken() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.SeatTaken);
		assertNotNull(methd);
	}
	
	@Test
	public void testShowCards() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.ShowCards);
		assertNotNull(methd);
	}
	
	@Test
	public void testShowCardsInit() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.ShowCardsInit);
		assertNotNull(methd);
	}
	
	@Test
	public void testPickCard() 
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.CardPicked);
		assertNotNull(methd);
	}
	/*
	@Test
	public void testInvitedFriends()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.InvitedFriends);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetAppUsers()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetAppUsers);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetLeaderBoard()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetLeaderBoard);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetKingOfTheDay()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetKingOfTheDay);
		assertNotNull(methd);
	}
	
	@Test
	public void testPlayerUpdatedGift()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.PlayerUpdatedGift);
		assertNotNull(methd);
	}
	
	@Test
	public void testConvertGoldToChips()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.ConvertGoldToChips);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetMyGift()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetMyGift);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetMygiftInventory()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetMygiftInventory);
		assertNotNull(methd);
	}
	
	@Test
	public void testSendGift()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.SendGift);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetUnlockedGifts()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetUnlockedGifts);
		assertNotNull(methd);
	}
	
	@Test
	public void testUpdateInventor()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.UpdateInventor);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetGiftsShop()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetGiftsShop);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetPlayerGold()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetPlayerGold);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetCreditScreen()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetCreditScreen);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetPlayerStats()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetPlayerStats);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetContestLeaders()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetContestLeaders);
		assertNotNull(methd);
	}
	
	@Test
	public void testSaveInviteRequest()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.SaveInviteRequest);
		assertNotNull(methd);
	}
	
	@Test
	public void testUpdateRequest()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.UpdateRequest);
		assertNotNull(methd);
	}
	
	@Test
	public void testGetMyFriends()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.GetMyFriends);
		assertNotNull(methd);
	}
	
	@Test
	public void testAddDefaultFriends()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.AddDefaultFriends);
		assertNotNull(methd);
	}
	
	@Test
	public void testHasPlayerLikedFanPage()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.HasPlayerLikedFanPage);
		assertNotNull(methd);
	}
	
	@Test
	public void testAddAsBuddy()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.AddAsBuddy);
		assertNotNull(methd);
	}
	
	@Test
	public void testInviteToPlay()
	{
		String methd = evHandlerMap.GetMethodNameFromMessage(ActionConstants.InviteToPlay);
		assertNotNull(methd);
	}*/
}
