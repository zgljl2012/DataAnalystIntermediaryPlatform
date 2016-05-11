package com.zgljl2012.modules.project.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zgljl2012.common.database.T40;
import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.database.executor.UpdateExecutor;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.project.BidManage;
import com.zgljl2012.modules.project.CommentManage;
import com.zgljl2012.modules.project.ProjectManage;
import com.zgljl2012.modules.project.query.ProjectBaseInfoQuery;
import com.zgljl2012.modules.project.query.ProjectListIndeQuery;
import com.zgljl2012.modules.project.query.ProjectStatusPaggingQuery;

/**
 * @author 廖金龙
 * @version 2016年4月14日下午9:30:04
 * 
 */
public class ProjectManageImpl extends AbstractService implements ProjectManage{
	
	BidManage bidManage;
	CommentManage commentManage;
	
	public ProjectManageImpl(Controller controller) {
		super(controller);
		bidManage = controller.getServiceManage().getService(BidManage.class);
	}

	@Override
	public void addProject(int uid, ProjectBaseInfoQuery query) throws Exception {
		String sql = "INSERT INTO T40(F02,F03,F04,F05,F06,F12,F13,F14,F17) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		List<Object> args = new ArrayList<>();
		if(StringHelper.isEmpty(query.getProjectName())){
			throw new Exception("企业名称不能为空");
		}
		args.add(query.getProjectName()); // F02
		args.add(query.getWillPrice()); // F03
		args.add(uid); // F04
		args.add(T40_F05.DSH.name()); // F05
		args.add(new Date()); // F06
		if(query.getFinishDate() == null) {
			throw new Exception("期望完成时间不能为空");
		}
		args.add(query.getFinishDate()); // F12
		if(StringHelper.isEmpty(query.getDescription())) {
			throw new Exception("项目描述不能为空");
		}
		args.add(query.getDescription()); // F13
		args.add(Bool.F.name()); // F14
		args.add(query.getBidDays()); // F17
		for(int i=0;i<args.size();i++) {
			System.out.println(args.get(i));
		}
		Connection conn = this.getConnection();
		try {
			this.insert(conn, sql, null, args.toArray());
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		conn.close();
	}

	@Override
	public void updateProject(int pid, ProjectBaseInfoQuery query) throws PostException {
		if(!bidManage.isExistsProjectId(pid)) {
			throw new PostException("项目不存在");
		}
		String sql = "UPDATE T40 SET F01=F01";
		List<Object> args = new ArrayList<>();
		if(!StringHelper.isEmpty(query.getProjectName())) {
			sql += ",F02=? ";
			args.add(query.getProjectName());
		}
		if(!StringHelper.isEmpty(query.getDescription())) {
			sql += ",F13=? ";
			args.add(query.getDescription());
		}
		if(query.getBidDays() != -1) {
			sql += ",F17=? ";
			args.add(query.getBidDays());
		}
		if(query.getFinishDate()!=null) {
			sql += ",F12=? ";
			args.add(query.getFinishDate());
		}
		if(query.getWillPrice() != -1) {
			sql += ",F03=?";
			args.add(query.getWillPrice());
		}
		sql += " where F01=?";
		args.add(pid);
		Connection conn = getConnection();
		try {
			this.update(conn, sql, new UpdateExecutor() {
				
				@Override
				public void execute(int rows) {
					
				}
			}, args.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public JSON projectList(int uid, final ProjectStatusPaggingQuery query) throws Exception {
		CommentManage commentManage = 
				controller.getServiceManage().getService(CommentManage.class);
		String sql = "SELECT * FROM T40 WHERE 1=1 ";
		ArrayList<Object> listArgs = new ArrayList<>();
		if (query.getStatus() != null) {
			sql += " AND F05 = ? ";
			listArgs.add(query.getStatus().name());
		}
		if( uid > 0 ) {
			sql += " AND F04 = ?";
			listArgs.add(uid);
		}
		Object[] args = listArgs.toArray();
		final JSON result = new JSON();
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.selectPaging(conn, sql, new PagingInfo(){

				@Override
				public int getCurrentPage() {
					// TODO Auto-generated method stub
					return query.current();
				}

				@Override
				public int getPageSize() {
					// TODO Auto-generated method stub
					return query.pageSize();
				}
				
			}, args);
			List<JSON> list = new ArrayList<JSON>();
			while(rs.next()) {
				T40 t = new T40();
				int projectId = rs.getInt(1);
				t.setF01(projectId);
				t.setF02(rs.getString(2));
				t.setF03(rs.getFloat(3));
				t.setF04(rs.getInt(4));
				t.setF05(T40_F05.parse(rs.getString(5)));
				t.setF06(rs.getDate(6));
				t.setF07(rs.getDate(7));
				t.setF08(rs.getInt(8));
				t.setF09(rs.getString(9));
				t.setF10(rs.getDate(10));
				t.setF11(rs.getDate(11));
				t.setF12(rs.getDate(12));
				t.setF13(rs.getString(13));
				t.setF14(Bool.parse(rs.getString(14)));
				t.setF15(rs.getInt(15));
				t.setF16(rs.getTimestamp(16));
				t.setF17(rs.getInt(17));
				JSON t40 = new JSON();
				JSON json = commentManage.getQy2Fxs(projectId);
				t40.put("t40", t);
				t40.put("comment", (String)json.get("comment"));
				t40.put("grade", ""+json.get("grade"));
				list.add(t40);
			}
			rs.close();
			rs.getStatement().close();
			result.put("data", list);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			conn.close();
		}
		return result;
	}

	@Override
	public int getProjectSize(int uid) {
		String sql = "SELECT COUNT(*) FROM T40 WHERE 1=1 ";
		if(uid > 0){
			sql += " and F04 = " +uid;
		}
		Connection conn = this.getConnection();
		try{
			ResultSet rs = this.select(conn, sql, null);
			if(rs.next()) {
				int count = rs.getInt(1);
				rs.close();
				rs.getStatement().close();
				return count;
			}
		} catch(Exception e) {
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
	public JSON getProjectInfo(int projectId) {
		String sql = "SELECT * FROM T40 WHERE F01 = ?";
		Connection conn = this.getConnection();
		try {
			final JSON t40 = new JSON();
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					T40 t = new T40();
					
					try {
						if(rs.next()) {
							t.setF01(rs.getInt(1));
							t.setF02(rs.getString(2));
							t.setF03(rs.getFloat(3));
							t.setF04(rs.getInt(4));
							t.setF05(T40_F05.parse(rs.getString(5)));
							t.setF06(rs.getDate(6));
							t.setF07(rs.getDate(7));
							t.setF08(rs.getInt(8));
							t.setF09(rs.getString(9));
							t.setF10(rs.getDate(10));
							t.setF11(rs.getDate(11));
							t.setF12(rs.getDate(12));
							t.setF13(rs.getString(13));
							t.setF14(Bool.parse(rs.getString(14)));
							t.setF15(rs.getInt(15));
							t.setF16(rs.getTimestamp(16));
							t.setF17(rs.getInt(17));
							t40.put("t40", t);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, new Object[]{projectId});
			return t40;
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
		return null;
	}

	@Override
	public void realeaseProject(int projectId) {
		String sql = "UPDATE T40 SET F05 = ? WHERE F01 = ?";
		Connection conn = this.getConnection();
		try {
			this.update(conn, sql, null, T40_F05.TBZ.name(), projectId);
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
	}

	@Override
	public int getProjectSize(int uid, T40_F05 status) {
		String sql = "SELECT COUNT(*) FROM T40 WHERE 1=1 ";
		List<Object> args = new ArrayList<Object>();
		if(uid > 0){
			sql += " and F04 = ?";
			args.add(uid);
		}
		if(status != null) {
			sql += " and F05 = ?";
			args.add(status.name());
		}
		Connection conn = this.getConnection();
		try{
			ResultSet rs = this.select(conn, sql, args.toArray());
			if(rs.next()) {
				int count = rs.getInt(1);
				rs.close();
				rs.getStatement().close();
				return count;
			}
		} catch(Exception e) {
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
	public JSON getProjectIndexList(final ProjectListIndeQuery query) 
			throws SQLException {
		String sql = "SELECT * FROM T40 WHERE 1=1 ";
		commentManage = controller.getServiceManage().getService(CommentManage.class);
		ArrayList<Object> listArgs = new ArrayList<>();
		if (query.getStatus() != null) {
			sql += " AND F05 = ? ";
			listArgs.add(query.getStatus().name());
		} else {
			sql += " AND (F05 = ? OR F05=? OR F05=?) ";
			listArgs.add(T40_F05.JXZ.name());
			listArgs.add(T40_F05.YJS.name());
			listArgs.add(T40_F05.TBZ.name());
		}
		if (query.getSalaryRange() != 0) {
			int range = query.getSalaryRange();
			if(range >= 10000) {
				sql += " AND F03 > ?";
			} else {
				sql += " AND F03 < ?";
			}
			listArgs.add(range);
		}
		if(query.getStar() > 0) {
			int star = query.getStar();
			sql +=" AND "+ 
				"(SELECT AVG(t1.F03) FROM T71 AS t1 LEFT JOIN T40 AS "
				+ "t2 ON t1.F01 = t2.F01 WHERE t2.F04 = F04)"+" > " 
				+ (star-1)+ " AND " +
				"(SELECT AVG(t1.F03) FROM T71 AS t1 LEFT JOIN T40 AS "
				+ "t2 ON t1.F01 = t2.F01 WHERE t2.F04 = F04)"
				+" <= "+star;
		}
		sql += " ORDER BY F03 DESC, F06 DESC";
		System.out.println(sql);
		Object[] args = listArgs.toArray();
		final JSON result = new JSON();
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.selectPaging(conn, sql, new PagingInfo(){

				@Override
				public int getCurrentPage() {
					// TODO Auto-generated method stub
					return query.current();
				}

				@Override
				public int getPageSize() {
					// TODO Auto-generated method stub
					return query.pageSize();
				}
				
			}, args);
			List<JSON> list = new ArrayList<JSON>();
			while(rs.next()) {
				T40 t = new T40();
				int pid = rs.getInt(1);
				t.setF01(pid);
				t.setF02(rs.getString(2));
				t.setF03(rs.getFloat(3));
				int qyId = rs.getInt(4);
				t.setF04(qyId);
				t.setF05(T40_F05.parse(rs.getString(5)));
				t.setF06(rs.getDate(6));
				t.setF07(rs.getDate(7));
				t.setF08(rs.getInt(8));
				t.setF09(rs.getString(9));
				t.setF10(rs.getDate(10));
				t.setF11(rs.getDate(11));
				t.setF12(rs.getDate(12));
				t.setF13(rs.getString(13));
				t.setF14(Bool.parse(rs.getString(14)));
				t.setF15(rs.getInt(15));
				t.setF16(rs.getTimestamp(16));
				t.setF17(rs.getInt(17));
				JSON t40 = new JSON();
				float avg = commentManage.getAverageOfQy(qyId);
				t40.put("t40", t);
				t40.put("avg", ""+avg);
				int countBid = bidManage.countBid(pid);
				t40.put("countBid", ""+countBid);
				list.add(t40);
			}
			rs.close();
			rs.getStatement().close();
			result.put("data", list);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			this.close(conn);
		}
		return result;
	}

	@Override
	public int getProjectSize(ProjectListIndeQuery query) {
		String sql = "SELECT COUNT(*) FROM T40 WHERE 1=1 ";
		List<Object> listArgs = new ArrayList<Object>();
		if (query.getStatus() != null) {
			sql += " AND F05 = ? ";
			listArgs.add(query.getStatus().name());
		} else {
			sql += " AND (F05 = ? OR F05=? OR F05=?) ";
			listArgs.add(T40_F05.JXZ.name());
			listArgs.add(T40_F05.YJS.name());
			listArgs.add(T40_F05.TBZ.name());
		}
		if (query.getSalaryRange() != 0) {
			int range = query.getSalaryRange();
			if(range >= 10000) {
				sql += " AND F03 > ?";
			} else {
				sql += " AND F03 < ?";
			}
			listArgs.add(range);
		}
		if(query.getStar() > 0) {
			int star = query.getStar();
			sql +=" AND "+ 
				"(SELECT AVG(t1.F03) FROM T71 AS t1 LEFT JOIN T40 AS "
				+ "t2 ON t1.F01 = t2.F01 WHERE t2.F04 = F04)"+" > " 
				+ (star-1)+ " AND " +
				"(SELECT AVG(t1.F03) FROM T71 AS t1 LEFT JOIN T40 AS "
				+ "t2 ON t1.F01 = t2.F01 WHERE t2.F04 = F04)"
				+" <= "+star;
		}
		Connection conn = this.getConnection();
		try{
			ResultSet rs = this.select(conn, sql, listArgs.toArray());
			if(rs.next()) {
				int count = rs.getInt(1);
				rs.close();
				rs.getStatement().close();
				return count;
			}
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

	@Override
	public void setProjectYJS(int projectId) throws PostException {
		if(!bidManage.isExistsProjectId(projectId)) {
			throw new PostException("项目不存在");
		}
		String sql = "UPDATE T40 SET F05=?,F11=? WHERE F01 = ?";
		Connection conn = this.getConnection();
		try {
			this.execute(conn, sql, 
					T40_F05.YJS.name(), 
					this.getNowTimestamp(), 
					projectId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PostException("系统发生错误");
		}
	}

}
