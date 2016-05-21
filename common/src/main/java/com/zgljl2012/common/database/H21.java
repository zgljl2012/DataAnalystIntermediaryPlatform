package com.zgljl2012.common.database;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午3:02:27
 * 后台用户表
 */
public class H21 {
	
	/**
	 * 用户ID
	 */
	public int F01;
	
	/**
	 * 用户组ID
	 */
	public int F02;
	
	/**
	 * 用户名
	 */
	public String username;
	
	/**
	 * 密码
	 */
	public String password;
	
	public int getF01() {
		return F01;
	}

	public void setF01(int f01) {
		F01 = f01;
	}

	public int getF02() {
		return F02;
	}

	public void setF02(int f02) {
		F02 = f02;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
