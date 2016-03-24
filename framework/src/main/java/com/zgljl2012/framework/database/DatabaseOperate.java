package com.zgljl2012.framework.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zgljl2012.framework.database.executor.InsertExecutor;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;

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
	
	/*******************************************************************
	 * 通过回调接口返回数据，会自动关闭Statement和ResultSet，最好使用下面的接口
	 *******************************************************************/
	
	/**
	 * 查询
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public void select(Connection conn, String sql, 
			SelectExecutor executor, Object... args) throws SQLException;
	
	/**
	 * 增加
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public void insert(Connection conn, String sql, 
			InsertExecutor executor, Object ...args) throws Throwable;
	
	/**
	 * 修改
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public void update(Connection conn, String sql, 
			UpdateExecutor executor, Object ...args) throws SQLException;
	
	
	
}
