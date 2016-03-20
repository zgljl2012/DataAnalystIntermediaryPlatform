package com.zgljl2012.framework.test.util;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * @author 廖金龙
 * @version 2016年2月29日下午11:59:32
 * 
 */
@SuppressWarnings("serial")
public class A extends AbstractEntity{
	int a;
	String b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
}