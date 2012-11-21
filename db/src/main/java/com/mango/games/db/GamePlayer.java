package com.mango.games.db;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

public class GamePlayer 
{
	private int id;
	private long gameid;
	private long userid;
	private String join_time;
	private String leave_time;
	private int winner;
	
	private static final String key_GamePlayerByID = "GamePlayerByID:%d";
	private static final String key_GamePlayerByUserID = "GamePlayerByUserID:%d";
	private static final String key_GamePlayerByGameID = "GamePlayerByGameID:%d";
	
	
	public GamePlayer()
	{
		
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setGameid(int gameid)
	{
		this.gameid = gameid;
	}
	
	public void setUserid(long userid)
	{
		this.userid = userid;
	}
	
	public long getUserid()
	{
		return this.userid;
	}
	
	public String getJoinTime()
	{
		return this.join_time;
	}
	
	public void SetLeaveTime()
	{
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.leave_time = df.format(cal.getTime()).toString();
	}
	
	public void SetLeaveTime(String leavetime)
	{
		this.leave_time = leavetime;
	}
	
	public String getLeaveTime()
	{
		return this.leave_time;
	}
	public GamePlayer(long gameid, long userid, int winner)
	{
		this.gameid = gameid;
		this.userid = userid;
		this.winner = winner;
		 
		String query = String.format(UserSQL.sqlCreateGamePlayer, this.gameid, 
				this.userid,  this.winner);
		System.out.println(query);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection();
				String autogenColumns[] = {"id"};
				Statement stm = conn.createStatement();
				stm.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = stm.getGeneratedKeys();

				if(result_set.first())
				{
					this.id = result_set.getInt(1);
					if(SpyMemCacheClient.getInstance().IsConnected())
						SpyMemCacheClient.getInstance().add(String.format(key_GamePlayerByID, this.id),  this);
				}
					  
			}
		catch (SQLException e) 
			{
					System.out.println("SQL Exception Code : "+e.getErrorCode());
					System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
					e.printStackTrace();
			}
	}
	
	/**
	 * Get Game Player Object Based on Primary Key 'ID'
	 * @param id
	 * @return GamePlayer Object
	 */
	public static GamePlayer getGamePlayerByID(int id)
	{
		GamePlayer gameplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gameplayer = (GamePlayer) SpyMemCacheClient.getInstance().get(String.format(key_GamePlayerByID, id));
		if(gameplayer == null)
		{
			String query = String.format(UserSQL.sqlGetGamePlayerByID, id);
			try
			{
				ResultSetHandler<GamePlayer> h = new BeanHandler<GamePlayer>(GamePlayer.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				gameplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
				SpyMemCacheClient.getInstance().add(String.format(key_GamePlayerByID, id),  gameplayer);
				
				System.out.println(gameplayer.toString());
				return gameplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
		}
		
		return gameplayer;
	}
	
	/**
	 * Get Game Player List Based on User ID
	 * @param userid
	 * @return List<GamePlayer>
	 */
	@SuppressWarnings("unchecked")
	public static List<GamePlayer> getGamePlayerByUserID(int userid)
	{
		List<GamePlayer> gameplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gameplayer = (List<GamePlayer>) SpyMemCacheClient.getInstance().get(String.format(key_GamePlayerByUserID, userid));
		
		if(gameplayer == null)
		{
			String query = String.format(UserSQL.sqlGetGamePlayerByUserID, userid);
			try
			{
				ResultSetHandler<List<GamePlayer>> h = new BeanListHandler<GamePlayer>(GamePlayer.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				gameplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_GamePlayerByUserID, userid),  gameplayer);
				
				System.out.println(gameplayer.toString());
				return gameplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		return gameplayer;
	}
	
	/**
	 * Get game Player List Based on gameID 
	 * @param gameid
	 * @return List<GamePlayer>
	 */
	@SuppressWarnings("unchecked")
	public static List<GamePlayer> getGamePlayerByGameID(int gameid)
	{
		List<GamePlayer> gameplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gameplayer = (List<GamePlayer>) SpyMemCacheClient.getInstance().get(String.format(key_GamePlayerByGameID, gameid));
		
		if(gameplayer == null)
		{
			String query = String.format(UserSQL.sqlGetGamePlayerByGameID, gameid);
			try
			{
				ResultSetHandler<List<GamePlayer>> h = new BeanListHandler<GamePlayer>(GamePlayer.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				gameplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_GamePlayerByGameID, gameid),  gameplayer);
				
				//System.out.println(gameplayer.toString());
				return gameplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		return gameplayer;
	}
	
	public void update()
	{
		if(SpyMemCacheClient.getInstance().IsConnected())
		{	
			SpyMemCacheClient.getInstance().delete(String.format(key_GamePlayerByID, this.id));
			SpyMemCacheClient.getInstance().delete(String.format(key_GamePlayerByUserID, this.userid));
			SpyMemCacheClient.getInstance().delete(String.format(key_GamePlayerByGameID, this.gameid));
		}
		String query = String.format(UserSQL.sqlUpdateGamePlayer, this.gameid , this.userid , this.join_time , this.leave_time , this.winner , this.id);
		DBAccess.ExecUpdate(query);
		
	}
}
