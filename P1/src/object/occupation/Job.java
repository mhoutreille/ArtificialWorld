package object.occupation;

import java.io.Serializable;

public abstract class Job extends Thread implements Serializable{

	
	private Boolean terminated = false;
	private Boolean started    = false;
	
	public abstract Object work() throws Exception;
	public abstract Object getPayoff();
	public abstract Boolean isPayDay();
	
	@Override
	public void run() {
		try {
			work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean getTerminated() {
		return terminated;
	}

	public void setTerminated(Boolean terminated) {
		this.terminated = terminated;
	}
	
	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}
	
	
}
