package object.entity.human.needs;

import java.util.LinkedList;
import java.util.List;

public class MaslowPyramid {

	private List<Need> pyramidLevels = new LinkedList<>();
	
	
	public MaslowPyramid() {
		pyramidLevels.add(new PhysiologicalNeed());
		pyramidLevels.add(new SecurityNeed());
	}


	public List<Need> getPyramidLevels() {
		return pyramidLevels;
	}


	public void setPyramidLevels(List<Need> pyramidLevels) {
		this.pyramidLevels = pyramidLevels;
	}
	
	
	
}
