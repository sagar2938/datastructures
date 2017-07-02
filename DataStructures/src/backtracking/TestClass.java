package backtracking;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

class TestClass {
	static HashMap<Long, Long>fibCache=new HashMap<Long,Long>();
     static HashMap<String, Long>gcdCache=new HashMap<String ,Long>();
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        Scanner s=new Scanner(System.in);
        long N=s.nextInt();
        long Q=s.nextInt();
        long A[]=new long[(int) N];
        for(long i=0;i<N;i++){
            A[(int) i]=s.nextLong();
        }
       
        for(long j=0;j<Q;j++){
            long L=s.nextLong();
            long R=s.nextLong();
            long fibValues[]=new long[(int) (R-L+1)];
            int index=0;
            
            for(long k=L-1;k<R;k++){
            
                long fibVal;
                if(fibCache.containsKey(A[(int) k])){
                	fibVal=fibCache.get(A[(int) k]);
                }else{
                	 fibVal=fibonacci.fib(A[(int) k]);
                	 fibCache.put(k, fibVal);
                }
                fibValues[index]=fibVal;
                index++;
            }
          
            System.out.println(findGCD(fibValues, fibValues.length));
        }

        
    }
    static long findGCD(long arr[], long n)
    {
        long result = arr[0];
        for (long i=1; i<n; i++){
        	String key=i+""+result;
        	if(gcdCache.containsKey(key)){
        		result=gcdCache.get(key);
        	}else{
        		result = gcd(arr[(int) i], result);
        		gcdCache.put(key, result);
        	}
            
        }
        return result;
    }
    static long gcd(long a, long b)
    {
    	
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}

class fibonacci
{
	/* function that returns nth Fibonacci number */
	static long fib(long n)
	{
	long F[][] = new long[][]{{1,1},{1,0}};
	if (n == 0)
		return 0;
	power(F, n-1);
	
	return F[0][0];
	}
	
	static void multiply(long F[][], long M[][])
	{
	long x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
	long y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
	long z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
	long w = F[1][0]*M[0][1] + F[1][1]*M[1][1];
	
	F[0][0] = x;
	F[0][1] = y;
	F[1][0] = z;
	F[1][1] = w;
	}
	
	/* Optimized version of power() in method 4 */
	static void power(long F[][], long n)
	{
	if( n == 0 || n == 1)
	return;
	long M[][] = new long[][]{{1,1},{1,0}};
	
	power(F, n/2);
	multiply(F, F);
	
	if (n%2 != 0)
	multiply(F, M);
	}
	

}
