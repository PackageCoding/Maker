package gui;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public abstract class Component {
	protected JLabel componentTitle;
	protected JScrollBar componentBar;
	protected JLabel componentBarLabel;
	private static int yValue = 20;
	public Component(JPanel panel,String ComponentTitle,Budget budget){
		
		this.componentTitle =new JLabel(""+ComponentTitle);
		this.componentTitle.setBounds(10,yValue,100,20);
		panel.add(this.componentTitle);
		
		componentBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,0);
		componentBar.setBounds(100,yValue,200,20);
		componentBar.setBlockIncrement(10);
		componentBar.setValue(0);
		componentBar.setMaximum(35000);
		
		componentBar.setUI(new BasicScrollBarUI()
	    {   
			
	        @Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }
	        
            @Override 
            protected void paintTrack(Graphics g, JComponent c, Rectangle r)
            {
                g.setColor(Color.white);
                g.fillRect(r.x, r.y + 7, r.width, 6);
            }
            
            protected void paintThumb(Graphics g, JComponent c, Rectangle r)
            {   	
            	
                g.translate(r.x, r.y);                           

                g.setColor(thumbDarkShadowColor);        
                g.fillRect(0, 0, r.width, r.height-1);
                //g.fillOval(0, 6, 8, 8);
                
                g.translate(-r.x, -r.y);

                
            }

	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
	    });
		panel.add(componentBar);
		componentBarLabel = new JLabel();
		componentBarLabel.setBounds(320,yValue,180,20);
		componentBarLabel.setText("$" + Integer.toString(componentBar.getValue()));
		panel.add(componentBarLabel);
		yValue+=30;

		barControlListener(budget);
	}
	
	public abstract void barControlListener(Budget budget);
	
	
	public void BarSetValue(int value) {
		componentBar.setValue(value);
	}
	
	public void BarSetMax(int value) {
		componentBar.setMaximum(value);
	}
	
	
}

	
