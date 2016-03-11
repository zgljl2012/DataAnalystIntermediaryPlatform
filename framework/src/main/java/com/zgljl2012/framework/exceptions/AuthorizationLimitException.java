package com.zgljl2012.framework.exceptions;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:34:17
 * 权限受限的异常
 */
@SuppressWarnings("serial")
public class AuthorizationLimitException extends AbstractException{

	public AuthorizationLimitException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
