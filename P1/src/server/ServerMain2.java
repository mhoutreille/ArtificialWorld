package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import server.protocol.WorldRequestProtocol;

public class ServerMain2 {

	
	public static void main(String[] zero) {
		 try {
			ServerSocket serverSocket 	= new ServerSocket(2016);
			Socket clientSocket 		= serverSocket.accept();
			
			//Receive a connection
			ObjectOutputStream out 			= new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in            = new ObjectInputStream(clientSocket.getInputStream());
			Object inputLine = "";
			
			//Read from client
			
			WorldRequestProtocol wrp = new WorldRequestProtocol();
			
			try {
				while (( inputLine = in.readObject()) != null) {
					
					out.writeObject(wrp.processInput((String)inputLine));
					
					
					
					
					/*try {
						serverResponse = (String)wrp.processInput(inputLine);
						out.write(serverResponse);
						out.flush();
						
						if (serverResponse.equals("BYE")) {
							break;
						}
							 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						serverSocket.close();
					}*/
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				serverSocket.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
