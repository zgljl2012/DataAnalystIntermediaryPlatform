package com.zgljl2012.framework.util.python;

public class StringUtil {
	
	/**
	 * 将多个参数组成命令行调用的格式
	 * @param args
	 * @return
	 */
	public static String blank(String... args) {
    	String  s = "";
    	for(int i=0;i<args.length;i++) {
    		String arg = args[i];
    		s += arg;
    		
    		if(i < args.length) {
    			s += " ";
    		}
    	}
    	return s;
    }
}
