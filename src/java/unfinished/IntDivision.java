package unfinished;

import java.util.Scanner;
/**
 * 把自然数N分解成若干个互不相同的正整数，使乘积最大；  
 * @author fish
 * http://blog.csdn.net/rinwkn/article/details/53457565
 */
public class IntDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			handler(sc.nextInt());
		}
		sc.close();
	}

	private static void handler(int n) {
		 int sum=0,index=0,left=0;  
		 int temp[] = new int[n];
	     for(int i=2;i<=n;i++){
	    	 temp[index++]=i;  
	         sum+=i;  
	         if(sum>n){ 
	        	 sum-=i;
	        	 index--;
	        	 left=n-sum;  
	             break;  
	         }
	     }  
	     for(int i=index-1;left>0;left--){
	    	 temp[i]++;  
	         i--;  
	         if(i<0) {
	        	 i=index-1;  
	         }
	     }  
	     int result =1;
	     for(int i=0;i<=index-1;i++){
	    	 result = result * temp[i]; 
	     }
	     System.out.println(result);
	}

}
