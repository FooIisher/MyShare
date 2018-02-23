package fish;

import java.util.Scanner;

/**
 * ����һ��������N�ͳ���L���ҳ�һ�γ��ȴ��ڵ���L�������Ǹ����������ǵĺ�ǡ��ΪN���𰸿����ж������������Ҫ�ҳ�������С���Ǹ���
 * ���� N = 18 L = 2��
 * 5 + 6 + 7 = 18 
 * 3 + 4 + 5 + 6 = 18
 * ��������Ҫ��ģ���������������̵� 5 6 7
 * �������ĸ���  >L
 * �� ����9 3
 * ��� 2 3 4 
 * 
 * @author fish
 *	
 *	�����Ŀ��Ҫ������������ͶԳƵ�����ȥ����
 *	����  1 2 3 4 5  �ĺ�  �ҽ��俴�� 5�� 3 ���
 *  ����  2 3 4 5 6 7 8 �ĺ� ���Կ���   3�� 4+5�ĺ�  
 *  �������˼·��N���л���
 *  
 */
public class SerialSum {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int L = sc.nextInt();
			System.out.print(handler(N,L));
		}
		sc.close();

	}

	private static String handler(int sum, int num) {
		String result = "No";
		for(int i=num;i<=100;i++){
			if(i%2==0){
				if(sum%(i/2)==0&&(sum/(i/2))%2==1){
					StringBuffer sb = new StringBuffer();
						int start = (sum/(i/2) -1)/2 -(i/2-1);
					
						for(int j=0;j<i;j++){
							sb.append( start+j + " ");
						}
						return sb.toString().trim();
				
				}
			}else{
				if(sum%i==0){
					StringBuffer sb = new StringBuffer();
					int start = sum/i -i/2;
					
					for(int j=0;j<i;j++){
						sb.append( start+j + " ");
					}
					return sb.toString().trim();
				
				}
			}
		}
		return result;
	}

}
