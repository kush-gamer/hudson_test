package com.mango.games.db.masterTables;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.mango.games.DBConstants.EnumValues.mTransactiontype;
import com.mango.games.db.mastertable.mTransactionType;

public class TestMTransactionType 
{
	private mTransactionType obj;
	@Before
	public void setUp() 
	{
		System.out.println("MCurrency Set UP");
		obj = new mTransactionType("test", mTransactiontype.Credit);
		System.out.println("Object Values : "+obj);
	}
	
	@After
	public void Clear()
	{
		System.out.println("Clear Method");
		System.out.println("Delete Object : "+obj);
		//obj.delete();
	}
	
	@Test
	public void ObjectCreation()
	{
		assertNotNull(obj);
	}
	
	@Test
	public void ObjectByID()
	{
		mTransactionType obj2 = mTransactionType.getmTransactionByID(obj.getId());
		//mTransactionType obj3 = new mTransactionType();
		System.out.println("OBJ2 : "+obj2.toString());
		System.out.println("OBj1 : "+obj.toString());
		assertTrue(obj2.getId() == obj.getId());
	}
	

}
