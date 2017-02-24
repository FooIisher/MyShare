package fish;

class Demo{
	private int i;
	private int j;

	public Demo(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	
	@Override
	public String toString(){
		return i+" "+j;
	}

	public synchronized void test() {
		i++;
	}

	public synchronized void test2() {
		j++;
		
	}
}
