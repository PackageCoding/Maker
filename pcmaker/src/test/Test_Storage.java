package test;

import static org.junit.Assert.*;
import org.junit.Test;
import backend.Storage;

public class Test_Storage {
	
	@Test
	public void test_getters() {
		Storage storage = new Storage("Crucial MX500", "2 TB", "SSD", "2048 MB", "2.5\"", "SATA 6 Gb/s", 1742, 401);
		assertEquals("Crucial MX500", storage.getName());
		assertEquals("2 TB", storage.getCapacity());
		assertEquals("SSD", storage.getType());
		assertEquals("2048 MB", storage.getCache());
		assertEquals("2.5\"", storage.getFormFactor());
		assertEquals("SATA 6 Gb/s", storage.get_Interface());
		assertEquals(1742, storage.getPrice());
		assertEquals(401, storage.getId());
	}
	
	@Test
	public void test_setters() {
		Storage storage = new Storage("", "", "", "", "", "", 0, 0);
		storage.setName("Gigabyte UD PRO");
		storage.setCapacity("256 GB");
		storage.setType("SSD");
		storage.setCache("256 MB");
		storage.setFormFactor("2.5\"");
		storage.set_Interface("SATA 6 Gb/s");
		storage.setPrice(272);
		storage.setId(402);
		
	
		
		assertEquals("Gigabyte UD PRO", storage.getName());
		assertEquals("256 GB", storage.getCapacity());
		assertEquals("SSD", storage.getType());
		assertEquals("256 MB", storage.getCache());
		assertEquals("2.5\"", storage.getFormFactor());
		assertEquals("SATA 6 Gb/s", storage.get_Interface());
		assertEquals(272, storage.getPrice());
		assertEquals(402, storage.getId());
	}
	
	@Test
	public void test_toString() {
		Storage storage = new Storage("Hitachi Deskstar", "1 TB", "7200 RPM", "32 MB", "3.5\"", "SATA 3 Gb/s", 374, 403);
		String result = storage.toString();
		String expected = "Hitachi Deskstar                   1 TB      7200 RPM  32 MB     3.5\"      SATA 3 Gb/s    374       403  ";
		assertEquals(expected, result);
	}
	
}
