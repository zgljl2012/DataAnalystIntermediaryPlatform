package com.zgljl2012.framework.test.variable;

import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.simple.variable.VariableManageSimple;
import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableManage;

public class TestVariable {
	
	VariableManage vm = null;
	
	@Before
	public void init() {
		vm = new VariableManageSimple(null);
	}
	
	@Test
	public void testVariableManage() {
		System.out.println(vm.getValue(SystemVariable.SITENAME));
		vm.setValue(SystemVariable.SITENAME, "Test");
		System.out.println(vm.getValue(SystemVariable.SITENAME));
	}
	
	@Test
	public void testVariableBean() {
		print(SystemVariable.SITENAME);
		print(SystemVariable.USERNAME);
	}
	
	void print(VariableBean bean)  {
		System.out.println("key:"+bean.getKey());
		System.out.println("name:"+bean.getName());
		System.out.println("value:"+bean.getValue());
		System.out.println("descirption:"+bean.getDescription());
	}
}
