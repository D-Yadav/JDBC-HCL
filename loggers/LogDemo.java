package com.hcl.loggers;
import org.apache.log4j.Logger;

    public class LogDemo {
	static Logger logger=Logger.getLogger(LogDemo.class);
	public static void main(String[] args) {
	int a,b,c;
	try {
	a=Integer.parseInt(args[0]);
	b=Integer.parseInt(args[1]);
	c=a/b;
	System.out.println(c);
	} catch (NumberFormatException e){
	logger.error(e.getMessage());
	logger.debug(e.getMessage());
	logger.fatal(e.getMessage());
	logger.info(e.getMessage());
	logger.isInfoEnabled();
	logger.trace(e.getMessage());
	}
	}

	}
	

