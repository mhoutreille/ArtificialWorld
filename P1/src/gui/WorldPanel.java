package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utils.WorldProxy;

public class WorldPanel extends JPanel implements Runnable, ChangeListener {

	
	


	



	JTextField dateField = new JTextField(20);
    //JTextField timeMultiplier = new JTextField(20);
    
    JSlider timeMultiplier = new JSlider(JSlider.HORIZONTAL, 1, 1000, 100);
	
	public WorldPanel() {
		
		
		timeMultiplier.setMajorTickSpacing(100);
		timeMultiplier.setMinorTickSpacing(1);
		timeMultiplier.setPaintTicks(true);
		timeMultiplier.setPaintLabels(true);
		timeMultiplier.addChangeListener(this);
		
        JLabel label1 = new JLabel("Current Date:");
        JLabel label2 = new JLabel("World Speed:");
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);
        
        gc.gridx = 0;
        gc.gridy = 0;
        add(label1, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(dateField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(label2, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(timeMultiplier, gc);
        
        
        new Thread(this).start();
        
        
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				refresh();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void refresh() {
		
		if(isVisible()) {
			dateField.setText(WorldProxy.getCurrentWorld().getCurrentDate().toGMTString()); 
			timeMultiplier.setValue(WorldProxy.getCurrentWorld().getTimeProcess().getWorldSpeedTimeFactor());
		}
		
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		JSlider source = (JSlider)arg0.getSource();
	    if (!source.getValueIsAdjusting()) {
	        int worldSpeedTimeFactor = (int)source.getValue();
	      
	        if (worldSpeedTimeFactor == 0) {
	           // if (!frozen) stopAnimation();
	        } else {
	        	WorldProxy.getCurrentWorld().getTimeProcess().setWorldSpeedTimeFactor(worldSpeedTimeFactor);
	        }
	    }
		
	}
	
	
	
}
