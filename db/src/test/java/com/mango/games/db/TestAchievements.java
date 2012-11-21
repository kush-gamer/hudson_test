package com.mango.games.db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAchievements {
	Achievements obj = null;
	@Before
	public void setUp() throws Exception 
	{
		//assertTrue(true);
		obj = new Achievements(1, "Kushagra", 1, 1);
	}
		
	@After
	public void tearDown() throws Exception 
	{
		//System.out.println(obj.toString());
		//obj.delete();
	}
	
	@Test
	public void testObjectCreation()
	{
		//assertTrue(true);
		assertNotNull(obj);
	}
	/*
	@Test
	public void testGetObjectByID()
	{
		
		assertTrue(true);
		//Achievements obj2 = Achievements.getAchievementByID(obj.getID());
		//System.out.println("Object2 : "+obj2.toString());
		//assertNotNull(obj2);
	}
	@Test
	public void testGetPlayerAchievements()
	{
		//boolean obj3 = Achievements.IsPlayerAchievement(obj.getFacebookID(), obj.getAchievementID());
		//System.out.println("Obj 3 values : "+obj3);
		//assertTrue(obj3);
		assertTrue(true);
	}*/
	
}
