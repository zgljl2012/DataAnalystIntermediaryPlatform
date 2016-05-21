package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午10:19:54
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="consoleUserManage", urlPatterns={"/user/console"})
public class ConsoleUserServlet extends AbstractServlet{
	
	@Impl
	HtUserManage um;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String current = req.getParameter("current");
		final int pageSize = 10;
		JSON json = um.consoleUser(new PagingInfo() {
			
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
		String uid  = req.getParameter("id");
		int id = Integer.parseInt(uid);
		um.scConsoleUser(id);
	}

}
