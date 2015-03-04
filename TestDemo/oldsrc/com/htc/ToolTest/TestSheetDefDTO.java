package com.htc.ToolTest;

import java.util.List;

public class TestSheetDefDTO {
	private String dataType;
	private String id;
	private List<ParamsDTO> params;
	

	public List<ParamsDTO> getParams() {
		return params;
	}

	public void setParams(List<ParamsDTO> params) {
		this.params = params;
	}

	public TestSheetDefDTO() {
		super();
	}

	public TestSheetDefDTO(String dataType, String id, List<ParamsDTO> params) {
		super();
		this.dataType = dataType;
		this.id = id;
		this.params = params;
	}

	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
