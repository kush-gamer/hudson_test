/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mango.games.rummy.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author jayanth
 */
public class Log {

	/**
	 * Logger, level set at info
	 */
	public static Logger logger = Logger.getRootLogger();

	public static boolean isConfigured = false;

	/**
	 * Configure the logger. To be called before anything else
	 */
	public static void ConfigureLogger() {

		if (!isConfigured) {
			// isConfigured = true;
			// PropertyConfigurator.configure("GameLogic/config/log4j.properties");
			// logger.setLevel(Level.DEBUG);
			// logger.info("logging initialized");

			ConsoleAppender console = new ConsoleAppender(); // create appender
			// configure the appender
			String PATTERN = "%d %-5p [%t] %-17c{2} (%13F:%L) %3x - %m%n";
			console.setLayout(new PatternLayout(PATTERN));
			console.setThreshold(Level.DEBUG);
			console.activateOptions();
			// add appender to any Logger (here is root)
			Logger.getRootLogger().addAppender(console);

			FileAppender daily = new FileAppender();
			// configure the appender
			String DATEPATTERN = "'.'yyyy-MM-dd-HH-mm";
			daily.setName("filelogger");
			daily.setFile("__lib__/run.log");
			daily.setLayout(new PatternLayout(PATTERN));
			daily.setThreshold(Level.DEBUG);
			daily.setAppend(true);
			try {
				daily.setWriter(new FileWriter("__lib__/run.log"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			DailyRollingFileAppender daily = new DailyRollingFileAppender();
////			// configure the appender
//			String DATEPATTERN = "'.'yyyy-MM-dd";
//			daily.setName("filelogger");
//			daily.setFile("__lib__/run.log");
//			daily.setLayout(new PatternLayout(PATTERN));
//			daily.setDatePattern(DATEPATTERN);
//			daily.setThreshold(Level.DEBUG);
//			daily.setAppend(true);
//			try {
//				daily.setWriter(new FileWriter("__lib__/run.log"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			// add appender to any Logger (here is root)
			Logger.getRootLogger().addAppender(daily);
			
			isConfigured = true;
		}
	}

}
