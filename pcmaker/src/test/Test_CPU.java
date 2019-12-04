package test;

import static org.junit.Assert.*;
import org.junit.Test;
import backend.CPU;

public class Test_CPU {

	@Test
	public void test_getters() {
		CPU cpu = new CPU("AMD A10-7850K", 4, "3.7 GHz", "4 GHz", "95", "Radeon R7 (on-die)", "No", 1227, 2);
		assertEquals("AMD A10-7850K", cpu.getName());
		assertEquals(4, cpu.getCoreCount());
		assertEquals("3.7 GHz", cpu.getCoreClock());
		assertEquals("4 GHz", cpu.getBoostClock());
		assertEquals("95", cpu.getTdp());
		assertEquals("Radeon R7 (on-die)", cpu.getIntegratedGraphics());
		assertEquals("No", cpu.getSmt());
		assertEquals(1227, cpu.getPrice());
		assertEquals(2, cpu.getId());
	}

	@Test
	public void test_setters() {
		CPU cpu = new CPU("", 0, "", "", "", "", "", 0, 0);
		cpu.setName("AMD A10-9700");
		cpu.setCoreCount(4);
		cpu.setCoreClock("3.5 GHz");
		cpu.setBoostClock("3.8 GHz");
		cpu.setTdp("65");
		cpu.setIntegratedGraphics("Radeon R7 (on-die)");
		cpu.setSmt("No");
		cpu.setPrice(589);
		cpu.setId(3);
		assertEquals("AMD A10-9700", cpu.getName());
		assertEquals(4, cpu.getCoreCount());
		assertEquals("3.5 GHz", cpu.getCoreClock());
		assertEquals("3.8 GHz", cpu.getBoostClock());
		assertEquals("65", cpu.getTdp());
		assertEquals("Radeon R7 (on-die)", cpu.getIntegratedGraphics());
		assertEquals("No", cpu.getSmt());
		assertEquals(589, cpu.getPrice());
		assertEquals(3, cpu.getId());
	}

	@Test
	public void test_toString() {
		CPU cpu = new CPU("AMD A10-7700K", 4, "3.4 GHz", "3.8 GHz", "95", "Radeon R7 (on-die)", "No", 900, 1);
		String result = cpu.toString();
		String expected = "AMD A10-7700K            4    3.4 GHz   3.8 GHz   95        Radeon R7 (on-die)       No   900       1    ";
		assertEquals(expected, result);
	}
}
