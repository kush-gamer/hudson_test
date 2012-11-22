/**
 * 
 */
package com.mango.games.rummy.logic.actions;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.AbstractMap.SimpleEntry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.mango.games.rummy.utils.Log;
import com.mangogames.rummy.model.Card;
import com.mangogames.rummy.model.CardContainer;
import com.mangogames.rummy.model.HandCards;
import com.mangogames.rummy.model.impl.CardImpl;
import com.mangogames.rummy.model.impl.HandCardsImpl;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

/**
 * @author Sanjeev
 * 
 * Do not add or remove methods to this file, as it will be always auto-generated from the interface definition.
 * It will return 0 for all actions. 0 implies action not handled.
 * 
 * This serves as a default action handler for Deal, Match and Game state machines. Each of the individual state machines
 * will override the actions that are valid in those states. For example, a Deal will override Pick/Discard/Declare/Drop actions.
 *
 */
public abstract class DefaultActionHandler extends RummyActions 
{
	/**
	 * This is the key method that translates the client message request into a server method call
	 * on Deal, Match or Game states.
	 * This method uses reflection to invoke the corresponding method for a given message.
	 * The mapping between client message and the server methods is captured as annotations.
	 * 
	 * This method should not be overridden.
	 */
	
	public final int act(ISFSObject sfsObject) throws Exception
	{
		LinkedList<SimpleEntry<String, String>> params;
		
		//1. Get the message name. Use the message name to get the method name from msghandlermap
		String messageName = "";
		
		boolean isServerEvent = sfsObject.getBool("IsServerEvent");
		
		if(isServerEvent == false)
		{
			messageName = sfsObject.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		}
		else
		{
			messageName = sfsObject.getUtfString("MessageName");
		}
		
		int retVal = 0;
		EventDetails map = getEventHandlerMap(messageName);
		//EventDetails map = EventHandlerMap.getEventHandlerMap().getEventDetailsMap(messageName);
		//EventDetails map = EventHandlerMap.getEventHandlerMap().getEventDetailsMap(messageName);
		if( map == null )
		{
			throw new Exception( messageName + " is not a valid message ");
		}
		
	    String methodName = map.getMethod();
	    
	    params = map.getParams();
	    int index = 0;
	      
	    Object arguments[] = new Object[params.size()];
	    
	    //iterate through each item in the list
	    for(Iterator<SimpleEntry<String, String>> i = params.listIterator(); i.hasNext();)
	    {
	    	SimpleEntry<String , String> entry = i.next();
	    	String paramName = entry.getKey(); //Get the data type from SFS object using this
			  
	    	String paramType = entry.getValue();  //This is the parameter type expected by the action handler.
	    	
	    	// extract from SFSObject the value and push into Object array
	    	Object arg = getItemFromSFSData(sfsObject, paramName, paramType);
	    	arguments[index++] = arg;
	    }
	    
	    //Invoke the method. This method will call the appropriate polymorphic implementation
	    retVal = invokeMethod(methodName, this, arguments);
	    
	    return retVal;
	}
	
	private int invokeMethod(String methodName, Object obj, Object... param) throws Exception 
	{
		Integer retVal = 0;
		Object params[] = new Object[param.length];
		
		Class<?> classes[] = new Class[param.length];

		for(int i=0; i<param.length; i++)
		{
			params[i] = param[i];
			classes[i] = params[i].getClass();
			
			if(classes[i].getName().equals("java.lang.Integer"))
			{
				classes[i] = int.class;
			}
			else if(classes[i].getName().equals("java.lang.Long")) 
			{
				classes[i] = long.class;
			}
			else if(classes[i].getName().equals("java.lang.Float")) 
			{
				classes[i] = float.class;
			}
			else if(classes[i].getName().equals("java.lang.Boolean"))
			{
				classes[i] = boolean.class;
			}
			/**
			 * Complex types - Custom annotated ones.
			 */
			else if(classes[i].getName().equals(CardImpl.class.getName()))
			{
				classes[i] = Card.class;
			} 
			else if(classes[i].getName().equals(HandCardsImpl.class.getName()))
			{
				classes[i] = HandCards.class;
			}
		}
		
		Method method = obj.getClass().getMethod(methodName, classes);		
		try
		{
			retVal = (Integer)method.invoke(obj, param);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return retVal.intValue();
	}
	
	private Object getItemFromSFSData(ISFSObject sfsObject, String paramName, String paramType)
	{
		Card dummycard;
		if(paramType.equals("int"))
		{ 
			return sfsObject.getInt(paramName);
		}
		else if(paramType.equals("long")) 
		{
			return sfsObject.getLong(paramName);
		}
		else if(paramType.equals("float")) 
		{
			return sfsObject.getFloat(paramName);
		}
		else if(paramType.equals("boolean"))
		{
			return sfsObject.getBool(paramName);
		}
		else if(paramType.equals("java.lang.String"))
		{
			return sfsObject.getUtfString(paramName);
		}
		else if(paramType.equals(Card.class.getName()))
		{
			Card card = (Card) TransientModelFactory.getFactory().createCard();
			
			ISFSObject sfsCard = sfsObject.getSFSObject("Card");
			
			if(sfsCard != null)
			{
				card.setRank(sfsCard.getInt("Rank"));
				card.setSuit(sfsCard.getInt("Suit"));
			}
			
			return card;
		}
		else if(paramType.equals(HandCards.class.getName())) 
		{
			Log.logger.debug("Getting in to check Slots");
			
			HandCards handCards = (HandCards) TransientModelFactory.getFactory().createHandCards();
			
			EList<EObject> groups = handCards.getGroups();
			
			//TODO: the old framework checks for card size. 
			
			ISFSArray slotsArray = sfsObject.getSFSArray("Slots");
			
			for(int i=0; i<slotsArray.size(); i++)
			{
				ISFSObject obj = slotsArray.getSFSObject(i);
				
				CardContainer group = (CardContainer) TransientModelFactory.getFactory().createGroupCards();
				EList<EObject> groupCards = group.getCard();
				
				ISFSArray cardsArray = obj.getSFSArray("Sequence");
				
				for(int j=0; j<cardsArray.size(); j++)
				{
					ISFSObject cardObj = cardsArray.getSFSObject(j);
					
					Card card = (Card) TransientModelFactory.getFactory().createCard();
					card.setRank(cardObj.getInt("Rank"));
					card.setSuit(cardObj.getInt("Suit"));
			
					groupCards.add(card);
				}
				
				groups.add(group);
			}
			
			return handCards;
		}
		
		return null;
	}
}
