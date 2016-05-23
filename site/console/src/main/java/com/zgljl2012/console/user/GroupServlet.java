package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午12:25:37
 * 用户组管理
 */
@SuppressWarnings("serial")
@WebServlet(name="userGroup", urlPatterns={"/user/group"})
public class GroupServlet extends AbstractConsoleServlet{
	
	@Impl
	HtUserManage um;
	
	@Impl
	PermissionManage pm;
	
	@Override
	protected boolean isPermission() {
		return false;
	}

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String current = req.getParameter("current");
		final int pageSize = 10;
		JSON json = um.consoleGroup(new PagingInfo() {
			
			@Override
			public int getPageSize() {
				return 10;
			}
			
			@Override
			public int getCurrentPage() {
				if(!StringHelper.isEmpty(current)) {
					return Integer.parseInt(current);
				}
				return 1;
			}
		});
		json.put("pageSize", ""+pageSize);
		out(res, json);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
