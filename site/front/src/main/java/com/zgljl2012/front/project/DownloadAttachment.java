package com.zgljl2012.front.project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年5月18日下午11:00:48
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="downloadAttachment", urlPatterns="/download/attachment")
public class DownloadAttachment extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		FileUpload load = controller.getFileUpload();
		String filename = req.getParameter("filename");
		String path = load.getPath();
		path += filename;
		File file = new File(path);
		// 取得文件的后缀名。
        String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
        // 以流的形式下载文件。
        InputStream fis = new BufferedInputStream(new FileInputStream(path));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        res.reset();
        // 设置response的Header
        res.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
        res.addHeader("Content-Length", "" + file.length());
        OutputStream toClient = new BufferedOutputStream(res.getOutputStream());
        res.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
		
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}
	
	 
}
