package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.exceptions.VerifyCodeTimeoutException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.servlet.VerifyCode;
import com.zgljl2012.framework.servlet.VerifyCodeValidate;
import com.zgljl2012.framework.servlet.session.LjlSession;
import com.zgljl2012.framework.util.StringHelper;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午9:01:08
 */
@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends AbstractServlet{

	private static final long serialVersionUID = 1L;
	
	@Impl
	HtUserManage manage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		post(req, res, controller);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		String username = req.getParameter("username"); // 用户名或邮箱
		String password = req.getParameter("password");
		String verifyCode = req.getParameter("verifyCode");
		try{
			if(StringHelper.isEmpty(username)) {
				throw new Exception("用户名不能为空！");
			}
			if(StringHelper.isEmpty(password)) {
				throw new Exception("密码不能为空！");
			}
			if(StringHelper.isEmpty(verifyCode)) {
				throw new Exception("验证码不能为空！");
			}
			VerifyCode vc = (VerifyCode)req.getSession().getAttribute("verifyCode");
			boolean isPass = VerifyCodeValidate.validate(verifyCode, vc);
			if(!isPass) { // 验证码不通过
				throw new PostException("验证码错误，请重新输入");
			}
			int uid = manage.login(username, StringHelper.crypt(password));
			if(uid == -1) {
				throw new PostException("用户名或密码错误，请重新输入！");
			}
			LjlSession ls = controller.getSession(req.getSession());
			ls.setLogined(true);
			ls.setUserId(uid);
			ls.setUsername(username);
			// 跳转到用户中心
			redirect(res, "/console/user");
		} catch (VerifyCodeTimeoutException e) { // 验证码超时
			e.printStackTrace();
			req.setAttribute("username", username);
			req.setAttribute("hint", "验证码超时，请重新输入");
			forward(req, res, "/more/user/login.jsp");
			return;
		} catch (PostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("username", username);
			req.setAttribute("hint", e.getMessage());
			forward(req, res, "/more/user/login.jsp");
			return;
		} 
		
	}

}
