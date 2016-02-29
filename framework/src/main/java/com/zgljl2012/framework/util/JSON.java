package com.zgljl2012.framework.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午12:02:09
 */
public class JSON {
	
	private Map<String, Object> map;
	
	public JSON() {
		map = new HashMap<>();
	}
	
	public void put(String key, String value) {
		map.put(key, value);
	}
	
	public void put(String key, String[] values) {
		
	}
	
	public void put(String key, JSON json) {
		map.put(key, json);
	}
	
	/**
	 * 存储对象
	 * @param key
	 * @param value 有get和set方法的对象
	 */
	public void put(String key, Object value) {
		Class<? extends Object> cls = value.getClass();
		// 获取所有方法
		Method[] methods = cls.getMethods();
		StringBuilder builder = new StringBuilder();
		JSON json = new JSON();
		for(Method method : methods) {
			if(method.getName().startsWith("get")) {
				try {
					Object o = method.invoke(value, null);
					String k = method.getName().substring(3);
					String v = o.toString();
					json.put(k, v);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.put(key, json);
	}
	
	public Object get(String key) {
		return map.get(key);
	}
	
	public String toString() {
		String json = "{";
		int count = 0;
		int length = map.entrySet().size();
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			if(entry.getValue().getClass().equals(String.class)) {
				json += margePair(entry.getKey(), (String)entry.getValue());
				if(count != length-1) {
					json += ",";
				}
			} else if(entry.getValue().getClass().equals(JSON.class)) {
				json += addMarks(entry.getKey())+":"+entry.getValue().toString();
				if(count != length-1) {
					json += ",";
				}
			}
			count++;
		}
		json += "}";
		return json;
	}
	
	/**
	 * 给字符串加上引号
	 * @param v
	 * @return
	 */
	private String addMarks(String v) {
		return "\""+v+"\"";
	}
	
	/**
	 * 组成 "k":"v" 这样的键值对
	 * @param k
	 * @param v
	 * @return
	 */
	private String margePair(String k, String v) {
		return addMarks(k)+":"+addMarks(v);
	}
}
