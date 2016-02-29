package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.framework.database.AbstractEntity;

@SuppressWarnings("serial")
public class T10 extends AbstractEntity{
	
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 用户名
	 */
	public String F02;
	
	/**
	 * 邮箱
	 */
	public String F03;
	
	/**
	 * 密码
	 */
	public String F04;
	
	/**
	 * 用户类型
	 */
	public T10_F05 F05;
	
	/**
	 * 是否删除
	 */
	public Bool F06;
	
	/**
	 * 注册时间戳
	 */
	public Timestamp F07;
	
	/**
	 * 用户状态
	 */
	public T10_F08 F08;
}
