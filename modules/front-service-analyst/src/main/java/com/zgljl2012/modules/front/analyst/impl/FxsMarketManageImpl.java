package com.zgljl2012.modules.front.analyst.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.common.database.T20;
import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.Degree;
import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.analyst.FxsMarketManage;
import com.zgljl2012.modules.front.analyst.query.FxsInfoQuery;
import com.zgljl2012.modules.project.CommentManage;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午8:19:44
 * 
 */
public class FxsMarketManageImpl extends AbstractService implements FxsMarketManage{
	
	CommentManage commentManage;
	
	public FxsMarketManageImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JSON search(FxsInfoQuery query, PagingInfo pagingInfo) {
		StringBuilder sql = new StringBuilder("SELECT * FROM T10 AS t1 "
				+ "LEFT JOIN T20 AS t2 ON t1.F01 = t2.F01 WHERE t1.F05 = 'FXS' "
				+ "AND t2.F05 IS NOT NULL AND t2.F06 IS NOT NULL AND t2.F10 IS NOT NULL");
		ArrayList<Object> args = new ArrayList<>();
		commentManage = controller.getServiceManage().getService(CommentManage.class);
		if(query != null) {
			if(query.getDegree() != null) {
				sql.append(" AND t2.F10 = ? ");
				args.add(query.getDegree().name());
			}
			if(query.getWorkTime() > -1) {
				sql.append(" AND YEAR(CURRENT_DATE()) - YEAR(t2.F06) >= ?");
				args.add(query.getWorkTime());
			}
			if(query.getGrade() > 0) {
				float star = query.getGrade();
				sql .append(" AND "+ 
					"(SELECT AVG(t3.F03) FROM T70 AS t3 LEFT JOIN T40 AS t4 ON "
					+ "t3.F01 = t4.F01 WHERE t4.F15 = t1.F01)"+" > " 
					+ (star-1)+ " AND " +
					"(SELECT AVG(t3.F03) FROM T70 AS t3 LEFT JOIN T40 AS t4 ON "
					+ "t3.F01 = t4.F01 WHERE t4.F15 = t1.F01)"
					+" <= "+star);
				
			}
		}
		Connection conn = getConnection();
		ResultSet rs = 
				selectPaging(conn, sql.toString(), pagingInfo, 
						args.toArray());
		JSON result = new JSON();
		try {
			List<JSON> list = new ArrayList<>();
			while(rs.next()) {
				T10 t10 = new T10();
				int j = 1;
				int fxsId = rs.getInt(j++);
				t10.setF01(fxsId);
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
				JSON jtmp = (JSON) json.get("t20");
				// 进行学历的中文转化
				if(t20.getF10() != null) {
					jtmp.put("F10", t20.getF10().getChineseName());
				}
				if(t20.getF02() != null) {
					jtmp.put("F02", StringHelper.asteriskRealName(t20.getF02()));
				}
				
				json.put("t20", jtmp);
				try {
					float avg = commentManage.getAverageOfFxs(fxsId);
					json.put("avg", ""+avg);
				} catch (PostException e) {
					e.printStackTrace();
					json.put("avg", ""+0);
				}
				list.add(json);
			}
			rs.close();
			rs.getStatement().close();
			this.close(conn);
			result.put("data", list);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			this.close(conn);
		}
		return null;
	}

	@Override
	public int fxsCount(FxsInfoQuery query) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM T20 AS t1 WHERE 1=1 "
				+ "AND t1.F05 IS NOT NULL AND t1.F06 IS NOT NULL AND t1.F10 IS NOT NULL");
		ArrayList<Object> args = new ArrayList<>();
		if(query != null) {
			if(query.getDegree() != null) {
				sql.append(" AND F10 = ? ");
				args.add(query.getDegree().name());
			}
			if(query.getWorkTime() > -1) {
				sql.append(" AND YEAR(CURRENT_DATE()) - YEAR(F06) >= ?");
				args.add(query.getWorkTime());
			}
			if(query.getGrade() > 0) {
				float star = query.getGrade();
				sql .append(" AND "+ 
					"(SELECT AVG(t3.F03) FROM T70 AS t3 LEFT JOIN T40 AS t4 ON "
					+ "t3.F01 = t4.F01 WHERE t4.F15 = t1.F01)"+" > " 
					+ (star-1)+ " AND " +
					"(SELECT AVG(t3.F03) FROM T70 AS t3 LEFT JOIN T40 AS t4 ON "
					+ "t3.F01 = t4.F01 WHERE t4.F15 = t1.F01)"
					+" <= "+star);
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
			rs.getStatement().close();
			conn.close();
			return r;
		} catch (SQLException e) {
			close(conn);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public JSON getFxs(int id) {
		String sql = "SELECT t1.*, t2.* FROM T10 as t1 LEFT JOIN "
				+ "T20 as t2 ON t1.F01 = t2.F01 "
				+ "WHERE t1.F06 = 'F' AND t1.F01 = ?";
		final JSON json = new JSON();
		Connection conn = getConnection();
		try {
			this.select(conn, sql, new SelectExecutor() {
				@Override
				public void execute(ResultSet rs) {
					try {
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
							
							json.put("t10", t10);
							json.put("t20", t20);
							JSON jtmp = (JSON) json.get("t20");
							// 进行学历的中文转化
							if(t20.getF10() != null) {
								jtmp.put("F10", t20.getF10().getChineseName());
							}
							
							json.put("t20", jtmp);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return json;
	}

}
