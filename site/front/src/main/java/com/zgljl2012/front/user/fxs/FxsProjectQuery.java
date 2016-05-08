package com.zgljl2012.front.user.fxs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.common.variable.PaggingVariable;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.project.BidManage;

/**
 * @author 廖金龙
 * @version 2016年5月6日下午1:49:25
 * 分析师项目状态查询
 */
@SuppressWarnings("serial")
@WebServlet(name="fxsProjectQuery", urlPatterns={"/user/fxs/project/query"})
public class FxsProjectQuery extends AbstractServlet{
	
	@Impl
	BidManage bidManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String status = req.getParameter("status");
		final String current = req.getParameter("current");
		int uid = controller.getSession(req.getSession()).getUserId();
		final int pageSize = Integer.parseInt(
			controller.getVariableManage().getValue(
				PaggingVariable.PAGE_FXS_PROJECT_SIZE));
		JSON j = bidManage.queryFxs(uid, T40_F05.parse(status), new PagingInfo(){

			@Override
			public int getCurrentPage() {
				if(current == null) return 1;
				return Integer.parseInt(current);
			}

			@Override
			public int getPageSize() {
				return pageSize;
			}
			
		});
		j.put("pageSize", ""+pageSize);
		out(res, j);
	}

}
