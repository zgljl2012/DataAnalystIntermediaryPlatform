package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 站内信内容
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T61 extends AbstractEntity{
	/**
	 * 站内信ID
	 */
	public int F01;
	
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

	/**
	 * 站内信内容
	 */
	public String F02;
}
