package com.zgljl2012.console.module.service.manage;

import com.zgljl2012.console.module.service.manage.query.FrontUserQuery;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午4:23:35
 * 后台用户管理
 */
public interface HtUserManage extends Service{
	
	public int login(String username, String password) throws PostException;

	public void updatePassword(int userId, String crypt) throws Exception;
	
	/**
	 * 分页查询T10
	 * @param query
	 * @param info
	 * @return
	 */
	public JSON frontUser(FrontUserQuery query, PagingInfo info);
	
	/**
	 * 分页查询T21
	 * @param info
	 * @return
	 */
	public JSON consoleUser(PagingInfo info);
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void scUser(int uid);
	
	/**
	 * 恢复用户
	 * @param uid
	 */
	public void uscUser(int uid);
	
	/**
	 * 将用户加入黑名单
	 * @param uid
	 */
	public void hmdUser(int uid);
	
	/**
	 * 将用户移出黑名单
	 * @param uid
	 */
	public void uhmdUser(int uid);
	
	/**
	 * 删除后台用户
	 * @param uid
	 */
	public void scConsoleUser(int uid);
}
