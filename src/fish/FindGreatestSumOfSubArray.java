package fish;



import java.util.Collections;

import java.util.Vector;

/**
 * ��Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * (�������ĳ���������1)
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
