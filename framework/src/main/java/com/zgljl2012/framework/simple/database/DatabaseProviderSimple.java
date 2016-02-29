package com.zgljl2012.framework.simple.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zgljl2012.framework.database.C3P0Util;
import com.zgljl2012.framework.database.DatabaseProvider;

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

}
