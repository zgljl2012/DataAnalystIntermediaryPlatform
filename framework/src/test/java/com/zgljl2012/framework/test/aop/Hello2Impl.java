package com.zgljl2012.framework.test.aop;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午1:19:05
 * 
 */
public class Hello2Impl extends AbstractService implements Hello2{

	public Hello2Impl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say() {
		// TODO Auto-generated method stub
		return "world";
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

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return null;
	}

}
