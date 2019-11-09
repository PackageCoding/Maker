package gui;
import java.awt.event.*;
import javax.swing.JPanel;

public class Component_Motherboard extends Component {

	public Component_Motherboard(JPanel panel, String componentTitle, Budget budget) {
		super(panel, componentTitle, budget);
	}
	
	public void barControlListener(Budget budget) {
		componentBar.setMaximum(7000);
		componentBar.addAdjustmentListener(new AdjustmentListener() {
        	public void adjustmentValueChanged(AdjustmentEvent e) {
        		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        		componentBar.addMouseListener(new MouseAdapter() {
        			public void mouseReleased(MouseEvent e) {
        				int increment = componentBar.getValue() - budget.getMbPrice();
        				/*if(budget.reachTotal(increment)) {
        					componentBar.setValue(budget.getRemaining()+budget.getMbPrice());
        					componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        					budget.addMbPrice(budget.getRemaining());
        				}
        				else {
        					budget.addMbPrice(increment);
        				}*/
        				budget.addMbPrice(increment);
        			}
        		});
        		
        	}
        });
	}
	

}
