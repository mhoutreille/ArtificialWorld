package utils;
import java.util.Calendar;
import java.util.Date;

import object.entity.human.Human;
import object.world.World;


public class WorldProxy {

	public static World currentWorld;
	
	
	


	


	public static World createNewWorld() {
		currentWorld = new World();
		return currentWorld;
	}
	
	
	public static Human createHuman() {
		Human h = new Human();
		currentWorld.addHumanToWorld(h);
		return h;
	}
	
	
	public static Date getCutOffTime(Date dateObject, Integer day) {
		
		
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(dateObject);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		if(day != null) {
			cal.set(Calendar.DAY_OF_MONTH, day);
		}
		
		return cal.getTime();
		
	}
	
	public static void setCurrentWorld(World currentWorld) {
		WorldProxy.currentWorld = currentWorld;
	}
	
	public static World getCurrentWorld() {
		return currentWorld;
	}
	
	
	
	
}
