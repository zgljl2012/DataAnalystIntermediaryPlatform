package com.zgljl2012.framework.weblistener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.servlet.session.LjlSession;
import com.zgljl2012.framework.simple.fileupload.FileUploadSimple;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;
import com.zgljl2012.framework.simple.servlet.session.LjlSessionSimple;
import com.zgljl2012.framework.simple.variable.VariableManageSimple;
import com.zgljl2012.framework.variable.VariableManage;

/**
 *@author 廖金龙
 *@version 2016年2月27日下午9:56:45
 *Web应用启动时调用此监听器
 */
@WebListener("Web应用创建时调用")
public class ContextStartListener implements  ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Controller controller = new Controller() {
			
			private ServiceManage serviceManage = new ServiceManageSimple();
			
			private VariableManage variableManage = new VariableManageSimple(null);
			
			private FileUpload fileUpload = new FileUploadSimple();
			
			@Override
			public ServiceManage getServiceManage() {
				// TODO Auto-generated method stub
				return serviceManage;
			}
			
			@Override
			public VariableManage getVariableManage() {
				// TODO Auto-generated method stub
				return variableManage;
			}

			@Override
			public LjlSession createSession(HttpSession session) {
				// TODO Auto-generated method stub
				LjlSession ljlSession = new LjlSessionSimple();
				ljlSession.setLogined(false);
				session.setAttribute("ljlSession", ljlSession);
				return ljlSession;
			}

			@Override
			public LjlSession getSession(HttpSession session) {
				// TODO Auto-generated method stub
				LjlSession ljlSession = (LjlSession) session.getAttribute("ljlSession");
				if(ljlSession == null) {
					ljlSession = this.createSession(session);
				}
				return ljlSession;
			}

			@Override
			public void forward(HttpServletRequest req,
					HttpServletResponse res, String url) {
				try {
					req.getRequestDispatcher(url).forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			@Override
			public void redirect(HttpServletResponse res, String url)
					throws IOException {
				res.sendRedirect(url);
			}

			@Override
			public FileUpload getFileUpload() {
				// TODO Auto-generated method stub
				return fileUpload;
			}
		};
		arg0.getServletContext().setAttribute("controller", controller);
	}

}
