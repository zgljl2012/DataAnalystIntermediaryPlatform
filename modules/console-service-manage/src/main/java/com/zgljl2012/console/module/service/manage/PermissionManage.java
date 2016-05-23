package com.zgljl2012.console.module.service.manage;

import java.util.List;
import java.util.Map;

import com.zgljl2012.common.database.H20;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年5月22日下午8:17:57
 * 权限管理
 */
public interface PermissionManage extends Service{
	
	/**
	 * 此用户是否有这个访问这个Servlet的权限
	 * @param uid
	 * @param cls
	 * @return
	 */
	boolean isAccessible(int uid, Class<? extends AbstractServlet> cls);
	
	/**
	 * 设置一个用户组的权限
	 * @param gId
	 * @param pIds
	 */
	void setPermission(int gId, int[] pIds);
	
	/**
	 * 获取一个用户组的所有权限
	 * @param gid
	 * @return
	 */
	Map<String, Object> getPermission(int gid);
	
	/**
	 * 获取所有的用户组
	 * @return
	 */
	List<H20> getAllH20();
	
}
