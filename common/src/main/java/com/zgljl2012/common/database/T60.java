package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 站内信
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T60 extends AbstractEntity{
	
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 发信人：用户ID
	 */
	public int F02;
	
	/**
	 * 收信人：用户ID
	 */
	public int F03;
	
	/**
	 * 时间戳
	 */
	public Timestamp F04;
	
	/**
	 * 标题，仅限10字
	 */
	public String F05;
	
	/**
	 * 是否已读
	 */
	public Bool F06;
	
	/**
	 * 是否删除
	 */
	public Bool F07;
}
