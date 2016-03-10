package com.zgljl2012.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;

/**
 *@author 廖金龙
 *@version 2016年2月25日下午9:58:49
 */
@SuppressWarnings("serial")
public abstract class AbstractServlet extends HttpServlet{
	
	protected Controller controller;
	
	@Override
	public final void init() throws ServletException {
		controller = (Controller) this.getServletContext().getAttribute("controller");
		// 进行依赖注入
		try {
			controller.getServiceManage().DI(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			get(req, resp, controller);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			post(req, resp, controller);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 自定义的Get方法
	 * @param req
	 * @param res
	 * @param controller
	 */
	protected abstract void get(HttpServletRequest req, HttpServletResponse res, Controller controller) throws Exception;
	
	/**
	 * 自定义的Post方法
	 * @param req
	 * @param res
	 * @param controller
	 */
	protected abstract void post(HttpServletRequest req, HttpServletResponse res, Controller controller) throws Exception;
	
	/**
	 * 转发
	 * @param req
	 * @param res
	 * @param url
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void forward(HttpServletRequest req, HttpServletResponse res, String url) throws ServletException, IOException {
		req.getRequestDispatcher(url).forward(req, res);
	}
	
	/**
	 * 重定向
	 * @param res
	 * @param url
	 * @throws IOException 
	 */
	protected void redirect(HttpServletResponse res, String url) throws IOException {
		res.sendRedirect(url);
	}
	
	/**
	 * 输出字符串给客户端
	 * @param res
	 * @param s
	 * @throws IOException
	 */
	protected void out(HttpServletResponse res, String s) throws IOException {
		PrintWriter out = res.getWriter();
		out.println(s);
	}
}
