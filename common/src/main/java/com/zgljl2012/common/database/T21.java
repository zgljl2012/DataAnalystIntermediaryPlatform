package com.zgljl2012.common.database;

import java.util.Date;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 分析师——从业经历
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T21 extends AbstractEntity {
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 用户ID
	 */
	public int F02;
	
	/**
	 * 公司名称（30个字）
	 */
	public String F03;
	
	/**
	 * 开始时间
	 */
	public Date F04;
	
	/**
	 * 结束时间
	 */
	public Date F05;
	
	/**
	 * 职务说明
	 */
	public String F06;
}
