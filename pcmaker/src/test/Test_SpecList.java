package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.CPUController;
import backend.Controller;
import backend.MemoryController;
import backend.MotherboardController;
import backend.PowerSupplyController;
import backend.SpecList;
import backend.StorageController;
import backend.VideoCardController;
import gui.Budget;
import gui.DIYTab;

public class Test_SpecList {
	@BeforeClass
	public static void init() throws IOException {
		FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		Controller.workbook = new XSSFWorkbook(file);
		CPUController cpuController = (CPUController) CPUController.getInstance();
		MemoryController memoryController = (MemoryController) MemoryController.getInstance();
		MotherboardController motherboardController = (MotherboardController) MotherboardController.getInstance();
		PowerSupplyController powerSupplyController = (PowerSupplyController) PowerSupplyController.getInstance();
		StorageController storageController = (StorageController) StorageController.getInstance();
		VideoCardController videoCardController = (VideoCardController) VideoCardController.getInstance();
	}
	
	@Test
	public void test_findList1() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		SpecList specList = new SpecList(budget);
		boolean result = specList.findList();
		assertFalse("Result is false", result);
	}
	
	@Test
	public void test_findList2() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.setCPUPreference("AMD");
		budget.addCpuPrice(5000);
		SpecList specList = new SpecList(budget);
		boolean result = specList.findList();
		assertFalse("Result is false", result);
	}
	
	@Test
	public void test_findList3() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.setCPUPreference("AMD");
		budget.addCpuPrice(10000);
		budget.addMbPrice(15000);
		budget.addRamPrice(20000);
		budget.addStoragePrice(25000);
		budget.setCardPreference("AMD");
		budget.addVideoCardPrice(30000);
		budget.addPsuPrice(35000);
		SpecList specList = new SpecList(budget);
		boolean result = specList.findList();
		assertTrue("Result is true", result);
	}
	
	@Test
	public void test_getters() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.setCPUPreference("AMD");
		budget.addCpuPrice(10000);
		budget.addMbPrice(15000);
		budget.addRamPrice(20000);
		budget.addStoragePrice(25000);
		budget.setCardPreference("AMD");
		budget.addVideoCardPrice(30000);
		budget.addPsuPrice(35000);
		SpecList specList = new SpecList(budget);
		specList.findList();
		assertEquals("Cpu: AMD Threadripper 2970WX, Price: $7136", specList.getCpuMessage());
		assertEquals("Motherboard: Gigabyte X570 AORUS XTREME, Price: $5491", specList.getMotherboardMessage());
		assertEquals("Memory: Corsair Vengeance LPX 16 GB, Price: $3216", specList.getMemoryMessage());
		assertEquals("Storage: Samsung 960 Pro, Price: $10139", specList.getStorageMessage());
		assertEquals("VideoCard: XFX RX-VEGMA3FD6, Price: $9359", specList.getVideoCardMessage());
		assertEquals("PowerSupply: Cooler Master Silent Pro Gold, Price: $21190", specList.getPowerSupplyMessage());
		assertEquals("Total Cost: $56531", specList.getTotalMessage());
	}
}
