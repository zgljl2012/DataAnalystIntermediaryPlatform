package com.zgljl2012.framework.simple.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zgljl2012.framework.database.C3P0Util;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.database.PagingInfo;

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
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
