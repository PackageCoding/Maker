package gui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Component_Storage extends Component {
	public Component_Storage(JPanel panel, String componentTitle, Budget budget) {
		super(panel, componentTitle, budget);
	}
	
	public void barControlListener(Budget budget) {
		componentBar.setMaximum(7000);
		componentBar.addAdjustmentListener(new AdjustmentListener() {
        	public void adjustmentValueChanged(AdjustmentEvent e) {
        		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        		componentBar.addMouseListener(new MouseAdapter() {
        			public void mouseReleased(MouseEvent e) {
        				int increment = componentBar.getValue() - budget.getStoragePrice();
        				budget.addStoragePrice(increment);
        			}
        		});
        		
        	}
        });
	}
}
