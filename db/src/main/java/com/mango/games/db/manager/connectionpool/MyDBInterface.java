/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mango.games.db.manager.connectionpool;

/**
 *
 * @author jayanth
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;


public class MyDBInterface {

    Connection connection;

	/**
	 *
	 */
	public MyDBInterface() {
		// TODO Auto-generated constructor stub
	}



        /**
         *
         */
        public void EstablishConnection()
	{
		try {
			connection = PoolFactory.getPooling().getConnection() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

        /**
         *
         * @param query
         * @return
         */
        public ResultSet executeQuery(String query)
	{
	  try {
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
	}


}
