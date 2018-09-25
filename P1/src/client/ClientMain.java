package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] zero) {
		
		Socket socket;
		 Object answer = "";
		try {
		
		     socket = new Socket(InetAddress.getLocalHost(),2009);	
	          
		     ObjectInputStream   in = new ObjectInputStream(socket.getInputStream());
		     ObjectOutputStream  out = new ObjectOutputStream(socket.getOutputStream());
		     
		     
		     out.writeObject("HW");
		     
		     try {
				Object response = in.readObject();
				System.out.println(response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
//		     while(!answer.equals(false)) {
//		    	 try {
//				//	answer = isr.readObject();
//					System.out.println(answer);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//		     }
		     
		     socket.close();

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
