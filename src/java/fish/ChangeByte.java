package fish;

import java.util.Scanner;

/*
 * ����: ��һ��byte���ֶ�Ӧ�Ķ�����������1�����������������3�Ķ�����Ϊ00000011���������2��1
 * ����: һ��byte�͵�����
 * ����: ��Ӧ�Ķ�����������1�����������
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
