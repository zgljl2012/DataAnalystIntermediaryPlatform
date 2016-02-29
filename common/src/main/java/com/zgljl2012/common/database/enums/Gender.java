package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

public enum Gender implements AbstractEnums{
	
	NAN("男"),
	
	NV("女"),
	
	BM("保密")
	
	;
	private String chinese;
	
	private Gender(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static Gender parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return Gender.valueOf(s);
	}
}
