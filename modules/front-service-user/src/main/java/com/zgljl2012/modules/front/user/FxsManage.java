package com.zgljl2012.modules.front.user;

import com.zgljl2012.common.database.T20;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.modules.front.user.query.T20Query;

/**
 * @author 廖金龙
 * @version 2016年2月29日上午10:05:23
 * 分析师用户管理
 */
public interface FxsManage extends Service{
	
	/**
	 * 根据T20Query里的内容，更新T20
	 * @param uid
	 * @param query
	 * @throws Exception 
	 */
	public void update(int uid, T20Query query) throws Exception;
	
	/**
	 * 获取分析师基本信息 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public T20 getT20(int uid) throws Exception;
	
}
