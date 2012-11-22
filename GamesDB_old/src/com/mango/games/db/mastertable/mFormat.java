package com.mango.games.db.mastertable;

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

public class mFormat 
{
	private int id;
	private String name;
	
	public mFormat()
	{
		
	}
	public mFormat(String name)
	{
		String query = String.format(UserSQL.sqlCreatemFormat, name);
		this.name = name;
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"id"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
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
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdatemFormat, this.id);
		DBAccess.ExecUpdate(query);
	}
	
	public mFormat getmFormatByID(int id)
	{
		String query = String.format(UserSQL.sqlGetmFormatByID, id);
		mFormat game = null;
		try
		{
			ResultSetHandler<mFormat> h = new BeanHandler<mFormat>(mFormat.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			game = run.query(conn, query, h);
			System.out.println(game.toString());
			return game;
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			return null;
		}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
