package com.mango.games.db.manager;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// package Database;

import java.sql.*;

import com.mango.games.db.manager.connectionpool.PoolFactory;


public class DBAccess {

    
    /**
     *
     * @return the resultset for the query
     */
    public static ResultSet ExecQuery(String query) {
        if (query == null) {
            throw new NullPointerException("Query hasn't been initialized");
        }
        try {
        	Connection conn = PoolFactory.getPooling().getConnection();
        	PreparedStatement statement = conn.prepareStatement(query);
        	ResultSet result_query = statement.executeQuery(query);
            return result_query;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        //CloseConnection();
        return null;
    }

    /**
     *
     * @return the number of elements that are modified
     */
    public static Integer ExecUpdate(String update) {
        if (update == null) {
            throw new NullPointerException("Update statement hasn't been initialized");
        }
        try {
        	Connection conn = PoolFactory.getPooling().getConnection();
        	PreparedStatement statement = conn.prepareStatement(update);
            int result_update = statement.executeUpdate(update);
            return result_update;
        } catch (SQLException e) {
        	System.out.println("SQL Exception Code: "+e.getErrorCode());
			System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
			e.printStackTrace();
        }
        return null;
    }
    
//    public static void main(String args[]) {
//    	String query = "SELECT 1 FROM mysql.user";
//    	ResultSet rs = DBAccess.ExecQuery(query);
//    	try {
//    		while(rs.next()) {
//    			System.out.println(rs.getString(1));    			
//    		}
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    }
 
}
