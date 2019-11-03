package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	public static void main(String[] args) throws IOException {
		FileInputStream file = null;

		try {
			file = new FileInputStream(new File("C:\\Users\\bellamy\\Desktop\\Pc-Picker\\poi\\poi\\Components.xlsx"));
			// file = new FileInputStream(new
			// File("H:\\eclipse-workplace\\poi-20191011T091221Z-001\\poi\\poi\\Components.xlsx"));
			//file = new FileInputStream(new File("C:\\Users\\hp\\eclipse-workspace\\poi\\poi\\Components.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			CPUController cpuController = new CPUController(workbook);
			//CPUCoolerController cpuCoolerController = new CPUCoolerController(workbook);
			//MotherboardController motherboardController = new MotherboardController(workbook);
			//cpuController.printList();
			//cpuController.printSortedList("Name", "ascending");
			//cpuController.printSortedList("Core Count", "ascending");
			//cpuController.searchById(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				file.close();
			}
		}
	}

}
