package com.zgljl2012.modules.front.user;

import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.user.query.QyUpdateQuery;

/**
 * @author 廖金龙
 * @version 2016年3月26日下午10:24:22
 * 企业管理接口
 */
public interface QyManage extends Service{
	
	/**
	 * 获取企业信息
	 * @param uid
	 * @return
	 */
	public JSON getQyInfo(int uid) throws Exception;
	
	/**
	 * 更新企业信息
	 * @param uid
	 * @param query
	 */
	public void updateQyInfo(int uid, QyUpdateQuery query) throws Exception;
	
}
