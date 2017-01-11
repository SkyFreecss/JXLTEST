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
 * ��MySql�е����ݵ��뵽Excel��
 * @author SkyFreecss
 *
 */
public class MySqlToExcel {
       
	   static Log log = LogFactory.getLog("MySqlToExcel.class");
	
	   public void mysqltoExcel(String filepath)
	   {
		   WritableWorkbook wwb = null;//��������������
		   File file = new File(filepath);
		   
		   log.info("���ڼ��Excel�ļ��Ƿ���ڣ�");
		   //�����ļ��Ƿ����
		   if(!file.exists())
		   {
			 try {
				 //�����������½����ļ�
				log.info("���ļ������ڣ����ڴ���������");
				file.createNewFile();
				log.info(filepath+"�����ɹ�");
			} catch (IOException e) {
				log.error("�ļ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		   }
		   else
		   {
			   log.info("���ļ��Ѿ����ڣ������д�����");
		   }
		   
		   try {
			   
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("��Ϸ��", 0);//�½���������󣬲����������ڵڼ�ҳ��
			
			List<Games> list = DBService.getAllByDataBase();//��ȡ���е����ݣ�
			String cmd[]={"explorer.exe","F:\\TestFile"};
			
			Process p = Runtime.getRuntime().exec(cmd);
			
			
			//������Ԫ�����
			log.info("���ڴ�����Ԫ��");
			Label labelid = new Label(0,0,"��    ��(id)");
			Label labelname = new Label(1,0,"�� Ϸ �� ��(name)");
			Label labelcompany = new Label(2,0,"�� �� �� ˾(company)");
			Label labelsummary = new Label(3,0,"��    Ҫ(summary)");
			Label labeldetails = new Label(4,0,"ϸ    ��(details)");
			Label labelprice = new Label(5,0,"��    ��(price)");
			Label labelpicture = new Label(6,0,"�� Ϸ �� ��(picture)");
			Label labelbigpicture = new Label(7,0,"�� Ϸ �� ͼ(bigpicture)");			
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
			
			
			//������д���ļ���
			wwb.write();
			wwb.close();
			   log.info("��Ԫ���Ѵ�����ɣ�");	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			log.error("д�����");
			e.printStackTrace();
		}
	   }
}
