package fish;

import java.util.Scanner;

/*
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 * 输入：一个正整数N。(N不大于30000)
 * 输出：不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 */

public class PickSeven {
	
	public static void main(String [] ar){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int num=0;
		for(int i=1;i<=n;i++){
			if(i%7==0||check(i)){
				System.out.println(i);
				num++;
			}
		}
		System.out.println(num);
	}
	
	static Boolean check(int n){
		while(n!=0){
			if(n%10==7){
				return true;
			}
			n=n/10;
		}
		return false;
		
	}

}
