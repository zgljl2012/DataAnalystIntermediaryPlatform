package com.zgljl2012.console.module.service.manage.query;

import com.zgljl2012.common.database.enums.T10_F05;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午5:29:44
 * 前台用户查询接口
 */
public interface FrontUserQuery {
	
	public String getUsername();
	
	public T10_F05 getUserType();

}
