package fish;

import java.util.Scanner;
/**
 * ƽ�����Ķ����ǣ���һ�����ֳ����������֣��ֱ��Ϊ�����µ�����
 * ���Ҳ��ֱ��������������㣺
 * 1����ߺ��ұ����ٴ���һλ��
 * 2����ߵ���ÿһλ�����������ұߵ���ÿһλ��ˣ����������Ϊƽ������
 * ���磺1221��������ֳ�12��21�Ļ���1*2=2*1�����1221Ϊƽ�����������磺1236����������Էֳ�123��1*2*3=6������1236Ҳ��ƽ��������1234����������Ҳ������ƽ������ 
 * @author fish
 *
 */
public class BalancedNumber {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
			System.out.println(check(in));
		}
		sc.close();
	}

	private static String check(String in) {
		char[] ins = in.toCharArray();
		if(ins.length<2){
			return "NO";
		}
		int i =0;
		int j =ins.length-1;
		int left=Integer.parseInt(String.valueOf(ins[i])),right=Integer.parseInt(String.valueOf(ins[j]));
		while(i<j){
			if(left<right){
				i++;
				left =left *Integer.parseInt(String.valueOf(ins[i]));
			}
			
			if(left>right){
				j--;
				right =right *Integer.parseInt(String.valueOf(ins[j]));
			}
			
			if(left==right){
				if(i==j-2){
					return "NO";
				}
				if(i==j-1){
					return "YES";
				}
				i++;
				j--;
				left =left *Integer.parseInt(String.valueOf(ins[i]));
				right =right *Integer.parseInt(String.valueOf(ins[j]));
			}
			
			if(left==0||right==0){
				return "YES";
			}
			
		}
		
		if(left==right){
			return "YES";
		}else{
			return "NO";
		}
		
	}

}
