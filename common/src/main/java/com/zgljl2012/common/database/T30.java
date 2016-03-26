package com.zgljl2012.common.database;

import com.zgljl2012.framework.database.AbstractEntity;

@SuppressWarnings("serial")
/**
 * 企业-资料
 * @author Administrator
 *
 */
public class T30 extends AbstractEntity {
	/**
	 * 用户ID（外键）
	 */
	public int F01;
	
	/**
	 * 公司名称（60个字）
	 */
	public int F02;
	
	/**
	 * 主营业务
	 */
	public String F03;
	
	/**
	 * 备注说明
	 */
	public String F04;

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

	public String getF03() {
		return F03;
	}

	public void setF03(String f03) {
		F03 = f03;
	}

	public String getF04() {
		return F04;
	}

	public void setF04(String f04) {
		F04 = f04;
	}
}
