package com.zgljl2012.common.database;

import java.util.Date;

import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 分析师——基本资料
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T20 extends AbstractEntity{
	/**
	 * 用户ID
	 */
	public int F01;
	
	/**
	 * 真实姓名
	 */
	public String F02;
	
	/**
	 * 性别
	 */
	public Gender F03;
	
	/**
	 * 出生日期
	 */
	public Date F04;
	
	/**
	 * 个人简介
	 */
	public String F05;
	
	/**
	 * 就业时间
	 */
	public Date F06;
	
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

	public Gender getF03() {
		return F03;
	}

	public void setF03(Gender f03) {
		F03 = f03;
	}

	public Date getF04() {
		return F04;
	}

	public void setF04(Date f04) {
		F04 = f04;
	}

	public String getF05() {
		return F05;
	}

	public void setF05(String f05) {
		F05 = f05;
	}

	public Date getF06() {
		return F06;
	}

	public void setF06(Date f06) {
		F06 = f06;
	}

	public String getF07() {
		return F07;
	}

	public void setF07(String f07) {
		F07 = f07;
	}

	public String getF08() {
		return F08;
	}

	public void setF08(String f08) {
		F08 = f08;
	}

	public String getF09() {
		return F09;
	}

	public void setF09(String f09) {
		F09 = f09;
	}

	/**
	 * 毕业院校（限20个字）
	 */
	public String F07;
	
	/**
	 * 当前公司（可选自由职业，限30个字）
	 */
	public String F08;
	
	/**
	 * 头像链接
	 */
	public String F09;
	
}
