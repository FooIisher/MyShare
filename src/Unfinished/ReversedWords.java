package Unfinished;

import java.util.Scanner;

public class ReversedWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			handler(sc.nextLine());
		}
		sc.close();
	}

	private static void handler(String input) {
		String[] ins = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String in : ins){
			sb.append(change(in)+" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static String change(String string) {
		char[] ins = string.toCharArray();
		int i = 0,j=ins.length-1;
		char temp = ' ';
		while(i<j){
			temp = ins[i];
			ins[i] = ins[j];
			ins[j] = temp;
			i++;
			j--;
		}
		return new String(ins);
	}

}
