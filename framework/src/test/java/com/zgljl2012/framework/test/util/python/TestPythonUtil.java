package com.zgljl2012.framework.test.util.python;

import org.junit.Test;

import com.zgljl2012.framework.util.PythonUtil;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午2:33:55
 * 测试PythonUtil
 */
public class TestPythonUtil {
	
	@Test
	public void testPythonExec() {
		String command = "print('我')";
		String s = PythonUtil.exec(command, "utf-8");
		System.out.println(s);
	}
	
	@Test
	public void testPythonExecPath() {
		String command = "import xlrd" + "\n" +
				"data = xlrd.open_workbook('1464027939603.xlsx')"  + "\n" +
				"table = data.sheets()[0]"  + "\n" +
				"nrows = table.nrows" + "\n" +
				"print(nrows)";
		String s = PythonUtil.exec("C:/Users/Administrator/ljl-project/FILE",command, "utf-8");
		System.out.println(s);
	}
	
}
