package api.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@DataProvider(name = "all-test-data")
	public static Object[][] getTestData() throws Exception {

		String sheetname = "Sheet1";
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\testData\\Users.xlsx");

		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetname, colNum, 1),
						excel.getCellData(sheetname, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}
	@DataProvider(name = "all-username-data")
	public static Object[] getUserNameData() throws Exception {

		String sheetname = "Sheet1";
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\testData\\Users.xlsx");

		int rows = excel.getRowCount(sheetname);
		Object[] data = new Object[rows - 1];

		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();
			table.put(excel.getCellData(sheetname, 1, 1),
					excel.getCellData(sheetname, 1, rowNum));
			data[rowNum - 2] = table;
		}
		return data;
	}
	
	@Test(dataProvider = "all-username-data")
	public void test(Hashtable<String,String> data) {
		System.out.println(data);
	}

}
