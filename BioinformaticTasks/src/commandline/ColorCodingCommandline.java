package commandline;

/**
 * Format a string to display it at a certain color in the linux shell.
 * 
 * @author Samuel Klein
 */
public class ColorCodingCommandline {

	public static String toRed(String s){
		return (char)27+"[31m"+s+(char)27+"[0m";
	}
	
	public static String toGreen(String s){
		return (char)27+"[32m"+s+(char)27+"[0m";
	}
	
	public static String toYellow(String s){
		return (char)27+"[33m"+s+(char)27+"[0m";
	}
	
	public static String toBlue(String s){
		return (char)27+"[34m"+s+(char)27+"[0m";
	}
	
	public static String toWhite(String s){
		return (char)27+"[37m"+s+(char)27+"[0m";
	}
	
	public static String toYellowBackground(String s){
		return (char)27+"[43m"+s+(char)27 +"[0m";
	}
	
}
