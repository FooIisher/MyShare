package stack;


import java.util.Scanner;

public class StringCompression {

	/*
	 * 给定如下格式的字符串  abacacaacacaacaca  
	 * 压缩后为   ab3[a2[ca]]
	 * 实现本算法 利用堆栈的相关性质去实现
	 * 
	 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。
	 * 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。 
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
