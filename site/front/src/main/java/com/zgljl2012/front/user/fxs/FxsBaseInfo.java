package com.zgljl2012.front.user.fxs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.front.user.UserManage;

/**
 * @author 廖金龙
 * @version 2016年2月29日下午11:10:15
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="fxsBaseInfo", urlPatterns={"/user/fsxBaseInfo"})
public class FxsBaseInfo extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		UserManage userManage = controller.getServiceManage().getService(UserManage.class);
		T10 t10 = userManage.getT10(controller.getSession(req.getSession()).getUserId());
		
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
