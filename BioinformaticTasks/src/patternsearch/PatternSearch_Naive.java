package patternsearch;

public class PatternSearch_Naive extends PatternSearch{

	/**
	 * The naive Algorithm which finds all occurrences of a pattern string
	 * in a text string.
	 *
	 * @param text to search in as char[]
	 * @param target searched string as char[]
	 * @return ReturnObject
	 */
	public PatternSearchReturnObject findPattern(char[] text, char[] target){

		PatternSearchReturnObject retObj = new PatternSearchReturnObject();
		int comparisonCounter = 0;
		boolean flag = true;

		for (int i = 0; i < text.length-target.length+1; i++) {
			int j = 0;
			while(text[i+j] == target[j]){
				j++;
				comparisonCounter++;
				if(j == target.length){
					retObj.addPosition(i, comparisonCounter);
					flag = false;
					break;
				}
			}
			if(flag){
				comparisonCounter++;				
			}
			flag = true;
		}
		return retObj;
	}

}
