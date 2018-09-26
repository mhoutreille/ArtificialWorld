package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.tableModel.HumanTableModel;
import object.entity.human.Human;
import utils.HumanProxy;

public class HumanPanel extends JPanel implements Runnable, MouseListener {



	JTextField humanPopulationField = new JTextField(20);
	JTextField humanDeadPopulationField = new JTextField(20);
	JTextField humanAlivePopulationField = new JTextField(20);
	
	JPanel mainInfoPanel = new JPanel();
	
	
	
	

	public HumanPanel() {
		
		
		
		
        JLabel label1 = new JLabel("Total Population : ");
        JLabel label2 = new JLabel("Total Dead  Population:");
        JLabel label3 = new JLabel("Total Alive Population:");
        
        setLayout(new BorderLayout());
        
        
       
        
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);
        
        gc.gridx = 0;
        gc.gridy = 0;
        mainInfoPanel.add(label1, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        mainInfoPanel.add(humanPopulationField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        mainInfoPanel.add(label2, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        mainInfoPanel.add(humanDeadPopulationField, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        mainInfoPanel.add(label3, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        mainInfoPanel.add(humanAlivePopulationField, gc);
        
        
        
        JPanel tablePanel = getTablePanel();
        add(mainInfoPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        
        
        
        new Thread(this).start();
        
        
	}
	
	public JPanel getTablePanel() {
		JPanel tablePanel = new JPanel();
		
		tablePanel.setLayout(new GridLayout(1,0));
		
		final JTable table = new JTable(new HumanTableModel());
		table.addMouseListener(this);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
		 //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
		
        
        tablePanel.add(scrollPane);
        
		return tablePanel;
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
			humanPopulationField.setText(HumanProxy.getList().size()+""); 
			humanDeadPopulationField.setText(HumanProxy.getDeadList().size()+"");
			humanAlivePopulationField.setText(HumanProxy.getAliveList().size()+"");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getSource() instanceof JTable)  {
			int selectedRow = ((JTable)arg0.getSource()).getSelectedRow();
			Human h = ((HumanTableModel)((JTable)arg0.getSource()).getModel()).getHumanAt(selectedRow);
		}
		
	}
	

	
	
}
