package com.mango.games.db.mastertable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.DBConstants.EnumValues.mTransactiontype;
import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class mTransactionType 
{
	private int id;
	private String description;
	private String type;
	private mTransactiontype enumtype;
	
	public mTransactionType()
	{
		
	}
	
	public mTransactionType(String desc , mTransactiontype type)
	{
		this.description = desc;
		this.enumtype = type;
		this.type = type.toString();
		String query = String.format(UserSQL.sqlCreatemTransactionType, this.description , this.enumtype);
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
	
	public static mTransactionType getmTransactionByID(int id)
	{
		mTransactionType game = null;
		String query = String.format(UserSQL.sqlGetmTransactionTypeByID, id);
		try
		{
			ResultSetHandler<mTransactionType> h = new BeanHandler<mTransactionType>(mTransactionType.class);
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
	
	public static mTransactionType getmTransactionTypeByType(mTransactiontype type)
	{
		mTransactionType game = null;
		String query = String.format(UserSQL.sqlGetmTransactionTypeByType, type);
		try
		{
			ResultSetHandler<mTransactionType> h = new BeanHandler<mTransactionType>(mTransactionType.class);
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
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdatemTransactionType, this.id);
		DBAccess.ExecUpdate(query);
	}
	
	public void delete()
	{
		String query = String.format(UserSQL.sqlDeletemTransactionType, this.id);
		DBAccess.ExecUpdate(query);
	}
	
	public String toString()
	{
		String returnValue = "mTransaction Type : ID=> "+this.id+" , Description=> "+this.description+" , Type=> "+this.enumtype.toString();
		return returnValue;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the type
	 */
	
	/*public String getType() {
		return type;
	}*/
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		enumtype = mTransactiontype.getEnum(type);
		this.type = type;
	}
	
	public mTransactiontype getEnumType()
	{
		return this.enumtype;
	}
	public void setEnumType(mTransactiontype type)
	{
		this.enumtype = type;
	}
	

}
