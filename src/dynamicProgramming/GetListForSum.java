package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 题目：(动态规划)
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数, 使其和等于 m ,要求将其中所有的可能组合列出来. 
 * 
 * 
 * @author fish
 *
 */
public class GetListForSum {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			getListForNum(m,n>m?m:n,list);
		}
		sc.close();
	}
	/**
	 * prinList(sum,n)= printList(sum-n,n-1)+printList(sum,n-1); 
	 * @param sum  
	 * @param n
	 * @param list
	 */
	private static void getListForNum(int sum, int n, ArrayList<Integer> list) {
		if(sum==0){
			System.out.println(list);
			return;
		}
		if(n<=0||sum<0){
			return;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>(list);
		getListForNum(sum, n-1, list);
		temp.add(n);
		getListForNum(sum-n, n-1, temp);
		
	}
	
}