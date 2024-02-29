package selenium_final;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class pull_data {
	public Object[][] pulldatafromexcel() throws EncryptedDocumentException, IOException {

		//to get path from the excel sheet
		FileInputStream fi=new FileInputStream("D:\\springtool\\again\\src\\main\\resources\\Assignment.xlsx");
		Workbook excel= WorkbookFactory.create(fi);
		
	//create a object for workbook (workbook is class is avilable in apache poi )
	
	//acess the excel sheet
	   Sheet sheet1=excel.getSheet("Sheet1");
	    //step 1-get row and coloumn count of the excel
	    int rowcount=sheet1.getLastRowNum();
	   int cellcount=sheet1.getRow(1).getLastCellNum();
	    //step 2 createa a 2 dimensiomal object arraty
	   Object[][] obj=new Object[rowcount][cellcount];
	    
	   for(int i=0;i<rowcount;i++) {
	    	for(int j=0;j<cellcount;j++) {
	    	obj[i][j]=sheet1.getRow(i+1).getCell(j).getStringCellValue();
	    	}
	    }
	   return obj;


	}
	}

