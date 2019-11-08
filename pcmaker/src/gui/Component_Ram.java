package gui;
import java.awt.event.*;
import javax.swing.JPanel;

public class Component_Ram extends Component {

	public Component_Ram(JPanel panel, String componentTitle, Budget budget) {
		super(panel, componentTitle, budget);
	}
	
	public void barControlListener(Budget budget) {
		componentBar.addAdjustmentListener(new AdjustmentListener() {
        	public void adjustmentValueChanged(AdjustmentEvent e) {
        		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        		componentBar.addMouseListener(new MouseAdapter() {
        			public void mouseReleased(MouseEvent e) {
        				int increment = componentBar.getValue() - budget.getRamPrice();
        				/*if(budget.reachTotal(increment)) {
        					componentBar.setValue(budget.getRemaining()+budget.getRamPrice());
        					componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
        					budget.addRamPrice(budget.getRemaining());
        				}
        				else {
        					budget.addRamPrice(increment);
        				}*/
        				budget.addRamPrice(increment);
        			}
        		});
        		
        	}
        });
	}
	

}
