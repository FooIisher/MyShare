package fish;
import java.util.Scanner;

/**
 * 模拟一个筛子翻转
 * 
 * @author fish
 *
 */
public class ShaiZi {
	//左边
	private int left ;
	//右边
	private int right ;
	//前边
	private int ahead;
	//后边
	private int back;
	//上边
	private int top;
	//下边
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
		if(way=='L'){//向左翻转
			int temp =this.left;
			this.left = this.top;
			this.top = this.right;
			this.right = this.down;
			this.down =temp;
		}else if(way=='R'){//向右翻转
			int temp =this.left;
			this.left = this.down;
			this.down = this.right;
			this.right = this.top;
			this.top = temp;
		}else if(way=='F'){//向前翻转
			int temp =this.top;
			this.top = this.back;
			this.back = this.down;
			this.down =this.ahead;
			this.ahead =temp;
		}else if(way=='B'){//向后翻转
			int temp =this.top;
			this.top = this.ahead;
			this.ahead = this.down;
			this.down =this.back;
			this.back =temp;
		}else if(way=='A'){//顺时针翻转
			int temp =this.ahead;
			this.ahead = this.left;
			this.left = this.back;
			this.back =this.right;
			this.right =temp;
		}else if(way=='C'){//逆时针翻转
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
