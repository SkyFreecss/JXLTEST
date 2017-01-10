package com.excel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 写入表
 * @author SkyFreecss
 *
 */
public class WriteExcel {
       
	   public static void main(String args[])
	   {
		   try {
			   //创建工作簿对象，打开Excel文件，若文件不存在，则创建文件。
			WritableWorkbook writebook = Workbook.createWorkbook(new File("F:/TestFile/test.xls"));
			
			//新建工作表对象，并声明其属于第几页。
			WritableSheet firstsheet = writebook.createSheet("Work1", 1);//
			WritableSheet secondsheet = writebook.createSheet("Work1", 0);
			
			//创建单元格对象
			Label label1 = new Label(1, 4, "test4");
			firstsheet.addCell(label1);
			Label label2 = new Label(1, 5, "test5");
			secondsheet.addCell(label2);
			
			//打开流，写入文件。
			writebook.write();
            writebook.close();
		} catch (IOException | WriteException e) {
			
			e.printStackTrace();
		}
	   }
}
