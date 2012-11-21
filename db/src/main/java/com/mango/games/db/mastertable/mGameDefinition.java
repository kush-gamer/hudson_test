package com.mango.games.db.mastertable;

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
import com.mango.games.db.sql.UserSQL;


@SuppressWarnings("serial")
public class mGameDefinition implements Serializable
{
	private long id;
	private int typeid;
	private int formatid;
	private int min_players;
	private int max_players;
	private float entryfee;
	private int min_rooms;
	private int increment_count;
	
	public int getMin_rooms() {
		return min_rooms;
	}

	public void setMin_rooms(int min_rooms) {
		this.min_rooms = min_rooms;
	}

	public int getIncrement_count() {
		return increment_count;
	}

	public void setIncrement_count(int increment_count) {
		this.increment_count = increment_count;
	}

	public mGameDefinition()
	{
		
	}
	
	@Override
	public String toString() 
	{
		String toreturn = "GAME DEFINITION: %d, %d, %d, %d, %d, %f";
		return String.format(toreturn, this.id, this.typeid, this.formatid, 
				this.min_players, this.max_players, this.entryfee);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public int getFormatid() {
		return formatid;
	}

	public void setFormatid(int formatid) {
		this.formatid = formatid;
	}

	public int getMin_players() {
		return min_players;
	}

	public void setMin_players(int min_players) {
		this.min_players = min_players;
	}

	public int getMax_players() {
		return max_players;
	}

	public void setMax_players(int max_players) {
		this.max_players = max_players;
	}

	public float getEntryfee() {
		return entryfee;
	}

	public void setEntryfee(float entryfee) {
		this.entryfee = entryfee;
	}
	
	
	
	public mGameDefinition(int typeid, int formatid, int min_players, int max_players, float entryfee)
	{
		this.typeid = typeid;
		this.formatid = formatid;
		this.min_players = min_players;
		this.max_players = max_players;
		this.entryfee = entryfee;
		
		String query = String.format(UserSQL.sqlCreateGameDef, this.typeid, 
				this.formatid, this.min_players, this.max_players, this.entryfee);
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
							this.id = result_set.getLong(1);
						}
							  
					}
				catch (SQLException e) 
					{
							System.out.println("SQL Exception Code : "+e.getErrorCode());
							System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
							e.printStackTrace();
					}
		
		
	}
	
	public static mGameDefinition getGameDefbyID(long id) 
	{
		String query = String.format(UserSQL.sqlGetGameDefById, id);
		try {
			ResultSetHandler<mGameDefinition> h = new BeanHandler<mGameDefinition>(mGameDefinition.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			mGameDefinition gamedef = run.query(conn, query, h);
			System.out.println(gamedef.toString());
			return gamedef;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return null;
	}
	
	public static List<mGameDefinition> getAllDefinitions() {
		List<mGameDefinition> gameDefinitions = null;
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<mGameDefinition>> h = new BeanListHandler<mGameDefinition>(mGameDefinition.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			gameDefinitions = run.query(conn, UserSQL.sqlGetDefinitions, h);
			for (mGameDefinition gd: gameDefinitions) {
				System.out.println(gd.toString());
			}
			return gameDefinitions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return gameDefinitions;
	}
}
