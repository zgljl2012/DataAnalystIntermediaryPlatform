package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午2:58:43
 * 后台用户组
 */
@SuppressWarnings("serial")
public class H20 extends AbstractEntity{
	
	/**
	 * 用户组ID
	 */
	public int F01;
	
	/**
	 * 用户组名称
	 */
	public String F02;

	public int getF01() {
		return F01;
	}

	public void setF01(int f01) {
		F01 = f01;
	}

	public String getF02() {
		return F02;
	}

	public void setF02(String f02) {
		F02 = f02;
	}
}
