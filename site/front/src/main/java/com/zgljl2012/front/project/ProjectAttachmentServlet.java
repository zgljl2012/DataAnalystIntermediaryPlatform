package com.zgljl2012.front.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.project.ProjectManage;

/**
 * @author 廖金龙
 * @version 2016年5月18日下午9:40:57
 * 项目附件上传
 */
@SuppressWarnings("serial")
@WebServlet(name="projectAttachment", urlPatterns={"/project/attachment"})
public class ProjectAttachmentServlet extends AbstractServlet{
	
	@Impl
	ProjectManage pm;
	
	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.doPost(req, res);
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		FileUpload fileUpload = controller.getFileUpload();
		Map<String, String> args = new HashMap<>();
		List<String> fileNames = fileUpload.upload(req, FILETYPE.FILE, args);
		String context = req.getContextPath();
		String url = context + "/" + "project";
		if(fileNames != null && fileNames.size() > 0) {
			String filename = fileNames.get(0);
			String pid = args.get("pid");
			if(pid!=null){
				url += "/edit/" + pid;
				pm.attachmentUpload(Integer.parseInt(pid), filename);
			}
		}
		this.redirect(res, url);
	}

}
