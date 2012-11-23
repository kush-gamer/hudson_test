package com.mango.games.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class GameDealer 
{
	private int id;
	private long gameid;
	private int matchid;
	private int dealid;
	private int chips;
	private int gold;
	
	public GameDealer()
	{
		
	}
	public GameDealer(long gameid , int matchid , int dealid , int chips , int gold)
	{
		this.gameid = gameid;
		this.matchid = matchid;
		this.dealid = dealid;
		this.chips = chips;
		this.gold = gold;
		
		String query = String.format(UserSQL.sqlCreategameDealer, this.gameid , this.matchid , this.dealid , this.chips , this.gold);
		
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"id"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					this.setId(result_set.getInt(1));
				}
		}
		catch (SQLException e) 
		{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
		}
	}
	
	public static GameDealer getGameDealerByID(int id)
	{
		GameDealer game = null;
		String query = String.format(UserSQL.sqlGetGameDealerByID, id);
		try
		{
			ResultSetHandler<GameDealer> h = new BeanHandler<GameDealer>(GameDealer.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static GameDealer getGameDealerByGameID(long gameid)
	{
		GameDealer game = null;
		String query = String.format(UserSQL.sqlGetGameDealerByGameID, gameid);
		try
		{
			ResultSetHandler<GameDealer> h = new BeanHandler<GameDealer>(GameDealer.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static GameDealer getGameDealerByGameID_MatchID(long gameid , int matchid)
	{
		GameDealer game = null;
		String query = String.format(UserSQL.sqlGetGameDealerByGameID_MatchID, gameid , matchid);
		try
		{
			ResultSetHandler<GameDealer> h = new BeanHandler<GameDealer>(GameDealer.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static GameDealer getGameDealerByGameID_MatchID_DealID(long gameid , int matchid , int dealid)
	{
		GameDealer game = null;
		String query = String.format(UserSQL.sqlGetGameDealerByGameID_MatchID_DealID, gameid , matchid , dealid);
		try
		{
			ResultSetHandler<GameDealer> h = new BeanHandler<GameDealer>(GameDealer.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdateGameDealer, this.gameid , this.matchid , this.dealid , this.chips , this.gold);
		DBAccess.ExecUpdate(query);
	}
	
	public void delete()
	{
		String query = String.format(UserSQL.sqlDeleteGameDealer, this.id);
		DBAccess.ExecUpdate(query);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the gameid
	 */
	public long getGameid() {
		return gameid;
	}
	/**
	 * @param gameid the gameid to set
	 */
	public void setGameid(long gameid) {
		this.gameid = gameid;
	}
	/**
	 * @return the matchid
	 */
	public int getMatchid() {
		return matchid;
	}
	/**
	 * @param matchid the matchid to set
	 */
	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}
	/**
	 * @return the dealid
	 */
	public int getDealid() {
		return dealid;
	}
	/**
	 * @param dealid the dealid to set
	 */
	public void setDealid(int dealid) {
		this.dealid = dealid;
	}
	/**
	 * @return the chips
	 */
	public int getChips() {
		return chips;
	}
	/**
	 * @param chips the chips to set
	 */
	public void setChips(int chips) {
		this.chips = chips;
	}
	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	

}
