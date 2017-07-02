package Arrays;

public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,6,7};
		int s=0,e=arr.length-1;
		while(s<e){
			int temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;
			e--;
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"  ");
		}
	}

}
