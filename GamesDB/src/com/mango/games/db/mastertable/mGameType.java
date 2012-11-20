package com.mango.games.db.mastertable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class mGameType 
{
	private int id;
	private String name;
	
	public mGameType()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public mGameType(String name)
	{
		this.name = name;
		String query = String.format(UserSQL.sqlCreateGameType, this.name);
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
				}
					  
			}
		catch (SQLException e) 
			{
					System.out.println("SQL Exception Code : "+e.getErrorCode());
					System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
					e.printStackTrace();
			}		
	}
	
	public static mGameType getUserbyID(int id) 
	{
		String query = String.format(UserSQL.sqlGetGameType, id);
		try {
			ResultSetHandler<mGameType> h = new BeanHandler<mGameType>(mGameType.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			mGameType gametype = run.query(conn, query, h);
			System.out.println(gametype.toString());
			return gametype;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return null;
	}	
	@Override
	public String toString() 
	{
		String toreturn = "GAME TYPE: %d, %s";
		return String.format(toreturn, this.id, this.name);
	}
	
}
