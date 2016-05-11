package com.zgljl2012.modules.project.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.BidManage;
import com.zgljl2012.modules.project.CommentManage;

/**
 * @author 廖金龙
 * @version 2016年5月8日下午10:17:58
 * 评论管理实现类
 */
public class CommentManageImpl extends AbstractService implements CommentManage{
	
	private BidManage bidManage;
	
	public CommentManageImpl(Controller controller) {
		super(controller);
		bidManage = controller.getServiceManage().getService(BidManage.class);
	}

	@Override
	public void fxs2qy(int projectId, String comment, float grade) 
			throws PostException{
		if(!bidManage.isExistsProjectId(projectId)) {
			throw new PostException("项目不存在");
		}
		String sql = "INSERT INTO T71(F02,F03,F01) VALUES(?,?,?)";
		Object[] args = new Object[]{
				comment, grade, projectId
		};
		if(this.isExistsCommentOfFxs(projectId)) {
			sql = "UPDATE T71 SET F02=?,F03=? WHERE F01=?";
		}
		Connection conn = this.getConnection();
		try {
			this.insert(conn, sql, null, args);
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PostException("系统错误");
		}
	}

	@Override
	public void qy2fxs(int projectId, String comment, float grade) 
			throws PostException{
		if(!bidManage.isExistsProjectId(projectId)) {
			throw new PostException("项目不存在");
		}
		String sql = "INSERT INTO T70(F02,F03,F01) VALUES(?,?,?)";
		Object[] args = new Object[]{
				comment, grade, projectId
		};
		if(this.isExistsCommentOfQy(projectId)) {
			sql = "UPDATE T70 SET F02=?,F03=? WHERE F01=?";
		}
		Connection conn = this.getConnection();
		try {
			this.insert(conn, sql, null, args);
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PostException("系统错误");
		}
	}

	@Override
	public boolean isExistsCommentOfFxs(int projectId) throws PostException{
		String sql = "SELECT F01 FROM T71 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, projectId);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs.getStatement().close();
				}
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean isExistsCommentOfQy(int projectId) {
		String sql = "SELECT F01 FROM T70 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, projectId);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs.getStatement().close();
				}
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public JSON getQy2Fxs(int projectId) throws PostException {
		if(!bidManage.isExistsProjectId(projectId)) {
			throw new PostException("没有找到该项目");
		}
		String sql = "SELECT F02,F03 FROM T70 WHERE F01 = ?";
		final JSON result = new JSON();
		Connection conn = this.getConnection();
		try {
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							result.put("comment", rs.getString(1));
							result.put("grade", ""+rs.getFloat(2));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, projectId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统发生错误");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public JSON getFxs2Qy(int projectId) throws PostException {
		if(!bidManage.isExistsProjectId(projectId)) {
			throw new PostException("没有找到该项目");
		}
		String sql = "SELECT F02,F03 FROM T71 WHERE F01 = ?";
		final JSON result = new JSON();
		Connection conn = this.getConnection();
		try {
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							result.put("comment", rs.getString(1));
							result.put("grade", ""+rs.getFloat(2));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, projectId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统发生错误");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public float getAverageOfQy(int projectId) throws PostException {
		String sql = "SELECT AVG(t1.F03) FROM T71 AS t1 LEFT JOIN T40 AS t2 ON t1.F01 = t2.F01 WHERE t2.F04 = ?";
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, sql, projectId);
			float r = 0;
			if(rs.next()) {
				r = rs.getFloat(1);
			}
			rs.close();
			rs.getStatement().close();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public float getAverageOfFxs(int fxsId) throws PostException {
		String sql = "SELECT AVG(t1.F03) FROM T70 AS t1 LEFT JOIN T40 AS t2 ON t1.F01 = t2.F01 WHERE t2.F15 = ?";
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, sql, fxsId);
			float r = 0;
			if(rs.next()) {
				r = rs.getFloat(1);
			}
			rs.close();
			rs.getStatement().close();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return 0;
	}

}
