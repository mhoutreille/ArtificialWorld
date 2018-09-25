package object.occupation;

public class JobWork extends Thread {

	String name;
	
	public JobWork(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name + " is WORKING");
	}

	
	
}
