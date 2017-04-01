package thread;
/**
 * 利用多线程循环打印ABC 10次
 * @author fish
 *
 */
public class CirclePrint {

	private Object a = new Object();
	private Object b = new Object();
	private Object c = new Object();
	
	public class Runner1 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++){
				try {
					synchronized (a) {
						synchronized (b) {
							System.out.print("A");
							b.notify();
						}
						if(i<9){
							a.wait();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
	}
	
	public class Runner2 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++){
				try {
					synchronized (b) {
						synchronized (c) {
							System.out.print("B");
							c.notify();
						}
						if(i<9){
							b.wait();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
	}
	
	public class Runner3 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++){
				try {
					synchronized (c) {
						synchronized (a) {
							System.out.print("C");
							a.notify();
						}
						if(i<9){
							c.wait();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		CirclePrint print = new CirclePrint();
		Thread work1 = new Thread(print.new Runner1());
		Thread work2 = new Thread(print.new Runner2());
		Thread work3 = new Thread(print.new Runner3());
		work1.start();
		Thread.sleep(1);
		work2.start();
		Thread.sleep(1);
		work3.start();
		
	}

	

}
