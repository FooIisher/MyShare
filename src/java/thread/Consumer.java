package thread;

public class Consumer extends Thread{

	private ConAndPro cp;

	public Consumer(ConAndPro cp,int number) {
		super();
		this.setName("������"+ number);
		this.cp = cp;
	}

	@Override
	public void run() {
		cp.consume();
	}
	
	

}
