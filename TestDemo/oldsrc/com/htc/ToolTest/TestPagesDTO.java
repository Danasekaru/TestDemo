package com.htc.ToolTest;

import java.util.List;
import java.util.Map;

public class TestPagesDTO {
	private String sheetName;
	private Map<String,TestSheetDefDTO> defMap;	
	
public TestPagesDTO(String sheetName, Map<String, TestSheetDefDTO> defMap,
			Map<String, List<String>> dataMap) {
		super();
		this.sheetName = sheetName;
		this.defMap = defMap;
	}

	
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	public Map<String, TestSheetDefDTO> getDefMap() {
		return defMap;
	}
	public void setDefMap(Map<String, TestSheetDefDTO> defMap) {
		this.defMap = defMap;
	}

	
}
