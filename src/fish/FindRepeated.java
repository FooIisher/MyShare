package fish;

/**
 * 在一个数组中存了若干个字母，有个字母出现的次数超过了数组总数的一半，找出这个字母
 * 要求用最少的时间复杂度和空间复杂度去解决
 * @author fish
 *	思路：提示用两个变量，一次遍历即可完成
 *	利用数组个数和该字母出现的次数超过了数组的一半来解决该问题
 *	两个变量一个存储当前遍历的字符，和该字符连续出现的次数
 *	遇到相同字符，次数+1，不同-1，次数变为0后，记录新字符
 *	最后记录下的一定为该重复的字符
 */
public class FindRepeated {

	public static void main(String[] args) {
		int[] nums  = {4,3,4,4,4,4,5,5,5,1,2,3,4,4,4,5,4};
		handler(nums);
	}

	private static void handler(int[] nums) {
		int tempChar = nums[0];
		int tempCount = 1;
		for(int num:nums){
			if(num==tempChar){
				tempCount++;
			}else{
				tempCount--;
				if(tempCount==0){
					tempChar = num;
					tempCount = 1;
				}
			}
		}
		System.out.println(tempChar);
	}

}
