package object.time;

import java.util.Date;

public abstract class Schedule implements TimeWindow {

	public Boolean InSchedule(Date time) {
		return isTimeToStart(time) && !isTimeToFinish(time);
	}

}
