package utils;

import java.util.LinkedList;
import java.util.List;

import object.entity.human.Human;

public class HumanProxy {

	private static List<Human> list = new LinkedList<>();
	
	
	
	public static List<Human> getDeadList() {
		
		List dead = new LinkedList<>();
		
		
		for (Human h : list) {
			if(h.getLife().getOver()) {
				dead.add(h);
			}
		}
		
		return dead;
		
	}
	
	
	public static List<Human> getAliveList() {
		
		List alives = new LinkedList<>();
		List deads = getDeadList();
		
		for (Human h : list) {
			if(!deads.contains(h)) {
				alives.add(h);
			}
		}
		
		return alives;
	}


	public static List<Human> getList() {
		return list;
	}


	public void setList(List<Human> list) {
		this.list = list;
	}
	
	public static void  newBorn(Human human) {
		list.add(human);
	}
	
	
}
