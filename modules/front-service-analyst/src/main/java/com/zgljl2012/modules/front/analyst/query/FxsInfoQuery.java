package com.zgljl2012.modules.front.analyst.query;

import com.zgljl2012.common.database.enums.Degree;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午8:07:59
 * 分析师信息查询接口
 */
public interface FxsInfoQuery {
	
	/**
	 * 学历要求
	 * @return
	 */
	public Degree getDegree();
	
	/**
	 * 从业时间，以年为单位
	 * @return
	 */
	public int getWorkTime();
	
	/**
	 * 分数要求
	 * @return
	 */
	public float getGrade();
	
}
