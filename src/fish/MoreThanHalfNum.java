package fish;

import java.util.HashMap;
/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
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
