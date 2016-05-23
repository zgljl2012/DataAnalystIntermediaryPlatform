package com.zgljl2012.console.system;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.variable.UrlVariable;
import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.variable.VariableManage;

/**
 * @author 廖金龙
 * @version 2016年5月12日下午11:47:43
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="variableUpdate", urlPatterns={"/variable/update"})
@Permission(name="常量配置修改")
public class VariableUpdateServlet extends AbstractConsoleServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		VariableManage vm = controller.getVariableManage();
		String key = req.getParameter("key");
		req.setAttribute("bean", vm.getVariableBean(key));
		String url = vm.getValue(UrlVariable.VARIABLE_UPDATE);
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		VariableManage vm = controller.getVariableManage();
		String key=req.getParameter("key");
		String value = req.getParameter("value");
		vm.setValue(vm.getVariableBean(key), value);
		String url = vm.getValue(UrlVariable.VARIABLE);
		this.forward(req, res, url);
	}

	@Override
	protected boolean isPermission() {
		return true;
	}

}
