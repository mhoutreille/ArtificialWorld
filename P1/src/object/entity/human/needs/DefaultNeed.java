package object.entity.human.needs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import object.entity.element.Food;
import object.entity.element.Water;

public class DefaultNeed implements Need {

	Double level = 0.;
	
	List<Class> needsType = new LinkedList<>(); 
	Map<Class, Double> needsLevel = new HashMap<Class, Double>();
	
	public DefaultNeed() {
		
	}
	
	
	
	@Override
	public Double getNeedLevel(HumanNeedable pNeed) {
		
		if(needsType.contains(pNeed.getClass())) {
			return needsLevel.get(pNeed.getClass());
		}
		
		return 0.;
	}
	
	
	public void feed(HumanNeedable pNeed) {
		
		if(needsType.contains(pNeed.getClass())) {
			needsLevel.put(pNeed.getClass(), getLevel(pNeed));
		}
		
	}
	
	
	
	// TO EXTERNALIZE
	/*
	 * (non-Javadoc)
	 * @see object.entity.human.needs.Need#getLevel(object.entity.human.needs.HumanNeedable)
	 * 
	 * Return the level of feeding for a given need
	 * 
	 */
	public Double getLevel(HumanNeedable pNeed) {
		return 1.;
	}
	
	/*
	 * (non-Javadoc)
	 * @see object.entity.human.needs.Need#getFeedImportance(object.entity.human.needs.HumanNeedable)
	 * 
	 * return prevalence of the feed e.g water is more important than food
	 */
	public Integer getFeedImportance(HumanNeedable pNeed) {
		if(needsType.contains(pNeed.getClass())) {
			return needsType.indexOf(pNeed);
		}
		return 0;
	}
	
	
	
	public Double ERF(double z, int precision) {
		/*Double term1 = 2./Math.sqrt(Math.PI);
		
		Double serieTerm = 0.;
		
		for(int i = 0; i <= precision; i++) {
			serieTerm =  serieTerm + (Math.pow(-1., i) * Math.pow(z, 2 * i + 1))   /((2*i + 1) * factorial(i)) ;
		}
		
		return term1 * serieTerm;*/
		
		//Math.pow(1.3, 2)
		
		Double n =  1-  Math.exp(Math.pow(-1.9, 1.3));
				
		return n;
				
				
		
	}
	
	
	
	public Integer factorial(int n) {
		
		
		if(n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}

}
