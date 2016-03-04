package com.zgljl2012.framework.fileupload;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 廖金龙
 * @version 2016年3月4日下午9:25:23
 * 文件上传接口
 */
public interface FileUpload {
	
	/**
	 * 文件上传
	 * @param request
	 * @return 文件绝对路径
	 */
	public String upload(HttpServletRequest request);
	
	/**
	 * 配置文件的路径以及文件名
	 * @param fileNameConfig
	 */
	public void setFileNameConfig(FileNameConfig fileNameConfig);
	
}
