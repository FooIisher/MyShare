package thread;

public class Productor extends Thread{

	private ConAndPro cp;

	public Productor(ConAndPro cp, int number) {
		super();
		this.setName("������"+number);
		this.cp = cp;
	}


	@Override
	public void run() {
		cp.product();
	}

}
