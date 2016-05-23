package com.zgljl2012.framework.util.python;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtil {
	
	/**
	 * 存储文件
	 * @param fp 文件路径+文件命名
	 * @param content 文件内容
	 */
	public static void save(String fp, String content, String charset) {
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fp),charset);
			out.write(content);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(String fp) {
		File f = new File(fp);
		if(f.exists()) {
			f.delete();
		}
	}
}
