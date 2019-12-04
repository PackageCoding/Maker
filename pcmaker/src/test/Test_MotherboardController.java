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

import backend.Motherboard;
import backend.MotherboardController;
import backend.Controller;

public class Test_MotherboardController {
	
	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}
	
	@Test
	public void test_searchById1() {
		Motherboard expected = new Motherboard("ASRock B365M-HDV", "LGA1151", "Micro ATX", 2, "32 GB", "Black / Silver",
				514, 204);
		Motherboard result = MotherboardController.searchById(204);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		Motherboard result = MotherboardController.searchById(301);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB",
				"Black / Red", 670, 202));
		expected.add(
				new Motherboard("ASRock B365M Pro4", "LGA1151", "Micro ATX", 4, "64 GB", "Black / Silver", 584, 203));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("MSI Z390-A PRO", "LGA1151", "ATX", 4, "128 GB", "Brown / Black", 857, 300));
		expected.add(new Motherboard("MSI X570-A PRO", "AM4", "ATX", 4, "128 GB", "Black / Silver", 1169, 299));
		expected.add(new Motherboard("MSI X470 GAMING PRO", "AM4", "ATX", 4, "64 GB", "Black / Red", 973, 298));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSocket_Cpu1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("Asus M5A78L-M PLUS/USB3", "AM3+", "Micro ATX", 4, "32 GB", "Black / Blue", 467, 221));
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("ASRock B450 Pro4", "AM4", "ATX", 4, "64 GB", "Black / Silver", 623, 205));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Socket / CPU", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListSocket_Cpu2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("Asus ROG RAMPAGE VI EXTREME OMEGA", "LGA2066", "EATX", 8, "128 GB", "Black", 6005,
				237));
		expected.add(new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB",
				"Black / Red", 670, 202));
		expected.add(
				new Motherboard("ASRock B365M Pro4", "LGA1151", "Micro ATX", 4, "64 GB", "Black / Silver", 584, 203));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Socket / CPU", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("ASRock B450 Pro4", "AM4",	"ATX", 4, "64 GB", "Black / Silver", 623, 205));
		expected.add(new Motherboard("ASRock B450 Steel Legend", "AM4", "ATX", 4, "64 GB", "Black / Silver", 826, 206));
		expected.add(new Motherboard("ASRock X370 KILLER SLI/ac", "AM4", "ATX",	4, "64 GB",	"Black / White", 897, 213));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Form Factor", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("ASRock Fatal1ty B450 Gaming-ITX/ac", "AM4", "Mini ITX", 2, "32 GB", "Black / Silver", 935, 212));
		expected.add(new Motherboard("ASRock Z390M-ITX/ac", "LGA1151", "Mini ITX", 2, "64 GB", "Black / Silver", 1150, 220));
		expected.add(new Motherboard("Asus ROG STRIX B360-I GAMING", "LGA1151", "Mini ITX",	2, "32 GB",	"Black / Silver", 1681, 238));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Form Factor", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListRamSlots1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("ASRock B365M-HDV", "LGA1151",	"Micro ATX", 2,	"32 GB", "Black / Silver", 514,	204));
		expected.add(new Motherboard("ASRock B450M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 498,	211));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("RAM Slots", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListRamSlots2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("Asus ROG RAMPAGE VI EXTREME OMEGA", "LGA2066", "EATX", 8,	"128 GB", "Black", 6005, 237));
		expected.add(new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB",
				"Black / Red", 670, 202));
		expected.add(
				new Motherboard("ASRock B365M Pro4", "LGA1151", "Micro ATX", 4, "64 GB", "Black / Silver", 584, 203));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("RAM Slots", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedMaxRam1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("ASRock B365M-HDV", "LGA1151", "Micro ATX", 2, "32 GB", "Black / Silver", 514, 204));
		expected.add(new Motherboard("ASRock B450M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 498, 211));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Max RAM", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedMaxRam2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB",
				"Black / Red", 670, 202));
		expected.add(new Motherboard("ASRock X570 Phantom Gaming 4", "AM4", "ATX", 4, "128 GB", "Black / Silver", 1052, 215));
		expected.add(new Motherboard("ASRock X570 Steel Legend", "AM4", "ATX", 4, "128 GB", "Black / Silver", 1325, 216));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Max RAM", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("ASRock B450M/AC", "AM4", "Micro ATX",	4, "64 GB",	"Black", 662, 210));
		expected.add(new Motherboard("Asus ROG Crosshair VII Hero (Wi-Fi)",	"AM4", "ATX", 4, "64 GB", "Black", 2027, 231));
		expected.add(new Motherboard("Asus ROG Crosshair VIII Hero (WI-FI)", "AM4", "ATX", 4, "64 GB", "Black",	2831, 232));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Color", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("Asus PRIME Z390-A", "LGA1151", "ATX",	4, "128 GB", "Silver / Black", 1403, 230));
		expected.add(new Motherboard("Gigabyte B360M DS3H", "LGA1151", "Micro ATX",	4, "64 GB",	"Silver / Black", 685, 254));
		expected.add(new Motherboard("MSI B450 Gaming Plus", "AM4",	"ATX", 4, "64 GB", "Red / Black", 755, 276));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Color", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("Gigabyte GA-A320M-S2H", "AM4", "Micro ATX", 2, "32 GB", "Black", 452, 260));
		expected.add(new Motherboard("Asus M5A78L-M PLUS/USB3", "AM3+", "Micro ATX", 4,	"32 GB", "Black / Blue", 467, 221));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(new Motherboard("Asus ROG RAMPAGE VI EXTREME OMEGA", "LGA2066", "EATX", 8, "128 GB", "Black", 6005, 237));
		expected.add(new Motherboard("Gigabyte X570 AORUS XTREME", "AM4", "EATX", 4, "128 GB", "Black / Silver", 5491, 266));
		expected.add(new Motherboard("Asus ROG MAXIMUS XI EXTREME",	"LGA1151", "EATX", 4, "128 GB", "Black", 4336, 233));
		ArrayList<Motherboard> sortedList = MotherboardController.getSortedList("Name", "Ascending");
		sortedList = MotherboardController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<Motherboard> expected = new ArrayList<>();
		expected.add(
				new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201));
		expected.add(new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB",
				"Black / Red", 670, 202));
		expected.add(
				new Motherboard("ASRock B365M Pro4", "LGA1151", "Micro ATX", 4, "64 GB", "Black / Silver", 584, 203));
		ArrayList<Motherboard> result = MotherboardController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		MotherboardController motherboardController = (MotherboardController) MotherboardController.getInstance();
		String[][] expected = new String[1][8];
		expected[0][0] = "ASRock A320M-HDV R4.0";
		expected[0][1] = "AM4";
		expected[0][2] = "Micro ATX";
		expected[0][3] = Integer.toString(2);
		expected[0][4] = "32 GB";
		expected[0][5] = "Black / White";
		expected[0][6] = Integer.toString(428);
		expected[0][7] = Integer.toString(201);
		String[][] sortedList = motherboardController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][8];
		for (int i = 0; i < 8; i++)
			result[0][i] = sortedList[0][i];
		assertArrayEquals(expected, result);
	}

	 @Test
	 public void test_getRequired1() {
	 Motherboard expected = new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX", 2, "32 GB", "Black / White", 428, 201);
	 Motherboard result = MotherboardController.getRequired("No Preference", 4, 428);
	 assertEquals(true, expected.equals(result));
	 }
	
	 @Test
	 public void test_getRequired2() {
		 Motherboard expected = new Motherboard("MSI H310M PRO-VDH PLUS", "LGA1151", "Micro ATX", 2, "32 GB", "Black", 506, 286);
		 Motherboard result = MotherboardController.getRequired("Intel", 4, 506);
		 assertEquals(true, expected.equals(result));
	 }
	 
	 @Test
	 public void test_getRequired3() {
		 Motherboard expected = new Motherboard("Asus ROG RAMPAGE VI EXTREME OMEGA", "LGA2066", "EATX", 8, "128 GB", "Black", 6005, 237);
		 Motherboard result = MotherboardController.getRequired("Intel", 8, 6005);
		 assertEquals(true, expected.equals(result));
	 }
	 
	 @Test
	 public void test_getRequired4() {
		 Motherboard expected = new Motherboard("Gigabyte GA-A320M-S2H", "AM4", "Micro ATX", 2, "32 GB", "Black", 452, 260);
		 Motherboard result = MotherboardController.getRequired("AMD", 16, 452);
		 assertEquals(true, expected.equals(result));
	 }
	 
	 @Test
	 public void test_getRequired5() {
		 Motherboard result = MotherboardController.getRequired("No Preference", 8, 0);
		 assertNull("Result is null", result);
	 }
}
