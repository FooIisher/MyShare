package fish;

import java.util.Arrays;
import java.util.Scanner;


public class MagicCircle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		System.out.println(handler(n,k,nums));
		sc.close();
	}

	private static String handler(int n, int k, int[] nums) {
		int[] temp = Arrays.copyOf(nums, n);
		for(int i=0;i<k;i++){
			nums =  Arrays.copyOf(temp, n);
			for(int j=0;j<nums.length;j++){
				if(j==nums.length-1){
					temp[j] = nums[j]+ nums[0];
				}else{
					temp[j] = nums[j]+ nums[j+1];
				}
				
				if(temp[j]>=100){
					temp[j] = temp[j]%100;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num:temp){
			sb.append(num+" ");
		}
		return sb.toString().trim();
	}

}
