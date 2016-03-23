package com.zgljl2012.framework.database.executor;

import java.sql.ResultSet;

/**
 * @author 廖金龙
 * @version 2016年3月23日下午10:25:05
 * 查询执行者，执行里面的execute方法
 */
public interface SelectExecutor {
	
	/**
	 * 监听器
	 * @param rs
	 */
	public void execute(ResultSet rs);
}
