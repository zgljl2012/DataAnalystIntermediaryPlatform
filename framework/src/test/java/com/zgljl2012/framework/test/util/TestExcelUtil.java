package com.zgljl2012.framework.test.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.zgljl2012.framework.util.ExcelUtil;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午1:27:04
 * 
 */
public class TestExcelUtil {
	
	@Test
	public void readXlsx() throws InvalidFormatException, IOException {
		String path =  "src/test/resources/1.xlsx";
		List<List<String>> t = ExcelUtil.readXlsx(path);
		for(List<String> row : t) {
			for(String col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void readXls() throws FileNotFoundException, IOException {
		String path = "src/test/resources/2.xls";
		List<List<String>> t = ExcelUtil.readXls(path);
		for(List<String> row : t) {
			for(String col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void read() {
		String path =  "src/test/resources/1.xlsx";
		List<List<String>> t = ExcelUtil.read(path);
		for(List<String> row : t) {
			for(String col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
		path = "src/test/resources/2.xls";
		t = ExcelUtil.read(path);
		for(List<String> row : t) {
			for(String col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
}
