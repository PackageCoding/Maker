package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import gui.Budget;
import gui.DIYTab;

public class Test_Budget {

	@Test
	public void test_resetComponentToZero() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.resetComponentToZero();
		assertEquals(0, budget.getTotal());
		assertEquals(0, budget.getCpuPrice());
		assertEquals(0, budget.getMbPrice());
		assertEquals(0, budget.getRamPrice());
		assertEquals(0, budget.getPsuPrice());
		assertEquals(0, budget.getVideoCardPrice());
		assertEquals(0, budget.getStoragePrice());
	}
	
	@Test
	public void test_showTotal() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.showTotal();
	}
	
	@Test
	public void test_getters_and_addFunctions() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.resetComponentToZero();
		budget.addTotal(1000);
		budget.addCpuPrice(2000);
		budget.addMbPrice(3000);
		budget.addRamPrice(4000);
		budget.addPsuPrice(5000);
		budget.addVideoCardPrice(6000);
		budget.addStoragePrice(7000);
		assertEquals(28000, budget.getTotal());
		assertEquals(2000, budget.getCpuPrice());
		assertEquals(3000, budget.getMbPrice());
		assertEquals(4000, budget.getRamPrice());
		assertEquals(5000, budget.getPsuPrice());
		assertEquals(6000, budget.getVideoCardPrice());
		assertEquals(7000, budget.getStoragePrice());
	}

	@Test
	public void test_getters_and_setters_preference() throws IOException {
		DIYTab diyTab = new DIYTab();
		Budget budget = new Budget(diyTab);
		budget.resetComponentToZero();
		budget.setCPUPreference("Intel");
		budget.setCardPreference("NVidia");
		assertEquals("Intel", budget.getCPUPreference());
		assertEquals("NVidia", budget.getCardPreference());
	}
	
}
