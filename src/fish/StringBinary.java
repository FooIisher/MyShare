package fish;

import java.util.Scanner;

public class StringBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
			handler(in);
		}
		sc.close();
	}

	private static void handler(String in) {
		if(in==null||("").equals(in)){
			return;
		}
		char[] ins = in.toCharArray();
		int sum =0;
		for(int i=0;i<ins.length;i++){
			int temp = ins[ins.length-1-i]-'a';
			sum = sum +  (int)Math.pow(26, i)  * temp;
		}
		System.out.println(sum);
	}

}
