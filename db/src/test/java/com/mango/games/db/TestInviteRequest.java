package com.mango.games.db;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestInviteRequest 
{
	@Test
	public void CreateInviteRequest()
	{
		InviteRequests obj = new InviteRequests("1233456", "KushFBID", "Mango Games");
		System.out.println("Status : "+obj.getStatus());
		obj.setStatus("Accepted");
		obj.update();
		InviteRequests obj1 = InviteRequests.getInviteRequestByID(16);
		//List<InviteRequests> obj2 = InviteRequests.getInviteRequestBySenderID_InvitedID("KushFBID", "Mango Games");
		//System.out.println("Size : "+obj2.size());
		List<InviteRequests> obj3 = InviteRequests.getInviteRequestBySenderFBID_Status("KushFBID", "Pending");
		System.out.println("Size Accepted : "+obj3.size());
		//assertEquals(obj, obj1);
		System.out.println("INvite Object : "+InviteRequests.getInviteRequestByRequestID("123"));
		assertNotNull(obj1);
		
	}
}
