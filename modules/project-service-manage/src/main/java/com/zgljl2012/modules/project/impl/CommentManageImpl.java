package com.zgljl2012.modules.project.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
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

}
