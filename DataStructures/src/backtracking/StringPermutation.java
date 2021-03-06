package backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class StringPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String input=s.next();
		HashMap<String,Integer>frequency=new HashMap<String,Integer>();
		for(int i=0;i<input.length();i++){
			String temp=input.charAt(i)+"";
			if(frequency.containsKey(temp)){
				frequency.put(temp, frequency.get(temp)+1);
			}else{
				frequency.put(temp, 1);
			}
		}
		String stringArray[]=new String[frequency.keySet().size()];
		Integer freqArray[]=new Integer[frequency.keySet().size()];
		int i=0;
		for(String key:frequency.keySet()){
			stringArray[i]=key;
			freqArray[i]=frequency.get(key);
			i++;
		}
		String result[]=new String[input.length()];
		printArray(stringArray);
		printArray2(freqArray);
		permute(stringArray, freqArray, result, 0);
	}
	
	public static void permute(String[]stringArray,Integer[]freqArray,String[]result,int level){
		if(level==result.length){
			printArray(result);
			return;
		}
		for(int i=0;i<stringArray.length;i++){
			if(freqArray[i]==0){
				continue;
			}
			result[level]=stringArray[i];
			freqArray[i]--;
			permute(stringArray, freqArray, result, level+1);
			freqArray[i]++;
		}
	}
	public static void printArray(String[]result){
		for(String s:result){
			System.out.print(s+"  ");
		}
		System.out.println();
	}
	public static void printArray2(Integer[]result){
		for(Integer s:result){
			System.out.print(s+"  ");
		}
		System.out.println();
	}
}

