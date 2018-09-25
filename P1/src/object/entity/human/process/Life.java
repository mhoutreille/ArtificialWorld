package object.entity.human.process;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import authority.Law;
import event.Event;
import object.entity.human.Human;
import utils.HumanProxy;
import utils.WorldProxy;

public class Life implements Runnable {


	private Human human = null;
	private Boolean over = false;
	private Runnable loveThread = null;
	
	
	Map<String, Event> events = new TreeMap<String, Event>();
	
	
	 public Life(Human human) {
		 
		 this.human = human;
		 
		 Thread t = new Thread(this);
		 t.setName(human + "'s Life");
		 t.start();
	 }
	
	
	
	@Override
	public void run() {
		events.put(Event.BIRTH,  new Event(WorldProxy.currentWorld.getTimeProcess().getCurrentDate(), null));
		HumanProxy.newBorn(human);
		
		
		while(!getOver() && isAlive()) {
			try {
				//feed life events here
				findLove();
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				setOver(true);
			}
		}
		
		setOver(true);
	}
	
	
	
	public Boolean isAlive() {
		if(getAge() > getNaturalMaxAge()  ) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public Integer getNaturalMaxAge() {
		return 5;
	}
	
	


	public Integer getAge() {
		

		Date birthDate =  events.get(Event.BIRTH).getDate();
		Date currentDate = WorldProxy.currentWorld.getTimeProcess().getCurrentDate();
		
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(currentDate);
		
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.setTime(birthDate);
		
		return gc.get(Calendar.YEAR) - gc2.get(Calendar.YEAR);
		
	}
	
	
	private synchronized void findLove() {
		
		if(human.getCompanion() == null) {
			List<Human> hList = HumanProxy.getAliveList();
			
			for (Human h : hList) {
				if(!h.equals(human) && h.getCompanion() == null){ // if not himself and the prospect is single
					if(h.getLife().getAge() >= Law.minMarriageLegalAge) {
						if(!h.getGenre().equals(human.getGenre())) {
							synchronized (human) {
								synchronized (h) {
									loveThread = new DefaultLoveThread(human, h);
								}
							}
						}
					}
				}						
			}
		}
	}
	
	
	public Boolean getOver() {
		return over;
	}

	public void setOver(Boolean over) {
		this.over = over;
		events.put(Event.DEATH,  new Event(WorldProxy.currentWorld.getTimeProcess().getCurrentDate(), null));
	}
	
	public Date getBirthDate() {
		return events.get(Event.BIRTH).getDate();
	}
	
	public Date getDeathDate() {
		return events.get(Event.DEATH).getDate();
	}



	public Runnable getLoveThread() {
		return loveThread;
	}



	public void setLoveThread(Runnable loveThread) {
		this.loveThread = loveThread;
	}

}
