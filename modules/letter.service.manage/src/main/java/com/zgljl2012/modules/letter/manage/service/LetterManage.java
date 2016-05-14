package com.zgljl2012.modules.letter.manage.service;

import java.util.List;

import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月14日下午6:28:43
 * 站内信
 */
public interface LetterManage extends Service{
	
	/**
	 * 点对点发送站内信
	 * @param fromId 当为0时为系统发送
	 * @param toId
	 * @param title
	 * @param content
	 */
	void sendLetter(int fromId, int toId, String title, String content);
	
	/**
	 * 发送给所有用户
	 * @param fromId
	 * @param title
	 * @param content
	 */
	void sendLetterToAll(int fromId, String title, String content);
	
	/**
	 * 给指定的用户发送站内信
	 * @param fromId
	 * @param listToID
	 * @param title
	 * @param content
	 */
	void sendLetter(int fromId, List<Integer> listToID, String title, String content);
	
	/**
	 * 读取用户所有的站内信，按时间排序
	 * @param userId
	 * @return
	 */
	JSON getAllLetter(int userId);
	
	/**
	 * 查询一封站内信是否已读
	 * @param lid
	 * @return
	 */
	boolean isReaded(int lid);
	
	/**
	 * 删除一封站内信
	 * @param lid
	 */
	void deleteLetter(int lid);
	
	/**
	 * 设置一封站内信为已读
	 * @param lid
	 */
	void readedLetter(int lid);
}
