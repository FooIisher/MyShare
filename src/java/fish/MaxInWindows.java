package fish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *  针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *   {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author fish
 *
 */
public class MaxInWindows {
	
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> result  =new ArrayList<Integer>();
		if(size<1||num.length==0){
			return null;
		}

		int max =0;
		if(num.length<=size){
			for(int n:num){
				if(n>max){
					max=n;
				}
			}
			result.add(max);
		}else{
			Queue<Integer> window = new LinkedList<Integer>();
			for(int i=0;i<num.length;i++){
				
				if(i<size){
					window.add(num[i]);
					
					if(num[i]>max){
						max=num[i];
					}
					
					if(i==size-1){
						result.add(max);
					}
				}else{
					if(num[i]>=max){
						max=num[i];
						window.add(num[i]);
						window.poll();
					}else{
						window.add(num[i]);
						window.poll();
						max=0;
						for(Object n:window.toArray()){
							int in = (int) n;
							if(in>max){
								max=in;
							}
						}
					}
					result.add(max);
				}
				
			}
				
		}
		
		
		return result;
    }

	public static void main(String[] args) {
		int[] nums = {2,3,4,2,6,2,5,1};
		MaxInWindows use = new MaxInWindows();
		System.out.println(use.maxInWindows(nums, 3));
	}

}
