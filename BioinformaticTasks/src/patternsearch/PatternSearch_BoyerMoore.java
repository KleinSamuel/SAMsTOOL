package patternsearch;

import java.util.HashMap;

public class PatternSearch_BoyerMoore extends PatternSearch {

	/**
	 * The BoyerMooreAlgorithm finds the first occurrence of a pattern string
	 * in a text string.
	 * Uses Strong Good Suffix Rule.
	 *
	 * @param text to search in as char[]
	 * @param target searched string as char[]
	 * @return ReturnObject
	 */
	public PatternSearchReturnObject findPattern(char[] text, char[] target){

		int textLength = text.length;
		int targetLength = target.length;
		int i = 0;
		int j = targetLength-1;
		int shiftValue = -1;

		PatternSearchReturnObject retObj = new PatternSearchReturnObject();

		int[] shiftTable = computeShiftTable(target, targetLength);

		int comparisonCounter = 0;
		
		boolean flag = true;

		HashMap<Character, int[]> shiftTable2 = computeShiftTableBadCharacter(target, targetLength);

		while(i <= (textLength-targetLength)){

			flag = true;

			while(text[i+j] == target[j]){
				
				comparisonCounter++;
				
				if(j==0){
					retObj.addPosition(i, comparisonCounter);
					flag = false;
					break;
				}
				j--;
			}
			
			if(flag){				
				comparisonCounter++;
			}else{
				i += shiftTable[0];
				j = targetLength-1;
				continue;
			}

			if(shiftTable2.containsKey(text[i+j])){
				shiftValue = shiftTable2.get(text[i+j])[j];
			}else{
				shiftValue = j;
			}
			
			i += Math.max(shiftTable[j], shiftValue);
			j = targetLength - 1;
		}

		return retObj;
	}

	/**
	 * Computes the good suffix shift table for the Boyer Moore Algorithm.
	 *
	 * @param target searched string as char[]
	 * @param targetLength length of target
	 * @return int[] shiftTable
	 */
	public int[] computeShiftTable(char[] target, int targetLength){

		int[] shiftTable = new int[targetLength+1];

		for (int i = 0; i <= targetLength; i++) {
			shiftTable[i] = targetLength;
		}

		int[] shiftTableSuffix = new int[targetLength+1];
		shiftTableSuffix[0] = -1;
		int i = 0;
		shiftTableSuffix[1] = 0;

		for (int j = 2; j <= targetLength; j++) {
			while(i >= 0 && target[targetLength-i-1] != target[targetLength-j]){
				shiftTable[targetLength-i-1] = Math.min(shiftTable[targetLength-i-1], j - i - 1);
				i = shiftTableSuffix[i];
			}
			i++;
			shiftTableSuffix[j] = i;
		}

		i = 0;

		for (int j2 = shiftTableSuffix[targetLength]; j2 >= 0; j2 = shiftTableSuffix[j2]) {
			int x = targetLength - j2;
			while(i < x){
				shiftTable[i] = Math.min(shiftTable[i], x);
				i++;
			}
		}

		shiftTable[targetLength-1]=1;

		return shiftTable;
	}

	/**
	 * Computes the bad character shift table for the Boyer Moore Algorithm.
	 *
	 * @param target searched string as char[]
	 * @param targetLength length of target
	 * @return HashMap<Character, Integer> shiftTable
	 */
	public HashMap<Character, int[]> computeShiftTableBadCharacter(char[] target, int targetLength){


		HashMap<Character, int[]> shiftTableChar = new HashMap<Character, int[]>();

		for (int i = 0; i < targetLength; i++) {
			shiftTableChar.putIfAbsent(target[i], new int[targetLength]);
		}
		int[] pos;
		int counter;
		for(char currChar : shiftTableChar.keySet()){
			pos = new int[targetLength];
			counter=1;
			for (int i = 0; i < targetLength; i++) {
				pos[i]=counter;
				if(currChar == target[i]){
					counter=0;
				}
				counter++;
			}
			shiftTableChar.put(currChar, pos);
		}

		return shiftTableChar;
	}

}
