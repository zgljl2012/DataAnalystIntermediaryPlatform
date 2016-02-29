package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 交易-评论表-企业评论分析师
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T70 extends AbstractEntity{
	
	/**
	 * 项目单ID
	 */
	public int F01;

	/**
	 * 企业评论分析师
	 */
	public String F02;

	/**
	 * 企业给分析师评分（5星）
	 */
	public int F03;
}
