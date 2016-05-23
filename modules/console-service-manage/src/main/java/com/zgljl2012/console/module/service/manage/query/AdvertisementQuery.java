package com.zgljl2012.console.module.service.manage.query;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午5:34:08
 * 
 */
public interface AdvertisementQuery {
	
	/**
	 * 广告图片路径
	 * @return
	 */
	String getPath();
	
	/**
	 * 广告标题
	 * @return
	 */
	String getTitle();
	
	/**
	 * 广告链接
	 * @return
	 */
	String getHref();
	
}
