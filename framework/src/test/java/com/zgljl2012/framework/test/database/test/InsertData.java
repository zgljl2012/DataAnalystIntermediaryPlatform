package com.zgljl2012.framework.test.database.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;

import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.simple.database.DatabaseProviderSimple;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年3月21日下午9:33:41
 * 
 */
public class InsertData {
	
	@Test
	public void user() throws SQLException {
		DatabaseProvider db = new DatabaseProviderSimple();
		Connection conn = db.getConnection();
		conn.setAutoCommit(false);
		String sql = "INSERT INTO T10(F02,F03,F04,F05,F06,F07,F08) VALUES(? ,? ,? ,? ,? ,? ,?)";
		String t20 = "INSERT INTO T20(F01) VALUES(?)"; // 插分析师资料简介
		try{
			int size = 30;
			for(int i=0;i<size;i++) {
				int uid = db.insert(conn, sql, 
						"test_"+i,
						"26934"+i+"@qq.com",
						StringHelper.crypt("123456"),
						"FXS",
						"F",
						new Timestamp(new java.util.Date().getTime()),
						"WJH");
				db.insert(conn, t20, uid);
			}
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
