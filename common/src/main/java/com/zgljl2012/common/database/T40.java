package com.zgljl2012.common.database;

import java.sql.Timestamp;
import java.util.Date;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.database.AbstractEntity;

/**
 * 项目单
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class T40 extends AbstractEntity{
	/**
	 * 自增ID
	 */
	public int F01;
	
	/**
	 * 项目名称（限25个字）
	 */
	public String F02;
	
	/**
	 * 价格
	 */
	public float F03;
	
	/**
	 * 发布者（公司/个人）ID
	 */
	public int F04;
	
	/**
	 * 项目状态
	 */
	public T40_F05 F05;
	
	/**
	 * 创建时间
	 */
	public Date F06;
	
	/**
	 * 审核时间
	 */
	public Date F07;
	
	/**
	 * 审核人ID
	 */
	public int F08;
	
	/**
	 * 不通过原因（如果不通过，限25个字）
	 */
	public String F09;
	
	/**
	 * 发布时间
	 */
	public Date F10;
	
	/**
	 * 项目完成时间
	 */
	public Date F11;
	
	/**
	 * 项目要求完成时间（天数）
	 */
	public Date F12;
	
	/**
	 * 项目描述
	 */
	public String F13;
	
	/**
	 * 是否删除
	 */
	public Bool F14;
	
	/**
	 * 中标用户ID
	 */
	public int F15;
	
	/**
	 * 中标时间
	 */
	public Timestamp F16;
	
	/**
	 * 招标天数
	 */
	public int F17;
	
	
	
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

	public float getF03() {
		return F03;
	}

	public void setF03(float f03) {
		F03 = f03;
	}

	public int getF04() {
		return F04;
	}

	public void setF04(int f04) {
		F04 = f04;
	}

	public T40_F05 getF05() {
		return F05;
	}

	public void setF05(T40_F05 f05) {
		F05 = f05;
	}

	public Date getF06() {
		return F06;
	}

	public void setF06(Date f06) {
		F06 = f06;
	}

	public Date getF07() {
		return F07;
	}

	public void setF07(Date f07) {
		F07 = f07;
	}

	public int getF08() {
		return F08;
	}

	public void setF08(int f08) {
		F08 = f08;
	}

	public String getF09() {
		return F09;
	}

	public void setF09(String f09) {
		F09 = f09;
	}

	public Date getF10() {
		return F10;
	}

	public void setF10(Date f10) {
		F10 = f10;
	}

	public Date getF11() {
		return F11;
	}

	public void setF11(Date f11) {
		F11 = f11;
	}

	public Date getF12() {
		return F12;
	}

	public void setF12(Date f12) {
		F12 = f12;
	}

	public String getF13() {
		return F13;
	}

	public void setF13(String f13) {
		F13 = f13;
	}

	public Bool getF14() {
		return F14;
	}

	public void setF14(Bool f14) {
		F14 = f14;
	}

	public int getF15() {
		return F15;
	}

	public void setF15(int f15) {
		F15 = f15;
	}

	public Timestamp getF16() {
		return F16;
	}

	public void setF16(Timestamp f16) {
		F16 = f16;
	}

	public int getF17() {
		return F17;
	}

	public void setF17(int f17) {
		F17 = f17;
	}
}
