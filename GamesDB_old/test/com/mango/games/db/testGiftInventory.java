package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGiftInventory 
{
	@Before
	public void setUp() throws Exception 
	{
		String facebookid = "kushagra";
		String giftID = "1";
		int count = 1;
		new GiftInventory(facebookid, giftID, count);
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	@Test
	public void testGetGiftInventoryByID()
	{
		GiftInventory obj = GiftInventory.getGiftInventoryByID(1);
		System.out.println("ID Object : "+obj);
		assertNotNull(obj);
	}
	
	@Test
	public void testGetGiftInventoryByFBID_GiftID()
	{
		GiftInventory obj = GiftInventory.getGiftInventoryByFacebookId_GiftID("kushagra", "1");
		System.out.println("Gift Inventory Object : "+obj);
		assertNotNull(obj);
	}
}
