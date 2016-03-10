package com.zgljl2012.framework.log;

/**
 * @author 廖金龙
 * @version 2016年3月10日下午9:01:49
 * 日志服务接口
 */
public interface AbstractLog {
	
	/**
	 * 输出到控制台
	 * @param s
	 */
	public void console(String s);
	
	/**
	 * 输出Debug级别的日志
	 * @param s
	 */
	public void debug(String s);
	
	/**
	 * 输出错误级别的日志
	 * @param error
	 */
	public void error(String error);
	
}
