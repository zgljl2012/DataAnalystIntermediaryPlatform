package com.zgljl2012.front.user.qy.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.ProjectManage;

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
		String status = req.getParameter("status");
		JSON data = projectManage.projectList(
				controller.getSession(req.getSession()).getUserId(),
				T40_F05.parse(status));
		out(res, data);
	}

}
