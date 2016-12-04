package alignment;

public class NeedlemanWunsch{
	   private int[][] E;
	   private String n, m;
	  
	   public NeedlemanWunsch(String a, String b){
	        n = a; m = b;
	        E = new int[n.length()+1][m.length()+1];
	        init();        
	   }
	   
	   public void init(){
	      E[0][0] = 0;
	      
	      for (int i=1; i<=n.length(); i++){
	    	  E[i][0] = 0;            	    	  
	      }
	      for (int j=1; j<=m.length(); j++){
	    	  E[0][j] = 0;    	    	  
	      }
	   }
	   
	   private int cost(char a, char b){
	      if (a==b){
	    	  return 1;
	      }else{
	    	  return 0;
	      }
	   }
	   
	   public int compare(){
	      for (int i=1; i<=n.length(); i++){
	         for (int j=1; j<=m.length(); j++){
	            E[i][j] = Math.max(E[i-1][j-1] + cost(n.charAt(i-1), m.charAt(j-1)), Math.max(E[i-1][j], E[i][j-1]));
	         }
	      }
	      return E[n.length()][m.length()];                                           
	   }
	   
	   public static void main(String[] args){
	      String a = "Hallo Waldfee";
	      String b = "Hola fee";
	      NeedlemanWunsch NW = new NeedlemanWunsch(a, b);         
	      System.out.println("Score: "+NW.compare());
	   }
	}