package com.zgljl2012.framework.test.util;

import org.junit.Test;

import com.zgljl2012.framework.util.JSON;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午12:11:25
 */
public class TestJSON {
	
	
	
	@Test
	public void test() {
		JSON j = new JSON();
		
		j.put("a", "1");
		j.put("b", "2");
		j.put("c", "3");
		j.put("d", "4");
		System.out.println(j.toString());
	}
	
	@Test
	public void test1() {
		JSON j = new JSON();
		j.put("d", "4");
		System.out.println(j.toString());
	}
	
	@Test
	public void testObject() {
		JSON j = new JSON();
		A a = new A();
		a.a = 1;
		a.b = "Hello";
		
		j.put("data", a);
		System.out.println(j.toString());
	}
	
	@Test
	public void testInt() {
		JSON j = new JSON();
		j.put("i", 1);
		System.out.println(j);
	}
	
	@Test
	public void testYinhao() {
		String s = "Hello\"World\"";
		s = s.replace("\"", "\\\"");
		System.out.println(s);
	}
	
	@Test
	public void testXiegang() {
		String s = "\\\\hello";
		s = s.replace("\\", "\\\\");
		System.out.println(s);
	}
	
	@Test
	public void testHuanHang() {
		String s = "Hello\r\nWorld";
		JSON j = new JSON();
		j.put("s",s);
		System.out.println(j);
	}
}
