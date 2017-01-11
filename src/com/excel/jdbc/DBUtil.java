package com.excel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBUtil {
       
	   private static final String URL = "jdbc:mysql://localhost:3306/hwj?useUnicode=true&characterEncoding=utf-8";
	   private static final String USER = "root";
	   private static final String PASSWORD = "83493233";
	   
	   private static Connection conn = null;
	   private static Log log = LogFactory.getLog("DBUtil.class");
	   
	   static
	   {
		       try {
				Class.forName("com.mysql.jdbc.Driver");//数据库驱动。
				log.info("加载数据库驱动成功！");
				conn = DriverManager.getConnection(URL,USER, PASSWORD);//连接数据库驱动。
				log.info("连接数据库服务器成功！");
			} catch (ClassNotFoundException | SQLException e) {
				log.error("加载数据库驱动失败！");
				e.printStackTrace();
			}
		       
	   }
	   
	   
	   
	   //对外提供一个方法，获取连接！
	   public static Connection getConnection()
	   {
		   return conn;
	   }
}
