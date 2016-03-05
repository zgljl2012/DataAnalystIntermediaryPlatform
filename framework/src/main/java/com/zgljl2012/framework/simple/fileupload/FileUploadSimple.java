package com.zgljl2012.framework.simple.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zgljl2012.framework.fileupload.FileUpload;
import com.zgljl2012.framework.fileupload.FileUploadSetter;
import com.zgljl2012.framework.fileupload.FileUploadSetter.FILETYPE;
import com.zgljl2012.framework.util.StringHelper;

/**
 * @author 廖金龙
 * @version 2016年3月5日下午7:59:23
 * 
 */
public class FileUploadSimple implements FileUpload{
	
	private String path = System.getProperty("user.home")+"/"+"ljl-project";
	
	/**
	 * 默认的Setter
	 */
	public static FileUploadSetter COMMON_SETTER = new FileUploadSetter() {

		@Override
		public String getFileName(String name) {
			// TODO Auto-generated method stub
			name = name.substring(name.lastIndexOf("."));
			java.util.Date date = new java.util.Date();
			name = Long.toString(date.getTime()) + name;
			return name;
		}

		@Override
		public String getRelativePath() {
			// TODO Auto-generated method stub
			return "/" + getFileType().name();
		}
		
		@Override
		public String getRelativePath(FILETYPE fileType) {
			// TODO Auto-generated method stub
			return "/" + fileType.name();
		}

		@Override
		public FILETYPE getFileType() {
			// TODO Auto-generated method stub
			return FILETYPE.FILE;
		}
		
	};
	
	@Override
	public String upload(HttpServletRequest request) {
		return upload(request, COMMON_SETTER);
	}

	@Override
	public String upload(HttpServletRequest request, FileUploadSetter setter) {
		return upload(request, setter, setter.getFileType());
	}

	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub
		this.path = path;
	}

	@Override
	public String getPath(String path) {
		// TODO Auto-generated method stub
		return path;
	}

	@Override
	public String upload(HttpServletRequest request, FILETYPE fileType) {
		// TODO Auto-generated method stub
		return upload(request, COMMON_SETTER, fileType);
	}
	
	
	public String upload(HttpServletRequest request, FileUploadSetter setter, FILETYPE fileType) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 内存中存储的最大值
		int sizeThreshold = 4096;
		factory.setSizeThreshold(sizeThreshold);
		// 临时文件的存储地点
		File fileTmp = new File(System.getProperty("java.io.tmpdir"));
		if(!fileTmp.exists()) {
			fileTmp.mkdirs();
		}
		factory.setRepository(fileTmp);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum size before a FileUploadException will be thrown
		upload.setSizeMax(1000000);

		List<FileItem> fileItems;
		try {
			fileItems = upload.parseRequest(request);
			Iterator<FileItem> i = fileItems.iterator();
			FileItem fi = (FileItem)i.next();
			// filename on the client
			String fileName = fi.getName();
			String path = System.getProperty("user.home");
			if(!StringHelper.isEmpty(this.path)) {
				path = this.path;
			}
			String returnName = ""; // 返回的路径：相对路径/文件名
			if(setter != null) {
				fileName = setter.getFileName(fileName);
				if(fileType!=null) {
					path += setter.getRelativePath(fileType);
					returnName += setter.getRelativePath(fileType);
				}
			}
			returnName += "/"+fileName;
			File filePath = new File(path);
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			File file = new File(path, fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			fi.write(file);
			return returnName;
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
