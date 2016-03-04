package com.zgljl2012.common.variable;

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
	
	VERIFYCODE_LENGTH("验证码长度") {
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "4";
		}
	},
	
	FILE_UPLOAD_PATH("文件上传路径") {
		@Override
		public String getValue() {
			// 默认为用户路径
			return System.getProperty("user.home");
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
