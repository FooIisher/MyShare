package fish;

import java.util.Scanner;

/*
 * 
 * ��һ��Ӣ������Ե���Ϊ��λ�����ŷš����硰I am a boy���������ŷź�Ϊ��boy a am I��
         ���е���֮����һ���ո����������г���Ӣ����ĸ�⣬���ٰ��������ַ�

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
