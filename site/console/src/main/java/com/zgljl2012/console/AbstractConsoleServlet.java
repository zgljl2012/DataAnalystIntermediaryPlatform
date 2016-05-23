package com.zgljl2012.console;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.module.service.manage.PermissionManage;
import com.zgljl2012.framework.exceptions.AuthorizationLimitException;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;

/**
 * @author 廖金龙
 * @version 2016年5月23日上午3:16:25
 * 
 */
@SuppressWarnings("serial")
public abstract class AbstractConsoleServlet extends AbstractServlet{
	
	protected final static String PERMISSION_ERROE_HINT = "抱歉，您无此权限";
	protected final static String PERMISSION_ERROR_URL  = "/more/error/error.jsp"; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			if(this.isPermission()) {
				int uid = controller.getSession(req.getSession()).getUserId();
				if(!this.isAccessible(uid)) {
					String error = PERMISSION_ERROR_URL;
					req.setAttribute("error", PERMISSION_ERROE_HINT);
					this.forward(req, resp, error);
					return;
				}
			}
			get(req, resp, controller);
		} catch(AuthorizationLimitException e) {
			String error = PERMISSION_ERROR_URL;
			req.setAttribute("error", PERMISSION_ERROE_HINT);
			this.forward(req, resp, error);
		} catch(PostException e) {
			e.printStackTrace();
			JSON json = new JSON();
			json.put("status", "error");
			json.put("description", e.getMessage());
			out(resp, json);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			if(this.isPermission()) {
				int uid = controller.getSession(req.getSession()).getUserId();
				if(!this.isAccessible(uid)) {
					String error = PERMISSION_ERROR_URL;
					req.setAttribute("error", PERMISSION_ERROE_HINT);
					this.forward(req, resp, error);
					return;
				}
			}
			post(req, resp, controller);
		} catch(AuthorizationLimitException e) {
			String error = PERMISSION_ERROR_URL;
			req.setAttribute("error", PERMISSION_ERROE_HINT);
			this.forward(req, resp, error);
		} catch(PostException e) {
			e.printStackTrace();
			JSON json = new JSON();
			json.put("status", "error");
			json.put("description", e.getMessage());
			out(resp, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否需要权限控制
	 * @return
	 */
	protected abstract boolean isPermission();
	
	private boolean isAccessible(int uid) {
		PermissionManage pm = 
				controller.getServiceManage().getService(PermissionManage.class);
		return pm.isAccessible(uid, this.getClass());
	}
}
