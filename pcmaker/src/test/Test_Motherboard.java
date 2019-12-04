package test;

import static org.junit.Assert.*;
import org.junit.Test;

import backend.Motherboard;

public class Test_Motherboard {
	
	@Test
	public void test_getters() {
		Motherboard motherboard = new Motherboard("ASRock B365M Phantom Gaming 4", "LGA1151", "Micro ATX", 4, "128 GB", "Black / Red", 670,	202);
		assertEquals("ASRock B365M Phantom Gaming 4", motherboard.getName());
		assertEquals("LGA1151", motherboard.getSocket_cpu());
		assertEquals("Micro ATX", motherboard.getFormFactor());
		assertEquals(4, motherboard.getRamSlots());
		assertEquals("128 GB", motherboard.getMaxRam());
		assertEquals("Black / Red", motherboard.getColor());
		assertEquals(670, motherboard.getPrice());
		assertEquals(202, motherboard.getId());
	}

	@Test
	public void test_setters() {
		Motherboard motherboard = new Motherboard("", "", "", 0, "", "", 0, 0);
		motherboard.setName("ASRock B365M Pro4");
		motherboard.setSocket_cpu("LGA1151");
		motherboard.setFormFactor("Micro ATX");
		motherboard.setRamSlots(4);
		motherboard.setMaxRam("64 GB");
		motherboard.setColor("Black / Silver");
		motherboard.setPrice(584);
		motherboard.setId(203);
		assertEquals("ASRock B365M Pro4", motherboard.getName());
		assertEquals("LGA1151", motherboard.getSocket_cpu());
		assertEquals("Micro ATX", motherboard.getFormFactor());
		assertEquals(4, motherboard.getRamSlots());
		assertEquals("64 GB", motherboard.getMaxRam());
		assertEquals("Black / Silver", motherboard.getColor());
		assertEquals(584, motherboard.getPrice());
		assertEquals(203, motherboard.getId());
	}

	@Test
	public void test_toString() {
		Motherboard motherboard = new Motherboard("ASRock A320M-HDV R4.0", "AM4", "Micro ATX",	2, "32 GB", "Black / White", 428, 201);
		String result = motherboard.toString();
		String expected = "ASRock A320M-HDV R4.0                   AM4            Micro ATX      2    32 GB     Black / White       428       201  ";
		assertEquals(expected, result);
	}
}
