package com.zgljl2012.front.preview;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.ExcelUtil;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午1:53:41
 * 预览Excel
 */
@SuppressWarnings("serial")
@WebServlet(name="preview",urlPatterns={"/preview"})
public class PreviewServlet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String path = req.getParameter("filePath");
		FileUpload loader = controller.getFileUpload();
		path = loader.getPath() + "/" + path;
		List<List<String>> table = ExcelUtil.read(path);
		req.setAttribute("table", table);
		String filename = path.substring(path.lastIndexOf('/')+1);
		req.setAttribute("filename", filename);
		this.forward(req, res, "/more/preview/preview.jsp");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
