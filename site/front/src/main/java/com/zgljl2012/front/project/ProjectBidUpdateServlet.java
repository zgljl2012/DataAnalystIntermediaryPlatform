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
import com.zgljl2012.modules.project.BidManage;

/**
 * @author 廖金龙
 * @version 2016年5月9日下午11:12:42
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="projectBidUpdate", urlPatterns={"/project/bid/update"})
public class ProjectBidUpdateServlet extends AbstractServlet{
	
	@Impl
	BidManage bidManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String comment = req.getParameter("comment");
		String sGrade = req.getParameter("price");
		String sBid = req.getParameter("bid");
		try {
			if(StringHelper.isEmpty(sGrade)) {
				throw new PostException("请输入报价");
			}
			bidManage.update(Integer.parseInt(sBid), comment, Float.parseFloat(sGrade));
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
