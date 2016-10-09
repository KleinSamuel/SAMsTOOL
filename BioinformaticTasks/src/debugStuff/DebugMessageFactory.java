package debugStuff;
import dateNtimeStuff.DateFactory;

/**
 * Containing debug stuff as printing out messages and statuses.
 * 
 * @author Samuel Klein
 */
public class DebugMessageFactory {
	
	/**
	 * Print out a normal debug message containing date and time.
	 * 
	 * @param message to be printed out
	 */
	public static void printNormalDebugMessage(String message){
		System.out.println("[  "+"OK"+"   ] "+"("+DateFactory.getDateAsString()+"):\t"+message);
	}
	
	/**
	 * Print out a error debug message containing date and time.
	 * 
	 * @param message to be printed out
	 */
	public static void printErrorDebugMessage(String message){
		System.out.println("[ "+"ERROR"+" ] "+"("+DateFactory.getDateAsString()+"):\t"+message);
	}
	
}
