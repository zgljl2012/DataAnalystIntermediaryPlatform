package com.zgljl2012.front.test;

import org.junit.Test;

/**
 * @author 廖金龙
 * @version 2016年3月27日下午7:22:31
 * 
 */
public class TestException {
	
	public void test() throws Exception {
		throw new Exception("test");
	}
	
	@Test
	public void exceptions() {
		try {
			test();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
