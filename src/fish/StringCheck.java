package fish;

/*
 * д��һ�����򣬽���һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��
 * ���룺ABCDEF A
 * �����1
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
