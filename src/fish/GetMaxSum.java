package fish;

/**
 * 求一个个数组中最大的连续子序列的和
 * @author fish
 *
 */
public class GetMaxSum {

	public static void main(String[] args) {
		int[] nums = { -3, 3, -1,-1, 4, -2, -1 };
		System.out.println(handler(nums));
	}

	private static String handler(int[] nums) {
		if(nums.length==0){
			return 0+"";
		}
		int AllMaxStart = 0, AllMaxEnd = 0, EndMaxStart = 0, EndMaxEnd = 0;
		int AllMax = nums[0];
		int EndMax = nums[0];
		for(int i=1;i<nums.length;i++){
			if(EndMax+nums[i]>=nums[i]){
				EndMax = EndMax+nums[i];
				EndMaxEnd = i;
			}else{
				EndMax = nums[i];
				EndMaxStart = i;
				EndMaxEnd = i;
			}
			
			if(AllMax<EndMax){
				AllMax=EndMax;
				AllMaxStart=EndMaxStart;
				AllMaxEnd=EndMaxEnd;
			}
		}
		return "sum: "+AllMax+ " ,start: "+AllMaxStart +" ,end: "+ AllMaxEnd;
	}

}
