package com.zgljl2012.framework.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Administrator
 *
 */
public interface DatabaseProvider {
	
	public Connection getConnection();
	
	public void close(Connection conn);
	
	public void close(Statement pst);
	
	public void close(ResultSet rs);
	
	public void close(Connection conn,Statement pst,ResultSet rs);
	
}
