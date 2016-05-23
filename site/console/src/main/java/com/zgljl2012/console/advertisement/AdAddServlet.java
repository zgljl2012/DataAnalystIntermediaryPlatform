package com.zgljl2012.console.advertisement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.common.database.T80;
import com.zgljl2012.console.AbstractConsoleServlet;
import com.zgljl2012.console.module.service.manage.AdvertisementManage;
import com.zgljl2012.console.module.service.manage.query.AdvertisementQuery;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;
import com.zgljl2012.framework.permission.Permission;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午7:11:30
 * 增加广告
 */
@SuppressWarnings("serial")
@WebServlet(name="adAdd", urlPatterns={"/ad/add"})
@Permission(name="添加广告")
public class AdAddServlet extends AbstractConsoleServlet{

	@Impl
	AdvertisementManage am;
	
	@Override
	protected boolean isPermission() {
		return true;
	}

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String id = req.getParameter("id");
		if(!StringHelper.isEmpty(id)) {
			T80 t = am.detail(Integer.parseInt(id));
			req.setAttribute("t", t);
			this.forward(req, res, "/more/system/editAd.jsp");
			return;
		}
		this.forward(req, res, "/more/system/addAd.jsp");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		FileUpload load = controller.getFileUpload();
		Map<String, String> map = new HashMap<>();
		final List<String> ls = load.upload(req, FILETYPE.IMAGE, map);
		final String title = map.get("title");
		final String href = map.get("href");
		am.add(new AdvertisementQuery() {
			
			@Override
			public String getTitle() {
				return title;
			}
			
			@Override
			public String getPath() {
				return ls.get(0);
			}
			
			@Override
			public String getHref() {
				return href;
			}
		});
		String context = req.getContextPath();
		this.redirect(res, context+"/more/compaign.jsp");
	}

}
