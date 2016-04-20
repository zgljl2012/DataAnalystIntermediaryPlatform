package com.zgljl2012.console.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年4月20日下午11:00:30
 * 项目发布Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="projectRelease", urlPatterns={"/project/realease"})
public class ProjectReleaseServlet extends AbstractServlet{
	
	@Impl
	ProjectManage pm;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String id = req.getParameter("id");
		pm.realeaseProject(Integer.parseInt(id));
		this.redirect(res, "");
	}

}
