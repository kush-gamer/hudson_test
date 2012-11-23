package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUser 
{
	@Before
	public void setUp() throws Exception 
	{
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
	/***
	 * Purpose: Inserting the User into the DB.
	 * Checking whether the inserted values are matching with the Coloumns inh ths DB.
	 */
		
	
	@Test
	public void testUserByID1()
	{
		UserDB user = new UserDB("Kush", "R", "example@xyz.com", "1001", "Male", "2012.2.25");
		//System.out.println("User "+user.getId());
		UserDB user1 = UserDB.getUserbyID(user.getId());
		//System.out.println("User : "+user.toString());
		//System.out.println("User 1 : "+user1.toString());
		assertEquals(user.getId(), user1.getId());
		assertNotNull(user);
	}
	
	@Test
	public void testUserByFbId()
	{
		UserDB user = new UserDB("Kush", "R", "example@xyz.com", "1001", "Male", "2012.2.25");
		UserDB user2 = UserDB.getUserbyFBID(user.getExternalid());
		//assertEquals(user.getExtsrcid(), user2.getExtsrcid());
		assertNotNull(user);
		assertNotNull(user2);
	}
	
	@Test
	public void testAddValidUser()
	{
		UserDB user = new UserDB("Kush", "R", "example@xyz.com", "1001", "Male", "2012.2.25");
		
		//Checks whether the user record has been created.
		assertNotNull(user);
		assert(user.getId() > 0);
		
		//Checking the userID
		UserDB user2 = UserDB.getUserbyID(user.getId());
		assertNotNull(user2);
		
		//Checking the FBID
		UserDB user3 = UserDB.getUserbyFBID(user.getExternalid());
		assertNotNull(user3);
		
		assert(user.getId() == user3.getId());
		
	}
	
	
	/**
	 * Purpose: Pass null as user first name.
	 * 
	 * Result: Record should not be created in the DB
	 */
	
	
	@Test
	public void testAddNullUserName()
	{
		UserDB user = new UserDB("null", "R", "xyz.com", "1001", "Male", "2012.2.20");
		assertNotNull(user.getId()==0);
	}

	
}
