package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.CPU;
import backend.CPUController;
import backend.Controller;

public class Test_CPUController {
	// need to add equals method in CPU
	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}
	
	@Test
	public void test_searchById1() {
		CPU expected = new CPU("AMD A10-9700E", 4, "3 GHz", "3.5 GHz", "35.0", "Radeon R7 (on-die)", "No", 742, 4);
		CPU result = CPUController.searchById(4);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		CPU result = CPUController.searchById(101);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95.0", "Radeon R7 (on-die)", "No", 900, 1));
		expected.add(new CPU("AMD A10-7850K", 4, "3.7 GHz", "4 GHz", "95.0", "Radeon R7 (on-die)", "No", 1227, 2));
		expected.add(new CPU("AMD A10-9700", 4, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R7 (on-die)", "No", 589, 3));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("Intel Xeon E5-2699 V4", 22, "2.2 GHz", "3.6 GHz", "145.0", "None", "Yes", 33841, 100));
		expected.add(new CPU("Intel Xeon E5-2699 V3", 18, "2.3 GHz", "3.6 GHz", "145.0", "None", "Yes", 31168, 99));
		expected.add(new CPU("Intel Xeon E5-2697 V4", 18, "2.3 GHz", "3.6 GHz", "145.0", "None", "Yes", 21605, 98));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreCount1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A6-7400K", 2, "3.5 GHz", "3.9 GHz", "65.0", "Radeon R5 (on die)", "No", 505, 5));
		expected.add(new CPU("AMD A6-9500", 2, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R5 (on die)", "No", 325, 6));
		expected.add(new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95.0", "Radeon R7 (on-die)", "No", 900, 1));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Core Count", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreCount2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD Threadripper 2990WX", 32, "3 GHz", "4.2 GHz", "250.0", "None", "Yes", 12862, 33));
		expected.add(new CPU("AMD Threadripper 2970WX", 24, "3 GHz", "4.2 GHz", "250.0", "None", "Yes", 7136, 32));
		expected.add(new CPU("Intel Xeon E5-2699 V4", 22, "2.2 GHz", "3.6 GHz", "145.0", "None", "Yes", 33841, 100));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Core Count", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreClock1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("Intel Xeon E5-2650L V3", 12, "1.8 GHz", "2.5 GHz", "65.0", "None", "Yes", 1993, 90));
		expected.add(new CPU("Intel Xeon E5-2650", 8, "2 GHz", "2.8 GHz", "95.0", "None", "Yes", 460, 88));
		expected.add(new CPU("Intel Core i5-8500T", 6, "2.1 GHz", "3.5 GHz", "35.0", "Intel UHD Graphics 630", "No",
				2172, 48));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Core Clock", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreClock2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD FX-9370", 8, "4.4 GHz", "4.7 GHz", "220.0", "None", "No", 6060, 12));
		expected.add(new CPU("Intel Core i7-7740X", 4, "4.3 GHz", "4.5 GHz", "112.0", "None", "Yes", 4047, 70));
		expected.add(new CPU("Intel Core i7-7700K", 4, "4.2 GHz", "4.5 GHz", "91.0", "Intel HD Graphics 630", "Yes",
				2788, 69));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Core Clock", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListBoostClock1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("Intel Xeon E5-2650L V3", 12, "1.8 GHz", "2.5 GHz", "65.0", "None", "Yes", 1993, 90));
		expected.add(new CPU("Intel Xeon E5-2650", 8, "2 GHz", "2.8 GHz", "95.0", "None", "Yes", 460, 88));
		expected.add(new CPU("Intel Xeon E5-2620 V4", 8, "2.1 GHz", "3 GHz", "85.0", "None", "Yes", 3171, 87));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Boost Clock", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListBoostClock2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(
				new CPU("Intel Core i7-8086K", 6, "4 GHz", "5 GHz", "95.0", "Intel UHD Graphics 630", "Yes", 7169, 72));
		expected.add(new CPU("Intel Core i9-9900", 8, "3.1 GHz", "5 GHz", "65.0", "Intel UHD Graphics 630", "Yes", 3463,
				80));
		expected.add(new CPU("Intel Core i9-9900K", 8, "3.6 GHz", "5 GHz", "95.0", "Intel UHD Graphics 630", "Yes",
				3992, 81));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Boost Clock", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListTdp1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A10-9700E", 4, "3 GHz", "3.5 GHz", "35.0", "Radeon R7 (on-die)", "No", 742, 4));
		expected.add(new CPU("Intel Core i5-8500T", 6, "2.1 GHz", "3.5 GHz", "35.0", "Intel UHD Graphics 630", "No",
				2172, 48));
		expected.add(new CPU("AMD A10-9700", 4, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R7 (on-die)", "No", 589, 3));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("TDP (W)", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListTdp2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD Threadripper 2970WX", 24, "3 GHz", "4.2 GHz", "250.0", "None", "Yes", 7136, 32));
		expected.add(new CPU("AMD Threadripper 2990WX", 32, "3 GHz", "4.2 GHz", "250.0", "None", "Yes", 12862, 33));
		expected.add(new CPU("AMD FX-9370", 8, "4.4 GHz", "4.7 GHz", "220.0", "None", "No", 6060, 12));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("TDP (W)", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListIntegratedGraphics1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("Intel Core i5-4440", 4, "3.1 GHz", "3.3 GHz", "84.0", "Intel HD Graphics 4600", "No",
				2145, 35));
		expected.add(new CPU("Intel Core i5-4690", 4, "3.5 GHz", "3.9 GHz", "84.0", "Intel HD Graphics 4600", "No", 1613, 36));
		expected.add(new CPU("Intel Core i5-4690K", 4, "3.5 GHz", "3.9 GHz", "88.0", "Intel HD Graphics 4600", "No", 1910, 37));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Integrated Graphics", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListIntegratedGraphics2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD Ryzen 3 3200G", 4, "3.6 GHz", "4 GHz", "65.0", "Radeon Vega 8", "No", 693, 16));
		expected.add(new CPU("AMD Ryzen 5 3400G", 4, "3.7 GHz", "4.2 GHz", "65.0", "Radeon Vega 11", "Yes", 1130, 22));
		expected.add(new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95.0", "Radeon R7 (on-die)", "No", 900, 1));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Integrated Graphics", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSmt1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95.0", "Radeon R7 (on-die)", "No", 900, 1));
		expected.add(new CPU("AMD A10-7850K", 4, "3.7 GHz", "4 GHz", "95.0", "Radeon R7 (on-die)", "No", 1227, 2));
		expected.add(new CPU("AMD A10-9700", 4, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R7 (on-die)", "No", 589, 3));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("SMT", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSmt2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD Ryzen 5 1400", 4, "3.2 GHz", "3.4 GHz", "65.0", "None", "Yes", 972, 17));
		expected.add(new CPU("AMD Ryzen 5 1500X", 4, "3.5 GHz", "3.7 GHz", "65.0", "None", "Yes", 1007, 18));
		expected.add(new CPU("AMD Ryzen 5 1600", 6, "3.2 GHz", "3.6 GHz", "65.0", "None", "Yes", 795, 19));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("SMT", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A6-9500", 2, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R5 (on die)", "No", 325, 6));
		expected.add(new CPU("Intel Xeon E5-2650", 8, "2 GHz", "2.8 GHz", "95.0", "None", "Yes", 460, 88));
		expected.add(new CPU("AMD Athlon X4 950", 4, "3.5 GHz", "3.8 GHz", "65.0", "None", "No", 463, 10));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("Intel Xeon E5-2699 V4", 22, "2.2 GHz", "3.6 GHz", "145.0", "None", "Yes", 33841, 100));
		expected.add(new CPU("Intel Xeon E5-2699 V3", 18, "2.3 GHz", "3.6 GHz", "145.0", "None", "Yes", 31168, 99));
		expected.add(new CPU("Intel Xeon E5-2697 V4", 18, "2.3 GHz", "3.6 GHz", "145.0", "None", "Yes", 21605, 98));
		ArrayList<CPU> sortedList = CPUController.getSortedList("Name", "Ascending");
		sortedList = CPUController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<CPU> expected = new ArrayList<>();
		expected.add(new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95.0", "Radeon R7 (on-die)", "No", 900, 1));
		expected.add(new CPU("AMD A10-7850K", 4, "3.7 GHz", "4 GHz", "95.0", "Radeon R7 (on-die)", "No", 1227, 2));
		expected.add(new CPU("AMD A10-9700", 4, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R7 (on-die)", "No", 589, 3));
		ArrayList<CPU> result = CPUController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		CPUController cpuController = (CPUController) CPUController.getInstance();
		String[][] expected = new String[1][9];
		expected[0][0] = "AMD A10-7700K";
		expected[0][1] = Integer.toString(4);
		expected[0][2] = "3.4 GHz";
		expected[0][3] = "3.8 GHz";
		expected[0][4] = "95.0";
		expected[0][5] = "Radeon R7 (on-die)";
		expected[0][6] = "No";
		expected[0][7] = Integer.toString(900);
		expected[0][8] = Integer.toString(1);
		String[][] sortedList = cpuController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][9];
		for (int i = 0; i < 9; i++)
			result[0][i] = sortedList[0][i];
		assertArrayEquals(expected, result);
	}

	@Test
	public void test_getRequired1() {
		CPU expected = new CPU("AMD A6-9500", 2, "3.5 GHz", "3.8 GHz", "65.0", "Radeon R5 (on die)", "No", 325, 6);
		CPU result = CPUController.getRequired("No Preference", 325);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired2() {
		CPU expected = new CPU("Intel Xeon E5-2650", 8, "2 GHz", "2.8 GHz", "95.0", "None", "Yes", 460, 88);
		CPU result = CPUController.getRequired("Intel", 460);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired3() {
		CPU result = CPUController.getRequired("Field", 0);
		assertNull("Result is null", result);
	}

}
