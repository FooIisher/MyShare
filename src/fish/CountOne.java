package fish;

import java.util.Scanner;

/**
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 * @author fish
 *
 */
public class CountOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			handler(sc.nextInt());
		}
		sc.close();

	}

	private static void handler(int in) {
		int result=0;
		int i=in;
		while(i>0){
			char[] ins = String.valueOf(i).toCharArray();
			for(char inChar:ins){
				if(inChar=='1'){
					result++;
				}
			}
		}
		i--;
		System.out.println(result);
		
	}

}
