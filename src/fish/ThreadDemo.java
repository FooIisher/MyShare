package fish;

import java.util.HashMap;
import java.util.TreeMap;

public class ThreadDemo extends Thread {

	private HashMap<Integer, Object> map;
	private int temp;
	
	public ThreadDemo(HashMap<Integer, Object> map, int temp) {
		super();
		this.map = map;
		this.temp = temp;
	}

	public ThreadDemo(HashMap<Integer, Object> map2) {
		super();
		this.map = map2;
		temp=1;
	}

	@Override
	public void run() {
		Demo demo = (Demo) map.get(temp);
		for(int i = 0;i<10;i++){
			demo.test();
			System.out.println(Thread.currentThread().getName()+ "£º-" + demo.toString() + "-");
		}
		
	}

}
