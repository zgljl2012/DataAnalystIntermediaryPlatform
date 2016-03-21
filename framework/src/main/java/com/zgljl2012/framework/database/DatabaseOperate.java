package com.zgljl2012.framework.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 廖金龙
 * @version 2016年3月21日下午9:37:48
 * 
 */
public interface DatabaseOperate {
	/**
	 * 查询
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(Connection conn, String sql, Object... args) throws SQLException;
	
	/**
	 * 执行sql语句
	 * @param conn
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	public void execute(Connection conn, String sql, Object ...args) throws SQLException;
	
	/**
	 * 增加
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public int insert(Connection conn, String sql, Object ...args) throws Throwable;
	
	/**
	 * 修改
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection conn, String sql, Object ...args) throws SQLException;
	
}
