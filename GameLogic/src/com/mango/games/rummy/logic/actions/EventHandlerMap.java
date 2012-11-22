package com.mango.games.rummy.logic.actions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mango.games.rummy.utils.Log;

/**
 * This object is loaded once on startup and is used heavily for translating and invoking
 * client events on the server side. This is a singleton class, and should be kept as re-entrant
 * all the time. 
 * 
 * Do not store any state information in this class. 
 * @author Sanjeev
 *
 */
public class EventHandlerMap 
{
	private HashMap<String, EventDetails> _eventDetailsMap;
	private static EventHandlerMap _eventHandlerMap;
	public static final Logger logger = LoggerFactory.getLogger(EventHandlerMap.class);
	
	protected EventHandlerMap()
	{
		_eventDetailsMap = new HashMap<String, EventDetails>();
	}
	
	public static EventHandlerMap getEventHandlerMap() //throws Exception
	{
		if(_eventHandlerMap == null)
		{
			Log.logger.debug("--------EVENT HANDLER INITIALIZED---------");
						
			_eventHandlerMap = new EventHandlerMap();
			try 
			{
				_eventHandlerMap.initialize();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		return _eventHandlerMap;
	}
	
	private void initialize() throws Exception
	{
		parse(new RummyActions().getClass());
	}
	
	
	/**
	 * Initialization routine
	 * @param clazz
	 * @throws Exception
	 */
	private void parse(Class<?> clazz) throws Exception 
	{
        Method[] methods = clazz.getMethods();
        int pass = 0;
        int fail = 0;

	    for (Method method : methods) 
	    {
	        if (method.isAnnotationPresent(AEvent.class)) 
	        {
	            try 
	            {
	            	AEvent evt = method.getAnnotation(AEvent.class);
	            	
	            	EventDetails map = new EventDetails(evt.msg(), method.getName());
	            	//Get parameter annotations and add them to the map.
                    Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                    
                    Class[] parameterTypes = method.getParameterTypes();
                    
                    int i=0;
                    for(Annotation[] annotations : parameterAnnotations)
                    {
                    	Class parameterType = parameterTypes[i++];
                    	
                    	for(Annotation annotation : annotations)
                    	{
                    		if(annotation instanceof AParam)
                    		{
                    			AParam pAnnot = (AParam) annotation;
                    			String paramType = parameterType.getName();
	                            
	                            /** If the type is custom, then store the custom annotated type
	                             * in the type value. This will help us convert the type easily
	                             */
	                            if( paramType.equals("java.lang.Object"))
	                            {
	                            	if(pAnnot.type() != null )
	                            	{
	                            		paramType = pAnnot.type();
	                            	}
	                            }
	                            
	                            map.addParam(pAnnot.name(), paramType);
	                          }
	                      }
                    }
                    
                    pass++;
                    _eventDetailsMap.put(evt.msg(), map);
                    
	            } 
	            catch (Exception e) 
	            {
	                fail++;
	            }
	        }
	    }
	}
	
	public String GetMethodNameFromMessage(String messageName)
	{
		String retVal = null;
		EventDetails map = _eventDetailsMap.get(messageName);
		
		if(map != null)
		{
     		retVal = map.getMethod();
		}
		
		return retVal;
	}
	
	public EventDetails getEventDetailsMap(String messageName)
	{
		EventDetails map = _eventDetailsMap.get(messageName);
	
		return map;
	}
}
