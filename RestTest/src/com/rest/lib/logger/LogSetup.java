package com.rest.lib.logger;

/**
 * LogSetup initializes the log formats for console and file appenders with given layout patterns.
 * Loggers( Responsible for capturing logging information) + Appenders + Layouts.
 * 
 * @version 1.0.1-Beta
 * 
 * @author kamesh babu
 */

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LogSetup extends LogPattern {
	private static final Logger log = LogManager.getLogger(LogSetup.class.getName());

	/**
	 * 
	 * init method intializes appenders with given layouts pattern. It does
	 * initializes the log look like in console and file appender.
	 * 
	 */
	public static void init() {
		log.info("Log setup initialized with console + file appender, file appender previous log history");
		consoleAppender();
		fileAppender();
		fileAppenderHistory();
	}

	/**
	 * Initializes the console with given layout pattern, sets threshold to Debug so
	 * all the above priority levels will be printed output in logs.
	 * 
	 * Trace < Debug < Info < Warn < Error < Fatal.
	 */
	private static void consoleAppender() {
		ConsoleAppender consoleAppender = new ConsoleAppender(); // create appender
		// configure the appender
		consoleAppender.setLayout(new PatternLayout(CONSOLE_PATTERN1));
		consoleAppender.setThreshold(Level.ERROR);
		consoleAppender.activateOptions();

		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(consoleAppender);
	}

	/**
	 * Initializes the file with given layout pattern under logs folder with
	 * restLog.log with clearing previous log history, sets threshold to "Trace" so
	 * all the above priority levels will be printed output in logs.
	 * 
	 * Trace < Debug < Info < Warn < Error < Fatal.
	 */
	private static void fileAppender() {
		FileAppender fileAppender = new FileAppender();
		fileAppender.setName("FileLogger");
		fileAppender.setFile("logs/restLog.log");
		fileAppender.setLayout(new PatternLayout(FILE_PATTERN1));
		fileAppender.setThreshold(Level.TRACE);
		fileAppender.setAppend(false);
		fileAppender.activateOptions();

		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(fileAppender);
	}

	/**
	 * Initializes the file with given layout pattern under logs folder with
	 * restLog.log without clearing previous log history(appends), sets threshold to
	 * "Trace" so all the above priority levels will be printed output in logs.
	 * 
	 * Trace < Debug < Info < Warn < Error < Fatal.
	 */
	private static void fileAppenderHistory() {
		FileAppender fileAppender = new FileAppender();
		fileAppender.setName("FileLogger");
		fileAppender.setFile("logs/restLogHisotry.log");
		fileAppender.setLayout(new PatternLayout(FILE_PATTERN1));
		fileAppender.setThreshold(Level.TRACE);
		fileAppender.setAppend(true);
		fileAppender.activateOptions();

		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(fileAppender);
	}
}