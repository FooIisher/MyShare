package fish;

import java.util.HashMap;
/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * @author fish
 *
 */
public class MoreThanHalfNum {
	
	public static int solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int in:array){
            if(map.containsKey(in)){
            	map.put(in, map.get(in)+1);
            	if(map.get(in)>array.length/2){
            		return in;
            	}
            }else{
            	map.put(in, 1);
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		int[] nums ={1,2,3,2,2,2,5,4,2};
		System.out.println(solution(nums));

	}

}
