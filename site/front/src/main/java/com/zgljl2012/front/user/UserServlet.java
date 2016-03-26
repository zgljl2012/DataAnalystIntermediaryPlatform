package com.zgljl2012.front.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.user.QyManage;

/**
 * @author 廖金龙
 * @version 2016年3月26日下午10:50:06
 * 用户中心Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="userServlet", urlPatterns={"/user"})
public class UserServlet extends AbstractServlet{

	@Impl
	QyManage qyManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String userType = controller.
				getSession(req.getSession()).getUserType();
		if("QY".equals(userType)) {
			JSON data = qyManage.getQyInfo(controller.
					getSession(req.getSession()).getUserId());
			req.setAttribute("data", data);
		}
		String url = "/more/user/index.jsp";
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
