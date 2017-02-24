package fish;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		
		HashMap<Integer,Object> map = new HashMap<Integer,Object>();
		map.put(1, new Demo(1,12));
		map.put(2, new Demo(2,22));
		map.put(3, new Demo(1,11));
		map.put(4, new Demo(4,19));
		


		ThreadDemo td1  = new  ThreadDemo(map);
		ThreadDemo td2  = new  ThreadDemo(map);
		ThreadDemo td3  = new  ThreadDemo(map,2);
//		ThreadDemo td4  = new  ThreadDemo(map);
//		ThreadDemo td5  = new  ThreadDemo(map);
		
		td1.start();
		td2.start();
		td3.start();
		
		System.out.println(Integer.MAX_VALUE);

	}

	
		

		
	
}
