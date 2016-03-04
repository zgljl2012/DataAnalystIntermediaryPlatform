package com.zgljl2012.framework.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.servlet.session.LjlSession;
import com.zgljl2012.framework.variable.VariableManage;

/**
 *@author 廖金龙
 *@version 2016年2月27日下午8:45:15
 * 控制器，负责提供一些常用工具：服务提供者、常量配置器
 * 他的初始化应该放在
 */
public interface Controller {

	/**
	 * 获取服务提供者
	 * @return
	 */
	public ServiceManage getServiceManage();
	
	/**
	 * 获取常量配置器
	 * @return
	 */
	public VariableManage getVariableManage();
	
	/**
	 * 生成一个LjlSession，并存放到到HttpSession里
	 * @return
	 */
	public LjlSession createSession(HttpSession session);
	
	/**
	 * 从Session中获取到LjlSession对象
	 * @param session
	 * @return
	 */
	public LjlSession getSession(HttpSession session);
	
	/**
	 * 转发
	 * @param req
	 * @param res
	 * @param url
	 */
	public void forward(HttpServletRequest req, HttpServletResponse res, String url);
	
	/**
	 * 重定向
	 * @param res
	 * @param url
	 * @throws IOException
	 */
	public void redirect(HttpServletResponse res, String url) throws IOException;
	
	/**
	 * 获取文件上传器
	 * @return
	 */
	public FileUpload getFileUpload();
}
