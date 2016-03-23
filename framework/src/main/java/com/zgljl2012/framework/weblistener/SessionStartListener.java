package com.zgljl2012.framework.weblistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zgljl2012.framework.controller.Controller;

/**
 *@author 廖金龙
 *@version 2016年2月28日下午6:09:21
 */
@WebListener("Session创建时调用")
public class SessionStartListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("新用户进入");
		arg0.getSource();
		Controller controller = 
				(Controller) arg0.getSession().getServletContext().getAttribute("controller");
		controller.createSession(arg0.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("用户离开");
		arg0.getSession().invalidate();
	}

}
