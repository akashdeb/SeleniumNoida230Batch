package com.crm.actiTime.seleniumAfternoonBatch.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtitlity {

	public String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		//Fetch Data from Excel
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fisExcel);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
				
	}

}
