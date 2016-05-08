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
 * @version 2016年5月5日下午6:51:26
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="projectBidDel", urlPatterns={"/project/bid/del"})
public class ProjectBidDelServlet extends AbstractServlet{
	
	@Impl
	BidManage bidManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String bidId = req.getParameter("bidId");
		try {
			int bd = Integer.parseInt(bidId);
			bidManage.del(bd);
			JSON r = new JSON();
			r.put("status", "success");
			out(res, r);
		} catch(NumberFormatException e) {
			throw new PostException("请选择正确的投标单");
		}
	}

}
