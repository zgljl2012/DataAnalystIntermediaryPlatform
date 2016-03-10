package com.zgljl2012.framework.simple.log;

import org.apache.log4j.Logger;

import com.zgljl2012.framework.log.AbstractLog;

/**
 * @author 廖金龙
 * @version 2016年3月10日下午9:08:17
 * 使用Log4j进行日志记录
 */
public class LogSimple implements AbstractLog{
	
	private static Logger logger = Logger.getLogger(LogSimple.class);
	
	@Override
	public void console(String s) {
		// TODO Auto-generated method stub
		logger.info(s);
	}

	@Override
	public void debug(String s) {
		// TODO Auto-generated method stub
		logger.debug(s);
	}

	@Override
	public void error(String error) {
		// TODO Auto-generated method stub
		logger.error(error);
	}

}
