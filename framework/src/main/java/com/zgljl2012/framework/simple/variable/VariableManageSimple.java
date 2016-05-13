package com.zgljl2012.framework.simple.variable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zgljl2012.framework.database.C3P0Util;
import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableManage;

public class VariableManageSimple implements VariableManage{

	private Map<String, VariableBean> data;
	
	private String table = null;
	
	private static Connection conn = null;
	
	static {
		conn = C3P0Util.getConnection();
	}
	
	public VariableManageSimple(Map<String, VariableBean> data) {
		this.data = data;
		if(this.data == null) {
			this.data = new HashMap<String, VariableBean>();
		}
	}
	
	public String getValue(VariableBean bean) {
		String r = null;
		VariableBean tmp = this.getFromDB(bean.getKey());
		if(tmp == null) {
			r = bean.getValue();
			this.setToDB(bean);
		} else {
			r = tmp.getValue();
		}
		data.put(bean.getKey(), tmp);
		return r;
	}

	public String setValue(final VariableBean bean, final String value) {
		data.put(bean.getKey(), new VariableBean() {

			@Override
			public String getKey() {
				return bean.getKey();
			}

			@Override
			public String getName() {
				return bean.getName();
			}

			@Override
			public String getDescription() {
				return bean.getDescription();
			}

			@Override
			public String getValue() {
				return value;
			}
			
		});
		this.updateToDB(data.get(bean.getKey()));
		return getValue(bean);
	}

	@Override
	public void setTable(String table) {
		this.table = table;
	}
	
	private VariableBean getFromDB(String key) {
		String sql = "SELECT * FROM " + this.table +" WHERE F01 = ?";
		PreparedStatement stmt = null;
		try {
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, key);
			final ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				final String key1 = rs.getString(1);
				final String name = rs.getString(2);
				final String description = rs.getString(3);
				final String value = rs.getString(4);
				VariableBean bean = new VariableBean(){

					@Override
					public String getKey() {
						return key1;
					}

					@Override
					public String getName() {
						return name;
					}

					@Override
					public String getDescription() {
						return description;
					}

					@Override
					public String getValue() {
						return value;
					}
					
				};
				return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public void setToDB(VariableBean bean) {
		String sql = "INSERT INTO "+this.table+"(F01,F02,F03,F04) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, bean.getKey());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getDescription());
			stmt.setString(4, bean.getValue());
			stmt.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateToDB(VariableBean bean) {
		String sql = "UPDATE "+this.table+" SET F02=?,F03=?,F04=? WHERE F01 = ?";
		PreparedStatement stmt = null;
		try {
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, bean.getName());
			stmt.setString(2, bean.getDescription());
			stmt.setString(3, bean.getValue());
			stmt.setString(4, bean.getKey());
			stmt.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Connection getConnection() {
		if(VariableManageSimple.conn!=null) {
			return VariableManageSimple.conn;
		}
		VariableManageSimple.conn = C3P0Util.getConnection();
		return VariableManageSimple.conn;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if(conn != null) {
			conn.close();
		}
	}

	@Override
	public List<VariableBean> getVariableBeanList() {
		Set<String> sets = this.data.keySet();
		List<VariableBean> list = new ArrayList<VariableBean>();
		for(String k : sets) {
			list.add(this.data.get(k));
		}
		return list;
	}

	@Override
	public VariableBean getVariableBean(String key) {
		VariableBean tmp = this.getFromDB(key);
		return tmp;
	}
}
