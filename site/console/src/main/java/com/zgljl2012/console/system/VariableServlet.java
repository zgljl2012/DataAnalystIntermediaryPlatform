package com.zgljl2012.console.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.variable.VariableBean;
import com.zgljl2012.framework.variable.VariableManage;

/**
 * @author 廖金龙
 * @version 2016年5月12日下午6:54:52
 * 获取系统常量列表
 */
@SuppressWarnings("serial")
@WebServlet(name="variableServlet", urlPatterns={"/variable"})
public class VariableServlet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		VariableManage vm = controller.getVariableManage();
		List<VariableBean> list = vm.getVariableBeanList();
		JSON json = new JSON();
		List<JSON> ls = new ArrayList<>();
		for(VariableBean vb : list) {
			JSON j = new JSON();
			j.put("key", vb.getKey());
			j.put("name", vb.getName());
			j.put("description", vb.getDescription());
			j.put("value", vb.getValue());
			ls.add(j);
		}
		json.put("data", ls);
		out(res, json);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
