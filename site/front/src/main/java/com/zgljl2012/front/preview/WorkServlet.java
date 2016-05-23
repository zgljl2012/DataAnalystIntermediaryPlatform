package com.zgljl2012.front.preview;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午3:37:03
 * 一半是编译器，一半是数据显示的工作区
 */
@SuppressWarnings("serial")
@WebServlet(name="work", urlPatterns={"/work"})
public class WorkServlet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String filePath = req.getParameter("filePath");
		req.setAttribute("filePath", filePath);
		this.forward(req, res, "/more/preview/work.jsp");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
