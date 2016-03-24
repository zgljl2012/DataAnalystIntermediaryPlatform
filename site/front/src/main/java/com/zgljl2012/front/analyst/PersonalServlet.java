package com.zgljl2012.front.analyst;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.analyst.FxsMarketManage;

/**
 * @author 廖金龙
 * @version 2016年3月24日下午10:32:19
 * 分析师页面
 */
@SuppressWarnings("serial")
@WebServlet(name="PersonalServlet", urlPatterns={"/analyst/*"})
public class PersonalServlet extends AbstractServlet{

	@Impl
	FxsMarketManage fxs;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String url = req.getRequestURI();
		String id = url.substring(url.lastIndexOf('/')+1);
		JSON data = fxs.getFxs(Integer.parseInt(id));
		req.setAttribute("data", data);
		String target = "/more/analyst/personal.jsp";
		this.forward(req, res, target);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

}
