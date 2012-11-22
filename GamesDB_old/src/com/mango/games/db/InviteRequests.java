package com.mango.games.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class InviteRequests 
{
	private int InvitationID;
	private String RequestID;
	private String SenderFBID;
	private String InvitedFBID;
	private String Status;
	private String DateOfInvite;
	
	
	public InviteRequests()
	{
		
	}
	public InviteRequests(String RequestID , String SenderFBID , String InvitedFBID)
	{
		this.RequestID = RequestID;
		this.SenderFBID = SenderFBID;
		this.InvitedFBID = InvitedFBID;
		//this.Status = "Pending";
		String query = String.format(UserSQL.sqlCreateInviteRequest, this.RequestID , this.SenderFBID , this.InvitedFBID);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"InvitationID"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					this.InvitationID = (result_set.getInt(1));
				}
		}
		catch (SQLException e) 
		{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
		}
	}
	
	public static InviteRequests getInviteRequestByID(int id)
	{
		InviteRequests inviteobj =null;
		String query = String.format(UserSQL.sqlGetInviteRequestsByID, id);
		System.out.println("Query : "+query);
		try
		{
			ResultSetHandler<InviteRequests> h = new BeanHandler<InviteRequests>(InviteRequests.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			inviteobj = run.query(conn, query, h);
			
			//SpyMemCacheClient.getInstance().add(String.format(key_AchievementByID, id),  game);
			
			System.out.println(inviteobj.toString());
			return inviteobj;
			
		}catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return inviteobj;
	}
	
	public static InviteRequests getInviteRequestByRequestID(String requestID)
	{
		InviteRequests inviteobj =null;
		String query = String.format(UserSQL.sqlGetInviteRequestByRequestID, requestID);
		System.out.println("Query : "+query);
		try
		{
			ResultSetHandler<InviteRequests> h = new BeanHandler<InviteRequests>(InviteRequests.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			inviteobj = run.query(conn, query, h);
			
			System.out.println(inviteobj.toString());
			return inviteobj;
			
		}catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return inviteobj;
	}
	
	public static List<InviteRequests> getInviteRequestBySenderID_InvitedID(String senderfbID , String invitedfbID)
	{
		List<InviteRequests> invites = null;
		String query = String.format(UserSQL.sqlGetInviteRequestBySenderId_ReceiverID, senderfbID , invitedfbID);
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<InviteRequests>> h = new BeanListHandler<InviteRequests>(InviteRequests.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			invites = run.query(conn, query, h);
			
			for (InviteRequests gd : invites) {
				System.out.println(gd.toString());
			}
			return invites;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invites;
	}
	
	
	public static List<InviteRequests> getInviteRequestBySenderFBID_Status(String senderfbid , String status)
	{
		List<InviteRequests> invites = null;
		String query = String.format(UserSQL.sqlGetInvitedRequestBySenderID_Status, senderfbid , status);
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<InviteRequests>> h = new BeanListHandler<InviteRequests>(InviteRequests.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			invites = run.query(conn, query, h);
			
			for (InviteRequests gd : invites) {
				System.out.println(gd.toString());
			}
			return invites;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invites;
	}
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdateInviteRequest, this.RequestID , this.SenderFBID , this.InvitedFBID , this.Status , this.InvitationID);
		DBAccess.ExecUpdate(query);
	}

	/**
	 * @return the invitationID
	 */
	public int getInvitationID() {
		return InvitationID;
	}

	/**
	 * @param invitationID the invitationID to set
	 */
	public void setInvitationID(int invitationID) {
		InvitationID = invitationID;
	}

	/**
	 * @return the requestID
	 */
	public String getRequestID() {
		return this.RequestID;
	}

	/**
	 * @param requestID the requestID to set
	 */
	public void setRequestID(String requestID) {
		this.RequestID = requestID;
	}

	/**
	 * @return the senderFBID
	 */
	public String getSenderFBID() {
		return this.SenderFBID;
	}

	/**
	 * @param senderFBID the senderFBID to set
	 */
	public void setSenderFBID(String senderFBID) {
		this.SenderFBID = senderFBID;
	}

	/**
	 * @return the invitedFBID
	 */
	public String getInvitedFBID() {
		return this.InvitedFBID;
	}

	/**
	 * @param invitedFBID the invitedFBID to set
	 */
	public void setInvitedFBID(String invitedFBID) {
		this.InvitedFBID = invitedFBID;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.Status = status;
	}

	/**
	 * @return the dateOfInvite
	 */
	public String getDateOfInvite() {
		return this.DateOfInvite;
	}

	/**
	 * @param dateOfInvite the dateOfInvite to set
	 */
	public void setDateOfInvite(String dateOfInvite) {
		this.DateOfInvite = dateOfInvite;
	}
	
}
