package com.zgljl2012.framework.simple.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zgljl2012.framework.database.C3P0Util;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.InsertExecutor;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;

public class DatabaseProviderSimple implements DatabaseProvider {
	
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return C3P0Util.getConnection();
	}

	public void close(Connection conn) {
		// TODO Auto-generated method stub
		if(conn!=null){  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }
        }
	}

	public void close(Statement pst) {
		// TODO Auto-generated method stub
		if(pst!=null){  
            try {  
                pst.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }      
	}

	public void close(ResultSet rs) {
		// TODO Auto-generated method stub
		if(rs!=null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }
	}

	public void close(Connection conn, Statement pst, ResultSet rs) {
		// TODO Auto-generated method stub
		C3P0Util.close(conn, pst, rs);
	}

	@Override
	public ResultSet selectPaging(Connection conn, String sql, PagingInfo pagingInfo,
			Object... args) {
		PreparedStatement stmt;
		try {
			int pageSize = pagingInfo.getPageSize();
			if(pageSize <= 0) pageSize = 1;
			int current = pagingInfo.getCurrentPage();
			if(current < 1) current = 1;
			current--;
			current = current * pageSize;
			sql += " LIMIT " +  current + ", " + pageSize;
			stmt = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int getPageCount(Connection conn, String table) {
		String sql = "SELECT COUNT(*) FROM " + table;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt(1);
				rs.close();
				st.close();
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
	public void execute(Connection conn, String sql, Object ...args) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		stmt.execute();
		stmt.close();
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
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		stmt.executeUpdate();
		ResultSet resultSet = stmt.getGeneratedKeys(); 
		try
	    {
	        if (resultSet.next()) {
	        	int id = resultSet.getInt(1);
	        	resultSet.close();
	        	stmt.close();
	        	return id;
	        }
	        return 0;
	    }
	    catch (Throwable localThrowable5)
	    {
	        throw localThrowable5;
	    }
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
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 0; i < args.length; i++) {
			stmt.setObject(i+1, args[i]);
		}
		int count = stmt.executeUpdate();
		stmt.close();
		return count;
	}

	@Override
	public void select(Connection conn, String sql, SelectExecutor executor,
			Object... args) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		try {
			for(int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			rs = stmt.executeQuery();
			if(executor != null) {
				executor.execute(rs);
			}
		} catch(SQLException e) {
			throw e;
		} finally {
			if(rs != null) {
				rs.close();
			}
			stmt.close();
		}
	}

	@Override
	public void insert(Connection conn, String sql, InsertExecutor executor,
			Object... args) throws Throwable {
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null; 
		try {
			for(int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			stmt.executeUpdate();
			resultSet = stmt.getGeneratedKeys();
	        if (resultSet.next()) {
	        	int id = resultSet.getInt(1);
	        	if(executor != null) {
	        		executor.execute(id);
	        	}
	        }
	    } catch (Throwable localThrowable5) {
	        throw localThrowable5;
	    } finally {
	    	if(resultSet != null) {
	    		resultSet.close();
	    	}
	    	stmt.close();
	    }
	}

	@Override
	public void update(Connection conn, String sql, UpdateExecutor executor,
			Object... args) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(sql);
		try{
			for(int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			int rows = stmt.executeUpdate();
			if(executor != null) {
				executor.execute(rows);
			}
		} catch(SQLException e) {
			throw e;
		} finally {
			stmt.close();
		}
	}

}
