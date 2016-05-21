package com.zgljl2012.modules.project;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.query.ProjectBaseInfoQuery;
import com.zgljl2012.modules.project.query.ProjectListIndeQuery;
import com.zgljl2012.modules.project.query.ProjectStatusPaggingQuery;

/**
 * @author 廖金龙
 * @version 2016年4月14日下午9:12:55
 * 项目管理接口，包括增删改查四种类型的操作
 */
public interface ProjectManage extends Service{
	
	/**
	 * 新增项目
	 * @param uid 企业用户ID
	 * @param query 项目信息
	 * @return 项目ID
	 */
	public void addProject(int uid, ProjectBaseInfoQuery query) throws Exception;
	
	/**
	 * 修改项目信息
	 * @param pid 项目ID
	 * @param query 项目信息接口
	 * @return 项目ID
	 */
	public void updateProject(int pid, ProjectBaseInfoQuery query) throws PostException;

	/**
	 * 当uid为0时，就查询所有用户对于状态的项目
	 * @param uid
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public JSON projectList(int uid, ProjectStatusPaggingQuery query) throws Exception;
	
	/**
	 * 查询项目数目，当uid为0时查询所有项目个数
	 * @param uid
	 * @return
	 */
	public int getProjectSize(int uid);
	
	/**
	 * 查询项目数目，当uid为0时查询所有项目个数
	 * @param uid
	 * @return
	 */
	public int getProjectSize(int uid, T40_F05 status);
	
	/**
	 * 获取项目信息
	 * @param projectId
	 * @return
	 */
	public JSON getProjectInfo(int projectId);
	
	/**
	 * 发布项目
	 * @param projectId
	 */
	public void realeaseProject(int projectId);
	
	/**
	 * 项目市场项目列表
	 * @param query
	 * @return
	 */
	public JSON getProjectIndexList(ProjectListIndeQuery query) throws Exception;
	
	/**
	 * 查询项目数目，当uid为0时查询所有项目个数
	 * @param uid
	 * @return
	 */
	public int getProjectSize(ProjectListIndeQuery status);
	
	/**
	 * 设置项目已结束
	 * @param projectId
	 * @throws PostException
	 */
	public void setProjectYJS(int projectId) throws PostException;
	
	/**
	 * 设置项目审核不通过
	 * @param projectId
	 * @param reason
	 * @throws PostException
	 */
	public void setNoPass(int uid, int projectId, String reason) throws PostException;
	
	/**
	 * 附件上传
	 * @param pid
	 * @param filename
	 * @throws PostException
	 */
	public void attachmentUpload(int pid, String filename) throws PostException;
	
	/**
	 * 获取附件路径
	 * @param pid
	 * @return
	 * @throws PostException
	 */
	public String getAttachment(int pid) throws PostException;
	
	/**
	 * 此项目是否已经上传了文件
	 * @param pid
	 * @return
	 * @throws PostException
	 */
	public boolean isHasAttachment(int pid) throws PostException;
	
	/**
	 * 获取一个项目的项目状态
	 * @param pid
	 * @return
	 * @throws PostException
	 */
	public T40_F05 getProjectStatus(int pid) throws PostException;
}
