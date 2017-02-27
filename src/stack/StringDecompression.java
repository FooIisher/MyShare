package stack;

import java.util.Scanner;
import java.util.Stack;

public class StringDecompression {
	
	/*
	 * 给定如下格式的字符串  ab3[a2[ca]]
	 * 解压后为 abacacaacacaacaca  
	 * 实现本算法 利用堆栈的相关性质去实现
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		while(sc.hasNext()){
			String in =sc.next();
			System.out.println("In  : "+in);
			System.out.println("Out : "+ getStringDecompressied(in));
		}
	}

	private static String getStringDecompressied(String ins) {
		
		if(ins==null){
			return ins;
		}
		
		Stack<Character> inStack = new Stack<Character>();
		//实现思路就是将字符不停压入栈中知道遇到第一个']' 开始将栈中内容进行出栈知道遇到第一 '[' 
		//这中间的内容就是一对[]中内容  转化为对应内容后  在压入栈中  反复执行 就可以把[] 都处理完成
		for(char in:ins.toCharArray()){
			if(in!=']'){
				inStack.push(in);
			}else{
				
				Stack<Character> temp = new Stack<Character>();
				char outTemp = inStack.pop();
				while(outTemp!='['){
					temp.push(outTemp);
					outTemp = inStack.pop();
				}
			
				int num =  Character.getNumericValue(inStack.pop()) ;
				StringBuilder sb = new StringBuilder();
				while(!temp.empty()){
					sb.append(temp.pop());
				}
				String tempStr =sb.toString();
				for(int i=1;i<num;i++){
					sb.append(tempStr);
				}
				
				char[] inTemps =sb.toString().toCharArray();
				for(char inTemp : inTemps){
					inStack.push(inTemp);
				}
			}
			
		}
		
		Stack<Character> outStack = new Stack<Character>();
		while(!inStack.empty()){
			outStack.push(inStack.pop());
		}
		
		StringBuilder outSb = new StringBuilder();
		while(!outStack.empty()){
			outSb.append(outStack.pop());
		}
		
		return outSb.toString();
	}

}
