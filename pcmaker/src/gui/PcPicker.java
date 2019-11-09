package gui;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import backend.CPUController;
import backend.MemoryController;
import backend.MotherboardController;
import backend.PowerSupplyController;
import backend.StorageController;
import backend.VideoCardController;

public class PcPicker extends Frame {
	static private JPanel diyPanel, cpuPanel, memoryPanel, montherboardPanel, powerSupplyPanel, videoCardPanel,
			storagePanel;

	//please give me commit!!!
	public PcPicker() {
		JFrame frame = new JFrame("CS3443 Group 17 - PC-PICKER");
		diyPanel = new JPanel();
		cpuPanel = new JPanel();
		memoryPanel = new JPanel();
		montherboardPanel = new JPanel();
		storagePanel = new JPanel();
		videoCardPanel = new JPanel();
		frame.setSize(800, 500); // width, height
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException{
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("Components.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//cpuController.searchById(1);

			JFrame frame = new JFrame("CS3443 Group 17 - PC-PICKER");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JTabbedPane tabbedPane = new JTabbedPane();
			frame.add(tabbedPane);

			diyPanel = new DIYTab();
			cpuPanel = new ListTab(new CPUController(workbook));
			memoryPanel = new ListTab(new MemoryController(workbook));
			montherboardPanel = new ListTab(new MotherboardController(workbook));
			powerSupplyPanel = new ListTab(new PowerSupplyController(workbook));
			storagePanel = new ListTab(new StorageController(workbook));
			videoCardPanel = new ListTab(new VideoCardController(workbook));
			tabbedPane.addTab("DIY Planner", diyPanel);
			tabbedPane.addTab("CPU List", cpuPanel);
			tabbedPane.addTab("Memory List", memoryPanel);
			tabbedPane.addTab("Montherboard List", montherboardPanel);
			tabbedPane.addTab("Power Supply List", powerSupplyPanel);
			tabbedPane.addTab("Storage List", storagePanel);
			tabbedPane.addTab("Video Card List", videoCardPanel);

			frame.setSize(1050, 550);
			frame.setVisible(true);
			frame.setResizable(false);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				file.close();
			}
		}

	}
}