package com.zgljl2012.framework.fileupload;


/**
 * @author 廖金龙
 * @version 2016年3月4日下午9:58:12
 * 文件上传的配置接口
 */
public interface FileUploadSetter {
	
	/**
	 * 文件类型
	 * @author 廖金龙
	 */
	public enum FILETYPE{
		IMAGE,	// 图片
		FILE	// 文件
	}
	
	/**
	 * 根据上传的文件的文件名进行文件的命名，包括后缀名
	 * @param name 上传的文件的文件名
	 * @return 处理后的文件名
	 */
	public String getFileName(String name);
	
	/**
	 * 获取相对路径，如:/tmp
	 * @param relativePath
	 * @return
	 */
	public String getRelativePath();
	
	/**
	 * 获取文件类型
	 * @return
	 */
	public FILETYPE getFileType();

	String getRelativePath(FILETYPE fileType);
}
