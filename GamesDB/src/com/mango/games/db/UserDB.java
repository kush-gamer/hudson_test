package com.mango.games.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.mango.games.db.manager.connectionpool.*;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

@SuppressWarnings("serial")
public class UserDB implements Serializable{
	
	private long id;
	private String first_name;
	private String last_name;
	private String emailid;
	private Date date_joined;
	private String externalid;
	private int extsrcid = 1; 
	private String gender;
	private String dob;
	
	private static final String key_UserByID = "UserByID:%d";
	private static final String key_UserByFacebookID = "UserByFacebookID:%s";
	
	public UserDB() 
	{
		
	}	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Date getDate_joined() {
		return date_joined;
	}

	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public String getExternalid() {
		return externalid;
	}

	public String setExternalid(String externalid) {
		return this.externalid = externalid;
	}

	public int getExtsrcid() {
		return extsrcid;
	}

	public void setExtsrcid(int extsrcid) {
		this.extsrcid = extsrcid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}		
	
	public String toString() 
	{
		String toreturn = "USER: %d, %s, %s, %s, %s, %s, %d, %s, %s";
		return String.format(toreturn, this.id, this.first_name, this.last_name, 
				this.emailid, this.date_joined, this.externalid, this.extsrcid, 
				this.gender, this.dob);
	}
	
	public UserDB(String fname, String lname, String email, String fbId, String gender, String dob) 
	{
		this.first_name = fname;
		this.last_name = lname;
		this.emailid = email;
		this.externalid = fbId;
		this.gender = gender;
		this.dob = dob;
		
			
		String query = String.format(UserSQL.sqlCreatePlayer, this.first_name, 
		this.last_name, this.emailid, this.externalid, this.extsrcid, 
		this.gender, this.dob);
		System.out.println(query);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection();
				String autogenColumns[] = {"id"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
								
				ResultSet result_set = statement.getGeneratedKeys();
				
				
				if(result_set.first())
				{
					System.out.println("Result Set : "+result_set.getLong(1));
					this.id = (long)result_set.getLong(1);
					//Create a user account for the user.
					if( this.id > 0 )
					{
						new UserAccount(this.id);
						if(SpyMemCacheClient.getInstance().IsConnected())
						{
							SpyMemCacheClient.getInstance().add(String.format(UserDB.key_UserByID, this.id),  this);
							SpyMemCacheClient.getInstance().add(String.format(UserDB.key_UserByFacebookID, this.externalid),  this);
						}
					}
				}		
				
			}
		catch (SQLException e) 
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
	}
	
	
	public static UserDB getUserbyID(long id) 
	{
		String key = String.format(UserDB.key_UserByID, id);
		System.out.println("Key Value : "+key);
		
		UserDB user = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			user = (UserDB)SpyMemCacheClient.getInstance().get(String.format(UserDB.key_UserByID, id));
		
		if(user == null)
		{
			String query = String.format(UserSQL.sqlGetPlayerById, id);
			try {
				ResultSetHandler<UserDB> h = new BeanHandler<UserDB>(UserDB.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				user = run.query(conn, query, h);
				
				if((user!= null) && SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(UserDB.key_UserByID, id),  user);
				
				return user;
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Mem Cache used");
		}
		return user;
	}
	
	public static UserDB getUserbyFBID(String fbid) 
	{
		UserDB user = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			user = (UserDB) SpyMemCacheClient.getInstance().get(String.format(UserDB.key_UserByFacebookID, fbid));
		if(user == null)
		{
			String query = String.format(UserSQL.sqlGetFacebookId, fbid);
			try {
				ResultSetHandler<UserDB> h = new BeanHandler<UserDB>(UserDB.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				user = run.query(conn, query, h);
				if((user!= null) && (SpyMemCacheClient.getInstance().IsConnected()))
					SpyMemCacheClient.getInstance().add(String.format(UserDB.key_UserByFacebookID, fbid),  user);
				
				return user;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Mem Cache used");
		}
		return user;
	}
	

}
