package fish;

import java.util.Scanner;

/*
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 输入: 一个byte型的数字
 * 返回: 对应的二进制数字中1的最大连续数
 * 
 */

public class ChangeByte {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int input = sc.nextInt();
		String temp =  Integer.toBinaryString(input + 0x00);
	
		System.out.println(temp);
		int count=0;
		int num=0;
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)=='1')
				count++;
			else{
				count=0;
			}
			if(num<count){
				num=count;
			}
		}
		sc.close();
		System.out.println(num);

	}

}
