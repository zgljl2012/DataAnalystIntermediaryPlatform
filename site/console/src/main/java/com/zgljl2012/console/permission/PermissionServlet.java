package com.zgljl2012.console.permission;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月22日上午12:37:49
 * 权限表
 */
@SuppressWarnings("serial")
@WebServlet(name="permission", urlPatterns={"/permission"})
@Permission(name="权限配置")
public class PermissionServlet extends AbstractConsoleServlet{
	
	@Impl
	PermissionManage pm;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String gid = req.getParameter("gid");
		if(!StringHelper.isEmpty(gid)) {
			Map<String, Object> map = pm.getPermission(Integer.parseInt(gid));
			req.setAttribute("p", map);
		}
		String url = "more/user/permission.jsp";
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String gid = req.getParameter("gid");
		String[] permission = req.getParameterValues("permission");
		if(gid!=null) {
			int[] pids = null;
			if(permission != null) {
				pids = new int[permission.length];
				for(int i=0; i < permission.length; i++) {
					pids[i] = Integer.parseInt(permission[i]);
				}
			}
			pm.setPermission(Integer.parseInt(gid), pids);
		}
		this.doGet(req, res);
	}

	@Override
	protected boolean isPermission() {
		return true;
	}

}
