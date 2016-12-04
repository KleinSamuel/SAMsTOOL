package patternsearch;

import patternsearch.PatternSearch.PatternSearchReturnObject;

public class PatternSearchRunner {

	/**
	 * Argument handling:
	 *
	 * 1 : String run mode
	 * 2 : String text
	 * 3 : String pattern
	 *
	 * -> String[1,2,3]
	 *
	 * Output style:
	 *
	 * 1 : String pattern
	 * 2 : Integer startPosition beginning with 0
	 * 3 : Integer endPosition beginning with 0
	 * 4 : Amount of comparisons since start
	 *
	 * for each occurrence
	 * 		print 1 \t 2 \t 3 \t 4
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		PatternSearch searchMethod = null;

		if(args.length != 3){
			System.err.println("Please provide valid params.");
			System.exit(1);
		}

		switch (args[0]) {
			case "naive":
				searchMethod = new PatternSearch_Naive();
				break;
			case "kmp":
				searchMethod = new PatternSearch_KnuthMorrisPratt();
				break;
			case "bm":
				searchMethod = new PatternSearch_BoyerMoore();
				break;
			default:
				System.err.println("Please provide a valid run mode.");
				System.exit(1);
				break;
		}

		PatternSearchReturnObject out = searchMethod.findPattern(args[2].toCharArray(), args[1].toCharArray());

		if(out == null){
			System.err.println("No return object found.");
			System.exit(1);
		}

		for(int i=0; i < out.getStartingPositions().size(); i++){
			System.out.println(args[1]+"\t"+out.getStartingPositions().get(i)+"\t"+(out.getStartingPositions().get(i)+args[1].length()-1)+"\t"+out.getComparisonCounter().get(i));
		}

	}
}
