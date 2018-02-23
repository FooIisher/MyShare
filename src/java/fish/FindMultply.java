package fish;
/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 * ����ʹ�ó�����
 * @author fish
 * ˼·�� 1.����ǰi - 1��Ԫ�صĳ˻�������N - i��Ԫ�صĳ˻��ֱ𱣴������������С�������ö�̬           �滮ʵ�֡�
        2.����B[i]��ֵ��
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
