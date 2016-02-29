package com.zgljl2012.framework.service;

/**
 * 服务管理器接口
 * @author Administrator
 */
public interface ServiceManage {
	
	// 获取对应接口的实现类
	public <T extends Service>T getService(Class<T> service);
	
	// 设置实现类的子文件夹名（限定只能使用子文件夹）
	public void setImplSolder(String solder);
	
	// 获取实现类的子文件夹名（限定只能使用子文件夹）
	public String getImplSolder();
	
	// 设置后缀
	public void setImplSuffix(String suffix);
	
	// 获取后缀
	public String getImplSuffix();
}
