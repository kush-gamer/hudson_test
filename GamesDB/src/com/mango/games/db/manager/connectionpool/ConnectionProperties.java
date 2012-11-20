/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mango.games.db.manager.connectionpool;

/**
 *
 * @author jayanth
 */
public class ConnectionProperties {

	private int partitionCount;
	private int minConnections;
    private int maxConnections;
    private int maxIdleTime;
    private int acquireIncrement;


	/**
     * @param minConnections
     * @param maxConnections
     */
    public ConnectionProperties(int minConnections, int maxConnections) {
        this.minConnections = minConnections;
        this.maxConnections = maxConnections;
        this.maxIdleTime = 0;
    }

    /**
     * @param minConnections
     * @param maxConnections
     * @param maxIdleTime
     */
    public ConnectionProperties(int partitionCount, int minConnections, 
    		int maxConnections, int maxIdleTime, int acquireIncrement) {
    	this.partitionCount = partitionCount;
        this.minConnections = minConnections;
        this.maxConnections = maxConnections;
        this.maxIdleTime = maxIdleTime;
        this.acquireIncrement = acquireIncrement;        
    }
    
    /**
     * @return Returns the Partition Count
     */
    public int getPartitionCount() {
		return partitionCount;
	}

    /**
     * @param partitionCount The partition count to set.
     */
	public void setPartitionCount(int partitionCount) {
		this.partitionCount = partitionCount;
	}

    /**
     * @return Returns the maxConnections.
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * @param maxConnections The maxConnections to set.
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * @return Returns the minConnections.
     */
    public int getMinConnections() {
        return minConnections;
    }

    /**
     * @param minConnections The minConnections to set.
     */
    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }

    /**
     * @return Returns the maxIdleTime.
     */
    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    /**
     * @param maxIdleTime The maxIdleTime to set.
     */
    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }
    
    /**
     * @return Returns the Acquire Increment
     */
    public int getAcquireIncrement() {
		return acquireIncrement;
	}
    
    /**
     * @param acquireIncrement The Acquire Increment to set
     */
	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}
}
