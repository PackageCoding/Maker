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

import backend.Memory;
import backend.MemoryController;
import backend.Controller;

public class Test_MemoryController {
	
	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}
	
	@Test
	public void test_searchById1() {
		Memory expected = new Memory("Corsair CMV8GX4M1A2133C15 8 GB", "DDR4-2133", "288-pin DIMM", "1 x 8GB", "Black",
				15, 288, 104);
		Memory result = MemoryController.searchById(104);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		Memory result = MemoryController.searchById(201);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9, 873,
				101));
		expected.add(new Memory("ADATA XPG GAMMIX D10 16 GB", "DDR4-2666", "288-pin DIMM", "2 x 8GB", "Red / White", 16,
				1271, 102));
		expected.add(new Memory("ADATA XPG V1.0 8 GB", "DDR3-1600", "240-pin DIMM", "1 x 8GB", "Black / Silver", 9, 613,
				103));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Team T-FORCE VULCAN TUF Gaming Allian 16 GB", "DDR4-3200", "288-pin DIMM", "2 x 8GB",
				"Gold / Black", 16, 545, 200));
		expected.add(new Memory("Team T-Force Delta RGB 8 GB", "DDR4-3000", "288-pin DIMM", "2 x 4GB", "Black", 16, 366,
				199));
		expected.add(new Memory("Team Dark Pro 16 GB", "DDR4-3200", "288-pin DIMM", "2 x 8GB", "Black", 14, 935, 198));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSpeed1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Corsair XMS3 16 GB", "DDR3-1333", "240-pin DIMM", "4 x 4GB", "Black / Silver", 9, 592,
				119));
		expected.add(new Memory("Crucial CT2KIT25664BA1339 4 GB", "DDR3-1333", "240-pin DIMM", "2 x 2GB", "Green", 9,
				206, 133));
		expected.add(
				new Memory("G.Skill Value Series 8 GB", "DDR3-1333", "240-pin DIMM", "2 x 4GB", "Green", 9, 280, 170));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Speed", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSpeed2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("G.Skill Trident Z RGB 16 GB", "DDR4-3600", "288-pin DIMM", "2 x 8GB", "Black", 17,
				1052, 168));
		expected.add(new Memory("Corsair Vengeance LPX 8 GB", "DDR4-3200", "288-pin DIMM", "2 x 4GB", "Black / Yellow",
				16, 2172, 113));
		expected.add(new Memory("Corsair Vengeance RGB 16 GB", "DDR4-3200", "288-pin DIMM", "2 x 8GB", "Black", 16,
				2097, 116));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Speed", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListType1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9, 873,
				101));
		expected.add(new Memory("ADATA XPG V1.0 8 GB", "DDR3-1600", "240-pin DIMM", "1 x 8GB", "Black / Silver", 9, 613,
				103));
		expected.add(new Memory("Corsair Dominator Platinum 8 GB", "DDR3-1866", "240-pin DIMM", "2 x 4GB",
				"Black / Silver", 9, 1715, 107));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Type", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListType2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG GAMMIX D10 16 GB", "DDR4-2666", "288-pin DIMM", "2 x 8GB", "Red / White", 16,
				1271, 102));
		expected.add(new Memory("Corsair CMV8GX4M1A2133C15 8 GB", "DDR4-2133", "288-pin DIMM", "1 x 8GB", "Black", 15,
				288, 104));
		expected.add(new Memory("Corsair Dominator Platinum 16 GB", "DDR4-2666", "288-pin DIMM", "2 x 8GB",
				"Black / Silver", 15, 748, 105));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Type", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListModules1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(
				new Memory("Corsair XMS3 4 GB", "DDR3-1600", "240-pin DIMM", "1 x 4GB", "Black / White", 11, 194, 120));
		expected.add(new Memory("Crucial Ballistix Sport LT 4 GB", "DDR4-2400", "288-pin DIMM", "1 x 4GB", "Silver", 16,
				147, 126));
		expected.add(new Memory("Crucial CT2KIT25664BA1339 4 GB", "DDR3-1333", "240-pin DIMM", "2 x 2GB", "Green", 9,
				206, 133));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Modules", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListModules2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Corsair Dominator Platinum 32 GB", "DDR4-3000", "288-pin DIMM", "2 x 16GB",
				"Black / Silver", 15, 1364, 106));
		expected.add(new Memory("Corsair Vengeance LPX 32 GB", "DDR4-3000", "288-pin DIMM", "2 x 16GB",
				"Black / Yellow", 15, 1208, 112));
		expected.add(new Memory("Corsair Vengeance RGB Pro 32 GB", "DDR4-3200", "288-pin DIMM", "4 x 8GB", "White", 16,
				1505, 118));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Modules", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9, 873,
				101));
		expected.add(new Memory("Corsair CMV8GX4M1A2133C15 8 GB", "DDR4-2133", "288-pin DIMM", "1 x 8GB", "Black", 15,
				288, 104));
		expected.add(new Memory("Corsair Vengeance RGB 16 GB", "DDR4-3200", "288-pin DIMM", "2 x 8GB", "Black", 16,
				2097, 116));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Color", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Crucial Sport LT 8 GB", "DDR4-2666", "288-pin DIMM", "1 x 8GB", "White / Silver", 16,
				924, 137));
		expected.add(new Memory("Kingston HyperX Fury White 16 GB", "DDR3-1600", "240-pin DIMM", "2 x 8GB",
				"White / Silver", 10, 696, 186));
		expected.add(new Memory("Kingston HyperX Fury White 8 GB", "DDR3-1866", "240-pin DIMM", "1 x 8GB",
				"White / Silver", 10, 350, 187));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Color", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCasLatency1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9, 873,
				101));
		expected.add(new Memory("ADATA XPG V1.0 8 GB", "DDR3-1600", "240-pin DIMM", "1 x 8GB", "Black / Silver", 9, 613,
				103));
		expected.add(new Memory("Corsair Dominator Platinum 8 GB", "DDR3-1866", "240-pin DIMM", "2 x 4GB",
				"Black / Silver", 9, 1715, 107));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("CAS Latency", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCasLatency2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Kingston HyperX Fury 8 GB", "DDR4-3200", "288-pin DIMM", "1 x 8GB",
				"Black / Dark Silver", 18, 452, 180));
		expected.add(
				new Memory("Crucial CT8G4DFD824A 8 GB", "DDR4-2400", "288-pin DIMM", "1 x 8GB", "Green", 17, 264, 135));
		expected.add(new Memory("G.Skill Trident Z RGB 16 GB", "DDR4-3600", "288-pin DIMM", "2 x 8GB", "Black", 17,
				1052, 168));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("CAS Latency", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Crucial Ballistix Sport LT 4 GB", "DDR4-2400", "288-pin DIMM", "1 x 4GB", "Silver", 16,
				147, 126));
		expected.add(new Memory("G.Skill F3-12800CL9D-4GBNQ 4 GB", "DDR3-1600", "240-pin DIMM", "2 x 2GB",
				"Red / Silver", 9, 187, 142));
		expected.add(new Memory("Kingston HyperX Fury Red 4 GB", "DDR3-1866", "240-pin DIMM", "1 x 4GB", "Red / Silver",
				10, 187, 184));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("Corsair Vengeance LPX 16 GB", "DDR4-3000", "288-pin DIMM", "4 x 4GB", "Black / Yellow",
				15, 3216, 111));
		expected.add(new Memory("G.Skill Trident Z RGB 32 GB", "DDR4-3200", "288-pin DIMM", "4 x 8GB", "Black", 14,
				2985, 169));
		expected.add(new Memory("Samsung MV-3V4G3D/US 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 11, 2389,
				197));
		ArrayList<Memory> sortedList = MemoryController.getSortedList("Name", "Ascending");
		sortedList = MemoryController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<Memory> expected = new ArrayList<>();
		expected.add(new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9, 873,
				101));
		expected.add(new Memory("ADATA XPG GAMMIX D10 16 GB", "DDR4-2666", "288-pin DIMM", "2 x 8GB", "Red / White", 16,
				1271, 102));
		expected.add(new Memory("ADATA XPG V1.0 8 GB", "DDR3-1600", "240-pin DIMM", "1 x 8GB", "Black / Silver", 9, 613,
				103));
		ArrayList<Memory> result = MemoryController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		MemoryController memoryController = (MemoryController) MemoryController.getInstance();
		String[][] expected = new String[1][8];
		expected[0][0] = "ADATA XPG Gaming Series 8 GB";
		expected[0][1] = "DDR3-1600";
		expected[0][2] = "240-pin DIMM";
		expected[0][3] = "2 x 4GB";
		expected[0][4] = "Black";
		expected[0][5] = Integer.toString(9);
		expected[0][6] = Integer.toString(873);
		expected[0][7] = Integer.toString(101);
		String[][] sortedList = memoryController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][8];
		for (int i = 0; i < 8; i++)
			result[0][i] = sortedList[0][i];
		assertArrayEquals(expected, result);
	}

	@Test
	public void test_getRequired1() {
		Memory expected = new Memory("Crucial Ballistix Sport LT 4 GB", "DDR4-2400", "288-pin DIMM", "1 x 4GB",
				"Silver", 16, 147, 126);
		Memory result = MemoryController.getRequired(147);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired2() {
		Memory result = MemoryController.getRequired(0);
		assertNull("Result is null", result);
	}
}
