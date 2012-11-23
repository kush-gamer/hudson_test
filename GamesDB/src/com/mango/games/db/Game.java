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

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

@SuppressWarnings("serial")
public class Game implements Serializable
{
	
	private long id;
	private int definitionid;
	private int prizeid;
	private String start_time;
	private String end_time;
	
	public Game()
	{
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDefinitionid() {
		return definitionid;
	}

	public void setDefinitionid(int definitionid) {
		this.definitionid = definitionid;
	}

	public int getPrizeid() {
		return prizeid;
	}

	public void setPrizeid(int prizeid) {
		this.prizeid = prizeid;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	/**
	 * Set the Current System Time as the Start Time
	 */
	public void setStart_time()
	{
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.start_time = df.format(cal.getTime()).toString();
	}
	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	/**
	 * Set the Current System Time as the End Time 
	 */
	public void setEnd_time()
	{
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.end_time = df.format(cal.getTime());
	}
	
	public void update()
	{
		
		String query = String.format(UserSQL.sqlUpdateGame,this.definitionid,this.prizeid,this.start_time,this.end_time,this.id);
		System.out.println(query);
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

	public String toString() 
	{
		String toreturn = "GAME: %d, %d, %d, %s, %s";
		return String.format(toreturn, this.id, this.definitionid, this.prizeid, 
				this.start_time, this.end_time);
	}
	/**
	 * Insert a new Row in Game Table with gameid AutoIncrement
	 * 
	 * @param definitionid
	 * @param prizeid
	 * 
	 */
	
	public Game(int definitionid, int prizeid)
	{
		this.definitionid = definitionid;
		this.prizeid = prizeid;
				
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.start_time = df.format(cal.getTime()).toString();
		
		setEnd_time();
		
		String query = String.format(UserSQL.sqlCreateGame, this.definitionid, this.prizeid, this.start_time, this.end_time);
		
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
					this.id = (long)result_set.getLong(1);
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

	public static Game getGameById(long id)
	{
		String query = String.format(UserSQL.sqlGetGameById,id);
		try
		{
			ResultSetHandler<Game> h = new BeanHandler<Game>(Game.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			Game game = run.query(conn, query, h);
			System.out.println(game.toString());
			return game;
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			return null;
		}
		
	}
	

}
