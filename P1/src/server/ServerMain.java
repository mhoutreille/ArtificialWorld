package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	public static void main(String[] zero) {
		
		ServerSocket socket = null ;
		Socket socketduserveur  = null;
		ObjectInputStream isr = null;
		
		try {
		
			socket = new ServerSocket(2009);
			
			while(true) {
				socketduserveur = socket.accept(); 
				isr = new ObjectInputStream(socketduserveur.getInputStream());
				
				
				try {
					Object query = isr.readObject();
					
					if(query.equals("HW")) {
						HelloWorldServer task = new HelloWorldServer(socketduserveur);
						task.start();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				
				
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			 try {
				 socket.close();
				socketduserveur.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
