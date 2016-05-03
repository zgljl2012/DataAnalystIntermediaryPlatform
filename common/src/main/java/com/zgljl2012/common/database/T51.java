package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 投标版留言
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T51 extends AbstractEntity {
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
	 * 投标单ID
	 */
	public int F01;
	
	/**
	 * 留言
	 */
	public String F02;
}
