/**
 * Destroy timers, schedulers, seats, bots, and other objects associated with a room.
 * In a static 
 */
package com.mango.games.rummy.logic.common.game;

import com.mango.games.rummy.logic.common.AbstractSTM;
import com.mango.games.rummy.logic.common.IStateChanger;
import com.mangogames.rummy.model.Game;

/**
 * @author Mango6
 *
 */
public class GameEndedSTM extends AbstractSTM 
{

	public GameEndedSTM(IStateChanger stateHolder) 
	{
		super(stateHolder);
	}
	

	public void enterState()
	{
		Game game = (Game)getClientAdapter().getTarget();
		
		game.setMatch(null);
	}
		
}
