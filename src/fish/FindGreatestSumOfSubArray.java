package fish;



import java.util.Collections;

import java.util.Vector;

/**
 * 需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * (子向量的长度至少是1)
 * @author fish
 *
 */
public class FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSumOfSubArray(array));
	}
	
	public static int findGreatestSumOfSubArray(int[] array) {
		if(array==null||array.length<1){
			return 0;
		}
		

		Vector<Integer> vec =  new Vector<Integer>();
		for(int i=0;i<array.length;i++){
			int sum = 0;
			for(int j=i;j<array.length;j++){
				sum += array[j];
				vec.add(sum);
			}
		}
		
		Collections.sort(vec);
		return vec.get(vec.size()-1);
        
    }

}
