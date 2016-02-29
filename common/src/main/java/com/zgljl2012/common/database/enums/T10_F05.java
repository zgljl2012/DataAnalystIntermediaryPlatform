package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

/**
 * 用户类型
 * @author 廖金龙
 * @version 2016/2/21 21:24
 */
public enum T10_F05 implements AbstractEnums{
	
	QY("企业"),
	FXS("分析师")
	;
	
	private String chinese;
	
	private T10_F05(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static T10_F05 parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return T10_F05.valueOf(s);
	}
}
