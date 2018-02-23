package fish;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 求超级数幂数      2<n<10`18 
 * 若一个数是一个素数的大于一的幂  
 * 如 27 是3的3次幂  
 * 输入27
 * 输出 3 3
 * 若不不是则输出No
 * 
 * 时间复杂度不过关
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
 * 检验这个数开方后是否还是整数
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
	 * 该思路时间复杂度太大
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
