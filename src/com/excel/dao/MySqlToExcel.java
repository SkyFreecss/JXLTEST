package com.excel.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excel.Games;
import com.excel.service.DBService;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 将MySql中的数据导入到Excel中
 * @author SkyFreecss
 *
 */
public class MySqlToExcel {
       
	   static Log log = LogFactory.getLog("MySqlToExcel.class");
	
	   public void mysqltoExcel(String filepath)
	   {
		   WritableWorkbook wwb = null;//声明工作薄对象！
		   File file = new File(filepath);
		   
		   log.info("正在检查Excel文件是否存在！");
		   //检查该文件是否存在
		   if(!file.exists())
		   {
			 try {
				 //若不存在则新建该文件
				log.info("该文件不存在，正在创建。。。");
				file.createNewFile();
				log.info(filepath+"创建成功");
			} catch (IOException e) {
				log.error("文件创建失败！");
				e.printStackTrace();
			}
		   }
		   else
		   {
			   log.info("该文件已经存在，不进行创建！");
		   }
		   
		   try {
			   
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("游戏表", 0);//新建工作表对象，并声明其属于第几页。
			
			List<Games> list = DBService.getAllByDataBase();//获取所有的数据！
			String cmd[]={"explorer.exe","F:\\TestFile"};
			
			Process p = Runtime.getRuntime().exec(cmd);
			
			
			//创建单元格对象
			log.info("正在创建单元格！");
			Label labelid = new Label(0,0,"编    号(id)");
			Label labelname = new Label(1,0,"游 戏 名 称(name)");
			Label labelcompany = new Label(2,0,"制 作 公 司(company)");
			Label labelsummary = new Label(3,0,"概    要(summary)");
			Label labeldetails = new Label(4,0,"细    节(details)");
			Label labelprice = new Label(5,0,"价    格(price)");
			Label labelpicture = new Label(6,0,"游 戏 封 面(picture)");
			Label labelbigpicture = new Label(7,0,"游 戏 截 图(bigpicture)");			
			ws.addCell(labelid);
			ws.addCell(labelname);
			ws.addCell(labelcompany);
			ws.addCell(labelsummary);
			ws.addCell(labeldetails);
			ws.addCell(labelprice);
			ws.addCell(labelpicture);
			ws.addCell(labelbigpicture);
			
			
			for(int i=0;i<list.size();i++)
			{
				Label labelid_i = new Label(0,i+1,list.get(i).getId()+" ");
				Label labelname_n = new Label(1,i+1,list.get(i).getName()+" ");
				Label labelcompany_c = new Label(2,i+1,list.get(i).getCompany()+" ");
				Label labelsummary_s = new Label(3,i+1,list.get(i).getSummary()+" ");
				Label labeldetails_d = new Label(4,i+1,list.get(i).getDetails()+" ");
				Label labelprice_p = new Label(5,i+1,list.get(i).getPrice()+" ");
				Label labelpicture_p = new Label(6,i+1,list.get(i).getPicture()+" ");
				Label labelbigpicture_p = new Label(7,i+1,list.get(i).getBigpicture()+" ");
			}
			
			
			//打开流，写入文件。
			wwb.write();
			wwb.close();
			   log.info("单元格已创建完成！");	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			log.error("写入错误！");
			e.printStackTrace();
		}
	   }
}
