package test;

import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;

import gui.ListTab;
import gui.TabFactory;

public class Test_TabFactory {
	@Test
	public void test_getTab() throws IOException {
		TabFactory tabFactory = new TabFactory();
		ListTab result = TabFactory.getTab("tab");
		assertNull("Result is null", result);
	}
}
