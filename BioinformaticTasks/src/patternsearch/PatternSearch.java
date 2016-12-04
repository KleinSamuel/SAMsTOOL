package patternsearch;

import java.util.ArrayList;

/**
 * This is the abstract class for different methods of searching a pattern string
 * in a text string.
 *
 * ACAB - All Codes Are Beautiful ;)
 *
 * @author Samuel Klein
 * @author Paul Hager
 *
 */
public abstract class PatternSearch {

	public PatternSearchReturnObject findPattern(char[] text, char[] pattern){
		return null;
	}

	/**
	 * The Object which is returned.
	 * Contains several information about the possible occurrences
	 * of a searched pattern string in a text string.
	 */
	public class PatternSearchReturnObject {

		private ArrayList<Integer> startingPositions;
		private ArrayList<Integer> comparisonCounter;

		public PatternSearchReturnObject(){
			this.startingPositions = new ArrayList<Integer>();
			this.comparisonCounter = new ArrayList<Integer>();
		}

		public ArrayList<Integer> getStartingPositions() {
			return startingPositions;
		}

		public ArrayList<Integer> getComparisonCounter() {
			return comparisonCounter;
		}

		public void setStartingPositions(ArrayList<Integer> startingPositions) {
			this.startingPositions = startingPositions;
		}

		public void addPosition(int pos, int comparisons){
			this.startingPositions.add(pos);
			this.comparisonCounter.add(comparisons);
		}
	}
}
