package com.zgljl2012.framework.test.util;

import junit.framework.Assert;

import org.junit.Test;

import com.zgljl2012.framework.util.StringHelper;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午1:05:46
 */
public class TestStringHelper {
	
	@Test
	public void testCrypt() {
		String pwd1 = "Hello";
		String pwd2 = "Hello";
		String m1 = StringHelper.crypt(pwd1);
		System.out.println(m1.length());
		System.out.println(StringHelper.checkPwd(pwd2, m1));
	}
	
	@Test
	public void asteriskRealName() {
		String s = "廖金龙";
		System.out.println(StringHelper.asteriskRealName(s));
		Assert.assertEquals("廖**", StringHelper.asteriskRealName(s));
	}
	
	@Test
	public void asteriskEmail() {
		String s = "223344@qq.com";
		System.out.println(StringHelper.asteriskEmail(s));
	}
}
