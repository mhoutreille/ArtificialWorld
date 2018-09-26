package object.entity.human.needs;

public interface Need {

	public Double getNeedLevel(String o);
	public Double getLevel(HumanNeedable pNeed);
	public Integer getFeedImportance(HumanNeedable pNeed);
	
}
