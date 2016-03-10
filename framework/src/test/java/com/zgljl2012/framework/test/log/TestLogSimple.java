package com.zgljl2012.framework.test.log;

import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.log.AbstractLog;
import com.zgljl2012.framework.simple.log.LogSimple;

/**
 * @author 廖金龙
 * @version 2016年3月10日下午9:10:45
 * 
 */
public class TestLogSimple {
	
	AbstractLog log = new LogSimple();
	
	@Before
	public void before(){
		log.console("start...");
	}
	
	@Test
	public void test() {
		log.debug("debug info");
		log.error("error info");
	}
}
