package object.entity.human.needs;

import java.util.List;

public class MaslowPyramid {

	private List<Need> pyramidLevels;
	
	
	public MaslowPyramid() {
		pyramidLevels.add(new PhysiologicalNeed());
		pyramidLevels.add(new SecurityNeed());
	}
	
	
	
}
