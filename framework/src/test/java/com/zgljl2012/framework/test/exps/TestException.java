package com.zgljl2012.framework.test.exps;

import org.junit.Test;

import com.zgljl2012.framework.exceptions.VerifyCodeTimeoutException;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午4:38:45
 */
public class TestException {
	
	@Test
	public void test() {
		try {
			throw new VerifyCodeTimeoutException();
		} catch(VerifyCodeTimeoutException e) {
			System.out.println("VerifyCodeTimeoutException");
		} catch(Exception e) {
			System.out.println("Exception");
		}
		
	}
}
