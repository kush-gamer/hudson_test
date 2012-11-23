package com.mango.games.db.masterTables;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mango.games.DBConstants.EnumValues.mCurrencyType;
import com.mango.games.db.mastertable.mCurrency;

public class Test_mCurrency 
{
	private mCurrency obj;
	@Before
	public void setUp() 
	{
		System.out.println("MCurrency Set UP");
		obj = new mCurrency(mCurrencyType.Cash);
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
	public void getObjectByID()
	{
		mCurrency obj1 = mCurrency.getmCurrencyByID(obj.getId());
		System.out.println("Object 1 : "+obj1);
		assertNotNull(obj1);
		//assertEquals(obj, obj1);
	}
	
	@Test
	public void Update()
	{
		obj.setStype(mCurrencyType.Chips);
		obj.update();
		mCurrency obj1 = mCurrency.getmCurrencyByID(obj.getId());
		assertEquals(obj1.getStype(), mCurrencyType.Chips);
	}
	
	@Test
	public void getObjectByType()
	{
		mCurrency obj1 = mCurrency.getmCurrencyByType(obj.getStype());
		assertEquals(obj, obj1);
	}
	
}
