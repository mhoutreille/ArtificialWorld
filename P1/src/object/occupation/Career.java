package object.occupation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import object.world.World;

public class Career extends Thread implements Serializable{

	private String careerName = null;
	private Date startDate = null;
	private List<Job> previousJobs = null;
	private Job currentJob;
	private Boolean endCarrier = false;
	
	
	public Career(Job currentJob, String careerName) {
		setName("Carrer " + careerName);
		this.currentJob = currentJob;
		this.careerName = careerName;
	}
	
	public void run() {
		
		Double totalEarning = 0.;
		
		while(!endCarrier) {
			
			if(currentJob != null && !currentJob.getStarted() && !currentJob.getTerminated()) {
				currentJob.start();
				currentJob.setStarted(true);
			}
				
			if(currentJob.isPayDay()) {
				Double pay = (Double)currentJob.getPayoff();
				totalEarning += pay;
				System.out.println("Receive " + pay);
				System.out.println("Total : " + totalEarning);
			}
		
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
	
	
	
	
	
	
