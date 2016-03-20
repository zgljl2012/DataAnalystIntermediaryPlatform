package com.zgljl2012.framework.test.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午11:23:57
 * 
 */
public class TestJSONList {
	
	List<A> list = new ArrayList<>();
	List<JSON> jsons = new ArrayList<>();
	
	
	@Before
	public void before() {
		for(int i=0;i<3;i++) {
			A a = new A();
			a.a = i;
			a.b = "H"+i;
			list.add(a);
			JSON j = new JSON();
			j.put(""+i, "W"+i);
			jsons.add(j);
		}
	}
	
	@Test
	public void jsonObjectList() {
		JSONObject json = new JSONObject();
		json.put("list", list);
		json.put("count", ""+list.size());
		System.out.println(json.toString());
	}
	
	@Test
	public void jsonList() {
		JSON json = new JSON();
		json.put("list", list);
		json.put("a", "hello，world");
		System.out.println(json.toString());
	}
	
	@Test
	public void jsonsList() {
		JSON json = new JSON();
		json.put("jsons", jsons);
		json.put("a", "hello，world");
		System.out.println(json.toString());
	}
	
	@Test
	public void jsonTestRechange() {
		A a = new A();
		a.a = 1;
		a.b = "H"+1;
		JSON json = new JSON();
		json.put("a", a);
		JSON j = (JSON)json.get("a");
		j.put("A", "Hello");
		json.put("a", j);
		System.out.println(json.get("a").getClass());
		System.out.println(json);
	}
}
