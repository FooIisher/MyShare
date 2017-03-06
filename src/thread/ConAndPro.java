package thread;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadFactory;



/**
 * ����notify��waitʵ�������ߺ�������ģʽ
 * @author fish
 *
 */
public class ConAndPro {

	private int size;
	
	private  Queue<Integer> container;  

	
	public ConAndPro(int size) {
		super();
		this.size = size;
		this.container = new LinkedList<Integer>();
	}
	
	public synchronized void product() {
		try {
			while(container.size()>=size){
				System.out.println(Thread.currentThread().getName()+"�������ڵȴ�");
				this.wait();
				
			}
			container.add((int) Math.random());
			this.notify();
			System.out.println("��" + Thread.currentThread().getName()+"������һ������");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public synchronized void consume() {

		try {
			while(container.size()==0){
				System.out.println(Thread.currentThread().getName()+"�ڵȴ�");
				this.wait();
			
			}
			
			container.poll();
			this.notify();
			System.out.println("��" + Thread.currentThread().getName()+"������һ������");
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}




	public static void main(String[] args) {
		ConAndPro cp = new ConAndPro(2);
		Consumer consummer1 = new Consumer(cp,1);
		Consumer consummer2 = new Consumer(cp,2);
		Consumer consummer3 = new Consumer(cp,3);
		Productor productor1 = new Productor(cp,1);
		Productor productor2 = new Productor(cp,2);
		Productor productor3 = new Productor(cp,3);
		
	
		productor1.start();
		productor2.start();
		productor3.start();
		consummer1.start();
		consummer2.start();
		consummer3.start();
		
	}

	





	

}
