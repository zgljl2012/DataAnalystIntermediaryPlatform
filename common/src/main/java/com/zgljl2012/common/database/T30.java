package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

@SuppressWarnings("serial")
/**
 * 企业-资料
 * @author Administrator
 *
 */
public class T30 extends AbstractEntity {
	/**
	 * 用户ID（外键）
	 */
	public int F01;
	
	/**
	 * 公司名称（60个字）
	 */
	public int F02;
	
	/**
	 * 主营业务
	 */
	public String F03;
	
	/**
	 * 备注说明
	 */
	public String F04;
}
