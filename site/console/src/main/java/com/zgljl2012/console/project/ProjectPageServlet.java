package com.zgljl2012.console.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年4月20日下午11:05:31
 * 项目页面
 */
@SuppressWarnings("serial")
@WebServlet(name="projectPage", urlPatterns={"/project/page/*"})
@Permission(name="项目审核")
public class ProjectPageServlet extends AbstractConsoleServlet{
	
	@Impl
	ProjectManage projectManage;
	
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String url = req.getRequestURI();
		String id = url.substring(url.lastIndexOf('/')+1);
		JSON r = projectManage.getProjectInfo(Integer.parseInt(id));
		req.setAttribute("data", r);
		url = "/more/project/page.jsp";
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

	@Override
	protected boolean isPermission() {
		return true;
	}

}
