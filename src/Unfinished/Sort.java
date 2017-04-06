package Unfinished;

import java.nio.channels.SelectableChannel;

public class Sort {
	
	/**
	 * ѡ������
	 * @param nums
	 * ÿ�α����ҳ���С������Ԫ�� ��ǰһ��Ԫ�ؽ���λ��
	 * ʱ�临�Ӷ�ΪO(n`2) 
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
	 * �ϲ�����
	 * @param nums
	 * @param start
	 * @param end
	 * �����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�
	 * Ȼ���ٰ����������кϲ�Ϊ������������ 
     * ʱ�临�Ӷ�ΪO(nlogn) 
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
	 * ��������
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
