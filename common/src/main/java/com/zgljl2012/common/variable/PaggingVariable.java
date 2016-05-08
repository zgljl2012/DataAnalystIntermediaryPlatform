package com.zgljl2012.common.variable;

import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableClass;

/**
 * @author 廖金龙
 * @version 2016年5月4日上午9:19:11
 * 分页信息
 */
@VariableClass(key="PAGGING", name="系统常量")
public enum PaggingVariable implements VariableBean{
	
	PAGE_BID_SIZE("项目页面分页展示投标情况的每页投标条数"){
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "5";
		}
	},
	
	PAGE_FXS_PROJECT_SIZE("分析师用户中心项目类表页面每页项目条数") {
		@Override
		public String getValue() {
			return "5";
		}
	}
	
	;
	
	private String key = "";
	private String name= "";
	private String value = "";
	private String description = "";
	
	private PaggingVariable(String name, String value) {
		this.name = name;
		this.value = value;
		key = this.getClass().getAnnotation(VariableClass.class).key();
		key += ".";
		key += name().toUpperCase();
	}
	
	private PaggingVariable(String name) {
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
