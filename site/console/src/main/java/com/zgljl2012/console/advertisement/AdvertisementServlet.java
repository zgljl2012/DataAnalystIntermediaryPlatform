package com.zgljl2012.console.advertisement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.AdvertisementManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午6:10:38
 * 广告管理Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="advertisementServlet", urlPatterns={"/ad"})
public class AdvertisementServlet extends AbstractConsoleServlet {
	
	@Impl
	AdvertisementManage am;
	
	@Override
	protected boolean isPermission() {
		return false;
	}

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String current = req.getParameter("current");
		final int pageSize = 10;
		JSON json = am.list(new PagingInfo() {
			
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
		String type = req.getParameter("type");
		String id = req.getParameter("id");
		if(!StringHelper.isEmpty(id)) {
			int aid = Integer.parseInt(id);
			if("sc".equals(type)) {
				am.sc(aid);
			} else if("xj".equals(type)) {
				am.xj(aid);
			} else if("sj".equals(type)) {
				am.sj(aid);
			}
		}
	}

}
