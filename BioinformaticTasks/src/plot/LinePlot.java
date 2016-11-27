package plot;

import java.util.ArrayList;
import java.util.Vector;

import javafx.util.Pair;

public class LinePlot {

	public int width = 100;
	public int height = 100;
	public int minY = 0;
	public int maxY = 100;
	public int minX = 0;
	public int maxX = 100;

	public String title = "default title";
	public String chartID = "chart";
	
	public boolean showVerticalLines = false;
	public boolean showHorizontalLines = false;
	
	public ArrayList<Line> lines = new ArrayList<>();
	
	public String createBarplotJS(){
		
		String[] lineNamesInternal = new String[lines.size()];
		
		String out = "";
		
		out += "\t<div id=\""+chartID+"\" style=\"width:"+width+"px;height:"+height+"px\"></div>\n";
		out += "\t<script>\n";
		
		int cnt = 0;
		for(Line l : lines){
			lineNamesInternal[cnt] = String.valueOf(cnt);
			
			out += "\t\tvar "+("a"+String.valueOf(cnt))+" = [";
			for (int i = 0; i < l.getData().size()-1; i++) {
				Pair<Object, Object> entry = l.getData().get(i);
				out += "["+entry.getKey()+","+entry.getValue()+"],";
			}
			Pair<Object, Object> entry = l.getData().get(l.getData().size()-1);
			out += "["+entry.getKey()+","+entry.getValue()+"]";
			out += "];\n";
			
			cnt++;
		}

		out += "\t\tFlotr.draw(document.getElementById(\""+chartID+"\"), \n\t\t\t[\n";
		
		for (int i = 0; i < lineNamesInternal.length; i++) {
			Line l = lines.get(i);
			String name = lineNamesInternal[i];
			out += "\t\t\t\t{\n";
			out += "\t\t\t\t\tdata: a"+name+",\n";
			out += "\t\t\t\t\tlabel: \""+l.getLabel()+"\",\n";
			out += "\t\t\t\t\tlines: {\n";
			out += "\t\t\t\t\t\tshow: true,\n";
			out += "\t\t\t\t\t\tlineWidth: "+l.getLineWidth()+"\n";
			out += "\t\t\t\t\t},\n";
			out += "\t\t\t\t\tshadowSize: "+l.getShadowSize()+",\n";
			out += "\t\t\t\t\tcolor: \""+l.getColor()+"\"\n";
			out += "\t\t\t\t}";
			out += (i < lineNamesInternal.length-1) ? ",\n" : "\n";
		}
		out += "\t\t\t],\t{\n";
		
		out += "\t\t\t\t\ttitle: \""+title+"\",\n";
		out += "\t\t\t\t\tgrid: {\n";
		out += "\t\t\t\t\t\thorizontalLines: "+showHorizontalLines+",\n";
		out += "\t\t\t\t\t\tverticalLines: "+showVerticalLines+"\n";
		out += "\t\t\t\t\t},\n";
		out += "\t\t\t\t\tyaxis: {\n";
		out += "\t\t\t\t\t\tmin: "+minY+",\n";
		out += "\t\t\t\t\t\tmax: "+maxY+"\n";
		out += "\t\t\t\t\t},\n";
		out += "\t\t\t\t\txaxis: {\n";
		out += "\t\t\t\t\t\tmin: "+minX+",\n";
		out += "\t\t\t\t\t\tmax: "+maxX+"\n";
		out += "\t\t\t\t\t}\n";
		
		out += "\t\t\t\t}\n";
		out += "\t\t);\n";
		out += "\t</script>\n";
		
		return out;
	}

	
	public static void main(String[] args) {
		
		Vector<Pair<Object, Object>> v = new Vector<>();
		v.add(new Pair<Object, Object>(1, 1));
		
		Line l1 = new Line().setData(v);
		
		LinePlot lp = new LinePlot();
		lp.lines.add(l1);
		
		System.out.println(lp.createBarplotJS());
	}
}
