package com.excel.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excel.Games;
import com.excel.dao.DBDAO;
import com.excel.jdbc.DBUtil;

/**
 * ���ݿ����
 * @author SkyFreecss
 *
 */
public class DBService {
	
       static Log log = LogFactory.getLog("DBService.class");
       
	   public static List<Games> getAllByDataBase()
	   {
		   List<Games> list = new ArrayList<Games>();
		   
		   DBDAO dd = new DBDAO();//�������ݿ⣡
		   
		   ResultSet rs = dd.DataBase();
		   
		   try {
			while(rs.next())
			   {
				   Integer id = rs.getInt("id");
				   String name = rs.getString("name");
				   String company = rs.getString("company");
				   String summary = rs.getString("summary");
				   String details = rs.getString("details");
				   Integer price = rs.getInt("price");
				   String picture = rs.getString("picture");
				   String bigpicture = rs.getString("bigpicture");
				   list.add(new Games(id,name,company,summary,details,price,picture,bigpicture));
			   }
		} catch (SQLException e) {
			log.error("��������");
			e.printStackTrace();
		}
		   return list;
	   }
}
