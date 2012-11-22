package com.mango.games.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

import java.util.Calendar;
import java.util.List;

public class GiftExchange 
{
	private int GiftExchangeID;
	private String GiftID;
	private String Sender;
	private String Receiver;
	private int IsAccepted;
	private String DateOfExchange;
	public int getGiftExchangeID() {
		return GiftExchangeID;
	}
	public void setGiftExchangeID(int giftExchangeID) {
		GiftExchangeID = giftExchangeID;
	}
	public String getGiftID() {
		return GiftID;
	}
	public void setGiftID(String giftID) {
		GiftID = giftID;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	/**
	 * @return the isAccepted
	 */
	public int getIsAccepted() {
		return IsAccepted;
	}
	/**
	 * @param isAccepted the isAccepted to set
	 */
	public void setIsAccepted(int isAccepted) {
		IsAccepted = isAccepted;
	}
	/**
	 * @return the dateOfExchange
	 */
	public String getDateOfExchange() {
		return DateOfExchange;
	}
	/**
	 * @param dateOfExchange the dateOfExchange to set
	 */
	public void setDateOfExchange(String dateOfExchange) {
		DateOfExchange = dateOfExchange;
	}
	
	public GiftExchange()
	{
		
	}

	public GiftExchange(String giftID , String sender , String receiver)
	{
		this.GiftID = giftID;
		this.Sender = sender;
		this.Receiver = receiver;
		this.IsAccepted = 0;
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.DateOfExchange = df.format(cal.getTime()).toString();
		
		String query = String.format(UserSQL.sqlCreateGiftExchange, this.GiftID , this.Sender , this.Receiver , this.IsAccepted ,this.DateOfExchange);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection(); 
				String autogenColumns[] = {"GiftExchangeID"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
				
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					this.GiftExchangeID = result_set.getInt(1);
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
	
	public void update()
	{
		String query = String.format(UserSQL.sqlUpdateGiftExchange, this.GiftID , this.Sender , this.Receiver , this.IsAccepted , this.DateOfExchange);
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
	
	public static GiftExchange getGiftExchangebyID(int id)
	{
		String query = String.format(UserSQL.sqlGetGiftExchangeByID, id);
		
		try
		{
			ResultSetHandler<GiftExchange> h = new BeanHandler<GiftExchange>(GiftExchange.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			GiftExchange game = run.query(conn, query, h);
			System.out.println(game.toString());
			return game;
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		return null;
	}
	
	public static List<GiftExchange> getGiftExchangebyGiftID(String giftid)
	{
		List<GiftExchange> giftexchange= null;
		String query = String.format(UserSQL.sqlGetGiftExchangeByGiftID, giftid);
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<GiftExchange>> h = new BeanListHandler<GiftExchange>(GiftExchange.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			giftexchange = run.query(conn, query, h);
			for (GiftExchange gd: giftexchange) {
				System.out.println(gd.toString());
			}
			return giftexchange;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return giftexchange;
	}
	
	public static List<GiftExchange> getGiftExchangeBySenderID(String senderid)
	{
		List<GiftExchange> giftexchange= null;
		String query = String.format(UserSQL.sqlGetGiftExchangeBySenderID, senderid);
		try {
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<GiftExchange>> h = new BeanListHandler<GiftExchange>(GiftExchange.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			giftexchange = run.query(conn, query, h);
			for (GiftExchange gd: giftexchange) {
				System.out.println(gd.toString());
			}
			return giftexchange;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return giftexchange;
	}
}
