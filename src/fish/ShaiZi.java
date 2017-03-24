package fish;
import java.util.Scanner;

/**
 * ģ��һ��ɸ�ӷ�ת
 * 
 * @author fish
 *
 */
public class ShaiZi {
	//���
	private int left ;
	//�ұ�
	private int right ;
	//ǰ��
	private int ahead;
	//���
	private int back;
	//�ϱ�
	private int top;
	//�±�
	private int down;
	
	
	
	public ShaiZi(int left, int right, int ahead, int back, int top, int down) {
		super();
		this.left = left;
		this.right = right;
		this.ahead = ahead;
		this.back = back;
		this.top = top;
		this.down = down;
	}
	
	public void move(char way){
		if(way=='L'){//����ת
			int temp =this.left;
			this.left = this.top;
			this.top = this.right;
			this.right = this.down;
			this.down =temp;
		}else if(way=='R'){//���ҷ�ת
			int temp =this.left;
			this.left = this.down;
			this.down = this.right;
			this.right = this.top;
			this.top = temp;
		}else if(way=='F'){//��ǰ��ת
			int temp =this.top;
			this.top = this.back;
			this.back = this.down;
			this.down =this.ahead;
			this.ahead =temp;
		}else if(way=='B'){//���ת
			int temp =this.top;
			this.top = this.ahead;
			this.ahead = this.down;
			this.down =this.back;
			this.back =temp;
		}else if(way=='A'){//˳ʱ�뷭ת
			int temp =this.ahead;
			this.ahead = this.left;
			this.left = this.back;
			this.back =this.right;
			this.right =temp;
		}else if(way=='C'){//��ʱ�뷭ת
			int temp =this.ahead;
			this.ahead = this.right;
			this.right = this.back;
			this.back =this.left;
			this.left =temp;
		}
	}



	@Override
	public String toString() {
		return left + "" + right + "" + ahead
				+ "" + back + "" + top + "" + down ;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in =sc.next();
			ShaiZi sz = new ShaiZi(1, 2, 3, 4, 5, 6);
			char[] ins = in.toCharArray();
			for(char inChar:ins){
				sz.move(inChar);
			}
			System.out.println(sz.toString());
		}
		sc.close();
	}

}
