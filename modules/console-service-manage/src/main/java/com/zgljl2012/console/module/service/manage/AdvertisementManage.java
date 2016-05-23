package com.zgljl2012.console.module.service.manage;

import com.zgljl2012.common.database.T80;
import com.zgljl2012.console.module.service.manage.query.AdvertisementQuery;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午5:32:47
 * 广告管理
 */
public interface AdvertisementManage extends Service{
	
	/**
	 * 添加广告
	 * @param query
	 */
	void add(AdvertisementQuery query);
	
	/**
	 * 分页查询
	 * @param info
	 */
	JSON list(PagingInfo info);
	
	/**
	 * 打开一个广告
	 * @param aid
	 * @return
	 */
	T80 detail(int aid);
	
	/**
	 * 下架一个广告
	 * @param aid
	 */
	void xj(int aid);
	
	/**
	 * 删除一个广告
	 * @param aid
	 */
	void sc(int aid);
	
	/**
	 * 上架一个广告
	 * @param aid
	 */
	void sj(int aid);
}
