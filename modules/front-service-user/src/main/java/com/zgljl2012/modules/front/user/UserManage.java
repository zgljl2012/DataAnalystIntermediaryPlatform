package com.zgljl2012.modules.front.user;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.common.database.T11;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.Service;

/**
 * 负责一些基础的用户信息操作:登录、注册
 * @author 廖金龙
 */
public interface UserManage extends Service {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户ID，-1为登录失败
	 * @throws Exception 登录密码或用户名错误就抛出异常
	 */
	public int login(String username, String password) throws Exception;
	
	/**
	 * 注册
	 * @param T10 用户注册信息
	 * @return 用户ID
	 * @throws Exception 注册时出现的异常事件
	 */
	public int register(String username, String password, String email, String userType) throws Exception;
	
	/**
	 * 获取注册验证消息，主要是激活码和时间戳
	 * 选取最后一个时间的记录
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public T11 getRegisterValidate(String email) throws Exception;
	
	/**
	 * 存储注册验证消息
	 * @param t
	 * @throws Exception
	 */
	public void setRegisterValidate(T11 t) throws Exception;
	
	/**
	 * 根据邮件地址获取用户信息
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public T10 getUserByEmail(String email) throws Exception;
	
	/**
	 * 启用用户ID
	 * @param uid 用户ID
	 * @throws Exception
	 */
	public void qyUser(int uid) throws Exception;
	
	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean isUsernameExists(String username) throws Exception;
	
	/**
	 * 检查邮箱是否已存在
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean isEmailExists(String email) throws Exception;
	
	/**
	 * 获取对应用户ID的用户信息
	 * @param uid 用户ID
	 * @return
	 */
	public T10 getT10(int uid) throws Exception;
	
	/**
	 * 修改用户名
	 * @param uid
	 * @param username
	 * @throws Exception
	 */
	public void updateUsername(int uid, String username) throws Exception;
	
	/**
	 * 修改密码
	 * @param uid
	 * @param pwd
	 * @throws Exception
	 */
	public void updatePassword(int uid, String pwd) throws Exception;
	
	/**
	 * 根据用户名获取用户ID
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public int getUidByUsername(String username) throws PostException;
	
}
