package object.world;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import object.entity.human.Human;
import object.world.processes.WorldTimeProcess;

public class World implements Serializable {

	
	String name = null;
	ConcurrentHashMap<Integer, Human> worldPopulation = new ConcurrentHashMap();
	WorldTimeProcess timeProcess = null;

	
	

	public World() {
		this.name  = "World";
		timeProcess = new WorldTimeProcess();
		new Thread(timeProcess).start();
	}
	
	
	public void addHumanToWorld(Human human) {
		worldPopulation.put(worldPopulation.size()+1, human);
	}
	
	public int getTotalWorldPopulation() {
		return worldPopulation.size();
	}
	
	
	public Date getCurrentDate() {
		return timeProcess.getCurrentDate();
	}
	
	public WorldTimeProcess getTimeProcess() {
		return timeProcess;
	}


	public void setTimeProcess(WorldTimeProcess timeProcess) {
		this.timeProcess = timeProcess;
	}


	
	
}
