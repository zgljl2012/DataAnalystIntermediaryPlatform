package com.zgljl2012.front.user;

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
import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;
import com.zgljl2012.framework.servlet.AbstractServlet;
import com.zgljl2012.modules.front.user.FxsManage;

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
		FileUpload fileUpload = controller.getFileUpload();
		String fileName = fileUpload.upload(req, FILETYPE.IMAGE);
		FxsManage manage = controller.getServiceManage().getService(FxsManage.class);
		manage.updateHeadImage(
				controller.getSession(req.getSession()).getUserId(), fileName);
		redirect(res, "/front/more/user/");
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
