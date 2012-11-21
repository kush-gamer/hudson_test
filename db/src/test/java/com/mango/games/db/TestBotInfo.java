package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBotInfo 
{
	
	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	@Test
	public void testAvailableBot()
	{
		BotInfoDB obj = BotInfoDB.getNextAvailable();
		System.out.println("Bot Object : "+obj.toString());
		assertNotNull(obj);
		obj.Engage();
		obj.Engage();
	}
	@Test
	public void testRelease()
	{
		BotInfoDB obj = BotInfoDB.getNextAvailable();
		obj.Release();
		obj.ReleaseAll();
	}
	
}
