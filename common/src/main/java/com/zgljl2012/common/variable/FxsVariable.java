package com.zgljl2012.common.variable;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableClass;

/**
 * @author 廖金龙
 * @version 2016年3月14日下午9:36:21
 * 
 */
public enum FxsVariable implements VariableBean{

	BUSINESS_HISTORY_MAXSIZE("工作经历最长条数", ""+10),
	
	;
	private String key = "";
	private String name= "";
	private String value = "";
	private String description = "";
	
	private FxsVariable(String name, String value) {
		this.name = name;
		this.value = value;
		key = FxsVariable.class.getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	private FxsVariable(String name) {
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
