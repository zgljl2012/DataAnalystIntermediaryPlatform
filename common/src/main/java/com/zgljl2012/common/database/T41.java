package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 上传的资源
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T41 extends AbstractEntity{
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 项目ID
	 */
	public int F02;
	
	/**
	 * 存储路径
	 */
	public String F03;
	
	/**
	 * 上传时间
	 */
	public Timestamp F04;
	
	/**
	 * 是否删除
	 */
	public Bool F05;
}
