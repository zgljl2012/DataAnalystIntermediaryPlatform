package com.zgljl2012.framework.variable;

import java.util.List;

public interface VariableManage {
	
	public String getValue(VariableBean bean);
	
	public String setValue(VariableBean bean, String value);
	
	public VariableBean getVariableBean(String key);
	
	/**
	 * 设置数据存储的表名
	 * @param table
	 */
	public void setTable(String table);
	
	/**
	 * 获取常量表
	 * @return
	 */
	public List<VariableBean> getVariableBeanList();
	
}
