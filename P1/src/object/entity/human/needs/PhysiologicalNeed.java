package object.entity.human.needs;


import object.entity.element.Food;
import object.entity.element.Water;

public class PhysiologicalNeed extends DefaultNeed {

	public PhysiologicalNeed() {
		
		needsType.add(Water.class);
		needsType.add(Food.class);
		needsType.add(Sleep.class);
		needsType.add(Sex.class);
	
		for (Class class1 : needsType) {
			needsLevel.put(class1, 0.);
		}
	}
	
}
