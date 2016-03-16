package com.zgljl2012.front.user.fxs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.user.FxsManage;
import com.zgljl2012.modules.front.user.query.FxsWorkExperienceQuery;

/**
 * @author 廖金龙
 * @version 2016年3月16日下午8:29:14
 * 
 */
@WebServlet(name="fxsWorkExperience", urlPatterns={"/user/workExperience"})
public class FxsWorkExperience extends AbstractServlet{

	private static final long serialVersionUID = 3718993555353042798L;
	
	@Impl
	FxsManage fxsManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String type = req.getParameter("type");
		JSON json = new JSON();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if("add".equals(type)) {
			int id = fxsManage.insertWorkExperience(
					controller.getSession(req.getSession()).getUserId(), 
					new FxsWorkExperienceQuery() {
						
						@Override
						public Date getStartDate() {
							String sDate = req.getParameter("companyStartDate");
							if(StringHelper.isEmpty(sDate)) {
								return null;
							}
							try {
								return sdf.parse(sDate);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return null;
						}
						
						@Override
						public String getRemark() {
							// TODO Auto-generated method stub
							return req.getParameter("companyRemark");
						}
						
						@Override
						public Date getFinishedDate() {
							String sDate = req.getParameter("companyFinishDate");
							if(StringHelper.isEmpty(sDate)) {
								return null;
							}
							try {
								return sdf.parse(sDate);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return null;
						}
						
						@Override
						public String getCompanyName() {
							// TODO Auto-generated method stub
							return req.getParameter("companyName");
						}
					});
			if(id == -1) {
				json.put("success","false");
			} else {
				json.put("success","true");
			}
		}
		this.out(res, json.toString());
	}

}
