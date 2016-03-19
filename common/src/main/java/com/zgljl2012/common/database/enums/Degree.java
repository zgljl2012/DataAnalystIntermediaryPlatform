package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年3月19日上午11:17:57
 * 学历
 */
public enum Degree implements AbstractEnums{
	
	DZ("大专"),
	BK("本科"),
	SS("硕士"),
	BS("博士"),
	BSH("博士后"),
	QT("其它")
	;

	private String chinese;
	
	private Degree(String s) {
		this.chinese = s;
	}
	
	public String getChineseName() {
		return this.chinese;
	}

	public static Degree parse(String s) {
		// TODO Auto-generated method stub
		if(StringHelper.isEmpty(s)) {
			return null;
		}
		return Degree.valueOf(s);
	}

}
