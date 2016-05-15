package com.zgljl2012.modules.letter.manage.query;

/**
 * @author 廖金龙
 * @version 2016年5月14日下午6:34:14
 * 站内信查询接口
 */
public interface LetterQuery {
	
	enum Readed {NONE, READED, UNREADED}
	
	/**
	 * 是否是已读站内信
	 * @return
	 */
	Readed getReaded();
	
}
