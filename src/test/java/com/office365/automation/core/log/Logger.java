package com.office365.automation.core.log;

import org.apache.log4j.Level;

public class Logger {
	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class);
	static{
		log.setLevel(Level.DEBUG);
	}
}
