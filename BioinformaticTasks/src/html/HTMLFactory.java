package html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import plot.BarPlot;

public class HTMLFactory {

	public static void test(){
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("/home/sam/Desktop/HTML/ChartTests/test.html"));
			
			bw.write("<!DOCTYPE html>\n");
			bw.write("<html lang=\"en\">\n");
		
			bw.write("<head>\n");
			bw.write("\t<meta charset=\"utf-8\">\n");
			bw.write("\t<title></title>\n");
			bw.write("</head>\n");
			
			bw.write("<body>\n");
			
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
			
			bw.write(bp.createBarplotJS());
			
			bw.write("</body>\n");
			bw.write("</html>");
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
