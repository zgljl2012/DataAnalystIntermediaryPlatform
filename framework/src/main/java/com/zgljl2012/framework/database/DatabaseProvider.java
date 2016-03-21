package com.zgljl2012.framework.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Administrator
 *
 */
public interface DatabaseProvider extends DatabaseOperate{
	
	public Connection getConnection();
	
	public void close(Connection conn);
	
	public void close(Statement pst);
	
	public void close(ResultSet rs);
	
	public void close(Connection conn,Statement pst,ResultSet rs);
	
	/**
	 * 分页查询方法
	 * @param sql
	 * @param pagingInfo
	 * @param args
	 * @return
	 */
	public ResultSet selectPaging(Connection conn, String sql, 
			PagingInfo pagingInfo, Object... args);
	
	/**
	 * 输入表名获取总页数
	 * @param conn
	 * @param table
	 * @return
	 */
	public int getPageCount(Connection conn, String table);
}
