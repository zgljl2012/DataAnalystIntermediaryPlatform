package com.zgljl2012.framework.exceptions;

/** 
 * @author 廖金龙
 * @version 2016年2月19日 上午11:55:30 
 * 登录时出现的异常
 */
@SuppressWarnings("serial")
public class LoginException extends AbstractException{
	
	public LoginException(String msg) {
		super(msg);
	}
}
