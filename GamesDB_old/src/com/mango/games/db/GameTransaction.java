package com.mango.games.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

public class GameTransaction 
{
	private int id;
	private long user_id;
	private long gameid;
	private int matchid;
	private int dealid;
	private int txtype;
	private int amount;
	private int currencyid;
	
	private static final String key_GameTransactionByID = "GameTransactionByID:%d";
	//private static final String key_GameTransactionBYUserID = "GameTransactionByUserID:%d";
	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the gameid
	 */
	public long getGameid() {
		return gameid;
	}
	/**
	 * @param gameid the gameid to set
	 */
	public void setGameid(long gameid) {
		this.gameid = gameid;
	}
	/**
	 * @return the matchid
	 */
	public int getMatchid() {
		return matchid;
	}
	/**
	 * @param matchid the matchid to set
	 */
	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}
	/**
	 * @return the dealid
	 */
	public int getDealid() {
		return dealid;
	}
	/**
	 * @param dealid the dealid to set
	 */
	public void setDealid(int dealid) {
		this.dealid = dealid;
	}
	/**
	 * @return the txtype
	 */
	public int getTxtype() {
		return txtype;
	}
	/**
	 * @param txtype the txtype to set
	 */
	public void setTxtype(int txtype) {
		this.txtype = txtype;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the currencyid
	 */
	public int getCurrencyid() {
		return currencyid;
	}
	/**
	 * @param currencyid the currencyid to set
	 */
	public void setCurrencyid(int currencyid) {
		this.currencyid = currencyid;
	}
	
	public GameTransaction(long userid , long gameid , int matchid , int dealid , int txtype , int amount , int currencyid)
	{
		this.user_id = userid;
		this.gameid = gameid;
		this.matchid = matchid;
		this.dealid = dealid;
		this.txtype = txtype;
		this.amount = amount;
		this.currencyid = currencyid;
		
		String query = String.format(UserSQL.sqlCreateGameTransaction, this.user_id , this.gameid , this.matchid , this.dealid , this.txtype , this.amount , this.currencyid);
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
					if(SpyMemCacheClient.getInstance().IsConnected())
					SpyMemCacheClient.getInstance().add(String.format(key_GameTransactionByID, this.id),  this);
				}
					  
			}
		catch (SQLException e) 
			{
					System.out.println("SQL Exception Code : "+e.getErrorCode());
					System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
					e.printStackTrace();
			}
		
	}
	

}
