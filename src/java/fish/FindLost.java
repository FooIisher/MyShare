package fish;


/**
 * 在一个连续的数组中找出缺失的数字
 * 方法2 是改进后的二分法 时间复杂度最优秀
 * @author fish
 *
 */
public class FindLost {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,8,9,10};
//		System.out.println("The lost is: "+ getLostNum1(nums));
		System.out.println("The lost is: "+ getLostNum2(nums));
	}

	private static int getLostNum2(int[] nums) {
		return findLost(nums,0,nums.length-1);
	}

	private static int findLost(int[] nums, int start, int end) {
		
		if(end==start){
			return start+1;
		}
		
		int mid = (start+end)/2;
		
		if(nums[mid]<mid+1){
			return findLost(nums,start,mid);
		}else if(nums[mid]==mid+1){
			return findLost(nums,mid+1,end);
		}else if(nums[mid]>mid+1){
			return findLost(nums,start,mid);
		}
		return -1;
		
	}

	private static int getLostNum1(int[] nums) {
		for(int i=0;i<nums.length/2;i++){
			if(nums[i]!=i+1){
				return i+1;
			}
			
			if(nums[nums.length-(i+1)]!=nums.length+1-i){
				return nums.length+1-i;
			}
		}

		return -1;
	}

}
