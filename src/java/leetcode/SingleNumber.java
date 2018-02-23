package leetcode;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
	
	/**
	 * 利用与的性质来做这道题目
	 * @param A
	 * @return
	 * 思路：
	 * 两个相同的数异或结果为0，不同为1 ，根据该规则下列过程如下
	 * 假设 数组为 2,3,2,3,4,1,4
	 * 那么结果应该为1
	 * 2^3=0000 0010 ^ 0000 0011 = 0000 0001   1
	 * 1^2=0000 0001 ^ 0000 0010 = 0000 0011    3
	 * 3^3=0000 0011 ^ 0000 0011 =  0000 0000    0
	 * 0^4=0000 0000 ^ 0000 0100 = 0000 0100  4
	 * 4 ^ 1 =0000 0100 ^ 0000 0001 = 0000 0101 5
	 * 5 ^ 4= 0000 0101 ^ 0000 0100 =0000 0001  1
	 * 整个过程如上，最后结果为1
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
	  * 换成出现三个重复的数字
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
