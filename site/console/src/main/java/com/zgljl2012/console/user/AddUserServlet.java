package com.zgljl2012.console.user;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.H20;
import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午2:03:46
 * 添加管理员
 */
@SuppressWarnings("serial")
@WebServlet(name="addUser", urlPatterns={"/user/addUser"})
@Permission(name="添加管理员")
public class AddUserServlet extends AbstractConsoleServlet{
	
	@Impl
	HtUserManage um;
	
	@Impl
	PermissionManage pm;
	
	@Override
	protected boolean isPermission() {
		return true;
	}

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String url = "/more/user/addUser.jsp";
		List<H20> j = pm.getAllH20();
		req.setAttribute("group", j);
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String gid = req.getParameter("gid");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(gid);
		if(!StringHelper.isEmpty(gid)&&
				!StringHelper.isEmpty(name)&&
				!StringHelper.isEmpty(pwd)) {
			pwd = StringHelper.crypt(pwd);
			// 添加用户
			um.addConsoleUser(Integer.parseInt(gid), name, pwd);
		}
		String context = req.getContextPath();
		String url = context+"/more/user.jsp";
		this.redirect(res, url);
	}

}
