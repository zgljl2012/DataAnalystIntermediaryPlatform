package com.zgljl2012.framework.database;

/**
 * @author 廖金龙
 * @version 2016年3月17日下午8:23:59
 * 分页的信息
 */
public interface PagingInfo {
	
	/**
	 * 获取当前页，页数从1开始数
	 * @return
	 */
	public int getCurrentPage();
	
	/**
	 * 每页数据的条数
	 */
	public int getPageSize();
	
}
