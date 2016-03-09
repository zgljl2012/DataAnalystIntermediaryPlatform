package com.zgljl2012.framework.test.service.impl;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.test.service.Hello;


public class HelloImpl extends AbstractService implements Hello{

	public HelloImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	public String say() {
		// TODO Auto-generated method stub
		return ("Hello");
	}
}
