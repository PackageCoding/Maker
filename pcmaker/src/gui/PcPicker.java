package gui;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import backend.Controller;

public class PcPicker extends Frame {
	static private JPanel diyPanel, cpuPanel, memoryPanel, montherboardPanel, powerSupplyPanel, videoCardPanel,
			storagePanel;

	public PcPicker() throws IOException {
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
			Controller.workbook = new XSSFWorkbook(file);

			JFrame frame = new JFrame("CS3443 Group 17 - PC-PICKER");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JTabbedPane tabbedPane = new JTabbedPane();
			frame.add(tabbedPane);

			diyPanel = new DIYTab();
			cpuPanel = TabFactory.getTab("cpu");
			memoryPanel = TabFactory.getTab("memory");
			montherboardPanel = TabFactory.getTab("motherboard");
			powerSupplyPanel = TabFactory.getTab("powersupply");
			storagePanel = TabFactory.getTab("storage");
			videoCardPanel = TabFactory.getTab("videocard");
			
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