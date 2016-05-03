package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 投标单
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T50 extends AbstractEntity {
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 项目ID
	 */
	public int F02;
	
	/**
	 * 用户ID
	 */
	public int F03;
	
	/**
	 * 报价
	 */
	public float F04;
	
	/**
	 * 时间戳
	 */
	public Timestamp F05;
	
	/**
	 * 是否删除
	 */
	public Bool F06;
	
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

	public float getF04() {
		return F04;
	}

	public void setF04(float f04) {
		F04 = f04;
	}

	public Timestamp getF05() {
		return F05;
	}

	public void setF05(Timestamp f05) {
		F05 = f05;
	}

	public Bool getF06() {
		return F06;
	}

	public void setF06(Bool f06) {
		F06 = f06;
	}

	
}
