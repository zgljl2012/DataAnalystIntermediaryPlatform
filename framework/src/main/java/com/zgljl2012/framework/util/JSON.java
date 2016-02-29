package com.zgljl2012.framework.util;

import java.util.HashMap;
import java.util.Map;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午12:02:09
 */
public class JSON {
	
	private Map<String, String> map;
	
	public JSON() {
		map = new HashMap<>();
	}
	
	public void put(String key, String value) {
		map.put(key, value);
	}
	
	public void put(String key, String[] values) {
		
	}
	
	public Object get(String key) {
		return map.get(key);
	}
	
	public String toString() {
		String json = "{";
		int count = 0;
		int length = map.entrySet().size();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			json += margePair(entry.getKey(), entry.getValue());
			if(count != length-1) {
				json += ",";
			}
			count++;
		}
		json += "}";
		return json;
	}
	
	private String addMarks(String v) {
		return "\""+v+"\"";
	}
	
	private String margePair(String k, String v) {
		return addMarks(k)+":"+addMarks(v);
	}
}
