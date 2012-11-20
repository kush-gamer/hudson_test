package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGamePlayer 
{
	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	/** Purpose: Creating the Gameplayer.
	 * With gameId and User_Id matching with the Game and User table. 
	 * 
	 * Checking whether it has properly Inserted in the DB.
	 * 
	 */
	
	@Test
	public void testgameplayer()
	{
		GamePlayer gameplayer = new GamePlayer(1,35,1);
		assertNotNull(gameplayer);
	}
	
	@Test
	public void testgameplaye2r()
	{
		GamePlayer gameplayer = new GamePlayer(2,36,2);
		assertNotNull(gameplayer);
		
	}
	
}
