package com.zgljl2012.modules.project;

import com.zgljl2012.common.database.enums.T40_F05;
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
	
	/**
	 * 删除一个投标单
	 * @param bidId
	 * @throws PostException
	 */
	void del(int bidId) throws PostException;
	
	/**
	 * 中标
	 * @param bidId
	 * @throws PostException
	 */
	void select(int bidId) throws PostException;
	
	/**
	 * 此项目是否处于进行中状态
	 * @param projectId
	 * @return
	 */
	boolean isSelected(int projectId);
	
	/**
	 * 分析师投标情况查询
	 * @param uid
	 * @param status
	 * @return
	 * @throws PostException
	 */
	JSON queryFxs(int uid, T40_F05 status, PagingInfo info) throws PostException;
	
	/**
	 * 分析师投标情况数量查询
	 * @param uid
	 * @param status
	 * @return
	 */
	int queryFxsCount(int uid, T40_F05 status);
	
	/**
	 * 是否存在此项目
	 * @param pid
	 * @return
	 */
	boolean isExistsProjectId(int pid);
	
	/**
	 * 这个用户是否投了这个标
	 * @param projectId
	 * @param uid
	 * @return
	 */
	boolean isExistsThisBid(int projectId, int uid);
	
	/**
	 * 更新评论和报价
	 * @param bid
	 * @param comment
	 * @param price
	 */
	void update(int bid, String comment, float price) throws PostException;
	
	/**
	 * 获取中标人用户ID，如果没有则返回-1
	 * @param projectId
	 * @return
	 */
	int getSelectedUserId(int projectId);
	
}
