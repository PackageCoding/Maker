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
	    //totalBudget = new JTextField("0",10);
        Component cpuBar = new Component_CPU(this, "CPU",budget);
        Component motherboardBar = new Component_Motherboard(this, "Motherboard",budget);
        Component ramBar = new Component_Ram(this, "RAM",budget);
        Component videoBar = new Component_VideoCard(this, "Video Card", budget);
        Component psuBar = new Component_PowerSupply(this, "Power Supply",budget);
        Component storageBar = new Component_Storage(this, "Storage",budget);
        //totalBudget.setBounds(10, 50, 200, 25);
        //this.add(totalBudget);
        
        FileInputStream file = new FileInputStream(new File("Components.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		CPUController cpuController = new CPUController(workbook);

        JLabel specListOutput = new JLabel();
    	specListOutput.setText("The following specification list is fulfilled your requirement:");
    	specListOutput.setBounds(400, 0, 500, 60);
    	this.add(specListOutput);
        /*totalBudget.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        	   warn();
        	}
        	public void removeUpdate(DocumentEvent e) {
        	   warn();
        	}
        	public void insertUpdate(DocumentEvent e) {
        	   warn();
        	}
        	public void warn() {
        		
        		try {
        			int total = Integer.parseInt(totalBudget.getText());
   
        		    if (totalBudget.getText().charAt(0)=='0'){
        		    	budget.setTotal(0);
        		    	checkSubmittedTotalBudgetLabel.setText("Enter A positive integer!");	
        		    	CPU.BarSetMax(0);
        		    	MotherBoard.BarSetMax(0);
        		    	RAM.BarSetMax(0);
        		    	PowerSupply.BarSetMax(0);
        		    } else {
        		    	budget.setTotal(total);
        		    	checkSubmittedTotalBudgetLabel.setText("You have enter $" + total);
        		    	CPU.BarSetMax(total);
        		    	MotherBoard.BarSetMax(total);
        		    	RAM.BarSetMax(total);
        		    	PowerSupply.BarSetMax(total);
        		    }
    
        	    }catch(Exception e) {
        	    	budget.setTotal(0);
        	    	checkSubmittedTotalBudgetLabel.setText("Enter A positive integer!");	
        	    	CPU.BarSetMax(0);
    		    	MotherBoard.BarSetMax(0);
    		    	RAM.BarSetMax(0);
    		    	PowerSupply.BarSetMax(0);
        	    }finally {
        	    	CPU.BarSetValue(0);
        	    	MotherBoard.BarSetValue(0);
        	    	RAM.BarSetValue(0);
        	    	PowerSupply.BarSetValue(0);
        		    budget.resetComponentToZero();
        		    
        	    }
        	}	  
        });

        totalBudgetlabel = new JLabel();
        totalBudgetlabel.setText("Enter Your Total Budget :");
        totalBudgetlabel.setBounds(10, 10, 200, 50);
        this.add(totalBudgetlabel);*/

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
        		specList = new SpecList(budget,cpuController);
        		specList.print();
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
