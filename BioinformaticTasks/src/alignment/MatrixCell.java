package alignment;

public class MatrixCell {

	private boolean UP;
	private boolean LEFT;
	private boolean UPLEFT;
	private int VALUE;
	
	public MatrixCell(int value, boolean up, boolean left, boolean upleft){
		this.UP = up;
		this.LEFT = left;
		this.UPLEFT = upleft;
		this.VALUE = value;
	}

	public MatrixCell setUp(boolean up){
		this.UP = up;
		return this;
	}
	
	public boolean isUP() {
		return this.UP;
	}
	
	public MatrixCell setLeft(boolean left){
		this.LEFT = left;
		return this;
	}

	public boolean isLEFT() {
		return this.LEFT;
	}

	public MatrixCell setUpLeft(boolean upleft){
		this.UPLEFT = upleft;
		return this;
	}
	
	public boolean isUPLEFT() {
		return this.UPLEFT;
	}
	
	public MatrixCell setValue(int value){
		this.VALUE = value;
		return this;
	}
	
	public int getValue(){
		return this.VALUE;
	}
}
