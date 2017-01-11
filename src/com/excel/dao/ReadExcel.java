package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 读表
 * @author SkyFreecss
 *
 */
public class ReadExcel {
       
	   public static void main(String args[])
	   {
		   //构造Excel文件输入流对象。
		     String sFilepath = "F:/TestFile/test.xls";
		     try {
				InputStream is = new FileInputStream(sFilepath);
		   
		   //声明工作簿对象
				Workbook wk = Workbook.getWorkbook(is);
		   
		   //获得工作簿的个数
				wk.getNumberOfSheets();
				
				Sheet oFirstSheet = wk.getSheet(0);//使用索引形式获得第一个工作表，也可以使用wk.getSheet(sheetName);
	//其中sheetName表示的是工作表的名称
				
				int rows = oFirstSheet.getRows();//获取工作表中的总行数.
				int colums = oFirstSheet.getColumns();//获取工作表中的总列数.
				
				for(int i=0;i<rows;i++)
				{
					for(int l=0;l<colums;l++)
					{
						Cell ocell = oFirstSheet.getCell(l,i);//两个参数，第一个是列数，第二个是行数。
						System.out.println(ocell.getContents()+"\r\n");
					}
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
}
