package com.zgljl2012.framework.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.DatabaseOperate;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.InsertExecutor;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;

/** 
 * @author 廖金龙
 * @version 创建时间：2016年2月18日 下午4:07:22 
 * 抽象业务模块类
 */
public abstract class AbstractService implements Service, DatabaseOperate{
	
	// 控制器
	protected Controller controller;
	
	// 数据库连接池管理
	private DatabaseProvider db;
	
	public AbstractService(Controller controller) {
		this.controller = controller;
		this.db = controller.getDatabaseProvider();
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public final Connection getConnection() {
		return db.getConnection();
	}
	
	/**
	 * 关闭数据库连接
	 */
	public final void close(Connection conn) {
		db.close(conn);
	}
	
	/**
	 * 查询
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(Connection conn, String sql, Object... args) throws SQLException {
		return db.select(conn, sql, args);
	}
	
	/**
	 * 执行sql语句
	 * @param conn
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	public void execute(Connection conn, String sql, Object ...args) throws SQLException {
		this.db.execute(conn, sql, args);
	}
	
	/**
	 * 增加
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public int insert(Connection conn, String sql, Object ...args) throws Throwable {
		return db.insert(conn, sql, args);
	}
	
	/**
	 * 修改
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection conn, String sql, Object ...args) throws SQLException {
		return db.update(conn, sql, args);
	}
	
	
	/**
	 * 分页查询方法
	 * @param sql
	 * @param pagingInfo
	 * @param args
	 * @return
	 */
	public ResultSet selectPaging(Connection conn, String sql, 
			PagingInfo pagingInfo, Object... args) {
		return db.selectPaging(conn, sql, pagingInfo, args);
	}
	
	/**
	 * 输入表名获取总页数
	 * @param conn
	 * @param table
	 * @return
	 */
	public int getPageCount(Connection conn, String table) {
		return db.getPageCount(conn, table);
	}
	
	/**
	 * 返回当前时间戳
	 * @return
	 */
	public Timestamp getNowTimestamp() {
		return new Timestamp(new java.util.Date().getTime());
	}
	
	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return this.controller;
	}
	
	@Override
	public void select(Connection conn, String sql,
			SelectExecutor executor, Object... args) throws SQLException {
		this.db.select(conn, sql, executor, args);
	}

	@Override
	public int insert(Connection conn, String sql,
			InsertExecutor executor, Object... args) throws Throwable {
		return this.db.insert(conn, sql, executor, args);
	}

	@Override
	public void update(Connection conn, String sql,
			UpdateExecutor executor, Object... args) throws SQLException {
		this.db.update(conn, sql, executor, args);
	}
	
}
