package fish;

import java.util.Scanner;

 /*
  * ����:�Ȳ����� 2��5��8��11��14��������
	����:������N >0
	���:��Ȳ�����ǰN���
	����:ת���ɹ����� 0 ,�Ƿ��������쳣����-1
  */

public class GetSum {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int n = Integer.parseInt(input);
		int sum = (2+3*(n-1)+2)*n/2;
	    System.out.print(sum);
		
		
	}
	
	
}
