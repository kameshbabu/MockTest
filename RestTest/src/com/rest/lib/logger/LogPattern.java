package com.rest.lib.logger;

/**
 * 
 * LogPattern contains different log pattern to be used for logs.
 * 
 * @version 1.0.1-Beta
 * 
 * @author kamesh babu
 */

public class LogPattern {

	/*
	 * %5p � It writes the level in the log. The �5� in the �%5p� is to set the
	 * width of the field to 5 characters. %d{yyyy-MM-dd HH:mm:ss.SSS}; � It writes
	 * the date in the given date-time format. %t � It writes the method name in the
	 * log. %c � It writes the absolute class name (e.g.com.stackify.log4j_demo.App)
	 * in the log. %m%n � It writes the message in the log. %L � It writes the line
	 * number in the log. %F � It writes the class name in the log.
	 */

	/* Console Patterns */
	final static String CONSOLE_PATTERN1 = "%d{yyyy-MM-dd HH:mm:ss} [ %p | %c | %C{1} ] %m%n";
	final static String CONSOLE_PATTERN2 = "%d{ISO8601} [%t] %-5p %c %x - %m%n";
	final static String CONSOLE_PATTERN3 = "[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %m%n";

	/* File Patterns */
	final static String FILE_PATTERN1 = "%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{1}] %m%n %L";
}