package com.zgljl2012.console.advertisement;

import java.io.ByteArrayOutputStream;
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
 * @version 2016年5月23日下午8:12:54
 * 广告
 */
@SuppressWarnings("serial")
@WebServlet(name="adShow", urlPatterns={"/ad/show"})
public class AdShowServlet extends AbstractServlet{

	@Override
	protected void get(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		String fileName = req.getParameter("filePath");
		FileUpload load = controller.getFileUpload();
		String path = load.getPath();
		path += fileName;
		File file = new File(path);
		OutputStream os = res.getOutputStream();
		FileInputStream fips = new FileInputStream(file);  
        byte[] btImg = readStream(fips);
        os.write(btImg);  
        os.flush(); 
	}

	@Override
	protected void post(HttpServletRequest req, HttpServletResponse res,
			Controller controller) throws Exception {
		
	}
	
	/** 
     * 读取管道中的流数据 
     */  
    public byte[] readStream(InputStream inStream) {  
        ByteArrayOutputStream bops = new ByteArrayOutputStream();  
        int data = -1;  
        try {  
            while((data = inStream.read()) != -1){  
                bops.write(data);  
            }  
            return bops.toByteArray();  
        }catch(Exception e){  
            return null;  
        }  
    } 
}
