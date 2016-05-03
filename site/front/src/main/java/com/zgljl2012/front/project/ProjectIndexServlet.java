package com.zgljl2012.front.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.project.ProjectManage;
import com.zgljl2012.modules.project.query.ProjectListIndeQuery;

/**
 * @author 廖金龙
 * @version 2016年4月25日下午10:47:48
 * 项目市场搜索Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="projectIndex", urlPatterns={"/projectIndex"})
public class ProjectIndexServlet extends AbstractServlet{
	
	@Impl
	ProjectManage projectManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final int pageSize = 10;
		ProjectListIndeQuery query = new ProjectListIndeQuery() {
			
			@Override
			public int pageSize() {
				// TODO Auto-generated method stub
				return pageSize;
			}
			
			@Override
			public T40_F05 getStatus() {
				String status = req.getParameter("status");
				if(!StringHelper.isEmpty(status)) {
					return T40_F05.parse(status);
				}
				return null;
			}
			
			@Override
			public int current() {
				if(StringHelper.isEmpty(req.getParameter("current"))) {
					return 0;
				}
				return Integer.parseInt(req.getParameter("current"));
			}
			
			@Override
			public int getStar() {
				if(StringHelper.isEmpty(req.getParameter("grade"))) {
					return 0;
				}
				return Integer.parseInt(req.getParameter("grade"));
			}
			
			@Override
			public int getSalaryRange() {
				if(StringHelper.isEmpty(req.getParameter("salaryRange"))) {
					return 0;
				}
				return Integer.parseInt(req.getParameter("salaryRange"));
			}
			
		};
		
		JSON json = projectManage.getProjectIndexList(query);
		json.put("pageSize", ""+pageSize);
		int count = projectManage.getProjectSize(query);
		json.put("count", "" +count);
		this.out(res, json);
	}

}
