package Strings;

public class ReverseArrayWithoutSpecialChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]={"a","%","b","c","$","d"};
		int l=0,r=arr.length-1;
		while(l<r){
			if(!(arr[l].charAt(0)>='a'&& arr[l].charAt(0)<='z')){
				l++;
			}
			else if(!((arr[l].charAt(0)>='a'&& arr[l].charAt(0)<='z'))){
				r--;
			}else{
				String temp=arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
				l++;
				r--;
			}
			
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"  ");
		}
	}

}
