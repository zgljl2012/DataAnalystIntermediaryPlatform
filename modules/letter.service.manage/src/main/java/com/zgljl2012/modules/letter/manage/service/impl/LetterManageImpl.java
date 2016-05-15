package com.zgljl2012.modules.letter.manage.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.letter.manage.query.LetterQuery;
import com.zgljl2012.modules.letter.manage.query.LetterQuery.Readed;
import com.zgljl2012.modules.letter.manage.service.LetterManage;

/**
 * @author 廖金龙
 * @version 2016年5月14日下午6:35:58
 * 站内信管理实现类
 */
public class LetterManageImpl extends AbstractService implements LetterManage{

	public LetterManageImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendLetter(int fromId, int toId, String title, String content) {
		List<Integer> l = new ArrayList<>();
		l.add(toId);
		this.sendLetter(fromId, l, title, content);
	}

	@Override
	public void sendLetterToAll(int fromId, String title, String content) {
		String sql = "SELECT F01 FROM T10 WHERE F06 = 'F'";
		final List<Integer> l = new ArrayList<>();
		Connection conn = this.getConnection();
		try {
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							l.add(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, new Object[]{});
			this.sendLetter(fromId, l, title, content);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void sendLetter(int fromId, List<Integer> listToID, String title,
			String content) {
		Connection conn = this.getConnection();
		String sql = "INSERT INTO T60(F02,F03,F04,F05,F06,F07) "
				+ "VALUES(?,?,?,?,?,?)";
		String sqlContent = "INSERT INTO T61(F01,F02) VALUES(?,?)";
		Object[] args = new Object[]{
			fromId,0,this.getNowTimestamp(),title,Bool.F.name(), Bool.F.name()	
		};
		try {
			conn.setAutoCommit(false);
			for(int toId : listToID) {
				args[1] = toId;
				int id = this.insert(conn, sql, null, args);
				this.insert(conn, sqlContent, null, id, content);
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public JSON getAllLetter(int userId) {
		String sql = "SELECT t1.F01,t3.F02,t1.F04,t1.F06,t1.F05,t2.F02 FROM T60 AS t1 LEFT "
				+ "JOIN T61 AS t2 ON t1.F01 = t2.F01 LEFT "
				+ "JOIN T10 AS t3 ON t1.F02 = t3.F01 WHERE t1.F03 = ? AND t1.F07 != 'S'";
		final JSON j = new JSON();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Connection conn = this.getConnection();
		try {
			conn.setAutoCommit(false);
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					List<JSON> list = new ArrayList<>();
					try {
						while(rs.next()) {
							JSON json = new JSON();
							json.put("id", ""+rs.getInt(1));
							json.put("to", rs.getString(2));
							json.put("timestamp", sdf.format(rs.getTimestamp(3)));
							json.put("readed", ""+(Bool.parse(
									rs.getString(4)).equals(Bool.S)));
							json.put("title", rs.getString(5));
							json.put("content", rs.getString(6));
							list.add(json);
						}
						j.put("data", list);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, userId);
			sql = "SELECT COUNT(F01) FROM T60 WHERE F03 = ?";
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							j.put("count", ""+rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, userId);
			conn.commit();
			return j;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean isReaded(int lid) {
		String sql = "SELECT F06 FROM T60 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, lid);
			if(rs.next()) {
				return "S".equals(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void deleteLetter(int lid) {
		String sql = "UPDATE T60 SET F07 = 'S' WHERE F01 = ?";
		Connection conn = getConnection();
		try {
			this.execute(conn, sql, lid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void readedLetter(int lid) {
		String sql = "UPDATE T60 SET F06 = 'S' WHERE F01 = ?";
		Connection conn = getConnection();
		try {
			this.execute(conn, sql, lid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public JSON getAllLetter(int userId, PagingInfo info,
			LetterQuery query) {
		String sql = "SELECT t1.F01,t3.F02,t1.F04,t1.F06,t1.F05,t2.F02 FROM T60 AS t1 LEFT "
				+ "JOIN T61 AS t2 ON t1.F01 = t2.F01 LEFT "
				+ "JOIN T10 AS t3 ON t1.F02 = t3.F01 WHERE t1.F03 = ? AND t1.F07 != 'S' ";
		if(query.getReaded() != null) {
			if(query.getReaded().equals(Readed.READED)) {
				sql += " AND t1.F06 = 'S' ";
			} else if(query.getReaded().equals(Readed.UNREADED)) {
				sql += " AND t1.F06 = 'F' ";
			}
		}
		final JSON j = new JSON();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			
			rs = this.selectPaging(conn, sql, info, userId);
			List<JSON> list = new ArrayList<>();
			while(rs.next()) {
				JSON json = new JSON();
				json.put("id", ""+rs.getInt(1));
				json.put("to", rs.getString(2));
				json.put("timestamp", sdf.format(rs.getTimestamp(3)));
				json.put("readed", ""+(Bool.parse(
						rs.getString(4)).equals(Bool.S)));
				json.put("title", rs.getString(5));
				json.put("content", rs.getString(6));
				list.add(json);
			}
			j.put("data", list);
			
			sql = "SELECT COUNT(F01) FROM T60 WHERE F03 = ?";
			if(query.getReaded() != null) {
				if(query.getReaded().equals(Readed.READED)) {
					sql += " AND F06 = 'S' ";
				} else if(query.getReaded().equals(Readed.UNREADED)) {
					sql += " AND F06 = 'F' ";
				}
			}
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						if(rs.next()) {
							j.put("count", ""+rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, userId);
			conn.commit();
			return j;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(rs!=null) {
					rs.close();
					rs.getStatement().close();
				}
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(rs!=null) {
					rs.close();
					rs.getStatement().close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void deleteAllLetterOfOne(int userId) {
		String sql = "UPDATE T60 SET F07 = 'S' WHERE F03 = ?";
		Connection conn = getConnection();
		try {
			this.update(conn, sql, new UpdateExecutor() {
				
				@Override
				public void execute(int rows) {
					
				}
			}, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	@Override
	public int countUnReaded(int userId) {
		String sql = "SELECT COUNT(F01) FROM T60 WHERE F06 = 'F' AND F03 = ? AND F07 = 'F'";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, userId);
			if(rs.next()) {
				return rs.getInt(1);
			}
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
		
		return 0;
	}

}
