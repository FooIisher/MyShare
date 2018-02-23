package fish;

/*
 * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入：ABCDEF A
 * 输出：1
 * 
 */

import java.util.Scanner;

public class StringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char temp= sc.next().charAt(0);
		
		//char temp = str.charAt(str.length()-1);
		int num=0;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==temp)
				num++;
		}
		System.out.println(num);
	}

}
