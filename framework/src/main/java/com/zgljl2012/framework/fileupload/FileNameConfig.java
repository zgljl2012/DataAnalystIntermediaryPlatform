package com.zgljl2012.framework.fileupload;

/**
 * @author 廖金龙
 * @version 2016年3月4日下午9:58:12
 * 文件的路径及文件名命名接口，包括路径的命名和文件的命名
 */
public interface FileNameConfig {
	
	/**
	 * 用户设置返回的路径，根据一定规则生成
	 * @return 路径
	 */
	public String getPath();
	
	/**
	 * 根据上传的文件的文件名进行文件的命名，包括后缀名
	 * @param name 上传的文件的文件名
	 * @return 处理后的文件名
	 */
	public String getFileName(String name);
}
