package test;

import static org.junit.Assert.*;
import org.junit.Test;

import backend.VideoCard;

public class Test_VideoCard {
	@Test
	public void test_getters() {
		VideoCard videoCard = new VideoCard("Asus DUAL", "Radeon RX 580", "8 GB", "1257 MHz", "1380 MHz", "PCIe x16",
				"Black / Silver", 2573, 501, "185");
		assertEquals("Asus DUAL", videoCard.getName());
		assertEquals("Radeon RX 580", videoCard.getChipset());
		assertEquals("8 GB", videoCard.getMemory());
		assertEquals("1257 MHz", videoCard.getCoreClock());
		assertEquals("1380 MHz", videoCard.getBoostClock());
		assertEquals("PCIe x16", videoCard.get_Interface());
		assertEquals("Black / Silver", videoCard.getColor());
		assertEquals(2573, videoCard.getPrice());
		assertEquals(501, videoCard.getId());
		assertEquals("185", videoCard.getTdp());
	}

	@Test
	public void test_setters() {
		VideoCard videoCard = new VideoCard("", "", "", "", "", "", "", 0, 0, "");
		videoCard.setName("Asus DUAL OC");
		videoCard.setChipset("GeForce RTX 2060");
		videoCard.setMemory("6 GB");
		videoCard.setCoreClock("1365 MHz");
		videoCard.setBoostClock("1785 MHz");
		videoCard.set_Interface("PCIe x16");
		videoCard.setColor("Black / Silver");
		videoCard.setPrice(2963);
		videoCard.setId(502);
		videoCard.setTdp("160");

		assertEquals("Asus DUAL OC", videoCard.getName());
		assertEquals("GeForce RTX 2060", videoCard.getChipset());
		assertEquals("6 GB", videoCard.getMemory());
		assertEquals("1365 MHz", videoCard.getCoreClock());
		assertEquals("1785 MHz", videoCard.getBoostClock());
		assertEquals("PCIe x16", videoCard.get_Interface());
		assertEquals("Black / Silver", videoCard.getColor());
		assertEquals(2963, videoCard.getPrice());
		assertEquals(502, videoCard.getId());
		assertEquals("160", videoCard.getTdp());
	}

	@Test
	public void test_toString() {
		VideoCard videoCard = new VideoCard("Asus Founders Edition", "GeForce GTX 1080 Ti", "11 GB", "1480 MHz",
				"1582 MHz", "PCIe x16", "Black / Silver", 15599, 503, "250");
		String result = videoCard.toString();
		String expected = "Asus Founders Edition         GeForce GTX 1080 Ti      11 GB     1480 MHz  1582 MHz  PCIe x16  Black / Silver 15599     503  250  ";
		assertEquals(expected, result);
	}
}
