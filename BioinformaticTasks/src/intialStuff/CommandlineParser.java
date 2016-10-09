package intialStuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import debugStuff.DebugMessageFactory;

/**
 * This is used to parse command line arguments.
 * 
 * @author Samuel Klein
 */
public class CommandlineParser {

	private HashMap<String, Object> argumentMap;
	private boolean debugMode = false;
	
	/**
	 * 1) Add argument classifier with addExpectedArgument()
	 * 2) Extract the argument list  with extractArguments()
	 * 
	 * @param debugMode
	 */
	public CommandlineParser(boolean debugMode){
		resetParameterMap();
		this.debugMode = debugMode;
	}
	
	/**
	 * Clear the parameter map
	 */
	private void resetParameterMap(){
		this.argumentMap = new HashMap<String, Object>();
	}
	
	/**
	 * Add argument classifier into argument map
	 * @param argAbbreviations String[] of argument abbreviations
	 */
	private void addExpectedArgument(String[] argAbbreviations){
		for (int i = 0; i < argAbbreviations.length; i++) {
			addExpectedArgument(argAbbreviations[i]);
		}
	}
	
	/**
	 * Add argument classifier into argument map
	 * @param argAbbreviation String argument abbreviation
	 */
	private void addExpectedArgument(String argAbbreviation){
		if(!argumentMap.containsKey(argAbbreviation)){
			argumentMap.put(argAbbreviation, null);
			DebugMessageFactory.printNormalDebugMessage(debugMode, "Added "+argAbbreviation+" to map");
		}else{
			DebugMessageFactory.printNormalDebugMessage(debugMode, argAbbreviation+" already exists in map");
		}
	}
	
	/**
	 * Traverse the original argument map and put respective arguments into map
	 * @param argumentList String[] of original arguments
	 */
	private void extractArguments(String[] argumentList){
		for (int i = 0; i < argumentList.length; i+=2) {
			if(argumentMap.containsKey(argumentList[i])){
				argumentMap.put(argumentList[i], argumentList[i+1]);
			}
		}
	}
	
	/**
	 * Print the argument map
	 */
	private void printMap(){
		System.out.println("MAP SIZE: "+argumentMap.size());
		for(Entry<String, Object> entry : argumentMap.entrySet()){
			System.out.println("[  KEY  ]"+entry.getKey());
			System.out.println("[ VALUE ]"+entry.getValue());
		}
	}
	
	/**
	 * Get argument map
	 * @return argumentMap HashMap<String, Object>
	 */
	private HashMap<String, Object> getArgumentMap(){
		return this.argumentMap;
	}
	
}
