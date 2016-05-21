package com.zgljl2012.common.system;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.system.SystemStartupListener;
import com.zgljl2012.framework.util.ScannerUtil;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午3:13:36
 * 
 */
public class PermissionInit implements SystemStartupListener{

	public String[] webs = {
			"com.zgljl2012.console"
	};
	
	@Override
	public void startup(Controller controller) {
		DatabaseProvider dp = controller.getDatabaseProvider();
		Connection conn = dp.getConnection();
		// 初始化数据库
		initAdministrator(conn);
		// 初始化权限
		for(String i : webs) {
			scannerServlet(i, conn);
		}
		dp.close(conn);
	}
	
	public void scannerServlet(String pkg, Connection conn) {
		List<String> ls = new ArrayList<>();
		Set<Class<?>> clss = ScannerUtil.getClasses(pkg);
		for(Class<?> c:clss) {
			Annotation anno = c.getAnnotation(Permission.class);
			if(anno != null) {
				Method[] method = anno.getClass().getDeclaredMethods();
				for(Method m : method) {
					try {
						String m_name = m.getName();
						if("name".equals(m_name)) {
							Object o = m.invoke(anno, new Object[]{});
							if(o!=null) {
								String name = (String)o;
								if(!StringHelper.isEmpty(name)) {
									ls.add(name);
								}
							}
						}
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		try {
			conn.setAutoCommit(false);
			for(String s: ls) {
				String sql = "SELECT F01 FROM H22 WHERE F02 LIKE ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, s);
				ResultSet rs = st.executeQuery();
				if(!rs.next()) {
					sql ="INSERT INTO H22(F02) VALUES(?)";
					rs.close();
					st.close();
					st = conn.prepareStatement(sql);
					st.setString(1, s);
					st.execute();
					st.close();
				} else {
					rs.close();
					st.close();
				}
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 初始化后台用户组、后台用户、后台权限、后台用户权限表，分别对应：
	 * H20 H21 H22 H23
	 * @param conn
	 */
	private void initAdministrator(Connection conn) {
		try {
			conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("CREATE TABLE IF NOT EXISTS "
					+ "H20 (");
			sql.append("F01  int NOT NULL AUTO_INCREMENT ,");
			sql.append("F02  varchar(50) NULL ,");
			sql.append("PRIMARY KEY (F01)");
			sql.append(") ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
			Statement stmt = conn.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
			
			sql = new StringBuffer("CREATE TABLE IF NOT EXISTS "
					+ "H21 (");
			sql.append("F01  int NOT NULL AUTO_INCREMENT ,");
			sql.append("F02  int NULL ,");
			sql.append("F03  varchar(30) NULL ,");
			sql.append("F04  varchar(50) NULL ,");
			sql.append("PRIMARY KEY (F01)");
			sql.append(") ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
			stmt = conn.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
			
			sql = new StringBuffer("CREATE TABLE IF NOT EXISTS "
					+ "H22 (");
			sql.append("F01  int NOT NULL AUTO_INCREMENT ,");
			sql.append("F02  varchar(80) NULL ,");
			sql.append("PRIMARY KEY (F01)");
			sql.append(") ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
			stmt = conn.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
			
			sql = new StringBuffer("CREATE TABLE IF NOT EXISTS "
					+ "H23 (");
			sql.append("F01  int NOT NULL AUTO_INCREMENT ,");
			sql.append("F02  int NULL ,");
			sql.append("F03  int NULL ,");
			sql.append("F04  timestamp NULL,");
			sql.append("PRIMARY KEY (F01)");
			sql.append(") ENGINE=InnoDB DEFAULT CHARACTER SET=utf8");
			stmt = conn.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}


}
