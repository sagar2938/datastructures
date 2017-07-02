package Arrays;

public class missingElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,6,7,8};
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum=sum+a[i];
		}
		System.out.println("XOR  --> "+(1^2));
		int n=8;
		int rangeSum=(n*(n+1))/2;
		System.out.println("missing element is -> "+(rangeSum-sum));
		usingXOR(a, 8);
	}
	
	static void usingXOR(int arr[],int n){
		int a=1;
		for(int i=2;i<=n;i++){
			a=a^i;
		}
		for(int i=0;i<arr.length;i++){
			a=a^arr[i];
		}
		System.out.println("The XOR value is  --> "+a);
		
	}

}
