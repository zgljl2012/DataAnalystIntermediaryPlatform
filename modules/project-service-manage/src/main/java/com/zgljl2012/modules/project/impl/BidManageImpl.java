package com.zgljl2012.modules.project.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.BidManage;

/**
 * @author 廖金龙
 * @version 2016年4月27日下午11:52:46
 * 
 */
public class BidManageImpl extends AbstractService implements BidManage{

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
		}
		return result;
	}

	@Override
	public boolean isMatch(int projectId, int uid) throws PostException {
		return this.isExistsProject(projectId, uid);
	}

	@Override
	public JSON list(int projectId, PagingInfo info) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

}
