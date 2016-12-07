package alignment;

import java.util.ArrayList;

import javafx.util.Pair;

/**
 * The Needleman-Wunsch algorithm is used for finding the best global alignment of two sequences.
 * 
 * @author Samuel Klein
 */
public class NeedlemanWunsch {

	public final int MATCH = 1;
	public final int MISMATCH = 0;
	public final int GAPPENALTY = -1;
	
	private String a;
	private String b;
	private MatrixCell[][] matrix;
	private ArrayList<Pair<String,String>> alignments;
	
	/**
	 * Compute the matrix to align two sequences.
	 * 
	 * @param firstSequence String
	 * @param secondSequence String
	 */
	private void computeMatrix(String a, String b){
		this.a = a;
		this.b = b;
		MatrixCell[][] matrix = new MatrixCell[b.length()+1][a.length()+1];
		
		/* initialize matrix */
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new MatrixCell(0, false, false, false);
			}
		}
		int penalty = 0;
		for (int i = 1; i < matrix.length; i++) {
			penalty += GAPPENALTY;
			matrix[i][0].setValue(penalty).setUp(true);
		}
		penalty = 0;
		for (int i = 1; i < matrix[0].length; i++) {
			penalty += GAPPENALTY;
			matrix[0][i].setValue(penalty).setLeft(true);
		}
		int upScore;
		int leftScore;
		int upLeftScore;
		/* fill matrix according to the 3 conditions */
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				upScore = matrix[i-1][j].getValue()+GAPPENALTY;
				leftScore = matrix[i][j-1].getValue()+GAPPENALTY;
				upLeftScore = (b.charAt(i-1) == a.charAt(j-1)) ? matrix[i-1][j-1].getValue()+MATCH : matrix[i-1][j-1].getValue()+MISMATCH;
				
				int max = Math.max(upScore, Math.max(leftScore, upLeftScore));
				
				if(max == upScore){
					matrix[i][j].setUp(true);
				}
				if(max == leftScore){
					matrix[i][j].setLeft(true);
				}
				if(max == upLeftScore){
					matrix[i][j].setUpLeft(true);
				}
				
				matrix[i][j].setValue(max);
			}
		}
		
		this.matrix = matrix;
	}
	
	private void doTraceback(){
		ArrayList<Pair<String,String>> alignments = new ArrayList<>();
		
		int i = matrix.length-1;
		int j = matrix[i].length-1;
		
		recursiveTraceback(i, j, "", "", alignments);
		
		this.alignments = alignments;
	}
	
	private void recursiveTraceback(int i, int j, String first, String second, ArrayList<Pair<String,String>> list){
		
		if(i == 0 && j == 0){
			list.add(new Pair<String, String>(new StringBuilder(first).reverse().toString(), new StringBuilder(second).reverse().toString()));
			return;
		}else{
			if(matrix[i][j].isUPLEFT()){
				recursiveTraceback(i-1, j-1, first += a.charAt(j-1), second += b.charAt(i-1), list);
			}
			if(matrix[i][j].isUP()){
				recursiveTraceback(i-1, j, first += "_", second += b.charAt(i-1), list);
			}
			if(matrix[i][j].isLEFT()){
				recursiveTraceback(i, j-1, first += a.charAt(j-1), second += "_", list);
			}
		}
	}
	
	/**
	 * Get the computed alignments as string with underscore for a gap.
	 * 
	 * @param firstSeq String
	 * @param secondSeq String
	 * @return ArrayList<Pair<String, String>> alignments
	 */
	public ArrayList<Pair<String, String>> getAlignments(String firstSeq, String secondSeq){
		computeMatrix(firstSeq, secondSeq);
		doTraceback();
		return this.alignments;
	}
	
	/**
	 * Get the distance score for the two aligned sequences.
	 * 
	 * @return int distance
	 */
	public int getDistanceScore(){
		return this.matrix[this.matrix.length-1][this.matrix[0].length-1].getValue();
	}
	
	/**
	 * Print the computed matrix.
	 * Used for debugging reasons.
	 */
	public void printMatrix(){
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				System.out.print(this.matrix[i][j].getValue()+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Print the computed alignments.
	 */
	public void printAlignments(){
		for(Pair<String, String> pair : this.alignments){
			System.out.println(pair.getKey());
			System.out.println(pair.getValue());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		NeedlemanWunsch nw = new NeedlemanWunsch();
		nw.getAlignments("BIERGARTEN", "STERNWARTE");
		nw.printAlignments();
		System.out.println(nw.getDistanceScore());
	}
}
