package com.htc.ToolTest;

public class TestResult {

	public static final String PASS="Passed";
	public static final String FAIL="Failed";
	
	private String sheetName;
	private String testCase;
	private String testScenario;
	private String expectedResult;
	private String expectedScreen;
	private String result;
	
	
	
	public TestResult() {
	}
	
	public TestResult(String sheetName, String testCase,
			String testScenario, String expectedResult, String expectedScreen,
			String result) {
		super();
		this.sheetName = sheetName;
		this.testCase = testCase;
		this.testScenario = testScenario;
		this.expectedResult = expectedResult;
		this.expectedScreen = expectedScreen;
		this.result = result;
	}

	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getTestScenario() {
		return testScenario;
	}
	public void setTestScenario(String testScenario) {
		this.testScenario = testScenario;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public String getExpectedScreen() {
		return expectedScreen;
	}
	public void setExpectedScreen(String expectedScreen) {
		this.expectedScreen = expectedScreen;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	@Override
	public String toString() {
		return "TestResult [ sheetName=" + sheetName
				+ ", testCase=" + testCase + ", testScenario=" + testScenario
				+ ", expectedResult=" + expectedResult + ", expectedScreen="
				+ expectedScreen + ", result=" + result + "]";
	}

}
