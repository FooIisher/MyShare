package Unfinished;
import java.util.Scanner;
/**
 * 输入一个带正负数的数组  求分为两组和相同的分法
 * @author fish
 *
 */
public class GetSumArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0;i<n;i++){
				nums[i] = sc.nextInt();
			}
			System.out.println(handler(nums)); 
		}
		sc.close();
	}

	private static int handler(int[] nums) {
		if(nums==null||nums.length==0||nums.length==1){
			return 0;
		}
		if(nums.length==2){
			if(nums[0]==nums[1]){
				return 1;
			}else{
				return 0;
			}
		}
		int time =0;
		for(int i=0;i<nums.length-1;i++){
			int left = getSum(nums,0,i);
			int right = getSum(nums,i+1,nums.length-1);
			if(left==right){
				time++;
			}
		}
		return time;
		
	}

	private static int getSum(int[] nums, int start, int end) {
		int result = 0;
		for(int i=start;i<=end;i++){
			result =result + nums[i];
		}
		return result;
	}

}
