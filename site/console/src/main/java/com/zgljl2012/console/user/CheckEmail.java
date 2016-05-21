package com.zgljl2012.console.user;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.user.UserManage;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午12:39:18
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/checkEmail"}, name="CheckEmail")
public class CheckEmail extends AbstractServlet{
	@Impl
	UserManage manage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception{
		// TODO Auto-generated method stub
		post(req, res, controller);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		String username = req.getParameter("email");
		boolean is = manage.isEmailExists(username);
		JSON json = new JSON();
		if(is) {
			json.put("result", "1");
		} else {
			json.put("result", "0");
		}
		PrintWriter out = res.getWriter();
		out.print(json.toString());
	}

}
