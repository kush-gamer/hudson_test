package com.mango.games.rummy.utils;

public interface ITimerScheduler 
{
    public static int GAME_STARTING = 1001;
    public static int SHUFFLE       = 1002;
    public static int TURN          = 1003;
    public static int SHOW_INIT     = 1004;
    public static int SHOW          = 1005;
    public static int SCORECARD     = 1006;
    public static int BOTSEAT       = 1007;
    public static int BOTPICK       = 1008;
    public static int BOTDISCARD    = 1009;
    public static int BOTSHOW    	= 1010;
	public static int MATCH_ENDING	= 1011;
    
	public void scheduleTimeout(long millis, int seq);
	public void schedulePlayerTimeout(long millis, long pid, int seq);
	public void clearTimeout(long pid);
}
