package com.mango.games.db;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestGameDealer 
{
	private GameDealer obj;
	@Before
	public void setUp() 
	{
		System.out.println("MCurrency Set UP");
		obj = new GameDealer(1, 2, 3, 400, 5000);
		System.out.println("Object Values : "+obj);
	}
	
	@After
	public void Clear()
	{
		System.out.println("Clear Method");
		System.out.println("Delete Object : "+obj);
		obj.delete();
	}
	
	@Test
	public void ObjectCreation()
	{
		System.out.println("ID : "+obj.getId());
		assertNotNull(obj.getId());
	}

}
