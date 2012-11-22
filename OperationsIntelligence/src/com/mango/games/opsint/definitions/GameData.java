package com.mango.games.opsint.definitions;

import com.mango.games.db.GameDefinition;

public class GameData {
	
	private GameDefinition gamedefinition;
	private int incrementCount;
	private int minimumNumberOfRooms;
	private int currentNumberOfRooms;
	
	
	public GameData(GameDefinition gd) {
		this.gamedefinition = gd;
		this.incrementCount = DefaultConstants.INCREMENTCOUNT;
		this.minimumNumberOfRooms = DefaultConstants.MINNUMBEROFROOMS;
		this.currentNumberOfRooms = 0;		
	}

	public GameDefinition getGamedefinition() {
		return gamedefinition;
	}


	public void setGamedefinition(GameDefinition gamedefinition) {
		this.gamedefinition = gamedefinition;
	}


	public int getIncrementCount() {
		return incrementCount;
	}


	public void setIncrementCount(int incrementCount) {
		this.incrementCount = incrementCount;
	}


	public int getMinimumNumberOfRooms() {
		return minimumNumberOfRooms;
	}


	public void setMinimumNumberOfRooms(int minimumNumberOfRooms) {
		this.minimumNumberOfRooms = minimumNumberOfRooms;
	}


	public int getCurrentNumberOfRooms() {
		return currentNumberOfRooms;
	}


	public void setCurrentNumberOfRooms(int currentNumberOfRooms) {
		this.currentNumberOfRooms = currentNumberOfRooms;
	}
}
