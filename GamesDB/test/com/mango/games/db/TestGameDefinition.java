package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mango.games.db.mastertable.mGameDefinition;

public class TestGameDefinition 
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
	 * Purpose: Defining the game with the Min/Max players along with the typeID, format ID.
	 * Checking whether it has properly Inserted.
	 */
	
	@Test
	public void testGameDef()
	{
		mGameDefinition gamedef = new mGameDefinition(23, 1, 5, 10, 35);
		assertNotNull(gamedef);
	}
	
	@Test
	public void testGameDefList()
	{
		mGameDefinition gamedef = new mGameDefinition(23, 2, 5, 10, 35);
		assertNotNull(gamedef);
		assertNotNull(mGameDefinition.getAllDefinitions());
	}
	
	@Test
	public void testGameDefbyId()
	{
		mGameDefinition gamedef = new mGameDefinition(24, 2, 5, 10, 35);
		mGameDefinition gamedef1 = mGameDefinition.getGameDefbyID(gamedef.getId());
		assertEquals(gamedef.getId(), gamedef1.getId());
	}
	
}
