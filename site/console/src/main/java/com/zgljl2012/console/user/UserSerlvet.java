package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午4:30:51
 * 用户管理
 */
@SuppressWarnings("serial")
@WebServlet(name="user", urlPatterns={"/user"})
public class UserSerlvet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.forward(req, res, "/more/user.jsp");
	}

}
