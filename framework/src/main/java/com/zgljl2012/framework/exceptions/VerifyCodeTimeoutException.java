package com.zgljl2012.framework.exceptions;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午1:31:59
 */
public class VerifyCodeTimeoutException extends Exception{

	private static final long serialVersionUID = -4286911742541081725L;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "验证码超时";
	}
}
