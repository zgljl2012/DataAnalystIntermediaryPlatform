package com.zgljl2012.framework.database;  
  
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
 * 数据库工具类 
 * @author 廖金龙
 * @version 0.0.1
 */
public class C3P0Util {
	
	public C3P0Util() {
		
	}
	
	/** 静态C3P0对象 */
    static ComboPooledDataSource cpds=null;
    
    static{
        cpds = new ComboPooledDataSource();
        String driverClass = "com.mysql.jdbc.Driver";   
        String jdbcURL = "jdbc:mysql://localhost:3306/db_01?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";   
        String user = "root";   
        String password = "";   
        try {
			cpds.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        cpds.setJdbcUrl(jdbcURL);   
        cpds.setUser(user);   
        cpds.setPassword(password);   
        cpds.setMaxStatements(100); 
    }
    /** 
     * 获得数据库连接 
     * @return   Connection 数据库连接
     */  
    public static Connection getConnection(){  
        try {  
            return cpds.getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
      
    /** 
     * 数据库关闭操作 
     * @param conn   数据库连接
     * @param st     Statement对象
     * @param rs 	 ResultSet结果集
     */  
    public static void close(Connection conn,Statement st,ResultSet rs){  
        if(rs!=null){  
            try {
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if(st!=null){  
            try {  
                st.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
  
        if(conn!=null){  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }
}