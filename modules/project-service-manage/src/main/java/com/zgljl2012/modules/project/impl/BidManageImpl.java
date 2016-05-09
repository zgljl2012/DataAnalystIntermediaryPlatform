package com.zgljl2012.modules.project.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.BidManage;
import com.zgljl2012.modules.project.CommentManage;

/**
 * @author 廖金龙
 * @version 2016年4月27日下午11:52:46
 * 
 */
public class BidManageImpl extends AbstractService implements BidManage{
	
	private CommentManage commentManage;
	
	public BidManageImpl(Controller controller) {
		super(controller);
	}

	@Override
	public int bid(int projectId, int uid, float price) throws PostException{
		if(!isExistsUid(uid)) {
			throw new PostException("用户不存在，请刷新重试");
		}
		if(!isExistsProjectId(projectId)) {
			throw new PostException("项目不存在");
		}
		if(isExistsProject(projectId, uid)) {
			throw new PostException("自己不能投自己发的标");
		}
		if(isExistsThisBid(projectId, uid)) {
			throw new PostException("抱歉，只能进行一次投标，但您可以修改自己的评论和报价");
		}
		String sql = "INSERT INTO T50(F02,F03,F04,F05,F06) VALUES(?,?,?,?,?)";
		Object[] args = new Object[]{
			projectId,
			uid,
			price,
			this.getNowTimestamp(),
			Bool.F.name()
		};
		try {
			return this.insert(getConnection(), sql, null, args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void comment(int bidId, String comment) throws PostException{
		if(!isExistsBidId(bidId)) {
			throw new PostException("投标单不存在");
		}
		Boolean ifExist = true;
		// 如果存在就修改
		String sql = "SELECT F01 FROM T51 WHERE F01 = ?";
		ResultSet rs;
		try {
			rs = this.select(getConnection(), sql, bidId);
			if(rs.next()) {
				ifExist = true;
			} else {
				ifExist = false;
			}
			rs.close();
			rs.getStatement().close();
			if(ifExist) {
				sql = "UPDATE T51 SET F02 = ? WHERE F01 = ?";
			} else {
				sql = "INSERT INTO T51(F02, F01) VALUES(?,?) ";
			}
			this.execute(getConnection(), sql, comment, bidId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统发生错误");
		}
		
	}

	@Override
	public void cancel(int bidId) throws PostException{
		if(!isExistsBidId(bidId)) {
			throw new PostException("投标单不存在");
		}
		try {
			this.execute(getConnection(), "UPDATE T50 SET F06=? WHERE F01=? ", 
					new Object[]{
				Bool.S.name(),
				bidId
			});
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统发生错误");
		}
	}
	
	public boolean isExistsUid(int uid) {
		ResultSet rs = null;
		try{
			rs= this.select(getConnection(), 
						"SELECT F01 FROM T10 WHERE F01 = ? ", uid);
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rs.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * T40中是否存在此项目
	 * @param pid
	 * @return
	 */
	public boolean isExistsProjectId(int pid) {
		ResultSet rs = null;
		try{
			rs= this.select(getConnection(), 
					"SELECT F01 FROM T40 WHERE F01 = ? ", pid);
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rs.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * T50中是否存在此投标单
	 * @param bid
	 * @return
	 */
	public boolean isExistsBidId(int bid) {
		ResultSet rs = null;
		try{
			rs= this.select(getConnection(), 
					"SELECT F01 FROM T50 WHERE F01 = ? ", bid);
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rs.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * T40中的此项目是否由此用户发布
	 * @param projectId
	 * @param uid
	 * @return
	 */
	public boolean isExistsProject(int projectId, int uid) {
		String sql = "SELECT F01 FROM T40 WHERE F01=? AND F04 = ?";
		ResultSet rs = null;
		try {
			rs = this.select(getConnection(), sql, projectId, uid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs.getStatement().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return false;
	}
	
	/**
	 * 这个用户是否已在此项目上投标
	 * @param projectId
	 * @param uid
	 * @return
	 */
	public boolean isExistsThisBid(int projectId, int uid) {
		String sql = "SELECT F01 FROM T50 WHERE F02=? AND F03 = ?";
		ResultSet rs = null;
		try {
			rs = this.select(getConnection(), sql, projectId, uid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs.getStatement().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return false;
	}

	@Override
	public JSON list(int projectId) throws PostException {
		String sql = "SELECT t1.*,t2.F02,t3.F02 FROM T50 AS "
				+ "t1 LEFT JOIN T51 AS t2 ON t1.F01 = t2.F01 "
				+ "LEFT JOIN T10 AS t3 ON t1.F03 = t3.F01"
				+ " WHERE t1.F02 = ? AND t1.F06 != 'S'";
		final JSON result = new JSON();
		final SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		try {
			this.select(getConnection(), sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						List<JSON> list = new ArrayList<>();
						while(rs.next()) {
							JSON j = new JSON();
							int i=1;
							j.put("F01", ""+rs.getInt(i++));
							j.put("F02", ""+rs.getInt(i++));
							j.put("F03", ""+rs.getInt(i++));
							j.put("F04", ""+rs.getFloat(i++));
							j.put("F05", sdf.format(rs.getTimestamp(i++)));
							j.put("F06", rs.getString(i++));
							j.put("comment", rs.getString(i++));
							j.put("username", rs.getString(i++));
							list.add(j);
						}
						result.put("data", list);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, projectId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统出现异常");
		}
		return result;
	}

	@Override
	public boolean isMatch(int projectId, int uid) throws PostException {
		return this.isExistsProject(projectId, uid);
	}

	@Override
	public JSON list(int projectId, PagingInfo info) throws PostException {
		String sql = "SELECT t1.*,t2.F02,t3.F02 FROM T50 AS "
				+ "t1 LEFT JOIN T51 AS t2 ON t1.F01 = t2.F01 "
				+ "LEFT JOIN T10 AS t3 ON t1.F03 = t3.F01"
				+ " WHERE t1.F02 = ? AND t1.F06 != 'S'";
		final JSON result = new JSON();
		final SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Connection conn = this.getConnection();
		ResultSet rs = this.selectPaging(conn, sql, info, projectId);
		List<JSON> list = new ArrayList<>();
		try {
			while(rs.next()) {
				JSON j = new JSON();
				int i=1;
				j.put("F01", ""+rs.getInt(i++));
				j.put("F02", ""+rs.getInt(i++));
				j.put("F03", ""+rs.getInt(i++));
				j.put("F04", ""+rs.getFloat(i++));
				j.put("F05", sdf.format(rs.getTimestamp(i++)));
				j.put("F06", rs.getString(i++));
				j.put("comment", rs.getString(i++));
				j.put("username", rs.getString(i++));
				list.add(j);
				result.put("data", list);
			}
			sql = "SELECT COUNT(t1.F01) FROM T50 AS "
					+ "t1 LEFT JOIN T51 AS t2 ON t1.F01 = t2.F01 "
					+ "LEFT JOIN T10 AS t3 ON t1.F03 = t3.F01"
					+ " WHERE t1.F02 = ? AND t1.F06 != 'S'";
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							result.put("count", ""+rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, projectId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统出现异常");
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs.getStatement().close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void del(int bidId) throws PostException {
		if(!this.isExistsBidId(bidId)) {
			throw new PostException("投标单不存在");
		}
		String sql = "UPDATE T50 SET F06 = 'S' WHERE F01 = ?";
		Connection conn = this.getConnection();
		try {
			this.execute(conn, sql, bidId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统出现异常");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void select(int bidId) throws PostException {
		String sql = "UPDATE T40 AS t1 LEFT JOIN T50 AS t2 ON t1.F01 = t2.F02 "+
				"SET t1.F05 = ?,t1.F15=t2.F03,t1.F16=? WHERE t2.F06 = 'F' AND t2.F01=?";
		if(!isExistsBidId(bidId)) {
			throw new PostException("投标单不存在");
		}
		Connection conn = getConnection();
		try {
			ResultSet tmp = this.select(conn, "SELECT F02 FROM T50 WHERE F01 = ?", bidId);
			int projectId = -1;
			if(tmp.next()) {
				projectId = tmp.getInt(1);
			}
			if(this.isSelected(projectId)) {
				throw new PostException("当前项目不处于可投标状态，不可进行中标操作");
			}
			this.execute(conn, sql, T40_F05.JXZ.name(), this.getNowTimestamp(), bidId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PostException("系统出现异常");
		}
	}
	
	@Override
	public boolean isSelected(int projectId) {
		String sql = "SELECT F01 FROM T40 WHERE F01 = ? AND F05 != 'TBZ'";
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
			if(rs != null) {
				try {
					rs.close();
					rs.getStatement().close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public JSON queryFxs(int uid, T40_F05 status, PagingInfo info)
			throws PostException {
		commentManage = controller.getServiceManage().getService(CommentManage.class);
		String sql = null;
		if(T40_F05.TBZ.name().equals(status.name())) {
			sql = "SELECT t1.*, t2.F02, t2.F03, t2.F06, t2.F13,"
					+ "t2.F17 FROM T50 AS t1 LEFT JOIN T40 AS t2 "
					+ "ON t1.F02 = t2.F01 WHERE t1.F03 = ? AND t1.F06 = 'F'";
		} else if(T40_F05.JXZ.name().equals(status.name())) {
			sql = "SELECT t1.F01,t1.F02, t1.F03, t1.F06, t1.F13, t1.F16 "
					+ "FROM T40 AS t1 WHERE t1.F05 = 'JXZ' AND t1.F15 = ?";
		} else if(T40_F05.YJS.name().equals(status.name())) {
			sql = "SELECT t1.F01,t1.F02, t1.F03, t1.F06, t1.F13, t1.F16 "
					+ "FROM T40 AS t1 WHERE t1.F05 = 'YJS' AND t1.F15 = ?";
		}
		if(sql == null) {
			throw new PostException("请输入正确的标状态");
		}
		Connection conn = this.getConnection();
		ResultSet rs = this.selectPaging(conn, sql, info, uid);
		final SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		try {
			List<JSON> list = new ArrayList<>();
			while(rs.next()) {
				JSON j = new JSON();
				if(T40_F05.TBZ.name().equals(status.name())) {
					j.put("F01", "" + rs.getInt(1));
					j.put("F02", "" + rs.getInt(2));
					j.put("F03", "" + rs.getInt(3));
					j.put("F04", "" + rs.getFloat(4));
					j.put("F05", sdf.format(rs.getTimestamp(5)));
					j.put("F06", "F");
					j.put("projectName",rs.getString(7));
					j.put("price", ""+rs.getFloat(8));
					j.put("createDate", sdf.format(rs.getDate(9)));
					j.put("description", rs.getString(10));
					j.put("days", ""+rs.getInt(11));
				} else if(T40_F05.JXZ.name().equals(status.name())) {
					j.put("F01", "" + rs.getInt(1));
					j.put("projectName", rs.getString(2));
					j.put("price", ""+rs.getFloat(3));
					j.put("createDate", sdf.format(rs.getDate(4)));
					j.put("description", rs.getString(5));
					j.put("bidDate", sdf.format(rs.getDate(6)));
				} else if(T40_F05.YJS.name().equals(status.name())) {
					int pid = rs.getInt(1);
					j.put("F01", "" + pid);
					j.put("projectName", rs.getString(2));
					j.put("price", ""+rs.getFloat(3));
					j.put("createDate", sdf.format(rs.getDate(4)));
					j.put("description", rs.getString(5));
					j.put("bidDate", sdf.format(rs.getDate(6)));
					JSON json = commentManage.getQy2Fxs(pid);
					j.put("comment", (String)json.get("comment"));
					j.put("grade", ""+json.get("grade"));
				}
				list.add(j);
			}
			int count = this.queryFxsCount(uid, status);
			JSON result = new JSON();
			result.put("data", list);
			result.put("count", ""+count);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rs.getStatement().close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int queryFxsCount(int uid, T40_F05 status) {
		String sql = null;
		if(T40_F05.TBZ.name().equals(status.name())) {
			sql = "SELECT COUNT(t1.F01) FROM T50 AS t1 LEFT JOIN T40 AS t2 "
					+ "ON t1.F02 = t2.F01 WHERE t1.F03 = ? AND t1.F06 = 'F'";
		} else if(T40_F05.JXZ.name().equals(status.name())) {
			sql = "SELECT COUNT(t1.F01) "
					+ "FROM T40 AS t1 WHERE t1.F05 = 'JXZ' AND t1.F15 = ?";
		} else if(T40_F05.YJS.name().equals(status.name())) {
			sql = "SELECT COUNT(t1.F01) "
					+ "FROM T40 AS t1 WHERE t1.F05 = 'YJS' AND t1.F15 = ?";
		}
		Connection conn = this.getConnection();
		ResultSet rs = null;
		int count = 0;
		try {
			rs = this.select(conn, sql, uid);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs.getStatement().close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	@Override
	public void update(int bid, String comment, float price) throws PostException{
		if(!this.isExistsBidId(bid)) {
			throw new PostException("投标单不存在");
		}
		Connection conn = this.getConnection();
		try {
			System.out.println(bid);
			System.out.println(comment);
			//conn.setAutoCommit(false);
			String sql = "UPDATE T50 SET F04 =? WHERE F01 = ?";
			this.update(conn, sql, new UpdateExecutor(){

				@Override
				public void execute(int rows) {
					
				}
				
			}, price, bid);
			sql = "UPDATE T51 SET F02=? WHERE F01 = ?";
			this.update(conn, sql, new UpdateExecutor(){

				@Override
				public void execute(int rows) {
					
				}
				
			}, comment, bid);
			//conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PostException("系统发生错误");
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int getSelectedUserId(int projectId) {
		Connection conn = this.getConnection();
		try{
			String sql = "SELECT F15 FROM T40 WHERE F01=? AND F05 = 'JXZ' OR F05 = 'YJS'";
			ResultSet rs = this.select(conn, sql, projectId);
			int r = -1;
			if(rs.next()) {
				r = rs.getInt(1);
			}
			return r;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
