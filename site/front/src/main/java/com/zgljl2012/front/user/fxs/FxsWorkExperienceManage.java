package com.zgljl2012.front.user.fxs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.front.user.FxsManage;

/**
 * @author 廖金龙
 * @version 2016年3月17日下午10:39:34
 * 获取从业经历的条数的多少
 */
@WebServlet(name="fxsWorkExperience", urlPatterns={"/user/workExperienceManage"})
public class FxsWorkExperienceManage extends AbstractServlet{

	private static final long serialVersionUID = -1997821863524070437L;
	
	@Impl
	FxsManage fxsManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// 获取从业经历的总条数和每页的条数
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
