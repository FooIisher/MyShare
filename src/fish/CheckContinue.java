package fish;

import java.util.Scanner;

/*
 * ���������ʣ��鿴��Щ�����Ƿ�����������У���ǰһ����������ĸ�ͺ�һ������β��ĸһ��
 * 
 */

public class CheckContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		System.out.println(check(input));
		sc.close();
	}
	
	public static int check(String[] str){
		for(int i=1;i<str.length;i++){
			if(str[i-1].charAt(str[i-1].length()-1)!=str[i].charAt(0))
				return -1;
		}
		
		return 1;
		
	}
}
