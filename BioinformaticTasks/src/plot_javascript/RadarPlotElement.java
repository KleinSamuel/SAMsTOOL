package plot_javascript;

import java.util.ArrayList;

public class RadarPlotElement {

	private String name;
	private ArrayList<Double> data;
	
	public RadarPlotElement(String name){
		this.name = name;
		data = new ArrayList<>();
	}
	
	public void addData(double d){
		this.data.add(d);
	}
	
	public ArrayList<Double> getData(){
		return this.data;
	}
	
	public String getName(){
		return this.name;
	}
	
}
