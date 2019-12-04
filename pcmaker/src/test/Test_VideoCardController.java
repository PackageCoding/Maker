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

import backend.VideoCard;
import backend.VideoCardController;
import backend.Controller;

public class Test_VideoCardController {

	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
	}

	@Test
	public void test_searchById1() {
		VideoCard expected = new VideoCard("Asus Phoenix", "GeForce GTX 1050 Ti", "4 GB", "1290 MHz", "1392 MHz",
				"PCIe x16", "Black / White", 896, 504, "75.0");
		VideoCard result = VideoCardController.searchById(504);
		assertTrue("Result is true", expected.equals(result));
	}

	@Test
	public void test_searchById2() {
		VideoCard result = VideoCardController.searchById(601);
		assertNull("Result is null", result);
	}

	@Test
	public void test_getSortedListName1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus DUAL", "Radeon RX 580", "8 GB", "1257 MHz", "1380 MHz", "PCIe x16",
				"Black / Silver", 2573, 501, "185.0"));
		expected.add(new VideoCard("Asus DUAL OC", "GeForce RTX 2060", "6 GB", "1365 MHz", "1785 MHz", "PCIe x16",
				"Black / Silver", 2963, 502, "160.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListName2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Zotac ZT-P10620A-10M", "GeForce GTX 1060 6GB", "6 GB", "1506 MHz", "1708 MHz",
				"PCIe x16", "Black", 1637, 600, "120.0"));
		expected.add(new VideoCard("Zotac OC Edition", "GeForce GTX 1050 Ti", "4 GB", "1392 MHz", "1506 MHz",
				"PCIe x16", "Black / White", 1731, 599, "75.0"));
		expected.add(new VideoCard("Zotac Mini", "GeForce GTX 1080 Ti", "11 GB", "1506 MHz", "1620 MHz", "PCIe x16",
				"Black", 10912, 598, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Name", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListChipset1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Gigabyte Silent Low Profile", "GeForce GT 1030", "2 GB", "1252 MHz", "1506 MHz",
				"PCIe x16", "White", 686, 556, "30.0"));
		expected.add(new VideoCard("EVGA Dual Superclocked ACX", "GeForce GTX 760", "2 GB", "1072 MHz", "1137 MHz",
				"PCIe x16", "Black / Silver", 2496, 518, "170.0"));
		expected.add(new VideoCard("EVGA Dual Classified ACX", "GeForce GTX 780 Ti", "3 GB", "1020 MHz", "1085 MHz",
				"PCIe x16", "Black / Silver", 3510, 517, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Chipset", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListChipset2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("XFX RX-VEGMA3FD6", "Radeon VII", "16 GB", "1400 MHz", "1801 MHz", "PCIe x16",
				"Silver", 9359, 592, "295.0"));
		expected.add(new VideoCard("Sapphire PULSE", "Radeon RX VEGA 56", "8 GB", "1208 MHz", "1512 MHz", "PCIe x16",
				"Black / Red", 3763, 588, "210.0"));
		expected.add(new VideoCard("Gigabyte GAMING OC", "Radeon RX 5700 XT", "8 GB", "1650 MHz", "1905 MHz",
				"PCIe x16", "Black", 3268, 552, "225.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Chipset", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListMemory1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("EVGA ACX 2.0", "GeForce GTX 1050", "2 GB", "1354 MHz", "1455 MHz", "PCIe x16",
				"Black", 2333, 515, "75.0"));
		expected.add(new VideoCard("EVGA Dual Superclocked ACX", "GeForce GTX 760", "2 GB", "1072 MHz", "1137 MHz",
				"PCIe x16", "Black / Silver", 2496, 518, "170.0"));
		expected.add(new VideoCard("Gigabyte OC", "GeForce GTX 1050", "2 GB", "1379 MHz", "1518 MHz", "PCIe x16",
				"Black / Orange", 1677, 555, "75.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Memory", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListMemory2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("XFX RX-VEGMA3FD6", "Radeon VII", "16 GB", "1400 MHz", "1801 MHz", "PCIe x16",
				"Silver", 9359, 592, "295.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		expected.add(new VideoCard("Asus ROG Strix Gaming OC", "GeForce RTX 2080 Ti", "11 GB", "1350 MHz", "1665 MHz",
				"PCIe x16", "Black", 9983, 506, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Memory", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreClock1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("EVGA 06G-P4-4990-KR", "GeForce GTX 980 Ti", "6 GB", "1000 MHz", "1076 MHz",
				"PCIe x16", "Black / Silver", 4672, 514, "250.0"));
		expected.add(new VideoCard("EVGA Dual Classified ACX", "GeForce GTX 780 Ti", "3 GB", "1020 MHz", "1085 MHz",
				"PCIe x16", "Black / Silver", 3510, 517, "250.0"));
		expected.add(new VideoCard("MSI R9 390X GAMING 8G", "Radeon R9 390X", "8 GB", "1050 MHz", "1100 MHz",
				"PCIe x16", "Black / Red", 2620, 579, "275.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Core Clock", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListCoreClock2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("EVGA FTW Hybrid Gaming", "GeForce GTX 1080", "8 GB", "1721 MHz", "1860 MHz",
				"PCIe x16", "Black / Silver", 6395, 526, "180.0"));
		expected.add(new VideoCard("EVGA SC HYBRID GAMING", "GeForce GTX 1070 Ti", "8 GB", "1721 MHz", "1860 MHz",
				"PCIe x16", "Silver / Black", 4562, 535, "180.0"));
		expected.add(new VideoCard("Gigabyte G1 Gaming", "GeForce GTX 1080", "8 GB", "1721 MHz", "1860 MHz", "PCIe x16",
				"Black / Orange", 6045, 549, "180.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Core Clock", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListBoostClock1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("EVGA 06G-P4-4990-KR", "GeForce GTX 980 Ti", "6 GB", "1000 MHz", "1076 MHz",
				"PCIe x16", "Black / Silver", 4672, 514, "250.0"));
		expected.add(new VideoCard("EVGA Dual Classified ACX", "GeForce GTX 780 Ti", "3 GB", "1020 MHz", "1085 MHz",
				"PCIe x16", "Black / Silver", 3510, 517, "250.0"));
		expected.add(new VideoCard("MSI R9 390X GAMING 8G", "Radeon R9 390X", "8 GB", "1050 MHz", "1100 MHz",
				"PCIe x16", "Black / Red", 2620, 579, "275.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Boost Clock", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListBoostClock2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Gigabyte GAMING OC", "Radeon RX 5700 XT", "8 GB", "1650 MHz", "1905 MHz",
				"PCIe x16", "Black", 3268, 552, "225.0"));
		expected.add(new VideoCard("XFX RX-57XT8MFD6", "Radeon RX 5700 XT", "8 GB", "1605 MHz", "1905 MHz", "PCIe x16",
				"Silver", 3119, 591, "225.0"));
		expected.add(new VideoCard("Asus STRIX GAMING OC", "GeForce RTX 2060", "6 GB", "1365 MHz", "1860 MHz",
				"PCIe x16", "Black", 2924, 509, "160.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Boost Clock", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListInterface1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus DUAL", "Radeon RX 580", "8 GB", "1257 MHz", "1380 MHz", "PCIe x16",
				"Black / Silver", 2573, 501, "185.0"));
		expected.add(new VideoCard("Asus DUAL OC", "GeForce RTX 2060", "6 GB", "1365 MHz", "1785 MHz", "PCIe x16",
				"Black / Silver", 2963, 502, "160.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Interface", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListInterface2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus DUAL", "Radeon RX 580", "8 GB", "1257 MHz", "1380 MHz", "PCIe x16",
				"Black / Silver", 2573, 501, "185.0"));
		expected.add(new VideoCard("Asus DUAL OC", "GeForce RTX 2060", "6 GB", "1365 MHz", "1785 MHz", "PCIe x16",
				"Black / Silver", 2963, 502, "160.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Interface", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus ROG STRIX", "Radeon RX 570", "4 GB", "1168 MHz", "1310 MHz", "PCIe x16",
				"Black", 1983, 505, "120.0"));
		expected.add(new VideoCard("Asus ROG Strix Gaming OC", "GeForce RTX 2080 Ti", "11 GB", "1350 MHz", "1665 MHz",
				"PCIe x16", "Black", 9983, 506, "250.0"));
		expected.add(new VideoCard("Asus ROG STRIX TOP", "Radeon RX 580", "8 GB", "1257 MHz", "1431 MHz", "PCIe x16",
				"Black", 2880, 507, "185.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Color", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListColor2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Gigabyte Gaming OC 11G", "GeForce GTX 1080 Ti", "11 GB", "1518 MHz", "1657 MHz",
				"PCIe x16", "White / Orange", 8579, 553, "250.0"));
		expected.add(new VideoCard("EVGA SC2 Gaming iCX", "GeForce GTX 1080", "8 GB", "1708 MHz", "1847 MHz",
				"PCIe x16", "White / Black", 6232, 537, "180.0"));
		expected.add(new VideoCard("Gigabyte Silent Low Profile", "GeForce GT 1030", "2 GB", "1252 MHz", "1506 MHz",
				"PCIe x16", "White", 686, 556, "30.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Color", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Gigabyte Silent Low Profile", "GeForce GT 1030", "2 GB", "1252 MHz", "1506 MHz",
				"PCIe x16", "White", 686, 556, "30.0"));
		expected.add(new VideoCard("Asus Phoenix", "GeForce GTX 1050 Ti", "4 GB", "1290 MHz", "1392 MHz", "PCIe x16",
				"Black / White", 896, 504, "75.0"));
		expected.add(new VideoCard("MSI GTX 1050 Ti 4GT OC", "GeForce GTX 1050 Ti", "4 GB", "1341 MHz", "1455 MHz",
				"PCIe x16", "Black / White", 1169, 571, "75.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Price", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListPrice2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		expected.add(new VideoCard("MSI GTX 1070 GAMING Z 8G", "GeForce GTX 1070", "8 GB", "1657 MHz", "1860 MHz",
				"PCIe x16", "Black / Red", 12042, 573, "150.0"));
		expected.add(new VideoCard("Zotac Mini", "GeForce GTX 1080 Ti", "11 GB", "1506 MHz", "1620 MHz", "PCIe x16",
				"Black", 10912, 598, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("Price", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListTdp1() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Gigabyte Silent Low Profile", "GeForce GT 1030", "2 GB", "1252 MHz", "1506 MHz",
				"PCIe x16", "White", 686, 556, "30.0"));
		expected.add(new VideoCard("Asus Phoenix", "GeForce GTX 1050 Ti", "4 GB", "1290 MHz", "1392 MHz", "PCIe x16",
				"Black / White", 896, 504, "75.0"));
		expected.add(new VideoCard("EVGA ACX 2.0", "GeForce GTX 1050", "2 GB", "1354 MHz", "1455 MHz", "PCIe x16",
				"Black", 2333, 515, "75.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("TDP (W)", "Ascending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListTdp2() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("XFX RX-VEGMA3FD6", "Radeon VII", "16 GB", "1400 MHz", "1801 MHz", "PCIe x16",
				"Silver", 9359, 592, "295.0"));
		expected.add(new VideoCard("MSI R9 390X GAMING 8G", "Radeon R9 390X", "8 GB", "1050 MHz", "1100 MHz",
				"PCIe x16", "Black / Red", 2620, 579, "275.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		ArrayList<VideoCard> sortedList = VideoCardController.getSortedList("Name", "Ascending");
		sortedList = VideoCardController.getSortedList("TDP (W)", "Descending");
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++)
			result[i] = sortedList.get(i);
		assertArrayEquals(expected.toArray(), result);
	}

	@Test
	public void test_getSortedListDefault() {
		ArrayList<VideoCard> expected = new ArrayList<>();
		expected.add(new VideoCard("Asus DUAL", "Radeon RX 580", "8 GB", "1257 MHz", "1380 MHz", "PCIe x16",
				"Black / Silver", 2573, 501, "185.0"));
		expected.add(new VideoCard("Asus DUAL OC", "GeForce RTX 2060", "6 GB", "1365 MHz", "1785 MHz", "PCIe x16",
				"Black / Silver", 2963, 502, "160.0"));
		expected.add(new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz", "1582 MHz",
				"PCIe x16", "Black / Silver", 15599, 503, "250.0"));
		ArrayList<VideoCard> result = VideoCardController.getSortedList("Field", "Ascending");
		assertEquals(0, result.size());
	}

	@Test
	public void test_getSortedData() {
		VideoCardController videoCardController = (VideoCardController) VideoCardController.getInstance();
		String[][] expected = new String[1][10];
		expected[0][0] = "Asus DUAL";
		expected[0][1] = "Radeon RX 580";
		expected[0][2] = "8 GB";
		expected[0][3] = "1257 MHz";
		expected[0][4] = "1380 MHz";
		expected[0][5] = "PCIe x16";
		expected[0][6] = "Black / Silver";
		expected[0][7] = Integer.toString(2573);
		expected[0][8] = Integer.toString(501);
		expected[0][9] = "185.0";
		String[][] sortedList = videoCardController.getSortedData("Name", "Ascending");
		String[][] result = new String[1][10];
		for (int i = 0; i < 10; i++) {
			result[0][i] = sortedList[0][i];
		}
		assertArrayEquals(expected, result);
	}

	@Test
	public void test_getRequired1() {
		VideoCard expected = new VideoCard("Asus ROG Strix Gaming OC", "GeForce RTX 2080 Ti", "11 GB", "1350 MHz",
				"1665 MHz", "PCIe x16", "Black", 9983, 506, "250.0");
		VideoCard result = VideoCardController.getRequired("No Preference", 10000);
		assertEquals(true, expected.equals(result));

	}

	@Test
	public void test_getRequired2() {
		VideoCard expected = new VideoCard("Asus ROG Strix Gaming OC", "GeForce RTX 2080 Ti", "11 GB", "1350 MHz",
				"1665 MHz", "PCIe x16", "Black", 9983, 506, "250.0");
		VideoCard result = VideoCardController.getRequired("NVidia", 9983);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired3() {
		VideoCard expected = new VideoCard("XFX RX-VEGMA3FD6", "Radeon VII", "16 GB", "1400 MHz", "1801 MHz",
				"PCIe x16", "Silver", 9359, 592, "295.0");
		VideoCard result = VideoCardController.getRequired("AMD", 9359);
		assertEquals(true, expected.equals(result));
	}

	@Test
	public void test_getRequired4() {
		VideoCard result = VideoCardController.getRequired("Field", 0);
		assertNull("Result is null", result);
	}

}
