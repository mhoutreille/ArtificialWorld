package client;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.MainFrame;
import object.entity.human.Human;
import object.world.World;
import utils.WorldProxy;


public class Main {

	
	public static WorldProxy wProxy;
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        MainFrame frame = new MainFrame();
        frame.pack();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		
//		PhysiologicalNeed p = new PhysiologicalNeed();
//		
//		Double erf = p.ERF(1., 7);
		
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		        UIManager.put("swing.boldMetal", Boolean.FALSE);
		        createAndShowGUI();
            }
        });
		
		World w1 = new World();
		wProxy.setCurrentWorld(w1); 
		
		
		Human H1 = new Human("Mathieu", "Houtreille", "M");
		Human H2 = new Human("Laura", "Lopez", "F");
		
		
		

		
	}

}
