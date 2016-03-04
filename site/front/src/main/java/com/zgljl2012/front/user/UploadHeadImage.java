package com.zgljl2012.front.user;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.servlet.AbstractServlet;

/**
 * @author 廖金龙
 * @version 2016年3月2日下午11:43:55
 * 
 */
@SuppressWarnings("serial")
@WebServlet(name="uploadHeadImage", urlPatterns={"/uploadHeadImage"})
public class UploadHeadImage extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		System.out.println("get");
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		System.out.println("post");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(4096);
		// the location for saving data that is larger than getSizeThreshold()
		File file = new File("/tmp");
		if(!file.exists()) {
			file.mkdirs();
		}
		factory.setRepository(file);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum size before a FileUploadException will be thrown
		upload.setSizeMax(1000000);

		List<FileItem> fileItems = upload.parseRequest(req);
		Iterator<FileItem> i = fileItems.iterator();
		FileItem fi = (FileItem)i.next();
		// filename on the client
		String fileName = fi.getName();
		// save comment and filename to database
		//   ...
		// write the file
		File file1 = new File(fileName);
		if(!file1.exists()) {
			file1.createNewFile();
		}
		System.out.println(file1.getAbsolutePath());
		fi.write(file1);
		redirect(res, "/front/more/user/");
	}

}
