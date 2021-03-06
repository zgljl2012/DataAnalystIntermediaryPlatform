package com.zgljl2012.front.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.project.CommentManage;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年5月8日下午10:43:59
 * 企业评论分析师的Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="projectQyComment", urlPatterns={"/project/qy/comment"})
public class ProjectQyCommentServlet extends AbstractServlet{
	
	@Impl
	private CommentManage commentManage;
	
	@Impl
	private ProjectManage projectManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String sProjectId = req.getParameter("projectId");
		JSON j = commentManage.getQy2Fxs(Integer.parseInt(sProjectId));
		System.out.println(j.toString());
		out(res, j);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String comment = req.getParameter("comment");
		String sGrade = req.getParameter("grade");
		String sProjectId = req.getParameter("projectId");
		try{
			if(StringHelper.isEmpty(comment)) {
				comment = "";
			}
			float grade = Float.parseFloat(sGrade);
			int projectId = Integer.parseInt(sProjectId);
			projectManage.setProjectYJS(projectId);
			commentManage.qy2fxs(projectId, comment, grade);
			JSON j = new JSON();
			j.put("status", "success");
			out(res,j);
		} catch(PostException e) {
			e.printStackTrace();
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			throw new PostException("系统发生错误，请刷新重试");
		}
	}

}
