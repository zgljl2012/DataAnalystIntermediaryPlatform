package com.zgljl2012.modules.project.query;

import com.zgljl2012.common.database.enums.T40_F05;

/**
 * @author 廖金龙
 * @version 2016年4月20日下午9:19:08
 * 项目状态的分页查询
 */
public interface ProjectStatusPaggingQuery {
	
	/**
	 * 项目状态
	 * @return
	 */
	public T40_F05 getStatus();
	
	/**
	 * 当前页
	 * @return
	 */
	public int current();
	
	/**
	 * 每页大小
	 * @return
	 */
	public int pageSize();
}
