package test;

import static org.junit.Assert.*;
import org.junit.Test;
import backend.Memory;

public class Test_Memory {

	@Test
	public void test_getters() {
		Memory memory = new Memory("ADATA XPG GAMMIX D10 16 GB", "DDR4-2666", "288-pin DIMM", "2 x 8GB", "Red / White",
				16, 1271, 102);
		assertEquals("ADATA XPG GAMMIX D10 16 GB", memory.getName());
		assertEquals("DDR4-2666", memory.getSpeed());
		assertEquals("288-pin DIMM", memory.getType());
		assertEquals("2 x 8GB", memory.getModules());
		assertEquals("Red / White", memory.getColor());
		assertEquals(16, memory.getCasLatency());
		assertEquals(1271, memory.getPrice());
		assertEquals(102, memory.getId());
	}

	@Test
	public void test_setters() {
		Memory memory = new Memory("", "", "", "", "", 0, 0, 0);
		memory.setName("ADATA XPG V1.0 8 GB");
		memory.setSpeed("DDR3-1600");
		memory.setType("240-pin DIMM");
		memory.setModules("1 x 8GB");
		memory.setColor("Black / Silver");
		memory.setCasLatency(9);
		memory.setPrice(613);
		memory.setId(103);
		assertEquals("ADATA XPG V1.0 8 GB", memory.getName());
		assertEquals("DDR3-1600", memory.getSpeed());
		assertEquals("240-pin DIMM", memory.getType());
		assertEquals("1 x 8GB", memory.getModules());
		assertEquals("Black / Silver", memory.getColor());
		assertEquals(9, memory.getCasLatency());
		assertEquals(613, memory.getPrice());
		assertEquals(103, memory.getId());
	}

	@Test
	public void test_toString() {
		Memory memory = new Memory("ADATA XPG Gaming Series 8 GB", "DDR3-1600", "240-pin DIMM", "2 x 4GB", "Black", 9,
				873, 101);
		String result = memory.toString();
		String expected = "ADATA XPG Gaming Series 8 GB                 DDR3-1600      240-pin DIMM   2 x 4GB   Black               9         873       101  ";
		assertEquals(expected, result);
	}
}
