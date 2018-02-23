package fish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
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
