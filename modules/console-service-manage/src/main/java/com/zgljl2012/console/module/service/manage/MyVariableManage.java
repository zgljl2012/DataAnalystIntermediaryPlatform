package com.zgljl2012.console.module.service.manage;

import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月17日下午10:40:25
 * 
 */
public interface MyVariableManage extends Service{
	
	/**
	 * 变量列表
	 * @param info
	 * @return
	 */
	JSON getVariableBeanList(String name, PagingInfo info);
	
}
