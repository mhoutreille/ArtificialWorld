package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	
	public MainFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-50), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150));

        //Add content to the window.
        add(getTabbedPane(), BorderLayout.CENTER);
         
        //Display the window.
        pack();
        setVisible(true);
	}
	
	
	private JTabbedPane getTabbedPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent panel1 = new WorldPanel();
        tabbedPane.addTab("World Parameters", null, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = new HumanPanel();
        tabbedPane.addTab("Humans", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        return tabbedPane;
	}
	
	
	 protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
}
