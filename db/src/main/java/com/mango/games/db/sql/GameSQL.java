package com.mango.games.db.sql;

public class GameSQL 
{

	public static final String sqlCreateGame = "insert into game (definitionid , prizeid) " +
			"values(%d , %d)";
	
	public static final String sqlCreateGameDealer = "insert into gamedealer (gameid , matchid , dealid) " +
			"values(%d , %d ,%d)";
}
