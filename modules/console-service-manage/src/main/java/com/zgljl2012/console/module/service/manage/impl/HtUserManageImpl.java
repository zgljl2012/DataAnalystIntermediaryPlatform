package com.zgljl2012.console.module.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.console.module.service.manage.HtUserManage;
import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.console.module.service.manage.query.FrontUserQuery;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午4:25:19
 * 后台用户管理
 */
public class HtUserManageImpl extends AbstractService implements HtUserManage{
	
	PermissionManage pm;
	
	public HtUserManageImpl(Controller controller) {
		super(controller);
	}

	public int login(String username, String password) throws PostException {
		Connection conn = this.getConnection();
		if(StringHelper.isEmpty(username)) {
			throw new PostException("用户名不能为空");
		}
		if(StringHelper.isEmpty(password)) {
			throw new PostException("密码不能为空");
		}
		String sql = "SELECT F01 FROM H21 WHERE F03=? AND F04=? ";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username); // username为用户名
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int uid = rs.getInt(1);
				rs.close();
				pstmt.close();
				return uid;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统正忙");
		}
		return -1;
	}

	@Override
	public void updatePassword(int uid, String pwd) throws Exception {
		Connection conn = this.getConnection();
		this.update(conn, "UPDATE H21 SET F04 = ? WHERE F01 = ?", null, pwd,uid);
		conn.close();
	}

	@Override
	public JSON frontUser(FrontUserQuery query, PagingInfo info) {
		StringBuffer sql = new StringBuffer("SELECT "
				+ "F01,F02,F03,F05,F07,F08 FROM T10 WHERE 1=1 ");
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		List<Object> args = new ArrayList<>();
		if(!StringHelper.isEmpty(query.getUsername())) {
			sql.append(" AND F02 like ?");
			args.add("%"+query.getUsername()+"%");
		}
		if(query.getUserType() != null) {
			sql.append(" AND F05 = ?");
			args.add(query.getUserType().name());
		}
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
				j.put("F05", T10_F05.parse(rs.getString(4)).getChineseName());
				j.put("F07", sdf.format(rs.getTimestamp(5)));
				j.put("F08", T10_F08.parse(rs.getString(6)).getChineseName());
				list.add(j);
			}
			json.put("data", list);
			String tmp = "SELECT COUNT(F01) FROM T10 WHERE 1=1 ";
			if(!StringHelper.isEmpty(query.getUsername())) {
				tmp += (" AND F02 like ?");
			}
			if(query.getUserType() != null) {
				tmp += (" AND F05 = ?");
			}
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
	public void scUser(int uid) {
		Connection conn = this.getConnection();
		try {
			this.execute(conn, "UPDATE T10 SET F06='S',F08='SC' WHERE F01 = ?", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public void uscUser(int uid) {
		Connection conn = this.getConnection();
		try {
			this.execute(conn, "UPDATE T10 SET F06='F',F08='QY' WHERE F01 = ?", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public void hmdUser(int uid) {
		Connection conn = this.getConnection();
		try {
			this.execute(conn, "UPDATE T10 SET F08='HMD' WHERE F01 = ?", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public void uhmdUser(int uid) {
		Connection conn = this.getConnection();
		try {
			this.execute(conn, "UPDATE T10 SET F08='QY' WHERE F01 = ?", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public JSON consoleUser(PagingInfo info) {
		StringBuffer sql = new StringBuffer("SELECT t1.F01,t2.F02, "
				+ "t1.F03,t2.F01 FROM H21 AS t1 LEFT JOIN H20 AS t2 ON "
				+ "t1.F02 = t2.F01 WHERE 1=1 ");
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
				j.put("F04", ""+rs.getInt(4));
				list.add(j);
			}
			json.put("data", list);
			String tmp = "SELECT COUNT(t1.F01) FROM H21 AS t1 "
					+ "LEFT JOIN H20 AS t2 ON t1.F02 = t2.F01 WHERE 1=1 ";
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
	public void scConsoleUser(int uid) {
		Connection conn = this.getConnection();
		try {
			this.execute(conn, "DELETE FROM H21 WHERE F01 = ?", uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public JSON consoleGroup(PagingInfo info) {
		StringBuffer sql = new StringBuffer("SELECT F01,F02 FROM H20 WHERE 1=1 ");
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
				list.add(j);
			}
			json.put("data", list);
			String tmp = "SELECT COUNT(F01) FROM H20 WHERE 1=1 ";
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
	public void addConsoleUserGroup(String name) {
		String sql = "SELECT F01 FROM H20 WHERE F02 LIKE ?";
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, sql, name);
			if(rs.next()) {
				return;
			}
			sql = "INSERT INTO H20(F02) VALUES(?)";
			this.insert(conn, sql, null, name);
			close(rs);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
	}

	@Override
	public void addConsoleUser(int gid, String name, String pwd) {
		String sql = "SELECT F01 FROM H21 WHERE F03 LIKE ?";
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, sql, name);
			if(rs.next()) {
				return;
			}
			sql = "INSERT INTO H21(F02,F03,F04) VALUES(?,?,?)";
			this.insert(conn, sql, null, gid, name, pwd);
			close(rs);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
	}
}
