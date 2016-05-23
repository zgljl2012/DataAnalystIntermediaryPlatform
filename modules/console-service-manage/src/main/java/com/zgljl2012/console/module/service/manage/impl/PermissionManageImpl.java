package com.zgljl2012.console.module.service.manage.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zgljl2012.common.database.H20;
import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月22日下午8:26:14
 * 
 */
public class PermissionManageImpl extends 
	AbstractService implements PermissionManage{

	public PermissionManageImpl(Controller controller) {
		super(controller);
	}

	@Override
	public boolean isAccessible(int uid, Class<? extends AbstractServlet> cls) {
		if(!this.isExistsUser(uid)) {
			return false;
		}
		int pid = getPermissionId(cls);
		int gid = getGid(uid);
		if(pid == -1 || gid == -1) {
			return false;
		}
		if(this.isExistsGroup2Permission(gid, pid)) {
			return true;
		}
		return false;
	}
	
	public int getGid(int uid) {
		String sql = "SELECT F02 FROM H21 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, uid);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return -1;
	}
	
	/**
	 * 获取权限ID
	 * @param cls
	 * @return
	 */
	public int getPermissionId(Class<? extends AbstractServlet> cls) {
		Annotation anno = cls.getAnnotation(Permission.class);
		if(anno != null) {
			Method[] method = anno.getClass().getDeclaredMethods();
			String name = "";
			for(Method m : method) {
				try {
					String m_name = m.getName();
					if("name".equals(m_name)) {
						Object o = m.invoke(anno, new Object[]{});
						if(o!=null) {
							name = (String)o;
						}
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if(StringHelper.isEmpty(name)) {
				return -1;
			}
			String sql = "SELECT F01 FROM H22 WHERE F02 like ? LIMIT 1";
			Connection conn =this.getConnection();
			ResultSet rs = null;
			try {
				rs = this.select(conn, sql, name);
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close(rs);
				this.close(conn);
			}
			
		}
		return -1;
	}

	@Override
	public void setPermission(int gId, int[] pIds) {
		if(!this.isExistsGroup(gId)) {
			return;
		}
		List<JSON> list = this.getAllPermission();
		for(int i=0; i < list.size(); i++) {
			int pid = Integer.parseInt((String)list.get(i).get("pid"));
			boolean is = false;
			if(pIds != null){
				for(int p : pIds) {
					if(pid == p) {
						is = true;
					}
				}
			}
			if(!is) {
				String sql = "DELETE FROM H23 WHERE F02 = ? AND F03 = ?";
				Connection conn = this.getConnection();
				try {
					this.execute(conn, sql, gId, pid);
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					this.close(conn);
				}
			}
		}
		if(pIds != null)
		for(int pid : pIds) {
			if(this.isExistsPermission(pid)) {
				if(!this.isExistsGroup2Permission(gId, pid)) {
					String sql = "INSERT INTO H23(F02,F03,F04) VALUES(?,?,?)";
					Connection conn = this.getConnection();
					try {
						this.insert(conn, sql, null, gId, pid, this.getNowTimestamp());
					} catch (Throwable e) {
						e.printStackTrace();
					} finally {
						this.close(conn);
					}
				}
			}
		}
		
	}
	
	/**
	 * 用户组是否存在
	 * @param gid
	 * @return
	 */
	public boolean isExistsGroup(int gid){
		String sql = "SELECT F01 FROM H20 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, gid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return false;
	}
	
	/**
	 * 用户是否存在
	 * @param uid
	 * @return
	 */
	public boolean isExistsUser(int uid){
		String sql = "SELECT F01 FROM H21 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, uid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return false;
	}
	
	/**
	 * 权限是否存在
	 * @param pid
	 * @return
	 */
	public boolean isExistsPermission(int pid) {
		String sql = "SELECT F01 FROM H22 WHERE F01 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, pid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return false;
	}
	
	/**
	 * 是否存在此用户组到彼权限的映射
	 * @param gid
	 * @param pid
	 * @return
	 */
	public boolean isExistsGroup2Permission(int gid, int pid) {
		String sql = "SELECT F01 FROM H23 WHERE F02=? AND F03=?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, gid, pid);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return false;
	}

	@Override
	public Map<String, Object> getPermission(int gid) {
		String sql = "SELECT t2.F01,t2.F02,t3.F01,t3.F02 "
				+ "FROM H23 AS t1 LEFT JOIN H20 AS t2 "
				+ "ON t1.F02 = t2.F01 LEFT JOIN H22 AS t3 "
				+ "ON t1.F03 = t3.F01 WHERE t2.F01 = ?";
		Map<String, Object> map = new HashMap<>();
		final List<JSON>  permission = this.getAllPermission();
		map.put("permission", permission);
		map.put("gid", gid);
		final List<JSON> list = new ArrayList<>();
		Connection conn = this.getConnection();
		try {
			ResultSet rs = this.select(conn, "SELECT F02 FROM H20 WHERE F01 = ?", 
					gid);
			if(rs.next()) {
				String n = rs.getString(1);
				map.put("gname", n);
			} else {
				map.put("gname", "管理员");
			}
			this.close(rs);
			this.select(conn, sql, new SelectExecutor() {
				@Override
				public void execute(ResultSet rs) {
					try {
						while(rs.next()) {
							JSON j = new JSON();
							j.put("gid",""+rs.getInt(1));
							j.put("gname", rs.getString(2));
							j.put("pid", ""+rs.getInt(3));
							j.put("pname", rs.getString(4));
							list.add(j);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, gid);
			map.put("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return map;
	}
	
	public List<JSON> getAllPermission() {
		String sql = "SELECT * FROM H22";
		Connection conn = this.getConnection();
		final List<JSON> list = new ArrayList<>();
		try {
			this.select(conn, sql, new SelectExecutor() {
				@Override
				public void execute(ResultSet rs) {
					try {
						while(rs.next()) {
							JSON j = new JSON();
							j.put("pid",""+rs.getInt(1));
							j.put("pname", rs.getString(2));
							list.add(j);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, new Object[]{});
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return list;
	}

	@Override
	public List<H20> getAllH20() {
		String sql = "SELECT F01,F02 FROM H20";
		Connection conn = this.getConnection();
		final List<H20> list = new ArrayList<>();
		try {
			this.select(conn, sql, new SelectExecutor() {
				
				@Override
				public void execute(ResultSet rs) {
					try {
						while(rs.next()) {
							H20 h = new H20();
							h.setF01(rs.getInt(1));
							h.setF02(rs.getString(2));
							list.add(h);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, new Object[]{});
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}
}
