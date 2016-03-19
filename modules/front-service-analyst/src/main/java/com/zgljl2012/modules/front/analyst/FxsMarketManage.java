package com.zgljl2012.modules.front.analyst;

import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.analyst.query.FxsInfoQuery;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午8:15:09
 * 
 */
public interface FxsMarketManage extends Service{
	
	/**
	 * 分页查询所有符合条件的分析师
	 * @param query
	 * @param pagingInfo
	 * @return
	 */
	public JSON search(FxsInfoQuery query, PagingInfo pagingInfo);
	
	/**
	 * 获取分析师总数
	 * @return
	 */
	public int fxsCount(FxsInfoQuery query);
}
