package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * ��Ŀ��(��̬�滮)
 * ������������ n �� m��������1��2��3.......n �� ����ȡ������, ʹ��͵��� m ,Ҫ���������еĿ�������г���. 
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