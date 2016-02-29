package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

public enum T40_F05 implements AbstractEnums{
	
	BJZ("编辑中"),
	DSH("待审核"),
	DXG("待修改"), // 审核未通过
	DFB("待发布"),
	TBZ("投标中"),
	JXZ("进行中"),
	YJS("已结束")
	;
	
	private String chinese;
	
	private T40_F05(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static T40_F05 parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return T40_F05.valueOf(s);
	}
	
}
