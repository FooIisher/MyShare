package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author fish
 *
 */

public class evalRPN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String[] ins = sc.nextLine().split(" ");
			System.out.println("result: "+evalRpn(ins));
		}
		sc.close();
	}
	
	private static int evalRpn(String[] tokens) {
		 Stack<String> stack = new Stack<String>();
		 for(String token:tokens){
			 if(token.equals("+")||token.equals("-")|token.equals("*")|token.equals("/")){
				 int first = 0;
				 int second = 0;
				 int i=0;
				 while(!stack.empty()&&i<2){
					 if(i==0){
						 second = Integer.parseInt(stack.pop()) ;
					 }else{
						 first = Integer.parseInt(stack.pop()) ;
					 }
					 i++;
				 }
				 
				 if(i==1){
					 stack.push(String.valueOf(second));
				 }
				 
				 if(i==2){
					 int result =0;
					 switch (token) {
					case "+":
						result = first + second;
						break;
					case "-":
						result = first - second;
						break;
					case "*":
						result = first * second;
						break;
					case "/":
						result = first / second;
						break;
					default:
						break;
					}
					 stack.push(String.valueOf(result));
				 }
	
			 }else{
				 stack.push(token);
			 }
		 }

	     return Integer.parseInt(stack.pop());   
	}

}
