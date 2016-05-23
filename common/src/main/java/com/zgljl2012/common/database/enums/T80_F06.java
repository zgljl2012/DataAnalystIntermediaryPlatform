package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午5:37:36
 * 广告状态（上架，下架）
 */
public enum T80_F06 implements AbstractEnums{
	
	SJ("上架"),
	
	XJ("下架")
	
	;
	
	private String chinese;
	
	private T80_F06(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static T80_F06 parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return T80_F06.valueOf(s);
	}
}
