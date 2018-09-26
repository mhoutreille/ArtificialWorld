package object.entity.human.needs;


import object.entity.element.Home;
import object.entity.element.Security;

public class SecurityNeed extends DefaultNeed {

	public SecurityNeed() {
		
		needsType.add(Home.class);
		needsType.add(Security.class);
		
		for (Class class1 : needsType) {
			needsLevel.put(class1, 0.);
		}
	}
	
}
