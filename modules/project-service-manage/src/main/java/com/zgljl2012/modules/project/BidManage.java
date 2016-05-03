package com.zgljl2012.modules.project;

import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年4月27日下午11:43:58
 * 投标接口
 */
public interface BidManage extends Service{
	
	/**
	 * 投标
	 * @param projectId 项目ID
	 * @param uid 用户ID
	 * @param price 报价
	 * @return 投标订单
	 */
	int bid(int projectId, int uid, float price) throws PostException;
	
	/**
	 * 留言（新增以及修改）
	 * @param bidId
	 * @param comment
	 */
	void comment(int bidId, String comment) throws PostException;
	
	/**
	 * 撤销报价与投标
	 * @param bidId
	 */
	void cancel(int bidId) throws PostException;
	
	/**
	 * 返回投标单列表
	 * @param projectId
	 * @return
	 * @throws PostException
	 */
	JSON list(int projectId) throws PostException;
	
	/**
	 * 分页返回投标单列表
	 * @param projectId
	 * @param info
	 * @return
	 * @throws PostException
	 */
	JSON list(int projectId, PagingInfo info) throws PostException;
	
	/**
	 * 此项目是否由此用户发布
	 * @param projectId
	 * @param uid
	 * @return
	 * @throws PostException
	 */
	boolean isMatch(int projectId, int uid) throws PostException;
	
}
