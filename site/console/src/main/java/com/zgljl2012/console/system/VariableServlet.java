package com.zgljl2012.console.system;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.module.service.manage.MyVariableManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月12日下午6:54:52
 * 获取系统常量列表
 */
@SuppressWarnings("serial")
@WebServlet(name="variableServlet", urlPatterns={"/variable"})
@Permission(name="常量配置查看")
public class VariableServlet extends AbstractServlet{
	
	@Impl
	private MyVariableManage vm;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String current = req.getParameter("current");
			String name = req.getParameter("name");
			if(StringHelper.isEmpty(name)) {
				name = null;
			}
			JSON json = vm.getVariableBeanList(name, new PagingInfo() {
				
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
			json.put("pageSize", ""+10);
			out(res, json);
		
	}

}
