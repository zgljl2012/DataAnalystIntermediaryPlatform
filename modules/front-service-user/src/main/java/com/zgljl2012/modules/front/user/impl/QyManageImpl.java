package com.zgljl2012.modules.front.user.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.user.QyManage;
import com.zgljl2012.modules.front.user.query.QyUpdateQuery;

/**
 * @author 廖金龙
 * @version 2016年3月26日下午10:39:55
 * 
 */
public class QyManageImpl extends AbstractService implements QyManage{

	public QyManageImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JSON getQyInfo(int uid) throws Exception {
		String sql = "SELECT t1.F02,t1.F03,t2.F02,t2.F03,t2.F04, t1.F08 "
				+ "FROM T10 AS t1 LEFT JOIN T30 AS t2 "
				+ "ON t1.F01 = t2.F01 WHERE t1.F05 = 'QY' "
				+ "AND t1.F01 = ?";
		Connection conn = getConnection();
		final JSON result = new JSON();
		try {
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							result.put("username", rs.getString(1));
							result.put("email", rs.getString(2));
							result.put("companyName", rs.getString(3));
							result.put("business", rs.getString(4));
							result.put("remark", rs.getString(5));
							result.put("status", rs.getString(6));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, uid);
		} catch (SQLException e) {
			throw e;
		} finally {
			conn.close();
		}
		return result;
	}

	@Override
	public void updateQyInfo(int uid, QyUpdateQuery query) 
			throws Exception {
		Connection conn = this.getConnection();
		// 检查UID是否存在
		ResultSet rs = this.select(conn, "SELECT F01,F02,F03 FROM T10 WHERE F01 = ?", uid);
		if(!rs.next()) {
			throw new Exception("没有找到该用户！");
		}
		
		
	}

}
