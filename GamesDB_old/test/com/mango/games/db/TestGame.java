package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGame 
{

	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	/** Purpose: Game Starting. 
	 * 
	 * With the current Game, Start Date and End Date.
	 * 
	 * Result: Game ID, GameDefinitionID, StartTime and EndTime
	 * 		     inserts into the DB.
	 */
	
	@Test
	public void testGame1()
	{
		Game game1 = new Game(1,1);
		game1.update();
		assertNotNull(game1);
		
	}
	
	@Test
	public void testGameById()
	{
		Game game2 = new Game(2,2);
		System.out.println("Game 2 Object : "+game2);
		Game gam = Game.getGameById(game2.getId());
		assertNotNull(gam);
	}
}
