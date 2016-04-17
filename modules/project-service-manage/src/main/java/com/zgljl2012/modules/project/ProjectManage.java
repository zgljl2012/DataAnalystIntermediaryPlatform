package com.zgljl2012.modules.project;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.query.ProjectBaseInfoQuery;

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
	public void updateProject(int pid, ProjectBaseInfoQuery query) throws Exception;

	/**
	 * 当uid为0时，就查询所有用户对于状态的项目
	 * @param uid
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public JSON projectList(int uid, T40_F05 status) throws Exception;
	
}
