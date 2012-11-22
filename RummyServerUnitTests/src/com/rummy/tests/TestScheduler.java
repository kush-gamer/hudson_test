package com.rummy.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mango.games.rummy.logic.common.IClientAdapter;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.utils.TableScheduler;
import com.mango.games.rummy.utils.TimeoutConstants;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import com.tests.concurrency.*;


@RunWith(ConcurrentJunitrunner.class)
@Concurrent(threads = 4)
public class TestScheduler {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
	}
	
	@Test
	public void testTimeOutInvocations() throws InterruptedException, Exception
	{
		IClientAdapter mockedAdapter = mock(IClientAdapter.class);
		
		when(mockedAdapter.handleTimeout(mock(TimedAction.class))).thenReturn(1);
		
		TableScheduler tableScheduler = new TableScheduler(mockedAdapter);
		
		//verify(mockedAdapter, times(1)).handleTimeOut(mock(TimedAction.class));
		
		tableScheduler.scheduleTimeout(2000, 11);//2 secs
		
		Thread.sleep(2020);
		
		//Verifications here.
		verify(mockedAdapter, timeout(2010)).handleTimeout(mock(TimedAction.class));
		
	}

}
