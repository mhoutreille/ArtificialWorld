package object.occupation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import object.time.FixedWorkHours;
import object.time.GlobalTimeParameters;
import utils.WorldProxy;

public class DefaultJob extends Job {


	private FixedWorkHours workSchedule = new FixedWorkHours(8, 30, 17, 0, false);
	private JobWork jobwork;
	private String jobName;
	private List<Date> payDays = new LinkedList();
	
	public DefaultJob(String jobName) {
		this.jobName = jobName;
		setName(jobName);
	}
	
	
	@Override
	public Object work() throws Exception {
		
		while(!getTerminated()) {
			
			if(workSchedule != null && workSchedule.InSchedule(GlobalTimeParameters.gmtPlus1Time)) {
				System.out.println("Bosse...");
				
			} else {
				System.out.println("Bosse pas...");
			}
			
			TimeUnit.MILLISECONDS.sleep(100);
			
			
		}
		
		return null;
	}
	
	
	@Override
	public Boolean isPayDay() {
		
		GregorianCalendar cal  = new GregorianCalendar();
		cal.setTime(WorldProxy.currentWorld.getCurrentDate());
		
		Date firstDayOfMonth = WorldProxy.getCutOffTime(cal.getTime(),1);
		
		if(cal.get(Calendar.DAY_OF_MONTH) >= 1 && !payDays.contains(firstDayOfMonth)) {
			payDays.add(firstDayOfMonth);
			return true;
		}
		
		return false;
	}
	
	@Override
	public Object getPayoff() {
		return 1000.;
	}

}
