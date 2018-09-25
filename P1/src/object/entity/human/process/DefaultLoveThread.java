package object.entity.human.process;

import object.entity.human.Human;

public class DefaultLoveThread implements Runnable {

	
	
	boolean isLove = false;
	Human h1 = null;
	Human h2 = null;
	
	public DefaultLoveThread(Human h1, Human h2) {
		this.h1 = h1;
		this.h2 = h2;
		isLove = true;
		h1.setCompanion(h2);
		h2.setCompanion(h1);
		
		
		Thread t = new Thread(this);
		t.setName("Love Relationship " + h1 + " " + h2);
		t.start();
	}
	
	
	@Override
	public void run() {
		
		while(isLove && !h1.getLife().getOver() && !h2.getLife().getOver()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		h1.setCompanion(null);
		h2.setCompanion(null);
		isLove = false;
		
	}

}
