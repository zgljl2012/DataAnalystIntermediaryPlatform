package com.zgljl2012.framework.servlet;

import java.util.Date;

import com.zgljl2012.framework.exceptions.VerifyCodeTimeoutException;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午12:46:51
 *验证码验证器
 */
public class VerifyCodeValidate {
	
	/**
	 * 验证码有效时间，默认为30秒
	 */
	public static long validTime = 30*1000;
	
	/**
	 * 验证验证码
	 * @param code 用户输入的验证码
	 * @param verifyCode session中存储的验证码
	 * @return
	 */
	public static boolean validate(String code, VerifyCode verifyCode) 
			throws VerifyCodeTimeoutException {
		Date now = new Date();
		code = code.toUpperCase(); // 转换为大写字母
		if(verifyCode == null) {
			throw new VerifyCodeTimeoutException();
		}
		// 验证码超时
		if(now.getTime() - verifyCode.getDate().getTime() > validTime) {
			throw new VerifyCodeTimeoutException();
		}
		if(code.equals(verifyCode.getCode())) {
			return true;
		}
		return false;
	}
	
}
