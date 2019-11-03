package gui;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DIYTab extends JPanel{
	private JTextField totalBudget;
	private JLabel totalBudgetlabel, checkSubmittedTotalBudgetLabel;
	private JButton calculateButtton;
	private double totalBudgetValue = 0;
	
	public DIYTab(){
		Budget budget = new Budget();    
	    totalBudget = new JTextField("0",10);
        Component CPU = new Component_CPU(this, "CPU",budget);
        Component MotherBoard = new Component_Motherboard(this, "MotherBoard",budget);
        Component RAM = new Component_Ram(this, "RAM",budget);
        Component PowerSupply = new Component_PowerSupply(this, "PowerSupply",budget);
        totalBudget.setBounds(10, 50, 200, 25);
        this.add(totalBudget);
        
        totalBudget.getDocument().addDocumentListener(new DocumentListener() {
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
        this.add(totalBudgetlabel);

        checkSubmittedTotalBudgetLabel= new JLabel();
        checkSubmittedTotalBudgetLabel.setText("Enter Your Total Budget :");
        checkSubmittedTotalBudgetLabel.setBounds(10, 300, 180, 50);
        this.add(checkSubmittedTotalBudgetLabel);
        
        
        calculateButtton = new JButton("Calculate");
        calculateButtton.setBounds(450, 400, 100, 60);
        this.add(calculateButtton);
        calculateButtton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
        		totalBudgetValue = Double.valueOf(totalBudget.getText());
        		checkSubmittedTotalBudgetLabel.setText("You have enter $"+String.valueOf(totalBudgetValue));				
			}          
	      });

        
        this.setLayout(null);
	}
}
