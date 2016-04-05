package com.zgljl2012.common.database.enums;

import com.zgljl2012.framework.enums.AbstractEnums;
import com.zgljl2012.framework.util.StringHelper;

public enum T40_F05 implements AbstractEnums{
	
	BJZ("编辑中"), // 用户可保留成草稿
	DSH("待审核"), // 有待后台管理人员审核
	DXG("待修改"), // 审核未通过
	DFB("待发布"), // 审核通过后待管理人员发布
	TBZ("招标中"), // 等待分析师投标 
	JXZ("工作中"), // 分析师工作中 
	YJS("已结束")  // 分析师完工
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
