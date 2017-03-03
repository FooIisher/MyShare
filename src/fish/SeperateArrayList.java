package fish;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * 对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足0<=X <= Y <N的整数，A[X], A[X+1] … A[Y]构成A的一个切片，记作(X, Y)。
 * 用三个下标 m1, m2, m3下标满足条件 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N – 1。
 * 可以把这个整型数组分成(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) 四个切片。如果这四个切片中的整数求和相等，称作“四等分”。
 * 编写一个函数，求一个给定的整型数组是否可以四等分，如果可以，返回一个布尔类型的true，如果不可以返回一个布尔类型的false。
 * 限制条件： 数组A最多有1,000,000项，数组中的整数取值范围介于-1,000,000到1,000,000之间。
 * 要求： 函数的计算复杂度为O(N)，使用的额外存储空间（除了输入的数组之外）最多为O(N)。
 * 例子：
 * 对于数组A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] 存在下标 2, 7, 9使得数组分成四个分片[2, 5], [1, 1, 1, 4], [7], [7]，这三个分片内整数之和相等，所以对于这个数组，函数应该返回true。
 * 对于数组 A=[10, 2, 11, 13, 1, 1, 1, 1, 1]， 找不到能把数组四等分的下标，所以函数应该返回false。
 * @author fish
 *
 */
public class SeperateArrayList {

		   
	public static void main(String[] args){

		int []  A ={1, 1, 1, 1, 1, 1, 1};
		Boolean res = resolve(A);
		System.out.println(String.valueOf(res));
		
	}
	
	/**
	 * 整体思路是 左右分别开始累加求和 当左边小时左边下标右移，右边小时右边下标左移
	 * 值到左右相等时，取中间部分在对其做一次如上的左右求和对比过程看能否找到中间的平衡点
	 * 记得要效验 平衡点的和与之前的和是否相等
	 * 
	 * ps 阿里的在线编程题，当时做的时间有点懵逼没做出来
	 * 
	 * @param a
	 * @return
	 */
	private static Boolean resolve(int[] a) {
		boolean result = false;
		int i=0;
		int j=a.length-1;
		int left =a[i];
		int right =a[j];
		while(i<j){
			if(left<right){
				i++;
				left +=a[i];
			}else if(left>right){
				j--;
				right +=a[j];
			}else if(left == right){
				result = checkMiddle(i+1,j-1,left,a);
				if(result){
					return result;
				}else{
					i++;
					left +=a[i];
				}
			}
			
		}
		return result;
	}

	private static boolean checkMiddle(int start, int end, int sum, int[] a) {
		int i = start+1;
		int j = end -1;
		int left =a[i];
		int right =a[j];
		while(j>i){
			if(left<right){
				i++;
				left +=a[i];
			}else if(left>right){
				j--;
				right +=a[j];
			}else if(left == right){
				if(j-i==2&&left == sum){
					return true;
				}else{
					return false;
				}
				
			}
			
		}
		return false;
	}
	
		   
		
	
	

}
