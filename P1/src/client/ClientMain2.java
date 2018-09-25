package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import object.world.World;

public class ClientMain2 {
	public static void main(String[] zero) {
		
		Socket socket = null;;	
		
		
		try {
			socket = new Socket(InetAddress.getLocalHost(),2016);	
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in   = new ObjectInputStream(socket.getInputStream());		   

		    String serverResponse = "";
		    
		   /* for (int i = 0; i < 10; i++) {
				
				try {
					out.writeObject("HELLO WORLD");
					String response = (String)in.readObject();
					System.out.println(response);
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		  
		    try {
			    out.writeObject("HELLO WORLD");
				String response = (String)in.readObject();
				TimeUnit.SECONDS.sleep(2);
				
				out.writeObject("CREATE NEW WORLD");
				response = (String)in.readObject();
				TimeUnit.SECONDS.sleep(2);
				
				out.writeObject("CREATE NEW HUMAN");
				response = (String)in.readObject();
				TimeUnit.SECONDS.sleep(2);
				
				
				out.writeObject("CREATE NEW HUMAN");
				response = (String)in.readObject();
				TimeUnit.SECONDS.sleep(2);
				
				out.writeObject("GET WORLD");
				World w1 = (World)in.readObject();
				System.out.println(w1.getTotalWorldPopulation());
				TimeUnit.SECONDS.sleep(2);
				
				out.writeObject("CREATE NEW HUMAN");
				response = (String)in.readObject();
				TimeUnit.SECONDS.sleep(2);
				
				
				out.writeObject("GET WORLD");
				World w2 = (World)in.readObject();
				System.out.println(w1.getTotalWorldPopulation());
				System.out.println(w2.getTotalWorldPopulation());
				
				
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		   /* out.writeObject("HELLO WORLD");
		   
		    try {
				String response = (String)in.readObject();
				System.out.println(response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		    
		    
		    
		   /* while (( serverResponse = in.readLine()) != null) {
		    	if(serverResponse.equals("BYE")) {
		    		break;
		    	}
		    	
		    	try {
					TimeUnit.SECONDS.sleep(2);
					
					out.println("HELLO WORLD");
					
					
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
		    	
		    	
		    	
		    }*/
		    
		    
		    
		    
		    
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
