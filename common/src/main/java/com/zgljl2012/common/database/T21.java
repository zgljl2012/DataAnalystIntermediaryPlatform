package com.zgljl2012.common.database;

import java.util.Date;

import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 分析师——从业经历
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T21 extends AbstractEntity {
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 用户ID
	 */
	public int F02;
	
	/**
	 * 公司名称（30个字）
	 */
	public String F03;
	
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

	public Date getF04() {
		return F04;
	}

	public void setF04(Date f04) {
		F04 = f04;
	}

	public Date getF05() {
		return F05;
	}

	public void setF05(Date f05) {
		F05 = f05;
	}

	public String getF06() {
		return F06;
	}

	public void setF06(String f06) {
		F06 = f06;
	}

	/**
	 * 开始时间
	 */
	public Date F04;
	
	/**
	 * 结束时间
	 */
	public Date F05;
	
	/**
	 * 职务说明
	 */
	public String F06;
}
