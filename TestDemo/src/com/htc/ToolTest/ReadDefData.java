package com.htc.ToolTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import android.app.Activity;
import android.util.Log;

public class ReadDefData extends Activity{
	private Map<String, TestSheetDefDTO> defMap = new LinkedHashMap< String, TestSheetDefDTO>();
	private HSSFWorkbook workbook = null;
	public Map<String, TestSheetDefDTO> getDefData(FileInputStream fs, String sheetName) throws Exception {
		InputStream fileInputStream = fs;
		workbook = new HSSFWorkbook(fileInputStream);
		Log.e("sheet name",""+sheetName);
		HSSFSheet ws = workbook.getSheet(sheetName + "Def");
		
		if(ws!=null){
		int rowNum = ws.getLastRowNum() + 1;

		for (int i = 1; i < rowNum; i++) {
			HSSFRow row = ws.getRow(i);
			HSSFCell keyCell = row.getCell(0);
			String defMapKey = cellToString(keyCell);
			TestSheetDefDTO testDefDto = new TestSheetDefDTO();
			HSSFCell dataTypeCell = row.getCell(1);
			testDefDto.setDataType(cellToString(dataTypeCell));

			if (null != row.getCell(2) && !row.getCell(2).equals("")) {
				HSSFCell idCell = row.getCell(2);
				testDefDto.setId(cellToString(idCell));
			} else {
				testDefDto.setId("");
			}
			List<ParamsDTO> paramsDTO = new ArrayList<ParamsDTO>();
			if (i < rowNum - 1) {
				HSSFRow rowNext = ws.getRow(i + 1);
				String rowNextValue = cellToString(rowNext.getCell(0));

				while (rowNextValue.contains("#")) {
					ParamsDTO paramsDto = new ParamsDTO();
					paramsDto
							.setParamField(cellToString(rowNext.getCell(0)));
					if (null != rowNext.getCell(1))
						paramsDto.setParamDataType(cellToString(rowNext
								.getCell(1)));
					else
						paramsDto.setParamDataType("");
					if (null != rowNext.getCell(2))
						paramsDto.setParamField(cellToString(rowNext
								.getCell(2)));
					else
						paramsDto.setParamField("");
					
//					if (null != rowNext.getCell(2))
//						paramsDto.setParamId(cellToString(rowNext
//								.getCell(2)));
//					else
//						paramsDto.setParamId("");
					paramsDTO.add(paramsDto);
					i++;
					rowNext = ws.getRow(i + 1);
					rowNextValue = cellToString(rowNext.getCell(0));
				}
			}
			testDefDto.setParams(paramsDTO);
			defMap.put(defMapKey, testDefDto);
//			System.out.println(defMap);
//			System.out.println(defMap);
		}
		}
		fs.close();
		fileInputStream.close();
		return defMap;
		
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
