package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午2:03:46
 * 添加用户组
 */
@SuppressWarnings("serial")
@WebServlet(name="addUserGroup", urlPatterns={"/user/addUserGroup"})
@Permission(name="添加管理员用户组")
public class AddUserGroupServlet extends AbstractConsoleServlet{
	
	@Impl
	HtUserManage um;
	
	@Override
	protected boolean isPermission() {
		return true;
	}

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String url = "/more/user/addUserGroup.jsp";
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String name = req.getParameter("name");
		if(!StringHelper.isEmpty(name)) {
			// 添加用户组
			um.addConsoleUserGroup(name);
		}
		String context = req.getContextPath();
		String url = context+"/more/user.jsp";
		this.redirect(res, url);
	}

}
