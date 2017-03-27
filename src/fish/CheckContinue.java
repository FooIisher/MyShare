package fish;

import java.util.Scanner;

/*
 * 输入多个单词，查看这些单词是否可以连续排列，即前一个单词首字母和后一个单词尾字母一样
 * 
 */

public class CheckContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		System.out.println(check(input));
		sc.close();
	}
	
	public static int check(String[] str){
		for(int i=1;i<str.length;i++){
			if(str[i-1].charAt(str[i-1].length()-1)!=str[i].charAt(0))
				return -1;
		}
		
		return 1;
		
	}
}
