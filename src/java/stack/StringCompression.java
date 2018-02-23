package stack;


import java.util.Scanner;

public class StringCompression {

	/*
	 * �������¸�ʽ���ַ���  abacacaacacaacaca  
	 * ѹ����Ϊ   ab3[a2[ca]]
	 * ʵ�ֱ��㷨 ���ö�ջ���������ȥʵ��
	 * 
	 * ����һ���ַ��������㽫�ַ������±��룬���������ַ��滻�ɡ��������ֵĸ���+�ַ�����
	 * �����ַ���AAAABCCDAA�ᱻ�����4A1B2C1D2A�� 
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String input = sc.nextLine();
			System.out.println(stringCompression(input)) ;
		}
		sc.close();
	}

	private static String stringCompression(String input) {
		if(input==null){
			return null;
		}
		StringBuilder result = new StringBuilder();
		char[] ins = input.toCharArray();
		char temp = ins[0];
		int num=1;
		for(int i=1;i<ins.length;i++){

			if(temp==ins[i]){
				num++;
				temp=ins[i];
			}else{
				
				result.append(num);
				result.append(temp);
				temp=ins[i];
				num=1;
			}
		}
		result.append(num);
		result.append(temp);
		
	
		return result.toString();
		
	}

}
