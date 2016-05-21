package com.zgljl2012.console.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.console.module.service.manage.query.FrontUserQuery;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午5:27:09
 * 前台用户管理
 */
@SuppressWarnings("serial")
@WebServlet(name="frontUserManage", urlPatterns={"/user/front"})
public class FrontUserServlet extends AbstractServlet{
	
	@Impl
	HtUserManage um;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String username = req.getParameter("username");
		final String userType = req.getParameter("userType");
		final String current = req.getParameter("current");
		final int pageSize = 10;
		JSON json = um.frontUser(new FrontUserQuery() {
			
			@Override
			public String getUsername() {
				return username;
			}
			
			@Override
			public T10_F05 getUserType() {
				if(!StringHelper.isEmpty(userType)) {
					return T10_F05.parse(userType);
				}
				return null;
			}
		}, new PagingInfo() {
			
			@Override
			public int getPageSize() {
				return pageSize;
			}
			
			@Override
			public int getCurrentPage() {
				if(current != null) {
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
		String type = req.getParameter("type");
		String uid  = req.getParameter("id");
		int id = Integer.parseInt(uid);
		if("sc".equals(type)) {
			um.scUser(id);
		} else if("usc".equals(type)) {
			um.uscUser(id);
		} else if("hmd".equals(type)) {
			um.hmdUser(id);
		} else if("uhmd".equals(type)) {
			um.uhmdUser(id);
		}
	}

}
