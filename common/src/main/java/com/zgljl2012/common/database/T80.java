package com.zgljl2012.common.database;

import java.sql.Timestamp;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T80_F06;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午5:34:36
 * 广告
 */
@SuppressWarnings("serial")
public class T80 extends AbstractEntity{
	
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 广告图片路径
	 */
	public String F02;
	
	/**
	 * 广告标题
	 */
	public String F03;
	
	/**
	 * 广告链接
	 */
	public String F04;
	
	/**
	 * 时间戳
	 */
	public Timestamp F05;
	
	/**
	 * 广告状态（SJ，XJ）
	 */
	public T80_F06 F06;
	
	/**
	 * 是否删除
	 */
	public Bool F07;
	
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

	public Timestamp getF05() {
		return F05;
	}

	public void setF05(Timestamp f05) {
		F05 = f05;
	}

	public T80_F06 getF06() {
		return F06;
	}

	public void setF06(T80_F06 f06) {
		F06 = f06;
	}

	public Bool getF07() {
		return F07;
	}

	public void setF07(Bool f07) {
		F07 = f07;
	}

	
}
