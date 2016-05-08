package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 交易-评论表-分析师评论企业
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T71 extends AbstractEntity{
	
	/**
	 * 项目单ID
	 */
	public int F01;

	/**
	 * 分析师评论企业
	 */
	public String F02;

	/**
	 * 分析师给企业评分（5星）
	 */
	public float F03;
}
