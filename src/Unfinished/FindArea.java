package Unfinished;

import java.util.Scanner;

public class FindArea {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i =0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		System.out.println(handler(nums)); 
		sc.close();
	}

	private static String handler(int[] nums) {
		if(nums.length<2){
			return -1 +" "+-1;
		}
		int[] flag= new int [nums.length];
		for(int i=0;i<nums.length-2;i++){
			int j=i+1;
			int temp =0;
			while(j<nums.length-1&&nums[j-1]<nums[j]){
				temp++;
				j++;
			}
			if(j<nums.length&&temp!=0){
				while(j<nums.length&&nums[j-1]>nums[j]){
					temp++;
					j++;
				
					
				}
				flag[i]=temp;
			}else{
				flag[i]=0;
			}
			i++;
		}
		int start =0;
		int max =0;
		for(int i =0;i<flag.length;i++){
			if(max<flag[i]){
				max = flag[i];
				start =i;
			}
		}
		if(start==0&&max==0){
			return "-1 -1";
		}
		
		return start+ " " +(start+max);
	}

}
