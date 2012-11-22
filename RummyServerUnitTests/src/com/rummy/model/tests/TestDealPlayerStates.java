package com.rummy.model.tests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mangogames.rummy.model.DealPlayer;
import com.mangogames.rummy.model.ModelFactory;
import com.mangogames.rummy.model.ModelPackage;

public class TestDealPlayerStates 
{

	ModelFactory factory = null;
	@Before
	public void setUp() throws Exception 
	{
		 ModelPackage.eINSTANCE.eClass();
		 // Retrieve the default factory singleton
		 factory = ModelFactory.eINSTANCE;
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetState()
	{
		DealPlayer playr = factory.createDealPlayer();
		
		try
		{
			playr.setState(DealPlayer.ACTIVE);
		}
		catch(Exception e)
		{
			assertEquals(e.getClass(),UnsupportedOperationException.class);
			return;
		}
		
		//assertEquals("setState should throw an exception", 1,2);
		
	}
	
	@Test
	public void testActiveState()
	{
		DealPlayer playr = factory.createDealPlayer();
		
		playr.updateState(DealPlayer.ACTIVE);
		
		assertTrue(playr.isPlaying());
		assertFalse(playr.isDropped());
		assertFalse(playr.isDoneWithShow());
		assertFalse(playr.hasLostTheGame());
		assertFalse(playr.hasPickedACard());

	}
	
	@Test
	public void testDroppedState()
	{
		DealPlayer playr = factory.createDealPlayer();
		
		playr.updateState(DealPlayer.DROPPED);
		
		assertFalse(playr.isPlaying());
		assertTrue(playr.isDropped());
		assertFalse(playr.isDoneWithShow());
		assertFalse(playr.hasLostTheGame());
		assertFalse(playr.hasPickedACard());
	}

	@Test
	public void testMultiState1()
	{
		DealPlayer playr = factory.createDealPlayer();
		
		playr.updateState(DealPlayer.ACTIVE);
		playr.updateState(DealPlayer.DROPPED);
		playr.updateState(DealPlayer.LOST_GAME);
		
		assertFalse(playr.isPlaying());
		assertFalse(playr.isDropped());
		assertFalse(playr.isDoneWithShow());
		assertTrue(playr.hasLostTheGame());
		assertFalse(playr.hasPickedACard());
	}
	
	@Test
	public void testPickedCard()
	{
		DealPlayer playr = factory.createDealPlayer();
		
		playr.updateState(DealPlayer.ACTIVE);
		playr.updateState(DealPlayer.PICKED);
		playr.updateState(DealPlayer.DROPPED);
		
		assertFalse(playr.isPlaying());
		assertTrue(playr.isDropped());
		assertFalse(playr.isDoneWithShow());
		assertFalse(playr.hasLostTheGame());
		assertTrue(playr.hasPickedACard());
	}
	
	@Test 
	public void testLostGameAfterPick()
	{
DealPlayer playr = factory.createDealPlayer();
		
		playr.updateState(DealPlayer.ACTIVE);
		playr.updateState(DealPlayer.PICKED);
		playr.updateState(DealPlayer.DROPPED);
		playr.updateState(DealPlayer.LOST_GAME);
		
		assertFalse(playr.isPlaying());
		assertFalse(playr.isDropped());
		assertFalse(playr.isDoneWithShow());
		assertTrue(playr.hasLostTheGame());
		assertTrue(playr.hasPickedACard());
	}
}
