package com.zgljl2012.common.system;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.DatabaseProvider;
import com.zgljl2012.framework.system.SystemStartupListener;
import com.zgljl2012.framework.util.ScannerUtil;
import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableManage;

/**
 * @author 廖金龙
 * @version 2016年5月12日上午11:00:54
 * 
 */
public class DataBaseInit implements SystemStartupListener{
	
	private static String ENUMS_PATH = "com.zgljl2012.common.variable";
	
	private static String TABLE = "H10";
	
	@Override
	public void startup(Controller controller) {
		controller.getLogger().console("数据库初始化");
		VariableManage vm = controller.getVariableManage();
		DatabaseProvider dp = controller.getDatabaseProvider();
		vm.setTable(TABLE);
		Set<Class<?>> clss = ScannerUtil.getClasses(ENUMS_PATH);
		// 初始化数据库
		Connection conn = dp.getConnection();
		initDB(conn);
		dp.close(conn);
		for(Class<?> cls : clss) {
			if(!cls.getName().contains("$")) {
				// 加载每个枚举对象数据
				try {
					Method method = cls.getMethod("values");
					VariableBean[] beans = (VariableBean[])method.invoke(null, null);
					for(VariableBean bean : beans) {
						String v = vm.getValue(bean);
					}
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private void initDB(Connection conn) {
		StringBuffer sql = new StringBuffer(
				"CREATE TABLE IF NOT EXISTS ");
		sql.append(TABLE+" (");
		sql.append("F01 varchar(40)  CHARACTER SET utf8 PRIMARY KEY,");
		sql.append("F02 varchar(40)  CHARACTER SET utf8 DEFAULT NULL,");
		sql.append("F03 varchar(200) CHARACTER SET utf8 DEFAULT NULL,");
		sql.append("F04 varchar(40)  CHARACTER SET utf8 DEFAULT NULL");
		sql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
