package fish;

import java.util.Scanner;

/*
 * 
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
         所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

 * 
 */

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String temp[] = input.split(" ");
		
		for(int i=temp.length-1;i>=0;i--)
			System.out.print(temp[i]+" ");
	}

}
