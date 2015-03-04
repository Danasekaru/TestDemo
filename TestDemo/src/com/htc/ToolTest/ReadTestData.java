package com.htc.ToolTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import android.app.Activity;
import android.util.Log;

public class ReadTestData extends Activity {
	Map<String, String> dataRowMap = new LinkedHashMap< String, String>();
	HSSFWorkbook workbook = null;
	int rowCount = '0';
	int n = 1;
//	String sheetName = "Registration";
	public Map<String, String> getTestData(FileInputStream fs, String sheetName, int rowNumber) throws IOException {
		InputStream fileInputStream = fs;
		workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet ws = workbook.getSheet(sheetName + "Data");
		int colNum = ws.getRow(0).getLastCellNum();
		for (int i = 0; i < colNum; i++) {
			Cell cellHeader = ws.getRow(0).getCell(i);
			Cell cell = ws.getRow(rowNumber).getCell(i);
			
			if (null != cell) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cellHeader.setCellType(Cell.CELL_TYPE_STRING);
				dataRowMap.put(cellHeader.toString(),cell.toString());
//				System.out.println(dataRowMap);
			} else {
				cellHeader.setCellType(Cell.CELL_TYPE_STRING);
//				cell.setCellType(Cell.CELL_TYPE_STRING);
				dataRowMap.put(cellHeader.toString(),"");
			}
		}
		fs.close();
		fileInputStream.close();
		return dataRowMap;
	
	}
	
	public int getTestDataRows(FileInputStream fs, String sheetName) throws IOException {
		int rowNumber= 0;
		InputStream fileInputStream = fs;
		workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet ws = workbook.getSheet(sheetName + "Data");
		if(ws!=null){
		 Log.e("row number",""+ws.getLastRowNum());
		 System.out.println("row number"+ws.getLastRowNum());
		rowNumber = ws.getLastRowNum() + 1;
		 System.out.println("row number"+rowNumber);
		}
		fs.close();
		fileInputStream.close();
		return rowNumber;
	}

}
