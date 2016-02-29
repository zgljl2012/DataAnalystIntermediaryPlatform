package com.zgljl2012.framework.simple.servlet.session;

import com.zgljl2012.framework.servlet.session.LjlSession;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午5:42:49
 */
public class LjlSessionSimple implements LjlSession{
	
	private boolean logined = false;
	
	private int uid;
	
	private String username;
	
	private String userType;

	public boolean isLogined() {
		// TODO Auto-generated method stub
		return logined;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return uid;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void logout() {
		// TODO Auto-generated method stub
		logined = false;
		username = null;
		userType = null;
		uid = -1;
	}

	public void setLogined(boolean is) {
		// TODO Auto-generated method stub
		logined = is;
	}

	public void setUserId(int uid) {
		// TODO Auto-generated method stub
		this.uid = uid;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	public void setUserType(String userType) {
		// TODO Auto-generated method stub
		this.userType = userType;
	}

	public String getUserType() {
		// TODO Auto-generated method stub
		return userType;
	}

}
