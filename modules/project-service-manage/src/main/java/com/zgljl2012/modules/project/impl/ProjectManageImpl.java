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
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
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

	public ProjectManageImpl(Controller controller) {
		super(controller);
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
	public void updateProject(int pid, ProjectBaseInfoQuery query) {
		
	}

	@Override
	public JSON projectList(int uid, final ProjectStatusPaggingQuery query) throws Exception {
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
				JSON t40 = new JSON();
				t40.put("t40", t);
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
						// TODO Auto-generated catch block
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
		sql += " ORDER BY F03 DESC, F06 DESC";
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
				JSON t40 = new JSON();
				t40.put("t40", t);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}
