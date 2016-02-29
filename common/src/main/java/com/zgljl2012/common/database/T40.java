package com.zgljl2012.common.database;

import java.util.Date;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 项目单
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T40 extends AbstractEntity{
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 项目名称（限25个字）
	 */
	public String F02;
	
	/**
	 * 价格
	 */
	public float F03;
	
	/**
	 * 发布者（公司/个人）ID
	 */
	public int F04;
	
	/**
	 * 项目状态
	 */
	public T40_F05 F05;
	
	/**
	 * 创建时间
	 */
	public Date F06;
	
	/**
	 * 审核时间
	 */
	public Date F07;
	
	/**
	 * 审核人ID
	 */
	public int F08;
	
	/**
	 * 不通过原因（如果不通过，限25个字）
	 */
	public String F09;
	
	/**
	 * 发布时间
	 */
	public Date F10;
	
	/**
	 * 完成时间
	 */
	public Date F11;
	
	/**
	 * 完成期限（天数）
	 */
	public int F12;
	
	/**
	 * 说明
	 */
	public String F13;
	
	/**
	 * 是否删除
	 */
	public Bool F14;
	
	/**
	 * 中标用户ID
	 */
	public int F15;
}
