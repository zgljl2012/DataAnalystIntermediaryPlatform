package com.zgljl2012.front.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.VerifyCodeTimeoutException;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.servlet.VerifyCode;
import com.zgljl2012.framework.servlet.VerifyCodeValidate;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.front.user.RegisterValidate.RegisterUrl;
import com.zgljl2012.modules.front.user.UserManage;

/**
 *@author 廖金龙
 *@version 2016年2月25日下午9:54:29
 */
@SuppressWarnings("serial")
@WebServlet(name="register", urlPatterns={"/register"})
public class RegisterServlet extends AbstractServlet{
	
	@Impl
	UserManage userManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception{
		// TODO Auto-generated method stub
		post(req, res, controller);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String userType = req.getParameter("userType");
		String verifyCode = req.getParameter("verifyCode");
		try {
			if(verifyCode==null||verifyCode!=null&&verifyCode.trim().length()==0) {
				throw new Exception("验证码不能为空！");
			}
			VerifyCode vc = (VerifyCode)req.getSession().getAttribute("verifyCode");
			boolean isPass = VerifyCodeValidate.validate(verifyCode, vc);
			if(!isPass) { // 验证码不通过
				req.setAttribute("username", username);
				req.setAttribute("email", email);
				req.setAttribute("userType", userType);
				req.setAttribute("hint", "验证码错误，请重新输入");
				forward(req, res, "/more/user/register.jsp");
				return;
			}
			int uid = userManage.register(username, StringHelper.crypt(password), email, userType);
			if(uid > 0) {
				new RegisterValidate(controller).processRegister(uid, email, new RegisterUrl(){
					public String url(String email, String hexCode) {
						return "http://localhost:8080/register.jsp?email="+email+"&hexCode="+hexCode;
					}
				});
			}
		} catch (VerifyCodeTimeoutException e) { // 验证码超时
			e.printStackTrace();
			req.setAttribute("username", username);
			req.setAttribute("email", email);
			req.setAttribute("userType", userType);
			req.setAttribute("hint", "验证码超时，请重新输入");
			forward(req, res, "/more/user/register.jsp");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("exp", e.getMessage());
			forward(req, res, "/error/error.jsp");
			return;
		}
		
		redirect(res, "/front/more/user/index.jsp");
	}
}
