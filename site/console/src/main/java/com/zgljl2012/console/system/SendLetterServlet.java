package com.zgljl2012.console.system;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.modules.front.user.UserManage;
import com.zgljl2012.modules.letter.manage.service.LetterManage;

/**
 * @author 廖金龙
 * @version 2016年5月14日下午11:08:18
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="sendLetter", urlPatterns={"/sendLetter"})
@Permission(name="发送站内信")
public class SendLetterServlet extends AbstractConsoleServlet{

	@Impl
	UserManage userManage;
	
	@Impl
	LetterManage letterManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String title = req.getParameter("title");
		String username = req.getParameter("username");
		String content = req.getParameter("content");
		int id = userManage.getUidByUsername(username);
		if(id == 0) {
			throw new PostException("未找到该用户");
		}
		letterManage.sendLetter(0, id, title, content);
		String url = "more/compaign.jsp";
		this.redirect(res, url);
	}

	@Override
	protected boolean isPermission() {
		return true;
	}

}
