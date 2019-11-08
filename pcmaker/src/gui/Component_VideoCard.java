package gui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Component_VideoCard extends Component{
	public Component_VideoCard(JPanel panel, String componentTitle, Budget budget) {
		super(panel, componentTitle, budget);
	}
	
	public void barControlListener(Budget budget) {
		componentBar.addAdjustmentListener(new AdjustmentListener() {
        	public void adjustmentValueChanged(AdjustmentEvent e) {
        		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        		componentBar.addMouseListener(new MouseAdapter() {
        			public void mouseReleased(MouseEvent e) {
        				int increment = componentBar.getValue() - budget.getVideoCardPrice();
        				/*if(budget.reachTotal(increment)) {
        					componentBar.setValue(budget.getRemaining()+budget.getCpuPrice());
        					componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        					budget.addCpuPrice(budget.getRemaining());
        				}
        				else {
        					budget.addCpuPrice(increment);
        				}*/
        				budget.addVideoCardPrice(increment);
        			}
        		});
        		
        	}
        });
	}
}
