package com.zgljl2012.framework.system;

import javax.servlet.ServletContextEvent;

public class TestStartup implements SystemStartupListener{

	@Override
	public void startup(ServletContextEvent context) {
		// TODO Auto-generated method stub
		System.out.println("startup");
	}

}
