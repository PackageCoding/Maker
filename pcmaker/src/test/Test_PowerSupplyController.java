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

import backend.PowerSupply;
import backend.PowerSupplyController;
import backend.Controller;

public class Test_PowerSupplyController {

	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}

	@Test
	public void test_searchById1() {
		PowerSupply expected = new PowerSupply("Asus ROG-THOR-1200P", "ATX", "80+ Platinum", "1200.0", "Full", 2261, 304);
		PowerSupply result = PowerSupplyController.searchById(304);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		PowerSupply result = PowerSupplyController.searchById(401);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Antec Earthwatts Gold Pro", "ATX", "80+ Gold", "650.0", "Semi", 740, 301));
		expected.add(new PowerSupply("Antec High Current Gamer", "ATX", "80+ Bronze", "850.0", "Full", 670, 302));
		expected.add(new PowerSupply("Apevia AD", "ATX", "80+ Bronze", "500.0", "No", 194, 303));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Thermaltake Toughpower iRGB PLUS Platinum", "ATX", "80+ Platinum", "1000.0", "Full", 1799, 400));
		expected.add(new PowerSupply("Thermaltake Toughpower iRGB PLUS", "ATX",	"80+ Titanium",	"1250.0",	"Full",	3509, 399));
		expected.add(new PowerSupply("Thermaltake Toughpower Grand RGB Sync Edition", "ATX", "80+ Gold", "650.0",	"Full",	748, 398));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Antec Earthwatts Gold Pro", "ATX", "80+ Gold", "650.0", "Semi", 740, 301));
		expected.add(new PowerSupply("Antec High Current Gamer", "ATX", "80+ Bronze", "850.0", "Full", 670, 302));
		expected.add(new PowerSupply("Apevia AD", "ATX", "80+ Bronze", "500.0", "No", 194, 303));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Form Factor", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListFormFactor2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Corsair SF", "SFX", "80+ Platinum", "750.0", "Full", 1403, 336));
		expected.add(new PowerSupply("SeaSonic FOCUS SGX", "SFX", "80+ Gold", "650.0", "Full", 967, 376));
		expected.add(new PowerSupply("Silverstone SFX",	"SFX", "80+ Titanium", "800.0",	"Full",	1645, 384));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Form Factor", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListEfficiencyRating1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Cooler Master MasterWatt Lite Full Range", "ATX", "80+", "600.0", "No", 538, 313));
		expected.add(new PowerSupply("EVGA 100-W1-0430-KR", "ATX", "80+", "430.0", "No", 701, 340));
		expected.add(new PowerSupply("EVGA 100-W1-0500-KR", "ATX", "80+", "500.0", "No", 350, 341));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Efficiency Rating", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedEfficiencyRating2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Corsair AX", "ATX", "80+ Titanium", "1000.0",	"Full",	1871, 318));
		expected.add(new PowerSupply("EVGA SuperNOVA T2", "ATX",	"80+ Titanium",	"1600.0", "Full", 3103, 357));
		expected.add(new PowerSupply("SeaSonic PRIME Ultra Titanium", "ATX", "80+ Titanium", "1000.0", "Full", 2152, 382));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Efficiency Rating", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListWattage1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Silverstone ST30SF", "SFX", "80+ Bronze", "300.0", "No", 483,	387));
		expected.add(new PowerSupply("Silverstone SST-FX350-G", "Flex ATX", "80+ Gold", "350.0", "No", 662, 385));
		expected.add(new PowerSupply("be quiet! Pure Power 11", "ATX", "80+ Gold", "400.0", "No", 998, 307));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Wattage", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListWattage2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("EVGA SuperNOVA P2", "ATX", "80+ Platinum", "1600.0", "Full", 3104, 356));
		expected.add(new PowerSupply("EVGA SuperNOVA T2", "ATX", "80+ Titanium", "1600.0", "Full", 3103, 357));
		expected.add(new PowerSupply("Thermaltake Toughpower DPS G RGB Titanium", "ATX", "80+ Titanium", "1500.0", "Full", 3091, 396));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Wattage", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedModular1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Antec High Current Gamer", "ATX", "80+ Bronze", "850.0", "Full", 670, 302));
		expected.add(new PowerSupply("Asus ROG-THOR-1200P",	"ATX", "80+ Platinum", "1200.0", "Full", 2261, 304));
		expected.add(new PowerSupply("Asus ROG-THOR-850P", "ATX", "80+ Platinum", "850.0", "Full", 1594, 305));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Modular", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedModular2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Antec Earthwatts Gold Pro", "ATX", "80+ Gold", "650.0", "Semi", 740, 301));
		expected.add(new PowerSupply("be quiet! DARK POWER PRO 11", "ATX", "80+ Platinum", "850.0", "Semi",	1403, 306));
		expected.add(new PowerSupply("Cooler Master MasterWatt", "ATX", "80+ Bronze", "750.0", "Semi", 705, 312));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Modular", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Apevia AD", "ATX", "80+ Bronze", "500.0", "No", 194, 303));
		expected.add(new PowerSupply("EVGA 100-W1-0500-KR",	"ATX", "80+", "500.0", "No", 350, 341));
		expected.add(new PowerSupply("Rosewill Glacier 500M", "ATX", "80+ Bronze", "500.0",	"Semi", 350, 368));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Cooler Master Silent Pro Gold", "ATX", "80+ Gold", "1200.0", "Semi", 21190, 316));
		expected.add(new PowerSupply("FSP Group TWINS700", "ATX", "80+ Gold", "700.0", "No", 4133, 360));
		expected.add(new PowerSupply("Thermaltake Toughpower iRGB PLUS", "ATX", "80+ Titanium", "1250.0", "Full", 3509, 399));
		ArrayList<PowerSupply> sortedList = PowerSupplyController.getSortedList("Name", "Ascending");
		sortedList = PowerSupplyController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<PowerSupply> expected = new ArrayList<>();
		expected.add(new PowerSupply("Antec Earthwatts Gold Pro", "ATX", "80+ Gold", "650.0", "Semi", 740, 301));
		expected.add(new PowerSupply("Antec High Current Gamer", "ATX", "80+ Bronze", "850.0", "Full", 670, 302));
		expected.add(new PowerSupply("Apevia AD", "ATX", "80+ Bronze", "500.0", "No", 194, 303));
		ArrayList<PowerSupply> result = PowerSupplyController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		PowerSupplyController powerSupplyController = (PowerSupplyController) PowerSupplyController.getInstance();
		String[][] expected = new String[1][7];
		expected[0][0] = "Antec Earthwatts Gold Pro";
		expected[0][1] = "ATX";
		expected[0][2] = "80+ Gold";
		expected[0][3] = "650.0";
		expected[0][4] = "Semi";
		expected[0][5] = Integer.toString(740);
		expected[0][6] = Integer.toString(301);
		String[][] sortedList = powerSupplyController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][7];
		for (int i = 0; i < 7; i++)
			result[0][i] = sortedList[0][i];
		assertArrayEquals(expected, result);
	}

	@Test
	public void test_getRequired1() {
		PowerSupply expected = new PowerSupply("Silverstone ST30SF", "SFX",	"80+ Bronze", "300.0", "No", 483, 387);
		PowerSupply result = PowerSupplyController.getRequired(300.0, 483);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired2() {
		PowerSupply result = PowerSupplyController.getRequired(0.0, 0);
		assertNull("Result is null", result);
	}
}
