package plot;

import java.util.Vector;

import javafx.util.Pair;

/**
 * Line Object for a LinePlot in Javascript's Flotr2
 * 
 * @author Samuel Klein
 */
public class Line {

	private String label = "Another Nameless Line";
	private Vector<Pair<Object, Object>> data;
	private String colorHexCode = "#000000";
	private int lineWidth = 1;
	private int shadowSize = 0;
	
	public Line setLabel(String s){
		this.label = s;
		return this;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public Line setData(Vector<Pair<Object, Object>> data){
		this.data = data;
		return this;
	}
	
	public Vector<Pair<Object, Object>> getData(){
		return this.data;
	}
	
	public Line setColor(String hexCode){
		this.colorHexCode = hexCode;
		return this;
	}
	
	public String getColor(){
		return this.colorHexCode;
	}
	
	public Line setLineWidth(int w){
		this.lineWidth = w;
		return this;
	}
	
	public int getLineWidth(){
		return this.lineWidth;
	}
	
	public Line setShadow(boolean flag){
		this.shadowSize = (flag) ? 1 : 0;
		return this;
	}
	
	public int getShadowSize(){
		return this.shadowSize;
	}
}