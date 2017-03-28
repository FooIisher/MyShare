package fish;

public class Sort {
	
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
		fastSort(nums, 0, nums.length-1);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}

}
