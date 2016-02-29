package com.zgljl2012.framework.simple.variable;

import java.util.HashMap;
import java.util.Map;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableManage;

public class VariableManageSimple implements VariableManage{

	private Map<String, String> data;
	
	public VariableManageSimple(Map<String, String> data) {
		this.data = data;
		if(this.data == null) {
			this.data = new HashMap<String, String>();
		}
	}
	
	public String getValue(VariableBean bean) {
		String value = data.get(bean.getKey());
		if(value == null) {
			value = bean.getValue();
			data.put(bean.getKey(), value);
		}
		return value;
	}

	public String setValue(VariableBean bean, String value) {
		data.put(bean.getKey(), value);
		return getValue(bean);
	}

}
