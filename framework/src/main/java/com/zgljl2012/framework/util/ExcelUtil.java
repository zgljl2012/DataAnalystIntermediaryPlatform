package com.zgljl2012.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author 廖金龙
 * @version 2016年5月24日上午1:20:28
 * 
 */
public class ExcelUtil {
	
	public static List<List<String>> read(String filePath) {
		String suffix = filePath.substring(filePath.lastIndexOf('.')+1);
		if("xls".equals(suffix.toLowerCase())) {
			try {
				return readXls(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if("xlsx".equals(suffix.toLowerCase())) {
			try {
				return readXlsx(filePath);
			} catch (InvalidFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static List<List<String>> readXls(String filePath) throws FileNotFoundException, IOException { 
		File file = new File(filePath);
	    POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new         FileInputStream(file));
	    HSSFWorkbook hssfWorkbook =  new HSSFWorkbook(poifsFileSystem);
	    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
	    List<List<String>> table = new ArrayList<>();
	    int rowstart = hssfSheet.getFirstRowNum();
	    int rowEnd = hssfSheet.getLastRowNum();
	    for(int i=rowstart;i<=rowEnd;i++)
	    {
	        HSSFRow row = hssfSheet.getRow(i);
	        if(null == row) continue;
	        int cellStart = row.getFirstCellNum();
	        int cellEnd = row.getLastCellNum();
	        List<String> listRow = new ArrayList<>();
	        for(int k=cellStart;k<=cellEnd;k++)
	        {
	            HSSFCell cell = row.getCell(k);
	            if(null==cell) continue;
	            switch (cell.getCellType())
	            {
	                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
	                	listRow.add(""+cell.getNumericCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_STRING: // 字符串
	                	listRow.add(cell.getStringCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
	                	listRow.add(""+cell.getBooleanCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_FORMULA: // 公式
	                    listRow.add(cell.getCellFormula());
	                    break;
	                case HSSFCell.CELL_TYPE_BLANK: // 空值
	                    listRow.add(" ");
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR: // 故障
	                	listRow.add("error");
	                    break;
	                default:
	                    System.out.print("未知类型   ");
	                    break;
	            }
	
	        }
	        table.add(listRow);
	    }
	    return table;
	}
	
	@SuppressWarnings("resource")
	public static List<List<String>> readXlsx(String filePath) 
			throws InvalidFormatException, IOException {
		File file = new File(filePath);
	    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
	    XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
	    int rowstart = xssfSheet.getFirstRowNum();
	    int rowEnd = xssfSheet.getLastRowNum();
	    List<List<String>> table = new ArrayList<>();
	    for(int i=rowstart;i<=rowEnd;i++)
	    {
	    	List<String> listRow = new ArrayList<>();
	        XSSFRow row = xssfSheet.getRow(i);
	        if(null == row) continue;
	        int cellStart = row.getFirstCellNum();
	        int cellEnd = row.getLastCellNum();

	        for(int k=cellStart;k<=cellEnd;k++)
	        {
	            XSSFCell cell = row.getCell(k);
	            if(null==cell) continue;

	            switch (cell.getCellType())
	            {
	                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
	                    listRow.add(""+cell.getNumericCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_STRING: // 字符串
	                    listRow.add(cell.getStringCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
	                	listRow.add(""+cell.getBooleanCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_FORMULA: // 公式
	                    listRow.add(cell.getCellFormula());
	                    break;
	                case HSSFCell.CELL_TYPE_BLANK: // 空值
	                    listRow.add(" ");
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR: // 故障
	                	listRow.add("error");
	                    break;
	                default:
	                    System.out.print("未知类型   ");
	                    break;
	            }
	        }
	        table.add(listRow);
	    }
	    return table;
	}
	
}
