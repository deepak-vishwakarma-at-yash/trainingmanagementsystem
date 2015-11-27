package com.yash.tmp.log;

import org.apache.log4j.Logger;

public class LoggerProvider {

	static final private Logger LOGGER = Logger.getLogger(LoggerProvider.class.getName());
	
	public static Logger getLogger(){
		return LOGGER;
	}
	
	
}
