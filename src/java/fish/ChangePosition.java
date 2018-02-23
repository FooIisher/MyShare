package fish;
import java.util.Scanner;


/**
 * BBGGB 将其换成BBBGG 需要移动的词最少 求出最少次数
 * @author fish
 *
 */
public class ChangePosition {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in =sc.next();
			System.out.println(handler1(in)>handler2(in)?handler2(in):handler1(in));
		}
		sc.close();
	}

	private static int handler1(String in) {
		int result =0;
		char[] ins = in.toCharArray();
		
		
		boolean flag = true;
		while(flag){
			flag=false;
			for(int i=1;i<ins.length;i++){
				if(ins[i-1]=='B'&&ins[i]=='G'){
					flag = true;
					result++;
					ins[i-1]='G';
					ins[i]='B';
				}
			}
		}
		return result;
	}
	
	private static int handler2(String in) {
		int result =0;
		char[] ins = in.toCharArray();
		
		
		boolean flag = true;
		while(flag){
			flag=false;
			for(int i=1;i<ins.length;i++){
				if(ins[i-1]=='G'&&ins[i]=='B'){
					flag = true;
					result++;
					ins[i-1]='B';
					ins[i]='G';
				}
			}
		}
		return result;
	}

}
