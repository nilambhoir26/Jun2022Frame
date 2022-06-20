package com.qa.jun2022.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static Workbook book;
	public static Sheet sheet;
	public static final String TestData_File_Path = "./src/main/java/com/qa/jun2022/TestData/TestData.xls";

	public static Object[][] getExcelData(String Sheetname) {

		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(TestData_File_Path);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(Sheetname);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}
		}

		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	
}
