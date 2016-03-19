package com.zgljl2012.front.user.fxs;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.enums.Degree;
import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.user.FxsManage;
import com.zgljl2012.modules.front.user.UserManage;
import com.zgljl2012.modules.front.user.query.T20Query;

/**
 * @author 廖金龙
 * @version 2016年2月29日下午1:58:55
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="FxsUpdate", urlPatterns={"/user/fxsUpdate"})
public class FxsUpdate extends AbstractServlet{
	
	@Impl
	FxsManage fxsManage;
	
	@Impl
	UserManage userManage;
	
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		post(req, res, controller);
	}

	@Override
	protected void post(final HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		final String name = req.getParameter("name");
		final String value = req.getParameter("value");
		JSON json = new JSON();
		PrintWriter out = res.getWriter();
		try{
			int uid = controller.getSession(req.getSession()).getUserId();
			if(uid <= 0) {
				throw new Exception("用户登录超时，请重新登录!");
			}
			// 修改用户名
			if("username".equals(name))
			if(!StringHelper.isEmpty(value)) {
				userManage.updateUsername(uid, value);
				json.put("status", "1"); // 修改成功
				json.put("description", "用户名修改成功！");
				out.println(json.toString());
				return;
			}
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 修改其他信息
			fxsManage.update(uid, new T20Query(){
	
				@Override
				public String getRealName() {
					// TODO Auto-generated method stub
					if("realName".equals(name)) return value;
					return null;
				}
	
				@Override
				public Gender getGender() {
					// TODO Auto-generated method stub
					if("gender".equals(name)) 
						return Gender.parse(value);
					return null;
				}
	
				@Override
				public Date getBornDate() {
					// TODO Auto-generated method stub
					try {
						if("bornDate".equals(name)) {
							return sdf.parse(value);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
	
				@Override
				public String getPersonalIntroduce() {
					// TODO Auto-generated method stub
					if("personalIntroduce".equals(name)) return value;
					return null;
				}
	
				@Override
				public Date getEmployDate() {
					// TODO Auto-generated method stub
					try {
						if("employDate".equals(name)) {
							return sdf.parse(value);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
	
				@Override
				public String getSchool() {
					// TODO Auto-generated method stub
					if("school".equals(name)) return value;
					return null;
				}
	
				@Override
				public String getCompany() {
					// TODO Auto-generated method stub
					if("commany".equals(name)) return value;
					return null;
				}
	
				@Override
				public String getHeadImgLink() {
					// TODO Auto-generated method stub
					if("headImgLink".equals(name)) return value;
					return null;
				}

				@Override
				public Degree getDegree() {
					if("degree".equals(name)) return Degree.parse(value);
					return null;
				}
				
			});
			json.put("status", "1"); // 修改成功
			json.put("description", "修改成功！");
			out.println(json.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
			json.put("status", "0"); // 修改失败
			json.put("description", e.getMessage());
			out.println(json.toString());
		}
	}

}
