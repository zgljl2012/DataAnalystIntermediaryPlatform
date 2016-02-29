package com.zgljl2012.framework.test.variable;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableClass;

@VariableClass(key="SYSTEM", name="系统常量")
public enum SystemVariable implements VariableBean{
	
	SITENAME("网站名称"){
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "数据分析师中介平台";
		}
	},
	
	USERNAME("用户名","admin"){
		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "网站用户名";
		}
	}
	
	;
	
	private String key = "";
	private String name= "";
	private String value = "";
	private String description = "";
	
	private SystemVariable(String name, String value) {
		this.name = name;
		this.value = value;
		key = SystemVariable.class.getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	private SystemVariable(String name) {
		this.name = name;
		key = SystemVariable.class.getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
