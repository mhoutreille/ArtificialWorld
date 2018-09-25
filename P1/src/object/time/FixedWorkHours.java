package object.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FixedWorkHours extends Schedule {

	private Integer startTimeH = 8;
	private Integer startTimeM = 30;
	
	private Integer endTimeH = 17;
	private Integer endTimeM = 0;
	
	private Boolean workOnWe = false;
	
	
	public FixedWorkHours(Integer startTimeH, Integer startTimeM, Integer endTimeH, Integer endTimeM, Boolean workOnWe) {
		this.startTimeH = startTimeH;
		this.startTimeM = startTimeM;
		this.endTimeH = endTimeH;
		this.endTimeM = endTimeM;
		this.workOnWe = workOnWe;
	}
	
	
	public Boolean isTimeToStart(Date time) {
		
		if(time != null) {
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(time); 
			
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int min = calendar.get(Calendar.MINUTE);
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			
			if(!workOnWe && (day == Calendar.SATURDAY || day == Calendar.SUNDAY)) {
				return false;
			}
			
			
			if(hour == startTimeH) {
				if(min >= startTimeM) {
					return true;
				}
			} else if(hour > startTimeH) {
				return true;
			}
		}
		
		
		return false;
	}

	public Boolean isTimeToFinish(Date time) {
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(time); 
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
	
		if(hour == endTimeH) {
			if(min >= endTimeM) {
				return true;
			}
		} else if(hour > endTimeH) {
			return true;
		}
		
		return false;
	}

}
