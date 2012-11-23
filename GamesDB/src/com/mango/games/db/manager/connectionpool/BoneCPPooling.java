/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mango.games.db.manager.connectionpool;

/**
 *
 * @author jayanth
 */

import com.jolbox.bonecp.*;
import java.sql.Connection;
import java.sql.SQLException;

public class BoneCPPooling implements dbPooling {

    private static BoneCPDataSource bcpds = null;

    private BoneCPPooling() {
        init();
    }
    private static BoneCPPooling boneCPPooling = null;

    /**
     *
     * @return
     */
    public synchronized static BoneCPPooling getInstance() {
        if (boneCPPooling == null) {
        	boneCPPooling = new BoneCPPooling();
            System.out.println("(Bone CP Pooling Class) should hav come only once...");
        }

        return boneCPPooling;
    }

    private void init() {
        DbProperties properties = DbResourceUtil.getDbProperties();
        bcpds = new BoneCPDataSource();
        try {
            bcpds.setDriverClass(properties.getDriverClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // loads the jdbc driver
        bcpds.setJdbcUrl(properties.getDbUrl());
        bcpds.setUsername(properties.getUsername());
        bcpds.setPassword(properties.getPassword());


        if (properties.getConnectionProperties() != null) {
            // the settings below are optional -- bonecp can work with defaults            
        	bcpds.setPartitionCount(properties.getConnectionProperties().getPartitionCount());
            bcpds.setAcquireIncrement(properties.getConnectionProperties().getAcquireIncrement());
            bcpds.setMaxConnectionsPerPartition(properties.getConnectionProperties().getMaxConnections());
            bcpds.setMinConnectionsPerPartition(properties.getConnectionProperties().getMinConnections());
            
        } else {
            //bcpds.setMinPoolSize(DEFAULT_MIN_PROPERTIES);
        	bcpds.setPartitionCount(DEFAULT_PARTITION_SIZE);
            bcpds.setAcquireIncrement(DEFAULT_ACQUIRE_INCREMENT);
            bcpds.setMaxConnectionsPerPartition(DEFAULT_MAX_PROPERTIES);
            bcpds.setMinConnectionsPerPartition(DEFAULT_MIN_PROPERTIES);

        }

        // The DataSource cpds is now a fully configured and usable pooled
        // DataSource ...
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return bcpds.getConnection();
    }

    public Connection getConnection(String userName, String password)
            throws SQLException {
        return bcpds.getConnection(userName, password);
    }
}
