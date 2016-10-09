package intialStuff;

import java.util.HashMap;

/**
 * This is used to parse command line arguments.
 * 
 * @author Samuel Klein
 *
 */
public class CommandlineParser {

	private HashMap<String, Object> parameterMap;
	private boolean debugMode = false;
	
	public CommandlineParser(boolean debugMode){
		parameterMap = new HashMap<String, Object>();
		this.debugMode = debugMode;
	}
	
	private void addExpectedParameter(String paramAbbreviation){
		
		if(parameterMap.containsKey(paramAbbreviation)){
			parameterMap.put(paramAbbreviation, null);
			
			if(debugMode){
			}
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
}
