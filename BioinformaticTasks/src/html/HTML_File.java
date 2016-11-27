package html;

/**
 * Create the SourceCode for a HTML file.
 * Need to close tags with addEndTags() at last.
 * 
 * @author Samuel Klein
 */
public class HTML_File {

	private String mainString = "";
	
	public HTML_File(String title){
		mainString += "<!DOCTYPE html>\n";
		mainString += "<html lang=\"en\">\n";
		mainString += "<head>\n";
		mainString += "\t<meta charset=\"utf-8\">\n";
		mainString += "\t<title>"+title+"</title>\n";
		mainString += "</head>\n";
		mainString += "<body>\n";
	}
	
	public void addEndTags(){
		mainString += "</body>\n";
		mainString += "</html>";
	}
	
	public void addCodeToBody(String code){
		mainString += code+"\n";
	}
	
	public String getSourceCode(){
		return this.mainString;
	}
}
