package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

public enum T10_F08 implements AbstractEnums{
	
	/**
	 * 删除
	 */
	SC("删除"),
	
	/**
	 * 黑名单
	 */
	HMD("黑名单"),
	
	/**
	 * 启用
	 */
	QY("启用"),
	
	/**
	 * 未激活
	 */
	WJH("未激活")
	;
	
	private String chinese;
	
	private T10_F08(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static T10_F08 parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return T10_F08.valueOf(s);
	}
}
