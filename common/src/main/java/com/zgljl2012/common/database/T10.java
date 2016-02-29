package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.framework.database.AbstractEntity;

@SuppressWarnings("serial")
public class T10 extends AbstractEntity{
	
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 用户名
	 */
	public String F02;
	
	/**
	 * 邮箱
	 */
	public String F03;
	
	/**
	 * 密码
	 */
	public String F04;
	
	/**
	 * 用户类型
	 */
	public T10_F05 F05;
	
	/**
	 * 是否删除
	 */
	public Bool F06;
	
	/**
	 * 注册时间戳
	 */
	public Timestamp F07;
	
	/**
	 * 用户状态
	 */
	public T10_F08 F08;
	
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

	public T10_F05 getF05() {
		return F05;
	}

	public void setF05(T10_F05 f05) {
		F05 = f05;
	}

	public Bool getF06() {
		return F06;
	}

	public void setF06(Bool f06) {
		F06 = f06;
	}

	public Timestamp getF07() {
		return F07;
	}

	public void setF07(Timestamp f07) {
		F07 = f07;
	}

	public T10_F08 getF08() {
		return F08;
	}

	public void setF08(T10_F08 f08) {
		F08 = f08;
	}

}
