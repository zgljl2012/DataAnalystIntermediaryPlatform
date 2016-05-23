package com.zgljl2012.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.zgljl2012.framework.util.python.FileUtil;
import com.zgljl2012.framework.util.python.NamedUtil;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午2:28:19
 * Python执行工具类
 */
public class PythonUtil {
	
	/**
	 * 存储路径
	 */
	public static final String path = "python_file/";
	
	/**
	 * 调用Python脚本
	 */
	public static String execfile(String path, String command, String charset) {
		Process process = null;
    	BufferedInputStream input = null;
    	try {
    		Runtime rt = Runtime.getRuntime(); 
    		command = "python " + command;
    		if(path != null) {
    			process = rt.exec(command, null, new File(path));
    		} else {
    			process = rt.exec(command);
    		}
    		InputStream in = process.getInputStream();
    		InputStreamReader isr = new InputStreamReader(in, "gbk");
    		BufferedReader bf = new BufferedReader(isr);
    		StringBuffer sb = new StringBuffer();
    		String newline = null;
    		while((newline=bf.readLine())!=null) {
    			sb.append(newline+"\n");
    		}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return null;
	}

	/**
	 * 直接运行Python程序
	 * 将代码先保存为脚本然后调用execfile运行脚本得到结果返回，然后将脚本删除
	 */
	public static String exec(String command, String charset) {
		String name = NamedUtil.named() + ".py";
		FileUtil.save(name, command, charset);
		String result = execfile(null,name, charset);
		FileUtil.delete(name);
		return result;
	}
	
	/**
	 * 直接运行Python程序，Path是相对路径
	 * @param path
	 * @param command
	 * @param charset
	 * @return
	 */
	public static String exec(String path, String command, String charset) {
		String name = path+"/"+NamedUtil.named() + ".py";
		FileUtil.save(name, command, charset);
		String result = execfile(path, name, charset);
		FileUtil.delete(name);
		return result;
	}
	
}
