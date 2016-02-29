package com.zgljl2012.common.database;

import java.util.Date;

import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 分析师——基本资料
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T20 extends AbstractEntity{
	/**
	 * 用户ID
	 */
	public int F01;
	
	/**
	 * 真实姓名
	 */
	public String F02;
	
	/**
	 * 性别
	 */
	public Gender F03;
	
	/**
	 * 出生日期
	 */
	public Date F04;
	
	/**
	 * 个人简介
	 */
	public String F05;
	
	/**
	 * 就业时间
	 */
	public Date F06;
	
	/**
	 * 毕业院校（限20个字）
	 */
	public String F07;
	
	/**
	 * 当前公司（可选自由职业，限30个字）
	 */
	public String F08;
	
	/**
	 * 头像链接
	 */
	public String F09;
	
}
