package html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javafx.util.Pair;
import plot.BarPlot;
import plot.JavascriptPlot;
import plot.Line;
import plot.LinePlot;

/**
 * Create a HTML file.
 * 
 * @author Samuel Klein
 */
public class HTMLFactory {
	
	public static void writeHtmlFile(String filepath){
		
		BarPlot bp = new BarPlot();
		
		bp.title = "MY FIRST BARPLOT IN JAVASCRIPT";
		bp.width = 500;
		bp.height = 500;
		bp.minY = 0;
		bp.chartID = "chart";
		bp.barWidth = 0.5;
		bp.colors = new String[]{"#89AFD2"};
		bp.yAxis = new Object[]{28,28,21,20,19};
		bp.xAxis = new Object[]{"MCI","MUN","ARS","TOT","NEW"};
		bp.showHorizontalLines = false;
		bp.showVerticalLines = false;
		
		Vector<Pair<Object, Object>> v1 = new Vector<>();
		Vector<Pair<Object, Object>> v2 = new Vector<>();
		Vector<Pair<Object, Object>> v3 = new Vector<>();
		for (int i = 0; i <= 200; i++) {
			v1.add(new Pair<Object, Object>(i, i));
			v2.add(new Pair<Object, Object>(i, i*2));
			v3.add(new Pair<Object, Object>(i, i*3));
		}
		
		Line l1 = new Line().setData(v1).setLabel("First Line");
		Line l2 = new Line().setData(v2).setLabel("Second Line");
		Line l3 = new Line().setData(v3).setLabel("Third Line");
		
		ArrayList<Line> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		LinePlot lp = new LinePlot();
		lp.title = "Das the first LinePlot";
		lp.width = 500;
		lp.height = 500;
		lp.chartID = "lpChart";
		lp.lines = list;
		lp.showVerticalLines = false;
		lp.showHorizontalLines = false;
		lp.minY = 0;
		lp.maxY = 3*200;
		lp.minX = 0;
		lp.maxX = 200;
		
		HTML_File f = new HTML_File("FIRST PLOTS");
		f.addCodeToBody(JavascriptPlot.getFlotrLine());
		
		f.addCodeToBody(bp.createBarplotJS());
		f.addCodeToBody(lp.createBarplotJS());
		
		f.addEndTags();
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			bw.write(f.getSourceCode());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
