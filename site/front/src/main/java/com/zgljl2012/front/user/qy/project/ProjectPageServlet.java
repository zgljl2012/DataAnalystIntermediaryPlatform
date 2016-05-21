package com.zgljl2012.front.user.qy.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年4月20日下午11:05:31
 * 项目页面
 */
@SuppressWarnings("serial")
@WebServlet(name="projectPage", urlPatterns={"/project/page/*"})
public class ProjectPageServlet extends AbstractServlet{
	
	@Impl
	ProjectManage projectManage;
	
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String url = req.getRequestURI();
		String id = url.substring(url.lastIndexOf('/')+1);
		JSON r = projectManage.getProjectInfo(Integer.parseInt(id));
		//附件
		String filename = projectManage.getAttachment(Integer.parseInt(id));
		if(!StringHelper.isEmpty(filename)) {
			r.put("filename", filename);
		}
		req.setAttribute("data", r);
		url = "/more/project/page.jsp";
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

}
