package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import info.clearthought.layout.TableLayout;
import object.entity.human.needs.DefaultNeed;
import object.entity.human.needs.HumanNeedable;
import object.entity.human.needs.MaslowPyramid;
import object.entity.human.needs.Need;

public class MaslowPyramidPanel extends JPanel {



	JTextField humanPopulationField = new JTextField(20);
	JTextField humanDeadPopulationField = new JTextField(20);
	JTextField humanAlivePopulationField = new JTextField(20);
	
	JPanel mainInfoPanel = new JPanel();
	
	
	
	

	public MaslowPyramidPanel(MaslowPyramid pyramidToRepresent) {
		
		
		setLayout(new TableLayout(new double[][]{{TableLayout.FILL},{20,TableLayout.FILL,TableLayout.FILL,20,20}}));
		
		int x = 0;
		
		for (Need need : pyramidToRepresent.getPyramidLevels()) {
			add(getStagePanel(need),"0, "+x);x++;
		}
		
		
//		for (Need need : pyramidToRepresent.getPyramidLevels()) {
//			System.out.println(need.getClass().getName());
//			System.out.println("----------------------");
//			
////			for (iterable_type iterable_element : ((DefaultNeed)need).getNeedLevel(pNeed)) {
////				
////			}
//		}
		
		
		
        
        
	}
	
	private JPanel getStagePanel(Need need) {
		
		
		JPanel stagePanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		stagePanel.setLayout(flowLayout);
		
		String className1 = need.getClass().getName();
		stagePanel.add(new JLabel(className1.substring(className1.lastIndexOf(".")+1, className1.length())));
		stagePanel.add(new JLabel("			"));
		
		for (Class clazz : ((DefaultNeed)need).getNeedsType()) {
			
			String needClassName = clazz.getName();
			stagePanel.add(new JLabel(needClassName.substring(needClassName.lastIndexOf(".")+1, needClassName.length())));
			
			JTextField valueField = new JTextField();
			valueField.setText(  ((DefaultNeed)need).getNeedLevel(needClassName).toString()  );
			stagePanel.add(valueField);
		}
		
		
		
		
		return stagePanel;
		
	}
	
	

	
	
}
