/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mango.games.db.manager.connectionpool;

/**
 *
 * @author jayanth
 */
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class DbResourceUtil {

    /**
     *
     * @return
     */
    public static DbProperties getDbProperties() {
                
        Locale l = new Locale("en", "IN");
        Locale.setDefault(l);
		ResourceBundle bundle = ResourceBundle.getBundle("com.mango.games.db.manager.connectionpool.db",
				Locale.getDefault());
        System.out.println(bundle.getLocale().toString());
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		String dbUrl = bundle.getString("db_url");
		String driverClass = bundle.getString("driver_class");
		String partitionCount = bundle.getString("partition_count");
		String minConnections = bundle.getString("min_connections");
		String maxConnections = bundle.getString("max_connections");
		String maxIdleTime = bundle.getString("max_idle_time");
		String acquireIncrement = bundle.getString("acquire_increment");

		if (minConnections == null || maxConnections == null) {
			return new DbProperties(username, password, dbUrl, driverClass);
		}
		return new DbProperties(username, password, dbUrl, driverClass,
				new ConnectionProperties(Integer.parseInt(partitionCount),
						Integer.parseInt(minConnections),
						Integer.parseInt(maxConnections),
						Integer.parseInt(maxIdleTime),
						Integer.parseInt(acquireIncrement)));

	}


}
