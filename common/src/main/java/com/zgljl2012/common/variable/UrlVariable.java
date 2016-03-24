package com.zgljl2012.common.variable;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableClass;

/**
 * @author 廖金龙
 * @version 2016年3月24日下午10:38:29
 * 
 */
@VariableClass(key="URL", name="URL变量")
public enum UrlVariable implements VariableBean{
	FXS_PERSONAL_ITEM("分析师个人主页展示页面", "more/analyst/personal.jsp")
	;
	private String key = "";
	private String name= "";
	private String value = "";
	private String description = "";
	
	private UrlVariable(String name, String value) {
		this.name = name;
		this.value = value;
		key = this.getClass().getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	private UrlVariable(String name) {
		this.name = name;
		key = this.getClass().getAnnotation(VariableClass.class).key();
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
