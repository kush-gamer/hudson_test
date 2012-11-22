/**
 * 
 */
package com.mango.games.rummy.logic.common;

import org.eclipse.emf.common.notify.Adapter;

import com.mango.games.rummy.logic.actions.EventHandlerMap;
import com.mango.games.rummy.logic.common.timers.TimedAction;
import com.mango.games.rummy.model.IModelCreationFactory;
import com.mango.games.rummy.utils.ITimerScheduler;
import com.smartfoxserver.v2.entities.data.ISFSObject;

/**
 * Wraps the EMF adapter interface with some MangoGames specific functionality. 
 * The client adapters have statemachines to execute game logic at different states.
 * The state machines need to implement a chain of command model to execute 
 * client events. Hence the client adapter needs to identify the next adapter (and its STM) to delegate 
 * the action to that adapter.
 * @author Sanjeev
 *
 */
public interface IClientAdapter extends Adapter, ITimerCallable
{
	
	/**
	 * Client adapters have statemachines to execute game logic. Each adapter can delegate execution of
	 * action to its child adapters (statemachine in the child adapters). 
	 * For example - A GameAdapter may delegate the event handling to a MatchAdapter 
	 * @return
	 */
	public int                   handleEvent(ISFSObject params) throws Exception;
	public int                   handleTimeout(TimedAction action) throws Exception;
	public ServerResponseManager getServerResponseManager();
	public void                  setServerResponseManager(ServerResponseManager mgr);
	
	public IModelCreationFactory getModelFactory();
	public void                  setModelCreationFactory(IModelCreationFactory fc);
	public ITimerScheduler       getTimerScheduler();
	public IStateChanger 		 getStateChanger();
	
	public IClientAdapter        getChildAdapter();
	public IStateChanger         getStateHolder();
	
	public EventHandlerMap       getEventHandlerMap();
	public void				     setEventHandlerMap(EventHandlerMap eventHandlerMap);
}
