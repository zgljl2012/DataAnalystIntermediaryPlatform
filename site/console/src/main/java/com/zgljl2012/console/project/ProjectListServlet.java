package com.zgljl2012.console.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.ProjectManage;
import com.zgljl2012.modules.project.query.ProjectStatusPaggingQuery;

/**
 * @author 廖金龙
 * @version 2016年4月17日下午2:54:31
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="projectList", urlPatterns={"/project/list"})
public class ProjectListServlet extends AbstractServlet{

	@Impl
	ProjectManage projectManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final String status = req.getParameter("status");
		final String current = req.getParameter("current");
		int uid = controller.getSession(req.getSession()).getUserId();
		final int pageSize = 10;
		JSON data = projectManage.projectList(
				uid,
				new ProjectStatusPaggingQuery() {
					
					@Override
					public int pageSize() {
						// TODO Auto-generated method stub
						return pageSize;
					}
					
					@Override
					public T40_F05 getStatus() {
						// TODO Auto-generated method stub
						return T40_F05.parse(status);
					}
					
					@Override
					public int current() {
						// TODO Auto-generated method stub
						return Integer.parseInt(current);
					}
				});
		int count = projectManage.getProjectSize(uid, T40_F05.parse(status));
		data.put("count", ""+count);
		data.put("pageSize", ""+pageSize);
		out(res, data);
	}

}
