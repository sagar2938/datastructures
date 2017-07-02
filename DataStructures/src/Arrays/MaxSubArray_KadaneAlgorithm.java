package Arrays;

public class MaxSubArray_KadaneAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[]={4,-3,-2,2,3,1,-2,-3,4,2,-6,-3,-1,3,1,2};
		int arr[]={1,2,3};
		
		int start=0,end=0,s=0;
		int max_sum_sofar=arr[0];
		int max_ending_here=0;
		for(int i=0;i<arr.length;i++){
			max_ending_here=max_ending_here+arr[i];
			if(max_ending_here>max_sum_sofar){
				max_sum_sofar=max_ending_here;
				start=s;
				end=i;
			}
			if(max_ending_here<0){
				max_ending_here=0;
				s=i+1;
			}
		}
		System.out.println("Max sub array sum : "+max_sum_sofar  +"  form indexes  "+start+" - "+end);
	}

}
