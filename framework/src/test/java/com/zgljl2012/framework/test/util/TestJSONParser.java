package com.zgljl2012.framework.test.util;

import java.io.File;
import java.util.Stack;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Test;

import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年3月15日下午9:02:26
 * 
 */
public class TestJSONParser {
	
	@Test
	public void stackToString() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		String s = "";
		while(!stack.isEmpty()) {
			s = stack.pop() + s;
		}
		Assert.assertEquals("abc", s);
	}
	
	@Test
	public void parserStringOnlyKandV() throws Exception {
		String s = "{\"a\":\"你    好\",                 \r"
				+ "\"b\":\"world\","
				+ "\"c\":                  \"welcome\","
				+ "\"d\":\"go\",}";
		System.out.println(s);
		System.out.println("========================");
		JSON json = JSON.parse(s);
		System.out.println(json);
	}
	
	@Test
	public void jsonObject() {
		String s = "{\"a\":\"你    好\","
				+ "\"b\":\"world\","
				+ "\"c\":{\"e\":\"welcome\"},"
				+ "\"d\":\"go\",}";
		JSONObject obj = new JSONObject(s);
		Object o = obj.get("c");
		System.out.println(obj);
		System.out.println(o.getClass());
	}
	
	@Test
	public void parser() {
		String s = "{\"a\":\"你    好\","
				+ "\"b\":\"world\","
				+ "\"c\":{\"e\":\"welcome\"},"
				+ "\"d\":\"go\",}";
		JSON json = JSON.parser(s);
		System.out.println(((JSON)json.get("c")).get("e"));
	}
	
	@Test
	public void jsonCons(){
		String s = "{\"a\":\"你    好\","
				+ "\"b\":\"world\","
				+ "\"c\":{\"e\":\"welcome\"},"
				+ "\"d\":\"go\",}";
		JSON j = new JSON(s);
		System.out.println(j);
	}
	
	@Test
	public void parserFile() {
		File file = new File("src/test/java/test.json");
		JSON j = JSON.parser(file);
		System.out.println(j);
	}
}
