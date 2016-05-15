package com.zgljl2012.front.user.qy;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.front.user.QyManage;
import com.zgljl2012.modules.front.user.UserManage;
import com.zgljl2012.modules.front.user.query.QyUpdateQuery;

/**
 * @author 廖金龙
 * @version 2016年3月27日下午6:26:59
 * 
 */

@SuppressWarnings("serial")
@WebServlet(name="updateQyInfoServlet", urlPatterns={"/user/updateQyInfo"})
public class UpdateQyInfoServlet extends AbstractServlet{

	@Impl
	QyManage qyManage;
	
	
	@Impl
	UserManage userManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		int uid = controller.getSession(req.getSession()).getUserId();
		final String name = req.getParameter("name");
		final String value = req.getParameter("value");
		JSON json = new JSON();
		json.put("success", "true");
		json.put("msg", "数据更新成功");
		try{
			if("username".equals(name)) {
				userManage.updateUsername(uid, value);
				json.put("msg", "用户名修改成功");
			} else {
			qyManage.updateQyInfo(uid, new QyUpdateQuery() {
				
				@Override
				public String getUsername() {
					return null;
				}
				
				@Override
				public String getRemark() {
					if("remark".equals(name)) {
						System.out.println(value);
						return value;
					}
					return null;
				}
				
				@Override
				public String getEmail() {
					if("email".equals(name)) {
						return value;
					}
					return null;
				}
				
				@Override
				public String getCompanyName() {
					if("companyName".equals(name)) {
						return value;
					}
					return null;
				}
				
				@Override
				public String getBusiness() {
					if("business".equals(name)) {
						return value;
					}
					return null;
				}
			});
			}
		} catch (Exception e) {
			json.put("success", "false");
			if(e.getMessage() != null) {
				json.put("msg", e.getMessage());
			} else {
				json.put("msg", "数据更新失败");
			}
			e.printStackTrace();
		}
		
		this.out(res, json);
	}

}
