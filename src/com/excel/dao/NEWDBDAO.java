package com.excel.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.excel.DJX;
import com.excel.jdbc.DBUtil;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class NEWDBDAO {
       
	   public void excelToMysql()
	   {
		   String filename = "F:/TestFile/djx.xls";
		   
		   Connection conn = DBUtil.getConnection();
		   try {
						   
			PreparedStatement ptmt = conn.prepareStatement("insert into djx(id,numbering,content) values (?,?,?)");
			
		   

		  InputStream is =new FileInputStream(filename);
	      
		  Workbook wk = Workbook.getWorkbook(is);
		  
		  Sheet[] sheet = wk.getSheets();
		  
		  int sheet_i_num = 0;
		  
		  DJX djx = new DJX();
		  
		  
		  String numbering = "";
		  String content = "";
		  String content2 = "";
		  String temp = "|";
		  if(sheet!=null&&sheet.length>0)
		  {
			  for(int sheetNum=0;sheetNum<sheet.length;sheetNum++)
			  {
				  sheet_i_num = sheet[sheetNum].getRows();
				  
				  for(int rowNum=1;rowNum<sheet_i_num;rowNum++)
				  {
					  Cell[] cells = sheet[sheetNum].getRow(rowNum);
					  numbering = cells[0].getContents();
					  content = cells[1].getContents();
					  ptmt.setInt(1,rowNum);
					  ptmt.setString(2,numbering);
					  content2 = content.replaceAll("\\|", "\n");
					  System.out.println(content2);
                      ptmt.setString(3,content2);
                      ptmt.executeUpdate();
                      System.out.println();
				  }
			  }
		  }
		  
		  wk.close();
		  ptmt.close();
		  conn.close();
		} catch (BiffException | IOException | SQLException e) {
			e.printStackTrace();
		}
	   }
}
