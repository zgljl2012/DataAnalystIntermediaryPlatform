package com.zgljl2012.front.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.BidManage;

/**
 * @author 廖金龙
 * @version 2016年4月28日下午10:30:14
 * 投标Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="projectBid", urlPatterns={"/project/bid"})
public class ProjectBidServlet extends AbstractServlet{
	
	@Impl
	BidManage bidManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// 获取投标列表
		String projectId = req.getParameter("projectId");
		if(projectId != null) {
			JSON json = bidManage.list(Integer.parseInt(projectId));
			out(res, json);
			return;
		} else {
			JSON j = new JSON();
			j.put("status","error");
			j.put("description","项目编号不能为空");
			out(res, j);
		}
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String projectId = req.getParameter("projectId");
		String price = req.getParameter("price");
		String comment = req.getParameter("comment");
		int uid = controller.getSession(req.getSession()).getUserId();
		JSON json = new JSON();
		try{
			int bidId = 
					bidManage.bid(Integer.parseInt(projectId), 
							uid, Float.parseFloat(price));
			bidManage.comment(bidId, comment);
			json.put("bidId", ""+bidId);
			json.put("status", "success");
		} catch(PostException e){
			throw e;
		}
		out(res, json);
	}

}
