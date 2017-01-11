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
	   static Connection conn = DBUtil.getConnection();//��ȡ���ݿ������
	   public ResultSet DataBase()
	   {
		   String sql = "select * from games";
		   rs = search(sql);
			
			try {
				while(rs.next())
				{
					System.out.println("-----------------------------------------");
					System.out.println("��          �ţ�"+"\t"+rs.getInt("id"));
					System.out.println("�� Ϸ �� �ƣ�"+"\t"+rs.getString("name"));
					System.out.println("�� �� �� ˾��"+"\t"+rs.getString("company"));
					System.out.println("��          Ҫ��"+"\t"+rs.getString("summary"));
					System.out.println("ϸ          �ڣ�"+"\t"+rs.getString("details"));
					System.out.println("��          ��"+"\t"+rs.getInt("price"));
					System.out.println("�� Ϸ �� �棺"+"\t"+rs.getString("picture"));
					System.out.println("�� Ϸ �� ͼ��"+"\t"+rs.getString("bigpicture"));
					System.out.println("-----------------------------------------");
				}
			} catch (SQLException e) {
				log.error("�Բ�����������");
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
