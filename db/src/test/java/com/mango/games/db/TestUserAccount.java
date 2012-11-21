package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserAccount 
{
	UserDB        usr = null;
	UserAccount uac = null;
	
	@Before
	public void setUp() throws Exception 
	{
		//If User with id=50 exists, then don't create User. Else create User.
	   // uac = UserAccount.getUserAccountbyID(50); 
		usr = UserDB.getUserbyID(404);
		if( usr == null )
		{
			usr = new UserDB("Suraj", "R", "example@xyz.com", "1001", "Male", "2012.2.25");
			uac = UserAccount.getUserAccountbyUserID(usr.getId());
		}
	
	}
		
	@After
	public void tearDown() throws Exception 
	{
		
	}
		
	@Test
	public void testCreateUserAccount()
	{
		/**
		 * Creating a new user should automatically create a new UserAccount. In this test
		 * we check if after creating a new User, a corresponding UserAccount has been created
		 */
		UserDB user = new UserDB("Suraj", "R", "@@@", "1001", "Male", "2012.2.25");
		System.out.println("User : "+user);
		UserAccount userAc = UserAccount.getUserAccountbyUserID(user.getId());
		System.out.println("User Account : "+userAc);
		assertNotNull(userAc);
		
	}
	
	@Test
	public void testUpdate()
	{
		/**
		 *  Updating the UserAccount with the values. It can be called anywhere from the application.
		 */
		UserDB user = new UserDB("Suraj", "R", "example@xyz.com", "1001", "Male", "2012.2.25");
		long id = user.getId();
		//User us = user.getUserbyID(id);
		UserAccount userAc = UserAccount.getUserAccountbyUserID(user.getId());
		assertNotNull(userAc);
		userAc.setChips(51);
		userAc.setGold(1);
		userAc.setExperience(1);
		userAc.setInvitebonus(11);
		userAc.update();
		
	}
	
	@Test
	public void testUpdate2()
	{
		uac = UserAccount.getUserAccountbyUserID(usr.getId());
		uac.setChips(5);
		uac.setGold(1);
		uac.setExperience(1);
		uac.setInvitebonus(1);
		uac.update();
		assertNotNull(uac);
		
	}
	
	/*@Test
	public void testUserAccByUserId()
	{
		
		long userid = usr.getId();
		UserAccount userAc = UserAccount.getUserAccountbyID(userid);
		assertNull(userAc);
	}
	
	
	
	/*@Test
	public void testAddGold()
	{
		//Add 1 Gold
		UserAccount.addGoldById(1, usr.getId());
		//Get the Gold and Check
		UserAccount uacChanged = UserAccount.getUserAccountbyID(usr.getId());
		
		assertEquals(uac.getChips(), uacChanged.getChips());
		
	}
	
	@Test
	public void testAddChips()
	{	
		//2. Add 20 chips
		UserAccount.addChipsById(20, usr.getId());
		//3. Get the chips again
		
		UserAccount uacChanged = UserAccount.getUserAccountbyID(usr.getId());
		
		//4. Check if chips in step-1 + 20 = chips in step-3
		assertEquals(uac.getGold(), uacChanged.getGold());
	}
	
	@Test
	public void testAddExperience()
	{
		UserAccount.setExperienceById(1, usr.getId());
		UserAccount uacChanged = UserAccount.getUserAccountbyID(usr.getId());
		assertEquals(uac.getExperience(), uacChanged.getExperience());
	}
	
	@Test
	public void testAddInviteBonus()
	{
		UserAccount.addInviteBonusById(100,usr.getId());
		UserAccount uacChanged = UserAccount.getUserAccountbyID(usr.getId());
		assertEquals(uac.getInvitebonus(), uacChanged.getInvitebonus());
	}
	
	@Test
	public void testSetLevel()
	{
		UserAccount.setLevelById(2, usr.getId());
		UserAccount uacChanged = UserAccount.getUserAccountbyID(usr.getId());
		assertEquals(uac.getLevel(), uacChanged.getLevel());
	}*/
	
	
}
