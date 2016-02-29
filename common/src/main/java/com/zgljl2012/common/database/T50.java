package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 投标单
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T50 extends AbstractEntity {
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 项目ID
	 */
	public int F02;
	
	/**
	 * 用户ID
	 */
	public int F03;
	
	/**
	 * 报价
	 */
	public float F04;
	
	/**
	 * 时间戳
	 */
	public Timestamp F05;
	
	/**
	 * 是否删除
	 */
	public Bool F06;
}
