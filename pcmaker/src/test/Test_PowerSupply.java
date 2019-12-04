package test;

import static org.junit.Assert.*;
import org.junit.Test;

import backend.PowerSupply;

public class Test_PowerSupply {
	
	@Test
	public void test_getters() {
		PowerSupply powerSupply = new PowerSupply("Antec High Current Gamer", "ATX", "80+ Bronze", "850", "Full", 670, 302);
		assertEquals("Antec High Current Gamer", powerSupply.getName());
		assertEquals("ATX", powerSupply.getFormFactor());
		assertEquals("80+ Bronze", powerSupply.getEfficiencyRating());
		assertEquals("850", powerSupply.getWattage());
		assertEquals("Full", powerSupply.getModular());
		assertEquals(670, powerSupply.getPrice());
		assertEquals(302, powerSupply.getId());
	}

	@Test
	public void test_setters() {
		PowerSupply powerSupply = new PowerSupply("", "", "", "", "", 0, 0);
		powerSupply.setName("Apevia AD");
		powerSupply.setFormFactor("ATX");
		powerSupply.setEfficiencyRating("80+ Bronze");
		powerSupply.setWattage("500");
		powerSupply.setModular("No");
		powerSupply.setPrice(194);
		powerSupply.setId(303);
		assertEquals("Apevia AD", powerSupply.getName());
		assertEquals("ATX", powerSupply.getFormFactor());
		assertEquals("80+ Bronze", powerSupply.getEfficiencyRating());
		assertEquals("500", powerSupply.getWattage());
		assertEquals("No", powerSupply.getModular());
		assertEquals(194, powerSupply.getPrice());
		assertEquals(303, powerSupply.getId());
	}

	@Test
	public void test_toString() {
		PowerSupply powerSupply = new PowerSupply("Antec Earthwatts Gold Pro", "ATX", "80+ Gold", "650", "Semi", 740, 301);
		String result = powerSupply.toString();
		String expected = "Antec Earthwatts Gold Pro                         ATX       80+ Gold       650       Semi 740       301  ";
		assertEquals(expected, result);
	}
}
