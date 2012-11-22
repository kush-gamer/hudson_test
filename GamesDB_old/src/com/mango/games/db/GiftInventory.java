package com.mango.games.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

public class GiftInventory {
	private int InventoryID;
	private String FacebookID;
	private String GiftID;
	private int Count;
	private String DateOfUpdate;

	private static final String key_GiftInventoryByID = "GiftInventoryByID:%d";
	/**
	 * @return the inventoryID
	 */
	public int getInventoryID() {
		return InventoryID;
	}

	/**
	 * @param inventoryID
	 *            the inventoryID to set
	 */
	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
	}

	/**
	 * @return the facebookID
	 */
	public String getFacebookID() {
		return FacebookID;
	}

	/**
	 * @param facebookID
	 *            the facebookID to set
	 */
	public void setFacebookID(String facebookID) {
		FacebookID = facebookID;
	}

	/**
	 * @return the giftID
	 */
	public String getGiftID() {
		return GiftID;
	}

	/**
	 * @param giftID
	 *            the giftID to set
	 */
	public void setGiftID(String giftID) {
		GiftID = giftID;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return Count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		Count = count;
	}

	/**
	 * @return the dateOfUpdate
	 */
	public String getDateOfUpdate() {
		return DateOfUpdate;
	}

	/**
	 * @param dateOfUpdate
	 *            the dateOfUpdate to set
	 */
	public void setDateOfUpdate(String dateOfUpdate) {
		DateOfUpdate = dateOfUpdate;
	}

	public GiftInventory() {

	}

	public GiftInventory(String facebookid, String giftid, int count) {
		this.FacebookID = facebookid;
		this.Count = count;
		this.GiftID = giftid;
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.DateOfUpdate = df.format(cal.getTime()).toString();

		String query = String.format(UserSQL.sqlCreateGiftInventory,
				this.FacebookID, this.GiftID, this.Count, this.DateOfUpdate);
		Connection conn;
		try {
			conn = PoolFactory.getPooling().getConnection();
			String autogenColumns[] = { "InventoryID" };
			Statement statement = conn.createStatement();
			statement.executeUpdate(query, autogenColumns);

			ResultSet result_set = statement.getGeneratedKeys();
			if (result_set.first()) {
				this.setInventoryID(result_set.getInt(1));
			}
			// update();

		} catch (SQLException e) {
			System.out.println("SQL Exception Code : " + e.getErrorCode());
			System.out.println("SQL Exception Message : "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void update() {
		
		SpyMemCacheClient.getInstance().delete(String.format(GiftInventory.key_GiftInventoryByID , this.InventoryID));
		String query = String.format(UserSQL.sqlUpdateGiftInventory,
				this.FacebookID, this.GiftID, this.Count, this.DateOfUpdate,
				this.InventoryID);
		Connection conn;
		try {
			conn = PoolFactory.getPooling().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("SQL Exception Code: " + e.getErrorCode());
			System.out.println("SQL Exception Message : "
					+ e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public static GiftInventory getGiftInventoryByID(int inventoryid)
	{
		GiftInventory obj  = null;
		
		obj =(GiftInventory) SpyMemCacheClient.getInstance().get("GiftInventoryByID"+inventoryid);
		if(obj == null)
		{
			String query = String.format(UserSQL.sqlGetGiftInventoryByID, inventoryid);
			try
			{
				ResultSetHandler<GiftInventory> h = new BeanHandler<GiftInventory>(GiftInventory.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				GiftInventory game = run.query(conn, query, h);
				System.out.println(game.toString());
				
				SpyMemCacheClient.getInstance().add("GiftInventoryByID",  game);
				
				return game;
				
			}catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return null;
	}
	
	public static GiftInventory getGiftInventoryByFacebookId_GiftID(String facebookId , String GiftID)
	{
		GiftInventory obj  = null;
		//if(SpyMemCacheClient.getInstance().IsConnected())
			//obj =(GiftInventory) SpyMemCacheClient.getInstance().get("GiftInventoryByID"+inventoryid);
		if(obj == null)
		{
			String query = String.format(UserSQL.sqlGetGiftInventoryByFacebookID_GiftID, facebookId , GiftID);
			try
			{
				ResultSetHandler<GiftInventory> h = new BeanHandler<GiftInventory>(GiftInventory.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				GiftInventory game = run.query(conn, query, h);
				if(game!=null)
					System.out.println(game.toString());
				
				//if(SpyMemCacheClient.getInstance().IsConnected())
				//	SpyMemCacheClient.getInstance().add("GiftInventoryByID",  game);
				
				return game;
				
			}catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return null;
	}

	public static List<GiftInventory> getGiftInventoryByFacebookID(String facebookid) 
	{
		List<GiftInventory> giftinventorylist = null;
		String query = String.format(UserSQL.sqlGetGiftInventoryByFacebookID,
				facebookid);
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<GiftInventory>> h = new BeanListHandler<GiftInventory>(
					GiftInventory.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			giftinventorylist = run.query(conn, query, h);
			for (GiftInventory gd : giftinventorylist) {
				System.out.println(gd.toString());
			}
			return giftinventorylist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giftinventorylist;
	}

}
