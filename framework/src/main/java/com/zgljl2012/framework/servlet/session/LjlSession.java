package com.zgljl2012.framework.servlet.session;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午5:23:03
 *和session的生命周期一样，在session创建时生成，由controller提供
 *所具有的功能有获取用户ID、用户名、用户类型、判断用户是否登录，登出等功能
 */
public interface LjlSession {
	
	/**
	 * 设置用户已登录
	 */
	public void setLogined(boolean is);
	
	/**
	 * 判断是否已登录
	 * @return
	 */
	public boolean isLogined();
	
	/**
	 * 设置用户ID
	 */
	public void setUserId(int uid);
	
	/**
	 * 设置用户名
	 */
	public void setUsername(String username);
	
	/**
	 * 设置用户类型
	 */
	public void setUserType(String userType);
	
	/**
	 * 获取用户ID
	 * @return
	 */
	public int getUserId();
	
	/**
	 * 获取用户名
	 * @return
	 */
	public String getUsername();
	
	/**
	 * 获取用户类型
	 * @return
	 */
	public String getUserType();
	
	/**
	 * 登出
	 */
	public void logout();
}
