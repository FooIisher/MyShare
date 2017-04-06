package Unfinished;

import java.nio.channels.SelectableChannel;

public class Sort {
	
	/**
	 * 选择排序
	 * @param nums
	 * 每次遍历找出最小或最大的元素 与前一个元素交换位置
	 * 时间复杂度为O(n`2) 
	 */
	public static void selectSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		int temp = 0,index=0;
		for(int i =0;i<nums.length;i++){
			temp=nums[i];
			index = i;
			for(int j = i ;j<nums.length;j++){
				if(temp>nums[j]){
					temp=nums[j];
					index=j;
				}
			}
			nums[index]=nums[i];
			nums[i]=temp;
		}
	}
	
	/**
	 * 合并排序
	 * @param nums
	 * @param start
	 * @param end
	 * 将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。
	 * 然后再把有序子序列合并为整体有序序列 
     * 时间复杂度为O(nlogn) 
	 */
	public static void mergeSort(int[] nums,int start,int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(nums,start,mid);
			mergeSort(nums,mid+1,end);
			mergeSortHandler(nums, start,mid, end);
		}
		return;
	}
	
	
	private static void mergeSortHandler(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end-start+1];
		int i =start;
		int j =mid+1;
		int k =0;
		while(i<=mid&&j<=end){
			if(nums[i]<nums[j]){
				temp[k++] = nums[i++];
			}else{
				temp[k++] = nums[j++];
			}
		}
		
		while(i<=mid){
			temp[k++]=nums[i++];
		}
		
		while(j<=end){
			temp[k++]=nums[j++];
		}
		
		for(int m=0;m<temp.length;m++){
			nums[start+m] = temp[m];
		}
	}


	/**
	 * 快速排序
	 * @param nums
	 * @param start
	 * @param end
	 */
	public static void fastSort(int[] nums,int start,int end){
		if(start >= end)
	    {
	        return;
	    }
		int i=start, j=end;
		int temp = nums[i];
		while(i<j){
			while(i<j&&nums[j]>=temp){
				j--;
			}
			if(i<j){
				nums[i] = nums[j];
			}
			while(i<j&&nums[i]<temp){
				i++;
			}
			if(i<j){
				nums[j] = nums[i];
			}
		}
		nums[i] = temp;	
		fastSort(nums, start, i-1);
		fastSort(nums, i+1, end);
	}

	public static void main(String[] args) {
		int[] nums = {1,2,4,6,7,3,6,8,10};
//		fastSort(nums, 0, nums.length-1);
//		mergeSort(nums, 0, nums.length-1);
		selectSort(nums);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}

}
