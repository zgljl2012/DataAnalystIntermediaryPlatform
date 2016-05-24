package com.zgljl2012.front.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.front.user.UserManage;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午11:18:34
 * 确认邮箱
 */
@SuppressWarnings("serial")
@WebServlet(name="confirmEmailBox",urlPatterns={"/confirm/email"})
public class ConfirmEmailBox extends AbstractServlet{

	@Impl
	UserManage um;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String email = req.getParameter("email");
		String hexCode = req.getParameter("hexCode");
		try {
			um.confirmEmailBox(email, hexCode);
			req.setAttribute("msg", "验证成功");
		} catch(PostException e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
		}
		this.forward(req, res, "/more/user/confirm.jsp");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
