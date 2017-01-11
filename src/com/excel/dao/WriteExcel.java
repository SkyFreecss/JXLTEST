package com.excel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * д���
 * @author SkyFreecss
 *
 */
public class WriteExcel {
       
	   public static void main(String args[])
	   {
		   try {
			   //�������������󣬴�Excel�ļ������ļ������ڣ��򴴽��ļ���
			WritableWorkbook writebook = Workbook.createWorkbook(new File("F:/TestFile/test.xls"));
			
			//�½���������󣬲����������ڵڼ�ҳ��
			WritableSheet firstsheet = writebook.createSheet("Work1", 1);//
			WritableSheet secondsheet = writebook.createSheet("Work1", 0);
			
			//������Ԫ�����
			Label label1 = new Label(1, 4, "test4");
			firstsheet.addCell(label1);
			Label label2 = new Label(1, 5, "test5");
			secondsheet.addCell(label2);
			
			//������д���ļ���
			writebook.write();
            writebook.close();
		} catch (IOException | WriteException e) {
			
			e.printStackTrace();
		}
	   }
}
