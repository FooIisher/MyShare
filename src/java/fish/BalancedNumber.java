package fish;

import java.util.Scanner;
/**
 * 平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，可以分成123和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。 
 * @author fish
 *
 */
public class BalancedNumber {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
			System.out.println(check(in));
		}
		sc.close();
	}

	private static String check(String in) {
		char[] ins = in.toCharArray();
		if(ins.length<2){
			return "NO";
		}
		int i =0;
		int j =ins.length-1;
		int left=Integer.parseInt(String.valueOf(ins[i])),right=Integer.parseInt(String.valueOf(ins[j]));
		while(i<j){
			if(left<right){
				i++;
				left =left *Integer.parseInt(String.valueOf(ins[i]));
			}
			
			if(left>right){
				j--;
				right =right *Integer.parseInt(String.valueOf(ins[j]));
			}
			
			if(left==right){
				if(i==j-2){
					return "NO";
				}
				if(i==j-1){
					return "YES";
				}
				i++;
				j--;
				left =left *Integer.parseInt(String.valueOf(ins[i]));
				right =right *Integer.parseInt(String.valueOf(ins[j]));
			}
			
			if(left==0||right==0){
				return "YES";
			}
			
		}
		
		if(left==right){
			return "YES";
		}else{
			return "NO";
		}
		
	}

}
