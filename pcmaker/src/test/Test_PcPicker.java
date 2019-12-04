package test;

import java.io.IOException;

import org.junit.Test;

import gui.PcPicker;

public class Test_PcPicker {
	@Test
	public void test_main() throws IOException {
		PcPicker pcPicker = new PcPicker();
		PcPicker.main(null);
	}

}
