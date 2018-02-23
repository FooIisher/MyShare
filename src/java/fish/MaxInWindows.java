package fish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 *  �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *   {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
