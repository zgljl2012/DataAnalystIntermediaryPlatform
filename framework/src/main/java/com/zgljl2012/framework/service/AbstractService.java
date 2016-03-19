package com.zgljl2012.framework.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.database.PagingInfo;

/** 
 * @author 廖金龙
 * @version 创建时间：2016年2月18日 下午4:07:22 
 * 抽象业务模块类
 */
public abstract class AbstractService implements Service{
	
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
	
	protected ResultSet select(Connection conn, String sql, Object... args) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		ResultSet rs = stmt.executeQuery();
		return rs;
	}
	
	/**
	 * 执行sql语句
	 * @param conn
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	protected void execute(Connection conn, String sql, Object ...args) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		stmt.execute();
	}
	
	/**
	 * sql的插入语句，会返回主键（得是int自增型）
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	protected int insert(Connection conn, String sql, Object ...args) throws Throwable {
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		stmt.executeUpdate();
		ResultSet resultSet = stmt.getGeneratedKeys(); 
		try
	    {
	        if (resultSet.next()) {
	          return resultSet.getInt(1);
	        }
	        return 0;
	    }
	    catch (Throwable localThrowable5)
	    {
	        throw localThrowable5;
	    }
	}
	
	/**
	 * sql的更新语句，会返回主键（得是int型）
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	protected int update(Connection conn, String sql, Object ...args) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		return stmt.executeUpdate();
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
}
