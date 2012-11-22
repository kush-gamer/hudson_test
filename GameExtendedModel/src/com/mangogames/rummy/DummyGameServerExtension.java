package com.mangogames.rummy;

import com.mango.games.rummy.games.inprogress.GameProxy;
import com.mango.games.rummy.logic.common.IClientAdapter;
/**
 * This is used for simulating the SFS Extension which holds the GameProxy object. This will help
 * in faster, test driven development without SFS Extension in place.
 * @author Sanjeev
 *
 */
public class DummyGameServerExtension 
{

	public GameProxy proxy1;
	public void initialize()
	{
		long id = 12422;
	    proxy1 = new GameProxy();
	    
	    proxy1.createNewGame(id, 4, 101, 1);
	}
	
	public void HandleEvent()
	{
		IClientAdapter adapter = null;
		
		//adapter.handleEvent(params)
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		DummyGameServerExtension ext = new DummyGameServerExtension();
		ext.initialize();
		
		ext.proxy1.getGameId();
	}
}
