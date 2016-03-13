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
	
	@Override
	public void hello1() {
		// TODO Auto-generated method stub
		print("1");
	}

	@Override
	public void hello2() {
		// TODO Auto-generated method stub
		print("2");
	}

	@Override
	public void hello3() {
		// TODO Auto-generated method stub
		print("3");
	}
	
	void print(String s) {
		System.out.println("hello"+s);
	}

}
