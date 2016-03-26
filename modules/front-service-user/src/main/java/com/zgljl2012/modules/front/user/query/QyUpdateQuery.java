package com.zgljl2012.modules.front.user.query;

/**
 * @author 廖金龙
 * @version 2016年3月26日下午10:35:00
 * 企业信息更新接口
 */
public interface QyUpdateQuery {
	
	/**
	 * 用户名
	 * @return
	 */
	public String getUsername();
	
	/**
	 * 邮箱
	 * @return
	 */
	public String getEmail();
	
	/**
	 * 公司名称
	 * @return
	 */
	public String getCompanyName();
	
	/**
	 * 主营业务
	 * @return
	 */
	public String getBusiness();
	
	/**
	 * 备注说明
	 * @return
	 */
	public String getRemark();
	
}
