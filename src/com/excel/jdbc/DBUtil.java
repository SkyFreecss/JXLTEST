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
				Class.forName("com.mysql.jdbc.Driver");//���ݿ�������
				log.info("�������ݿ������ɹ���");
				conn = DriverManager.getConnection(URL,USER, PASSWORD);//�������ݿ�������
				log.info("�������ݿ�������ɹ���");
			} catch (ClassNotFoundException | SQLException e) {
				log.error("�������ݿ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		       
	   }
	   
	   
	   
	   //�����ṩһ����������ȡ���ӣ�
	   public static Connection getConnection()
	   {
		   return conn;
	   }
}
