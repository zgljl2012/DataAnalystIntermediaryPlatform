package com.zgljl2012.front.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.servlet.VerifyCode;
import com.zgljl2012.framework.servlet.VerifyCodeValidate;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.user.UserManage;

/**
 * @author 廖金龙
 * @version 2016年3月30日下午9:35:19
 * 修改密码Servlet
 */
@SuppressWarnings("serial")
@WebServlet(name="resetPwdServlet", urlPatterns={"/user/resetPwd"})
public class ResetPwdServlet extends AbstractServlet{
	
	@Impl
	UserManage userManage;
	
	private static final String url = "/more/user/resetPwd.jsp";
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.forward(req, res, url);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String type = req.getParameter("type");
		JSON result = new JSON();
		result.put("success", "true");
		if("oldPwd".equals(type)) {
			String oldPwd = req.getParameter("oldPwd");
			int uid = userManage.login(controller.getSession(req.getSession()).getUsername(),
					StringHelper.crypt(oldPwd));
			if(uid <= 0) {
				result.put("success", "false");
				result.put("description", "原密码错误");
			}
			out(res, result);
		} else {
			String oldPwd = req.getParameter("old_password");
			String newPwd = req.getParameter("new_password");
			String rePwd = req.getParameter("re_password");
			String verifyCode = req.getParameter("verifyCode");
			try{
				if(newPwd == null) {
					throw new Exception("请输入新密码");
				}
				if(rePwd == null) {
					throw new Exception("请输入确认密码");
				}
				if(verifyCode == null) {
					throw new Exception("请输入验证码");
				}
				if(oldPwd == null) {
					throw new Exception("请输入原密码");
				}
				VerifyCode vc = (VerifyCode)req.getSession().getAttribute("verifyCode");
				boolean isPass = VerifyCodeValidate.validate(verifyCode, vc);
				if(!isPass) { // 验证码不通过
					throw new Exception("验证码错误，请重新输入");
				}
				int uid = userManage.login(controller.getSession(req.getSession()).getUsername(),
						StringHelper.crypt(oldPwd));
				if(uid <= 0) {
					throw new Exception("原密码错误");
				}
				if(!newPwd.equals(rePwd)) {
					throw new Exception("两次输入的密码不一致");
				}
				userManage.updatePassword(
						controller.getSession(req.getSession()).getUserId(), 
						StringHelper.crypt(newPwd));
				req.setAttribute("success", true);
				req.setAttribute("description", "密码修改成功！");
			} catch(Exception e) {
				req.setAttribute("success", false);
				req.setAttribute("description", e.getMessage());
			}
			forward(req, res, url);
		}
		
	}

}
