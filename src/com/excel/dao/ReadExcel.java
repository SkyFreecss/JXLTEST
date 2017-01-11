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
 * ����
 * @author SkyFreecss
 *
 */
public class ReadExcel {
       
	   public static void main(String args[])
	   {
		   //����Excel�ļ�����������
		     String sFilepath = "F:/TestFile/test.xls";
		     try {
				InputStream is = new FileInputStream(sFilepath);
		   
		   //��������������
				Workbook wk = Workbook.getWorkbook(is);
		   
		   //��ù������ĸ���
				wk.getNumberOfSheets();
				
				Sheet oFirstSheet = wk.getSheet(0);//ʹ��������ʽ��õ�һ��������Ҳ����ʹ��wk.getSheet(sheetName);
	//����sheetName��ʾ���ǹ����������
				
				int rows = oFirstSheet.getRows();//��ȡ�������е�������.
				int colums = oFirstSheet.getColumns();//��ȡ�������е�������.
				
				for(int i=0;i<rows;i++)
				{
					for(int l=0;l<colums;l++)
					{
						Cell ocell = oFirstSheet.getCell(l,i);//������������һ�����������ڶ�����������
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
