package com.zgljl2012.front.preview;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.framework.util.PythonUtil;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午2:44:36
 * Python编译
 */
@SuppressWarnings("serial")
@WebServlet(name="pythonCode", urlPatterns={"/code/python"})
public class PythonServlet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		this.forward(req, res, "/more/preview/python.jsp");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		FileUpload load = controller.getFileUpload();
		String code = req.getParameter("code");
		String path = load.getPath()+"/" + FILETYPE.FILE.name();
		String console = PythonUtil.exec(
				path, 
				code, "utf-8");
		out(res, console);
	}

}
