/**
 * This class creates a map between a Game Client message and the server side message handler (ActionHandler) method.
 * This map is created by reading the annotations on the AbstractActionHandler methods. 
 * This map helps invoke the server side methods using reflection API, without having to create a manual mapping between
 * messages and their handlers on the server side. 
 */
package com.mango.games.rummy.logic.actions;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;

/**
 * This is loaded once on startup.
 *
 */
public class EventDetails 
{
    private String mesg;
    private String methd;
    
    /** A list of key value pairs that contain the param-name and type */
    private LinkedList<SimpleEntry<String, String>>  params;
    
    public EventDetails(String msg, String mthd)
    {
    	mesg = msg;
    	methd = mthd;
    	
    	params = null;
    }
    
    public void addParam(String name, String type)
    {
    	if( params == null )
    	{
    		params = new LinkedList<SimpleEntry<String, String>>();
    	}
    	
    	SimpleEntry<String, String> newEntry = new SimpleEntry<String, String>(name, type);
    	
    	params.add(newEntry);
    }
    
    public String getMethod()
    {
    	return methd;
    }
    
    public String getMessage()
    {
    	return mesg;
    }
    
    public LinkedList<SimpleEntry<String, String>> getParams()
    {
    	return params;
    }
    
}
