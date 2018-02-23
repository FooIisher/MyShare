package fish;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * @author fish
 * 思路： 1.计算前i - 1个元素的乘积，及后N - i个元素的乘积分别保存在两个数组中。这可以用动态           规划实现。
        2.计算B[i]的值。
 */
public class FindMultply {

	public static int[] multiply(int[] A) {
       if(A==null||A.length==0){
    	   return null;
       }
       int[] firstTemp = new int [A.length];
       firstTemp[0] = A[0]; 
       int[] lastTemp = new int [A.length];
       lastTemp[A.length-1] = A[A.length-1];
       for(int i=1;i<A.length-1;i++){
    	   firstTemp[i] = firstTemp[i-1] * A[i];
    	   lastTemp[A.length-1-i] =  lastTemp[A.length-i] *  A[A.length-1-i];
       }
       int[] B = new int[A.length];
       for(int i=0;i<A.length;i++){
    	   if(i==0){
    		   B[i] = lastTemp[1]; 
    	   }else if(i==A.length-1){
    		   B[i] = firstTemp[A.length-2]; 
    	   }else{
    		   B[i] = firstTemp[i-1] * lastTemp[i+1];
    	   }
       }
       return B;
    }
	
	public static void main(String[] args){
		int A[] = {1,2,3,4,5};
		for(int n : multiply(A)){
			System.out.print(n+" ");
		}
	}

}
