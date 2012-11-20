package com.mango.games.db;

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

public class Gift 
{
	private int AutoGiftID;
	private int CategoryID;
	private String GiftID;
	private String Name;
	private int Chips;
	private String Image;
	private String Description;
	private int Count;
	
	private static final String key_GiftByID = "GiftByAutoGiftID:%d";
	private static final String key_GiftByGiftID = "GiftByGiftID:%s";
	private static final String key_GiftByCategoryID = "GiftByCategoryID:%d";
	private static final String key_GiftByName = "GiftByName:%s";
	
	/**
	 * 
	 * @return AutoGiftID
	 */
	public int getAutoGiftID()
	{
		return this.AutoGiftID;
	}
	/**
	 * 
	 * @return CategoryID
	 */
	public int getCategoryID()
	{
		return this.CategoryID;
	}
	/**
	 * 
	 * @return GiftID
	 */
	public String getGiftID()
	{
		return this.GiftID;
	}
	/**
	 * 
	 * @return Name
	 */
	public String getName()
	{
		return this.Name;
	}
	/**
	 * 
	 * @return Chips
	 */
	public int getChips()
	{
		return this.Chips;
	}
	/**
	 * 
	 * @return Image
	 */
	public String getImage()
	{
		return this.Image;
	}
	/**
	 * 
	 * @return Description
	 */
	public String getDescription()
	{
		return this.Description;
	}
	/**
	 * 
	 * @return Count
	 */
	public int getCount()
	{
		return this.Count;
	}
	/**
	 * 
	 * @param categoryid
	 */
	public void setCategoryID(int categoryid)
	{
		this.CategoryID = categoryid;
	}
	/**
	 * 
	 * @param giftid
	 */
	public void setGiftID(String giftid)
	{
		this.GiftID = giftid;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.Name = name;
	}
	public void setChips(int chips)
	{
		this.Chips = chips;
	}
	/**
	 * 
	 * @param image
	 */
	public void setImage(String image)
	{
		this.Image = image;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.Description = description;
	}
	/**
	 * 
	 * @param count
	 */
	public void setCount(int count)
	{
		this.Count = count;
	}
	
	public Gift()
	{
		
	}
	/**
	 * 
	 * @param categoryid
	 * @param giftid
	 * @param name
	 * @param image
	 * @param description
	 * @param chips
	 * @param count
	 */
	public Gift(int categoryid , String giftid , String name , String image ,String description , int chips , int count)
	{
		this.CategoryID = categoryid;
		this.Chips = chips;
		this.Count = count;
		this.Description = description;
		this.GiftID = giftid;
		this.Image = image;
		this.Name  = name;
		
		String query = String.format(UserSQL.sqlCreateGift,this.CategoryID, this.GiftID, this.Name , this.Chips , this.Image , this.Description , this.Count);
		System.out.println(query);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"AutoGiftID"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					this.AutoGiftID = result_set.getInt(1);
					if(SpyMemCacheClient.getInstance().IsConnected())
						SpyMemCacheClient.getInstance().add(String.format(key_GiftByID, this.AutoGiftID),  this);
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
	 * 
	 * @param giftid
	 * @return Gift Object
	 */
	public static Gift getGiftByGiftID(String giftid)
	{
		Gift gift = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gift = (Gift) SpyMemCacheClient.getInstance().get(String.format(key_GiftByGiftID, giftid));
		if(gift == null)
		{
			String query = String.format(UserSQL.sqlGetGiftByGiftID, giftid);
			try
			{
				ResultSetHandler<Gift> h = new BeanHandler<Gift>(Gift.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				gift = run.query(conn, query, h);
				System.out.println(gift.toString());
				return gift;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		
		return gift;
	}
	/**
	 * 
	 * @param id
	 * @return Gift Object
	 */
	public static Gift getGiftByID(int id)
	{
		Gift gift = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gift = (Gift)SpyMemCacheClient.getInstance().get(String.format(key_GiftByID, id));
		if(gift == null)
		{
			String query = String.format(UserSQL.sqlGetGiftByID, id);
			try
			{
				ResultSetHandler<Gift> h = new BeanHandler<Gift>(Gift.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				gift = run.query(conn, query, h);
				System.out.println(gift.toString());
				return gift;
				
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		
		return gift;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Gift> getGiftByCategoryID(int categoryid)
	{
		List<Gift> gift = null;
		if(SpyMemCacheClient.getInstance().IsConnected())
			gift = (List<Gift>) SpyMemCacheClient.getInstance().get(String.format(key_GiftByCategoryID, categoryid));
		if(gift == null)
		{
			String query = String.format(UserSQL.sqlGetGiftByCategoryID, categoryid);
			try {
				QueryRunner run = new QueryRunner();
				ResultSetHandler<List<Gift>> h = new BeanListHandler<Gift>(Gift.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				gift = run.query(conn, query, h);
				
				if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_GiftByCategoryID, categoryid),  gift);
				
				for (Gift gd : gift) {
					System.out.println(gd.toString());
				}
				return gift;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return gift;
	}
	public void Update()
	{
		if(SpyMemCacheClient.getInstance().IsConnected())
		{
			SpyMemCacheClient.getInstance().delete(String.format(key_GiftByID, this.AutoGiftID));
			SpyMemCacheClient.getInstance().delete(String.format(key_GiftByGiftID, this.GiftID));
			SpyMemCacheClient.getInstance().delete(String.format(key_GiftByCategoryID, this.CategoryID));
			SpyMemCacheClient.getInstance().delete(String.format(key_GiftByName, this.Name));
		}
		
		
		String query = String.format(UserSQL.sqlUpdateGift, this.CategoryID , this.GiftID , this.Name , this.Chips , this.Image , this.Description , this.Count);
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

}





































