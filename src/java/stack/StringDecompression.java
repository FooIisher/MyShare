package stack;

import java.util.Scanner;
import java.util.Stack;

public class StringDecompression {
	
	/*
	 * �������¸�ʽ���ַ���  ab3[a2[ca]]
	 * ��ѹ��Ϊ abacacaacacaacaca  
	 * ʵ�ֱ��㷨 ���ö�ջ���������ȥʵ��
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
		//ʵ��˼·���ǽ��ַ���ͣѹ��ջ��֪��������һ��']' ��ʼ��ջ�����ݽ��г�ջ֪��������һ '[' 
		//���м�����ݾ���һ��[]������  ת��Ϊ��Ӧ���ݺ�  ��ѹ��ջ��  ����ִ�� �Ϳ��԰�[] ���������
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
