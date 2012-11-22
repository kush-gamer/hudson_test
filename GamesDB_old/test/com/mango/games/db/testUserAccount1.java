package com.mango.games.db;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testUserAccount1 
{
	UserDB usr = null;
	UserAccount uac = null;
	
	@Before
	public void setup()
	{
		if(UserDB.getUserbyID(403)!= null)
		{
			usr = UserDB.getUserbyID(403);
		}
		else
		{
			usr = new UserDB("Suraj", "R", "Gmail@", "1001", "Male", "2012.2.25");
			uac = UserAccount.getUserAccountbyUserID(usr.getId());
		}
		
	}
	
	
	@Test
	public void testUsr()
	{
		long id = usr.getId();
		System.out.println(id);
		UserAccount uac = UserAccount.getUserAccountbyUserID(id);
		assertNotNull(uac);
	}
	
	
	@Test
	public void testUpdate()
	{
		long id = usr.getId();
		System.out.println(id);
		UserAccount uac = UserAccount.getUserAccountbyUserID(id);
		uac.setChips(500);
		uac.setExperience(2);
		uac.setGold(5);
		uac.setInvitebonus(200);
		uac.setLevel(2);
		uac.update();
		
	}
	
}
