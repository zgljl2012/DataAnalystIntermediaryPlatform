package com.zgljl2012.framework.database.executor;

/**
 * @author 廖金龙
 * @version 2016年3月23日下午10:30:05
 * 
 */
public interface UpdateExecutor {
	
	/**
	 * 返回更新的条数
	 * @param rows
	 */
	public void execute(int rows);
	
}
