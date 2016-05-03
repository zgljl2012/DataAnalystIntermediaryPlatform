package com.zgljl2012.modules.project.query;

import com.zgljl2012.common.database.enums.T40_F05;

/**
 * @author 廖金龙
 * @version 2016年4月25日下午11:12:00
 * 
 */
public interface ProjectListIndeQuery {
	/**
	 * 项目状态
	 * @return
	 */
	public T40_F05 getStatus();
	
	/**
	 * 薪酬最高值
	 * @return
	 */
	public int getSalaryRange();
	
	/**
	 * 评分
	 * @return
	 */
	public int getStar();
	
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
