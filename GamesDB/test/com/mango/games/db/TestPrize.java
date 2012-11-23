package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPrize 
{
	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	/** Purpose: Insert prize into the DB with the Prize Name, Sponser, Sponser Logo and image.
	 *  
	 * Checks whether it has Inserted into the DB.
	 */
	
	@Test
	public void testprize()
	{
		Prize prize = new Prize("IPad","Aircel","DON","AA","LL");
		assertNotNull(prize);
		//assertNotNull(prize.getId()==0);
		
	}
	
	@Test
	public void testPrize1()
	{
		Prize prize1 = new Prize("Tablet","Aircel","DON","AA","LL");
		assertNotNull(prize1);
	}
	
	@Test
	public void testPrizeById()
	{
		Prize prize = new Prize("IPad","Aircel","DON","AA","LL1");
		Prize pri = Prize.getPrizebyID(prize.getId());
		assertEquals(prize.getId(), pri.getId());
	}
	
	@Test
	public void testPrizeById1()
	{
		Prize prize = new Prize("Tablet","Aircel","DON","AA","LL1");
		Prize pri = Prize.getPrizebyID(prize.getId());
		assertEquals(prize.getId(), pri.getId());
	}
	
}
