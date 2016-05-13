package com.zgljl2012.framework.system;

import com.zgljl2012.framework.controller.Controller;

public class TestStartup implements SystemStartupListener{

	@Override
	public void startup(Controller controller) {
		// TODO Auto-generated method stub
		System.out.println("startup");
	}

}
