package com.zgljl2012.front;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.T40_F05;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.analyst.FxsMarketManage;
import com.zgljl2012.modules.project.ProjectManage;
import com.zgljl2012.modules.project.query.ProjectListIndeQuery;

/**
 * @author 廖金龙
 * @version 2016年5月11日下午11:02:33
 * 主页Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="indexServlet", urlPatterns={"/index/data"})
public class IndexServlet extends AbstractServlet{

	@Impl
	ProjectManage projectMange;
	
	@Impl
	FxsMarketManage fxsMarketManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		JSON jProject = projectMange.getProjectIndexList(new ProjectListIndeQuery() {
			
			@Override
			public int pageSize() {
				// TODO Auto-generated method stub
				return 5;
			}
			
			@Override
			public T40_F05 getStatus() {
				// TODO Auto-generated method stub
				return T40_F05.TBZ;
			}
			
			@Override
			public int getStar() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getSalaryRange() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int current() {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		
		JSON jFxs = fxsMarketManage.search(null, new PagingInfo() {
			
			@Override
			public int getPageSize() {
				// TODO Auto-generated method stub
				return 10;
			}
			
			@Override
			public int getCurrentPage() {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		
		JSON data = new JSON();
		data.put("project", jProject);
		data.put("fxs", jFxs);
		out(res, data);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
