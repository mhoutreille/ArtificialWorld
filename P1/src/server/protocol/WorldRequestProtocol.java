package server.protocol;

import utils.WorldProxy;

public class WorldRequestProtocol implements Protocol {

	@Override
	public Object processInput(String input) throws Exception {
		
		if(input.toUpperCase().equalsIgnoreCase("HELLO WORLD")) {
			return "HELLO HUMAN";
		} else if(input.toUpperCase().equalsIgnoreCase("CREATE NEW WORLD")) {
			
			WorldProxy.createNewWorld();
			
			return "WORLD CREATED";
		} else if(input.toUpperCase().equalsIgnoreCase("CREATE NEW HUMAN")) {
			
			WorldProxy.createHuman();
			
			return "HUMAN CREATED";
		} else if(input.toUpperCase().equalsIgnoreCase("GET WORLD")) {

			return WorldProxy.currentWorld;
		}
		
		
		return "BYE";
	}

	
	
	
	
}
