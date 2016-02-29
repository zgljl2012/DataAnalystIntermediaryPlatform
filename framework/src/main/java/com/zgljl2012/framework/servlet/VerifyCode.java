package com.zgljl2012.framework.servlet;

import java.util.Date;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午12:40:28
 * 验证码
 */
public class VerifyCode {
	
	/**
	 * 验证码
	 */
	private String code;
	
	/**
	 * 生成时间
	 */
	private Date date = new Date();
	
	public VerifyCode(String code) {
		this.code = code.toUpperCase(); // 有字母就转换为大写字母
	}

	public String getCode() {
		return code;
	}

	public Date getDate() {
		return date;
	}
	
}
