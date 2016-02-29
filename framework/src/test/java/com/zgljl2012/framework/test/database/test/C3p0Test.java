package com.zgljl2012.framework.test.database.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.simple.database.DatabaseProviderSimple;

public class C3p0Test {
	
	DatabaseProvider dbProvider;
	
	@Before
	public void before() {
		dbProvider = new DatabaseProviderSimple();
	}
	
	@Test
	public void testSelect() {
		Connection conn=dbProvider.getConnection();  
        String sql = "Select * from student";
        try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(2)+" "+rs.getInt(3));
			}
			dbProvider.close(conn, stat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		Connection conn=dbProvider.getConnection();
		String sql = "insert into student(name, age) values('小红', ?)";
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1, 20);
			ptst.execute();
			dbProvider.close(conn, ptst, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
