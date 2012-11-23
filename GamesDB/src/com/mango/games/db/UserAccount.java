package com.mango.games.db;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;


@SuppressWarnings("serial")
public class UserAccount implements Serializable
{
	private long id;
	private int chips;
	private int gold;
	private int experience;
	private int level;
	private String lastlogin;
	private int invitebonus;
	private long user_id;
	private static final String key_UserAccountByUserID = "UserAccountByUserID:%d";
	
	
	public UserAccount()
	{
		
	}
	
	public String toString() 
	{
		String toreturn = "USER Account: %d, %d, %d, %d, %d, %s, %d, %d";
		return String.format(toreturn, this.id, this.chips, this.gold, 
				this.experience, this.level, this.lastlogin, this.invitebonus, 
				this.user_id);
	}

	public int getChips() {
		return chips;
	}

	public int setChips(int chips) {
		return this.chips = chips;
	}

	public int getGold() {
		return gold;
	}

	public int setGold(int gold) {
		return this.gold = gold;
	}

	public int getExperience() {
		return experience;
	}

	public int setExperience(int experience) {
		return this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public int setLevel(int level) {
		return this.level = level;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public String setLastlogin(String lastlogin) {
		return this.lastlogin = lastlogin;
	}

	public int getInvitebonus() {
		return invitebonus;
	}

	public int setInvitebonus(int invitebonus) {
		return this.invitebonus = invitebonus;
	}

	public long getUser_id() {
		return user_id;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserAccount(long user_id)
	{
		this.user_id = user_id;
		
		String query = String.format(UserSQL.sqlCreateUserAccountDefault,this.user_id);
				
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
							
							SpyMemCacheClient.getInstance().add(String.format(UserAccount.key_UserAccountByUserID, this.user_id),  this);
						}
						conn.close();
							  
					}
				catch (SQLException e) 
					{
							System.out.println("SQL Exception Code : "+e.getErrorCode());
							System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
							e.printStackTrace();
					}	
	}
	
	
	/**
	 * DB Access methods
	 * @param chips
	 * @param gold
	 * @param experience
	 * @param level
	 * @param lastlogin
	 * @param invitebonus
	 * @param user_id
	 */
	
	public UserAccount(int chips, int gold, int experience, int level, String lastlogin, int invitebonus, long user_id)
	{
		
		this.chips = chips;
		this.gold = gold;
		this.experience = experience;
		this.level = level;
		this.lastlogin = lastlogin;
		this.invitebonus = invitebonus;
		this.user_id = user_id;
		
		String query = String.format(UserSQL.sqlCreateUserAccount, this.chips, 
				this.gold, this.experience, this.level, this.lastlogin, 
				this.invitebonus, this.user_id);
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
							this.id = result_set.getInt("id");
							if(SpyMemCacheClient.getInstance().IsConnected())
								SpyMemCacheClient.getInstance().add(String.format(UserAccount.key_UserAccountByUserID, this.user_id),  this);
						}
						conn.close();
							  
					}
				catch (SQLException e) 
					{
							System.out.println("SQL Exception Code : "+e.getErrorCode());
							System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
							e.printStackTrace();
					}
		
	}
	
	
	/*public static UserAccount getUserAccountbyID(long id) 
	{

		//String query = "select * from useraccount where id=%d";
		String query = String.format(UserSQL.sqlGetUserAccountById, id);
		System.out.println(query);
		try {
			ResultSetHandler<UserAccount> h = new BeanHandler<UserAccount>(UserAccount.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			UserAccount useraccount = new UserAccount(); 
			useraccount = 	run.query(conn, query, h);
			System.out.println(useraccount.toString());
			conn.close();
			return useraccount;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return null;
	}*/
	
	public static UserAccount getUserAccountbyUserID(long userid)
	{
		UserAccount useraccount = null; 
		if(SpyMemCacheClient.getInstance().IsConnected())
			useraccount= (UserAccount)SpyMemCacheClient.getInstance().get(String.format(UserAccount.key_UserAccountByUserID , userid));
		if(useraccount == null)
		{
			String query = String.format(UserSQL.sqlGetUserAccountByUserID, userid);
			System.out.println("User Acc Query : "+query);
			try {
				ResultSetHandler<UserAccount> h = new BeanHandler<UserAccount>(UserAccount.class);
				Connection conn = PoolFactory.getPooling().getConnection();
				QueryRunner run = new QueryRunner();
				useraccount = run.query(conn, query, h);
				System.out.println("User Account Details : "+useraccount.toString());
				conn.close();
				//System.out.println(useraccount.toString());
				return useraccount;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Mem Cache used");
		}
		return useraccount;
		
	}
	
	public void update()
	{
		if(SpyMemCacheClient.getInstance().IsConnected())
			SpyMemCacheClient.getInstance().delete(String.format(UserAccount.key_UserAccountByUserID, this.user_id));
		
		String query = String.format(UserSQL.sqlUpdateUserAccount, this.chips , this.gold, this.experience ,this.level , this.lastlogin , this.invitebonus , this.id);
		System.out.println(query);
		Connection conn;
		try {
			conn = PoolFactory.getPooling().getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(query);
			conn.close();
			
		} 
		catch (SQLException e) 
		{
				System.out.println("SQL Exception Code : "+e.getErrorCode());
				System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
				e.printStackTrace();
		}
		
	}
}
