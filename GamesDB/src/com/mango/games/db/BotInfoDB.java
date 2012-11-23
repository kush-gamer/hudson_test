package com.mango.games.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.DBAccess;
import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.memcache.SpyMemCacheClient;
import com.mango.games.db.sql.UserSQL;

@SuppressWarnings("serial")
public class BotInfoDB implements Serializable
{
	private int id;
	private String first_name;
	private String last_name;
	private String emailid;
	private Date date_joined;
	private String externalid;
	private int extsrcid = 2; 
	private String gender;
	private String dob;
	private int instance;
	
	private static final String key_BotInfoByID = "BOTINFOByID : %d";
	
	
	public BotInfoDB()
	{
		
	}
	
	public BotInfoDB(String f_name, String l_name, String email, String exterid, String gender, String dob)
	{
		this.first_name = f_name;
		this.last_name = l_name;
		this.emailid = email;
		this.externalid = exterid;
		this.gender = gender;
		this.dob = dob;
		String query = String.format(UserSQL.sqlCreateBotInfo, this.first_name , this.last_name , this.emailid , this.externalid , this.extsrcid , this.gender , this.dob);
		
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection();
				String autogenColumns[] = {"id"};
				Statement statement = conn.createStatement();
				statement.executeUpdate(query, autogenColumns);
								
				ResultSet result_set = statement.getGeneratedKeys();
				if(result_set.first())
				{
					System.out.println("Result Set : "+result_set.getLong(1));
					this.id = result_set.getInt(1);
					//SpyMemCacheClient.getInstance().add(String.format(key_BotInfoByID, this.id), this);
				}
		}
		catch (SQLException e) 
		{
			System.out.println("SQL Exception Code : "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	public static BotInfoDB getNextAvailable()
	{
		BotInfoDB botObj = null;
		String query = UserSQL.sqlGetNextAvailableBot;
		try
		{
			ResultSetHandler<BotInfoDB> h = new BeanHandler<BotInfoDB>(BotInfoDB.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			botObj = run.query(conn, query, h);
			
			System.out.println(botObj.toString());
			return botObj;
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return botObj;
	}
	
	public void Engage()
	{
		String query = String.format(UserSQL.sqlEngageBot, this.id);
		DBAccess.ExecUpdate(query);
	}
	
	public void Release()
	{
		String query = String.format(UserSQL.sqlReleaseBot, this.id);
		if(this.instance > 0)
		{
			DBAccess.ExecUpdate(query);
		}
		else
		{
			System.out.println("ERROR : Bot Instance Value is Less Than Zero");
		}
	}
	
	public void ReleaseAll()
	{
		DBAccess.ExecUpdate(UserSQL.sqlReleaseAllBot);
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the date_joined
	 */
	public Date getDate_joined() {
		return date_joined;
	}
	/**
	 * @param date_joined the date_joined to set
	 */
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	/**
	 * @return the externalid
	 */
	public String getExternalid() {
		return externalid;
	}
	/**
	 * @param externalid the externalid to set
	 */
	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}
	/**
	 * @return the extsrcid
	 */
	public int getExtsrcid() {
		return extsrcid;
	}
	/**
	 * @param extsrcid the extsrcid to set
	 */
	public void setExtsrcid(int extsrcid) {
		this.extsrcid = extsrcid;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the instance
	 */
	public int getInstance() {
		return instance;
	}
	/**
	 * @param instance the instance to set
	 */
	public void setInstance(int instance) 
	{
		this.instance = instance;
	}
}
