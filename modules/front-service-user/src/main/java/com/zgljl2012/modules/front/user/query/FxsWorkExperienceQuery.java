package com.zgljl2012.modules.front.user.query;

import java.util.Date;

/**
 * @author 廖金龙
 * @version 2016年3月16日下午9:08:05
 * 分析师工作经历查询接口
 */
public interface FxsWorkExperienceQuery {
	
	public String getCompanyName();
	
	public Date getStartDate();
	
	public Date getFinishedDate();
	
	public String getRemark();
	
}
