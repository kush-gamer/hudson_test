/**
 * 
 */
package com.mango.games.rummy.logic.common;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * @author admin
 *
 */
public abstract class AbstractAdapter implements IClientAdapter 
{
	private EObject target;

	/**
	 * 
	 */
	public AbstractAdapter(EObject targ) 
	{
		target = targ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	@Override
	public Notifier getTarget() 
	{
		return target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void setTarget(Notifier newTarget) 
	{
		target = (EObject)newTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) 
	{
		if( type instanceof EObject )
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.common.IClientAdapter#handleTimeout(com.mango.games.rummy.logic.common.timers.TimedAction)
	 */
	@Override
	public int handleTimeout(TimedAction action) throws Exception 
	{
		//This method unravels the event object and call appropriate action in the state machine.
    	int isHandled = 0;
    	
    	//1. Get the current Match and its adapter
    	IClientAdapter childAdapter = getChildAdapter();
    	
    	/**
    	 * Give the child adapter a first shot at the event. The child adapter will give its children
    	 * the first shot at handling the event. This ensures that maximum number of events that happen
    	 * during deal play are directly handled by deal.
    	
    	 */
    	try 
    	{
    		if( childAdapter != null )
    		{
    			isHandled = childAdapter.handleTimeout(action);
    		}
		} 
    	catch (Exception e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
		}
    	
    	/**
    	 * If the event is not handled at  the deal/match level, 
         * then pass on the event to the current stateSTM. 
    	 */
    	if( isHandled == 0 )
    	{
    		IStateChanger stateHolder = getStateHolder();
    		if( stateHolder != null )
    		    isHandled = getStateHolder().getCurrent().timeout(action);
    	}
    	
    	if( isHandled == 0 )
    	{
    		//TODO - Log an error that a message went unhandled.
    		//We should actually throw an exception and capture it in unit test cases.
    		//until all the events are handled.
    	}
    	
    	return isHandled;
	}
	
	@Override
	public void setModelCreationFactory(IModelCreationFactory fc) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setServerResponseManager(ServerResponseManager mgr)
	{
		
	}
	
	/* (non-Javadoc)
	 * @see com.mango.games.rummy.logic.common.IClientAdapter#handleEvent(com.smartfoxserver.v2.entities.data.ISFSObject)
	 */
	@Override
	public int handleEvent(ISFSObject params) throws Exception
    {
    	//This method unravels the event object and call appropriate action in the state machine.
    	int isHandled = 0;
    	//1. Get the current Match and its adapter
    	IClientAdapter childAdapter = getChildAdapter();
    	
    	/**
    	 * Give the child adapter a first shot at the event. The child adapter will give its children
    	 * the first shot at handling the event. This ensures that maximum number of events that happen
    	 * during deal play are directly handled by deal.
    	 */
    	if( childAdapter != null )
    		isHandled = childAdapter.handleEvent(params);
    	
    	/**
    	 * If the event is not handled at the deal/match level, 
         * then pass on the event to the current stateSTM. 
    	 */
    	if( isHandled == 0 )
    	{
    		IStateChanger stateHolder = getStateHolder();
    		if( stateHolder != null )
    	        isHandled = stateHolder.getCurrent().act(params);
    	}
    	
    	if( isHandled == 0 )
    	{
    		//TODO - Log an error that a message went unhandled.
    		//We should actually throw an exception and capture it in unit test cases.
    		//until all the events are handled.
    	}
    	
    	return isHandled;
    }
}
