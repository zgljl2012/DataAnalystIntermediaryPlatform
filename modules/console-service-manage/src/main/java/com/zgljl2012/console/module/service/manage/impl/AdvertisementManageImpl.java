package com.zgljl2012.console.module.service.manage.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.T80;
import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T80_F06;
import com.zgljl2012.console.module.service.manage.AdvertisementManage;
import com.zgljl2012.console.module.service.manage.query.AdvertisementQuery;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午5:46:43
 * 
 */
public class AdvertisementManageImpl extends 
	AbstractService implements AdvertisementManage{

	public AdvertisementManageImpl(Controller controller) {
		super(controller);
	}

	@Override
	public void add(AdvertisementQuery query) {
		String sql = "INSERT INTO T80(F02,F03,F04,F05,F06,F07) VALUES(?,?,?,?,?,?)";
		List<Object> args = new ArrayList<>();
		args.add(query.getPath());
		args.add(query.getTitle());
		args.add(query.getHref());
		args.add(this.getNowTimestamp());
		args.add(T80_F06.XJ.name());
		args.add(Bool.F.name());
		Connection conn = this.getConnection();
		try {
			this.insert(conn, sql, null, args.toArray());
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	@Override
	public JSON list(PagingInfo info) {
		StringBuffer sql = new StringBuffer("SELECT * FROM T80 "
				+ "WHERE F07 ='F'");
		List<Object> args = new ArrayList<>();
		Connection conn = this.getConnection();
		ResultSet rs = 
				this.selectPaging(conn, sql.toString(), info, args.toArray());
		final JSON json = new JSON();
		try {
			List<JSON> list = new ArrayList<>();
			while(rs.next()) {
				JSON j = new JSON();
				j.put("F01", ""+rs.getInt(1));
				j.put("F02", rs.getString(2));
				j.put("F03", rs.getString(3));
				j.put("F04", rs.getString(4));
				j.put("F05", sdf.format(rs.getTimestamp(5)));
				j.put("F06", rs.getString(6));
				list.add(j);
			}
			json.put("data", list);
			String tmp = "SELECT COUNT(F01) FROM T80 WHERE F07='F' ";
			this.select(conn, tmp, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							json.put("count", ""+rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, args.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return json;
	}

	@Override
	public T80 detail(int aid) {
		String sql = "SELECT * FROM T80 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, aid);
			T80 t = new T80();
			if(rs.next()) {
				t.setF01(rs.getInt(1));
				t.setF02(rs.getString(2));
				t.setF03(rs.getString(3));
				t.setF04(rs.getString(4));
				t.setF05(rs.getTimestamp(5));
				t.setF06(T80_F06.parse(rs.getString(6)));
			}
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return null;
	}

	@Override
	public void xj(int aid) {
		String sql = "UPDATE T80 SET F06='XJ' WHERE F01= ?";
		Connection conn = this.getConnection();
		try {
			this.execute(conn, sql, aid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public void sc(int aid) {
		String sql = "UPDATE T80 SET F07='S' WHERE F01= ?";
		Connection conn = this.getConnection();
		try {
			this.execute(conn, sql, aid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public void sj(int aid) {
		String sql = "UPDATE T80 SET F06='SJ' WHERE F01= ?";
		Connection conn = this.getConnection();
		try {
			this.execute(conn, sql, aid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

}
