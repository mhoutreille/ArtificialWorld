package event;

import java.util.Date;

public class Event {

	
	public static String BIRTH = "BIRTH_EVENT";
	public static String DEATH = "DEATH_EVENT";
	
	
	private Date date;
	private String description;
	
	public Event(Date date, String description) {
		this.date = date;
		this.description = description;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}

	
}
