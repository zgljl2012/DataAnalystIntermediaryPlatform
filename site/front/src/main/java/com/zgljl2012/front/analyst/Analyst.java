package com.zgljl2012.front.analyst;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.Degree;
import com.zgljl2012.common.variable.FxsVariable;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.analyst.FxsMarketManage;
import com.zgljl2012.modules.front.analyst.query.FxsInfoQuery;

/**
 * @author 廖金龙
 * @version 2016年3月19日下午8:40:58
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="analyst", urlPatterns={"/analyst"})
public class Analyst extends AbstractServlet{
	
	@Impl
	FxsMarketManage fxsMarketManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.post(req, res, controller);
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			final Controller controller) throws Exception {
		FxsInfoQuery query = new FxsInfoQuery() {
			
			@Override
			public int getWorkTime() {
				if(!StringHelper.isEmpty(req.getParameter("workTime"))) {
					return Integer.parseInt(req.getParameter("workTime"));
				}
				return -1;
			}
			
			@Override
			public float getGrade() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Degree getDegree() {
				if(!StringHelper.isEmpty(req.getParameter("degree"))) {
					return Degree.parse(req.getParameter("degree"));
				}
				return null;
			}
		};
		
		JSON json = fxsMarketManage.search(query, new PagingInfo() {
				
				@Override
				public int getPageSize() {
					String s = controller.getVariableManage().
							getValue(FxsVariable.ANALYST_LIST_SIZE);
					return Integer.parseInt(s);
				}
				
				@Override
				public int getCurrentPage() {
					int c = 1;
					if(!StringHelper.isEmpty(req.getParameter("current"))) {
						c = Integer.parseInt(req.getParameter("current"));
					}
					return c;
				}
		});
		int c = fxsMarketManage.fxsCount(query);
		JSON j = new JSON();
		j.put("count", ""+c);
		if(json != null)
			j.put("data", json);
		out(res, j.toString());
	}

}
