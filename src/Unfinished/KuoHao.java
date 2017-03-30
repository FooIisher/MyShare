package Unfinished;

import java.util.Scanner;
import java.util.Stack;

public class KuoHao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] ins = sc.next().toCharArray();
			hander(ins); 
		}	
		sc.close();

	}

	private static void hander(char[] ins) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<ins.length;i++){
			if(ins[i]=='['){
				stack.add('[');
			}
			
			if(ins[i]==']'){
//				for(int j=stack.size();i>0;j--){
//					if()
//				}
			}
		}
		
	}

}
