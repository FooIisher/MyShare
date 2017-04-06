package Unfinished;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007 
 * @author fish
 *利用归并排序思路来出路该题目
 *合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
 *数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
 *
 */
public class ReversedInArrays {
	
	public static int handler(int[] nums){
		if(nums==null||nums.length==0){
			return 0;
		}
		int[] temp = Arrays.copyOf(nums, nums.length);
		int result = countReversedPair(nums,temp,0,nums.length-1);
		return result;
	}

	private static int countReversedPair(int[] nums, int[] temp, int start, int end) {
		if(start == end){
			return 0;
		}
		int mid = (start+end)>>1;
		int leftCount = countReversedPair(nums, temp, start, mid);
		int rightCount = countReversedPair(nums, temp, mid+1, end);
		int i = mid,j=end;
		int count=0,tempIndex=end;
		while(i>=start&&j>mid){
			if(nums[i]>nums[j]){
				count+=j-mid;
				if(count>=1000000007){
					count = count % 1000000007;
				}
				temp[tempIndex--]=nums[i--];
			}else{
				temp[tempIndex--]=nums[j--];
			}
		}
		while(i>=start){
			temp[tempIndex--]=nums[i--];
		}
		while(j>mid){
			temp[tempIndex--]=nums[j--];
		}
		for(int k=start;k<=end;k++){
			nums[k]=temp[k];
		}
		
		return (leftCount+rightCount+count)%1000000007;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,0};
		System.out.println(handler(nums));

	}

}
