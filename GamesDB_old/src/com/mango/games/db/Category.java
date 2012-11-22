package com.mango.games.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;
import java.util.List;

@SuppressWarnings("serial")
public class Category implements Serializable
{
	private int CategoryID;
	private String CategoryName;
	
	
	public void setCategoryName(String categoryname)
	{
		this.CategoryName = categoryname;
	}
	
	public String getCategoryName()
	{
		return this.CategoryName;
	}
	
	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	
	public Category(String categoryname)
	{
		this.CategoryName = categoryname;
		String query = String.format(UserSQL.sqlCreateCategory, categoryname);
		Connection conn;
		try {
			conn = PoolFactory.getPooling().getConnection(); 
			String autogenColumns[] = {"CategoryID"};
			Statement statement = conn.createStatement();
			statement.executeUpdate(query, autogenColumns);
			
			ResultSet result_set = statement.getGeneratedKeys();
			if(result_set.first())
			{
				this.setCategoryID(result_set.getInt(1));
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
	
	public static Category getCategoryByID(int id)
	{
		String query = String.format(UserSQL.sqlGetCategoryByID, id);
		try
		{
			ResultSetHandler<Category> h = new BeanHandler<Category>(Category.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			Category game = run.query(conn, query, h);
			System.out.println(game.toString());
			return game;
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		return null;
	}
	
	public static List<Category> getCategoryList()
	{
		List<Category> categorylist = null;
		String query = UserSQL.sqlGetCategoryList;
		
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<Category>> h = new BeanListHandler<Category>(Category.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			categorylist = run.query(conn, query, h);
			for (Category gd: categorylist) {
				System.out.println(gd.toString());
			}
			return categorylist;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return categorylist;
		
	}
	
}
