package leetcode;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
	
	/**
	 * ��������������������Ŀ
	 * @param A
	 * @return
	 * ˼·��
	 * ������ͬ���������Ϊ0����ͬΪ1 �����ݸù������й�������
	 * ���� ����Ϊ 2,3,2,3,4,1,4
	 * ��ô���Ӧ��Ϊ1
	 * 2^3=0000 0010 ^ 0000 0011 = 0000 0001   1
	 * 1^2=0000 0001 ^ 0000 0010 = 0000 0011    3
	 * 3^3=0000 0011 ^ 0000 0011 =  0000 0000    0
	 * 0^4=0000 0000 ^ 0000 0100 = 0000 0100  4
	 * 4 ^ 1 =0000 0100 ^ 0000 0001 = 0000 0101 5
	 * 5 ^ 4= 0000 0101 ^ 0000 0100 =0000 0001  1
	 * �����������ϣ������Ϊ1
	 *	
	 */
	 public int singleNumber(int[] A) {
		 if(A==null||A.length==0){
			 return -1;
		 }else{
			 int result = A[0];
			 for(int i =1;i<A.length;i++){
				 result = result^A[i];
			 }
			 return result;
		 }
	 }
	 
	 /**
	  * ���ɳ��������ظ�������
	  * @param A
	  * @return
	  */
	 public int singleNumber2(int[] A){
		 int one = 0,two =0;
		 for(int number:A){
			 one = (one^number)&~two;
			 two = (two^number)&~one;
		 }
		 return one;
		 
	 }
}
