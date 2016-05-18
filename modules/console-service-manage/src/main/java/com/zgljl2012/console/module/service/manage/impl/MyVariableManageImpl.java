package com.zgljl2012.console.module.service.manage.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.console.module.service.manage.MyVariableManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月17日下午10:40:47
 * 
 */
public class MyVariableManageImpl extends AbstractService 
	implements MyVariableManage{

	public MyVariableManageImpl(Controller controller) {
		super(controller);
	}

	@Override
	public JSON getVariableBeanList(String name, PagingInfo info) {
		String sql = "SELECT * FROM H10 WHERE 1=1 ";
		Connection conn = this.getConnection();
		if(name != null) {
			sql += " AND F02 like '%"+name+"%'";
		}
		ResultSet rs = this.selectPaging(conn, sql, info, new Object[]{});
		JSON json = new JSON();
		List<JSON> ls = new ArrayList<>();
		try {
			while(rs.next()) {
				JSON j = new JSON();
				j.put("key", rs.getString(1));
				j.put("name", rs.getString(2));
				j.put("description", rs.getString(3));
				j.put("value", rs.getString(4));
				ls.add(j);
			}
			json.put("data", ls);
			sql = "SELECT COUNT(F01) FROM H10 WHERE 1=1 ";
			if(name != null) {
				sql += " AND F02 like '%"+name+"%'";
			}
			ResultSet rs1 = this.select(conn, sql, new Object[]{});
			if(rs1.next()) {
				int count = rs1.getInt(1);
				json.put("count", ""+count);
			}
			rs1.close();
			rs1.getStatement().close();
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rs.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
		return null;
	}

}
