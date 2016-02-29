package com.zgljl2012.framework.exceptions;

import com.zgljl2012.framework.enums.EnumException;

/** 
 * @author 廖金龙
 * @version 2016年2月19日 上午11:54:18 
 * 抽象异常类
 */
@SuppressWarnings("serial")
public abstract class AbstractException extends Exception{
	
	public AbstractException(String msg) {
		super(msg);
	}
	
	EnumException exception = null;
	
	public AbstractException(EnumException ex) {
		exception = ex;
	}
	
	public EnumException getException() {
		return exception;
	}
	
	@Override
	public String getMessage() {
		// 子类可通过异常的枚举值来给出返回消息
		return super.getMessage();
	}
}
