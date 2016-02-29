package com.zgljl2012.common;

import org.junit.Test;

import com.zgljl2012.common.database.enums.Bool;


public class AbstractEnumsTest {
	
	@Test
	public void test() {
		Bool t = Bool.S;
		System.out.println(t.getChineseName());
		
		t = Bool.parse("F");
		System.out.println(t.getChineseName());
	}
	
}
