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

	
	private static char[] handler2(Long in) {
		// TODO Auto-generated method stub
		return null;
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
