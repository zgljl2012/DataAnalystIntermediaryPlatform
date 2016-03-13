package com.zgljl2012.framework.test.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.log.AbstractLog;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.servlet.session.LjlSession;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;
import com.zgljl2012.framework.variable.VariableManage;

/**
 * @author 廖金龙
 * @version 2016年3月13日下午4:01:11
 * 
 */
public class TestAopServiceManage {
	
	ServiceManage serviceManage;
	Controller controller = new Controller() {

		@Override
		public ServiceManage getServiceManage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VariableManage getVariableManage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LjlSession createSession(HttpSession session) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LjlSession getSession(HttpSession session) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void forward(HttpServletRequest req, HttpServletResponse res,
				String url) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void redirect(HttpServletResponse res, String url)
				throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public FileUpload getFileUpload() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DatabaseProvider getDatabaseProvider() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AbstractLog getLogger() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	@Before
	public void before() {
		serviceManage = new ServiceManageSimple(controller);
	}
	
	@Test
	public void test() {
		Hello2 h = serviceManage.getService(Hello2.class, Hello2Impl.class);
		h.hello1();
		h.hello2();
		h.hello3();
		Hello2 h2 = serviceManage.getService(Hello2.class, Hello2Impl.class);
		h2.hello1();
		h2.hello2();
		h2.hello3();
	}
}
