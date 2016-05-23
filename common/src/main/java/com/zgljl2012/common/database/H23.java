package com.zgljl2012.common.database;

import java.sql.Timestamp;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午3:09:12
 * 用户权限表
 */
public class H23 {
	
	/**
	 * 用户权限ID
	 */
	public int F01;
	
	/**
	 * 用户组表
	 */
	public int F02;
	
	/**
	 * 权限ID
	 */
	public int F03;
	
	/**
	 * 时间戳
	 */
	public Timestamp F04;

	public int getF01() {
		return F01;
	}

	public void setF01(int f01) {
		F01 = f01;
	}

	public int getF02() {
		return F02;
	}

	public void setF02(int f02) {
		F02 = f02;
	}

	public int getF03() {
		return F03;
	}

	public void setF03(int f03) {
		F03 = f03;
	}

	public Timestamp getF04() {
		return F04;
	}

	public void setF04(Timestamp f04) {
		F04 = f04;
	}
	
	
}
