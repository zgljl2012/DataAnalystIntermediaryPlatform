package com.zgljl2012.modules.project;

import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月8日下午3:49:50
 * 评论管理
 */
public interface CommentManage extends Service{
	
	/**
	 * 分析师评价企业
	 * @param projectId 项目ID
	 * @param comment 评论
	 * @param grade 分数
	 */
	void fxs2qy(int projectId, String comment, float grade) throws PostException;
	
	/**
	 * 企业评论分析师
	 * @param projectId 项目ID
	 * @param comment 评论
	 * @param grade 分数
	 */
	void qy2fxs(int projectId, String comment, float grade) throws PostException;
	
	/**
	 * 这个项目是否有分析师给企业的评论
	 * @param projectId
	 * @return
	 */
	boolean isExistsCommentOfFxs(int projectId) throws PostException;
	
	/**
	 * 这个项目是否有企业给分析师的评论
	 * @param projectId
	 * @return
	 */
	boolean isExistsCommentOfQy(int projectId) throws PostException;
	
	JSON getQy2Fxs(int projectId) throws PostException;
	
	JSON getFxs2Qy(int projectId) throws PostException;
	
	/**
	 * 获取企业平均分
	 * @param projectId
	 * @return
	 * @throws PostException
	 */
	float getAverageOfQy(int projectId) throws PostException;
	
	/**
	 * 获取分析师平均分
	 * @param fxsId
	 * @return
	 * @throws PostException
	 */
	float getAverageOfFxs(int fxsId) throws PostException;
}
