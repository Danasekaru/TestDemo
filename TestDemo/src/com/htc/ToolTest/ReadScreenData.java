package com.htc.ToolTest;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import android.app.Activity;

public class ReadScreenData  extends Activity{
Map<String,String> screenName = new LinkedHashMap<String,String>();
HSSFWorkbook workbook = null;


String sheetName = "Screens";
public Map<String,String> getScreenData(FileInputStream fs) throws Exception {
	InputStream fileInputStream = fs;
	workbook = new HSSFWorkbook(fileInputStream);
	HSSFSheet ws = workbook.getSheet(sheetName);
	int rowNum = ws.getLastRowNum() + 1;
	for (int i = 1; i < rowNum; i++) {
		HSSFRow row = ws.getRow(i);
		HSSFCell scrKey = row.getCell(1);
		HSSFCell scrId = row.getCell(1);
		screenName.put(cellToString(scrKey),cellToString(scrId));
	}
	fs.close();
	fileInputStream.close();
	return screenName;
}
public static String cellToString(HSSFCell cell) throws Exception {

	int type;
	Object result;
	type = cell.getCellType();

	switch (type) {

	case 0:// numeric value in excel
		result = cell.getNumericCellValue();
		break;
	case 1: // string value in excel
		result = cell.getStringCellValue();
		break;
	case 2: // boolean value in excel
		result = cell.getBooleanCellValue();
		break;
	default:
		throw new Exception();
	}

	return result.toString();

}
}
