package com.zgljl2012.modules.project.query;

import java.sql.Date;

/**
 * @author 廖金龙
 * @version 2016年4月14日下午9:14:30
 * 项目基本信息查询接口，此接口更新项目基本信息，用于新增和修改项目信息
 */
public interface ProjectBaseInfoQuery {
	
	/**
	 * 项目名称
	 * @return
	 */
	public String getProjectName();
	
	/**
	 * 意向价格
	 * @return
	 */
	public float getWillPrice();
	
	/**
	 * 招标天数
	 * @return
	 */
	public int getBidDays();
	
	/**
	 * 希望完成日期
	 * @return
	 */
	public Date getFinishDate();
	
	/**
	 * 项目描述
	 * @return
	 */
	public String getDescription();
}
