package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import backend.CPUController;
import backend.Controller;
import backend.SpecList;

public class DIYTab extends JPanel implements TotalObserver{
	//private JTextField totalBudget;
	private JLabel totalBudgetlabel, checkSubmittedTotalBudgetLabel,resultOutput;
	private JButton calculateButtton;
	private double totalBudgetValue = 0;
	private Budget budget;
	private SpecList specList;
	private ButtonGroup cpuGroup, cardGroup;
	private boolean calRsult = false;
	
	public DIYTab() throws IOException{
		budget = new Budget(this);

        Component cpuBar = new Component_CPU(this, "CPU",budget);
        Component motherboardBar = new Component_Motherboard(this, "Motherboard",budget);
        Component ramBar = new Component_Ram(this, "RAM",budget);
        Component videoBar = new Component_VideoCard(this, "Video Card", budget);
        Component psuBar = new Component_PowerSupply(this, "Power Supply",budget);
        Component storageBar = new Component_Storage(this, "Storage",budget);
  
        FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//CPUController cpuController = new CPUController(workbook);

        JLabel specListTitle = new JLabel();
    	specListTitle.setText("The following specification list is fulfilled your requirement:");
    	specListTitle.setBounds(400, 0, 500, 60);
    	this.add(specListTitle);
    	
    	JLabel specListOutput = new JLabel();
    	specListOutput.setText("<html>Hello World!<br/>blahblahblah<br/></html>");
    	specListOutput.setBounds(420, 20, 500, 300);
    	this.add(specListOutput);

        checkSubmittedTotalBudgetLabel= new JLabel();
        checkSubmittedTotalBudgetLabel.setText("Total Budget: $ 0");
        checkSubmittedTotalBudgetLabel.setBounds(10, 220, 180, 50);
        this.add(checkSubmittedTotalBudgetLabel);
        
        
        calculateButtton = new JButton("Calculate");
        calculateButtton.setBounds(450, 400, 100, 60);
        this.add(calculateButtton);
        calculateButtton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
        		budget.setCPUPreference(getSelectedButtonText(cpuGroup));
        		budget.setCardPreference(getSelectedButtonText(cardGroup));
        		budget.showTotal();
        		specList = new SpecList(budget);
        		
        		if(specList.findList()) {
        			String listText = "<html>"+specList.getCpuMessage()+"<br/>\"<br/>"+specList.getMotherboardMessage()+"<br/>\"<br/>"+
        								specList.getMemoryMessage()+"<br/>\"<br/>"+specList.getVideoCardMessage()+"<br/>\"<br/>"+specList.getPowerSupplyMessage()+"<br/>\"<br/>"+
        								specList.getStorageMessage()+"<br/>\"<br/>"+specList.getTotalMessage()+"</html>";
        			specListOutput.setText(listText);
        		}
        		else {
        			specListOutput.setText("No result found!");
        		}
			}          
	      });
        
        JLabel cpuBrand = new JLabel("CPU Brand Preference");
        cpuBrand.setBounds(10, 270, 180, 50);
        this.add(cpuBrand);
        JRadioButton intelCPU = new JRadioButton("Intel", false);
        JRadioButton amdCPU = new JRadioButton("AMD", false);
        JRadioButton npCPU = new JRadioButton("No Preference", true);
        intelCPU.setBounds(10, 300, 180, 50);
        amdCPU.setBounds(10, 330, 180, 50);
        npCPU.setBounds(10, 360, 180, 50);
        this.add(intelCPU);
        this.add(amdCPU);
        this.add(npCPU);
        cpuGroup = new ButtonGroup();
        cpuGroup.add(intelCPU);
        cpuGroup.add(amdCPU);
        cpuGroup.add(npCPU);
        
        
        JLabel videoCardBrand = new JLabel("Video Card Brand Preference");
        videoCardBrand.setBounds(200, 270, 180, 50);
        this.add(videoCardBrand);
        JRadioButton nvidiaCard = new JRadioButton("NVidia", false);
        JRadioButton amdCard = new JRadioButton("AMD", false);
        JRadioButton npCard = new JRadioButton("No Preference", true);
        nvidiaCard.setBounds(200, 300, 180, 50);
        amdCard.setBounds(200, 330, 180, 50);
        npCard.setBounds(200, 360, 180, 50);
        this.add(nvidiaCard);
        this.add(amdCard);
        this.add(npCard);
        cardGroup = new ButtonGroup();
        cardGroup.add(nvidiaCard);
        cardGroup.add(amdCard);
        cardGroup.add(npCard);
        this.setLayout(null);
	}
	
	public void updateTotal() {
		checkSubmittedTotalBudgetLabel.setText("Total Budget: $ " + budget.getTotal());
	}
	
	public void refreshresult() {
		this.add(resultOutput);
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();

	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }

	    return null;
	}
	
}
