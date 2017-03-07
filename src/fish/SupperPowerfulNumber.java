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

	
	private static char[] handler2(Long in) {
		// TODO Auto-generated method stub
		return null;
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
