package fish;

import java.util.Scanner;

/*
 * ���7�й����ֵĸ���������7�ı��������а���7�����֣���17��27��37...70��71��72��73...���ĸ���
 * ���룺һ��������N��(N������30000)
 * �����������N����7�йص����ָ�������������20����7�йص����ְ���7,14,17.
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
