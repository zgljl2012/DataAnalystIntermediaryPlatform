package com.zgljl2012.modules.front.analyst.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.common.database.T20;
import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.Degree;
import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.analyst.FxsMarketManage;
import com.zgljl2012.modules.front.analyst.query.FxsInfoQuery;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午8:19:44
 * 
 */
public class FxsMarketManageImpl extends AbstractService implements FxsMarketManage{

	public FxsMarketManageImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JSON search(FxsInfoQuery query, PagingInfo pagingInfo) {
		StringBuilder sql = new StringBuilder("SELECT * FROM T10 AS t1 "
				+ "LEFT JOIN T20 AS t2 ON t1.F01 = t2.F01 WHERE t1.F05 = 'FXS' ");
		ArrayList<Object> args = new ArrayList<>();
		if(query != null) {
			if(query.getDegree() != null) {
				sql.append(" AND t2.F10 = ?");
				args.add(query.getDegree().name());
			}
			if(query.getWorkTime() > -1) {
				sql.append("AND YEAR(CURRENT_DATE()) - YEAR(t2.F06) >= ?");
				args.add(query.getWorkTime());
			}
			if(query.getGrade() > -1) {
				// 分数暂时不考虑
			}
		}
		Connection conn = getConnection();
		ResultSet rs = 
				selectPaging(conn, sql.toString(), pagingInfo, 
						args.toArray());
		JSON result = new JSON();
		try {
			int i=0;
			while(rs.next()) {
				T10 t10 = new T10();
				int j = 1;
				t10.setF01(rs.getInt(j++));
				t10.setF02(rs.getString(j++));
				t10.setF03(rs.getString(j++));
				t10.setF04(rs.getString(j++));
				t10.setF05(T10_F05.parse(rs.getString(j++)));
				t10.setF06(Bool.parse(rs.getString(j++)));
				t10.setF07(rs.getTimestamp(j++));
				t10.setF08(T10_F08.parse(rs.getString(j++)));
				T20 t20 = new T20();
				t20.setF01(rs.getInt(j++));
				t20.setF02(rs.getString(j++));
				t20.setF03(Gender.parse(rs.getString(j++)));
				t20.setF04(rs.getDate(j++));
				t20.setF05(rs.getString(j++));
				t20.setF06(rs.getDate(j++));
				t20.setF07(rs.getString(j++));
				t20.setF08(rs.getString(j++));
				t20.setF09(rs.getString(j++));
				t20.setF10(Degree.parse(rs.getString(j++)));
				
				JSON json = new JSON();
				json.put("t10", t10);
				json.put("t20", t20);
				i++;
				result.put(""+i, json);
			}
			this.close(conn);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			this.close(conn);
		}
		return null;
	}

	@Override
	public int fxsCount(FxsInfoQuery query) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM T20");
		ArrayList<Object> args = new ArrayList<>();
		if(query != null) {
			if(query.getDegree() != null) {
				sql.append(" AND F10 = ?");
				args.add(query.getDegree().name());
			}
			if(query.getWorkTime() > -1) {
				sql.append("AND YEAR(CURRENT_DATE()) - YEAR(F06) >= ?");
				args.add(query.getWorkTime());
			}
			if(query.getGrade() > -1) {
				// 分数暂时不考虑
			}
		}
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, sql.toString(), args.toArray());
			int r = -1;
			if(rs.next()) {
				r = rs.getInt(1);
			}
			rs.close();
			conn.close();
			return r;
		} catch (SQLException e) {
			close(conn);
			e.printStackTrace();
		}
		return 0;
	}

}
