package fish;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * �󳬼�������      2<n<10`18 
 * ��һ������һ�������Ĵ���һ����  
 * �� 27 ��3��3����  
 * ����27
 * ��� 3 3
 * �������������No
 * 
 * ʱ�临�ӶȲ�����
 * @author fish
 *
 */

public class SupperPowerfulNumber {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
//			System.out.print(handler(Long.valueOf(in)));
			System.out.print(handler2(Long.valueOf(in)));
		}
		sc.close();
	}

	
	private static String handler2(long in) {
		int num=0;
		double number = (double) in;
		while(checkSqrt(number)&&number>3){
			num++;
			number =  Math.sqrt(number);
		}
		
		if(num==0){
			return "No";
		}else{
			int result = (int) number;
			int count = (int) Math.pow(2, num);
			return result+" "+count ;
		}
		
	}

/**
 * ����������������Ƿ�������
 * @param number
 * @return
 */
	private static boolean checkSqrt(double number) {
		double result = Math.sqrt(number);
		int temp = (int) result;
		double check = (double) temp;
		if(result == check){
			return true;
		}
		return false;
	}


	/**
	 * ��˼·ʱ�临�Ӷ�̫��
	 * @param n
	 * @return
	 */
	private static String handler(long n) {
		String result= "No";
		if(n<7){
			return result;
		}
		
		
		
		for(int i=2;i<n/2;i++){
			if(!check(i)){
				int num =1;
				int sum =i;
				while(sum<n){
					sum = sum * i;
					num ++;
				}
				if(sum == n ){
					return i+" "+num;
				}	
			}
		}
		return result;
	}

	private static boolean check(int i) {
		for(int j=3;j<i;i++){
			if(i%j==0){
				return true;
			}
		}
		return false;
	}

}
