package com.zgljl2012.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.json.JSONObject;

/**
 *@author 廖金龙
 *@version 2016年2月28日上午12:02:09
 */
public class JSON implements Cloneable{
	
	private Map<String, Object> map;
	
	public JSON() {
		map = new HashMap<>();
	}
	
	public JSON(String json) {
		map = JSON.parser(json).map;
	}
	
	public void put(String key, String value) {
		value = value.replace("\"", "\\\"");	// 处理双引号
		value = value.replace("\r", "\\r");		// 处理换行符
		value = value.replace("\n", "\\n");		// 处理回车
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
		if(value instanceof String) {
			put(key, (String)value);
			return;
		} else if(value instanceof JSON) {
			put(key, (JSON)value);
			return;
		}
		Class<? extends Object> cls = value.getClass();
		Field[] fields = cls.getDeclaredFields();
		JSON json = new JSON();
		for(Field field : fields) {
			String methodName = "get";
			methodName += 
					field.getName().substring(0, 1).toUpperCase()
					+ field.getName().substring(1);
			try {
				Method method = cls.getMethod(methodName,null);
				if(method != null) {
					Object o = method.invoke(value, null);
					if(o != null) {
						String k = method.getName().substring(3);
						String v = o.toString();
						json.put(k, v);
					}
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		this.put(key, json);
	}
	
	/**
	 * 基于org.json的包写的解析
	 * @param s
	 * @return
	 */
	public static JSON parser(String s) {
		JSONObject obj = new JSONObject(s);
		JSON json = new JSON();
		for(String k : obj.keySet()) {
			Object o = obj.get(k);
			if(o instanceof JSONObject) {
				json.put(k, parser(o.toString()));
			} else {
				json.put(k, o);
			}
		}
		return json;
	}
	
	/**
	 * 解析文件
	 * @param file
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static JSON parser(File file){
		try {
			@SuppressWarnings("resource")
			InputStream in = new FileInputStream(file);
			byte[] buffer = new byte[100];
			StringBuilder sb = new StringBuilder();
			while(in.available() > 0) {
				in.read(buffer);
				sb.append(new String(buffer));
			}
			return JSON.parser(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将字符串解析为JSON对象，自己写的解析，暂时只能解析不带花括号和中括号版本的
	 * 建议别用
	 * @param s
	 * @return
	 */
	@Deprecated
	public static JSON parse(String s) throws Exception{
		JSON json = new JSON();
		boolean leftYinhao = false; // 是否已经有了左引号
		Stack<Character> word = new Stack<>(); // 单个单词的栈
		Stack<String> stack = new Stack<>(); // 整个JSON的栈
		String k = null, v = null;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '{') {
				stack.push("{");
			} else if(ch == ',') {
				String v1 = stack.pop();
				json.put(stack.pop(), v1);
			} else if(ch == '}') {
				String t = stack.pop(); 
				if(!"{".equals(t)) {
					
				}
			} else if(ch == '\"') {
				if(leftYinhao) {
					leftYinhao = false;
					if(k == null) {
						k = JSON.getStringFromStack(word);
					} else {
						v = JSON.getStringFromStack(word);
					}
					if(k!=null && v != null) {
						stack.push(k);
						stack.push(v);
						k = null;
						v = null;
					}
				} else {
					leftYinhao = true;
				}
			} else if(ch == '\r' || ch == ' ' || ch == '\n') {
				if(leftYinhao) {
					word.push(ch);
				}
			}
			else {
				if(leftYinhao) {
					word.push(ch);
				}
			}
		}
		return json;
	}
	
	public Object get(String key) {
		return map.get(key);
	}
	
	@Override
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
	
	/**
	 * 将栈里面的字符拼接成字符串
	 * @param stack
	 * @return
	 */
	private static String getStringFromStack(Stack<Character> stack) {
		String s = "";
		while(!stack.isEmpty()) {
			s = stack.pop() + s;
		}
		return s;
	}
	
	/**
	 * 清空JSON
	 */
	private void clear() {
		this.map.clear();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
