package com.zgljl2012.framework.system;

import com.zgljl2012.framework.controller.Controller;

/**
 * @author 廖金龙
 * @version 2016年3月14日下午9:25:45
 * 
 */
public class TestShutdown implements SystemShutdownListener{

	@Override
	public void shutdown(Controller controller) {
		// TODO Auto-generated method stub
		System.out.println("shutdown");
	}

}
