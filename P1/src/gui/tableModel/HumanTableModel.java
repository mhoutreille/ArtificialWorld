package gui.tableModel;

import javax.swing.table.DefaultTableModel;

import object.entity.human.Human;
import utils.HumanProxy;

public class HumanTableModel extends DefaultTableModel {

	
	 String columnNames[] = null;
	
	
	 public HumanTableModel() {
		 columnNames = new String[]{"First Name", "Last Name", "Birthdate" , "Single", "Age", "Death"};
	 }
	 
	 
	 public String getColumnName(int col) {
	        return columnNames[col].toString();
	 }
	 
	 
    public int getRowCount() { 
    	return HumanProxy.getList().size(); 
    }
    
    
    public int getColumnCount() { 
    	return 6; 
    }
    
    
    public Human getHumanAt(int row) {
    	return HumanProxy.getList().get(row);
    }
    
    public Object getValueAt(int row, int col) {
    	
    	Human h = HumanProxy.getList().get(row);
    	
    	if(col == 0) {
    		return h.getFirstName();
    	}
    	
    	if(col == 1) {
    		return h.getLastName();
    	}
    	
    	if(col == 2) {
    		return h.getLife().getBirthDate();
    	}
    	
    	if(col == 3) {
    		return h.getCompanion() == null ? "Y" : "N [" + h.getCompanion()+"]";
    	}
    	
    	if(col == 4) {
    		return h.getLife().getAge();
    	}
    			
    	
    	if(col == 5 && h.getLife().getOver()) {
    		return h.getLife().getDeathDate();
    	}
    	
    	return "";
    	
    }
    
    public boolean isCellEditable(int row, int col)
        { return false; }
    
    
//    public void setValueAt(Object value, int row, int col) {
//        rowData[row][col] = value;
//        fireTableCellUpdated(row, col);
//    }
	
	
}
