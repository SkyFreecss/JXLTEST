package com.excel.test;

import com.excel.dao.DBDAO;
import com.excel.dao.MySqlToExcel;

/**
 * 数据库的连接测试类
 * @author SkyFreecss
 *
 */
public class DBTEST {
       
	   public static void main(String args[])
	   {
		   MySqlToExcel mste = new MySqlToExcel();
		   mste.mysqltoExcel("f:/TestFile/test.xls");
	   }
}
