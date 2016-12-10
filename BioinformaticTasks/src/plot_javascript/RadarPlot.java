package plot_javascript;

import java.util.ArrayList;

public class RadarPlot {

	public int width = 100;
	public int height = 100;

	public String title = "default title";
	public String chartID = "chart";
	
	public boolean showVerticalLines = false;
	public boolean showHorizontalLines = false;
	
	public ArrayList<String> dataList = new ArrayList<>();
	public ArrayList<String> idList = new ArrayList<>();
	public ArrayList<RadarPlotElement> elements = new ArrayList<>();
	
	public String createBarplotJS(){
		String out = "";
		
		out += "\t<div id=\""+chartID+"\" style=\"width:"+width+"px;height:"+height+"px\"></div>\n";
		out += "\t<script>\n";
		
		out += "\t\tvar labels = [";
		int cnt = 0;
		for(String s : dataList){
			out += "["+cnt+",\""+s+"\"]";
			out += (cnt< dataList.size()-1) ? "," : "];\n";
			cnt++;
		}
		
		out += "\t\tvar ref = {\n";
		int cnt2 = 0;
		for(String s : dataList){
			out += "\t\t\t"+s+": 0";
			out += (cnt2< dataList.size()-1) ? ",\n" : "\n\t\t};\n";
			cnt2++;
		}
		
		out += "\t\tvar elements = [\n";
		int c1 = 0;
		for(RadarPlotElement e : elements){
			ArrayList<Double> d = e.getData();
			out += "\t\t\t{\n";
			out += "\t\t\t\tid: \""+e.getName()+"\",\n";
			int c2 = 0;
			for(Double d2 : d){
				out += "\t\t\t\t"+dataList.get(c2)+": "+d2+"";
				out += (c2 < d.size()-1) ? ",\n" : "\n";
				c2++;
			}
			out += "\t\t\t}";
			out += (c1 < elements.size()-1) ? ",\n" : "\n";
			c1++;
		}
		out += "\t\t];\n";
		
		out += "\t\tvar get_element = function(id){\n";
		out += "\t\t\tfor(var i = 0; i < elements.length; i++){\n";
		out += "\t\t\t\tif(elements[i].id === id){\n";
		out += "\t\t\t\t\treturn elements[i];\n";
		out += "\t\t\t\t}\n";
		out += "\t\t\t}\n";
		out += "\t\t};\n";
		
		out += "\t\tvar get_data = function(id){\n";
		out += "\t\t\tvar obj = {}, i = 0;\n";
		out += "\t\t\tobj.label = id;\n";
		out += "\t\t\tobj.data = [];\n";
		out += "\t\t\tfor(var key in ref){\n";
		out += "\t\t\t\tobj.data.push([i, get_element(id)[key]]);\n";
		out += "\t\t\t\ti++;\n";
		out += "\t\t\t};\n";
		out += "\t\t\treturn obj;\n";
		out += "\t\t};\n";
		
		out += "\t\tFlotr.draw(document.getElementById(\""+chartID+"\"), \n";
		out += "\t\t\t[\n";
		cnt = 0;
		for(RadarPlotElement ele : elements){
			out += "\t\t\t\tget_data(\""+ele.getName()+"\")";
			out += (cnt < elements.size()-1) ? ",\n" : "\n";
			cnt++;
		}
		out += "\t\t\t],\n";
		out += "\t\t\t{\n";
		
		out += "\t\t\t\ttitle: \""+title+"\",\n";
		out += "\t\t\t\tradar: {\n";
		out += "\t\t\t\t\tshow: true\n";
		out += "\t\t\t\t},\n";
		out += "\t\t\t\tgrid: {\n";
		out += "\t\t\t\t\tcircular: true\n";
		out += "\t\t\t\t},\n";
		out += "\t\t\t\txaxis: {\n";
		out += "\t\t\t\t\tticks: labels\n";
		out += "\t\t\t\t},\n";
		out += "\t\t\t\tyaxis: {\n";
		out += "\t\t\t\t\tshowLabels: false,\n";
		out += "\t\t\t\t\tmin: 0,\n";
		out += "\t\t\t\t\tmax: 100\n";
		out += "\t\t\t\t}\n";
		
		out += "\t\t\t}\n";
		out += "\t\t);\n";
		out += "\t</script>\n";
		return out;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> labs = new ArrayList<>();
		labs.add("ONE");
		labs.add("TWO");
		labs.add("THREE");
		labs.add("FOUR");
		labs.add("FIVE");
		
		RadarPlotElement r1 = new RadarPlotElement("r1");
		RadarPlotElement r2 = new RadarPlotElement("r2");
		RadarPlotElement r3 = new RadarPlotElement("r3");
		for (int i = 0; i < labs.size(); i++) {
			r1.addData(i*1.0);
			r2.addData(i*1.0);
			r3.addData(i*1.0);
		}
		
		ArrayList<RadarPlotElement> elems = new ArrayList<>();
		elems.add(r1);
		elems.add(r2);
		elems.add(r3);
		
		RadarPlot rp = new RadarPlot();
		rp.chartID = "radarChart";
		rp.height = 500;
		rp.width = 500;
		rp.showHorizontalLines = false;
		rp.showVerticalLines = false;
		rp.dataList = labs;
		rp.elements = elems;
		
		System.out.println(rp.createBarplotJS());
	}
	
}
