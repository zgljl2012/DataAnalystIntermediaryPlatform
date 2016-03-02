package com.zgljl2012.front.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年3月2日下午11:43:55
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="uploadHeadImage", urlPatterns={"/uploadHeadImage"})
public class UploadHeadImage extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("get");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("post");
	}

}
