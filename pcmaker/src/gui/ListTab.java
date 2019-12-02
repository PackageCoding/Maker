package gui;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import backend.CPU;
import backend.Controller;

public class ListTab extends JPanel{
	private JTable table;
	private JScrollPane scrollPane;
	private String tableData[][];
	private JLabel sortTitle, sortField, sortOrder;
	private Controller controller;
	
	public ListTab(Controller ctl) throws IOException {
		controller = ctl;

	    // Column Names 
	    String[] columnNames = controller.getFieldTitle();
	    tableData = controller.getTableData();
	 
	    // Initializing the JTable 
	    table = new JTable(tableData, columnNames);
	    
	    table.getTableHeader().setReorderingAllowed(false);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	    
	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0,0,880,475);
	    this.add(scrollPane);
		
	    this.setLayout(new BorderLayout());
	    
	    sortTitle = new JLabel("Sorted By:");
	    sortTitle.setBounds(890,20,100,50);
	    this.add(sortTitle);
	    
	    sortField = new JLabel("Name");
	    sortField.setBounds(890,50,200,50);
	    this.add(sortField);
	    
	    sortOrder = new JLabel("Ascending");
	    sortOrder.setBounds(890,80,100,50);
	    this.add(sortOrder);
	    
	    this.add(new JLabel());
	    
	    table.getTableHeader().addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            int col = table.columnAtPoint(e.getPoint());
	            String name = table.getColumnName(col);
	      
	            if(!name.equals("Id")) {
	            	if(sortField.getText().equals(name)) {
	            		if(sortOrder.getText().equals("Ascending")) {
	            			sortOrder.setText("Descending");
	            		}
	            		else {	
	            			sortOrder.setText("Ascending");
	            		}
	            	}
	            	else {
	            		sortField.setText(name);
	            		sortOrder.setText("Ascending");
	            	}
	            
	            	table.setVisible(false);
	            
	            	tableData = controller.getSortedData(sortField.getText(), sortOrder.getText());
	            	for(int rowNum=0; rowNum<tableData.length; rowNum++) {
	            		for(int colNum=0; colNum<tableData[0].length; colNum++) {
	            			table.getModel().setValueAt(tableData[rowNum][colNum], rowNum, colNum);
	            		}
	            	}
	            	table.setVisible(true);
	            }
	        }
	    });
	}
	
	
	
	
}
