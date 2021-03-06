package com.zgljl2012.modules.front.user;

import java.util.List;

import com.zgljl2012.common.database.T20;
import com.zgljl2012.common.database.T21;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.modules.front.user.query.FxsWorkExperienceQuery;
import com.zgljl2012.modules.front.user.query.T20Query;

/**
 * @author 廖金龙
 * @version 2016年2月29日上午10:05:23
 * 分析师用户管理
 */
public interface FxsManage extends Service{
	
	/**
	 * 根据T20Query里的内容，更新T20
	 * @param uid
	 * @param query
	 * @throws Exception 
	 */
	public void update(int uid, T20Query query) throws Exception;
	
	/**
	 * 获取分析师基本信息 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public T20 getT20(int uid) throws Exception;
	
	/**
	 * 上传图像，存储图像的相对路径到数据库
	 * @param fileName
	 * @throws Exception
	 */
	public void updateHeadImage(int uid, String fileName) throws Exception;
	
	/**
	 * 新增分析师工作经历信息
	 * @param uid
	 * @param query
	 */
	public int insertWorkExperience(int uid, FxsWorkExperienceQuery query);
	
	/**
	 * 分页查询分析师的从业经历
	 * @param uid
	 * @param query
	 * @param pagingInfo
	 * @return
	 */
	public List<T21> search(int uid, FxsWorkExperienceQuery query, PagingInfo pagingInfo);
	
	/**
	 * 获取从业经历的条数
	 * @return
	 */
	public int getCountWorkExperience(int uid);
	
	/**
	 * 删除工作经历
	 * @param uid 用户ID
	 * @param id 工作经历ID
	 */
	public void deleteWorkExperienceItem(int id) throws Exception;
}
