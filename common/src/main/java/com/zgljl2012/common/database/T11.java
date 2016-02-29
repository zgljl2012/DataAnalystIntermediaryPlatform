package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.framework.database.AbstractEntity;

@SuppressWarnings("serial")
public class T11 extends AbstractEntity{
	
	/**
	 * 用户ID 
	 */
	public int F01;
	
	/**
	 * 邮箱地址
	 */
	public String F02;
	
	/**
	 * 激活码
	 */
	public String F03;
	
	/**
	 * 时间戳
	 */
	public Timestamp F04;
}
