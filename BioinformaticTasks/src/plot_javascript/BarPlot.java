package plot_javascript;

public class BarPlot {

	public int width = 100;
	public int height = 100;
	public int minY = 0;

	public String title = "default title";
	public String chartID = "chart";
	
	public String[] colors = new String[]{"#0f0f0f"};
	
	public double barWidth = 1;
	
	public boolean showVerticalLines = false;
	public boolean showHorizontalLines = false;
	
	public Object[] yAxis;
	public Object[] xAxis;
	
	public String createBarplotJS(){
		String out = "";
		
		out += "\t<div id=\""+chartID+"\" style=\"width:"+width+"px;height:"+height+"px\"></div>\n";
		out += "\t<script>\n";
		
		out += "\t\tvar xaxis = [";
		for (int i = 0; i < xAxis.length-1; i++) {
			out += "["+i+",\""+xAxis[i]+"\"],";
		}
		out += "["+(xAxis.length-1)+",\""+xAxis[(xAxis.length-1)]+"\"]";
		out += "];\n";
		
		out += "\t\tvar yaxis = [";
		for (int i = 0; i < yAxis.length-1; i++) {
			out += "[["+i+","+yAxis[i]+"]],";
		}
		out += "[["+(yAxis.length-1)+","+yAxis[(yAxis.length-1)]+"]]";
		out += "];\n\n";
		
		out += "Flotr.draw(document.getElementById(\""+chartID+"\"), yaxis, {\n";
		
		out += "\t\t\ttitle: \""+title+"\",\n";
		out += "\t\t\tcolors: [";
		for (int i = 0; i < colors.length-1; i++) {
			out += "\""+colors[i]+"\",";
		}
		out += "\""+colors[colors.length-1]+"\"],\n";
		
		out += "\t\t\tbars: {\n";
		out += "\t\t\t\tshow: true,\n";
		out += "\t\t\t\tbarWidth: "+barWidth+",\n";
		out += "\t\t\t\tshadowSize: 0,\n";
		out += "\t\t\t\tfillOpacity: 1,\n";
		out += "\t\t\t\tlineWidth: 0,\n\t\t\t},\n";
		
		out += "\t\t\tyaxis: {\n";
		out += "\t\t\t\tmin: "+minY+",\n";
		out += "\t\t\t\ttickDecimals: 0\n\t\t\t},\n";
		
		out += "\t\t\txaxis: {\n";
		out += "\t\t\t\tticks: xaxis\n\t\t\t},\n";
		
		out += "\t\t\tgrid: {\n";
		out += "\t\t\t\thorizontalLines: "+showHorizontalLines+",\n";
		out += "\t\t\t\tverticalLines: "+showVerticalLines+"\n\t\t\t}\n";
		
		out += "\t\t\t});\n\t</script>\n";
		return out;
	}

}
