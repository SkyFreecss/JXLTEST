package com.excel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excel.jdbc.DBUtil;

/**
 * 
 * @author SkyFreecss
 *
 */
public class DBDAO {
       static Log log = LogFactory.getLog("DBDAO.class");
	   static ResultSet rs = null;
	   static Connection conn = DBUtil.getConnection();//获取数据库的连接
	   public ResultSet DataBase()
	   {
		   String sql = "select * from games";
		   rs = search(sql);
			
			try {
				while(rs.next())
				{
					System.out.println("-----------------------------------------");
					System.out.println("编          号："+"\t"+rs.getInt("id"));
					System.out.println("游 戏 名 称："+"\t"+rs.getString("name"));
					System.out.println("制 作 公 司："+"\t"+rs.getString("company"));
					System.out.println("概          要："+"\t"+rs.getString("summary"));
					System.out.println("细          节："+"\t"+rs.getString("details"));
					System.out.println("价          格："+"\t"+rs.getInt("price"));
					System.out.println("游 戏 封 面："+"\t"+rs.getString("picture"));
					System.out.println("游 戏 截 图："+"\t"+rs.getString("bigpicture"));
					System.out.println("-----------------------------------------");
				}
			} catch (SQLException e) {
				log.error("对不起，数据有误！");
				e.printStackTrace();
			}
			
		    return rs;
	   }
	   
	   public ResultSet search(String sql)
	   {		   
              try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
              return rs;
	   }
}
