package fish;

import java.util.Scanner;
/**
 * 在这本算法书页码中0~9每个数字分别出现了多少次
 * 这个暴力算法的时间复杂度没有通过  待优化
 * @author fish
 *
 */
public class CountPageNumbers {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			int number = sc.nextInt();
			System.out.print(handler(number));
		}
		sc.close();

	}

	private static String handler(int number) {
		int[] nums = {0,0,0,0,0,0,0,0,0,0};
		for(int i=1;i<=number;i++){
			String temp = String.valueOf(i);
			char[] temps = temp.toCharArray();
			for(char in:temps){
				switch (in) {
				case '0':
					nums[0]++;
					break;
				case '1':
					nums[1]++;
					break;
				case '2':
					nums[2]++;
					break;
				case '3':
					nums[3]++;
					break;
				case '4':
					nums[4]++;
					break;
				case '5':
					nums[5]++;
					break;
				case '6':
					nums[6]++;
					break;
				case '7':
					nums[7]++;
					break;
				case '8':
					nums[8]++;
					break;
				case '9':
					nums[9]++;
					break;
				default:
					break;
				}
			}
		}
	
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<nums.length;i++){
			sb.append(nums[i] +" ");
		}
		
		return sb.toString().trim();
	}

}
