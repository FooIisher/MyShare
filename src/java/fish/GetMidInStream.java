package fish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * @author fish
 *
 */
public class GetMidInStream {

		ArrayList<Integer> list = new ArrayList<Integer>();

		public void Insert(Integer num) {
			list.add(num);
			Collections.sort(list);
	    }

	    public Double GetMedian() {
	        double result=0;
	    	if(list.size()%2==1){
	    		result = Double.valueOf(list.get(list.size()/2));
	        }else{
	        	result = ( Double.valueOf(list.get(list.size()/2-1))
	        			+ Double.valueOf(list.get(list.size()/2)))/2;
	        }
	    	
	    	return result;
	    }


}
