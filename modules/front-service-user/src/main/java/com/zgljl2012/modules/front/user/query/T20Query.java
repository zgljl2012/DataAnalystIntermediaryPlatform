package com.zgljl2012.modules.front.user.query;

import java.util.Date;

import com.zgljl2012.common.database.enums.Degree;
import com.zgljl2012.common.database.enums.Gender;

/**
 *@author 廖金龙
 *@version 2016年2月29日上午12:36:09
 *T20分析师表插入情况
 */
public interface T20Query {
	
	/**
	 * 获取真实姓名
	 * @return
	 */
	public String getRealName();
	
	/**
	 * 获取性别
	 * @return
	 */
	public Gender getGender();
	
	/**
	 * 获取出生日期
	 * @return
	 */
	public Date getBornDate();
	
	/**
	 * 获取个人简介
	 * @return
	 */
	public String getPersonalIntroduce();
	
	/**
	 * 获取从业开始时间
	 * @return
	 */
	public Date getEmployDate();
	
	/**
	 * 获取毕业院校
	 * @return
	 */
	public String getSchool();
	
	/**
	 * 获取从业公司
	 * @return
	 */
	public String getCompany();
	
	/**
	 * 获取图像链接
	 * @return
	 */
	public String getHeadImgLink();
	
	/**
	 * 学历
	 * @return
	 */
	public Degree getDegree();
}
