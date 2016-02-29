package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

public enum Bool implements AbstractEnums{
	
	S("是"),
	
	F("否")
	;
	
	private String chinese;
	
	private Bool(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static Bool parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return Bool.valueOf(s);
	}
	
}
