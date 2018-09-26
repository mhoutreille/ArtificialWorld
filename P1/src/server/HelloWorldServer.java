package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import object.entity.human.Human;

public class HelloWorldServer extends Thread {

	Socket socketduserveur = null;
	
	public HelloWorldServer(Socket socketduserveur) {
		this.socketduserveur = socketduserveur;
	}
	
	@Override
	public void run() {

		
		 Human h = new Human();
		
		
		 ObjectOutputStream  out = null;
		
		while(true) {
			
			
			try {
				out = new ObjectOutputStream(socketduserveur.getOutputStream());
				
				for(int i = 0; i <= 10; i++) {
					out.writeObject(h);
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				    out.flush();
				}
				
				out.writeObject(false);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
