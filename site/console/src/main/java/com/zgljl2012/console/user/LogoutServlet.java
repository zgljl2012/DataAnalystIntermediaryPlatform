package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午10:09:11
 */
@SuppressWarnings("serial")
@WebServlet(name="logout",urlPatterns={"/logout"})
public class LogoutServlet extends AbstractServlet{

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
		controller.getSession(req.getSession()).logout();
		// 跳转到首页
		controller.redirect(res, "/console/");
	}

}
