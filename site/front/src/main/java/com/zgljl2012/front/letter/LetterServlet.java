package com.zgljl2012.front.letter;

import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.variable.PaggingVariable;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.PagingInfo;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.JSON;
import com.zgljl2012.modules.letter.manage.query.LetterQuery;
import com.zgljl2012.modules.letter.manage.service.LetterManage;

/**
 * @author 廖金龙
 * @version 2016年5月15日下午2:32:48
 * 站内信
 */
@SuppressWarnings("serial")
@WebServlet(name="letterServlet", urlPatterns={"/letter"})
public class LetterServlet  extends AbstractServlet{

	@Impl
	LetterManage letterManage;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		int userId = controller.getSession(req.getSession()).getUserId();
		final String current = req.getParameter("current");
		final String readed = req.getParameter("readed");
		final int pageSize = Integer.parseInt(controller.getVariableManage().getValue(
				PaggingVariable.PAGE_LETTER_SIZE));
		JSON json = letterManage.getAllLetter(userId, new PagingInfo() {
			
			@Override
			public int getPageSize() {
				return pageSize;
			}
			
			@Override
			public int getCurrentPage() {
				if(current != null) {
					return Integer.parseInt(current);
				}
				return 1;
			}
		}, new LetterQuery(){

			@Override
			public Readed getReaded() {
				if("readed".equals(readed)) {
					return Readed.READED;
				} else if("unreaded".equals(readed)) {
					return Readed.UNREADED;
				}
				return null;
			}
			
		});
		json.put("pageSize", ""+pageSize);
		out(res, json);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String type = req.getParameter("type");
		if("read".equals(type)) {
			String id = req.getParameter("id");
			letterManage.readedLetter(Integer.parseInt(id));
		} else if("del".equals(type)) {
			String[] lids = req.getParameterValues("lid[]");
			if(lids != null)
				for(String id : lids) {
					letterManage.deleteLetter(Integer.parseInt(id));
				}
		} else if("delAll".equals(type)) {
			int userId = controller.getSession(req.getSession()).getUserId();
			letterManage.deleteAllLetterOfOne(userId);
		}
		
	}

}
