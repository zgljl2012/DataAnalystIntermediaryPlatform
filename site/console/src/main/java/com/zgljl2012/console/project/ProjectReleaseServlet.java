package com.zgljl2012.console.project;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.variable.LetterVariable;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.framework.variable.VariableManage;
import com.zgljl2012.modules.letter.manage.service.LetterManage;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年4月20日下午11:00:30
 * 项目发布Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="projectRelease", urlPatterns={"/project/realease"})
@Permission(name="项目发布或审核不通过")
public class ProjectReleaseServlet extends AbstractServlet{
	
	private static final SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	
	@Impl
	ProjectManage pm;
	
	@Impl
	LetterManage lm;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		String reason = req.getParameter("reason");
		JSON t = (JSON) pm.getProjectInfo(Integer.parseInt(id)).get("t40");
		VariableManage vm = controller.getVariableManage();
		Map<String,String> map = new HashMap<>();
		map.put("date", (String)t.get("F06"));
		map.put("title", (String) t.get("F02"));
		int to = Integer.parseInt((String) t.get("F04"));
		if("nopass".equals(type)) {
			if(StringHelper.isEmpty(reason)) {
				reason = "项目审核不通过";
			}
			map.put("reason", reason);
			System.out.println(reason);
			String content = StringHelper.renderString(
					vm.getValue(LetterVariable.PROJECT_NOPASS)
					, map);
			pm.setNoPass(0, Integer.parseInt(id), reason);
			// 发送站内信
			lm.sendLetter(0, to, "审核未通过", content);
		} else if("release".equals(type)) {
			pm.realeaseProject(Integer.parseInt(id));
			String content = StringHelper.renderString(
					vm.getValue(LetterVariable.PROJECT_PASS), 
					map);
			lm.sendLetter(0, to, "审核通过", content);
		}
		String context = req.getContextPath();
		this.redirect(res, context+"/more/project.jsp");
	}

}
