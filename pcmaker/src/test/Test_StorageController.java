package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Storage;
import backend.StorageController;
import backend.Controller;

public class Test_StorageController {

	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}

	@Test
	public void test_searchById1() {
		Storage expected = new Storage("Hitachi Deskstar 5K3000", "2 TB", "5400 RPM", "32 MB", "3.5\"", "SATA 6 Gb/s",
				2106, 404);
		Storage result = StorageController.searchById(404);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		Storage result = StorageController.searchById(501);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Gigabyte UD PRO", "256 GB", "SSD", "256 MB", "2.5\"", "SATA 6 Gb/s", 272, 402));
		expected.add(new Storage("Hitachi Deskstar", "1 TB", "7200 RPM", "32 MB", "3.5\"", "SATA 3 Gb/s", 374, 403));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Western Digital WD3001FAEX", "3 TB", "7200 RPM", "64 MB", "3.5\"", "SATA 6 Gb/s",
				1247, 500));
		expected.add(new Storage("Western Digital WD VelociRaptor", "1 TB", "10000 RPM", "64 MB", "2.5\"",
				"SATA 6 Gb/s", 1013, 499));
		expected.add(
				new Storage("Western Digital WD SE", "3 TB", "7200 RPM", "64 MB", "3.5\"", "SATA 6 Gb/s", 1053, 498));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCapacity1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Patriot Blaze", "120 GB", "SSD", "32 MB", "2.5\"", "SATA 6 Gb/s", 1739, 414));
		expected.add(new Storage("Seagate Barracuda 7200.10", "160 GB", "7200 RPM", "8 MB", "3.5\"", "SATA 3 Gb/s", 552,
				429));
		expected.add(new Storage("Seagate Constellation.2", "250 GB", "7200 RPM", "64 MB", "2.5\"", "SATA 6 Gb/s", 462,
				439));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Capacity", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCapacity2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Seagate IronWolf", "12 TB", "7200 RPM", "256 MB", "3.5\"", "SATA 6 Gb/s", 2579, 441));
		expected.add(
				new Storage("Seagate BarraCuda Pro", "8 TB", "7200 RPM", "256 MB", "3.5\"", "SATA 6 Gb/s", 2382, 434));
		expected.add(
				new Storage("Hitachi Deskstar NAS", "6 TB", "7200 RPM", "128 MB", "3.5\"", "SATA 6 Gb/s", 9405, 407));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Capacity", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListType1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(
				new Storage("Hitachi Deskstar 5K3000", "2 TB", "5400 RPM", "32 MB", "3.5\"", "SATA 6 Gb/s", 2106, 404));
		expected.add(
				new Storage("Hitachi Travelstar 5K1000", "1 TB", "5400 RPM", "8 MB", "2.5\"", "SATA 6 Gb/s", 413, 410));
		expected.add(new Storage("Samsung Spinpoint M8", "1 TB", "5400 RPM", "8 MB", "2.5\"", "SATA 3 Gb/s", 407, 427));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Type", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListType2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Gigabyte UD PRO", "256 GB", "SSD", "256 MB", "2.5\"", "SATA 6 Gb/s", 272, 402));
		expected.add(new Storage("HP EX920", "1 TB", "SSD", "1024 MB", "M.2-2280", "M.2 (M)", 896, 413));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Type", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCache1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(
				new Storage("Hitachi Travelstar 5K1000", "1 TB", "5400 RPM", "8 MB", "2.5\"", "SATA 6 Gb/s", 413, 410));
		expected.add(new Storage("Samsung Spinpoint M8", "1 TB", "5400 RPM", "8 MB", "2.5\"", "SATA 3 Gb/s", 407, 427));
		expected.add(new Storage("Seagate Barracuda 7200.10", "160 GB", "7200 RPM", "8 MB", "3.5\"", "SATA 3 Gb/s", 552,
				429));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Cache", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCache2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Samsung 860 Evo", "4 TB", "SSD", "4096 MB", "2.5\"", "SATA 6 Gb/s", 4523, 417));
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Samsung 960 Pro", "2 TB", "SSD", "2048 MB", "M.2-2280", "M.2 (M)", 10139, 420));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Cache", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Gigabyte UD PRO", "256 GB", "SSD", "256 MB", "2.5\"", "SATA 6 Gb/s", 272, 402));
		expected.add(
				new Storage("Hitachi Travelstar", "500 GB", "7200 RPM", "16 MB", "2.5\"", "SATA 3 Gb/s", 803, 409));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Form Factor", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("HP EX920", "1 TB", "SSD", "1024 MB", "M.2-2280", "M.2 (M)", 896, 413));
		expected.add(new Storage("Plextor M8Pe", "256 GB", "SSD", "512 MB", "M.2-2280", "M.2 (M)", 1656, 415));
		expected.add(new Storage("Samsung 960 EVO", "500 GB", "SSD", "512 MB", "M.2-2280", "M.2 (M)", 1372, 419));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Form Factor", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListInterface1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("HP EX920", "1 TB", "SSD", "1024 MB", "M.2-2280", "M.2 (M)", 896, 413));
		expected.add(new Storage("Plextor M8Pe", "256 GB", "SSD", "512 MB", "M.2-2280", "M.2 (M)", 1656, 415));
		expected.add(new Storage("Samsung 960 EVO", "500 GB", "SSD", "512 MB", "M.2-2280", "M.2 (M)", 1372, 419));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Interface", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListInterface2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Gigabyte UD PRO", "256 GB", "SSD", "256 MB", "2.5\"", "SATA 6 Gb/s", 272, 402));
		expected.add(
				new Storage("Hitachi Deskstar 5K3000", "2 TB", "5400 RPM", "32 MB", "3.5\"", "SATA 6 Gb/s", 2106, 404));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Interface", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Toshiba MQ01ABD050", "500 GB", "5400 RPM", "8 MB", "2.5\"", "SATA 3 Gb/s", 201, 466));
		expected.add(new Storage("Seagate Barracuda", "320 GB", "7200 RPM", "16 MB", "3.5\"", "SATA 6 Gb/s", 210, 428));
		expected.add(new Storage("Seagate Momentus 7200.4", "500 GB", "7200 RPM", "16 MB", "2.5\"", "SATA 3 Gb/s", 218,
				446));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Samsung 960 Pro", "2 TB", "SSD", "2048 MB", "M.2-2280", "M.2 (M)", 10139, 420));
		expected.add(
				new Storage("Hitachi Deskstar NAS", "6 TB", "7200 RPM", "128 MB", "3.5\"", "SATA 6 Gb/s", 9405, 407));
		expected.add(new Storage("Samsung 860 Evo", "4 TB", "SSD", "4096 MB", "2.5\"", "SATA 6 Gb/s", 4523, 417));
		ArrayList<Storage> sortedList = StorageController.getSortedList("Name", "Ascending");
		sortedList = StorageController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<Storage> expected = new ArrayList<>();
		expected.add(new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401));
		expected.add(new Storage("Gigabyte UD PRO", "256 GB", "SSD", "256 MB", "2.5\"", "SATA 6 Gb/s", 272, 402));
		expected.add(new Storage("Hitachi Deskstar", "1 TB", "7200 RPM", "32 MB", "3.5\"", "SATA 3 Gb/s", 374, 403));
		ArrayList<Storage> result = StorageController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		StorageController storageController = (StorageController) StorageController.getInstance();
		String[][] expected = new String[1][8];
		expected[0][0] = "Crucial MX500";
		expected[0][1] = "2 TB";
		expected[0][2] = "SSD";
		expected[0][3] = "2048 MB";
		expected[0][4] = "2.5\"";
		expected[0][5] = "SATA 6 Gb/s";
		expected[0][6] = Integer.toString(1742);
		expected[0][7] = Integer.toString(401);
		String[][] sortedList = storageController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][8];
		for (int i = 0; i < 8; i++)
			result[0][i] = sortedList[0][i];
		assertArrayEquals(expected, result);
	}

	@Test
	public void test_getRequired1() {
		Storage expected = new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401);
		Storage result = StorageController.getRequired(1742);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired2() {
		Storage result = StorageController.getRequired(0);
		assertNull("Result is null", result);
	}

}
