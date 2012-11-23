package com.mango.games.db.mastertable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.DBConstants.EnumValues;
import com.mango.games.DBConstants.EnumValues.mCurrencyType;
import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class mCurrency 
{
	private int id;
	private String type;
	private EnumValues.mCurrencyType stype;
	
	public mCurrency()
	{
		
	}
	
	public mCurrency(EnumValues.mCurrencyType type)
	{
		String query = String.format(UserSQL.sqlCreatemCurrency, type.toString());
		System.out.println("mCurrency Create Query : "+query);
		this.setStype(type);
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
	
	
	public static mCurrency getmCurrencyByID(int id)
	{
		String query = String.format(UserSQL.sqlGetmCurrencyByID, id);
		mCurrency game = null;
		try
		{
			ResultSetHandler<mCurrency> h = new BeanHandler<mCurrency>(mCurrency.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			System.out.println("Inside get currency by id");
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return game;
	}
	
	public static mCurrency getmCurrencyByType(EnumValues.mCurrencyType type)
	{
		String query = String.format(UserSQL.sqlGetmCurrencyByType, type.toString());
		mCurrency game = null;
		try
		{
			ResultSetHandler<mCurrency> h = new BeanHandler<mCurrency>(mCurrency.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			System.out.println("Inside get currency by type");
			game = run.query(conn, query, h);
			return game;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return game;		
	}
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdatemCurrency, this.stype , this.id);
		DBAccess.ExecUpdate(query);
	}
	
	public void delete()
	{
		String query = String.format(UserSQL.sqlDeletemCurrency, this.id);
		DBAccess.ExecUpdate(query);
	}
	
	@Override
	public String toString()
	{
		String obj = String.format("mCurrency Object\n\tID : %d\n\tType : %s" , this.id , this.stype);
		return obj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public String getType() {
		return type;
	}*/

	public void setType(String type) {
		this.type = type;
		setStype(mCurrencyType.getEnum(type));
	}

	public EnumValues.mCurrencyType getStype() {
		return stype;
	}

	public void setStype(EnumValues.mCurrencyType stype) {
		System.out.println("Inside set stype: " + stype);
		this.stype = stype;
	}
	
}


