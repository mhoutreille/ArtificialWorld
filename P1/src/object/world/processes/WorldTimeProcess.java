package object.world.processes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import object.time.GlobalTimeParameters;
import utils.WorldProxy;

public class WorldTimeProcess implements Runnable {

	Integer worldSpeedTimeFactor = 1;
	

	Date currentDate = new Date();
	
	@Override
	public void run() {
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(WorldProxy.getCutOffTime(currentDate, null));
		GlobalTimeParameters.gmtPlus1Time = cal.getTime();
		
		while(true) {
			cal.add(Calendar.MINUTE, 15 * worldSpeedTimeFactor);
			currentDate = cal.getTime();
			GlobalTimeParameters.gmtPlus1Time = cal.getTime();
			
			//System.out.println("Current Date in world : " + GlobalTimeParameters.gmtPlus1Time );
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public Integer getWorldSpeedTimeFactor() {
		return worldSpeedTimeFactor;
	}

	public void setWorldSpeedTimeFactor(Integer worldSpeedTimeFactor) {
		this.worldSpeedTimeFactor = worldSpeedTimeFactor;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
