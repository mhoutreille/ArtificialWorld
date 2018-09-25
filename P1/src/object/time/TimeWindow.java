package object.time;

import java.util.Date;

public interface TimeWindow {
	public Boolean isTimeToStart(Date time);
	public Boolean isTimeToFinish(Date time);
}
