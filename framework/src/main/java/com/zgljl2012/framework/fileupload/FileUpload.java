package com.zgljl2012.framework.fileupload;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;

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
	public String upload(HttpServletRequest request, FileUploadSetter setter);
	
	/**
	 * 文件上传
	 * @param request
	 * @return 文件绝对路径
	 */
	public String upload(HttpServletRequest request);
	
	/**
	 * 文件上传
	 * @param request
	 * @param fileType
	 * @return
	 */
	public String upload(HttpServletRequest request, FILETYPE fileType);
	
	/**
	 * 文件上传根路径
	 * @param fileNameConfig
	 */
	public void setPath(String path);
	
	/**
	 * 文件上传根路径
	 * @param path
	 * @return
	 */
	public String getPath();
	
	public List<String> upload(HttpServletRequest request, FileUploadSetter setter, 
			FILETYPE fileType, Map<String, String> args);
	
	public List<String> upload(HttpServletRequest request,
			FILETYPE fileType, Map<String, String> args);
	
}
