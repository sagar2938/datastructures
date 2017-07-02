package backtracking;

import java.util.HashMap;

public class stringCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void combination(char input[]){
		HashMap<Character, Integer>countMap=new HashMap<Character,Integer>();
		for(int i=0;i<input.length;i++){
			if(countMap.containsKey(input[i])){
				countMap.put(input[i], countMap.get(input[i])+1);
				
			}else{
				countMap.put(input[i], 0);
			}
		}
		
	}
	public static void combinationUtil(char input[],int count[],)
}
