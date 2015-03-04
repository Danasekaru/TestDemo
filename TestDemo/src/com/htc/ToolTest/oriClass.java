package com.htc.ToolTest;
//package ToolTest;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.*;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.List;
//import java.util.Properties;
//import java.util.Set;
//import java.util.TreeSet;
//
//import android.os.Environment;
//import android.test.ActivityInstrumentationTestCase2;
//import android.test.suitebuilder.TestMethod;
//import android.util.Log;
//
//import java.text.DateFormat;
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//
//import java.io.File;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
//import com.bitbar.recorder.extensions.ExtSolo;
//import com.htc.mail.sendMail;
//
//
//import ToolTest.ParamsDTO;
//
//import de.mindpipe.android.logging.log4j.LogConfigurator;
//import ToolTest.RobotiumMethod;
//
//import junit.framework.Assert;
//import junit.framework.AssertionFailedError;
//import java.lang.reflect.InvocationTargetException;
//
//
//
//@SuppressLint("NewApi")
//public class ToolMainClass extends ActivityInstrumentationTestCase2<Activity> {
//	private static final String METHOD_CLASS = "ToolTest.RobotiumMethod";
//	// Property File Name
//	private static final String PROPERTY_FILE = "TestTool.properties";
//	private static String TESTCASE_FILENAME;
//	private static String TESTDATA_FILENAME;
//	private Logger log;
//	// Map for Definition Data
//	private Map<String, TestSheetDefDTO> defMap = new LinkedHashMap<String, TestSheetDefDTO>();
//	// Map for Test Data
//	private Map<String, String> dataRowMap = new LinkedHashMap<String, String>();
//	// Screen Data
//	private Map<String, String> screenName = new LinkedHashMap<String, String>();
//
//	List<ParamsDTO> params;
//	private int result;
//
//	private ArrayList<TestResult> testResults = new ArrayList<TestResult>();
//
//	// Screen Launcher Parameter
//	private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.bharatmatrimony.SplashScreen";
//	private static Class<?> launchActivityClass;
//	static {
//		try {
//			launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps
//							// collecting better test execution data during test
//							// runs
//
//	@SuppressWarnings("unchecked")
//	public ToolMainClass() throws ClassNotFoundException {
//		super((Class<Activity>) launchActivityClass);
//	}
//
//	@Override
//	public void setUp() throws Exception {
//		super.setUp();
//		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass()
//				.getCanonicalName(), getName());
//		// Read Property file to get Test Case File Name and Test Definition
//		// file name
//		Properties prop = new Properties();
//		InputStream fileInputStream = getFilestream(PROPERTY_FILE);		
//		prop.load(fileInputStream);
//		TESTDATA_FILENAME = prop.getProperty("TestData_FileName").toString();
//		TESTCASE_FILENAME = prop.getProperty("Defination_FileName").toString();
//		fileInputStream.close();
//		logger();
//
//	}
//
//	@Override
//	public void tearDown() throws Exception {		
//		solo.finishOpenedActivities();
//		super.tearDown();
//
//	}
//
//	public void testApplication() throws Exception, ClassNotFoundException,
//			InvocationTargetException {
//		
//		try {			
//			ReadScreenData ldScreenData = new ReadScreenData();
//			
//			screenName = ldScreenData.getScreenData(getFilestream(TESTCASE_FILENAME));
//
//			Iterator<String> screenIterator = screenName.keySet().iterator();
//			
//			ScreenIteration(screenIterator);
//			
//			result=writeReportData(testResults);			
////			if(result==0){
////				 public static final String URL = "http://localhost:8080/SendMailAttachServlet/SendMailAttachServlet";
////			}
////			//send status success mail
//			
//		//new sendMail("robotest@test.com", "robotest1@test.com", "Test from Madhavi", "testing.txt", "D:/", "<h1>This is a test</h1>"
//		//	           + "", "text/html").send();
////			 sm.send();
//			
//			
//			Log.e("result",""+result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.assertNull(null);
//			throw e;
//		}
//	}
//
//	public FileInputStream getFilestream(String Filename) {
//		FileInputStream fs = null;
//		try {
//
//			fs = getActivity().openFileInput(Filename);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return fs;
//	}
//
//	public void logger() {
//
//		LogConfigurator logConfigurator = new LogConfigurator();
//
//		logConfigurator.setFileName(Environment.getExternalStorageDirectory()
//				+ File.separator + "RobotiumTestingLog" + File.separator
//				+ "logs" + File.separator + "log4j.txt");
//		logConfigurator.setRootLevel(Level.DEBUG);
//		logConfigurator.setLevel("org.apache", Level.ERROR);
//		logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
//		logConfigurator.setMaxFileSize(1024 * 1024 * 5);
//		logConfigurator.setImmediateFlush(true);
//		logConfigurator.configure();
//		log = Logger.getLogger(ToolMainClass.class);
//		log.info("\nBharat Matrimony Logger Created\n");
//	}
//
//	public String createReportFile() throws Exception {
//
//		FileOutputStream outputStreamOne = null;
//		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
//		Calendar cal = Calendar.getInstance();
//		String reportFileName = "TestReport_"
//				+ dateFormat.format(cal.getTime()) + ".xls";
//		HSSFWorkbook wb = new HSSFWorkbook();
//		try {
//			outputStreamOne = getActivity().openFileOutput(reportFileName,
//					Context.MODE_WORLD_WRITEABLE);
//			for (String testDTO1 : screenName.keySet()) {
//				HSSFSheet sheet = wb.createSheet(testDTO1);
//				int rowNum = sheet.getLastRowNum();
//				Row row = sheet.createRow(rowNum);
//				Cell cell0 = row.createCell(0);
//				cell0.setCellValue("Test Case");
//				Cell cell1 = row.createCell(1);
//				cell1.setCellValue("Test Scenario");
//				Cell cell2 = row.createCell(2);
//				cell2.setCellValue("Expected Output");
//				Cell cell3 = row.createCell(3);
//				cell3.setCellValue("Expected Screen");
//				Cell cell4 = row.createCell(4);
//				cell4.setCellValue("Result");
//			}
//			wb.write(outputStreamOne);
//			outputStreamOne.close();
//			log.info("\nTest Report Created with Sheet Name as Screen Name \n");
//
//		} catch (IOException e) {
//			Assert.assertNull(null);
//			e.printStackTrace();
//		}
//
//		return reportFileName;
//	}
//
//	public String assertResult(String expectedOutput, String expectedScreen){
//		//	throws AssertionFailedError {
//
//		String result = "";
//		try {
//			if (!expectedOutput.isEmpty()) {
//				Assert.assertTrue(solo.waitForText(expectedOutput, 1));
//			} else {
//				Assert.assertTrue(solo.waitForText(expectedScreen, 1));
//			}
//			result = "PASSED";
//		} catch (AssertionFailedError e) {
//			//Assert.assertFalse("DUmmy", false);
//			// Assert.assertNull(null);
//			// e = null;
//			result = "FAILED";
//
//			// solo.fail(result, e);
//
//		}
//		// catch (Exception e) {
//		// Assert.assertNull(null); }
//		log.info("Expected Output compared with Actual Result " + result + '\n');
//		return result;
//
//	}
//	
//	
//	public ArrayList<TestResult> ScreenIteration(Iterator<String> screenIterator) throws Exception{
//		
//		RobotiumMethod rm = new RobotiumMethod();
//
//		Class<?> extCls = Class.forName(METHOD_CLASS);
//		try{
//		int noOfRows = 0;
//		while (screenIterator.hasNext()) {
//
//			ReadDefData ldReadDefData = new ReadDefData();
//			ReadTestData ldReadTestData = new ReadTestData();
//			String sheetName = screenIterator.next().toString();
//			noOfRows = ldReadTestData.getTestDataRows(
//					getFilestream(TESTDATA_FILENAME), sheetName);
//
//			defMap = null;
//			defMap = ldReadDefData.getDefData(
//					getFilestream(TESTCASE_FILENAME), sheetName);
//
//			for (int i = 1; i < noOfRows; i++) {
//
//				dataRowMap = null;
//				dataRowMap = ldReadTestData.getTestData(
//						getFilestream(TESTDATA_FILENAME), sheetName, i);
//				if (!dataRowMap.get("Execute").contentEquals("N")) {
//					for (Map.Entry<String, TestSheetDefDTO> entry : defMap
//							.entrySet()) {
//						Object bO = true;
//						if (dataRowMap.containsKey(entry.getKey())
//								&& bO.equals(true)) {
//
//							Method meth = extCls.getDeclaredMethod(entry
//									.getValue().getDataType(),
//									ExtSolo.class, String.class,
//									String.class, String.class);
//
//							bO = meth.invoke(rm, solo, entry.getValue()
//									.getId(), entry.getValue()
//									.getDataType(), dataRowMap.get(entry
//									.getKey()));
//							System.out.println("Print Object Value" + bO);
//							log.info("\n"
//									+ entry.getValue().getId().toString()
//									+ " "
//									+ entry.getValue().getDataType()
//											.toString()
//									+ " "
//									+ dataRowMap.get(entry.getKey())
//											.toString());
//							for (ParamsDTO paramdt : entry.getValue()
//									.getParams()) {
//
//								Method meth1 = extCls.getDeclaredMethod(
//										paramdt.getParamDataType(),
//										ExtSolo.class, String.class,
//										String.class, String.class);
//
//								bO = meth1.invoke(rm, solo,
//										paramdt.getParamField(),
//										paramdt.getParamDataType(),
//										dataRowMap.get(entry.getKey()));
//								log.info("\n" + entry.getValue().getId()
//										+ " " + paramdt.getParamDataType()
//										+ " "
//										+ dataRowMap.get(entry.getKey()));
//
//							}
//
//						} else {
//							System.out
//									.println("Robotium not able to execute the Action");
//							break;
//						}
//					}
//					
//					String ExpOut=dataRowMap.get("Expected Output");
//					String ExpScr=dataRowMap.get("Expected Screen");
//					String TestCas=dataRowMap.get("Test Case");
//					String TestScen=dataRowMap.get("Test Scenario");
//					
//					String result = assertResult(ExpOut,ExpScr);
//
//					testResults.add(new TestResult(sheetName,TestCas,TestScen,ExpOut,ExpScr,result));				
//					
//				}		
//				
//				//Screen Refresh code			
//				
//				
////				if (sheetName.equalsIgnoreCase("Registration")) {
////					solo.goBack();
////					solo.clickOnButton("Register Now");
////				}
//			}
//		}
//		}
//		 catch (Exception exp) {
//				exp.printStackTrace();
//				Assert.assertNull(null);
//				throw exp;
//			}
//		return testResults;
//		}
//	
//
//	public int writeReportData(ArrayList<TestResult> results) throws Exception {
//
//		FileOutputStream outputStreamThird = null;
//		String fileName = this.createReportFile();
//		String[] files=getActivity().fileList();
//		int retVal = 0;		
//		try {
//			FileInputStream fs = getActivity().openFileInput(fileName);
//			HSSFWorkbook writeReportWorkbook = new HSSFWorkbook();
//			writeReportWorkbook = new HSSFWorkbook(fs);
//			for (TestResult res : results) {
//				HSSFSheet sheet = writeReportWorkbook.getSheet(res
//						.getSheetName());
//				int rowNum = sheet.getLastRowNum() + 1;
//				Row row = sheet.createRow(rowNum);
//				int cellnum = 0;
//				Cell cell = row.createCell(cellnum);
//				cell.setCellValue(res.getTestCase());
//				cellnum++;
//				Cell cellTs = row.createCell(cellnum);
//				cellTs.setCellValue(res.getTestScenario());
//				cellnum++;
//				Cell cellExpectedOutput = row.createCell(cellnum);
//				cellExpectedOutput.setCellValue(res.getExpectedResult());
//				cellnum++;
//				Cell cellExpectedScreen = row.createCell(cellnum);
//				cellExpectedScreen.setCellValue(res.getExpectedScreen());
//				cellnum++;
//				Cell cellResult = row.createCell(cellnum);
//				cellResult.setCellValue(res.getResult());
//				outputStreamThird = getActivity().openFileOutput(fileName,
//						Context.MODE_WORLD_WRITEABLE);
//				writeReportWorkbook.write(outputStreamThird);	
//				
//			}
//			
//			outputStreamThird.close();
//			log.info("\nTestResult Data in excel sheet completed..\n");
//			
//			for (String s: files){						
//			if(s.equalsIgnoreCase(fileName)){
//				retVal=0;				
//			}
//			else{
//				retVal=1;				
//			}
//			}
//
//		} catch (IOException e) {
//			return 1;
//		}
//		return retVal;
//	}
//	
//}