package fish;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 把只包含素因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author fish
 *	思路：利用数组记录之前的丑数，并记录当前数字是由几个2,3,5乘积组合而成 ，依次递归判读最小值
 */
public class FindUglyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.print(handler(sc.nextInt())); 
		}
		sc.close();
	}

	private static int handler(int k) {
		if(k==0){
			return 0;
		}
		if(k==1){
			return 1;
		}
		int count2=0,count3=0,count5=0,index=0;
		int num = 0;
		int[] temp = new int[k];
		temp[index] = 1;
		
		while(k>1){
			num = Math.min(temp[count2]*2, Math.min(temp[count3]*3, temp[count5]*5));
			if(num==temp[count2]*2) count2++;
			if(num==temp[count3]*3) count3++;
			if(num==temp[count5]*5) count5++;
			temp[++index]= num;
			k--;
		}
		return  temp[temp.length-1];
	}

}
