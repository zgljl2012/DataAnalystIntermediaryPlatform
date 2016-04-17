package com.zgljl2012.front.user.qy.project;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.project.ProjectManage;
import com.zgljl2012.modules.project.query.ProjectBaseInfoQuery;

/**
 * @author 廖金龙
 * @version 2016年4月13日下午9:59:57
 * 新增项目列表
 */
@SuppressWarnings("serial")
@WebServlet(name="NewProject",urlPatterns={"/project/new"})
public class NewProjectServlet extends AbstractServlet{
	
	@Impl
	ProjectManage projectManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		try {
			post(req, res, controller);
		} catch(PostException e) {
			e.printStackTrace();
			JSON json = new JSON();
			json.put("status", "error");
			json.put("description", e.getMessage());
			out(res, json);
		}
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ProjectBaseInfoQuery info = new ProjectBaseInfoQuery(){

			@Override
			public String getProjectName() {
				// TODO Auto-generated method stub
				return req.getParameter("projectName");
			}

			@Override
			public float getWillPrice() {
				if(!StringHelper.isEmpty(req.getParameter("willPrice"))) {
					try{
						return Float.parseFloat(req.getParameter("willPrice"));
					} catch (Exception e){
						return 0;
					}
				}
				return 0;
			}

			@Override
			public int getBidDays() {
				if(!StringHelper.isEmpty(req.getParameter("bidDays"))) {
					try{
						return Integer.parseInt(req.getParameter("bidDays"));
					} catch (Exception e){
						e.printStackTrace();
						return -1;
					}
				}
				return -1;
			}

			@Override
			public Date getFinishDate() {
				if(!StringHelper.isEmpty(req.getParameter("timeLimit"))) {
					try {
						return new java.sql.Date(
								sdf.parse(req.getParameter("timeLimit")).getTime());
					} catch (ParseException e) {
						e.printStackTrace();
						return null;
					}
				}
				return null;
			}

			@Override
			public String getDescription() {
				if(!StringHelper.isEmpty(req.getParameter("projectDescription"))) {
					return req.getParameter("projectDescription");
				}
				return null;
			}
			
		};
		
		if(info.getBidDays() == -1) {
			throw new PostException("招标天数不能为空");
		}
		
		if(info.getDescription() == null) {
			throw new PostException("项目描述不能为空");
		}
		
		if(info.getProjectName() == null) {
			throw new PostException("项目名称不能为空");
		}
		
		if(info.getFinishDate() == null) {
			throw new PostException("期望完成时间不能为空");
		}
		try {
			projectManage.addProject(controller.getSession(req.getSession()).getUserId(), 
					info);
		} catch(Exception e) {
			throw new PostException(e.getMessage());
		}
		String path = this.getServletContext().getContextPath();
		String url = path+"/user";
		System.out.print(path);
		this.redirect(res, url);
	}
	
}
