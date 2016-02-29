package com.zgljl2012.framework.test.util;

import org.junit.Test;

import com.zgljl2012.framework.email.SendEmail;

/**
 *@author 廖金龙
 *@version 2016年2月27日下午10:23:18
 */
public class TestSendEmail {
	
	@Test
	public void test() throws Exception {
		// dwbpavadujztdcdh
		String toEmail = "1936855897@qq.com";
		String subject = "测试邮件发送";
		String content = "邮件内容";
		SendEmail.send(toEmail, subject,content);
	}
}
