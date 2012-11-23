package com.mango.games.db;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

@SuppressWarnings("serial")
public class DealPlayerDB implements Serializable
{
	private int id;
	private long gameid;
	private int matchid;
	private int dealid;
	private long userid;
	private int points;
	private static final String key_DealPlayerByID = "DealPlayerByID:%d";
	private static final String key_DealPlayerByUserID = "DealPlayerByUserID:%d";
	private static final String key_DealPlayerByDealID = "DealPlayerByDealID:%d";
	
	public DealPlayerDB()
	{
		
	}
	
	public DealPlayerDB(long gameid, int matchid, int dealid, long userid, int points )
	{
		this.gameid = gameid;
		this.matchid = matchid;
		this.dealid = dealid;
		this.userid = userid;
		this.points = points;
		
		String query = String.format(UserSQL.sqlCreateDealPlayer, this.gameid, 
				this.matchid, this.dealid, this.userid, this.points);
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
							this.id = result_set.getInt("id");
							
							if(SpyMemCacheClient.getInstance().IsConnected())
							SpyMemCacheClient.getInstance().add(String.format(key_DealPlayerByID, this.id),  this);
						}
							  
					}
				catch (SQLException e) 
					{
							System.out.println("SQL Exception Code : "+e.getErrorCode());
							System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
							e.printStackTrace();
					}
	}

	public int getId() {
		return id;
	}

	public void setId(int newid) {
		this.id = newid;
	}

	/**
	 * 
	 * @return gameid
	 */
	public long getGameid()
	{
		return gameid;
	}
	
	public void setGameid(long newgameid)
	{
		this.gameid = newgameid;
	}
	public int getMatchid() {
		return matchid;
	}

	public void setMatchid(int newmatchid) {
		this.matchid = newmatchid;
	}

	public int getDealid() {
		return dealid;
	}

	public void setDealid(int newdealid) {
		this.dealid = newdealid;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int newpoints) {
		this.points = newpoints;
	}
	
	/**
	 * Get The Details of deal based on Primary Key ID
	 * @param id
	 * @return DealPlayer Object
	 */
	public static DealPlayerDB getDealPlayerByID(int id)
	{
		DealPlayerDB dealplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			dealplayer = (DealPlayerDB)SpyMemCacheClient.getInstance().get(String.format(key_DealPlayerByID, id));
		
		if(dealplayer == null)
		{
			String query = String.format(UserSQL.sqlGetDealPlayerByID, id);
			try
			{
				ResultSetHandler<DealPlayerDB> h = new BeanHandler<DealPlayerDB>(DealPlayerDB.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				dealplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
				SpyMemCacheClient.getInstance().add(String.format(key_DealPlayerByID, id),  dealplayer);
				
				System.out.println(dealplayer.toString());
				return dealplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		return dealplayer;
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	/**
	 * Get List of all Deals done by this userid
	 * @param userid
	 * @return List<DealPlayer> 
	 */
	@SuppressWarnings("unchecked")
	public static List<DealPlayerDB> getDealPlayerByUserID(int userid)
	{
		List<DealPlayerDB> dealplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			dealplayer = (List<DealPlayerDB>) SpyMemCacheClient.getInstance().get(String.format(key_DealPlayerByUserID, userid));
		if(dealplayer == null)
		{
			String query = String.format(UserSQL.sqlGetDealPlayerByUserID, userid);
			try
			{
				ResultSetHandler<List<DealPlayerDB>> h = new BeanListHandler<DealPlayerDB>(DealPlayerDB.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				dealplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_DealPlayerByUserID, userid),  dealplayer);
				
				System.out.println(dealplayer.toString());
				return dealplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		
		return dealplayer;
	}
	
	@SuppressWarnings("unchecked")
	public static List<DealPlayerDB> getDealPlayerByDealID(int dealid)
	{
		List<DealPlayerDB> dealplayer = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			dealplayer = (List<DealPlayerDB>) SpyMemCacheClient.getInstance().get(String.format(key_DealPlayerByDealID, dealid));
		if(dealplayer == null)
		{
			String query = String.format(UserSQL.sqlGetDealPlayerByDealID, dealid);
			try
			{
				ResultSetHandler<List<DealPlayerDB>> h = new BeanListHandler<DealPlayerDB>(DealPlayerDB.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				dealplayer = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_DealPlayerByDealID, dealid),  dealplayer);
				
				System.out.println(dealplayer.toString());
				return dealplayer;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		
		return dealplayer;
	}
	/**
	 * Update the DealPlayer Table 
	 */
	public void update()
	{
		if(SpyMemCacheClient.getInstance().IsConnected())
		{
			SpyMemCacheClient.getInstance().delete(String.format(key_DealPlayerByID, this.id));
			SpyMemCacheClient.getInstance().delete(String.format(key_DealPlayerByUserID, this.userid));
			SpyMemCacheClient.getInstance().delete(String.format(key_DealPlayerByDealID, this.dealid));
		}
		String query = String.format(UserSQL.sqlUpdateDealPlayer,this.gameid,this.matchid,this.dealid,this.userid,this.id);
		
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
	
}
