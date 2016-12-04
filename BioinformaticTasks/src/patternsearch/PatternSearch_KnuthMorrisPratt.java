package patternsearch;

public class PatternSearch_KnuthMorrisPratt extends PatternSearch {

	/**
	 * The KnuthMorrisPrattAlgorithm finds all occurrences of a pattern string
	 * in a text string using a border table.
	 *
	 * @param text to search in as char[]
	 * @param target searched string as char[]
	 * @return ReturnObject
	 */
	public PatternSearchReturnObject findPattern(char[] text, char[] target){

		PatternSearchReturnObject retObj = new PatternSearchReturnObject();

		int n = text.length;
		int m = target.length;

		int[] borderArray = compute_borders(new int[m+1], target);

		int i = 0;
		int j = 0;

		int comparisonCounter = 0;
		
		boolean flag = true;

		while(i <= n-m){
			
			flag = true;			
			
			while(text[i+j] == target[j]){
				j++;
				
				comparisonCounter += 1;
				
				if(j == m){
					retObj.addPosition(i, comparisonCounter);
					flag = false;
					break;
				}
			}

			if(flag){
				comparisonCounter += 1;					
			}
			
			i += j - borderArray[j];
			j = Math.max(0, borderArray[j]);
		
		}

		return retObj;
	}

	/**
	 * Computes the border table for the KMP Algorithm.
	 *
	 * @param borderArray empty integer array
	 * @param target searched string as char[]
	 * @return int[] border array
	 */
	public int[] compute_borders(int[] borderArray, char[] target){
		borderArray[0] = -1;
		borderArray[1] = 0;
		int i = borderArray[1];
		for (int j = 2; j <= target.length; j++) {
			while(i >= 0 && (target[i] != target[j-1])){
				i = borderArray[i];
			}
			i++;
			borderArray[j] = i;
		}
		
		return borderArray;
	}
}
