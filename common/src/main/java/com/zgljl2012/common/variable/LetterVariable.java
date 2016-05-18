package com.zgljl2012.common.variable;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableClass;

/**
 * @author 廖金龙
 * @version 2016年5月14日下午10:04:31
 * 
 */
@VariableClass(key="LETTER", name="站内信")
public enum LetterVariable implements VariableBean {
	
	REGISTER("注册") {
		@Override
		public String getValue() {
			return "尊敬的用户${name}，欢迎注册我们网站.";
		}
	},
	
	PROJECT_PASS("项目审核通过") {
		@Override
		public String getValue() {
			return "尊敬的用户您好，您于${date}发布的项目【${title}】已审核通过。";
		}
	},
	
	PROJECT_NOPASS("项目审核不通过") {
		@Override
		public String getValue() {
			return "尊敬的用户您好，您于${date}发布的项目【${title}】没有通过审核，具体原因为:\n${reason}";
		}
	}
	;
	private String key = "";
	private String name= "";
	private String value = "";
	private String description = "";
	
	private LetterVariable(String name, String value) {
		this.name = name;
		this.value = value;
		key = LetterVariable.class.getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	private LetterVariable(String name) {
		this.name = name;
		key = LetterVariable.class.getAnnotation(VariableClass.class).key();
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
