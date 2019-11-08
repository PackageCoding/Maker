package gui;
import java.awt.event.*;
import javax.swing.JPanel;

public class Component_PowerSupply extends Component {

	public Component_PowerSupply(JPanel panel, String componentTitle, Budget budget) {
		super(panel, componentTitle, budget);
	}
	
	public void barControlListener(Budget budget) {
		componentBar.addAdjustmentListener(new AdjustmentListener() {
        	public void adjustmentValueChanged(AdjustmentEvent e) {
        		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        		componentBar.addMouseListener(new MouseAdapter() {
        			public void mouseReleased(MouseEvent e) {
        				int increment = componentBar.getValue() - budget.getPsuPrice();
        				/*if(budget.reachTotal(increment)) {
        					componentBar.setValue(budget.getRemaining()+budget.getPsuPrice());
        					componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        					budget.addPsuPrice(budget.getRemaining());
        				}
        				else {
        					budget.addPsuPrice(increment);
        				}*/
        				budget.addPsuPrice(increment);
        			}
        		});
        		
        	}
        });
	}
	

}
