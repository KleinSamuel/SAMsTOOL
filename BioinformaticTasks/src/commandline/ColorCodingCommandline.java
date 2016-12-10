package commandline;

/**
 * Format a string to display it at a certain color in the linux shell.
 * 
 * @author Samuel Klein
 */
public class ColorCodingCommandline {

	public static String toBlack(String s){
		return (char)27+"[30m"+s+(char)27+"[0m";
	}
	
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
	
	public static String toMagenta(String s){
		return (char)27+"[35m"+s+(char)27+"[0m";
	}
	
	public static String toCyan(String s){
		return (char)27+"[36m"+s+(char)27+"[0m";
	}
	
	public static String toWhite(String s){
		return (char)27+"[37m"+s+(char)27+"[0m";
	}
	
	public static String toBlackBackground(String s){
		return (char)27+"[40m"+s+(char)27 +"[0m";
	}
	
	public static String toRedBackground(String s){
		return (char)27+"[41m"+s+(char)27 +"[0m";
	}
	
	public static String toGreenBackground(String s){
		return (char)27+"[42m"+s+(char)27 +"[0m";
	}
	
	public static String toYellowBackground(String s){
		return (char)27+"[43m"+s+(char)27 +"[0m";
	}
	
	public static String toBlueBackground(String s){
		return (char)27+"[44m"+s+(char)27 +"[0m";
	}
	
	public static String toMagentaBackground(String s){
		return (char)27+"[45m"+s+(char)27 +"[0m";
	}
	
	public static String toCyanBackground(String s){
		return (char)27+"[46m"+s+(char)27 +"[0m";
	}
	
	public static String toWhiteBackground(String s){
		return (char)27+"[47m"+s+(char)27 +"[0m";
	}
	
}
