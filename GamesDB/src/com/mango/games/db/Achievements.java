package com.mango.games.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

@SuppressWarnings("serial")
public class Achievements implements Serializable
{
	private int ID;
	private int AchievementID;
	private String FacebookID;
	private int BadgeID;
	private int IsCurrent;
	private String DateOfUnlock;
	
	private static final String key_AchievementByID = "AchievementByID:%d";
	
	public Achievements()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFacebookID() {
		return FacebookID;
	}

	public void setFacebookID(String facebookID) {
		FacebookID = facebookID;
	}

	public int getBadgeID() {
		return BadgeID;
	}

	public void setBadgeID(int badgeID) {
		BadgeID = badgeID;
	}

	public int getIsCurrent() {
		return IsCurrent;
	}

	public void setIsCurrent(int isCurrent) {
		IsCurrent = isCurrent;
	}

	public String getDateOfUnlock() {
		return DateOfUnlock;
	}

	public void setDateOfUnlock(String dateOfUnlock) {
		DateOfUnlock = dateOfUnlock;
	}

	public int getAchievementID() {
		return AchievementID;
	}

	public void setAchievementID(int achievementID) {
		AchievementID = achievementID;
	}
	
	public Achievements(int achievementid , String facebookid , int badgeid , int iscurrent)
	{
		this.AchievementID = achievementid;
		this.FacebookID = facebookid;
		this.BadgeID = badgeid;
		this.IsCurrent = iscurrent;
		
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.DateOfUnlock = df.format(cal.getTime()).toString();
		
		
		String query = String.format(UserSQL.sqlCreateAchievement, this.AchievementID , this.FacebookID , this.BadgeID , this.IsCurrent , this.DateOfUnlock);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"ID"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					this.ID = result_set.getInt(1);
					
					SpyMemCacheClient.getInstance().add(String.format(key_AchievementByID, this.ID),  this);
				}
				//update();
					  
			}
		catch (SQLException e) 
			{
					System.out.println("SQL Exception Code : "+e.getErrorCode());
					System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
					e.printStackTrace();
			}
	}
	
	public static Achievements getAchievementByID(int id)
	{
		Achievements game = null;

		game = (Achievements)SpyMemCacheClient.getInstance().get(String.format(key_AchievementByID, id));
		if(game == null)
		{
			String query = String.format(UserSQL.sqlGetAchievementsByID, id);
			try
			{
				ResultSetHandler<Achievements> h = new BeanHandler<Achievements>(Achievements.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				game = run.query(conn, query, h);
								
				SpyMemCacheClient.getInstance().add(String.format(key_AchievementByID, id),  game);
				
				System.out.println(game.toString());
				return game;
				
			}catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return game;
	}
	
	
	public static boolean IsPlayerAchievement(String facebookid , int achievementid)
	{
		String query = String.format(UserSQL.sqlGetAchievementByFacebookID_AchievementID, facebookid , achievementid);
		boolean returnValue = false;
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(query);
				returnValue =  result.first();
		}
		catch (SQLException e) 
		{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
		}
		return returnValue;
	}
	public void update()
	{
		SpyMemCacheClient.getInstance().delete(String.format(key_AchievementByID, this.ID));
	
		String query = String.format(UserSQL.sqlUpdateAchievements, this.AchievementID , this.FacebookID , this.BadgeID , this.IsCurrent , this.DateOfUnlock , this.ID);
		Connection conn;
		try {
			conn = PoolFactory.getPooling().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(query);
			
		} 
		catch (SQLException e) {
			System.out.println("SQL Exception Code: "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		String value = "Achievements Object : ID=>"+this.ID+" , Achievement ID=>"+this.AchievementID+
				", FacebookID=>"+this.FacebookID+" , BadgeID=>"+this.BadgeID+" , IsCurrent=>"+this.IsCurrent;
		return value;
	}
	
	public void delete()
	{
		String query = String.format(UserSQL.sqlDeleteAchievements, this.ID);
		DBAccess.ExecUpdate(query);
	}

}
