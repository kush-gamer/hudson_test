package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mango.games.db.mastertable.mGameType;

public class testmGameType 
{
	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	/**
	 * Purpose: Inserting the Specific Game into the DB.
	 * 
	 * EveryGame will be given a unique ID. 
	 * 
	 * Unique constraint has to be satisfied
	 * 
	 */
	
	@Test
	public void testGameType()
	{
		mGameType gametype = new mGameType("Teen Patti");
		assertNotNull(gametype);
	}
	
	@Test
	public void testGameType1()
	{
		mGameType gametype = new mGameType("RummY");
		assertNotNull(gametype);
	}
	
	
	@Test
	public void testGameTypeById()
	{
		mGameType gametype = new mGameType("XBOX");
		mGameType gam = mGameType.getUserbyID(gametype.getId());
		assertEquals(gametype.getId(), gam.getId());
	}
	
	@Test
	public void testGameTypeById1()
	{
		mGameType gametype1 = new mGameType("Gaming");
		mGameType gam = mGameType.getUserbyID(gametype1.getId());
		assertEquals(gametype1.getId(), gam.getId());
	}
	
}
