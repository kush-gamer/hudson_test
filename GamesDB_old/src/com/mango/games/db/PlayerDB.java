package com.mango.games.db;
import java.sql.*;
import com.mango.games.db.sql.UserSQL;
import com.mango.games.db.manager.DBAccess;

/**
 * PlayerDB - Class to retrieve player profile from DB / Memcached.
 * A player profile contains name, gifts, and other relevant details that are
 * accessed frequently during the game play. These details are cached in memcached for a
 * fixed lifetime (6 hours). The memcached entries are cleared on writes.
 */

/**
 * @author Sanjeev
 *
 */
public class PlayerDB 
{
     
	/** 
	 * Create a new user record in the database.
	 * @return
	 */
	
	
	
	
	public int createFacebookPlayer(String fbId, String fname, String lname, String gender, String email, String dob, String location)
	{
	    //first_name, last_name, email_id, externalid, extsrcid, gender, dob
		//final String queryString = UserSQL.sqlCreatePlayer + ',' + fname + ',' + lname + ',' + email + ',' + fbId + ',' + "1," + gender + ',' +  dob;
		final String queryString = String.format(UserSQL.sqlCreatePlayer, fname, lname, email, fbId, 1, gender, dob);		
		
		
		if(fname==null || gender==null)
			return 0;
		//insert into user (first_name, last_name, emailid, externalid, extsrcid, gender, dob) values ('Suraj', 'R', 'example@xyz.com', '1001', 1, 'Male', '1.2.2012')
		
		int result = DBAccess.ExecUpdate(queryString);
		return result;
	}
	
	public ResultSet getPlayerById(int pid)
	{
		final String queryStr = String.format(UserSQL.sqlGetPlayerById,pid );
		
		ResultSet res = DBAccess.ExecQuery(queryStr);
		return res;
		
	}
	
	
	public ResultSet getPlayerByFbId(int fbid)
	{
		final String queryStr = String.format(UserSQL.sqlGetFacebookId, fbid);
		ResultSet rs = DBAccess.ExecQuery(queryStr);
		return rs;
	}
	
	public void del()
	{
		final String str = "delete from user";
		DBAccess.ExecUpdate(str);
	}

}
