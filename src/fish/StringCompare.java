package fish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *   输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *   例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author fish
 *
 */
public class StringCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int nums[] = new int[n];
			for(int i=0;i<n;i++){
				nums[i] = sc.nextInt();
			}
			System.out.println(handler(nums));
		}
		sc.close();
		

	}

	private static String handler(int[] nums) {
		if(nums==null){
			return null;
		}
		StringBuilder result = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int num:nums){
			list.add(num);
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}
		});
		for(int num:list){
			result.append(num);
		}
		return result.toString();
	}

}
